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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Thread'", "'+'", "'-'", "'model'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'execmode'", "'interval'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'['", "']'", "'import'", "'from'", "'.*'", "'.'", "'s'", "'ms'", "'us'", "'ns'", "'DefaultThread'"
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1307:1: rule__NodeClass__Group__4__Impl : ( ( rule__NodeClass__UnorderedGroup_4 ) ) ;
    public final void rule__NodeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1311:1: ( ( ( rule__NodeClass__UnorderedGroup_4 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( ( rule__NodeClass__UnorderedGroup_4 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ( ( rule__NodeClass__UnorderedGroup_4 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1313:1: ( rule__NodeClass__UnorderedGroup_4 )
            {
             before(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1314:1: ( rule__NodeClass__UnorderedGroup_4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1314:2: rule__NodeClass__UnorderedGroup_4
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4_in_rule__NodeClass__Group__4__Impl2662);
            rule__NodeClass__UnorderedGroup_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1324:1: rule__NodeClass__Group__5 : rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 ;
    public final void rule__NodeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1328:1: ( rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1329:2: rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52692);
            rule__NodeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52695);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1336:1: rule__NodeClass__Group__5__Impl : ( ( rule__NodeClass__ThreadsAssignment_5 )* ) ;
    public final void rule__NodeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1340:1: ( ( ( rule__NodeClass__ThreadsAssignment_5 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1341:1: ( ( rule__NodeClass__ThreadsAssignment_5 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1341:1: ( ( rule__NodeClass__ThreadsAssignment_5 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1342:1: ( rule__NodeClass__ThreadsAssignment_5 )*
            {
             before(grammarAccess.getNodeClassAccess().getThreadsAssignment_5()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1343:1: ( rule__NodeClass__ThreadsAssignment_5 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==11||LA14_0==48) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1343:2: rule__NodeClass__ThreadsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__NodeClass__ThreadsAssignment_5_in_rule__NodeClass__Group__5__Impl2722);
            	    rule__NodeClass__ThreadsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getNodeClassAccess().getThreadsAssignment_5()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1353:1: rule__NodeClass__Group__6 : rule__NodeClass__Group__6__Impl ;
    public final void rule__NodeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1357:1: ( rule__NodeClass__Group__6__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1358:2: rule__NodeClass__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62753);
            rule__NodeClass__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1364:1: rule__NodeClass__Group__6__Impl : ( '}' ) ;
    public final void rule__NodeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1368:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1369:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1369:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1370:1: '}'
            {
             before(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_22_in_rule__NodeClass__Group__6__Impl2781); 
             after(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__NodeClass__Group_4_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1397:1: rule__NodeClass__Group_4_0__0 : rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1 ;
    public final void rule__NodeClass__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1401:1: ( rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1402:2: rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__0__Impl_in_rule__NodeClass__Group_4_0__02826);
            rule__NodeClass__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__1_in_rule__NodeClass__Group_4_0__02829);
            rule__NodeClass__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__0"


    // $ANTLR start "rule__NodeClass__Group_4_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1409:1: rule__NodeClass__Group_4_0__0__Impl : ( 'runtime' ) ;
    public final void rule__NodeClass__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1413:1: ( ( 'runtime' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1414:1: ( 'runtime' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1414:1: ( 'runtime' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1415:1: 'runtime'
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0()); 
            match(input,27,FOLLOW_27_in_rule__NodeClass__Group_4_0__0__Impl2857); 
             after(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1428:1: rule__NodeClass__Group_4_0__1 : rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2 ;
    public final void rule__NodeClass__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1432:1: ( rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1433:2: rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__1__Impl_in_rule__NodeClass__Group_4_0__12888);
            rule__NodeClass__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__2_in_rule__NodeClass__Group_4_0__12891);
            rule__NodeClass__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__1"


    // $ANTLR start "rule__NodeClass__Group_4_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1440:1: rule__NodeClass__Group_4_0__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1444:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1445:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1445:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1446:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group_4_0__1__Impl2919); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_0__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1459:1: rule__NodeClass__Group_4_0__2 : rule__NodeClass__Group_4_0__2__Impl ;
    public final void rule__NodeClass__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1463:1: ( rule__NodeClass__Group_4_0__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1464:2: rule__NodeClass__Group_4_0__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__2__Impl_in_rule__NodeClass__Group_4_0__22950);
            rule__NodeClass__Group_4_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__2"


    // $ANTLR start "rule__NodeClass__Group_4_0__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1470:1: rule__NodeClass__Group_4_0__2__Impl : ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) ) ;
    public final void rule__NodeClass__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1474:1: ( ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1475:1: ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1475:1: ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1476:1: ( rule__NodeClass__RuntimeAssignment_4_0_2 )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeAssignment_4_0_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1477:1: ( rule__NodeClass__RuntimeAssignment_4_0_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1477:2: rule__NodeClass__RuntimeAssignment_4_0_2
            {
            pushFollow(FOLLOW_rule__NodeClass__RuntimeAssignment_4_0_2_in_rule__NodeClass__Group_4_0__2__Impl2977);
            rule__NodeClass__RuntimeAssignment_4_0_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getRuntimeAssignment_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__2__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1493:1: rule__NodeClass__Group_4_1__0 : rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1 ;
    public final void rule__NodeClass__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1497:1: ( rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1498:2: rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__0__Impl_in_rule__NodeClass__Group_4_1__03013);
            rule__NodeClass__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__1_in_rule__NodeClass__Group_4_1__03016);
            rule__NodeClass__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__0"


    // $ANTLR start "rule__NodeClass__Group_4_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1505:1: rule__NodeClass__Group_4_1__0__Impl : ( 'priomin' ) ;
    public final void rule__NodeClass__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1509:1: ( ( 'priomin' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1510:1: ( 'priomin' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1510:1: ( 'priomin' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1511:1: 'priomin'
            {
             before(grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0()); 
            match(input,29,FOLLOW_29_in_rule__NodeClass__Group_4_1__0__Impl3044); 
             after(grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1524:1: rule__NodeClass__Group_4_1__1 : rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2 ;
    public final void rule__NodeClass__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1528:1: ( rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1529:2: rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__1__Impl_in_rule__NodeClass__Group_4_1__13075);
            rule__NodeClass__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__2_in_rule__NodeClass__Group_4_1__13078);
            rule__NodeClass__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__1"


    // $ANTLR start "rule__NodeClass__Group_4_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1536:1: rule__NodeClass__Group_4_1__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1540:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1541:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1541:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1542:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group_4_1__1__Impl3106); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1555:1: rule__NodeClass__Group_4_1__2 : rule__NodeClass__Group_4_1__2__Impl ;
    public final void rule__NodeClass__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1559:1: ( rule__NodeClass__Group_4_1__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1560:2: rule__NodeClass__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__2__Impl_in_rule__NodeClass__Group_4_1__23137);
            rule__NodeClass__Group_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__2"


    // $ANTLR start "rule__NodeClass__Group_4_1__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1566:1: rule__NodeClass__Group_4_1__2__Impl : ( ( rule__NodeClass__PriominAssignment_4_1_2 ) ) ;
    public final void rule__NodeClass__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1570:1: ( ( ( rule__NodeClass__PriominAssignment_4_1_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1571:1: ( ( rule__NodeClass__PriominAssignment_4_1_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1571:1: ( ( rule__NodeClass__PriominAssignment_4_1_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1572:1: ( rule__NodeClass__PriominAssignment_4_1_2 )
            {
             before(grammarAccess.getNodeClassAccess().getPriominAssignment_4_1_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1573:1: ( rule__NodeClass__PriominAssignment_4_1_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1573:2: rule__NodeClass__PriominAssignment_4_1_2
            {
            pushFollow(FOLLOW_rule__NodeClass__PriominAssignment_4_1_2_in_rule__NodeClass__Group_4_1__2__Impl3164);
            rule__NodeClass__PriominAssignment_4_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriominAssignment_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__2__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1589:1: rule__NodeClass__Group_4_2__0 : rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1 ;
    public final void rule__NodeClass__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1593:1: ( rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1594:2: rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__0__Impl_in_rule__NodeClass__Group_4_2__03200);
            rule__NodeClass__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__1_in_rule__NodeClass__Group_4_2__03203);
            rule__NodeClass__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__0"


    // $ANTLR start "rule__NodeClass__Group_4_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1601:1: rule__NodeClass__Group_4_2__0__Impl : ( 'priomax' ) ;
    public final void rule__NodeClass__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1605:1: ( ( 'priomax' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1606:1: ( 'priomax' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1606:1: ( 'priomax' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1607:1: 'priomax'
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0()); 
            match(input,30,FOLLOW_30_in_rule__NodeClass__Group_4_2__0__Impl3231); 
             after(grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1620:1: rule__NodeClass__Group_4_2__1 : rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2 ;
    public final void rule__NodeClass__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1624:1: ( rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1625:2: rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__1__Impl_in_rule__NodeClass__Group_4_2__13262);
            rule__NodeClass__Group_4_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__2_in_rule__NodeClass__Group_4_2__13265);
            rule__NodeClass__Group_4_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__1"


    // $ANTLR start "rule__NodeClass__Group_4_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1632:1: rule__NodeClass__Group_4_2__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1636:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1637:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1637:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1638:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1()); 
            match(input,28,FOLLOW_28_in_rule__NodeClass__Group_4_2__1__Impl3293); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1651:1: rule__NodeClass__Group_4_2__2 : rule__NodeClass__Group_4_2__2__Impl ;
    public final void rule__NodeClass__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1655:1: ( rule__NodeClass__Group_4_2__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1656:2: rule__NodeClass__Group_4_2__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__2__Impl_in_rule__NodeClass__Group_4_2__23324);
            rule__NodeClass__Group_4_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__2"


    // $ANTLR start "rule__NodeClass__Group_4_2__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1662:1: rule__NodeClass__Group_4_2__2__Impl : ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) ) ;
    public final void rule__NodeClass__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1666:1: ( ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1667:1: ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1667:1: ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1668:1: ( rule__NodeClass__PriomaxAssignment_4_2_2 )
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxAssignment_4_2_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1669:1: ( rule__NodeClass__PriomaxAssignment_4_2_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1669:2: rule__NodeClass__PriomaxAssignment_4_2_2
            {
            pushFollow(FOLLOW_rule__NodeClass__PriomaxAssignment_4_2_2_in_rule__NodeClass__Group_4_2__2__Impl3351);
            rule__NodeClass__PriomaxAssignment_4_2_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriomaxAssignment_4_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1685:1: rule__PhysicalThread__Group__0 : rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 ;
    public final void rule__PhysicalThread__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1689:1: ( rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1690:2: rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03387);
            rule__PhysicalThread__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03390);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1697:1: rule__PhysicalThread__Group__0__Impl : ( ( rule__PhysicalThread__Alternatives_0 ) ) ;
    public final void rule__PhysicalThread__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1701:1: ( ( ( rule__PhysicalThread__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1702:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1702:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1703:1: ( rule__PhysicalThread__Alternatives_0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1704:1: ( rule__PhysicalThread__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1704:2: rule__PhysicalThread__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3417);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1714:1: rule__PhysicalThread__Group__1 : rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 ;
    public final void rule__PhysicalThread__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1718:1: ( rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1719:2: rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13447);
            rule__PhysicalThread__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13450);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1726:1: rule__PhysicalThread__Group__1__Impl : ( ( rule__PhysicalThread__NameAssignment_1 ) ) ;
    public final void rule__PhysicalThread__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1730:1: ( ( ( rule__PhysicalThread__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1731:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1731:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1732:1: ( rule__PhysicalThread__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1733:1: ( rule__PhysicalThread__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1733:2: rule__PhysicalThread__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3477);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1743:1: rule__PhysicalThread__Group__2 : rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 ;
    public final void rule__PhysicalThread__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1747:1: ( rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1748:2: rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23507);
            rule__PhysicalThread__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23510);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1755:1: rule__PhysicalThread__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalThread__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1759:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1760:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1760:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1761:1: '{'
            {
             before(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3538); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1774:1: rule__PhysicalThread__Group__3 : rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 ;
    public final void rule__PhysicalThread__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1778:1: ( rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1779:2: rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33569);
            rule__PhysicalThread__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33572);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1786:1: rule__PhysicalThread__Group__3__Impl : ( ( rule__PhysicalThread__UnorderedGroup_3 ) ) ;
    public final void rule__PhysicalThread__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1790:1: ( ( ( rule__PhysicalThread__UnorderedGroup_3 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1791:1: ( ( rule__PhysicalThread__UnorderedGroup_3 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1791:1: ( ( rule__PhysicalThread__UnorderedGroup_3 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1792:1: ( rule__PhysicalThread__UnorderedGroup_3 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1793:1: ( rule__PhysicalThread__UnorderedGroup_3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1793:2: rule__PhysicalThread__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3_in_rule__PhysicalThread__Group__3__Impl3599);
            rule__PhysicalThread__UnorderedGroup_3();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()); 

            }


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1803:1: rule__PhysicalThread__Group__4 : rule__PhysicalThread__Group__4__Impl ;
    public final void rule__PhysicalThread__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1807:1: ( rule__PhysicalThread__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1808:2: rule__PhysicalThread__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43629);
            rule__PhysicalThread__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1814:1: rule__PhysicalThread__Group__4__Impl : ( '}' ) ;
    public final void rule__PhysicalThread__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1818:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1819:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1819:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1820:1: '}'
            {
             before(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_22_in_rule__PhysicalThread__Group__4__Impl3657); 
             after(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__PhysicalThread__Group_3_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1843:1: rule__PhysicalThread__Group_3_0__0 : rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1 ;
    public final void rule__PhysicalThread__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1847:1: ( rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1848:2: rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__0__Impl_in_rule__PhysicalThread__Group_3_0__03698);
            rule__PhysicalThread__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__1_in_rule__PhysicalThread__Group_3_0__03701);
            rule__PhysicalThread__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1855:1: rule__PhysicalThread__Group_3_0__0__Impl : ( 'execmode' ) ;
    public final void rule__PhysicalThread__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1859:1: ( ( 'execmode' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1860:1: ( 'execmode' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1860:1: ( 'execmode' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1861:1: 'execmode'
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0()); 
            match(input,31,FOLLOW_31_in_rule__PhysicalThread__Group_3_0__0__Impl3729); 
             after(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1874:1: rule__PhysicalThread__Group_3_0__1 : rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2 ;
    public final void rule__PhysicalThread__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1878:1: ( rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1879:2: rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__1__Impl_in_rule__PhysicalThread__Group_3_0__13760);
            rule__PhysicalThread__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__2_in_rule__PhysicalThread__Group_3_0__13763);
            rule__PhysicalThread__Group_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1886:1: rule__PhysicalThread__Group_3_0__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1890:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1891:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1891:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1892:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_0__1__Impl3791); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1905:1: rule__PhysicalThread__Group_3_0__2 : rule__PhysicalThread__Group_3_0__2__Impl ;
    public final void rule__PhysicalThread__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1909:1: ( rule__PhysicalThread__Group_3_0__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1910:2: rule__PhysicalThread__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__2__Impl_in_rule__PhysicalThread__Group_3_0__23822);
            rule__PhysicalThread__Group_3_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1916:1: rule__PhysicalThread__Group_3_0__2__Impl : ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1920:1: ( ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1921:1: ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1921:1: ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1922:1: ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_3_0_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1923:1: ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1923:2: rule__PhysicalThread__ExecmodeAssignment_3_0_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__ExecmodeAssignment_3_0_2_in_rule__PhysicalThread__Group_3_0__2__Impl3849);
            rule__PhysicalThread__ExecmodeAssignment_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1939:1: rule__PhysicalThread__Group_3_1__0 : rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1 ;
    public final void rule__PhysicalThread__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1943:1: ( rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1944:2: rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__0__Impl_in_rule__PhysicalThread__Group_3_1__03885);
            rule__PhysicalThread__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__1_in_rule__PhysicalThread__Group_3_1__03888);
            rule__PhysicalThread__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1951:1: rule__PhysicalThread__Group_3_1__0__Impl : ( 'interval' ) ;
    public final void rule__PhysicalThread__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1955:1: ( ( 'interval' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1956:1: ( 'interval' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1956:1: ( 'interval' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1957:1: 'interval'
            {
             before(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0()); 
            match(input,32,FOLLOW_32_in_rule__PhysicalThread__Group_3_1__0__Impl3916); 
             after(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1970:1: rule__PhysicalThread__Group_3_1__1 : rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2 ;
    public final void rule__PhysicalThread__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1974:1: ( rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1975:2: rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__1__Impl_in_rule__PhysicalThread__Group_3_1__13947);
            rule__PhysicalThread__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__2_in_rule__PhysicalThread__Group_3_1__13950);
            rule__PhysicalThread__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1982:1: rule__PhysicalThread__Group_3_1__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1986:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1987:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1987:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1988:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_1__1__Impl3978); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2001:1: rule__PhysicalThread__Group_3_1__2 : rule__PhysicalThread__Group_3_1__2__Impl ;
    public final void rule__PhysicalThread__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2005:1: ( rule__PhysicalThread__Group_3_1__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2006:2: rule__PhysicalThread__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__2__Impl_in_rule__PhysicalThread__Group_3_1__24009);
            rule__PhysicalThread__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2012:1: rule__PhysicalThread__Group_3_1__2__Impl : ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2016:1: ( ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2017:1: ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2017:1: ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2018:1: ( rule__PhysicalThread__TimeAssignment_3_1_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_3_1_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2019:1: ( rule__PhysicalThread__TimeAssignment_3_1_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2019:2: rule__PhysicalThread__TimeAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__TimeAssignment_3_1_2_in_rule__PhysicalThread__Group_3_1__2__Impl4036);
            rule__PhysicalThread__TimeAssignment_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2035:1: rule__PhysicalThread__Group_3_2__0 : rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1 ;
    public final void rule__PhysicalThread__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2039:1: ( rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2040:2: rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__0__Impl_in_rule__PhysicalThread__Group_3_2__04072);
            rule__PhysicalThread__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__1_in_rule__PhysicalThread__Group_3_2__04075);
            rule__PhysicalThread__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2047:1: rule__PhysicalThread__Group_3_2__0__Impl : ( 'prio' ) ;
    public final void rule__PhysicalThread__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2051:1: ( ( 'prio' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2052:1: ( 'prio' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2052:1: ( 'prio' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2053:1: 'prio'
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0()); 
            match(input,33,FOLLOW_33_in_rule__PhysicalThread__Group_3_2__0__Impl4103); 
             after(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2066:1: rule__PhysicalThread__Group_3_2__1 : rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2 ;
    public final void rule__PhysicalThread__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2070:1: ( rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2071:2: rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__1__Impl_in_rule__PhysicalThread__Group_3_2__14134);
            rule__PhysicalThread__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__2_in_rule__PhysicalThread__Group_3_2__14137);
            rule__PhysicalThread__Group_3_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2078:1: rule__PhysicalThread__Group_3_2__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2082:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2083:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2083:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2084:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_2__1__Impl4165); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2097:1: rule__PhysicalThread__Group_3_2__2 : rule__PhysicalThread__Group_3_2__2__Impl ;
    public final void rule__PhysicalThread__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2101:1: ( rule__PhysicalThread__Group_3_2__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2102:2: rule__PhysicalThread__Group_3_2__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__2__Impl_in_rule__PhysicalThread__Group_3_2__24196);
            rule__PhysicalThread__Group_3_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2108:1: rule__PhysicalThread__Group_3_2__2__Impl : ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2112:1: ( ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2113:1: ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2113:1: ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2114:1: ( rule__PhysicalThread__PrioAssignment_3_2_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_3_2_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2115:1: ( rule__PhysicalThread__PrioAssignment_3_2_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2115:2: rule__PhysicalThread__PrioAssignment_3_2_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__PrioAssignment_3_2_2_in_rule__PhysicalThread__Group_3_2__2__Impl4223);
            rule__PhysicalThread__PrioAssignment_3_2_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_3_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2131:1: rule__PhysicalThread__Group_3_3__0 : rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1 ;
    public final void rule__PhysicalThread__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2135:1: ( rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2136:2: rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__0__Impl_in_rule__PhysicalThread__Group_3_3__04259);
            rule__PhysicalThread__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__1_in_rule__PhysicalThread__Group_3_3__04262);
            rule__PhysicalThread__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2143:1: rule__PhysicalThread__Group_3_3__0__Impl : ( 'stacksize' ) ;
    public final void rule__PhysicalThread__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2147:1: ( ( 'stacksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2148:1: ( 'stacksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2148:1: ( 'stacksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2149:1: 'stacksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0()); 
            match(input,34,FOLLOW_34_in_rule__PhysicalThread__Group_3_3__0__Impl4290); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2162:1: rule__PhysicalThread__Group_3_3__1 : rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2 ;
    public final void rule__PhysicalThread__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2166:1: ( rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2167:2: rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__1__Impl_in_rule__PhysicalThread__Group_3_3__14321);
            rule__PhysicalThread__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__2_in_rule__PhysicalThread__Group_3_3__14324);
            rule__PhysicalThread__Group_3_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2174:1: rule__PhysicalThread__Group_3_3__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2178:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2179:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2179:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2180:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_3__1__Impl4352); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2193:1: rule__PhysicalThread__Group_3_3__2 : rule__PhysicalThread__Group_3_3__2__Impl ;
    public final void rule__PhysicalThread__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2197:1: ( rule__PhysicalThread__Group_3_3__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2198:2: rule__PhysicalThread__Group_3_3__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__2__Impl_in_rule__PhysicalThread__Group_3_3__24383);
            rule__PhysicalThread__Group_3_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2204:1: rule__PhysicalThread__Group_3_3__2__Impl : ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2208:1: ( ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2209:1: ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2209:1: ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2210:1: ( rule__PhysicalThread__StacksizeAssignment_3_3_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_3_3_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2211:1: ( rule__PhysicalThread__StacksizeAssignment_3_3_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2211:2: rule__PhysicalThread__StacksizeAssignment_3_3_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__StacksizeAssignment_3_3_2_in_rule__PhysicalThread__Group_3_3__2__Impl4410);
            rule__PhysicalThread__StacksizeAssignment_3_3_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_3_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2227:1: rule__PhysicalThread__Group_3_4__0 : rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1 ;
    public final void rule__PhysicalThread__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2231:1: ( rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2232:2: rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__0__Impl_in_rule__PhysicalThread__Group_3_4__04446);
            rule__PhysicalThread__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__1_in_rule__PhysicalThread__Group_3_4__04449);
            rule__PhysicalThread__Group_3_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2239:1: rule__PhysicalThread__Group_3_4__0__Impl : ( 'msgblocksize' ) ;
    public final void rule__PhysicalThread__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2243:1: ( ( 'msgblocksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2244:1: ( 'msgblocksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2244:1: ( 'msgblocksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2245:1: 'msgblocksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0()); 
            match(input,35,FOLLOW_35_in_rule__PhysicalThread__Group_3_4__0__Impl4477); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2258:1: rule__PhysicalThread__Group_3_4__1 : rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2 ;
    public final void rule__PhysicalThread__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2262:1: ( rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2263:2: rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__1__Impl_in_rule__PhysicalThread__Group_3_4__14508);
            rule__PhysicalThread__Group_3_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__2_in_rule__PhysicalThread__Group_3_4__14511);
            rule__PhysicalThread__Group_3_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2270:1: rule__PhysicalThread__Group_3_4__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2274:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2275:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2275:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2276:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_4__1__Impl4539); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2289:1: rule__PhysicalThread__Group_3_4__2 : rule__PhysicalThread__Group_3_4__2__Impl ;
    public final void rule__PhysicalThread__Group_3_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2293:1: ( rule__PhysicalThread__Group_3_4__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2294:2: rule__PhysicalThread__Group_3_4__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__2__Impl_in_rule__PhysicalThread__Group_3_4__24570);
            rule__PhysicalThread__Group_3_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2300:1: rule__PhysicalThread__Group_3_4__2__Impl : ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2304:1: ( ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2305:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2305:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2306:1: ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_3_4_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2307:1: ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2307:2: rule__PhysicalThread__MsgblocksizeAssignment_3_4_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_3_4_2_in_rule__PhysicalThread__Group_3_4__2__Impl4597);
            rule__PhysicalThread__MsgblocksizeAssignment_3_4_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_3_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2323:1: rule__PhysicalThread__Group_3_5__0 : rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1 ;
    public final void rule__PhysicalThread__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2327:1: ( rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2328:2: rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__0__Impl_in_rule__PhysicalThread__Group_3_5__04633);
            rule__PhysicalThread__Group_3_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__1_in_rule__PhysicalThread__Group_3_5__04636);
            rule__PhysicalThread__Group_3_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2335:1: rule__PhysicalThread__Group_3_5__0__Impl : ( 'msgpoolsize' ) ;
    public final void rule__PhysicalThread__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2339:1: ( ( 'msgpoolsize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2340:1: ( 'msgpoolsize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2340:1: ( 'msgpoolsize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2341:1: 'msgpoolsize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_5__0__Impl4664); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2354:1: rule__PhysicalThread__Group_3_5__1 : rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2 ;
    public final void rule__PhysicalThread__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2358:1: ( rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2359:2: rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__1__Impl_in_rule__PhysicalThread__Group_3_5__14695);
            rule__PhysicalThread__Group_3_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__2_in_rule__PhysicalThread__Group_3_5__14698);
            rule__PhysicalThread__Group_3_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2366:1: rule__PhysicalThread__Group_3_5__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2370:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2371:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2371:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2372:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalThread__Group_3_5__1__Impl4726); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2385:1: rule__PhysicalThread__Group_3_5__2 : rule__PhysicalThread__Group_3_5__2__Impl ;
    public final void rule__PhysicalThread__Group_3_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2389:1: ( rule__PhysicalThread__Group_3_5__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2390:2: rule__PhysicalThread__Group_3_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__2__Impl_in_rule__PhysicalThread__Group_3_5__24757);
            rule__PhysicalThread__Group_3_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2396:1: rule__PhysicalThread__Group_3_5__2__Impl : ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2400:1: ( ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2401:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2401:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2402:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_3_5_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2403:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2403:2: rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2_in_rule__PhysicalThread__Group_3_5__2__Impl4784);
            rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_3_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__2__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2419:1: rule__RuntimeClass__Group__0 : rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 ;
    public final void rule__RuntimeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2423:1: ( rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2424:2: rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04820);
            rule__RuntimeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04823);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2431:1: rule__RuntimeClass__Group__0__Impl : ( 'RuntimeClass' ) ;
    public final void rule__RuntimeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2435:1: ( ( 'RuntimeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2436:1: ( 'RuntimeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2436:1: ( 'RuntimeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2437:1: 'RuntimeClass'
            {
             before(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__RuntimeClass__Group__0__Impl4851); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2450:1: rule__RuntimeClass__Group__1 : rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 ;
    public final void rule__RuntimeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2454:1: ( rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2455:2: rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14882);
            rule__RuntimeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14885);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2462:1: rule__RuntimeClass__Group__1__Impl : ( ( rule__RuntimeClass__NameAssignment_1 ) ) ;
    public final void rule__RuntimeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2466:1: ( ( ( rule__RuntimeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2467:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2467:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2468:1: ( rule__RuntimeClass__NameAssignment_1 )
            {
             before(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2469:1: ( rule__RuntimeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2469:2: rule__RuntimeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4912);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2479:1: rule__RuntimeClass__Group__2 : rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 ;
    public final void rule__RuntimeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2483:1: ( rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2484:2: rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24942);
            rule__RuntimeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24945);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2491:1: rule__RuntimeClass__Group__2__Impl : ( ( rule__RuntimeClass__DocuAssignment_2 )? ) ;
    public final void rule__RuntimeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2495:1: ( ( ( rule__RuntimeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2496:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2496:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2497:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2498:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2498:2: rule__RuntimeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4972);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2508:1: rule__RuntimeClass__Group__3 : rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 ;
    public final void rule__RuntimeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2512:1: ( rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2513:2: rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__35003);
            rule__RuntimeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__35006);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2520:1: rule__RuntimeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__RuntimeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2524:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2525:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2525:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2526:1: '{'
            {
             before(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl5034); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2539:1: rule__RuntimeClass__Group__4 : rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 ;
    public final void rule__RuntimeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2543:1: ( rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2544:2: rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__45065);
            rule__RuntimeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__45068);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2551:1: rule__RuntimeClass__Group__4__Impl : ( 'model' ) ;
    public final void rule__RuntimeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2555:1: ( ( 'model' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2556:1: ( 'model' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2556:1: ( 'model' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2557:1: 'model'
            {
             before(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl5096); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2570:1: rule__RuntimeClass__Group__5 : rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 ;
    public final void rule__RuntimeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2574:1: ( rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2575:2: rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__55127);
            rule__RuntimeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__55130);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2582:1: rule__RuntimeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__RuntimeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2586:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2587:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2587:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2588:1: '='
            {
             before(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl5158); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2601:1: rule__RuntimeClass__Group__6 : rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 ;
    public final void rule__RuntimeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2605:1: ( rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2606:2: rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__65189);
            rule__RuntimeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__65192);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2613:1: rule__RuntimeClass__Group__6__Impl : ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) ;
    public final void rule__RuntimeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2617:1: ( ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2618:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2618:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2619:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2620:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2620:2: rule__RuntimeClass__ThreadModelAssignment_6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl5219);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2630:1: rule__RuntimeClass__Group__7 : rule__RuntimeClass__Group__7__Impl ;
    public final void rule__RuntimeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2634:1: ( rule__RuntimeClass__Group__7__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2635:2: rule__RuntimeClass__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__75249);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2641:1: rule__RuntimeClass__Group__7__Impl : ( '}' ) ;
    public final void rule__RuntimeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2645:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2646:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2646:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2647:1: '}'
            {
             before(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 
            match(input,22,FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl5277); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2676:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2680:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2681:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05324);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05327);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2688:1: rule__Documentation__Group__0__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2692:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2693:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2693:1: ( '[' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2694:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Documentation__Group__0__Impl5355); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2707:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2711:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2712:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15386);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15389);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2719:1: rule__Documentation__Group__1__Impl : ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2723:1: ( ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2724:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2724:1: ( ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2725:1: ( ( rule__Documentation__TextAssignment_1 ) ) ( ( rule__Documentation__TextAssignment_1 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2725:1: ( ( rule__Documentation__TextAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2726:1: ( rule__Documentation__TextAssignment_1 )
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2727:1: ( rule__Documentation__TextAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2727:2: rule__Documentation__TextAssignment_1
            {
            pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5418);
            rule__Documentation__TextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 

            }

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2730:1: ( ( rule__Documentation__TextAssignment_1 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2731:1: ( rule__Documentation__TextAssignment_1 )*
            {
             before(grammarAccess.getDocumentationAccess().getTextAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2732:1: ( rule__Documentation__TextAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2732:2: rule__Documentation__TextAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5430);
            	    rule__Documentation__TextAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2743:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2747:1: ( rule__Documentation__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2748:2: rule__Documentation__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25463);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2754:1: rule__Documentation__Group__2__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2758:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2759:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2759:1: ( ']' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2760:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2()); 
            match(input,39,FOLLOW_39_in_rule__Documentation__Group__2__Impl5491); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2779:1: rule__PRIO__Group__0 : rule__PRIO__Group__0__Impl rule__PRIO__Group__1 ;
    public final void rule__PRIO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2783:1: ( rule__PRIO__Group__0__Impl rule__PRIO__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2784:2: rule__PRIO__Group__0__Impl rule__PRIO__Group__1
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05528);
            rule__PRIO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05531);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2791:1: rule__PRIO__Group__0__Impl : ( ( rule__PRIO__Alternatives_0 )? ) ;
    public final void rule__PRIO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2795:1: ( ( ( rule__PRIO__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2796:1: ( ( rule__PRIO__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2796:1: ( ( rule__PRIO__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2797:1: ( rule__PRIO__Alternatives_0 )?
            {
             before(grammarAccess.getPRIOAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2798:1: ( rule__PRIO__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=12 && LA17_0<=13)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2798:2: rule__PRIO__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5558);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2808:1: rule__PRIO__Group__1 : rule__PRIO__Group__1__Impl ;
    public final void rule__PRIO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2812:1: ( rule__PRIO__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2813:2: rule__PRIO__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15589);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2819:1: rule__PRIO__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__PRIO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2823:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2824:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2824:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2825:1: RULE_INT
            {
             before(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5616); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2840:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2844:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2845:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05649);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05652);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2852:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2856:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2857:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2857:1: ( 'import' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2858:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__Import__Group__0__Impl5680); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2871:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2875:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2876:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15711);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15714);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2883:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2887:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2888:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2888:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2889:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2890:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2890:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5741);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2900:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2904:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2905:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25771);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2911:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2915:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2916:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2916:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2917:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2918:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2918:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5798);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2934:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2938:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2939:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05834);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05837);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2946:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2950:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2951:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2951:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2952:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2953:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2953:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5864);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2963:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2967:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2968:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15894);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2974:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2978:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2979:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2979:1: ( 'from' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2980:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,41,FOLLOW_41_in_rule__Import__Group_1_0__1__Impl5922); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2997:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3001:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3002:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05957);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05960);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3009:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3013:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3014:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3014:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3015:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5987);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3026:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3030:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3031:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__16016);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3037:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3041:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3042:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3042:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3043:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3044:1: ( '.*' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==42) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3045:2: '.*'
                    {
                    match(input,42,FOLLOW_42_in_rule__ImportedFQN__Group__1__Impl6045); 

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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3060:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3064:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3065:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__06082);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__06085);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3072:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3076:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3077:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3077:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3078:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6112); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3089:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3093:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3094:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16141);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3100:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3104:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3105:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3105:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3106:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3107:1: ( rule__FQN__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==43) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3107:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6168);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3121:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3125:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3126:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06203);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06206);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3133:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3137:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3138:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3138:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3139:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,43,FOLLOW_43_in_rule__FQN__Group_1__0__Impl6234); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3152:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3156:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3157:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16265);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3163:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3167:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3168:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3168:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3169:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6292); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3184:1: rule__TIME__Group_0__0 : rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 ;
    public final void rule__TIME__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3188:1: ( rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3189:2: rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__06325);
            rule__TIME__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__06328);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3196:1: rule__TIME__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3200:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3201:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3201:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3202:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl6355); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3213:1: rule__TIME__Group_0__1 : rule__TIME__Group_0__1__Impl ;
    public final void rule__TIME__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3217:1: ( rule__TIME__Group_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3218:2: rule__TIME__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__16384);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3224:1: rule__TIME__Group_0__1__Impl : ( 's' ) ;
    public final void rule__TIME__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3228:1: ( ( 's' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3229:1: ( 's' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3229:1: ( 's' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3230:1: 's'
            {
             before(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
            match(input,44,FOLLOW_44_in_rule__TIME__Group_0__1__Impl6412); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3247:1: rule__TIME__Group_1__0 : rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 ;
    public final void rule__TIME__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3251:1: ( rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3252:2: rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__06447);
            rule__TIME__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__06450);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3259:1: rule__TIME__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3263:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3264:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3264:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3265:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl6477); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3276:1: rule__TIME__Group_1__1 : rule__TIME__Group_1__1__Impl ;
    public final void rule__TIME__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3280:1: ( rule__TIME__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3281:2: rule__TIME__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__16506);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3287:1: rule__TIME__Group_1__1__Impl : ( 'ms' ) ;
    public final void rule__TIME__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3291:1: ( ( 'ms' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3292:1: ( 'ms' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3292:1: ( 'ms' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3293:1: 'ms'
            {
             before(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
            match(input,45,FOLLOW_45_in_rule__TIME__Group_1__1__Impl6534); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3310:1: rule__TIME__Group_2__0 : rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 ;
    public final void rule__TIME__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3314:1: ( rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3315:2: rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__06569);
            rule__TIME__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__06572);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3322:1: rule__TIME__Group_2__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3326:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3327:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3327:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3328:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl6599); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3339:1: rule__TIME__Group_2__1 : rule__TIME__Group_2__1__Impl ;
    public final void rule__TIME__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3343:1: ( rule__TIME__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3344:2: rule__TIME__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__16628);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3350:1: rule__TIME__Group_2__1__Impl : ( 'us' ) ;
    public final void rule__TIME__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3354:1: ( ( 'us' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3355:1: ( 'us' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3355:1: ( 'us' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3356:1: 'us'
            {
             before(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
            match(input,46,FOLLOW_46_in_rule__TIME__Group_2__1__Impl6656); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3373:1: rule__TIME__Group_3__0 : rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 ;
    public final void rule__TIME__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3377:1: ( rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3378:2: rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__06691);
            rule__TIME__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__06694);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3385:1: rule__TIME__Group_3__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3389:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3390:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3390:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3391:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl6721); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3402:1: rule__TIME__Group_3__1 : rule__TIME__Group_3__1__Impl ;
    public final void rule__TIME__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3406:1: ( rule__TIME__Group_3__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3407:2: rule__TIME__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__16750);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3413:1: rule__TIME__Group_3__1__Impl : ( 'ns' ) ;
    public final void rule__TIME__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3417:1: ( ( 'ns' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3418:1: ( 'ns' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3418:1: ( 'ns' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3419:1: 'ns'
            {
             before(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
            match(input,47,FOLLOW_47_in_rule__TIME__Group_3__1__Impl6778); 
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


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3437:1: rule__NodeClass__UnorderedGroup_4 : rule__NodeClass__UnorderedGroup_4__0 {...}?;
    public final void rule__NodeClass__UnorderedGroup_4() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3442:1: ( rule__NodeClass__UnorderedGroup_4__0 {...}?)
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3443:2: rule__NodeClass__UnorderedGroup_4__0 {...}?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__0_in_rule__NodeClass__UnorderedGroup_46814);
            rule__NodeClass__UnorderedGroup_4__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4", "getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3454:1: rule__NodeClass__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) ) ;
    public final void rule__NodeClass__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3459:1: ( ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3460:3: ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3460:3: ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( LA20_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt20=1;
            }
            else if ( LA20_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt20=2;
            }
            else if ( LA20_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt20=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3462:4: ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3462:4: ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3463:5: {...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3463:106: ( ( ( rule__NodeClass__Group_4_0__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3464:6: ( ( rule__NodeClass__Group_4_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3470:6: ( ( rule__NodeClass__Group_4_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3472:7: ( rule__NodeClass__Group_4_0__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3473:7: ( rule__NodeClass__Group_4_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3473:8: rule__NodeClass__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_0__0_in_rule__NodeClass__UnorderedGroup_4__Impl6903);
                    rule__NodeClass__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3479:4: ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3479:4: ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3480:5: {...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3480:106: ( ( ( rule__NodeClass__Group_4_1__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3481:6: ( ( rule__NodeClass__Group_4_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3487:6: ( ( rule__NodeClass__Group_4_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3489:7: ( rule__NodeClass__Group_4_1__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3490:7: ( rule__NodeClass__Group_4_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3490:8: rule__NodeClass__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_1__0_in_rule__NodeClass__UnorderedGroup_4__Impl6994);
                    rule__NodeClass__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3496:4: ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3496:4: ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3497:5: {...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3497:106: ( ( ( rule__NodeClass__Group_4_2__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3498:6: ( ( rule__NodeClass__Group_4_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3504:6: ( ( rule__NodeClass__Group_4_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3506:7: ( rule__NodeClass__Group_4_2__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3507:7: ( rule__NodeClass__Group_4_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3507:8: rule__NodeClass__Group_4_2__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_2__0_in_rule__NodeClass__UnorderedGroup_4__Impl7085);
                    rule__NodeClass__Group_4_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3522:1: rule__NodeClass__UnorderedGroup_4__0 : rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )? ;
    public final void rule__NodeClass__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3526:1: ( rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3527:2: rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__07144);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3528:2: ( rule__NodeClass__UnorderedGroup_4__1 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( LA21_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt21=1;
            }
            else if ( LA21_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt21=1;
            }
            else if ( LA21_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3528:2: rule__NodeClass__UnorderedGroup_4__1
                    {
                    pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__1_in_rule__NodeClass__UnorderedGroup_4__07147);
                    rule__NodeClass__UnorderedGroup_4__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__0"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3535:1: rule__NodeClass__UnorderedGroup_4__1 : rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )? ;
    public final void rule__NodeClass__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3539:1: ( rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3540:2: rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__17172);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3541:2: ( rule__NodeClass__UnorderedGroup_4__2 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( LA22_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt22=1;
            }
            else if ( LA22_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt22=1;
            }
            else if ( LA22_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3541:2: rule__NodeClass__UnorderedGroup_4__2
                    {
                    pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__2_in_rule__NodeClass__UnorderedGroup_4__17175);
                    rule__NodeClass__UnorderedGroup_4__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__1"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3548:1: rule__NodeClass__UnorderedGroup_4__2 : rule__NodeClass__UnorderedGroup_4__Impl ;
    public final void rule__NodeClass__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3552:1: ( rule__NodeClass__UnorderedGroup_4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3553:2: rule__NodeClass__UnorderedGroup_4__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__27200);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__2"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3566:1: rule__PhysicalThread__UnorderedGroup_3 : rule__PhysicalThread__UnorderedGroup_3__0 {...}?;
    public final void rule__PhysicalThread__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3571:1: ( rule__PhysicalThread__UnorderedGroup_3__0 {...}?)
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3572:2: rule__PhysicalThread__UnorderedGroup_3__0 {...}?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__0_in_rule__PhysicalThread__UnorderedGroup_37230);
            rule__PhysicalThread__UnorderedGroup_3__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3583:1: rule__PhysicalThread__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) ) ;
    public final void rule__PhysicalThread__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3588:1: ( ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3589:3: ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3589:3: ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) )
            int alt23=6;
            int LA23_0 = input.LA(1);

            if ( LA23_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt23=2;
            }
            else if ( LA23_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt23=3;
            }
            else if ( LA23_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt23=4;
            }
            else if ( LA23_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt23=5;
            }
            else if ( LA23_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt23=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3591:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3591:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3592:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3592:111: ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3593:6: ( ( rule__PhysicalThread__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3599:6: ( ( rule__PhysicalThread__Group_3_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3601:7: ( rule__PhysicalThread__Group_3_0__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3602:7: ( rule__PhysicalThread__Group_3_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3602:8: rule__PhysicalThread__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7319);
                    rule__PhysicalThread__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3608:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3608:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3609:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3609:111: ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3610:6: ( ( rule__PhysicalThread__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3616:6: ( ( rule__PhysicalThread__Group_3_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3618:7: ( rule__PhysicalThread__Group_3_1__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3619:7: ( rule__PhysicalThread__Group_3_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3619:8: rule__PhysicalThread__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7410);
                    rule__PhysicalThread__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3625:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3625:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3626:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3626:111: ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3627:6: ( ( rule__PhysicalThread__Group_3_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3633:6: ( ( rule__PhysicalThread__Group_3_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3635:7: ( rule__PhysicalThread__Group_3_2__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3636:7: ( rule__PhysicalThread__Group_3_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3636:8: rule__PhysicalThread__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7501);
                    rule__PhysicalThread__Group_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3642:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3642:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3643:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3643:111: ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3644:6: ( ( rule__PhysicalThread__Group_3_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3650:6: ( ( rule__PhysicalThread__Group_3_3__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3652:7: ( rule__PhysicalThread__Group_3_3__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_3()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3653:7: ( rule__PhysicalThread__Group_3_3__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3653:8: rule__PhysicalThread__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7592);
                    rule__PhysicalThread__Group_3_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3659:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3659:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3660:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3660:111: ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3661:6: ( ( rule__PhysicalThread__Group_3_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3667:6: ( ( rule__PhysicalThread__Group_3_4__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3669:7: ( rule__PhysicalThread__Group_3_4__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_4()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3670:7: ( rule__PhysicalThread__Group_3_4__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3670:8: rule__PhysicalThread__Group_3_4__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7683);
                    rule__PhysicalThread__Group_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_4()); 

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3676:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3676:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3677:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3677:111: ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3678:6: ( ( rule__PhysicalThread__Group_3_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3684:6: ( ( rule__PhysicalThread__Group_3_5__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3686:7: ( rule__PhysicalThread__Group_3_5__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_5()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3687:7: ( rule__PhysicalThread__Group_3_5__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3687:8: rule__PhysicalThread__Group_3_5__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7774);
                    rule__PhysicalThread__Group_3_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_5()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3702:1: rule__PhysicalThread__UnorderedGroup_3__0 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3706:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3707:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__07833);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3708:2: ( rule__PhysicalThread__UnorderedGroup_3__1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt24=1;
            }
            else if ( LA24_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt24=1;
            }
            else if ( LA24_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt24=1;
            }
            else if ( LA24_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt24=1;
            }
            else if ( LA24_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3708:2: rule__PhysicalThread__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__1_in_rule__PhysicalThread__UnorderedGroup_3__07836);
                    rule__PhysicalThread__UnorderedGroup_3__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__0"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3715:1: rule__PhysicalThread__UnorderedGroup_3__1 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3719:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3720:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__17861);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3721:2: ( rule__PhysicalThread__UnorderedGroup_3__2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt25=1;
            }
            else if ( LA25_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt25=1;
            }
            else if ( LA25_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt25=1;
            }
            else if ( LA25_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt25=1;
            }
            else if ( LA25_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3721:2: rule__PhysicalThread__UnorderedGroup_3__2
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__2_in_rule__PhysicalThread__UnorderedGroup_3__17864);
                    rule__PhysicalThread__UnorderedGroup_3__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__1"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3728:1: rule__PhysicalThread__UnorderedGroup_3__2 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3732:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3733:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__27889);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3734:2: ( rule__PhysicalThread__UnorderedGroup_3__3 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( LA26_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt26=1;
            }
            else if ( LA26_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt26=1;
            }
            else if ( LA26_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt26=1;
            }
            else if ( LA26_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt26=1;
            }
            else if ( LA26_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3734:2: rule__PhysicalThread__UnorderedGroup_3__3
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__3_in_rule__PhysicalThread__UnorderedGroup_3__27892);
                    rule__PhysicalThread__UnorderedGroup_3__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__2"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3741:1: rule__PhysicalThread__UnorderedGroup_3__3 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3745:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3746:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__37917);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3747:2: ( rule__PhysicalThread__UnorderedGroup_3__4 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( LA27_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt27=1;
            }
            else if ( LA27_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt27=1;
            }
            else if ( LA27_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt27=1;
            }
            else if ( LA27_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt27=1;
            }
            else if ( LA27_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt27=1;
            }
            else if ( LA27_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3747:2: rule__PhysicalThread__UnorderedGroup_3__4
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__4_in_rule__PhysicalThread__UnorderedGroup_3__37920);
                    rule__PhysicalThread__UnorderedGroup_3__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__3"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3754:1: rule__PhysicalThread__UnorderedGroup_3__4 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3758:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3759:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__47945);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3760:2: ( rule__PhysicalThread__UnorderedGroup_3__5 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( LA28_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt28=1;
            }
            else if ( LA28_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt28=1;
            }
            else if ( LA28_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt28=1;
            }
            else if ( LA28_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt28=1;
            }
            else if ( LA28_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt28=1;
            }
            else if ( LA28_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3760:2: rule__PhysicalThread__UnorderedGroup_3__5
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__5_in_rule__PhysicalThread__UnorderedGroup_3__47948);
                    rule__PhysicalThread__UnorderedGroup_3__5();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__4"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3767:1: rule__PhysicalThread__UnorderedGroup_3__5 : rule__PhysicalThread__UnorderedGroup_3__Impl ;
    public final void rule__PhysicalThread__UnorderedGroup_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3771:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3772:2: rule__PhysicalThread__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__57973);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__5"


    // $ANTLR start "rule__PhysicalModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3791:1: rule__PhysicalModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__PhysicalModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3795:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3796:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3796:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3797:1: ruleFQN
            {
             before(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_18013);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3806:1: rule__PhysicalModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__PhysicalModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3810:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3811:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3811:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3812:1: ruleImport
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_38044);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3821:1: rule__PhysicalModel__SystemsAssignment_4_0 : ( rulePhysicalSystem ) ;
    public final void rule__PhysicalModel__SystemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3825:1: ( ( rulePhysicalSystem ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3826:1: ( rulePhysicalSystem )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3826:1: ( rulePhysicalSystem )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3827:1: rulePhysicalSystem
            {
             before(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_08075);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3836:1: rule__PhysicalModel__NodeClassesAssignment_4_1 : ( ruleNodeClass ) ;
    public final void rule__PhysicalModel__NodeClassesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3840:1: ( ( ruleNodeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3841:1: ( ruleNodeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3841:1: ( ruleNodeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3842:1: ruleNodeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_18106);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3851:1: rule__PhysicalModel__RuntimeClassesAssignment_4_2 : ( ruleRuntimeClass ) ;
    public final void rule__PhysicalModel__RuntimeClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3855:1: ( ( ruleRuntimeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3856:1: ( ruleRuntimeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3856:1: ( ruleRuntimeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3857:1: ruleRuntimeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_28137);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3866:1: rule__PhysicalSystem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalSystem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3870:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3871:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3871:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3872:1: RULE_ID
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_18168); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3881:1: rule__PhysicalSystem__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__PhysicalSystem__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3885:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3886:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3886:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3887:1: ruleDocumentation
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_28199);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3896:1: rule__PhysicalSystem__NodeRefsAssignment_4 : ( ruleNodeRef ) ;
    public final void rule__PhysicalSystem__NodeRefsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3900:1: ( ( ruleNodeRef ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3901:1: ( ruleNodeRef )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3901:1: ( ruleNodeRef )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3902:1: ruleNodeRef
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_48230);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3911:1: rule__NodeRef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3915:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3916:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3916:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3917:1: RULE_ID
            {
             before(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_18261); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3926:1: rule__NodeRef__TypeAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__NodeRef__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3930:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3931:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3931:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3932:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3933:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3934:1: ruleFQN
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_38296);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3945:1: rule__NodeRef__DocuAssignment_4 : ( ruleDocumentation ) ;
    public final void rule__NodeRef__DocuAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3949:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3950:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3950:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3951:1: ruleDocumentation
            {
             before(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_48331);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3960:1: rule__NodeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3964:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3965:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3965:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3966:1: RULE_ID
            {
             before(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_18362); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3975:1: rule__NodeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__NodeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3979:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3980:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3980:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3981:1: ruleDocumentation
            {
             before(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_28393);
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


    // $ANTLR start "rule__NodeClass__RuntimeAssignment_4_0_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3990:1: rule__NodeClass__RuntimeAssignment_4_0_2 : ( ( ruleFQN ) ) ;
    public final void rule__NodeClass__RuntimeAssignment_4_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3994:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3995:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3995:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3996:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3997:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3998:1: ruleFQN
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_4_0_2_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_4_0_28428);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_4_0_2_0_1()); 

            }

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__RuntimeAssignment_4_0_2"


    // $ANTLR start "rule__NodeClass__PriominAssignment_4_1_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4009:1: rule__NodeClass__PriominAssignment_4_1_2 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriominAssignment_4_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4013:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4014:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4014:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4015:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_4_1_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_4_1_28463);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_4_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriominAssignment_4_1_2"


    // $ANTLR start "rule__NodeClass__PriomaxAssignment_4_2_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4024:1: rule__NodeClass__PriomaxAssignment_4_2_2 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriomaxAssignment_4_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4028:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4029:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4029:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4030:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_4_2_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_4_2_28494);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_4_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriomaxAssignment_4_2_2"


    // $ANTLR start "rule__NodeClass__ThreadsAssignment_5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4039:1: rule__NodeClass__ThreadsAssignment_5 : ( rulePhysicalThread ) ;
    public final void rule__NodeClass__ThreadsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4043:1: ( ( rulePhysicalThread ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4044:1: ( rulePhysicalThread )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4044:1: ( rulePhysicalThread )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4045:1: rulePhysicalThread
            {
             before(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_58525);
            rulePhysicalThread();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__ThreadsAssignment_5"


    // $ANTLR start "rule__PhysicalThread__DefaultAssignment_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4054:1: rule__PhysicalThread__DefaultAssignment_0_0 : ( ( 'DefaultThread' ) ) ;
    public final void rule__PhysicalThread__DefaultAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4058:1: ( ( ( 'DefaultThread' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4059:1: ( ( 'DefaultThread' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4059:1: ( ( 'DefaultThread' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4060:1: ( 'DefaultThread' )
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4061:1: ( 'DefaultThread' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4062:1: 'DefaultThread'
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            match(input,48,FOLLOW_48_in_rule__PhysicalThread__DefaultAssignment_0_08561); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4077:1: rule__PhysicalThread__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalThread__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4081:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4082:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4082:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4083:1: RULE_ID
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_18600); 
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


    // $ANTLR start "rule__PhysicalThread__ExecmodeAssignment_3_0_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4092:1: rule__PhysicalThread__ExecmodeAssignment_3_0_2 : ( ruleExecMode ) ;
    public final void rule__PhysicalThread__ExecmodeAssignment_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4096:1: ( ( ruleExecMode ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4097:1: ( ruleExecMode )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4097:1: ( ruleExecMode )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4098:1: ruleExecMode
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 
            pushFollow(FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_3_0_28631);
            ruleExecMode();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__ExecmodeAssignment_3_0_2"


    // $ANTLR start "rule__PhysicalThread__TimeAssignment_3_1_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4107:1: rule__PhysicalThread__TimeAssignment_3_1_2 : ( ruleTIME ) ;
    public final void rule__PhysicalThread__TimeAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4111:1: ( ( ruleTIME ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4112:1: ( ruleTIME )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4112:1: ( ruleTIME )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4113:1: ruleTIME
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_3_1_28662);
            ruleTIME();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__TimeAssignment_3_1_2"


    // $ANTLR start "rule__PhysicalThread__PrioAssignment_3_2_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4122:1: rule__PhysicalThread__PrioAssignment_3_2_2 : ( rulePRIO ) ;
    public final void rule__PhysicalThread__PrioAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4126:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4127:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4127:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4128:1: rulePRIO
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_3_2_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_3_2_28693);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_3_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__PrioAssignment_3_2_2"


    // $ANTLR start "rule__PhysicalThread__StacksizeAssignment_3_3_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4137:1: rule__PhysicalThread__StacksizeAssignment_3_3_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__StacksizeAssignment_3_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4141:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4142:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4142:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4143:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_3_3_28724); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__StacksizeAssignment_3_3_2"


    // $ANTLR start "rule__PhysicalThread__MsgblocksizeAssignment_3_4_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4152:1: rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgblocksizeAssignment_3_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4156:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4157:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4157:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4158:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_3_4_28755); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgblocksizeAssignment_3_4_2"


    // $ANTLR start "rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4167:1: rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4171:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4172:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4172:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4173:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_28786); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2"


    // $ANTLR start "rule__RuntimeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4182:1: rule__RuntimeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RuntimeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4186:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4187:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4187:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4188:1: RULE_ID
            {
             before(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_18817); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4197:1: rule__RuntimeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__RuntimeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4201:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4202:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4202:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4203:1: ruleDocumentation
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_28848);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4212:1: rule__RuntimeClass__ThreadModelAssignment_6 : ( ruleThreadModel ) ;
    public final void rule__RuntimeClass__ThreadModelAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4216:1: ( ( ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4217:1: ( ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4217:1: ( ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4218:1: ruleThreadModel
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_68879);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4227:1: rule__Documentation__TextAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Documentation__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4231:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4232:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4232:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4233:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_18910); 
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4242:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4246:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4247:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4247:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4248:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_08941);
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
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4257:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4261:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4262:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4262:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4263:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_28972); 
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
    public static final BitSet FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__32570 = new BitSet(new long[]{0x0000000068000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__32573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NodeClass__Group__3__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__42632 = new BitSet(new long[]{0x0001000000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__42635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4_in_rule__NodeClass__Group__4__Impl2662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__52692 = new BitSet(new long[]{0x0001000000400800L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__52695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__ThreadsAssignment_5_in_rule__NodeClass__Group__5__Impl2722 = new BitSet(new long[]{0x0001000000000802L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__62753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__NodeClass__Group__6__Impl2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__0__Impl_in_rule__NodeClass__Group_4_0__02826 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__1_in_rule__NodeClass__Group_4_0__02829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__NodeClass__Group_4_0__0__Impl2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__1__Impl_in_rule__NodeClass__Group_4_0__12888 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__2_in_rule__NodeClass__Group_4_0__12891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group_4_0__1__Impl2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__2__Impl_in_rule__NodeClass__Group_4_0__22950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__RuntimeAssignment_4_0_2_in_rule__NodeClass__Group_4_0__2__Impl2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__0__Impl_in_rule__NodeClass__Group_4_1__03013 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__1_in_rule__NodeClass__Group_4_1__03016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__NodeClass__Group_4_1__0__Impl3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__1__Impl_in_rule__NodeClass__Group_4_1__13075 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__2_in_rule__NodeClass__Group_4_1__13078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group_4_1__1__Impl3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__2__Impl_in_rule__NodeClass__Group_4_1__23137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriominAssignment_4_1_2_in_rule__NodeClass__Group_4_1__2__Impl3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__0__Impl_in_rule__NodeClass__Group_4_2__03200 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__1_in_rule__NodeClass__Group_4_2__03203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__NodeClass__Group_4_2__0__Impl3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__1__Impl_in_rule__NodeClass__Group_4_2__13262 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__2_in_rule__NodeClass__Group_4_2__13265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__NodeClass__Group_4_2__1__Impl3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__2__Impl_in_rule__NodeClass__Group_4_2__23324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriomaxAssignment_4_2_2_in_rule__NodeClass__Group_4_2__2__Impl3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__03387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__03390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__13447 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__13450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl3477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__23507 = new BitSet(new long[]{0x0000001F80000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__23510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PhysicalThread__Group__2__Impl3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__33569 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__33572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3_in_rule__PhysicalThread__Group__3__Impl3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__43629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PhysicalThread__Group__4__Impl3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__0__Impl_in_rule__PhysicalThread__Group_3_0__03698 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__1_in_rule__PhysicalThread__Group_3_0__03701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PhysicalThread__Group_3_0__0__Impl3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__1__Impl_in_rule__PhysicalThread__Group_3_0__13760 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__2_in_rule__PhysicalThread__Group_3_0__13763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_0__1__Impl3791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__2__Impl_in_rule__PhysicalThread__Group_3_0__23822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__ExecmodeAssignment_3_0_2_in_rule__PhysicalThread__Group_3_0__2__Impl3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__0__Impl_in_rule__PhysicalThread__Group_3_1__03885 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__1_in_rule__PhysicalThread__Group_3_1__03888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PhysicalThread__Group_3_1__0__Impl3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__1__Impl_in_rule__PhysicalThread__Group_3_1__13947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__2_in_rule__PhysicalThread__Group_3_1__13950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_1__1__Impl3978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__2__Impl_in_rule__PhysicalThread__Group_3_1__24009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__TimeAssignment_3_1_2_in_rule__PhysicalThread__Group_3_1__2__Impl4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__0__Impl_in_rule__PhysicalThread__Group_3_2__04072 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__1_in_rule__PhysicalThread__Group_3_2__04075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PhysicalThread__Group_3_2__0__Impl4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__1__Impl_in_rule__PhysicalThread__Group_3_2__14134 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__2_in_rule__PhysicalThread__Group_3_2__14137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_2__1__Impl4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__2__Impl_in_rule__PhysicalThread__Group_3_2__24196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__PrioAssignment_3_2_2_in_rule__PhysicalThread__Group_3_2__2__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__0__Impl_in_rule__PhysicalThread__Group_3_3__04259 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__1_in_rule__PhysicalThread__Group_3_3__04262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__PhysicalThread__Group_3_3__0__Impl4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__1__Impl_in_rule__PhysicalThread__Group_3_3__14321 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__2_in_rule__PhysicalThread__Group_3_3__14324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_3__1__Impl4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__2__Impl_in_rule__PhysicalThread__Group_3_3__24383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__StacksizeAssignment_3_3_2_in_rule__PhysicalThread__Group_3_3__2__Impl4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__0__Impl_in_rule__PhysicalThread__Group_3_4__04446 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__1_in_rule__PhysicalThread__Group_3_4__04449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__PhysicalThread__Group_3_4__0__Impl4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__1__Impl_in_rule__PhysicalThread__Group_3_4__14508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__2_in_rule__PhysicalThread__Group_3_4__14511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_4__1__Impl4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__2__Impl_in_rule__PhysicalThread__Group_3_4__24570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_3_4_2_in_rule__PhysicalThread__Group_3_4__2__Impl4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__0__Impl_in_rule__PhysicalThread__Group_3_5__04633 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__1_in_rule__PhysicalThread__Group_3_5__04636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_5__0__Impl4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__1__Impl_in_rule__PhysicalThread__Group_3_5__14695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__2_in_rule__PhysicalThread__Group_3_5__14698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalThread__Group_3_5__1__Impl4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__2__Impl_in_rule__PhysicalThread__Group_3_5__24757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2_in_rule__PhysicalThread__Group_3_5__2__Impl4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__04820 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__04823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__RuntimeClass__Group__0__Impl4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__14882 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__14885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__24942 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__24945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__35003 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__35006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__RuntimeClass__Group__3__Impl5034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__45065 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__45068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RuntimeClass__Group__4__Impl5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__55127 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__55130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RuntimeClass__Group__5__Impl5158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__65189 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__65192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__75249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__RuntimeClass__Group__7__Impl5277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__05324 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__05327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Documentation__Group__0__Impl5355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__15386 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__15389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5418 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__TextAssignment_1_in_rule__Documentation__Group__1__Impl5430 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__25463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Documentation__Group__2__Impl5491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__05528 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__05531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__15589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05649 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Import__Group__0__Impl5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15711 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl5741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl5798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__05834 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__05837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl5864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__15894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Import__Group_1_0__1__Impl5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__05957 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__05960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl5987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__16016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ImportedFQN__Group__1__Impl6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__06082 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__06085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl6112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__16141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl6168 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__06203 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__06206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__FQN__Group_1__0__Impl6234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__16265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl6292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__06325 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__06328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl6355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__16384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__TIME__Group_0__1__Impl6412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__06447 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__06450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__16506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__TIME__Group_1__1__Impl6534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__06569 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__06572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl6599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__16628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__TIME__Group_2__1__Impl6656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__06691 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__06694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__16750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__TIME__Group_3__1__Impl6778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__0_in_rule__NodeClass__UnorderedGroup_46814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__0_in_rule__NodeClass__UnorderedGroup_4__Impl6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__0_in_rule__NodeClass__UnorderedGroup_4__Impl6994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__0_in_rule__NodeClass__UnorderedGroup_4__Impl7085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__07144 = new BitSet(new long[]{0x0000000068000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__1_in_rule__NodeClass__UnorderedGroup_4__07147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__17172 = new BitSet(new long[]{0x0000000068000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__2_in_rule__NodeClass__UnorderedGroup_4__17175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__27200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__0_in_rule__PhysicalThread__UnorderedGroup_37230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl7774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__07833 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__1_in_rule__PhysicalThread__UnorderedGroup_3__07836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__17861 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__2_in_rule__PhysicalThread__UnorderedGroup_3__17864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__27889 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__3_in_rule__PhysicalThread__UnorderedGroup_3__27892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__37917 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__4_in_rule__PhysicalThread__UnorderedGroup_3__37920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__47945 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__5_in_rule__PhysicalThread__UnorderedGroup_3__47948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__57973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_18013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_38044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_08075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_18106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_28137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_18168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_28199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_48230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_18261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_38296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_48331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_18362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_28393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_4_0_28428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_4_1_28463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_4_2_28494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_58525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__PhysicalThread__DefaultAssignment_0_08561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_18600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_3_0_28631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_3_1_28662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_3_2_28693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_3_3_28724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_3_4_28755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_28786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_18817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_28848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_68879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__TextAssignment_18910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_08941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_28972 = new BitSet(new long[]{0x0000000000000002L});

}
