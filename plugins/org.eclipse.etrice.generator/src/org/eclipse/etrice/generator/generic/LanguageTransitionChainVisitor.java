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

import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.ITransitionChainVisitor;
import org.eclipse.etrice.generator.etricegen.TransitionChain;
import org.eclipse.etrice.generator.extensions.Extensions;

import com.google.inject.Inject;

public class LanguageTransitionChainVisitor implements ITransitionChainVisitor {

	private ExpandedActorClass ac;
	@Inject private AbstractLanguageGenerator javaGen;
	@Inject private ILanguageExtension langExt;
	private String typedData = "";
	private String dataArg = "";
	private boolean dataDriven = false;

	LanguageTransitionChainVisitor(ExpandedActorClass ac) {
		this.ac = ac;
	}
	
	void init(TransitionChain tc) {
		if (tc.getTransition() instanceof TriggeredTransition) {
			// we rely on the previous checking during the generator model creation
			VarDecl data = ((TriggeredTransition)tc.getTransition()).getTriggers().get(0).getMsgFromIfPairs().get(0).getMessage().getData();
			
			String[] result = javaGen.getArglistAndTypedData(data);
			dataArg = result[0];
			typedData = result[1];
			dataDriven = false;
		}
		else if (tc.getTransition() instanceof GuardedTransition) {
			dataDriven = true;
		}
	}

	// ITransitionChainVisitor interface
	
	public String genActionOperationCall(Transition tr) {
		if (tr.getAction()!=null && !tr.getAction().getCommands().isEmpty()) {
			if (tr instanceof InitialTransition)
				return Extensions.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else if (dataDriven)
				return Extensions.getActionCodeOperationName(tr)+"("+langExt.selfPointer(false)+");\n";
			else
				return Extensions.getActionCodeOperationName(tr)+"("+langExt.selfPointer(true)+"ifitem"+dataArg+");\n";
		}
		return "";
	}

	public String genEntryOperationCall(State state) {
		return Extensions.getEntryCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genExitOperationCall(State state) {
		return Extensions.getExitCodeOperationName(state)+"("+langExt.selfPointer(false)+");\n";
	}

	public String genElseIfBranch(CPBranchTransition tr, boolean isFirst) {
		String result = "";
		
		if (!isFirst )
			result = "}\nelse ";

		result += "if ("+ac.getCode(tr.getCondition())+") {\n";
		
		return result;
	}

	public String genElseBranch(ContinuationTransition tr) {
		String result = "}\nelse {\n";
		return result;
	}

	public String genEndIf() {
		return "}\n";
	}

	public String genReturnState(State state) {
		return "return " + Extensions.getStateId(state) + ";";
	}

	public String genTypedData() {
		return typedData;
	}

}
