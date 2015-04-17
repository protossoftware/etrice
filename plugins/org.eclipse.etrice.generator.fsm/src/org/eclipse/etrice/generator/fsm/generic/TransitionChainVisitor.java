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

import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ITransitionChainVisitor;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers;

/**
 * Implementation of the {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ITransitionChainVisitor ITransitionChainVisitor} interface.
 * Uses an {@link org.eclipse.etrice.generator.generic.ILanguageExtension ILanguageExtension} for target language specific things.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class TransitionChainVisitor implements ITransitionChainVisitor {

	private FSMHelpers fsmHelpers = new FSMHelpers();
	
	// Initialized in constructor
	private ExpandedModelComponent xpac;
	private ILanguageExtensionBase langExt;
	private CodegenHelpers codegenHelpers;
	private IDetailCodeTranslator translationProvider;
	private boolean dataDriven;

	/**
	 * Constructor
	 * 
	 * @param xpac an {@link ExpandedModelComponent}
	 * @param codegenHelpers 
	 * @param languageExt 
	 */
	protected TransitionChainVisitor(
			ExpandedModelComponent xpac,
			ILanguageExtensionBase languageExt,
			CodegenHelpers codegenHelpers,
			IDetailCodeTranslator translationProvider
	) {
		this.xpac = xpac;
		this.langExt = languageExt;
		this.codegenHelpers = codegenHelpers;
		this.translationProvider = translationProvider;
	}
	
	protected void init(TransitionChain tc) {
		dataDriven = false;
		
		if (tc.getTransition() instanceof GuardedTransition) {
			dataDriven = true;
		}
		else if (tc.getTransition() instanceof InitialTransition) {
			dataDriven = true;
		}
	}

	// ITransitionChainVisitor interface
	
	public String genActionOperationCall(Transition tr) {

		if (fsmHelpers.hasDetailCode(tr.getAction())) {
			if (tr instanceof InitialTransition)
				return codegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else if (dataDriven)
				return codegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else {
				String[] result = langExt.generateArglistAndTypedData(xpac.getData(tr));
				String dataArg = result[0];
				
				return codegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(true)+"ifitem"+dataArg+");\n";
			}
		}
		return "";
	}

	public String genEntryOperationCall(State state) {
		return codegenHelpers.getEntryCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genExitOperationCall(State state) {
		return codegenHelpers.getExitCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genElseIfBranch(CPBranchTransition tr, boolean isFirst) {
		String result = "";
		
		if (!isFirst )
			result = "}\nelse ";

		result += "if ("+translationProvider.getTranslatedCode(tr.getCondition())+") {\n";
		
		return result;
	}

	public String genElseBranch(ContinuationTransition tr) {
		String result = "}\nelse {\n";
		return result;
	}

	public String genEndIf() {
		return "}\n";
	}

	public String genReturnState(State state, boolean executeEntryCode) {
		if (executeEntryCode)
			return "return " + codegenHelpers.getGenStateId(state) + ";";
		else
			return "return " + codegenHelpers.getGenStateId(state) + " + STATE_MAX;";
	}

	public String genTypedData(TransitionChain tc) {
		String[] result = langExt.generateArglistAndTypedData(tc.getData());
		return result[1];
	}

}
