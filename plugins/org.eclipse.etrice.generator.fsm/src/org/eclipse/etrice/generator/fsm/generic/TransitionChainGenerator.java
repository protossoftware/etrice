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

package org.eclipse.etrice.generator.fsm.generic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers;

import com.google.inject.Inject;

/**
 * base class for 
 * @author Henrik Rentz-Reichert
 *
 */
public class TransitionChainGenerator {

	@Inject private ILanguageExtensionBase languageExt;
	@Inject private CodegenHelpers codegenHelpers;
	@Inject private IDetailCodeTranslator translator;

	public String generateExecuteChain(ExpandedModelComponent xpmc, TransitionChain tc) {
		TransitionChainVisitor tcv = new TransitionChainVisitor(xpmc, languageExt, codegenHelpers, translator);
		tcv.init(tc);
		
		return tc.genExecuteChain(tcv);
	}

	public String generateArgumentList(ExpandedModelComponent xpmc, Transition t) {
		if (t instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		TransitionChain chain = xpmc.getChain(t);
		if (!(chain.getTransition() instanceof TriggeredTransition))
			return "";
		
		return generateTypedArgumentList(xpmc.getData(t));
	}

	public String generateTypedArgumentList(EObject data) {
		return languageExt.generateArglistAndTypedData(data)[2];
	}
}
