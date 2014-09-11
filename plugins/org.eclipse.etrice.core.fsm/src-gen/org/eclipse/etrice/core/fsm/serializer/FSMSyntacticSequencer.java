package org.eclipse.etrice.core.fsm.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class FSMSyntacticSequencer extends AbstractSyntacticSequencer {

	protected FSMGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q;
	protected AbstractElementAlias match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q;
	protected AbstractElementAlias match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (FSMGrammarAccess) access;
		match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_2()));
		match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_7_2()));
		match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_3_5()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q.equals(syntax))
				emit_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q.equals(syntax))
				emit_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q.equals(syntax))
				emit_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
