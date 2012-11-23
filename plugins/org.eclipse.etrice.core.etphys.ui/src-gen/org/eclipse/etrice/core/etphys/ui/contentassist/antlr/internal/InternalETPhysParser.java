package org.eclipse.etrice.core.etphys.ui.contentassist.antlr.internal; 

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
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETPhysParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Thread'", "'+'", "'-'", "'model'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'execmode'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'['", "']'", "'import'", "'from'", "'.*'", "'.'", "'DefaultThread'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalETPhysParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETPhysParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETPhysParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g"; }


     
     	private ETPhysGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ETPhysGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:60:1: entryRulePhysicalModel : rulePhysicalModel EOF ;
    public final void entryRulePhysicalModel() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:61:1: ( rulePhysicalModel EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:62:1: rulePhysicalModel EOF
            {
             before(grammarAccess.getPhysicalModelRule()); 
            pushFollow(FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel61);
            rulePhysicalModel();

            state._fsp--;

             after(grammarAccess.getPhysicalModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalModel68); 

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
    // $ANTLR end "entryRulePhysicalModel"


    // $ANTLR start "rulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:69:1: rulePhysicalModel : ( ( rule__PhysicalModel__Group__0 ) ) ;
    public final void rulePhysicalModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:73:2: ( ( ( rule__PhysicalModel__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:74:1: ( ( rule__PhysicalModel__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:74:1: ( ( rule__PhysicalModel__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:75:1: ( rule__PhysicalModel__Group__0 )
            {
             before(grammarAccess.getPhysicalModelAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:76:1: ( rule__PhysicalModel__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:76:2: rule__PhysicalModel__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__0_in_rulePhysicalModel94);
            rule__PhysicalModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalModel"


    // $ANTLR start "entryRulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:88:1: entryRulePhysicalSystem : rulePhysicalSystem EOF ;
    public final void entryRulePhysicalSystem() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:89:1: ( rulePhysicalSystem EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:90:1: rulePhysicalSystem EOF
            {
             before(grammarAccess.getPhysicalSystemRule()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem121);
            rulePhysicalSystem();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalSystem128); 

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
    // $ANTLR end "entryRulePhysicalSystem"


    // $ANTLR start "rulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:97:1: rulePhysicalSystem : ( ( rule__PhysicalSystem__Group__0 ) ) ;
    public final void rulePhysicalSystem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:101:2: ( ( ( rule__PhysicalSystem__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:102:1: ( ( rule__PhysicalSystem__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:102:1: ( ( rule__PhysicalSystem__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:103:1: ( rule__PhysicalSystem__Group__0 )
            {
             before(grammarAccess.getPhysicalSystemAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:104:1: ( rule__PhysicalSystem__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:104:2: rule__PhysicalSystem__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__0_in_rulePhysicalSystem154);
            rule__PhysicalSystem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalSystemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalSystem"


    // $ANTLR start "entryRuleNodeRef"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:116:1: entryRuleNodeRef : ruleNodeRef EOF ;
    public final void entryRuleNodeRef() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:117:1: ( ruleNodeRef EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:118:1: ruleNodeRef EOF
            {
             before(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef181);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef188); 

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
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:125:1: ruleNodeRef : ( ( rule__NodeRef__Group__0 ) ) ;
    public final void ruleNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:129:2: ( ( ( rule__NodeRef__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:130:1: ( ( rule__NodeRef__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:130:1: ( ( rule__NodeRef__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:131:1: ( rule__NodeRef__Group__0 )
            {
             before(grammarAccess.getNodeRefAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:132:1: ( rule__NodeRef__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:132:2: rule__NodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef214);
            rule__NodeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRuleNodeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:144:1: entryRuleNodeClass : ruleNodeClass EOF ;
    public final void entryRuleNodeClass() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:145:1: ( ruleNodeClass EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:146:1: ruleNodeClass EOF
            {
             before(grammarAccess.getNodeClassRule()); 
            pushFollow(FOLLOW_ruleNodeClass_in_entryRuleNodeClass241);
            ruleNodeClass();

            state._fsp--;

             after(grammarAccess.getNodeClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeClass248); 

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
    // $ANTLR end "entryRuleNodeClass"


    // $ANTLR start "ruleNodeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:153:1: ruleNodeClass : ( ( rule__NodeClass__Group__0 ) ) ;
    public final void ruleNodeClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:157:2: ( ( ( rule__NodeClass__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:158:1: ( ( rule__NodeClass__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:158:1: ( ( rule__NodeClass__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:159:1: ( rule__NodeClass__Group__0 )
            {
             before(grammarAccess.getNodeClassAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:160:1: ( rule__NodeClass__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:160:2: rule__NodeClass__Group__0
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__0_in_ruleNodeClass274);
            rule__NodeClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeClass"


    // $ANTLR start "entryRulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:172:1: entryRulePhysicalThread : rulePhysicalThread EOF ;
    public final void entryRulePhysicalThread() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:173:1: ( rulePhysicalThread EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:174:1: rulePhysicalThread EOF
            {
             before(grammarAccess.getPhysicalThreadRule()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread301);
            rulePhysicalThread();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalThread308); 

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
    // $ANTLR end "entryRulePhysicalThread"


    // $ANTLR start "rulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:181:1: rulePhysicalThread : ( ( rule__PhysicalThread__Group__0 ) ) ;
    public final void rulePhysicalThread() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:185:2: ( ( ( rule__PhysicalThread__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:186:1: ( ( rule__PhysicalThread__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:186:1: ( ( rule__PhysicalThread__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:187:1: ( rule__PhysicalThread__Group__0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:188:1: ( rule__PhysicalThread__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:188:2: rule__PhysicalThread__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0_in_rulePhysicalThread334);
            rule__PhysicalThread__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalThread"


    // $ANTLR start "entryRuleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:200:1: entryRuleRuntimeClass : ruleRuntimeClass EOF ;
    public final void entryRuleRuntimeClass() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:201:1: ( ruleRuntimeClass EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:202:1: ruleRuntimeClass EOF
            {
             before(grammarAccess.getRuntimeClassRule()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass361);
            ruleRuntimeClass();

            state._fsp--;

             after(grammarAccess.getRuntimeClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuntimeClass368); 

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
    // $ANTLR end "entryRuleRuntimeClass"


    // $ANTLR start "ruleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:209:1: ruleRuntimeClass : ( ( rule__RuntimeClass__Group__0 ) ) ;
    public final void ruleRuntimeClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:213:2: ( ( ( rule__RuntimeClass__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:214:1: ( ( rule__RuntimeClass__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:214:1: ( ( rule__RuntimeClass__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:215:1: ( rule__RuntimeClass__Group__0 )
            {
             before(grammarAccess.getRuntimeClassAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:216:1: ( rule__RuntimeClass__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:216:2: rule__RuntimeClass__Group__0
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0_in_ruleRuntimeClass394);
            rule__RuntimeClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuntimeClass"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:228:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:229:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:230:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation421);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation428); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:237:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:241:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:242:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:242:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:243:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:244:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:244:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation454);
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


    // $ANTLR start "entryRulePRIO"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:256:1: entryRulePRIO : rulePRIO EOF ;
    public final void entryRulePRIO() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:260:1: ( rulePRIO EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:261:1: rulePRIO EOF
            {
             before(grammarAccess.getPRIORule()); 
            pushFollow(FOLLOW_rulePRIO_in_entryRulePRIO486);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPRIORule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePRIO493); 

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
    // $ANTLR end "entryRulePRIO"


    // $ANTLR start "rulePRIO"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:271:1: rulePRIO : ( ( rule__PRIO__Group__0 ) ) ;
    public final void rulePRIO() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:276:2: ( ( ( rule__PRIO__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:277:1: ( ( rule__PRIO__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:277:1: ( ( rule__PRIO__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:278:1: ( rule__PRIO__Group__0 )
            {
             before(grammarAccess.getPRIOAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:279:1: ( rule__PRIO__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:279:2: rule__PRIO__Group__0
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0_in_rulePRIO523);
            rule__PRIO__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPRIOAccess().getGroup()); 

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
    // $ANTLR end "rulePRIO"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:292:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:293:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:294:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport550);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport557); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:301:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:305:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:306:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:306:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:307:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:308:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:308:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport583);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:320:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:321:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:322:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN610);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN617); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:329:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:333:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:334:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:334:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:335:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:336:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:336:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN643);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:348:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:349:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:350:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN670);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN677); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:357:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:361:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:362:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:362:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:363:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:364:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:364:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN703);
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


    // $ANTLR start "ruleExecMode"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:377:1: ruleExecMode : ( ( rule__ExecMode__Alternatives ) ) ;
    public final void ruleExecMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:381:1: ( ( ( rule__ExecMode__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:382:1: ( ( rule__ExecMode__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:382:1: ( ( rule__ExecMode__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:383:1: ( rule__ExecMode__Alternatives )
            {
             before(grammarAccess.getExecModeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:384:1: ( rule__ExecMode__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:384:2: rule__ExecMode__Alternatives
            {
            pushFollow(FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode740);
            rule__ExecMode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExecModeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExecMode"


    // $ANTLR start "ruleThreadModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:396:1: ruleThreadModel : ( ( rule__ThreadModel__Alternatives ) ) ;
    public final void ruleThreadModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:400:1: ( ( ( rule__ThreadModel__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:401:1: ( ( rule__ThreadModel__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:401:1: ( ( rule__ThreadModel__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:402:1: ( rule__ThreadModel__Alternatives )
            {
             before(grammarAccess.getThreadModelAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:403:1: ( rule__ThreadModel__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:403:2: rule__ThreadModel__Alternatives
            {
            pushFollow(FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel776);
            rule__ThreadModel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getThreadModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThreadModel"


    // $ANTLR start "rule__PhysicalModel__Alternatives_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:414:1: rule__PhysicalModel__Alternatives_4 : ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) );
    public final void rule__PhysicalModel__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:418:1: ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 36:
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:419:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:419:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:420:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:421:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:421:2: rule__PhysicalModel__SystemsAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_4811);
                    rule__PhysicalModel__SystemsAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:425:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:425:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:426:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:427:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:427:2: rule__PhysicalModel__NodeClassesAssignment_4_1
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_4829);
                    rule__PhysicalModel__NodeClassesAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:431:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:431:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:432:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:433:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:433:2: rule__PhysicalModel__RuntimeClassesAssignment_4_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_4847);
                    rule__PhysicalModel__RuntimeClassesAssignment_4_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2()); 

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
    // $ANTLR end "rule__PhysicalModel__Alternatives_4"


    // $ANTLR start "rule__PhysicalThread__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:442:1: rule__PhysicalThread__Alternatives_0 : ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) );
    public final void rule__PhysicalThread__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:446:1: ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==43) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:447:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:447:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:448:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:449:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:449:2: rule__PhysicalThread__DefaultAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_0880);
                    rule__PhysicalThread__DefaultAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:453:6: ( 'Thread' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:453:6: ( 'Thread' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:454:1: 'Thread'
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1()); 
                    match(input,11,FOLLOW_11_in_rule__PhysicalThread__Alternatives_0899); 
                     after(grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1()); 

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
    // $ANTLR end "rule__PhysicalThread__Alternatives_0"


    // $ANTLR start "rule__PRIO__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:466:1: rule__PRIO__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__PRIO__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:470:1: ( ( '+' ) | ( '-' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:471:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:471:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:472:1: '+'
                    {
                     before(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__PRIO__Alternatives_0934); 
                     after(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:479:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:479:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:480:1: '-'
                    {
                     before(grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__PRIO__Alternatives_0954); 
                     after(grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 

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
    // $ANTLR end "rule__PRIO__Alternatives_0"


    // $ANTLR start "rule__Import__Alternatives_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:492:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:496:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:497:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:497:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:498:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:499:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:499:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1988);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:503:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:503:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:504:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Import__Alternatives_11007); 
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


    // $ANTLR start "rule__ExecMode__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:516:1: rule__ExecMode__Alternatives : ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) );
    public final void rule__ExecMode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:520:1: ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 16:
                {
                alt5=2;
                }
                break;
            case 17:
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:521:1: ( ( 'polled' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:521:1: ( ( 'polled' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:522:1: ( 'polled' )
                    {
                     before(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:523:1: ( 'polled' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:523:3: 'polled'
                    {
                    match(input,15,FOLLOW_15_in_rule__ExecMode__Alternatives1042); 

                    }

                     after(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:528:6: ( ( 'blocked' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:528:6: ( ( 'blocked' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:529:1: ( 'blocked' )
                    {
                     before(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:530:1: ( 'blocked' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:530:3: 'blocked'
                    {
                    match(input,16,FOLLOW_16_in_rule__ExecMode__Alternatives1063); 

                    }

                     after(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:535:6: ( ( 'mixed' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:535:6: ( ( 'mixed' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:536:1: ( 'mixed' )
                    {
                     before(grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:537:1: ( 'mixed' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:537:3: 'mixed'
                    {
                    match(input,17,FOLLOW_17_in_rule__ExecMode__Alternatives1084); 

                    }

                     after(grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__ExecMode__Alternatives"


    // $ANTLR start "rule__ThreadModel__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:547:1: rule__ThreadModel__Alternatives : ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) );
    public final void rule__ThreadModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:551:1: ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==19) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:552:1: ( ( 'singleThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:552:1: ( ( 'singleThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:553:1: ( 'singleThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:554:1: ( 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:554:3: 'singleThreaded'
                    {
                    match(input,18,FOLLOW_18_in_rule__ThreadModel__Alternatives1120); 

                    }

                     after(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:559:6: ( ( 'multiThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:559:6: ( ( 'multiThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:560:1: ( 'multiThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:561:1: ( 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:561:3: 'multiThreaded'
                    {
                    match(input,19,FOLLOW_19_in_rule__ThreadModel__Alternatives1141); 

                    }

                     after(grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__ThreadModel__Alternatives"


    // $ANTLR start "rule__PhysicalModel__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:573:1: rule__PhysicalModel__Group__0 : rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 ;
    public final void rule__PhysicalModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:577:1: ( rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:578:2: rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__01174);
            rule__PhysicalModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__01177);
            rule__PhysicalModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__0"


    // $ANTLR start "rule__PhysicalModel__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:585:1: rule__PhysicalModel__Group__0__Impl : ( 'PhysicalModel' ) ;
    public final void rule__PhysicalModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:589:1: ( ( 'PhysicalModel' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:590:1: ( 'PhysicalModel' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:590:1: ( 'PhysicalModel' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:591:1: 'PhysicalModel'
            {
             before(grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__PhysicalModel__Group__0__Impl1205); 
             after(grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__0__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:604:1: rule__PhysicalModel__Group__1 : rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 ;
    public final void rule__PhysicalModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:608:1: ( rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:609:2: rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__11236);
            rule__PhysicalModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__11239);
            rule__PhysicalModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__1"


    // $ANTLR start "rule__PhysicalModel__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:616:1: rule__PhysicalModel__Group__1__Impl : ( ( rule__PhysicalModel__NameAssignment_1 ) ) ;
    public final void rule__PhysicalModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:620:1: ( ( ( rule__PhysicalModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:621:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:621:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:622:1: ( rule__PhysicalModel__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:623:1: ( rule__PhysicalModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:623:2: rule__PhysicalModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl1266);
            rule__PhysicalModel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__1__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:633:1: rule__PhysicalModel__Group__2 : rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 ;
    public final void rule__PhysicalModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:637:1: ( rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:638:2: rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__21296);
            rule__PhysicalModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__21299);
            rule__PhysicalModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__2"


    // $ANTLR start "rule__PhysicalModel__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:645:1: rule__PhysicalModel__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:649:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:650:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:650:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:651:1: '{'
            {
             before(grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalModel__Group__2__Impl1327); 
             after(grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__2__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:664:1: rule__PhysicalModel__Group__3 : rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 ;
    public final void rule__PhysicalModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:668:1: ( rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:669:2: rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__31358);
            rule__PhysicalModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__31361);
            rule__PhysicalModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__3"


    // $ANTLR start "rule__PhysicalModel__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:676:1: rule__PhysicalModel__Group__3__Impl : ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) ;
    public final void rule__PhysicalModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:680:1: ( ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:681:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:681:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:682:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:683:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==39) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:683:2: rule__PhysicalModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl1388);
            	    rule__PhysicalModel__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__3__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:693:1: rule__PhysicalModel__Group__4 : rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 ;
    public final void rule__PhysicalModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:697:1: ( rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:698:2: rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__41419);
            rule__PhysicalModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__41422);
            rule__PhysicalModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__4"


    // $ANTLR start "rule__PhysicalModel__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:705:1: rule__PhysicalModel__Group__4__Impl : ( ( rule__PhysicalModel__Alternatives_4 )* ) ;
    public final void rule__PhysicalModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:709:1: ( ( ( rule__PhysicalModel__Alternatives_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:710:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:710:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:711:1: ( rule__PhysicalModel__Alternatives_4 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getAlternatives_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:712:1: ( rule__PhysicalModel__Alternatives_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23||LA8_0==26||LA8_0==36) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:712:2: rule__PhysicalModel__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl1449);
            	    rule__PhysicalModel__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getPhysicalModelAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__4__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:722:1: rule__PhysicalModel__Group__5 : rule__PhysicalModel__Group__5__Impl ;
    public final void rule__PhysicalModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:726:1: ( rule__PhysicalModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:727:2: rule__PhysicalModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__51480);
            rule__PhysicalModel__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__5"


    // $ANTLR start "rule__PhysicalModel__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:733:1: rule__PhysicalModel__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:737:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:738:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:738:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:739:1: '}'
            {
             before(grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalModel__Group__5__Impl1508); 
             after(grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__5__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:764:1: rule__PhysicalSystem__Group__0 : rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 ;
    public final void rule__PhysicalSystem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:768:1: ( rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:769:2: rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__01551);
            rule__PhysicalSystem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__01554);
            rule__PhysicalSystem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__0"


    // $ANTLR start "rule__PhysicalSystem__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:776:1: rule__PhysicalSystem__Group__0__Impl : ( 'PhysicalSystem' ) ;
    public final void rule__PhysicalSystem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:780:1: ( ( 'PhysicalSystem' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:781:1: ( 'PhysicalSystem' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:781:1: ( 'PhysicalSystem' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:782:1: 'PhysicalSystem'
            {
             before(grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__PhysicalSystem__Group__0__Impl1582); 
             after(grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__0__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:795:1: rule__PhysicalSystem__Group__1 : rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 ;
    public final void rule__PhysicalSystem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:799:1: ( rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:800:2: rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__11613);
            rule__PhysicalSystem__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__11616);
            rule__PhysicalSystem__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__1"


    // $ANTLR start "rule__PhysicalSystem__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:807:1: rule__PhysicalSystem__Group__1__Impl : ( ( rule__PhysicalSystem__NameAssignment_1 ) ) ;
    public final void rule__PhysicalSystem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:811:1: ( ( ( rule__PhysicalSystem__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:812:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:812:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:813:1: ( rule__PhysicalSystem__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:814:1: ( rule__PhysicalSystem__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:814:2: rule__PhysicalSystem__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl1643);
            rule__PhysicalSystem__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__1__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:824:1: rule__PhysicalSystem__Group__2 : rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 ;
    public final void rule__PhysicalSystem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:828:1: ( rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:829:2: rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__21673);
            rule__PhysicalSystem__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__21676);
            rule__PhysicalSystem__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__2"


    // $ANTLR start "rule__PhysicalSystem__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:836:1: rule__PhysicalSystem__Group__2__Impl : ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) ;
    public final void rule__PhysicalSystem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:840:1: ( ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:841:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:841:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:842:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:843:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==37) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:843:2: rule__PhysicalSystem__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl1703);
                    rule__PhysicalSystem__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__2__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:853:1: rule__PhysicalSystem__Group__3 : rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 ;
    public final void rule__PhysicalSystem__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:857:1: ( rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:858:2: rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__31734);
            rule__PhysicalSystem__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__31737);
            rule__PhysicalSystem__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__3"


    // $ANTLR start "rule__PhysicalSystem__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:865:1: rule__PhysicalSystem__Group__3__Impl : ( '{' ) ;
    public final void rule__PhysicalSystem__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:869:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:870:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:870:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:871:1: '{'
            {
             before(grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalSystem__Group__3__Impl1765); 
             after(grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__3__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:884:1: rule__PhysicalSystem__Group__4 : rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 ;
    public final void rule__PhysicalSystem__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:888:1: ( rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:889:2: rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__41796);
            rule__PhysicalSystem__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__41799);
            rule__PhysicalSystem__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__4"


    // $ANTLR start "rule__PhysicalSystem__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:896:1: rule__PhysicalSystem__Group__4__Impl : ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) ;
    public final void rule__PhysicalSystem__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:900:1: ( ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:901:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:901:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:902:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:2: rule__PhysicalSystem__NodeRefsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl1826);
            	    rule__PhysicalSystem__NodeRefsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__4__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:913:1: rule__PhysicalSystem__Group__5 : rule__PhysicalSystem__Group__5__Impl ;
    public final void rule__PhysicalSystem__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:917:1: ( rule__PhysicalSystem__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:918:2: rule__PhysicalSystem__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__51857);
            rule__PhysicalSystem__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__5"


    // $ANTLR start "rule__PhysicalSystem__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:924:1: rule__PhysicalSystem__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalSystem__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:928:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:929:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:929:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:930:1: '}'
            {
             before(grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalSystem__Group__5__Impl1885); 
             after(grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__5__Impl"


    // $ANTLR start "rule__NodeRef__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:955:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:959:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:960:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__01928);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__01931);
            rule__NodeRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__0"


    // $ANTLR start "rule__NodeRef__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:967:1: rule__NodeRef__Group__0__Impl : ( 'NodeRef' ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:971:1: ( ( 'NodeRef' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:972:1: ( 'NodeRef' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:972:1: ( 'NodeRef' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:973:1: 'NodeRef'
            {
             before(grammarAccess.getNodeRefAccess().getNodeRefKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__NodeRef__Group__0__Impl1959); 
             after(grammarAccess.getNodeRefAccess().getNodeRefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__0__Impl"


    // $ANTLR start "rule__NodeRef__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:986:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:990:1: ( rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:991:2: rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__11990);
            rule__NodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__11993);
            rule__NodeRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__1"


    // $ANTLR start "rule__NodeRef__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:998:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__NameAssignment_1 ) ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1002:1: ( ( ( rule__NodeRef__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1003:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1003:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1004:1: ( rule__NodeRef__NameAssignment_1 )
            {
             before(grammarAccess.getNodeRefAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1005:1: ( rule__NodeRef__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1005:2: rule__NodeRef__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl2020);
            rule__NodeRef__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__1__Impl"


    // $ANTLR start "rule__NodeRef__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1015:1: rule__NodeRef__Group__2 : rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 ;
    public final void rule__NodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1019:1: ( rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1020:2: rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__22050);
            rule__NodeRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__22053);
            rule__NodeRef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__2"


    // $ANTLR start "rule__NodeRef__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1027:1: rule__NodeRef__Group__2__Impl : ( ':' ) ;
    public final void rule__NodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1031:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1032:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1032:1: ( ':' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1033:1: ':'
            {
             before(grammarAccess.getNodeRefAccess().getColonKeyword_2()); 
            match(input,25,FOLLOW_25_in_rule__NodeRef__Group__2__Impl2081); 
             after(grammarAccess.getNodeRefAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__2__Impl"


    // $ANTLR start "rule__NodeRef__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1046:1: rule__NodeRef__Group__3 : rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 ;
    public final void rule__NodeRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1050:1: ( rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1051:2: rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__32112);
            rule__NodeRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__32115);
            rule__NodeRef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__3"


    // $ANTLR start "rule__NodeRef__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1058:1: rule__NodeRef__Group__3__Impl : ( ( rule__NodeRef__TypeAssignment_3 ) ) ;
    public final void rule__NodeRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1062:1: ( ( ( rule__NodeRef__TypeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1063:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1063:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1064:1: ( rule__NodeRef__TypeAssignment_3 )
            {
             before(grammarAccess.getNodeRefAccess().getTypeAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1065:1: ( rule__NodeRef__TypeAssignment_3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1065:2: rule__NodeRef__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl2142);
            rule__NodeRef__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__3__Impl"


    // $ANTLR start "rule__NodeRef__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1075:1: rule__NodeRef__Group__4 : rule__NodeRef__Group__4__Impl ;
    public final void rule__NodeRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1079:1: ( rule__NodeRef__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1080:2: rule__NodeRef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__42172);
            rule__NodeRef__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__4"


    // $ANTLR start "rule__NodeRef__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1086:1: rule__NodeRef__Group__4__Impl : ( ( rule__NodeRef__DocuAssignment_4 )? ) ;
    public final void rule__NodeRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1090:1: ( ( ( rule__NodeRef__DocuAssignment_4 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1091:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1091:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1092:1: ( rule__NodeRef__DocuAssignment_4 )?
            {
             before(grammarAccess.getNodeRefAccess().getDocuAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1093:1: ( rule__NodeRef__DocuAssignment_4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1093:2: rule__NodeRef__DocuAssignment_4
                    {
                    pushFollow(FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl2199);
                    rule__NodeRef__DocuAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeRefAccess().getDocuAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__4__Impl"


    // $ANTLR start "rule__NodeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1113:1: rule__NodeClass__Group__0 : rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 ;
    public final void rule__NodeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1117:1: ( rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1118:2: rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__02240);
            rule__NodeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__02243);
            rule__NodeClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__0"


    // $ANTLR start "rule__NodeClass__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1125:1: rule__NodeClass__Group__0__Impl : ( 'NodeClass' ) ;
    public final void rule__NodeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1129:1: ( ( 'NodeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1130:1: ( 'NodeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1130:1: ( 'NodeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1131:1: 'NodeClass'
            {
             before(grammarAccess.getNodeClassAccess().getNodeClassKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__NodeClass__Group__0__Impl2271); 
             after(grammarAccess.getNodeClassAccess().getNodeClassKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__0__Impl"


    // $ANTLR start "rule__NodeClass__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1144:1: rule__NodeClass__Group__1 : rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 ;
    public final void rule__NodeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1148:1: ( rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1149:2: rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__12302);
            rule__NodeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__12305);
            rule__NodeClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__1"


    // $ANTLR start "rule__NodeClass__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1156:1: rule__NodeClass__Group__1__Impl : ( ( rule__NodeClass__NameAssignment_1 ) ) ;
    public final void rule__NodeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1160:1: ( ( ( rule__NodeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1161:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1161:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1162:1: ( rule__NodeClass__NameAssignment_1 )
            {
             before(grammarAccess.getNodeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1163:1: ( rule__NodeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1163:2: rule__NodeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl2332);
            rule__NodeClass__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__1__Impl"


    // $ANTLR start "rule__NodeClass__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1173:1: rule__NodeClass__Group__2 : rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 ;
    public final void rule__NodeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1177:1: ( rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1178:2: rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__22362);
            rule__NodeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__22365);
            rule__NodeClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__2"


    // $ANTLR start "rule__NodeClass__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1185:1: rule__NodeClass__Group__2__Impl : ( ( rule__NodeClass__DocuAssignment_2 )? ) ;
    public final void rule__NodeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1189:1: ( ( ( rule__NodeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1190:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1190:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1191:1: ( rule__NodeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getNodeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1192:1: ( rule__NodeClass__DocuAssignment_2 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==37) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1192:2: rule__NodeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl2392);
                    rule__NodeClass__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeClassAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__2__Impl"


    // $ANTLR start "rule__NodeClass__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1202:1: rule__NodeClass__Group__3 : rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 ;
    public final void rule__NodeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1206:1: ( rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1207:2: rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__32423);
            rule__NodeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__32426);
            rule__NodeClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__3"


    // $ANTLR start "rule__NodeClass__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1214:1: rule__NodeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__NodeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1218:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1219:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1219:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1220:1: '{'
            {
             before(grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__NodeClass__Group__3__Impl2454); 
             after(grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__3__Impl"


    // $ANTLR start "rule__NodeClass__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1233:1: rule__NodeClass__Group__4 : rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 ;
    public final void rule__NodeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1237:1: ( rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1238:2: rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__42485);
            rule__NodeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__42488);
            rule__NodeClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__4"


    // $ANTLR start "rule__NodeClass__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1245:1: rule__NodeClass__Group__4__Impl : ( 'runtime' ) ;
    public final void rule__NodeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1249:1: ( ( 'runtime' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1250:1: ( 'runtime' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1250:1: ( 'runtime' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1251:1: 'runtime'
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__NodeClass__Group__4__Impl2516); 
             after(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__4__Impl"


    // $ANTLR start "rule__NodeClass__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1264:1: rule__NodeClass__Group__5 : rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 ;
    public final void rule__NodeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1268:1: ( rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1269:2: rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52547);
            rule__NodeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52550);
            rule__NodeClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__5"


    // $ANTLR start "rule__NodeClass__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1276:1: rule__NodeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1280:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1281:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1281:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1282:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__5__Impl2578); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__5__Impl"


    // $ANTLR start "rule__NodeClass__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1295:1: rule__NodeClass__Group__6 : rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7 ;
    public final void rule__NodeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1299:1: ( rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1300:2: rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62609);
            rule__NodeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__7_in_rule__NodeClass__Group__62612);
            rule__NodeClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__6"


    // $ANTLR start "rule__NodeClass__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1307:1: rule__NodeClass__Group__6__Impl : ( ( rule__NodeClass__RuntimeAssignment_6 ) ) ;
    public final void rule__NodeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1311:1: ( ( ( rule__NodeClass__RuntimeAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( ( rule__NodeClass__RuntimeAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( ( rule__NodeClass__RuntimeAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1313:1: ( rule__NodeClass__RuntimeAssignment_6 )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1314:1: ( rule__NodeClass__RuntimeAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1314:2: rule__NodeClass__RuntimeAssignment_6
            {
            pushFollow(FOLLOW_rule__NodeClass__RuntimeAssignment_6_in_rule__NodeClass__Group__6__Impl2639);
            rule__NodeClass__RuntimeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getRuntimeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__6__Impl"


    // $ANTLR start "rule__NodeClass__Group__7"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1324:1: rule__NodeClass__Group__7 : rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8 ;
    public final void rule__NodeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1328:1: ( rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1329:2: rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__7__Impl_in_rule__NodeClass__Group__72669);
            rule__NodeClass__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__8_in_rule__NodeClass__Group__72672);
            rule__NodeClass__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__7"


    // $ANTLR start "rule__NodeClass__Group__7__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1336:1: rule__NodeClass__Group__7__Impl : ( 'priomin' ) ;
    public final void rule__NodeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1340:1: ( ( 'priomin' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1341:1: ( 'priomin' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1341:1: ( 'priomin' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1342:1: 'priomin'
            {
             before(grammarAccess.getNodeClassAccess().getPriominKeyword_7()); 
            match(input,29,FOLLOW_29_in_rule__NodeClass__Group__7__Impl2700); 
             after(grammarAccess.getNodeClassAccess().getPriominKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__7__Impl"


    // $ANTLR start "rule__NodeClass__Group__8"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1355:1: rule__NodeClass__Group__8 : rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9 ;
    public final void rule__NodeClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1359:1: ( rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1360:2: rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__8__Impl_in_rule__NodeClass__Group__82731);
            rule__NodeClass__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__9_in_rule__NodeClass__Group__82734);
            rule__NodeClass__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__8"


    // $ANTLR start "rule__NodeClass__Group__8__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1367:1: rule__NodeClass__Group__8__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1371:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1372:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1372:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1373:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_8()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__8__Impl2762); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__8__Impl"


    // $ANTLR start "rule__NodeClass__Group__9"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1386:1: rule__NodeClass__Group__9 : rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10 ;
    public final void rule__NodeClass__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1390:1: ( rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1391:2: rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__9__Impl_in_rule__NodeClass__Group__92793);
            rule__NodeClass__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__10_in_rule__NodeClass__Group__92796);
            rule__NodeClass__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__9"


    // $ANTLR start "rule__NodeClass__Group__9__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1398:1: rule__NodeClass__Group__9__Impl : ( ( rule__NodeClass__PriominAssignment_9 ) ) ;
    public final void rule__NodeClass__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1402:1: ( ( ( rule__NodeClass__PriominAssignment_9 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1403:1: ( ( rule__NodeClass__PriominAssignment_9 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1403:1: ( ( rule__NodeClass__PriominAssignment_9 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1404:1: ( rule__NodeClass__PriominAssignment_9 )
            {
             before(grammarAccess.getNodeClassAccess().getPriominAssignment_9()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1405:1: ( rule__NodeClass__PriominAssignment_9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1405:2: rule__NodeClass__PriominAssignment_9
            {
            pushFollow(FOLLOW_rule__NodeClass__PriominAssignment_9_in_rule__NodeClass__Group__9__Impl2823);
            rule__NodeClass__PriominAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriominAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__9__Impl"


    // $ANTLR start "rule__NodeClass__Group__10"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1415:1: rule__NodeClass__Group__10 : rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11 ;
    public final void rule__NodeClass__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1419:1: ( rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1420:2: rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__10__Impl_in_rule__NodeClass__Group__102853);
            rule__NodeClass__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__11_in_rule__NodeClass__Group__102856);
            rule__NodeClass__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__10"


    // $ANTLR start "rule__NodeClass__Group__10__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1427:1: rule__NodeClass__Group__10__Impl : ( 'priomax' ) ;
    public final void rule__NodeClass__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1431:1: ( ( 'priomax' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1432:1: ( 'priomax' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1432:1: ( 'priomax' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1433:1: 'priomax'
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxKeyword_10()); 
            match(input,30,FOLLOW_30_in_rule__NodeClass__Group__10__Impl2884); 
             after(grammarAccess.getNodeClassAccess().getPriomaxKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__10__Impl"


    // $ANTLR start "rule__NodeClass__Group__11"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1446:1: rule__NodeClass__Group__11 : rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12 ;
    public final void rule__NodeClass__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1450:1: ( rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1451:2: rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__11__Impl_in_rule__NodeClass__Group__112915);
            rule__NodeClass__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__12_in_rule__NodeClass__Group__112918);
            rule__NodeClass__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__11"


    // $ANTLR start "rule__NodeClass__Group__11__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1458:1: rule__NodeClass__Group__11__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1462:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1463:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1463:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1464:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_11()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__11__Impl2946); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__11__Impl"


    // $ANTLR start "rule__NodeClass__Group__12"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1477:1: rule__NodeClass__Group__12 : rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13 ;
    public final void rule__NodeClass__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1481:1: ( rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1482:2: rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__12__Impl_in_rule__NodeClass__Group__122977);
            rule__NodeClass__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__13_in_rule__NodeClass__Group__122980);
            rule__NodeClass__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__12"


    // $ANTLR start "rule__NodeClass__Group__12__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1489:1: rule__NodeClass__Group__12__Impl : ( ( rule__NodeClass__PriomaxAssignment_12 ) ) ;
    public final void rule__NodeClass__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1493:1: ( ( ( rule__NodeClass__PriomaxAssignment_12 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1494:1: ( ( rule__NodeClass__PriomaxAssignment_12 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1494:1: ( ( rule__NodeClass__PriomaxAssignment_12 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1495:1: ( rule__NodeClass__PriomaxAssignment_12 )
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxAssignment_12()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1496:1: ( rule__NodeClass__PriomaxAssignment_12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1496:2: rule__NodeClass__PriomaxAssignment_12
            {
            pushFollow(FOLLOW_rule__NodeClass__PriomaxAssignment_12_in_rule__NodeClass__Group__12__Impl3007);
            rule__NodeClass__PriomaxAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriomaxAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__12__Impl"


    // $ANTLR start "rule__NodeClass__Group__13"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1506:1: rule__NodeClass__Group__13 : rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14 ;
    public final void rule__NodeClass__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1510:1: ( rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1511:2: rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__13__Impl_in_rule__NodeClass__Group__133037);
            rule__NodeClass__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__14_in_rule__NodeClass__Group__133040);
            rule__NodeClass__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__13"


    // $ANTLR start "rule__NodeClass__Group__13__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1518:1: rule__NodeClass__Group__13__Impl : ( ( rule__NodeClass__ThreadsAssignment_13 )* ) ;
    public final void rule__NodeClass__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1522:1: ( ( ( rule__NodeClass__ThreadsAssignment_13 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1523:1: ( ( rule__NodeClass__ThreadsAssignment_13 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1523:1: ( ( rule__NodeClass__ThreadsAssignment_13 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1524:1: ( rule__NodeClass__ThreadsAssignment_13 )*
            {
             before(grammarAccess.getNodeClassAccess().getThreadsAssignment_13()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1525:1: ( rule__NodeClass__ThreadsAssignment_13 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==11||LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1525:2: rule__NodeClass__ThreadsAssignment_13
            	    {
            	    pushFollow(FOLLOW_rule__NodeClass__ThreadsAssignment_13_in_rule__NodeClass__Group__13__Impl3067);
            	    rule__NodeClass__ThreadsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getNodeClassAccess().getThreadsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__13__Impl"


    // $ANTLR start "rule__NodeClass__Group__14"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1535:1: rule__NodeClass__Group__14 : rule__NodeClass__Group__14__Impl ;
    public final void rule__NodeClass__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1539:1: ( rule__NodeClass__Group__14__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1540:2: rule__NodeClass__Group__14__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__14__Impl_in_rule__NodeClass__Group__143098);
            rule__NodeClass__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__14"


    // $ANTLR start "rule__NodeClass__Group__14__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1546:1: rule__NodeClass__Group__14__Impl : ( '}' ) ;
    public final void rule__NodeClass__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1550:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1551:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1551:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1552:1: '}'
            {
             before(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_14()); 
            match(input,22,FOLLOW_22_in_rule__NodeClass__Group__14__Impl3126); 
             after(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__14__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1595:1: rule__PhysicalThread__Group__0 : rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 ;
    public final void rule__PhysicalThread__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1599:1: ( rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1600:2: rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03187);
            rule__PhysicalThread__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03190);
            rule__PhysicalThread__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__0"


    // $ANTLR start "rule__PhysicalThread__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1607:1: rule__PhysicalThread__Group__0__Impl : ( ( rule__PhysicalThread__Alternatives_0 ) ) ;
    public final void rule__PhysicalThread__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1611:1: ( ( ( rule__PhysicalThread__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1612:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1612:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1613:1: ( rule__PhysicalThread__Alternatives_0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1614:1: ( rule__PhysicalThread__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1614:2: rule__PhysicalThread__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3217);
            rule__PhysicalThread__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1624:1: rule__PhysicalThread__Group__1 : rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 ;
    public final void rule__PhysicalThread__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1628:1: ( rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1629:2: rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13247);
            rule__PhysicalThread__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13250);
            rule__PhysicalThread__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__1"


    // $ANTLR start "rule__PhysicalThread__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1636:1: rule__PhysicalThread__Group__1__Impl : ( ( rule__PhysicalThread__NameAssignment_1 ) ) ;
    public final void rule__PhysicalThread__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1640:1: ( ( ( rule__PhysicalThread__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1641:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1641:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1642:1: ( rule__PhysicalThread__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1643:1: ( rule__PhysicalThread__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1643:2: rule__PhysicalThread__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3277);
            rule__PhysicalThread__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1653:1: rule__PhysicalThread__Group__2 : rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 ;
    public final void rule__PhysicalThread__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1657:1: ( rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1658:2: rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23307);
            rule__PhysicalThread__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23310);
            rule__PhysicalThread__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__2"


    // $ANTLR start "rule__PhysicalThread__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1665:1: rule__PhysicalThread__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalThread__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1669:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1670:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1670:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1671:1: '{'
            {
             before(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3338); 
             after(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1684:1: rule__PhysicalThread__Group__3 : rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 ;
    public final void rule__PhysicalThread__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1688:1: ( rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1689:2: rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33369);
            rule__PhysicalThread__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33372);
            rule__PhysicalThread__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__3"


    // $ANTLR start "rule__PhysicalThread__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1696:1: rule__PhysicalThread__Group__3__Impl : ( 'execmode' ) ;
    public final void rule__PhysicalThread__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1700:1: ( ( 'execmode' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1701:1: ( 'execmode' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1701:1: ( 'execmode' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1702:1: 'execmode'
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__PhysicalThread__Group__3__Impl3400); 
             after(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__3__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1715:1: rule__PhysicalThread__Group__4 : rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5 ;
    public final void rule__PhysicalThread__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1719:1: ( rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1720:2: rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43431);
            rule__PhysicalThread__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__5_in_rule__PhysicalThread__Group__43434);
            rule__PhysicalThread__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__4"


    // $ANTLR start "rule__PhysicalThread__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1727:1: rule__PhysicalThread__Group__4__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1731:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1732:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1732:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1733:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__4__Impl3462); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__4__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1746:1: rule__PhysicalThread__Group__5 : rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6 ;
    public final void rule__PhysicalThread__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1750:1: ( rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1751:2: rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__5__Impl_in_rule__PhysicalThread__Group__53493);
            rule__PhysicalThread__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__6_in_rule__PhysicalThread__Group__53496);
            rule__PhysicalThread__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__5"


    // $ANTLR start "rule__PhysicalThread__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1758:1: rule__PhysicalThread__Group__5__Impl : ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) ) ;
    public final void rule__PhysicalThread__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1762:1: ( ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1763:1: ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1763:1: ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1764:1: ( rule__PhysicalThread__ExecmodeAssignment_5 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_5()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1765:1: ( rule__PhysicalThread__ExecmodeAssignment_5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1765:2: rule__PhysicalThread__ExecmodeAssignment_5
            {
            pushFollow(FOLLOW_rule__PhysicalThread__ExecmodeAssignment_5_in_rule__PhysicalThread__Group__5__Impl3523);
            rule__PhysicalThread__ExecmodeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__5__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1775:1: rule__PhysicalThread__Group__6 : rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7 ;
    public final void rule__PhysicalThread__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1779:1: ( rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1780:2: rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__6__Impl_in_rule__PhysicalThread__Group__63553);
            rule__PhysicalThread__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__7_in_rule__PhysicalThread__Group__63556);
            rule__PhysicalThread__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__6"


    // $ANTLR start "rule__PhysicalThread__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1787:1: rule__PhysicalThread__Group__6__Impl : ( 'prio' ) ;
    public final void rule__PhysicalThread__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1791:1: ( ( 'prio' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1792:1: ( 'prio' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1792:1: ( 'prio' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1793:1: 'prio'
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_6()); 
            match(input,32,FOLLOW_32_in_rule__PhysicalThread__Group__6__Impl3584); 
             after(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__6__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__7"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1806:1: rule__PhysicalThread__Group__7 : rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8 ;
    public final void rule__PhysicalThread__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1810:1: ( rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1811:2: rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__7__Impl_in_rule__PhysicalThread__Group__73615);
            rule__PhysicalThread__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__8_in_rule__PhysicalThread__Group__73618);
            rule__PhysicalThread__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__7"


    // $ANTLR start "rule__PhysicalThread__Group__7__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1818:1: rule__PhysicalThread__Group__7__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1822:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1823:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1823:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1824:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_7()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__7__Impl3646); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__7__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__8"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1837:1: rule__PhysicalThread__Group__8 : rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9 ;
    public final void rule__PhysicalThread__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1841:1: ( rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1842:2: rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__8__Impl_in_rule__PhysicalThread__Group__83677);
            rule__PhysicalThread__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__9_in_rule__PhysicalThread__Group__83680);
            rule__PhysicalThread__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__8"


    // $ANTLR start "rule__PhysicalThread__Group__8__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1849:1: rule__PhysicalThread__Group__8__Impl : ( ( rule__PhysicalThread__PrioAssignment_8 ) ) ;
    public final void rule__PhysicalThread__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1853:1: ( ( ( rule__PhysicalThread__PrioAssignment_8 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1854:1: ( ( rule__PhysicalThread__PrioAssignment_8 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1854:1: ( ( rule__PhysicalThread__PrioAssignment_8 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1855:1: ( rule__PhysicalThread__PrioAssignment_8 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_8()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1856:1: ( rule__PhysicalThread__PrioAssignment_8 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1856:2: rule__PhysicalThread__PrioAssignment_8
            {
            pushFollow(FOLLOW_rule__PhysicalThread__PrioAssignment_8_in_rule__PhysicalThread__Group__8__Impl3707);
            rule__PhysicalThread__PrioAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__8__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__9"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1866:1: rule__PhysicalThread__Group__9 : rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10 ;
    public final void rule__PhysicalThread__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1870:1: ( rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1871:2: rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__9__Impl_in_rule__PhysicalThread__Group__93737);
            rule__PhysicalThread__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__10_in_rule__PhysicalThread__Group__93740);
            rule__PhysicalThread__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__9"


    // $ANTLR start "rule__PhysicalThread__Group__9__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1878:1: rule__PhysicalThread__Group__9__Impl : ( 'stacksize' ) ;
    public final void rule__PhysicalThread__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1882:1: ( ( 'stacksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1883:1: ( 'stacksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1883:1: ( 'stacksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1884:1: 'stacksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_9()); 
            match(input,33,FOLLOW_33_in_rule__PhysicalThread__Group__9__Impl3768); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__9__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__10"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1897:1: rule__PhysicalThread__Group__10 : rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11 ;
    public final void rule__PhysicalThread__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1901:1: ( rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1902:2: rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__10__Impl_in_rule__PhysicalThread__Group__103799);
            rule__PhysicalThread__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__11_in_rule__PhysicalThread__Group__103802);
            rule__PhysicalThread__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__10"


    // $ANTLR start "rule__PhysicalThread__Group__10__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1909:1: rule__PhysicalThread__Group__10__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1913:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1914:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1914:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1915:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_10()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__10__Impl3830); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__10__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__11"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1928:1: rule__PhysicalThread__Group__11 : rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12 ;
    public final void rule__PhysicalThread__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1932:1: ( rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1933:2: rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__11__Impl_in_rule__PhysicalThread__Group__113861);
            rule__PhysicalThread__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__12_in_rule__PhysicalThread__Group__113864);
            rule__PhysicalThread__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__11"


    // $ANTLR start "rule__PhysicalThread__Group__11__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1940:1: rule__PhysicalThread__Group__11__Impl : ( ( rule__PhysicalThread__StacksizeAssignment_11 ) ) ;
    public final void rule__PhysicalThread__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1944:1: ( ( ( rule__PhysicalThread__StacksizeAssignment_11 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1945:1: ( ( rule__PhysicalThread__StacksizeAssignment_11 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1945:1: ( ( rule__PhysicalThread__StacksizeAssignment_11 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1946:1: ( rule__PhysicalThread__StacksizeAssignment_11 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_11()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1947:1: ( rule__PhysicalThread__StacksizeAssignment_11 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1947:2: rule__PhysicalThread__StacksizeAssignment_11
            {
            pushFollow(FOLLOW_rule__PhysicalThread__StacksizeAssignment_11_in_rule__PhysicalThread__Group__11__Impl3891);
            rule__PhysicalThread__StacksizeAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__11__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__12"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1957:1: rule__PhysicalThread__Group__12 : rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13 ;
    public final void rule__PhysicalThread__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1961:1: ( rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1962:2: rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__12__Impl_in_rule__PhysicalThread__Group__123921);
            rule__PhysicalThread__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__13_in_rule__PhysicalThread__Group__123924);
            rule__PhysicalThread__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__12"


    // $ANTLR start "rule__PhysicalThread__Group__12__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1969:1: rule__PhysicalThread__Group__12__Impl : ( 'msgblocksize' ) ;
    public final void rule__PhysicalThread__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1973:1: ( ( 'msgblocksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1974:1: ( 'msgblocksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1974:1: ( 'msgblocksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1975:1: 'msgblocksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_12()); 
            match(input,34,FOLLOW_34_in_rule__PhysicalThread__Group__12__Impl3952); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__12__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__13"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1988:1: rule__PhysicalThread__Group__13 : rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14 ;
    public final void rule__PhysicalThread__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1992:1: ( rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1993:2: rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__13__Impl_in_rule__PhysicalThread__Group__133983);
            rule__PhysicalThread__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__14_in_rule__PhysicalThread__Group__133986);
            rule__PhysicalThread__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__13"


    // $ANTLR start "rule__PhysicalThread__Group__13__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2000:1: rule__PhysicalThread__Group__13__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2004:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2005:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2005:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2006:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_13()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__13__Impl4014); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__13__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__14"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2019:1: rule__PhysicalThread__Group__14 : rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15 ;
    public final void rule__PhysicalThread__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2023:1: ( rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2024:2: rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__14__Impl_in_rule__PhysicalThread__Group__144045);
            rule__PhysicalThread__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__15_in_rule__PhysicalThread__Group__144048);
            rule__PhysicalThread__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__14"


    // $ANTLR start "rule__PhysicalThread__Group__14__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2031:1: rule__PhysicalThread__Group__14__Impl : ( ( rule__PhysicalThread__MsgblocksizeAssignment_14 ) ) ;
    public final void rule__PhysicalThread__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2035:1: ( ( ( rule__PhysicalThread__MsgblocksizeAssignment_14 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2036:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_14 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2036:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_14 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2037:1: ( rule__PhysicalThread__MsgblocksizeAssignment_14 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_14()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2038:1: ( rule__PhysicalThread__MsgblocksizeAssignment_14 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2038:2: rule__PhysicalThread__MsgblocksizeAssignment_14
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_14_in_rule__PhysicalThread__Group__14__Impl4075);
            rule__PhysicalThread__MsgblocksizeAssignment_14();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__14__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__15"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2048:1: rule__PhysicalThread__Group__15 : rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16 ;
    public final void rule__PhysicalThread__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2052:1: ( rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2053:2: rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__15__Impl_in_rule__PhysicalThread__Group__154105);
            rule__PhysicalThread__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__16_in_rule__PhysicalThread__Group__154108);
            rule__PhysicalThread__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__15"


    // $ANTLR start "rule__PhysicalThread__Group__15__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2060:1: rule__PhysicalThread__Group__15__Impl : ( 'msgpoolsize' ) ;
    public final void rule__PhysicalThread__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2064:1: ( ( 'msgpoolsize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2065:1: ( 'msgpoolsize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2065:1: ( 'msgpoolsize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2066:1: 'msgpoolsize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_15()); 
            match(input,35,FOLLOW_35_in_rule__PhysicalThread__Group__15__Impl4136); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__15__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__16"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2079:1: rule__PhysicalThread__Group__16 : rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17 ;
    public final void rule__PhysicalThread__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2083:1: ( rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2084:2: rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__16__Impl_in_rule__PhysicalThread__Group__164167);
            rule__PhysicalThread__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__17_in_rule__PhysicalThread__Group__164170);
            rule__PhysicalThread__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__16"


    // $ANTLR start "rule__PhysicalThread__Group__16__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2091:1: rule__PhysicalThread__Group__16__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2095:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2096:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2096:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2097:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_16()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__16__Impl4198); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__16__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__17"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2110:1: rule__PhysicalThread__Group__17 : rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18 ;
    public final void rule__PhysicalThread__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2114:1: ( rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2115:2: rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__17__Impl_in_rule__PhysicalThread__Group__174229);
            rule__PhysicalThread__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__18_in_rule__PhysicalThread__Group__174232);
            rule__PhysicalThread__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__17"


    // $ANTLR start "rule__PhysicalThread__Group__17__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2122:1: rule__PhysicalThread__Group__17__Impl : ( ( rule__PhysicalThread__MsgpoolsizeAssignment_17 ) ) ;
    public final void rule__PhysicalThread__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2126:1: ( ( ( rule__PhysicalThread__MsgpoolsizeAssignment_17 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_17 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_17 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2128:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_17 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_17()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_17 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:2: rule__PhysicalThread__MsgpoolsizeAssignment_17
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_17_in_rule__PhysicalThread__Group__17__Impl4259);
            rule__PhysicalThread__MsgpoolsizeAssignment_17();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__17__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__18"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2139:1: rule__PhysicalThread__Group__18 : rule__PhysicalThread__Group__18__Impl ;
    public final void rule__PhysicalThread__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2143:1: ( rule__PhysicalThread__Group__18__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2144:2: rule__PhysicalThread__Group__18__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__18__Impl_in_rule__PhysicalThread__Group__184289);
            rule__PhysicalThread__Group__18__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__18"


    // $ANTLR start "rule__PhysicalThread__Group__18__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2150:1: rule__PhysicalThread__Group__18__Impl : ( '}' ) ;
    public final void rule__PhysicalThread__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2154:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2155:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2155:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2156:1: '}'
            {
             before(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_18()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalThread__Group__18__Impl4317); 
             after(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__18__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2207:1: rule__RuntimeClass__Group__0 : rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 ;
    public final void rule__RuntimeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2211:1: ( rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2212:2: rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04386);
            rule__RuntimeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04389);
            rule__RuntimeClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__0"


    // $ANTLR start "rule__RuntimeClass__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2219:1: rule__RuntimeClass__Group__0__Impl : ( 'RuntimeClass' ) ;
    public final void rule__RuntimeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2223:1: ( ( 'RuntimeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2224:1: ( 'RuntimeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2224:1: ( 'RuntimeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2225:1: 'RuntimeClass'
            {
             before(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__RuntimeClass__Group__0__Impl4417); 
             after(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__0__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2238:1: rule__RuntimeClass__Group__1 : rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 ;
    public final void rule__RuntimeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2242:1: ( rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2243:2: rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14448);
            rule__RuntimeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14451);
            rule__RuntimeClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__1"


    // $ANTLR start "rule__RuntimeClass__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2250:1: rule__RuntimeClass__Group__1__Impl : ( ( rule__RuntimeClass__NameAssignment_1 ) ) ;
    public final void rule__RuntimeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2254:1: ( ( ( rule__RuntimeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2255:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2255:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2256:1: ( rule__RuntimeClass__NameAssignment_1 )
            {
             before(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2257:1: ( rule__RuntimeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2257:2: rule__RuntimeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4478);
            rule__RuntimeClass__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__1__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2267:1: rule__RuntimeClass__Group__2 : rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 ;
    public final void rule__RuntimeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2271:1: ( rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2272:2: rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24508);
            rule__RuntimeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24511);
            rule__RuntimeClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__2"


    // $ANTLR start "rule__RuntimeClass__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2279:1: rule__RuntimeClass__Group__2__Impl : ( ( rule__RuntimeClass__DocuAssignment_2 )? ) ;
    public final void rule__RuntimeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2283:1: ( ( ( rule__RuntimeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2284:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2284:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2285:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2286:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==37) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2286:2: rule__RuntimeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4538);
                    rule__RuntimeClass__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__2__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2296:1: rule__RuntimeClass__Group__3 : rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 ;
    public final void rule__RuntimeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2300:1: ( rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2301:2: rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__34569);
            rule__RuntimeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__34572);
            rule__RuntimeClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__3"


    // $ANTLR start "rule__RuntimeClass__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2308:1: rule__RuntimeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__RuntimeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2312:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2313:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2313:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2314:1: '{'
            {
             before(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl4600); 
             after(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__3__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2327:1: rule__RuntimeClass__Group__4 : rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 ;
    public final void rule__RuntimeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2331:1: ( rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2332:2: rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__44631);
            rule__RuntimeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__44634);
            rule__RuntimeClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__4"


    // $ANTLR start "rule__RuntimeClass__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2339:1: rule__RuntimeClass__Group__4__Impl : ( 'model' ) ;
    public final void rule__RuntimeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2343:1: ( ( 'model' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2344:1: ( 'model' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2344:1: ( 'model' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2345:1: 'model'
            {
             before(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl4662); 
             after(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__4__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2358:1: rule__RuntimeClass__Group__5 : rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 ;
    public final void rule__RuntimeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2362:1: ( rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2363:2: rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__54693);
            rule__RuntimeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__54696);
            rule__RuntimeClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__5"


    // $ANTLR start "rule__RuntimeClass__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2370:1: rule__RuntimeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__RuntimeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2374:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2375:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2375:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2376:1: '='
            {
             before(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl4724); 
             after(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__5__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2389:1: rule__RuntimeClass__Group__6 : rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 ;
    public final void rule__RuntimeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2393:1: ( rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2394:2: rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__64755);
            rule__RuntimeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__64758);
            rule__RuntimeClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__6"


    // $ANTLR start "rule__RuntimeClass__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2401:1: rule__RuntimeClass__Group__6__Impl : ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) ;
    public final void rule__RuntimeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2405:1: ( ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2406:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2406:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2407:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2408:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2408:2: rule__RuntimeClass__ThreadModelAssignment_6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl4785);
            rule__RuntimeClass__ThreadModelAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__6__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__7"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2418:1: rule__RuntimeClass__Group__7 : rule__RuntimeClass__Group__7__Impl ;
    public final void rule__RuntimeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2422:1: ( rule__RuntimeClass__Group__7__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2423:2: rule__RuntimeClass__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__74815);
            rule__RuntimeClass__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__7"


    // $ANTLR start "rule__RuntimeClass__Group__7__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2429:1: rule__RuntimeClass__Group__7__Impl : ( '}' ) ;
    public final void rule__RuntimeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2433:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2434:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2434:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2435:1: '}'
            {
             before(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 
            match(input,22,FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl4843); 
             after(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__7__Impl"


    // $ANTLR start "rule__Documentation__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2464:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2468:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2469:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__04890);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__04893);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2476:1: rule__Documentation__Group__0__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2480:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2481:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2481:1: ( '[' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2482:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__Documentation__Group__0__Impl4921); 
             after(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__0__Impl"


    // $ANTLR start "rule__Documentation__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2495:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2499:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2500:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14952);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14955);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2507:1: rule__Documentation__Group__1__Impl : ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2511:1: ( ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2512:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2512:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2513:1: ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2513:1: ( ( rule__Documentation__TextAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2514:1: ( rule__Documentation__TextAssignment_1 )
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2515:1: ( rule__Documentation__TextAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2515:2: rule__Documentation__TextAssignment_1
            {
            pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl4984);
            rule__Documentation__TextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 

            }

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2518:1: ( ( rule__Documentation__TextAssignment_1 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2519:1: ( rule__Documentation__TextAssignment_1 )*
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2520:1: ( rule__Documentation__TextAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_STRING) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2520:2: rule__Documentation__TextAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl4996);
            	    rule__Documentation__TextAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 

            }


            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2531:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2535:1: ( rule__Documentation__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2536:2: rule__Documentation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25029);
            rule__Documentation__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2542:1: rule__Documentation__Group__2__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2546:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2547:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2547:1: ( ']' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2548:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2()); 
            match(input,38,FOLLOW_38_in_rule__Documentation__Group__2__Impl5057); 
             after(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__PRIO__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2567:1: rule__PRIO__Group__0 : rule__PRIO__Group__0__Impl rule__PRIO__Group__1 ;
    public final void rule__PRIO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2571:1: ( rule__PRIO__Group__0__Impl rule__PRIO__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2572:2: rule__PRIO__Group__0__Impl rule__PRIO__Group__1
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05094);
            rule__PRIO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05097);
            rule__PRIO__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__0"


    // $ANTLR start "rule__PRIO__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2579:1: rule__PRIO__Group__0__Impl : ( ( rule__PRIO__Alternatives_0 )? ) ;
    public final void rule__PRIO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2583:1: ( ( ( rule__PRIO__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2584:1: ( ( rule__PRIO__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2584:1: ( ( rule__PRIO__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2585:1: ( rule__PRIO__Alternatives_0 )?
            {
             before(grammarAccess.getPRIOAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2586:1: ( rule__PRIO__Alternatives_0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=12 && LA16_0<=13)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2586:2: rule__PRIO__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5124);
                    rule__PRIO__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPRIOAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__0__Impl"


    // $ANTLR start "rule__PRIO__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2596:1: rule__PRIO__Group__1 : rule__PRIO__Group__1__Impl ;
    public final void rule__PRIO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2600:1: ( rule__PRIO__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2601:2: rule__PRIO__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15155);
            rule__PRIO__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__1"


    // $ANTLR start "rule__PRIO__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2607:1: rule__PRIO__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__PRIO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2611:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2612:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2612:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2613:1: RULE_INT
            {
             before(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5182); 
             after(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2628:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2632:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2633:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05215);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05218);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2640:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2644:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2645:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2645:1: ( 'import' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2646:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__Import__Group__0__Impl5246); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2659:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2663:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2664:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15277);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15280);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2671:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2675:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2676:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2676:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2677:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2678:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2678:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5307);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2688:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2692:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2693:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25337);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2699:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2703:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2704:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2704:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2705:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2706:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2706:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5364);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2722:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2726:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2727:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05400);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05403);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2734:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2738:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2739:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2739:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2740:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2741:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2741:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5430);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2751:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2755:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2756:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15460);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2762:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2766:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2767:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2767:1: ( 'from' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2768:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,40,FOLLOW_40_in_rule__Import__Group_1_0__1__Impl5488); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2785:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2789:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2790:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05523);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05526);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2797:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2801:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2802:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2802:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2803:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5553);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2814:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2818:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2819:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15582);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2825:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2829:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2830:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2830:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2831:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2832:1: ( '.*' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2833:2: '.*'
                    {
                    match(input,41,FOLLOW_41_in_rule__ImportedFQN__Group__1__Impl5611); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2848:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2852:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2853:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05648);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05651);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2860:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2864:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2866:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5678); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2877:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2881:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2882:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15707);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2888:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2892:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2893:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2893:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2894:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:1: ( rule__FQN__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==42) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5734);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2909:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2913:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2914:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05769);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05772);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2921:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2925:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2926:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2926:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2927:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,42,FOLLOW_42_in_rule__FQN__Group_1__0__Impl5800); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2940:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2944:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2945:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15831);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2951:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2955:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2956:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2956:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2957:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5858); 
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


    // $ANTLR start "rule__PhysicalModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2973:1: rule__PhysicalModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__PhysicalModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2977:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2978:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2978:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2979:1: ruleFQN
            {
             before(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_15896);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__NameAssignment_1"


    // $ANTLR start "rule__PhysicalModel__ImportsAssignment_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2988:1: rule__PhysicalModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__PhysicalModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2992:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2993:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2993:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2994:1: ruleImport
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_35927);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__ImportsAssignment_3"


    // $ANTLR start "rule__PhysicalModel__SystemsAssignment_4_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3003:1: rule__PhysicalModel__SystemsAssignment_4_0 : ( rulePhysicalSystem ) ;
    public final void rule__PhysicalModel__SystemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3007:1: ( ( rulePhysicalSystem ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3008:1: ( rulePhysicalSystem )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3008:1: ( rulePhysicalSystem )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3009:1: rulePhysicalSystem
            {
             before(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_05958);
            rulePhysicalSystem();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__SystemsAssignment_4_0"


    // $ANTLR start "rule__PhysicalModel__NodeClassesAssignment_4_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3018:1: rule__PhysicalModel__NodeClassesAssignment_4_1 : ( ruleNodeClass ) ;
    public final void rule__PhysicalModel__NodeClassesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3022:1: ( ( ruleNodeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3023:1: ( ruleNodeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3023:1: ( ruleNodeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3024:1: ruleNodeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_15989);
            ruleNodeClass();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__NodeClassesAssignment_4_1"


    // $ANTLR start "rule__PhysicalModel__RuntimeClassesAssignment_4_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3033:1: rule__PhysicalModel__RuntimeClassesAssignment_4_2 : ( ruleRuntimeClass ) ;
    public final void rule__PhysicalModel__RuntimeClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3037:1: ( ( ruleRuntimeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3038:1: ( ruleRuntimeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3038:1: ( ruleRuntimeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3039:1: ruleRuntimeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_26020);
            ruleRuntimeClass();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__RuntimeClassesAssignment_4_2"


    // $ANTLR start "rule__PhysicalSystem__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3048:1: rule__PhysicalSystem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalSystem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3052:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3053:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3053:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3054:1: RULE_ID
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_16051); 
             after(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__NameAssignment_1"


    // $ANTLR start "rule__PhysicalSystem__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3063:1: rule__PhysicalSystem__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__PhysicalSystem__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3067:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3068:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3068:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3069:1: ruleDocumentation
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_26082);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__DocuAssignment_2"


    // $ANTLR start "rule__PhysicalSystem__NodeRefsAssignment_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3078:1: rule__PhysicalSystem__NodeRefsAssignment_4 : ( ruleNodeRef ) ;
    public final void rule__PhysicalSystem__NodeRefsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3082:1: ( ( ruleNodeRef ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3083:1: ( ruleNodeRef )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3083:1: ( ruleNodeRef )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3084:1: ruleNodeRef
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_46113);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__NodeRefsAssignment_4"


    // $ANTLR start "rule__NodeRef__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3093:1: rule__NodeRef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3097:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3098:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3098:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3099:1: RULE_ID
            {
             before(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_16144); 
             after(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__NameAssignment_1"


    // $ANTLR start "rule__NodeRef__TypeAssignment_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3108:1: rule__NodeRef__TypeAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__NodeRef__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3112:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3113:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3113:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3114:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3115:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3116:1: ruleFQN
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_36179);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__TypeAssignment_3"


    // $ANTLR start "rule__NodeRef__DocuAssignment_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3127:1: rule__NodeRef__DocuAssignment_4 : ( ruleDocumentation ) ;
    public final void rule__NodeRef__DocuAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3131:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3132:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3132:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3133:1: ruleDocumentation
            {
             before(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_46214);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__DocuAssignment_4"


    // $ANTLR start "rule__NodeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3142:1: rule__NodeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3146:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3147:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3147:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3148:1: RULE_ID
            {
             before(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_16245); 
             after(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__NameAssignment_1"


    // $ANTLR start "rule__NodeClass__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3157:1: rule__NodeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__NodeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3161:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3162:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3162:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3163:1: ruleDocumentation
            {
             before(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_26276);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__DocuAssignment_2"


    // $ANTLR start "rule__NodeClass__RuntimeAssignment_6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3172:1: rule__NodeClass__RuntimeAssignment_6 : ( ( ruleFQN ) ) ;
    public final void rule__NodeClass__RuntimeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3176:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3177:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3177:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3178:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_6_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3179:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3180:1: ruleFQN
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_66311);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__RuntimeAssignment_6"


    // $ANTLR start "rule__NodeClass__PriominAssignment_9"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3191:1: rule__NodeClass__PriominAssignment_9 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriominAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3195:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3196:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3196:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3197:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_9_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_96346);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriominAssignment_9"


    // $ANTLR start "rule__NodeClass__PriomaxAssignment_12"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3206:1: rule__NodeClass__PriomaxAssignment_12 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriomaxAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3210:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3211:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3211:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3212:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_12_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_126377);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriomaxAssignment_12"


    // $ANTLR start "rule__NodeClass__ThreadsAssignment_13"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3221:1: rule__NodeClass__ThreadsAssignment_13 : ( rulePhysicalThread ) ;
    public final void rule__NodeClass__ThreadsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3225:1: ( ( rulePhysicalThread ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3226:1: ( rulePhysicalThread )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3226:1: ( rulePhysicalThread )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3227:1: rulePhysicalThread
            {
             before(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_13_0()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_136408);
            rulePhysicalThread();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__ThreadsAssignment_13"


    // $ANTLR start "rule__PhysicalThread__DefaultAssignment_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3236:1: rule__PhysicalThread__DefaultAssignment_0_0 : ( ( 'DefaultThread' ) ) ;
    public final void rule__PhysicalThread__DefaultAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3240:1: ( ( ( 'DefaultThread' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3241:1: ( ( 'DefaultThread' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3241:1: ( ( 'DefaultThread' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3242:1: ( 'DefaultThread' )
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3243:1: ( 'DefaultThread' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3244:1: 'DefaultThread'
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            match(input,43,FOLLOW_43_in_rule__PhysicalThread__DefaultAssignment_0_06444); 
             after(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 

            }

             after(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__DefaultAssignment_0_0"


    // $ANTLR start "rule__PhysicalThread__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3259:1: rule__PhysicalThread__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalThread__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3263:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3264:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3264:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3265:1: RULE_ID
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_16483); 
             after(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__NameAssignment_1"


    // $ANTLR start "rule__PhysicalThread__ExecmodeAssignment_5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3274:1: rule__PhysicalThread__ExecmodeAssignment_5 : ( ruleExecMode ) ;
    public final void rule__PhysicalThread__ExecmodeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3278:1: ( ( ruleExecMode ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3279:1: ( ruleExecMode )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3279:1: ( ruleExecMode )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3280:1: ruleExecMode
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_56514);
            ruleExecMode();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__ExecmodeAssignment_5"


    // $ANTLR start "rule__PhysicalThread__PrioAssignment_8"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3289:1: rule__PhysicalThread__PrioAssignment_8 : ( rulePRIO ) ;
    public final void rule__PhysicalThread__PrioAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3293:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3294:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3294:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3295:1: rulePRIO
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_8_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_86545);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__PrioAssignment_8"


    // $ANTLR start "rule__PhysicalThread__StacksizeAssignment_11"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3304:1: rule__PhysicalThread__StacksizeAssignment_11 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__StacksizeAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3308:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3309:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3309:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3310:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_11_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_116576); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__StacksizeAssignment_11"


    // $ANTLR start "rule__PhysicalThread__MsgblocksizeAssignment_14"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3319:1: rule__PhysicalThread__MsgblocksizeAssignment_14 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgblocksizeAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3323:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3324:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3324:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3325:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_14_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_146607); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgblocksizeAssignment_14"


    // $ANTLR start "rule__PhysicalThread__MsgpoolsizeAssignment_17"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3334:1: rule__PhysicalThread__MsgpoolsizeAssignment_17 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgpoolsizeAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3338:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3339:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3339:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3340:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_17_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_176638); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgpoolsizeAssignment_17"


    // $ANTLR start "rule__RuntimeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3349:1: rule__RuntimeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RuntimeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3353:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3354:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3354:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3355:1: RULE_ID
            {
             before(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_16669); 
             after(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__NameAssignment_1"


    // $ANTLR start "rule__RuntimeClass__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3364:1: rule__RuntimeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__RuntimeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3368:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3369:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3369:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3370:1: ruleDocumentation
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_26700);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__DocuAssignment_2"


    // $ANTLR start "rule__RuntimeClass__ThreadModelAssignment_6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3379:1: rule__RuntimeClass__ThreadModelAssignment_6 : ( ruleThreadModel ) ;
    public final void rule__RuntimeClass__ThreadModelAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3383:1: ( ( ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3384:1: ( ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3384:1: ( ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3385:1: ruleThreadModel
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_66731);
            ruleThreadModel();

            state._fsp--;

             after(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__ThreadModelAssignment_6"


    // $ANTLR start "rule__Documentation__TextAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3394:1: rule__Documentation__TextAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Documentation__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3398:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3399:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3399:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3400:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_16762); 
             after(grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__TextAssignment_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3409:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3413:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3414:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3414:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3415:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_06793);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3424:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3428:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3429:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3429:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3430:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_26824); 
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


 

    public static final BitSet FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__0_in_rulePhysicalModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalSystem128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__0_in_rulePhysicalSystem154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_entryRuleNodeClass241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeClass248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__0_in_ruleNodeClass274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalThread308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0_in_rulePhysicalThread334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuntimeClass368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0_in_ruleRuntimeClass394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_entryRulePRIO486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePRIO493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0_in_rulePRIO523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_4811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_0880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__PhysicalThread__Alternatives_0899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PRIO__Alternatives_0934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PRIO__Alternatives_0954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Alternatives_11007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExecMode__Alternatives1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ExecMode__Alternatives1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExecMode__Alternatives1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ThreadModel__Alternatives1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ThreadModel__Alternatives1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__01174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__01177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PhysicalModel__Group__0__Impl1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__11236 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__11239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__21296 = new BitSet(new long[]{0x0000009004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__21299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalModel__Group__2__Impl1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__31358 = new BitSet(new long[]{0x0000009004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__31361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl1388 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__41419 = new BitSet(new long[]{0x0000009004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__41422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl1449 = new BitSet(new long[]{0x0000001004800002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__51480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalModel__Group__5__Impl1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__01551 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__01554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PhysicalSystem__Group__0__Impl1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__11613 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__11616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__21673 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__21676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__31734 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__31737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalSystem__Group__3__Impl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__41796 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__41799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl1826 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__51857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalSystem__Group__5__Impl1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__01928 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__01931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__NodeRef__Group__0__Impl1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__11990 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__11993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__22050 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__22053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__NodeRef__Group__2__Impl2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__32112 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__32115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__42172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__02240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__02243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__NodeClass__Group__0__Impl2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__12302 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__12305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__22362 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__22365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__32423 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__32426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NodeClass__Group__3__Impl2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__42485 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__42488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__NodeClass__Group__4__Impl2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52547 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__5__Impl2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62609 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__7_in_rule__NodeClass__Group__62612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__RuntimeAssignment_6_in_rule__NodeClass__Group__6__Impl2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__7__Impl_in_rule__NodeClass__Group__72669 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__8_in_rule__NodeClass__Group__72672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__NodeClass__Group__7__Impl2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__8__Impl_in_rule__NodeClass__Group__82731 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__9_in_rule__NodeClass__Group__82734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__8__Impl2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__9__Impl_in_rule__NodeClass__Group__92793 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__10_in_rule__NodeClass__Group__92796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriominAssignment_9_in_rule__NodeClass__Group__9__Impl2823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__10__Impl_in_rule__NodeClass__Group__102853 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__11_in_rule__NodeClass__Group__102856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__NodeClass__Group__10__Impl2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__11__Impl_in_rule__NodeClass__Group__112915 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__12_in_rule__NodeClass__Group__112918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__11__Impl2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__12__Impl_in_rule__NodeClass__Group__122977 = new BitSet(new long[]{0x0000080000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__13_in_rule__NodeClass__Group__122980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriomaxAssignment_12_in_rule__NodeClass__Group__12__Impl3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__13__Impl_in_rule__NodeClass__Group__133037 = new BitSet(new long[]{0x0000080000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__14_in_rule__NodeClass__Group__133040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__ThreadsAssignment_13_in_rule__NodeClass__Group__13__Impl3067 = new BitSet(new long[]{0x0000080000000802L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__14__Impl_in_rule__NodeClass__Group__143098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__NodeClass__Group__14__Impl3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13247 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23307 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33369 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PhysicalThread__Group__3__Impl3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43431 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__5_in_rule__PhysicalThread__Group__43434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__4__Impl3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__5__Impl_in_rule__PhysicalThread__Group__53493 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__6_in_rule__PhysicalThread__Group__53496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__ExecmodeAssignment_5_in_rule__PhysicalThread__Group__5__Impl3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__6__Impl_in_rule__PhysicalThread__Group__63553 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__7_in_rule__PhysicalThread__Group__63556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PhysicalThread__Group__6__Impl3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__7__Impl_in_rule__PhysicalThread__Group__73615 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__8_in_rule__PhysicalThread__Group__73618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__7__Impl3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__8__Impl_in_rule__PhysicalThread__Group__83677 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__9_in_rule__PhysicalThread__Group__83680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__PrioAssignment_8_in_rule__PhysicalThread__Group__8__Impl3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__9__Impl_in_rule__PhysicalThread__Group__93737 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__10_in_rule__PhysicalThread__Group__93740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PhysicalThread__Group__9__Impl3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__10__Impl_in_rule__PhysicalThread__Group__103799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__11_in_rule__PhysicalThread__Group__103802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__10__Impl3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__11__Impl_in_rule__PhysicalThread__Group__113861 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__12_in_rule__PhysicalThread__Group__113864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__StacksizeAssignment_11_in_rule__PhysicalThread__Group__11__Impl3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__12__Impl_in_rule__PhysicalThread__Group__123921 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__13_in_rule__PhysicalThread__Group__123924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PhysicalThread__Group__12__Impl3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__13__Impl_in_rule__PhysicalThread__Group__133983 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__14_in_rule__PhysicalThread__Group__133986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__13__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__14__Impl_in_rule__PhysicalThread__Group__144045 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__15_in_rule__PhysicalThread__Group__144048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_14_in_rule__PhysicalThread__Group__14__Impl4075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__15__Impl_in_rule__PhysicalThread__Group__154105 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__16_in_rule__PhysicalThread__Group__154108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PhysicalThread__Group__15__Impl4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__16__Impl_in_rule__PhysicalThread__Group__164167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__17_in_rule__PhysicalThread__Group__164170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__16__Impl4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__17__Impl_in_rule__PhysicalThread__Group__174229 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__18_in_rule__PhysicalThread__Group__174232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_17_in_rule__PhysicalThread__Group__17__Impl4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__18__Impl_in_rule__PhysicalThread__Group__184289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalThread__Group__18__Impl4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04386 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RuntimeClass__Group__0__Impl4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14448 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24508 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__34569 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__34572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__44631 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__44634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__54693 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__54696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl4724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__64755 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__64758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__74815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl4843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__04890 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__04893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Documentation__Group__0__Impl4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__14952 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__14955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl4984 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl4996 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Documentation__Group__2__Impl5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05094 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05215 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Import__Group__0__Impl5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15277 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05400 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Import__Group_1_0__1__Impl5488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05523 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ImportedFQN__Group__1__Impl5611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__05648 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__05651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__15707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl5734 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__05769 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__05772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__FQN__Group_1__0__Impl5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__15831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_15896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_35927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_05958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_15989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_26020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_16051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_26082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_46113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_16144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_36179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_46214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_16245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_26276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_66311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_96346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_126377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_136408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__PhysicalThread__DefaultAssignment_0_06444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_16483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_56514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_86545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_116576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_146607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_176638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_16669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_26700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_66731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_16762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_06793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_26824 = new BitSet(new long[]{0x0000000000000002L});

}