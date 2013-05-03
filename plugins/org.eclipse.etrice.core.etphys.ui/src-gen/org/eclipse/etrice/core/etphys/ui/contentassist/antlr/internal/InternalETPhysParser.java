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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Thread'", "'+'", "'-'", "'model'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'execmode'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'interval'", "'RuntimeClass'", "'['", "']'", "'import'", "'from'", "'.*'", "'.'", "'s'", "'ms'", "'us'", "'ns'", "'DefaultThread'"
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
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
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
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


    // $ANTLR start "entryRuleTIME"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:376:1: entryRuleTIME : ruleTIME EOF ;
    public final void entryRuleTIME() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:377:1: ( ruleTIME EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:378:1: ruleTIME EOF
            {
             before(grammarAccess.getTIMERule()); 
            pushFollow(FOLLOW_ruleTIME_in_entryRuleTIME730);
            ruleTIME();

            state._fsp--;

             after(grammarAccess.getTIMERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTIME737); 

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
    // $ANTLR end "entryRuleTIME"


    // $ANTLR start "ruleTIME"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:385:1: ruleTIME : ( ( rule__TIME__Alternatives ) ) ;
    public final void ruleTIME() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:389:2: ( ( ( rule__TIME__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:390:1: ( ( rule__TIME__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:390:1: ( ( rule__TIME__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:391:1: ( rule__TIME__Alternatives )
            {
             before(grammarAccess.getTIMEAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:392:1: ( rule__TIME__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:392:2: rule__TIME__Alternatives
            {
            pushFollow(FOLLOW_rule__TIME__Alternatives_in_ruleTIME763);
            rule__TIME__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTIMEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTIME"


    // $ANTLR start "ruleExecMode"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:405:1: ruleExecMode : ( ( rule__ExecMode__Alternatives ) ) ;
    public final void ruleExecMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:409:1: ( ( ( rule__ExecMode__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:410:1: ( ( rule__ExecMode__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:410:1: ( ( rule__ExecMode__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:411:1: ( rule__ExecMode__Alternatives )
            {
             before(grammarAccess.getExecModeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:412:1: ( rule__ExecMode__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:412:2: rule__ExecMode__Alternatives
            {
            pushFollow(FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode800);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:424:1: ruleThreadModel : ( ( rule__ThreadModel__Alternatives ) ) ;
    public final void ruleThreadModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:428:1: ( ( ( rule__ThreadModel__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:429:1: ( ( rule__ThreadModel__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:429:1: ( ( rule__ThreadModel__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:430:1: ( rule__ThreadModel__Alternatives )
            {
             before(grammarAccess.getThreadModelAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:431:1: ( rule__ThreadModel__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:431:2: rule__ThreadModel__Alternatives
            {
            pushFollow(FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel836);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:442:1: rule__PhysicalModel__Alternatives_4 : ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) );
    public final void rule__PhysicalModel__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:446:1: ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) )
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
            case 37:
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:447:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:447:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:448:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:449:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:449:2: rule__PhysicalModel__SystemsAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_4871);
                    rule__PhysicalModel__SystemsAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:453:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:453:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:454:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:455:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:455:2: rule__PhysicalModel__NodeClassesAssignment_4_1
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_4889);
                    rule__PhysicalModel__NodeClassesAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:459:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:459:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:460:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:461:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:461:2: rule__PhysicalModel__RuntimeClassesAssignment_4_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_4907);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:470:1: rule__PhysicalThread__Alternatives_0 : ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) );
    public final void rule__PhysicalThread__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:474:1: ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==48) ) {
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:475:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:475:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:476:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:477:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:477:2: rule__PhysicalThread__DefaultAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_0940);
                    rule__PhysicalThread__DefaultAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:481:6: ( 'Thread' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:481:6: ( 'Thread' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:482:1: 'Thread'
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1()); 
                    match(input,11,FOLLOW_11_in_rule__PhysicalThread__Alternatives_0959); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:494:1: rule__PRIO__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__PRIO__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:498:1: ( ( '+' ) | ( '-' ) )
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:499:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:499:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:500:1: '+'
                    {
                     before(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__PRIO__Alternatives_0994); 
                     after(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:507:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:507:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:508:1: '-'
                    {
                     before(grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__PRIO__Alternatives_01014); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:520:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:524:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
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
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:525:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:525:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:526:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:527:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:527:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_11048);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:531:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:531:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:532:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Import__Alternatives_11067); 
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


    // $ANTLR start "rule__TIME__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:544:1: rule__TIME__Alternatives : ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) );
    public final void rule__TIME__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:548:1: ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 45:
                    {
                    alt5=2;
                    }
                    break;
                case 46:
                    {
                    alt5=3;
                    }
                    break;
                case 47:
                    {
                    alt5=4;
                    }
                    break;
                case 44:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:549:1: ( ( rule__TIME__Group_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:549:1: ( ( rule__TIME__Group_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:550:1: ( rule__TIME__Group_0__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:551:1: ( rule__TIME__Group_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:551:2: rule__TIME__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_0__0_in_rule__TIME__Alternatives1101);
                    rule__TIME__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:555:6: ( ( rule__TIME__Group_1__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:555:6: ( ( rule__TIME__Group_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:556:1: ( rule__TIME__Group_1__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:557:1: ( rule__TIME__Group_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:557:2: rule__TIME__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_1__0_in_rule__TIME__Alternatives1119);
                    rule__TIME__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:561:6: ( ( rule__TIME__Group_2__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:561:6: ( ( rule__TIME__Group_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:562:1: ( rule__TIME__Group_2__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:563:1: ( rule__TIME__Group_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:563:2: rule__TIME__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_2__0_in_rule__TIME__Alternatives1137);
                    rule__TIME__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:567:6: ( ( rule__TIME__Group_3__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:567:6: ( ( rule__TIME__Group_3__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:568:1: ( rule__TIME__Group_3__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_3()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:569:1: ( rule__TIME__Group_3__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:569:2: rule__TIME__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_3__0_in_rule__TIME__Alternatives1155);
                    rule__TIME__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_3()); 

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
    // $ANTLR end "rule__TIME__Alternatives"


    // $ANTLR start "rule__ExecMode__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:578:1: rule__ExecMode__Alternatives : ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) );
    public final void rule__ExecMode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:582:1: ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:583:1: ( ( 'polled' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:583:1: ( ( 'polled' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:584:1: ( 'polled' )
                    {
                     before(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:585:1: ( 'polled' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:585:3: 'polled'
                    {
                    match(input,15,FOLLOW_15_in_rule__ExecMode__Alternatives1189); 

                    }

                     after(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:590:6: ( ( 'blocked' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:590:6: ( ( 'blocked' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:591:1: ( 'blocked' )
                    {
                     before(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:592:1: ( 'blocked' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:592:3: 'blocked'
                    {
                    match(input,16,FOLLOW_16_in_rule__ExecMode__Alternatives1210); 

                    }

                     after(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:597:6: ( ( 'mixed' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:597:6: ( ( 'mixed' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:598:1: ( 'mixed' )
                    {
                     before(grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:599:1: ( 'mixed' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:599:3: 'mixed'
                    {
                    match(input,17,FOLLOW_17_in_rule__ExecMode__Alternatives1231); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:609:1: rule__ThreadModel__Alternatives : ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) );
    public final void rule__ThreadModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:613:1: ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:614:1: ( ( 'singleThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:614:1: ( ( 'singleThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:615:1: ( 'singleThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:616:1: ( 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:616:3: 'singleThreaded'
                    {
                    match(input,18,FOLLOW_18_in_rule__ThreadModel__Alternatives1267); 

                    }

                     after(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:621:6: ( ( 'multiThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:621:6: ( ( 'multiThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:622:1: ( 'multiThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:623:1: ( 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:623:3: 'multiThreaded'
                    {
                    match(input,19,FOLLOW_19_in_rule__ThreadModel__Alternatives1288); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:635:1: rule__PhysicalModel__Group__0 : rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 ;
    public final void rule__PhysicalModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:639:1: ( rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:640:2: rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__01321);
            rule__PhysicalModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__01324);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:647:1: rule__PhysicalModel__Group__0__Impl : ( 'PhysicalModel' ) ;
    public final void rule__PhysicalModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:651:1: ( ( 'PhysicalModel' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:652:1: ( 'PhysicalModel' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:652:1: ( 'PhysicalModel' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:653:1: 'PhysicalModel'
            {
             before(grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__PhysicalModel__Group__0__Impl1352); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:666:1: rule__PhysicalModel__Group__1 : rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 ;
    public final void rule__PhysicalModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:670:1: ( rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:671:2: rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__11383);
            rule__PhysicalModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__11386);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:678:1: rule__PhysicalModel__Group__1__Impl : ( ( rule__PhysicalModel__NameAssignment_1 ) ) ;
    public final void rule__PhysicalModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:682:1: ( ( ( rule__PhysicalModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:683:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:683:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:684:1: ( rule__PhysicalModel__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:685:1: ( rule__PhysicalModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:685:2: rule__PhysicalModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl1413);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:695:1: rule__PhysicalModel__Group__2 : rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 ;
    public final void rule__PhysicalModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:699:1: ( rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:700:2: rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__21443);
            rule__PhysicalModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__21446);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:707:1: rule__PhysicalModel__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:711:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:712:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:712:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:713:1: '{'
            {
             before(grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalModel__Group__2__Impl1474); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:726:1: rule__PhysicalModel__Group__3 : rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 ;
    public final void rule__PhysicalModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:730:1: ( rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:731:2: rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__31505);
            rule__PhysicalModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__31508);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:738:1: rule__PhysicalModel__Group__3__Impl : ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) ;
    public final void rule__PhysicalModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:742:1: ( ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:743:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:743:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:744:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:745:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==40) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:745:2: rule__PhysicalModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl1535);
            	    rule__PhysicalModel__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:755:1: rule__PhysicalModel__Group__4 : rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 ;
    public final void rule__PhysicalModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:759:1: ( rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:760:2: rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__41566);
            rule__PhysicalModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__41569);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:767:1: rule__PhysicalModel__Group__4__Impl : ( ( rule__PhysicalModel__Alternatives_4 )* ) ;
    public final void rule__PhysicalModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:771:1: ( ( ( rule__PhysicalModel__Alternatives_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:772:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:772:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:773:1: ( rule__PhysicalModel__Alternatives_4 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getAlternatives_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:774:1: ( rule__PhysicalModel__Alternatives_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23||LA9_0==26||LA9_0==37) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:774:2: rule__PhysicalModel__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl1596);
            	    rule__PhysicalModel__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:784:1: rule__PhysicalModel__Group__5 : rule__PhysicalModel__Group__5__Impl ;
    public final void rule__PhysicalModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:788:1: ( rule__PhysicalModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:789:2: rule__PhysicalModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__51627);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:795:1: rule__PhysicalModel__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:799:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:800:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:800:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:801:1: '}'
            {
             before(grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalModel__Group__5__Impl1655); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:826:1: rule__PhysicalSystem__Group__0 : rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 ;
    public final void rule__PhysicalSystem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:830:1: ( rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:831:2: rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__01698);
            rule__PhysicalSystem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__01701);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:838:1: rule__PhysicalSystem__Group__0__Impl : ( 'PhysicalSystem' ) ;
    public final void rule__PhysicalSystem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:842:1: ( ( 'PhysicalSystem' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:843:1: ( 'PhysicalSystem' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:843:1: ( 'PhysicalSystem' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:844:1: 'PhysicalSystem'
            {
             before(grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__PhysicalSystem__Group__0__Impl1729); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:857:1: rule__PhysicalSystem__Group__1 : rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 ;
    public final void rule__PhysicalSystem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:861:1: ( rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:862:2: rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__11760);
            rule__PhysicalSystem__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__11763);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:869:1: rule__PhysicalSystem__Group__1__Impl : ( ( rule__PhysicalSystem__NameAssignment_1 ) ) ;
    public final void rule__PhysicalSystem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:873:1: ( ( ( rule__PhysicalSystem__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:874:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:874:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:875:1: ( rule__PhysicalSystem__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:876:1: ( rule__PhysicalSystem__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:876:2: rule__PhysicalSystem__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl1790);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:886:1: rule__PhysicalSystem__Group__2 : rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 ;
    public final void rule__PhysicalSystem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:890:1: ( rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:891:2: rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__21820);
            rule__PhysicalSystem__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__21823);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:898:1: rule__PhysicalSystem__Group__2__Impl : ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) ;
    public final void rule__PhysicalSystem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:902:1: ( ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:904:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:905:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==38) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:905:2: rule__PhysicalSystem__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl1850);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:915:1: rule__PhysicalSystem__Group__3 : rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 ;
    public final void rule__PhysicalSystem__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:919:1: ( rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:920:2: rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__31881);
            rule__PhysicalSystem__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__31884);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:927:1: rule__PhysicalSystem__Group__3__Impl : ( '{' ) ;
    public final void rule__PhysicalSystem__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:931:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:932:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:932:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:933:1: '{'
            {
             before(grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalSystem__Group__3__Impl1912); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:946:1: rule__PhysicalSystem__Group__4 : rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 ;
    public final void rule__PhysicalSystem__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:950:1: ( rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:951:2: rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__41943);
            rule__PhysicalSystem__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__41946);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:958:1: rule__PhysicalSystem__Group__4__Impl : ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) ;
    public final void rule__PhysicalSystem__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:962:1: ( ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:963:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:963:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:964:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:965:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:965:2: rule__PhysicalSystem__NodeRefsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl1973);
            	    rule__PhysicalSystem__NodeRefsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:975:1: rule__PhysicalSystem__Group__5 : rule__PhysicalSystem__Group__5__Impl ;
    public final void rule__PhysicalSystem__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:979:1: ( rule__PhysicalSystem__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:980:2: rule__PhysicalSystem__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__52004);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:986:1: rule__PhysicalSystem__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalSystem__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:990:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:991:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:991:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:992:1: '}'
            {
             before(grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalSystem__Group__5__Impl2032); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1017:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1021:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1022:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__02075);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__02078);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1029:1: rule__NodeRef__Group__0__Impl : ( 'NodeRef' ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1033:1: ( ( 'NodeRef' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1034:1: ( 'NodeRef' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1034:1: ( 'NodeRef' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1035:1: 'NodeRef'
            {
             before(grammarAccess.getNodeRefAccess().getNodeRefKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__NodeRef__Group__0__Impl2106); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1048:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1052:1: ( rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1053:2: rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__12137);
            rule__NodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__12140);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1060:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__NameAssignment_1 ) ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1064:1: ( ( ( rule__NodeRef__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1065:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1065:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1066:1: ( rule__NodeRef__NameAssignment_1 )
            {
             before(grammarAccess.getNodeRefAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1067:1: ( rule__NodeRef__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1067:2: rule__NodeRef__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl2167);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1077:1: rule__NodeRef__Group__2 : rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 ;
    public final void rule__NodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1081:1: ( rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1082:2: rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__22197);
            rule__NodeRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__22200);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1089:1: rule__NodeRef__Group__2__Impl : ( ':' ) ;
    public final void rule__NodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1093:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1094:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1094:1: ( ':' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1095:1: ':'
            {
             before(grammarAccess.getNodeRefAccess().getColonKeyword_2()); 
            match(input,25,FOLLOW_25_in_rule__NodeRef__Group__2__Impl2228); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1108:1: rule__NodeRef__Group__3 : rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 ;
    public final void rule__NodeRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1112:1: ( rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1113:2: rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__32259);
            rule__NodeRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__32262);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1120:1: rule__NodeRef__Group__3__Impl : ( ( rule__NodeRef__TypeAssignment_3 ) ) ;
    public final void rule__NodeRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1124:1: ( ( ( rule__NodeRef__TypeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1125:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1125:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1126:1: ( rule__NodeRef__TypeAssignment_3 )
            {
             before(grammarAccess.getNodeRefAccess().getTypeAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1127:1: ( rule__NodeRef__TypeAssignment_3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1127:2: rule__NodeRef__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl2289);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1137:1: rule__NodeRef__Group__4 : rule__NodeRef__Group__4__Impl ;
    public final void rule__NodeRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1141:1: ( rule__NodeRef__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1142:2: rule__NodeRef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__42319);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1148:1: rule__NodeRef__Group__4__Impl : ( ( rule__NodeRef__DocuAssignment_4 )? ) ;
    public final void rule__NodeRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1152:1: ( ( ( rule__NodeRef__DocuAssignment_4 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1153:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1153:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1154:1: ( rule__NodeRef__DocuAssignment_4 )?
            {
             before(grammarAccess.getNodeRefAccess().getDocuAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1155:1: ( rule__NodeRef__DocuAssignment_4 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==38) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1155:2: rule__NodeRef__DocuAssignment_4
                    {
                    pushFollow(FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl2346);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1175:1: rule__NodeClass__Group__0 : rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 ;
    public final void rule__NodeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1179:1: ( rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1180:2: rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__02387);
            rule__NodeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__02390);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1187:1: rule__NodeClass__Group__0__Impl : ( 'NodeClass' ) ;
    public final void rule__NodeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1191:1: ( ( 'NodeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1192:1: ( 'NodeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1192:1: ( 'NodeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1193:1: 'NodeClass'
            {
             before(grammarAccess.getNodeClassAccess().getNodeClassKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__NodeClass__Group__0__Impl2418); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1206:1: rule__NodeClass__Group__1 : rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 ;
    public final void rule__NodeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1210:1: ( rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1211:2: rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__12449);
            rule__NodeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__12452);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1218:1: rule__NodeClass__Group__1__Impl : ( ( rule__NodeClass__NameAssignment_1 ) ) ;
    public final void rule__NodeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1222:1: ( ( ( rule__NodeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1223:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1223:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1224:1: ( rule__NodeClass__NameAssignment_1 )
            {
             before(grammarAccess.getNodeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1225:1: ( rule__NodeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1225:2: rule__NodeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl2479);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1235:1: rule__NodeClass__Group__2 : rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 ;
    public final void rule__NodeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1239:1: ( rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1240:2: rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__22509);
            rule__NodeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__22512);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1247:1: rule__NodeClass__Group__2__Impl : ( ( rule__NodeClass__DocuAssignment_2 )? ) ;
    public final void rule__NodeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1251:1: ( ( ( rule__NodeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1252:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1252:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1253:1: ( rule__NodeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getNodeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1254:1: ( rule__NodeClass__DocuAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1254:2: rule__NodeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl2539);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1264:1: rule__NodeClass__Group__3 : rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 ;
    public final void rule__NodeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1268:1: ( rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1269:2: rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__32570);
            rule__NodeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__32573);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1276:1: rule__NodeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__NodeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1280:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1281:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1281:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1282:1: '{'
            {
             before(grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__NodeClass__Group__3__Impl2601); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1295:1: rule__NodeClass__Group__4 : rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 ;
    public final void rule__NodeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1299:1: ( rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1300:2: rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__42632);
            rule__NodeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__42635);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1307:1: rule__NodeClass__Group__4__Impl : ( 'runtime' ) ;
    public final void rule__NodeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1311:1: ( ( 'runtime' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( 'runtime' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( 'runtime' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1313:1: 'runtime'
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__NodeClass__Group__4__Impl2663); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1326:1: rule__NodeClass__Group__5 : rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 ;
    public final void rule__NodeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1330:1: ( rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1331:2: rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52694);
            rule__NodeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52697);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1338:1: rule__NodeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1342:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1343:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1343:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1344:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__5__Impl2725); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1357:1: rule__NodeClass__Group__6 : rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7 ;
    public final void rule__NodeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1361:1: ( rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1362:2: rule__NodeClass__Group__6__Impl rule__NodeClass__Group__7
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62756);
            rule__NodeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__7_in_rule__NodeClass__Group__62759);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1369:1: rule__NodeClass__Group__6__Impl : ( ( rule__NodeClass__RuntimeAssignment_6 ) ) ;
    public final void rule__NodeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1373:1: ( ( ( rule__NodeClass__RuntimeAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1374:1: ( ( rule__NodeClass__RuntimeAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1374:1: ( ( rule__NodeClass__RuntimeAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1375:1: ( rule__NodeClass__RuntimeAssignment_6 )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1376:1: ( rule__NodeClass__RuntimeAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1376:2: rule__NodeClass__RuntimeAssignment_6
            {
            pushFollow(FOLLOW_rule__NodeClass__RuntimeAssignment_6_in_rule__NodeClass__Group__6__Impl2786);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1386:1: rule__NodeClass__Group__7 : rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8 ;
    public final void rule__NodeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1390:1: ( rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1391:2: rule__NodeClass__Group__7__Impl rule__NodeClass__Group__8
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__7__Impl_in_rule__NodeClass__Group__72816);
            rule__NodeClass__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__8_in_rule__NodeClass__Group__72819);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1398:1: rule__NodeClass__Group__7__Impl : ( 'priomin' ) ;
    public final void rule__NodeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1402:1: ( ( 'priomin' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1403:1: ( 'priomin' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1403:1: ( 'priomin' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1404:1: 'priomin'
            {
             before(grammarAccess.getNodeClassAccess().getPriominKeyword_7()); 
            match(input,29,FOLLOW_29_in_rule__NodeClass__Group__7__Impl2847); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1417:1: rule__NodeClass__Group__8 : rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9 ;
    public final void rule__NodeClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1421:1: ( rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1422:2: rule__NodeClass__Group__8__Impl rule__NodeClass__Group__9
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__8__Impl_in_rule__NodeClass__Group__82878);
            rule__NodeClass__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__9_in_rule__NodeClass__Group__82881);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1429:1: rule__NodeClass__Group__8__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1433:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1434:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1434:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1435:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_8()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__8__Impl2909); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1448:1: rule__NodeClass__Group__9 : rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10 ;
    public final void rule__NodeClass__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1452:1: ( rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1453:2: rule__NodeClass__Group__9__Impl rule__NodeClass__Group__10
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__9__Impl_in_rule__NodeClass__Group__92940);
            rule__NodeClass__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__10_in_rule__NodeClass__Group__92943);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1460:1: rule__NodeClass__Group__9__Impl : ( ( rule__NodeClass__PriominAssignment_9 ) ) ;
    public final void rule__NodeClass__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1464:1: ( ( ( rule__NodeClass__PriominAssignment_9 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1465:1: ( ( rule__NodeClass__PriominAssignment_9 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1465:1: ( ( rule__NodeClass__PriominAssignment_9 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1466:1: ( rule__NodeClass__PriominAssignment_9 )
            {
             before(grammarAccess.getNodeClassAccess().getPriominAssignment_9()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1467:1: ( rule__NodeClass__PriominAssignment_9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1467:2: rule__NodeClass__PriominAssignment_9
            {
            pushFollow(FOLLOW_rule__NodeClass__PriominAssignment_9_in_rule__NodeClass__Group__9__Impl2970);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1477:1: rule__NodeClass__Group__10 : rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11 ;
    public final void rule__NodeClass__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1481:1: ( rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1482:2: rule__NodeClass__Group__10__Impl rule__NodeClass__Group__11
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__10__Impl_in_rule__NodeClass__Group__103000);
            rule__NodeClass__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__11_in_rule__NodeClass__Group__103003);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1489:1: rule__NodeClass__Group__10__Impl : ( 'priomax' ) ;
    public final void rule__NodeClass__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1493:1: ( ( 'priomax' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1494:1: ( 'priomax' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1494:1: ( 'priomax' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1495:1: 'priomax'
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxKeyword_10()); 
            match(input,30,FOLLOW_30_in_rule__NodeClass__Group__10__Impl3031); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1508:1: rule__NodeClass__Group__11 : rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12 ;
    public final void rule__NodeClass__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1512:1: ( rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1513:2: rule__NodeClass__Group__11__Impl rule__NodeClass__Group__12
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__11__Impl_in_rule__NodeClass__Group__113062);
            rule__NodeClass__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__12_in_rule__NodeClass__Group__113065);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1520:1: rule__NodeClass__Group__11__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1524:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1525:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1525:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1526:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_11()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group__11__Impl3093); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1539:1: rule__NodeClass__Group__12 : rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13 ;
    public final void rule__NodeClass__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1543:1: ( rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1544:2: rule__NodeClass__Group__12__Impl rule__NodeClass__Group__13
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__12__Impl_in_rule__NodeClass__Group__123124);
            rule__NodeClass__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__13_in_rule__NodeClass__Group__123127);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1551:1: rule__NodeClass__Group__12__Impl : ( ( rule__NodeClass__PriomaxAssignment_12 ) ) ;
    public final void rule__NodeClass__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1555:1: ( ( ( rule__NodeClass__PriomaxAssignment_12 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1556:1: ( ( rule__NodeClass__PriomaxAssignment_12 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1556:1: ( ( rule__NodeClass__PriomaxAssignment_12 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1557:1: ( rule__NodeClass__PriomaxAssignment_12 )
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxAssignment_12()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1558:1: ( rule__NodeClass__PriomaxAssignment_12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1558:2: rule__NodeClass__PriomaxAssignment_12
            {
            pushFollow(FOLLOW_rule__NodeClass__PriomaxAssignment_12_in_rule__NodeClass__Group__12__Impl3154);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1568:1: rule__NodeClass__Group__13 : rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14 ;
    public final void rule__NodeClass__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1572:1: ( rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1573:2: rule__NodeClass__Group__13__Impl rule__NodeClass__Group__14
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__13__Impl_in_rule__NodeClass__Group__133184);
            rule__NodeClass__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__14_in_rule__NodeClass__Group__133187);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1580:1: rule__NodeClass__Group__13__Impl : ( ( rule__NodeClass__ThreadsAssignment_13 )* ) ;
    public final void rule__NodeClass__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1584:1: ( ( ( rule__NodeClass__ThreadsAssignment_13 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1585:1: ( ( rule__NodeClass__ThreadsAssignment_13 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1585:1: ( ( rule__NodeClass__ThreadsAssignment_13 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1586:1: ( rule__NodeClass__ThreadsAssignment_13 )*
            {
             before(grammarAccess.getNodeClassAccess().getThreadsAssignment_13()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1587:1: ( rule__NodeClass__ThreadsAssignment_13 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==11||LA14_0==48) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1587:2: rule__NodeClass__ThreadsAssignment_13
            	    {
            	    pushFollow(FOLLOW_rule__NodeClass__ThreadsAssignment_13_in_rule__NodeClass__Group__13__Impl3214);
            	    rule__NodeClass__ThreadsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1597:1: rule__NodeClass__Group__14 : rule__NodeClass__Group__14__Impl ;
    public final void rule__NodeClass__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1601:1: ( rule__NodeClass__Group__14__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1602:2: rule__NodeClass__Group__14__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__14__Impl_in_rule__NodeClass__Group__143245);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1608:1: rule__NodeClass__Group__14__Impl : ( '}' ) ;
    public final void rule__NodeClass__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1612:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1613:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1613:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1614:1: '}'
            {
             before(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_14()); 
            match(input,22,FOLLOW_22_in_rule__NodeClass__Group__14__Impl3273); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1657:1: rule__PhysicalThread__Group__0 : rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 ;
    public final void rule__PhysicalThread__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1661:1: ( rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1662:2: rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03334);
            rule__PhysicalThread__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03337);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1669:1: rule__PhysicalThread__Group__0__Impl : ( ( rule__PhysicalThread__Alternatives_0 ) ) ;
    public final void rule__PhysicalThread__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1673:1: ( ( ( rule__PhysicalThread__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1674:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1674:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1675:1: ( rule__PhysicalThread__Alternatives_0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1676:1: ( rule__PhysicalThread__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1676:2: rule__PhysicalThread__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3364);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1686:1: rule__PhysicalThread__Group__1 : rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 ;
    public final void rule__PhysicalThread__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1690:1: ( rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1691:2: rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13394);
            rule__PhysicalThread__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13397);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1698:1: rule__PhysicalThread__Group__1__Impl : ( ( rule__PhysicalThread__NameAssignment_1 ) ) ;
    public final void rule__PhysicalThread__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1702:1: ( ( ( rule__PhysicalThread__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1703:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1703:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1704:1: ( rule__PhysicalThread__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1705:1: ( rule__PhysicalThread__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1705:2: rule__PhysicalThread__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3424);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1715:1: rule__PhysicalThread__Group__2 : rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 ;
    public final void rule__PhysicalThread__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1719:1: ( rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1720:2: rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23454);
            rule__PhysicalThread__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23457);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1727:1: rule__PhysicalThread__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalThread__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1731:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1732:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1732:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1733:1: '{'
            {
             before(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3485); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1746:1: rule__PhysicalThread__Group__3 : rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 ;
    public final void rule__PhysicalThread__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1750:1: ( rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1751:2: rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33516);
            rule__PhysicalThread__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33519);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1758:1: rule__PhysicalThread__Group__3__Impl : ( 'execmode' ) ;
    public final void rule__PhysicalThread__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1762:1: ( ( 'execmode' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1763:1: ( 'execmode' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1763:1: ( 'execmode' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1764:1: 'execmode'
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__PhysicalThread__Group__3__Impl3547); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1777:1: rule__PhysicalThread__Group__4 : rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5 ;
    public final void rule__PhysicalThread__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1781:1: ( rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1782:2: rule__PhysicalThread__Group__4__Impl rule__PhysicalThread__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43578);
            rule__PhysicalThread__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__5_in_rule__PhysicalThread__Group__43581);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1789:1: rule__PhysicalThread__Group__4__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1793:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1794:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1794:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1795:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__4__Impl3609); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1808:1: rule__PhysicalThread__Group__5 : rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6 ;
    public final void rule__PhysicalThread__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1812:1: ( rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1813:2: rule__PhysicalThread__Group__5__Impl rule__PhysicalThread__Group__6
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__5__Impl_in_rule__PhysicalThread__Group__53640);
            rule__PhysicalThread__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__6_in_rule__PhysicalThread__Group__53643);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1820:1: rule__PhysicalThread__Group__5__Impl : ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) ) ;
    public final void rule__PhysicalThread__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1824:1: ( ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1825:1: ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1825:1: ( ( rule__PhysicalThread__ExecmodeAssignment_5 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1826:1: ( rule__PhysicalThread__ExecmodeAssignment_5 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_5()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1827:1: ( rule__PhysicalThread__ExecmodeAssignment_5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1827:2: rule__PhysicalThread__ExecmodeAssignment_5
            {
            pushFollow(FOLLOW_rule__PhysicalThread__ExecmodeAssignment_5_in_rule__PhysicalThread__Group__5__Impl3670);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1837:1: rule__PhysicalThread__Group__6 : rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7 ;
    public final void rule__PhysicalThread__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1841:1: ( rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1842:2: rule__PhysicalThread__Group__6__Impl rule__PhysicalThread__Group__7
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__6__Impl_in_rule__PhysicalThread__Group__63700);
            rule__PhysicalThread__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__7_in_rule__PhysicalThread__Group__63703);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1849:1: rule__PhysicalThread__Group__6__Impl : ( ( rule__PhysicalThread__Group_6__0 )? ) ;
    public final void rule__PhysicalThread__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1853:1: ( ( ( rule__PhysicalThread__Group_6__0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1854:1: ( ( rule__PhysicalThread__Group_6__0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1854:1: ( ( rule__PhysicalThread__Group_6__0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1855:1: ( rule__PhysicalThread__Group_6__0 )?
            {
             before(grammarAccess.getPhysicalThreadAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1856:1: ( rule__PhysicalThread__Group_6__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1856:2: rule__PhysicalThread__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_6__0_in_rule__PhysicalThread__Group__6__Impl3730);
                    rule__PhysicalThread__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicalThreadAccess().getGroup_6()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1866:1: rule__PhysicalThread__Group__7 : rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8 ;
    public final void rule__PhysicalThread__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1870:1: ( rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1871:2: rule__PhysicalThread__Group__7__Impl rule__PhysicalThread__Group__8
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__7__Impl_in_rule__PhysicalThread__Group__73761);
            rule__PhysicalThread__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__8_in_rule__PhysicalThread__Group__73764);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1878:1: rule__PhysicalThread__Group__7__Impl : ( 'prio' ) ;
    public final void rule__PhysicalThread__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1882:1: ( ( 'prio' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1883:1: ( 'prio' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1883:1: ( 'prio' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1884:1: 'prio'
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_7()); 
            match(input,32,FOLLOW_32_in_rule__PhysicalThread__Group__7__Impl3792); 
             after(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_7()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1897:1: rule__PhysicalThread__Group__8 : rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9 ;
    public final void rule__PhysicalThread__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1901:1: ( rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1902:2: rule__PhysicalThread__Group__8__Impl rule__PhysicalThread__Group__9
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__8__Impl_in_rule__PhysicalThread__Group__83823);
            rule__PhysicalThread__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__9_in_rule__PhysicalThread__Group__83826);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1909:1: rule__PhysicalThread__Group__8__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1913:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1914:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1914:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1915:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_8()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__8__Impl3854); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_8()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1928:1: rule__PhysicalThread__Group__9 : rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10 ;
    public final void rule__PhysicalThread__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1932:1: ( rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1933:2: rule__PhysicalThread__Group__9__Impl rule__PhysicalThread__Group__10
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__9__Impl_in_rule__PhysicalThread__Group__93885);
            rule__PhysicalThread__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__10_in_rule__PhysicalThread__Group__93888);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1940:1: rule__PhysicalThread__Group__9__Impl : ( ( rule__PhysicalThread__PrioAssignment_9 ) ) ;
    public final void rule__PhysicalThread__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1944:1: ( ( ( rule__PhysicalThread__PrioAssignment_9 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1945:1: ( ( rule__PhysicalThread__PrioAssignment_9 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1945:1: ( ( rule__PhysicalThread__PrioAssignment_9 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1946:1: ( rule__PhysicalThread__PrioAssignment_9 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_9()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1947:1: ( rule__PhysicalThread__PrioAssignment_9 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1947:2: rule__PhysicalThread__PrioAssignment_9
            {
            pushFollow(FOLLOW_rule__PhysicalThread__PrioAssignment_9_in_rule__PhysicalThread__Group__9__Impl3915);
            rule__PhysicalThread__PrioAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_9()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1957:1: rule__PhysicalThread__Group__10 : rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11 ;
    public final void rule__PhysicalThread__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1961:1: ( rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1962:2: rule__PhysicalThread__Group__10__Impl rule__PhysicalThread__Group__11
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__10__Impl_in_rule__PhysicalThread__Group__103945);
            rule__PhysicalThread__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__11_in_rule__PhysicalThread__Group__103948);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1969:1: rule__PhysicalThread__Group__10__Impl : ( 'stacksize' ) ;
    public final void rule__PhysicalThread__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1973:1: ( ( 'stacksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1974:1: ( 'stacksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1974:1: ( 'stacksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1975:1: 'stacksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_10()); 
            match(input,33,FOLLOW_33_in_rule__PhysicalThread__Group__10__Impl3976); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_10()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1988:1: rule__PhysicalThread__Group__11 : rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12 ;
    public final void rule__PhysicalThread__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1992:1: ( rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1993:2: rule__PhysicalThread__Group__11__Impl rule__PhysicalThread__Group__12
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__11__Impl_in_rule__PhysicalThread__Group__114007);
            rule__PhysicalThread__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__12_in_rule__PhysicalThread__Group__114010);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2000:1: rule__PhysicalThread__Group__11__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2004:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2005:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2005:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2006:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_11()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__11__Impl4038); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_11()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2019:1: rule__PhysicalThread__Group__12 : rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13 ;
    public final void rule__PhysicalThread__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2023:1: ( rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2024:2: rule__PhysicalThread__Group__12__Impl rule__PhysicalThread__Group__13
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__12__Impl_in_rule__PhysicalThread__Group__124069);
            rule__PhysicalThread__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__13_in_rule__PhysicalThread__Group__124072);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2031:1: rule__PhysicalThread__Group__12__Impl : ( ( rule__PhysicalThread__StacksizeAssignment_12 ) ) ;
    public final void rule__PhysicalThread__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2035:1: ( ( ( rule__PhysicalThread__StacksizeAssignment_12 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2036:1: ( ( rule__PhysicalThread__StacksizeAssignment_12 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2036:1: ( ( rule__PhysicalThread__StacksizeAssignment_12 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2037:1: ( rule__PhysicalThread__StacksizeAssignment_12 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_12()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2038:1: ( rule__PhysicalThread__StacksizeAssignment_12 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2038:2: rule__PhysicalThread__StacksizeAssignment_12
            {
            pushFollow(FOLLOW_rule__PhysicalThread__StacksizeAssignment_12_in_rule__PhysicalThread__Group__12__Impl4099);
            rule__PhysicalThread__StacksizeAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_12()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2048:1: rule__PhysicalThread__Group__13 : rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14 ;
    public final void rule__PhysicalThread__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2052:1: ( rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2053:2: rule__PhysicalThread__Group__13__Impl rule__PhysicalThread__Group__14
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__13__Impl_in_rule__PhysicalThread__Group__134129);
            rule__PhysicalThread__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__14_in_rule__PhysicalThread__Group__134132);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2060:1: rule__PhysicalThread__Group__13__Impl : ( 'msgblocksize' ) ;
    public final void rule__PhysicalThread__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2064:1: ( ( 'msgblocksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2065:1: ( 'msgblocksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2065:1: ( 'msgblocksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2066:1: 'msgblocksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_13()); 
            match(input,34,FOLLOW_34_in_rule__PhysicalThread__Group__13__Impl4160); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_13()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2079:1: rule__PhysicalThread__Group__14 : rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15 ;
    public final void rule__PhysicalThread__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2083:1: ( rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2084:2: rule__PhysicalThread__Group__14__Impl rule__PhysicalThread__Group__15
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__14__Impl_in_rule__PhysicalThread__Group__144191);
            rule__PhysicalThread__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__15_in_rule__PhysicalThread__Group__144194);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2091:1: rule__PhysicalThread__Group__14__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2095:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2096:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2096:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2097:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_14()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__14__Impl4222); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_14()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2110:1: rule__PhysicalThread__Group__15 : rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16 ;
    public final void rule__PhysicalThread__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2114:1: ( rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2115:2: rule__PhysicalThread__Group__15__Impl rule__PhysicalThread__Group__16
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__15__Impl_in_rule__PhysicalThread__Group__154253);
            rule__PhysicalThread__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__16_in_rule__PhysicalThread__Group__154256);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2122:1: rule__PhysicalThread__Group__15__Impl : ( ( rule__PhysicalThread__MsgblocksizeAssignment_15 ) ) ;
    public final void rule__PhysicalThread__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2126:1: ( ( ( rule__PhysicalThread__MsgblocksizeAssignment_15 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_15 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_15 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2128:1: ( rule__PhysicalThread__MsgblocksizeAssignment_15 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_15()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:1: ( rule__PhysicalThread__MsgblocksizeAssignment_15 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:2: rule__PhysicalThread__MsgblocksizeAssignment_15
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_15_in_rule__PhysicalThread__Group__15__Impl4283);
            rule__PhysicalThread__MsgblocksizeAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_15()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2139:1: rule__PhysicalThread__Group__16 : rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17 ;
    public final void rule__PhysicalThread__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2143:1: ( rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2144:2: rule__PhysicalThread__Group__16__Impl rule__PhysicalThread__Group__17
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__16__Impl_in_rule__PhysicalThread__Group__164313);
            rule__PhysicalThread__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__17_in_rule__PhysicalThread__Group__164316);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2151:1: rule__PhysicalThread__Group__16__Impl : ( 'msgpoolsize' ) ;
    public final void rule__PhysicalThread__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2155:1: ( ( 'msgpoolsize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2156:1: ( 'msgpoolsize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2156:1: ( 'msgpoolsize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2157:1: 'msgpoolsize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_16()); 
            match(input,35,FOLLOW_35_in_rule__PhysicalThread__Group__16__Impl4344); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_16()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2170:1: rule__PhysicalThread__Group__17 : rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18 ;
    public final void rule__PhysicalThread__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2174:1: ( rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2175:2: rule__PhysicalThread__Group__17__Impl rule__PhysicalThread__Group__18
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__17__Impl_in_rule__PhysicalThread__Group__174375);
            rule__PhysicalThread__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__18_in_rule__PhysicalThread__Group__174378);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2182:1: rule__PhysicalThread__Group__17__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2186:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2187:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2187:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2188:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_17()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group__17__Impl4406); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_17()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2201:1: rule__PhysicalThread__Group__18 : rule__PhysicalThread__Group__18__Impl rule__PhysicalThread__Group__19 ;
    public final void rule__PhysicalThread__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2205:1: ( rule__PhysicalThread__Group__18__Impl rule__PhysicalThread__Group__19 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2206:2: rule__PhysicalThread__Group__18__Impl rule__PhysicalThread__Group__19
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__18__Impl_in_rule__PhysicalThread__Group__184437);
            rule__PhysicalThread__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__19_in_rule__PhysicalThread__Group__184440);
            rule__PhysicalThread__Group__19();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2213:1: rule__PhysicalThread__Group__18__Impl : ( ( rule__PhysicalThread__MsgpoolsizeAssignment_18 ) ) ;
    public final void rule__PhysicalThread__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2217:1: ( ( ( rule__PhysicalThread__MsgpoolsizeAssignment_18 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2218:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_18 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2218:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_18 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2219:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_18 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_18()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2220:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_18 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2220:2: rule__PhysicalThread__MsgpoolsizeAssignment_18
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_18_in_rule__PhysicalThread__Group__18__Impl4467);
            rule__PhysicalThread__MsgpoolsizeAssignment_18();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_18()); 

            }


            }

        }
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


    // $ANTLR start "rule__PhysicalThread__Group__19"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2230:1: rule__PhysicalThread__Group__19 : rule__PhysicalThread__Group__19__Impl ;
    public final void rule__PhysicalThread__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2234:1: ( rule__PhysicalThread__Group__19__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2235:2: rule__PhysicalThread__Group__19__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__19__Impl_in_rule__PhysicalThread__Group__194497);
            rule__PhysicalThread__Group__19__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__19"


    // $ANTLR start "rule__PhysicalThread__Group__19__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2241:1: rule__PhysicalThread__Group__19__Impl : ( '}' ) ;
    public final void rule__PhysicalThread__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2245:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2246:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2246:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2247:1: '}'
            {
             before(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_19()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalThread__Group__19__Impl4525); 
             after(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__19__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_6__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2300:1: rule__PhysicalThread__Group_6__0 : rule__PhysicalThread__Group_6__0__Impl rule__PhysicalThread__Group_6__1 ;
    public final void rule__PhysicalThread__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2304:1: ( rule__PhysicalThread__Group_6__0__Impl rule__PhysicalThread__Group_6__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2305:2: rule__PhysicalThread__Group_6__0__Impl rule__PhysicalThread__Group_6__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_6__0__Impl_in_rule__PhysicalThread__Group_6__04596);
            rule__PhysicalThread__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_6__1_in_rule__PhysicalThread__Group_6__04599);
            rule__PhysicalThread__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__0"


    // $ANTLR start "rule__PhysicalThread__Group_6__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2312:1: rule__PhysicalThread__Group_6__0__Impl : ( 'interval' ) ;
    public final void rule__PhysicalThread__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2316:1: ( ( 'interval' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2317:1: ( 'interval' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2317:1: ( 'interval' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2318:1: 'interval'
            {
             before(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_6_0()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_6__0__Impl4627); 
             after(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_6__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2331:1: rule__PhysicalThread__Group_6__1 : rule__PhysicalThread__Group_6__1__Impl rule__PhysicalThread__Group_6__2 ;
    public final void rule__PhysicalThread__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2335:1: ( rule__PhysicalThread__Group_6__1__Impl rule__PhysicalThread__Group_6__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2336:2: rule__PhysicalThread__Group_6__1__Impl rule__PhysicalThread__Group_6__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_6__1__Impl_in_rule__PhysicalThread__Group_6__14658);
            rule__PhysicalThread__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_6__2_in_rule__PhysicalThread__Group_6__14661);
            rule__PhysicalThread__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__1"


    // $ANTLR start "rule__PhysicalThread__Group_6__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2343:1: rule__PhysicalThread__Group_6__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2347:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2348:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2348:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2349:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_6_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_6__1__Impl4689); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_6__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2362:1: rule__PhysicalThread__Group_6__2 : rule__PhysicalThread__Group_6__2__Impl ;
    public final void rule__PhysicalThread__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2366:1: ( rule__PhysicalThread__Group_6__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2367:2: rule__PhysicalThread__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_6__2__Impl_in_rule__PhysicalThread__Group_6__24720);
            rule__PhysicalThread__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__2"


    // $ANTLR start "rule__PhysicalThread__Group_6__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2373:1: rule__PhysicalThread__Group_6__2__Impl : ( ( rule__PhysicalThread__TimeAssignment_6_2 ) ) ;
    public final void rule__PhysicalThread__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2377:1: ( ( ( rule__PhysicalThread__TimeAssignment_6_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2378:1: ( ( rule__PhysicalThread__TimeAssignment_6_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2378:1: ( ( rule__PhysicalThread__TimeAssignment_6_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2379:1: ( rule__PhysicalThread__TimeAssignment_6_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_6_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2380:1: ( rule__PhysicalThread__TimeAssignment_6_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2380:2: rule__PhysicalThread__TimeAssignment_6_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__TimeAssignment_6_2_in_rule__PhysicalThread__Group_6__2__Impl4747);
            rule__PhysicalThread__TimeAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_6__2__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2396:1: rule__RuntimeClass__Group__0 : rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 ;
    public final void rule__RuntimeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2400:1: ( rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2401:2: rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04783);
            rule__RuntimeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04786);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2408:1: rule__RuntimeClass__Group__0__Impl : ( 'RuntimeClass' ) ;
    public final void rule__RuntimeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2412:1: ( ( 'RuntimeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2413:1: ( 'RuntimeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2413:1: ( 'RuntimeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2414:1: 'RuntimeClass'
            {
             before(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__RuntimeClass__Group__0__Impl4814); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2427:1: rule__RuntimeClass__Group__1 : rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 ;
    public final void rule__RuntimeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2431:1: ( rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2432:2: rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14845);
            rule__RuntimeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14848);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2439:1: rule__RuntimeClass__Group__1__Impl : ( ( rule__RuntimeClass__NameAssignment_1 ) ) ;
    public final void rule__RuntimeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2443:1: ( ( ( rule__RuntimeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2444:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2444:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2445:1: ( rule__RuntimeClass__NameAssignment_1 )
            {
             before(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2446:1: ( rule__RuntimeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2446:2: rule__RuntimeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4875);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2456:1: rule__RuntimeClass__Group__2 : rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 ;
    public final void rule__RuntimeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2460:1: ( rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2461:2: rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24905);
            rule__RuntimeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24908);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2468:1: rule__RuntimeClass__Group__2__Impl : ( ( rule__RuntimeClass__DocuAssignment_2 )? ) ;
    public final void rule__RuntimeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2472:1: ( ( ( rule__RuntimeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2473:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2473:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2474:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2475:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2475:2: rule__RuntimeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4935);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2485:1: rule__RuntimeClass__Group__3 : rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 ;
    public final void rule__RuntimeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2489:1: ( rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2490:2: rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__34966);
            rule__RuntimeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__34969);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2497:1: rule__RuntimeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__RuntimeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2501:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2502:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2502:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2503:1: '{'
            {
             before(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl4997); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2516:1: rule__RuntimeClass__Group__4 : rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 ;
    public final void rule__RuntimeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2520:1: ( rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2521:2: rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__45028);
            rule__RuntimeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__45031);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2528:1: rule__RuntimeClass__Group__4__Impl : ( 'model' ) ;
    public final void rule__RuntimeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2532:1: ( ( 'model' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2533:1: ( 'model' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2533:1: ( 'model' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2534:1: 'model'
            {
             before(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl5059); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2547:1: rule__RuntimeClass__Group__5 : rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 ;
    public final void rule__RuntimeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2551:1: ( rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2552:2: rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__55090);
            rule__RuntimeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__55093);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2559:1: rule__RuntimeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__RuntimeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2563:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2564:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2564:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2565:1: '='
            {
             before(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl5121); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2578:1: rule__RuntimeClass__Group__6 : rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 ;
    public final void rule__RuntimeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2582:1: ( rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2583:2: rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__65152);
            rule__RuntimeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__65155);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2590:1: rule__RuntimeClass__Group__6__Impl : ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) ;
    public final void rule__RuntimeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2594:1: ( ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2595:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2595:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2596:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2597:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2597:2: rule__RuntimeClass__ThreadModelAssignment_6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl5182);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2607:1: rule__RuntimeClass__Group__7 : rule__RuntimeClass__Group__7__Impl ;
    public final void rule__RuntimeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2611:1: ( rule__RuntimeClass__Group__7__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2612:2: rule__RuntimeClass__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__75212);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2618:1: rule__RuntimeClass__Group__7__Impl : ( '}' ) ;
    public final void rule__RuntimeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2622:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2623:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2623:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2624:1: '}'
            {
             before(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 
            match(input,22,FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl5240); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2653:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2657:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2658:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05287);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05290);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2665:1: rule__Documentation__Group__0__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2669:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2670:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2670:1: ( '[' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2671:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Documentation__Group__0__Impl5318); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2684:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2688:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2689:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15349);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15352);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2696:1: rule__Documentation__Group__1__Impl : ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2700:1: ( ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2701:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2701:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2702:1: ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2702:1: ( ( rule__Documentation__TextAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2703:1: ( rule__Documentation__TextAssignment_1 )
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2704:1: ( rule__Documentation__TextAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2704:2: rule__Documentation__TextAssignment_1
            {
            pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5381);
            rule__Documentation__TextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 

            }

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2707:1: ( ( rule__Documentation__TextAssignment_1 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2708:1: ( rule__Documentation__TextAssignment_1 )*
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2709:1: ( rule__Documentation__TextAssignment_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2709:2: rule__Documentation__TextAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5393);
            	    rule__Documentation__TextAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2720:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2724:1: ( rule__Documentation__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2725:2: rule__Documentation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25426);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2731:1: rule__Documentation__Group__2__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2735:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2736:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2736:1: ( ']' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2737:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__Documentation__Group__2__Impl5454); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2756:1: rule__PRIO__Group__0 : rule__PRIO__Group__0__Impl rule__PRIO__Group__1 ;
    public final void rule__PRIO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2760:1: ( rule__PRIO__Group__0__Impl rule__PRIO__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2761:2: rule__PRIO__Group__0__Impl rule__PRIO__Group__1
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05491);
            rule__PRIO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05494);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2768:1: rule__PRIO__Group__0__Impl : ( ( rule__PRIO__Alternatives_0 )? ) ;
    public final void rule__PRIO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2772:1: ( ( ( rule__PRIO__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2773:1: ( ( rule__PRIO__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2773:1: ( ( rule__PRIO__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2774:1: ( rule__PRIO__Alternatives_0 )?
            {
             before(grammarAccess.getPRIOAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2775:1: ( rule__PRIO__Alternatives_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=12 && LA18_0<=13)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2775:2: rule__PRIO__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5521);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2785:1: rule__PRIO__Group__1 : rule__PRIO__Group__1__Impl ;
    public final void rule__PRIO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2789:1: ( rule__PRIO__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2790:2: rule__PRIO__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15552);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2796:1: rule__PRIO__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__PRIO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2800:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2801:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2801:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2802:1: RULE_INT
            {
             before(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5579); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2817:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2821:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2822:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05612);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05615);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2829:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2833:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2834:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2834:1: ( 'import' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2835:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__Import__Group__0__Impl5643); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2848:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2852:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2853:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15674);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15677);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2860:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2864:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2866:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2867:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2867:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5704);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2877:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2881:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2882:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25734);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2888:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2892:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2893:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2893:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2894:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5761);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2911:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2915:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2916:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05797);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05800);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2923:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2927:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2928:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2928:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2929:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2930:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2930:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5827);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2940:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2944:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2945:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15857);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2951:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2955:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2956:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2956:1: ( 'from' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2957:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,41,FOLLOW_41_in_rule__Import__Group_1_0__1__Impl5885); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2974:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2978:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2979:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05920);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05923);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2986:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2990:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2991:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2991:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2992:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5950);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3003:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3007:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3008:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15979);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3014:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3018:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3019:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3019:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3020:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3021:1: ( '.*' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==42) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3022:2: '.*'
                    {
                    match(input,42,FOLLOW_42_in_rule__ImportedFQN__Group__1__Impl6008); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3037:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3041:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3042:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__06045);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__06048);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3049:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3053:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3054:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3054:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3055:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6075); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3066:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3070:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3071:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16104);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3077:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3081:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3082:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3082:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3083:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3084:1: ( rule__FQN__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==43) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3084:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6131);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3098:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3102:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3103:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06166);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06169);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3110:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3114:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3115:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3115:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3116:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,43,FOLLOW_43_in_rule__FQN__Group_1__0__Impl6197); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3129:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3133:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3134:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16228);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3140:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3144:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3145:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3145:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3146:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6255); 
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


    // $ANTLR start "rule__TIME__Group_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3161:1: rule__TIME__Group_0__0 : rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 ;
    public final void rule__TIME__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3165:1: ( rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3166:2: rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__06288);
            rule__TIME__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__06291);
            rule__TIME__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0"


    // $ANTLR start "rule__TIME__Group_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3173:1: rule__TIME__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3177:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3178:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3178:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3179:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl6318); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0__Impl"


    // $ANTLR start "rule__TIME__Group_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3190:1: rule__TIME__Group_0__1 : rule__TIME__Group_0__1__Impl ;
    public final void rule__TIME__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3194:1: ( rule__TIME__Group_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3195:2: rule__TIME__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__16347);
            rule__TIME__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1"


    // $ANTLR start "rule__TIME__Group_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3201:1: rule__TIME__Group_0__1__Impl : ( 's' ) ;
    public final void rule__TIME__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3205:1: ( ( 's' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3206:1: ( 's' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3206:1: ( 's' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3207:1: 's'
            {
             before(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
            match(input,44,FOLLOW_44_in_rule__TIME__Group_0__1__Impl6375); 
             after(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1__Impl"


    // $ANTLR start "rule__TIME__Group_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3224:1: rule__TIME__Group_1__0 : rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 ;
    public final void rule__TIME__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3228:1: ( rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3229:2: rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__06410);
            rule__TIME__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__06413);
            rule__TIME__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0"


    // $ANTLR start "rule__TIME__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3236:1: rule__TIME__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3240:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3241:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3241:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3242:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl6440); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0__Impl"


    // $ANTLR start "rule__TIME__Group_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3253:1: rule__TIME__Group_1__1 : rule__TIME__Group_1__1__Impl ;
    public final void rule__TIME__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3257:1: ( rule__TIME__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3258:2: rule__TIME__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__16469);
            rule__TIME__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1"


    // $ANTLR start "rule__TIME__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3264:1: rule__TIME__Group_1__1__Impl : ( 'ms' ) ;
    public final void rule__TIME__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3268:1: ( ( 'ms' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3269:1: ( 'ms' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3269:1: ( 'ms' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3270:1: 'ms'
            {
             before(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
            match(input,45,FOLLOW_45_in_rule__TIME__Group_1__1__Impl6497); 
             after(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1__Impl"


    // $ANTLR start "rule__TIME__Group_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3287:1: rule__TIME__Group_2__0 : rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 ;
    public final void rule__TIME__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3291:1: ( rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3292:2: rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__06532);
            rule__TIME__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__06535);
            rule__TIME__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0"


    // $ANTLR start "rule__TIME__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3299:1: rule__TIME__Group_2__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3303:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3304:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3304:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3305:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl6562); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0__Impl"


    // $ANTLR start "rule__TIME__Group_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3316:1: rule__TIME__Group_2__1 : rule__TIME__Group_2__1__Impl ;
    public final void rule__TIME__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3320:1: ( rule__TIME__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3321:2: rule__TIME__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__16591);
            rule__TIME__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1"


    // $ANTLR start "rule__TIME__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3327:1: rule__TIME__Group_2__1__Impl : ( 'us' ) ;
    public final void rule__TIME__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3331:1: ( ( 'us' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3332:1: ( 'us' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3332:1: ( 'us' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3333:1: 'us'
            {
             before(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
            match(input,46,FOLLOW_46_in_rule__TIME__Group_2__1__Impl6619); 
             after(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1__Impl"


    // $ANTLR start "rule__TIME__Group_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3350:1: rule__TIME__Group_3__0 : rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 ;
    public final void rule__TIME__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3354:1: ( rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3355:2: rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__06654);
            rule__TIME__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__06657);
            rule__TIME__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0"


    // $ANTLR start "rule__TIME__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3362:1: rule__TIME__Group_3__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3366:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3367:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3367:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3368:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl6684); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0__Impl"


    // $ANTLR start "rule__TIME__Group_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3379:1: rule__TIME__Group_3__1 : rule__TIME__Group_3__1__Impl ;
    public final void rule__TIME__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3383:1: ( rule__TIME__Group_3__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3384:2: rule__TIME__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__16713);
            rule__TIME__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1"


    // $ANTLR start "rule__TIME__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3390:1: rule__TIME__Group_3__1__Impl : ( 'ns' ) ;
    public final void rule__TIME__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3394:1: ( ( 'ns' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3395:1: ( 'ns' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3395:1: ( 'ns' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3396:1: 'ns'
            {
             before(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
            match(input,47,FOLLOW_47_in_rule__TIME__Group_3__1__Impl6741); 
             after(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1__Impl"


    // $ANTLR start "rule__PhysicalModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3414:1: rule__PhysicalModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__PhysicalModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3418:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3419:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3419:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3420:1: ruleFQN
            {
             before(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_16781);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3429:1: rule__PhysicalModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__PhysicalModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3433:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3434:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3434:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3435:1: ruleImport
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_36812);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3444:1: rule__PhysicalModel__SystemsAssignment_4_0 : ( rulePhysicalSystem ) ;
    public final void rule__PhysicalModel__SystemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3448:1: ( ( rulePhysicalSystem ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3449:1: ( rulePhysicalSystem )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3449:1: ( rulePhysicalSystem )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3450:1: rulePhysicalSystem
            {
             before(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_06843);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3459:1: rule__PhysicalModel__NodeClassesAssignment_4_1 : ( ruleNodeClass ) ;
    public final void rule__PhysicalModel__NodeClassesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3463:1: ( ( ruleNodeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3464:1: ( ruleNodeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3464:1: ( ruleNodeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3465:1: ruleNodeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_16874);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3474:1: rule__PhysicalModel__RuntimeClassesAssignment_4_2 : ( ruleRuntimeClass ) ;
    public final void rule__PhysicalModel__RuntimeClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3478:1: ( ( ruleRuntimeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3479:1: ( ruleRuntimeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3479:1: ( ruleRuntimeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3480:1: ruleRuntimeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_26905);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3489:1: rule__PhysicalSystem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalSystem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3493:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3494:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3494:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3495:1: RULE_ID
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_16936); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3504:1: rule__PhysicalSystem__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__PhysicalSystem__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3508:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3509:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3509:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3510:1: ruleDocumentation
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_26967);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3519:1: rule__PhysicalSystem__NodeRefsAssignment_4 : ( ruleNodeRef ) ;
    public final void rule__PhysicalSystem__NodeRefsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3523:1: ( ( ruleNodeRef ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3524:1: ( ruleNodeRef )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3524:1: ( ruleNodeRef )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3525:1: ruleNodeRef
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_46998);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3534:1: rule__NodeRef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3538:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3539:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3539:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3540:1: RULE_ID
            {
             before(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_17029); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3549:1: rule__NodeRef__TypeAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__NodeRef__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3553:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3554:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3554:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3555:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3556:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3557:1: ruleFQN
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_37064);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3568:1: rule__NodeRef__DocuAssignment_4 : ( ruleDocumentation ) ;
    public final void rule__NodeRef__DocuAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3572:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3573:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3573:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3574:1: ruleDocumentation
            {
             before(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_47099);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3583:1: rule__NodeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3587:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3588:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3588:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3589:1: RULE_ID
            {
             before(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_17130); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3598:1: rule__NodeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__NodeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3602:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3603:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3603:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3604:1: ruleDocumentation
            {
             before(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_27161);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3613:1: rule__NodeClass__RuntimeAssignment_6 : ( ( ruleFQN ) ) ;
    public final void rule__NodeClass__RuntimeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3617:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3618:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3618:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3619:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_6_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3620:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3621:1: ruleFQN
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_67196);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3632:1: rule__NodeClass__PriominAssignment_9 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriominAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3636:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3637:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3637:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3638:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_9_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_97231);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3647:1: rule__NodeClass__PriomaxAssignment_12 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriomaxAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3651:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3652:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3652:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3653:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_12_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_127262);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3662:1: rule__NodeClass__ThreadsAssignment_13 : ( rulePhysicalThread ) ;
    public final void rule__NodeClass__ThreadsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3666:1: ( ( rulePhysicalThread ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3667:1: ( rulePhysicalThread )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3667:1: ( rulePhysicalThread )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3668:1: rulePhysicalThread
            {
             before(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_13_0()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_137293);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3677:1: rule__PhysicalThread__DefaultAssignment_0_0 : ( ( 'DefaultThread' ) ) ;
    public final void rule__PhysicalThread__DefaultAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3681:1: ( ( ( 'DefaultThread' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3682:1: ( ( 'DefaultThread' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3682:1: ( ( 'DefaultThread' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3683:1: ( 'DefaultThread' )
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3684:1: ( 'DefaultThread' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3685:1: 'DefaultThread'
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            match(input,48,FOLLOW_48_in_rule__PhysicalThread__DefaultAssignment_0_07329); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3700:1: rule__PhysicalThread__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalThread__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3704:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3705:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3705:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3706:1: RULE_ID
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_17368); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3715:1: rule__PhysicalThread__ExecmodeAssignment_5 : ( ruleExecMode ) ;
    public final void rule__PhysicalThread__ExecmodeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3719:1: ( ( ruleExecMode ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3720:1: ( ruleExecMode )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3720:1: ( ruleExecMode )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3721:1: ruleExecMode
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_57399);
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


    // $ANTLR start "rule__PhysicalThread__TimeAssignment_6_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3730:1: rule__PhysicalThread__TimeAssignment_6_2 : ( ruleTIME ) ;
    public final void rule__PhysicalThread__TimeAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3734:1: ( ( ruleTIME ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3735:1: ( ruleTIME )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3735:1: ( ruleTIME )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3736:1: ruleTIME
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_6_27430);
            ruleTIME();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__TimeAssignment_6_2"


    // $ANTLR start "rule__PhysicalThread__PrioAssignment_9"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3745:1: rule__PhysicalThread__PrioAssignment_9 : ( rulePRIO ) ;
    public final void rule__PhysicalThread__PrioAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3749:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3750:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3750:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3751:1: rulePRIO
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_9_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_97461);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__PrioAssignment_9"


    // $ANTLR start "rule__PhysicalThread__StacksizeAssignment_12"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3760:1: rule__PhysicalThread__StacksizeAssignment_12 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__StacksizeAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3764:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3765:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3765:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3766:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_12_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_127492); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__StacksizeAssignment_12"


    // $ANTLR start "rule__PhysicalThread__MsgblocksizeAssignment_15"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3775:1: rule__PhysicalThread__MsgblocksizeAssignment_15 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgblocksizeAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3779:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3780:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3780:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3781:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_15_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_157523); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgblocksizeAssignment_15"


    // $ANTLR start "rule__PhysicalThread__MsgpoolsizeAssignment_18"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3790:1: rule__PhysicalThread__MsgpoolsizeAssignment_18 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgpoolsizeAssignment_18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3794:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3795:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3795:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3796:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_18_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_187554); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgpoolsizeAssignment_18"


    // $ANTLR start "rule__RuntimeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3805:1: rule__RuntimeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RuntimeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3809:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3810:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3810:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3811:1: RULE_ID
            {
             before(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_17585); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3820:1: rule__RuntimeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__RuntimeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3824:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3825:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3825:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3826:1: ruleDocumentation
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_27616);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3835:1: rule__RuntimeClass__ThreadModelAssignment_6 : ( ruleThreadModel ) ;
    public final void rule__RuntimeClass__ThreadModelAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3839:1: ( ( ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3840:1: ( ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3840:1: ( ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3841:1: ruleThreadModel
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_67647);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3850:1: rule__Documentation__TextAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Documentation__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3854:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3855:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3855:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3856:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_17678); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3865:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3869:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3870:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3870:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3871:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_07709);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3880:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3884:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3885:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3885:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3886:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_27740); 
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
    public static final BitSet FOLLOW_ruleTIME_in_entryRuleTIME730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTIME737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Alternatives_in_ruleTIME763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_4907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_0940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__PhysicalThread__Alternatives_0959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PRIO__Alternatives_0994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PRIO__Alternatives_01014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_11048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Import__Alternatives_11067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__0_in_rule__TIME__Alternatives1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__0_in_rule__TIME__Alternatives1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__0_in_rule__TIME__Alternatives1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__0_in_rule__TIME__Alternatives1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExecMode__Alternatives1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ExecMode__Alternatives1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExecMode__Alternatives1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ThreadModel__Alternatives1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ThreadModel__Alternatives1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__01321 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__01324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PhysicalModel__Group__0__Impl1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__11383 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__11386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__21443 = new BitSet(new long[]{0x0000012004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__21446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalModel__Group__2__Impl1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__31505 = new BitSet(new long[]{0x0000012004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__31508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl1535 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__41566 = new BitSet(new long[]{0x0000012004C00000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__41569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl1596 = new BitSet(new long[]{0x0000002004800002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__51627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalModel__Group__5__Impl1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__01698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__01701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PhysicalSystem__Group__0__Impl1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__11760 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__11763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__21820 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__21823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__31881 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__31884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalSystem__Group__3__Impl1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__41943 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__41946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl1973 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__52004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalSystem__Group__5__Impl2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__02075 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__02078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__NodeRef__Group__0__Impl2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__12137 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__12140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__22197 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__22200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__NodeRef__Group__2__Impl2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__32259 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__32262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__42319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__02387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__02390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__NodeClass__Group__0__Impl2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__12449 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__12452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__22509 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__22512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__32570 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__32573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NodeClass__Group__3__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__42632 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__42635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__NodeClass__Group__4__Impl2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52694 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__5__Impl2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62756 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__7_in_rule__NodeClass__Group__62759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__RuntimeAssignment_6_in_rule__NodeClass__Group__6__Impl2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__7__Impl_in_rule__NodeClass__Group__72816 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__8_in_rule__NodeClass__Group__72819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__NodeClass__Group__7__Impl2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__8__Impl_in_rule__NodeClass__Group__82878 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__9_in_rule__NodeClass__Group__82881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__8__Impl2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__9__Impl_in_rule__NodeClass__Group__92940 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__10_in_rule__NodeClass__Group__92943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriominAssignment_9_in_rule__NodeClass__Group__9__Impl2970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__10__Impl_in_rule__NodeClass__Group__103000 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__11_in_rule__NodeClass__Group__103003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__NodeClass__Group__10__Impl3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__11__Impl_in_rule__NodeClass__Group__113062 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__12_in_rule__NodeClass__Group__113065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group__11__Impl3093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__12__Impl_in_rule__NodeClass__Group__123124 = new BitSet(new long[]{0x0001000000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__13_in_rule__NodeClass__Group__123127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriomaxAssignment_12_in_rule__NodeClass__Group__12__Impl3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__13__Impl_in_rule__NodeClass__Group__133184 = new BitSet(new long[]{0x0001000000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__14_in_rule__NodeClass__Group__133187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__ThreadsAssignment_13_in_rule__NodeClass__Group__13__Impl3214 = new BitSet(new long[]{0x0001000000000802L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__14__Impl_in_rule__NodeClass__Group__143245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__NodeClass__Group__14__Impl3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13394 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23454 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33516 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PhysicalThread__Group__3__Impl3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43578 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__5_in_rule__PhysicalThread__Group__43581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__4__Impl3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__5__Impl_in_rule__PhysicalThread__Group__53640 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__6_in_rule__PhysicalThread__Group__53643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__ExecmodeAssignment_5_in_rule__PhysicalThread__Group__5__Impl3670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__6__Impl_in_rule__PhysicalThread__Group__63700 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__7_in_rule__PhysicalThread__Group__63703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__0_in_rule__PhysicalThread__Group__6__Impl3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__7__Impl_in_rule__PhysicalThread__Group__73761 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__8_in_rule__PhysicalThread__Group__73764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PhysicalThread__Group__7__Impl3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__8__Impl_in_rule__PhysicalThread__Group__83823 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__9_in_rule__PhysicalThread__Group__83826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__8__Impl3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__9__Impl_in_rule__PhysicalThread__Group__93885 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__10_in_rule__PhysicalThread__Group__93888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__PrioAssignment_9_in_rule__PhysicalThread__Group__9__Impl3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__10__Impl_in_rule__PhysicalThread__Group__103945 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__11_in_rule__PhysicalThread__Group__103948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PhysicalThread__Group__10__Impl3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__11__Impl_in_rule__PhysicalThread__Group__114007 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__12_in_rule__PhysicalThread__Group__114010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__11__Impl4038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__12__Impl_in_rule__PhysicalThread__Group__124069 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__13_in_rule__PhysicalThread__Group__124072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__StacksizeAssignment_12_in_rule__PhysicalThread__Group__12__Impl4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__13__Impl_in_rule__PhysicalThread__Group__134129 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__14_in_rule__PhysicalThread__Group__134132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PhysicalThread__Group__13__Impl4160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__14__Impl_in_rule__PhysicalThread__Group__144191 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__15_in_rule__PhysicalThread__Group__144194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__14__Impl4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__15__Impl_in_rule__PhysicalThread__Group__154253 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__16_in_rule__PhysicalThread__Group__154256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_15_in_rule__PhysicalThread__Group__15__Impl4283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__16__Impl_in_rule__PhysicalThread__Group__164313 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__17_in_rule__PhysicalThread__Group__164316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PhysicalThread__Group__16__Impl4344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__17__Impl_in_rule__PhysicalThread__Group__174375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__18_in_rule__PhysicalThread__Group__174378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group__17__Impl4406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__18__Impl_in_rule__PhysicalThread__Group__184437 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__19_in_rule__PhysicalThread__Group__184440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_18_in_rule__PhysicalThread__Group__18__Impl4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__19__Impl_in_rule__PhysicalThread__Group__194497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalThread__Group__19__Impl4525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__0__Impl_in_rule__PhysicalThread__Group_6__04596 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__1_in_rule__PhysicalThread__Group_6__04599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_6__0__Impl4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__1__Impl_in_rule__PhysicalThread__Group_6__14658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__2_in_rule__PhysicalThread__Group_6__14661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_6__1__Impl4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_6__2__Impl_in_rule__PhysicalThread__Group_6__24720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__TimeAssignment_6_2_in_rule__PhysicalThread__Group_6__2__Impl4747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04783 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RuntimeClass__Group__0__Impl4814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14845 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24905 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__34966 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__34969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__45028 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__45031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__55090 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__55093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__65152 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__65155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__75212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl5240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05287 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Documentation__Group__0__Impl5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15349 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5381 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5393 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Documentation__Group__2__Impl5454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05491 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05612 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Import__Group__0__Impl5643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15674 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05797 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Import__Group_1_0__1__Impl5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05920 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__15979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ImportedFQN__Group__1__Impl6008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__06045 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__06048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6131 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FQN__Group_1__0__Impl6197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__06288 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__06291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__16347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__TIME__Group_0__1__Impl6375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__06410 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__06413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl6440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__16469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__TIME__Group_1__1__Impl6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__06532 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__06535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl6562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__16591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__TIME__Group_2__1__Impl6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__06654 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__06657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__16713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__TIME__Group_3__1__Impl6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_16781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_36812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_06843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_16874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_26905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_26967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_46998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_17029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_37064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_47099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_17130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_27161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_67196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_97231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_127262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_137293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__PhysicalThread__DefaultAssignment_0_07329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_17368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_57399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_6_27430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_97461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_127492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_157523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_187554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_17585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_27616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_67647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_17678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_07709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_27740 = new BitSet(new long[]{0x0000000000000002L});

}