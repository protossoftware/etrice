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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase.TypedDataKind;

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
	@Inject private FSMNameProvider fsmNameProvider;
	@Inject private FSMHelpers fsmHelpers;

	public String generateExecuteChain(GraphContainer gc, Link l) {
		TransitionChainVisitor tcv = new TransitionChainVisitor(gc, languageExt, codegenHelpers, translator);
		tcv.init(l.getTransition());
		
		return genExecuteChain(l, tcv);
	}

	public String generateArgumentList(GraphContainer gc, Link l) {
		if (l.getTransition() instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		if (!l.isIfitemTriggered())
			return "";
		
		return languageExt.generateArglistAndTypedData(l.getCommonData())[TypedDataKind.COMMA_SEPARATED_PARAM_IN_DECLARATION.ordinal()];
	}

	public String genExecuteChain(Link l, ITransitionChainVisitor tcv) {
		StringBuilder result = new StringBuilder();
		
		/* TODO: the next generated code declares a correctly typed variable for the generic data.
		 * It is hard to determine whether it is actually needed though.
		 * It is needed in non-initial transitions with action code that are not data driven.
		 * It might be needed in condition expressions. But this code would have to be parsed
		 * with uncertain result (because of e.g. comments).
		 */
		result.append(tcv.genTypedData(l.getTransition()));
		
		genChainCode(l, tcv, result);
		
		return result.toString();
	}
	
	private void genChainCode(Link l, ITransitionChainVisitor tcv, StringBuilder result) {
		
		result.append(tcv.genActionOperationCall(l.getTransition()));
		
		Node target = l.getTarget();
		StateGraphNode stateGraphNode = target.getStateGraphNode();
		List<Link> outgoing = new ArrayList<Link>(target.getOutgoing());
		
		// TODO: remove sorting again
		final CodegenHelpers cgh = new CodegenHelpers();
		Collections.sort(outgoing, new Comparator<Link>() {

			@Override
			public int compare(Link o1, Link o2) {
				String id1 = cgh.getGenChainId(o1.getTransition());
				String id2 = cgh.getGenChainId(o2.getTransition());
				return id1.compareTo(id2);
			}
			
		});
		
		if (stateGraphNode instanceof ChoicePoint) {
			Link dflt = FsmGenExtensions.getChoicepointDefaultBranch(target);
			assert(dflt!=null): "ChoicePoint "+fsmNameProvider.getFullPath(stateGraphNode)+" has no default branch!";
			
			// first generate all choicepoint branches as if/else
			boolean isFirst = true;
			for (Link cond : outgoing) {
				if (cond==dflt)
					continue;
				
				assert(cond.getTransition() instanceof CPBranchTransition): "The non default ChoicePoint branch "
					+fsmNameProvider.getFullPath(cond.getTransition())+" must be of type CPBranchTransition!";
				
				result.append(tcv.genElseIfBranch((CPBranchTransition) cond.getTransition(), isFirst));
				isFirst = false;

				genChainCode(cond, tcv, result);
			}
			
			// then generate the default branch
			result.append(tcv.genElseBranch((ContinuationTransition) dflt.getTransition()));
			
			genChainCode(dflt, tcv, result);
			
			result.append(tcv.genEndIf());
		}
		else {
			if (stateGraphNode instanceof TrPoint) {
				if (stateGraphNode instanceof TransitionPoint) {
					// TransitionPoint is final destination of the chain
					result.append(tcv.genReturnState(fsmHelpers.getParentState(stateGraphNode), false));
					return;
				}	
				else {
					assert(outgoing.size()<=1): "TrPoint "+fsmNameProvider.getFullPath(stateGraphNode)
								+" is expected to have at most one outgoing transition!";
					if (outgoing.size()==1) {
						State state = fsmHelpers.getParentState(stateGraphNode);
						if (stateGraphNode instanceof EntryPoint) {
							if (state!=null && !target.isInherited() && fsmHelpers.hasEntryCode(state, true))
								result.append(tcv.genEntryOperationCall(state));
						}
						else if (stateGraphNode instanceof ExitPoint) {
							if (state!=null && !target.isInherited() && fsmHelpers.hasExitCode(state, true))
								result.append(tcv.genExitOperationCall(state));
						}
						else {
							assert(false): "unexpected sub type";
						}
					}
				}
				if (! outgoing.isEmpty()) {
					genChainCode(outgoing.get(0), tcv, result);
				}
			}
			else {
				// the following assertion should always hold true
				assert(stateGraphNode instanceof State): "A transition target can be a ChoicePoint, a TrPoint or a State!";
				
				result.append(tcv.genReturnState((State) stateGraphNode, true));
			}
		}
	}
}
