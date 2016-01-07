package org.eclipse.etrice.core.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
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
public class RoomSyntacticSequencer extends AbstractSyntacticSequencer {

	protected RoomGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ActorClass___BehaviorKeyword_9_0_LeftCurlyBracketKeyword_9_2_RightCurlyBracketKeyword_9_6__q;
	protected AbstractElementAlias match_ActorClass___InterfaceKeyword_7_0_LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__q;
	protected AbstractElementAlias match_ActorClass___StructureKeyword_8_0_LeftCurlyBracketKeyword_8_2_RightCurlyBracketKeyword_8_7__q;
	protected AbstractElementAlias match_ActorInstanceMapping___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q;
	protected AbstractElementAlias match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q;
	protected AbstractElementAlias match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q;
	protected AbstractElementAlias match_PortOperation___ColonKeyword_5_0_0_VoidKeyword_5_0_1_0__q;
	protected AbstractElementAlias match_ProtocolClass___IncomingKeyword_10_0_LeftCurlyBracketKeyword_10_1_RightCurlyBracketKeyword_10_3__q;
	protected AbstractElementAlias match_ProtocolClass___OutgoingKeyword_11_0_LeftCurlyBracketKeyword_11_1_RightCurlyBracketKeyword_11_3__q;
	protected AbstractElementAlias match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q;
	protected AbstractElementAlias match_StandardOperation___ColonKeyword_6_0_VoidKeyword_6_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (RoomGrammarAccess) access;
		match_ActorClass___BehaviorKeyword_9_0_LeftCurlyBracketKeyword_9_2_RightCurlyBracketKeyword_9_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9_6()));
		match_ActorClass___InterfaceKeyword_7_0_LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3()));
		match_ActorClass___StructureKeyword_8_0_LeftCurlyBracketKeyword_8_2_RightCurlyBracketKeyword_8_7__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getActorClassAccess().getStructureKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2()), new TokenAlias(false, false, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7()));
		match_ActorInstanceMapping___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getActorInstanceMappingAccess().getRightCurlyBracketKeyword_4_2()));
		match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_2()));
		match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_7_2()));
		match_PortOperation___ColonKeyword_5_0_0_VoidKeyword_5_0_1_0__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0()), new TokenAlias(false, false, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0()));
		match_ProtocolClass___IncomingKeyword_10_0_LeftCurlyBracketKeyword_10_1_RightCurlyBracketKeyword_10_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0()), new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1()), new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3()));
		match_ProtocolClass___OutgoingKeyword_11_0_LeftCurlyBracketKeyword_11_1_RightCurlyBracketKeyword_11_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0()), new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1()), new TokenAlias(false, false, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3()));
		match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_3_5()));
		match_StandardOperation___ColonKeyword_6_0_VoidKeyword_6_1_0__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0()));
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
			if(match_ActorClass___BehaviorKeyword_9_0_LeftCurlyBracketKeyword_9_2_RightCurlyBracketKeyword_9_6__q.equals(syntax))
				emit_ActorClass___BehaviorKeyword_9_0_LeftCurlyBracketKeyword_9_2_RightCurlyBracketKeyword_9_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ActorClass___InterfaceKeyword_7_0_LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__q.equals(syntax))
				emit_ActorClass___InterfaceKeyword_7_0_LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ActorClass___StructureKeyword_8_0_LeftCurlyBracketKeyword_8_2_RightCurlyBracketKeyword_8_7__q.equals(syntax))
				emit_ActorClass___StructureKeyword_8_0_LeftCurlyBracketKeyword_8_2_RightCurlyBracketKeyword_8_7__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ActorInstanceMapping___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q.equals(syntax))
				emit_ActorInstanceMapping___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q.equals(syntax))
				emit_ContinuationTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q.equals(syntax))
				emit_InitialTransition___LeftCurlyBracketKeyword_7_0_RightCurlyBracketKeyword_7_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PortOperation___ColonKeyword_5_0_0_VoidKeyword_5_0_1_0__q.equals(syntax))
				emit_PortOperation___ColonKeyword_5_0_0_VoidKeyword_5_0_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ProtocolClass___IncomingKeyword_10_0_LeftCurlyBracketKeyword_10_1_RightCurlyBracketKeyword_10_3__q.equals(syntax))
				emit_ProtocolClass___IncomingKeyword_10_0_LeftCurlyBracketKeyword_10_1_RightCurlyBracketKeyword_10_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ProtocolClass___OutgoingKeyword_11_0_LeftCurlyBracketKeyword_11_1_RightCurlyBracketKeyword_11_3__q.equals(syntax))
				emit_ProtocolClass___OutgoingKeyword_11_0_LeftCurlyBracketKeyword_11_1_RightCurlyBracketKeyword_11_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q.equals(syntax))
				emit_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StandardOperation___ColonKeyword_6_0_VoidKeyword_6_1_0__q.equals(syntax))
				emit_StandardOperation___ColonKeyword_6_0_VoidKeyword_6_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('Behavior' '{' '}')?
	 */
	protected void emit_ActorClass___BehaviorKeyword_9_0_LeftCurlyBracketKeyword_9_2_RightCurlyBracketKeyword_9_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('Interface' '{' '}')?
	 */
	protected void emit_ActorClass___InterfaceKeyword_7_0_LeftCurlyBracketKeyword_7_1_RightCurlyBracketKeyword_7_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('Structure' '{' '}')?
	 */
	protected void emit_ActorClass___StructureKeyword_8_0_LeftCurlyBracketKeyword_8_2_RightCurlyBracketKeyword_8_7__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_ActorInstanceMapping___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
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
	 *     (':' 'void')?
	 */
	protected void emit_PortOperation___ColonKeyword_5_0_0_VoidKeyword_5_0_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('incoming' '{' '}')?
	 */
	protected void emit_ProtocolClass___IncomingKeyword_10_0_LeftCurlyBracketKeyword_10_1_RightCurlyBracketKeyword_10_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('outgoing' '{' '}')?
	 */
	protected void emit_ProtocolClass___OutgoingKeyword_11_0_LeftCurlyBracketKeyword_11_1_RightCurlyBracketKeyword_11_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_SimpleState___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_5__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (':' 'void')?
	 */
	protected void emit_StandardOperation___ColonKeyword_6_0_VoidKeyword_6_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
