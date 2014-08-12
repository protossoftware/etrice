/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.AbstractGenerator;

import com.google.inject.Inject;

/**
 * base class for 
 * @author Henrik Rentz-Reichert
 *
 */
public class TransitionChainGenerator {

	@Inject ILanguageExtension languageExt;

	public String generateExecuteChain(ExpandedActorClass ac, TransitionChain tc) {
		TransitionChainVisitor tcv = new TransitionChainVisitor(ac);
		AbstractGenerator.getInjector().injectMembers(tcv);
		tcv.init(tc);
		
		return tc.genExecuteChain(tcv);
	}

	public String generateArgumentList(ExpandedActorClass xpac, Transition t) {
		if (t instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		TransitionChain chain = xpac.getChain(t);
		if (!(chain.getTransition() instanceof TriggeredTransition))
			return "";
		
		return generateTypedArgumentList((VarDecl) xpac.getData(t));
	}

	public String generateTypedArgumentList(VarDecl data) {
		return languageExt.generateArglistAndTypedData(data)[2];
	}
}
