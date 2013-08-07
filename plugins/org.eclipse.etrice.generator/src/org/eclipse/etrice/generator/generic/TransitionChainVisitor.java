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
import org.eclipse.etrice.core.genmodel.etricegen.ITransitionChainVisitor;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.CodegenHelpers;

import com.google.inject.Inject;

/**
 * Implementation of the {@link org.eclipse.etrice.core.genmodel.etricegen.ITransitionChainVisitor ITransitionChainVisitor} interface.
 * Uses an {@link org.eclipse.etrice.generator.generic.ILanguageExtension ILanguageExtension} for target language specific things.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class TransitionChainVisitor implements ITransitionChainVisitor {

	@Inject private ILanguageExtension langExt;
	private ExpandedActorClass xpac;
	private boolean dataDriven;

	/**
	 * Constructor
	 * 
	 * @param xpac an {@link ExpandedActorClass}
	 */
	protected TransitionChainVisitor(ExpandedActorClass xpac) {
		this.xpac = xpac;
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

		if (tr.getAction()!=null && !tr.getAction().getLines().isEmpty()) {
			if (tr instanceof InitialTransition)
				return CodegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else if (dataDriven)
				return CodegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else {
				String[] result = langExt.generateArglistAndTypedData(xpac.getData(tr));
				String dataArg = result[0];
				
				return CodegenHelpers.getActionCodeOperationName(tr)+"("+langExt.selfPointer(true)+"ifitem"+dataArg+");\n";
			}
		}
		return "";
	}

	public String genEntryOperationCall(State state) {
		return CodegenHelpers.getEntryCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genExitOperationCall(State state) {
		return CodegenHelpers.getExitCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genElseIfBranch(CPBranchTransition tr, boolean isFirst) {
		String result = "";
		
		if (!isFirst )
			result = "}\nelse ";

		result += "if ("+AbstractGenerator.getInstance().getTranslatedCode(tr.getCondition())+") {\n";
		
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
			return "return " + CodegenHelpers.getGenStateId(state) + ";";
		else
			return "return " + CodegenHelpers.getGenStateId(state) + " + STATE_MAX;";
	}

	public String genTypedData(TransitionChain tc) {
		String[] result = langExt.generateArglistAndTypedData(tc.getData());
		return result[1];
	}

}
