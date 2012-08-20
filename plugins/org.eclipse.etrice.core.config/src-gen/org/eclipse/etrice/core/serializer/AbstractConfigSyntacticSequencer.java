package org.eclipse.etrice.core.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.services.ConfigGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractConfigSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ConfigGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_a;
	protected AbstractElementAlias match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_p;
	protected AbstractElementAlias match_AttrClassConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q;
	protected AbstractElementAlias match_AttrInstanceConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ConfigGrammarAccess) access;
		match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_a = new TokenAlias(true, true, grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1());
		match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_p = new TokenAlias(true, false, grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1());
		match_AttrClassConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3()));
		match_AttrInstanceConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_3()));
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
			if(match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_a.equals(syntax))
				emit_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_p.equals(syntax))
				emit_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AttrClassConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q.equals(syntax))
				emit_AttrClassConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AttrInstanceConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q.equals(syntax))
				emit_AttrInstanceConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '}'*
	 */
	protected void emit_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '}'+
	 */
	protected void emit_ActorInstanceConfig_RightCurlyBracketKeyword_1_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_AttrClassConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_AttrInstanceConfig___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
