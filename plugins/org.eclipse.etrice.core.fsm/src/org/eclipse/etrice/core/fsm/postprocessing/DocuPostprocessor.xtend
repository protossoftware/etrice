/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

/**
 * This post processor adds documentation to the generated EMF model.
 * By intention no {@code null} checks are performed. This way developers
 * find easier if the referenced class, attribute or reference isn't found.
 */
class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.getEPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("AbstractMessage")
		cls.setDocumentation('''
			A message in ROOM is part of a {@link ProtocolClass}. Messages are exchanged via {@link Port}s.
			For event driven protocols the message is an object that is deliverd using a message
			service of the runtime. For data driven systems only messages holding data are valid. In this
			case the conjugate port is the one holding (and writing) the data and the regular port is
			reading the data.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				An abstract message to be overridden in derived grammars.
				By this name the message is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("AbstractInterfaceItem")
		cls.setDocumentation('''
			An abstract interface item to be overridden in derived grammars.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the interface item is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraphNode")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link State}</li>
			  <li>{@link ChoicePoint}</li>
			  <li>{@link TrPoint}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraphItem")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link StateGraphNode}</li>
			  <li>{@link Transition}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("State")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link SimpleState}</li>
			  <li>{@link RefinedState}</li>
			</ul>
		''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("entryCode").setDocumentation(
			'''
				This is an optional entry code written in the code generator's target language.
				It is executed when the state is entered.
			''')
		
		cls.getReference("exitCode").setDocumentation(
			'''
				This is an optional entry code written in the code generator's target language.
				It is executed when the state is left.
			''')
		
		cls.getReference("doCode").setDocumentation(
			'''
				This is an optional do code written in the code generator's target language.
				It is executed whenever the actor instance is polled (applies only to
				data driven and sync actor classes).
			''')
			
		cls.getReference("subgraph").setDocumentation(
			'''
				This is an optional sub state graph of this state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraph")
		cls.setDocumentation('''
			A state graph is a directed graph composed of
			{@link StateGraphNode}s as nodes and {@link Transition}s as edges.
		''')
			
		cls.getReference("states").setDocumentation(
			'''
				This is a list of all states of this state graph.
			''')
			
		cls.getReference("trPoints").setDocumentation(
			'''
				This is a list of all transition, entry and exit points of this state graph.
			''')
			
		cls.getReference("chPoints").setDocumentation(
			'''
				This is a list of all choice points of this state graph.
			''')
			
		cls.getReference("transitions").setDocumentation(
			'''
				This is a list of all transitions of this state graph.
			''')
			
		cls.getReference("refinedTransitions").setDocumentation(
			'''
				This is a list of all refined transitions of this state graph.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SimpleState")
		cls.setDocumentation('''
			A simple state is the standard case of a @link State}.
			It comprises and <em>entry</em>, <em>exit</em> and <em>do</em> code
			and it can contain another {@link StateGraph} as sub state
			graph.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the state is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefinedState")
		cls.setDocumentation('''
			A refined state can be used only in a derived {@link ActorClass}.
			It refers to a {@link State} in the inherited state machine
			which is refined by adding detail code and/or
			{@link StateGraphItem}s in the sub state graph.
		''')
			
		cls.getReference("target").setDocumentation(
			'''
				This is the referenced state in the base class state machine.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("DetailCode")
		cls.setDocumentation('''
			The detail code contains a list of strings which
			are considered verbatim code of the code generator
			target language.
			
			<p>
			The detail code is parsed by the {@link org.eclipse.etrice.generator.base.DetailCodeTranslator}
			which replaces certain frequent constructs like access of members
			and sending a message via a port by target language specific code.
			</p>
		''')
			
		cls.getAttribute("lines").setDocumentation(
			'''
				This is a list of commands in the code generator's target language.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TrPoint")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TransitionPoint}</li>
			  <li>{@link EntryPoint}</li>
			  <li>{@link ExitPoint}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the transition, entry or exit point is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionPoint")
		cls.setDocumentation('''
			A transition point is located at the border of a {@link State}
			and is not visible or accessible outside. It is used
			to globally handle messages. If a {@link Transition} starting
			at a transition point triggers then exit and entry codes
			are executed as usual as long as the handler flag of the
			transition point isn't set.
		''')
		
		cls.getAttribute("handler").setDocumentation(
			'''
				If this flag is {@code true} then for a transition triggerd from this point
				no exit and entry codes of the states left and entered are executed.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("EntryPoint")
		cls.setDocumentation('''
			An entry point is located at the border of a {@link State}
			and is visible and accessible outside. Outside
			it can be the target of a {@link Transition} and inside the source.
			If it is not connected in the interior then it is a
			<em>transition to history</em>.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ExitPoint")
		cls.setDocumentation('''
			An exit point is located at the border of a {@link State}
			and is visible and accessible outside. Outside
			it can be the source of a {@link Transition} and inside the target.
			If it is not connected in the interior then it is a
			<em>group transition</em>.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ChoicePoint")
		cls.setDocumentation('''
			A choice point corresponds to an {@code if else} construct.
			It is the target of one or more {@link Transition}s and the
			source of several {@link Transition}s.
			One outgoing transitions must be a {@link ContinuationTransition}
			and corresponds to the final else. It is called the
			<em>default branch</em> of the choice point.
			All other outgoing transitions have to be {@link CPBranchTransition}s.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the choice point is referred to in the model.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Transition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link InitialTransition}</li>
			  <li>{@link NonInitialTransition}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				This is an optional name of the transition.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("to").setDocumentation(
			'''
				This is the target node of the transition.
			''')
		
		cls.getReference("action").setDocumentation(
			'''
				This is an optional code in the code generator's target language.
				It is execute when the transition fires.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("NonInitialTransition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TransitionChainStartTransition}</li>
			  <li>{@link ContinuationTransition}</li>
			  <li>{@link CPBranchTransition}</li>
			</ul>
		''')
		
		cls.getReference("from").setDocumentation(
			'''
				This is the source node of the transition.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionChainStartTransition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TriggeredTransition}</li>
			  <li>{@link GuardedTransition}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("InitialTransition")
		cls.setDocumentation('''
			There can be at most one initial transition in a {@link StateGraph}.
			It defines the starting point of the state graph and is traversed
			exactly once when the state graph is accessed for the first time.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ContinuationTransition")
		cls.setDocumentation('''
			Continuation transitions start at entry or exit points
			({@link EntryPoint}s or {@link ExitPoint}s) or form
			the default branch of a {@link ChoicePoint}.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TriggeredTransition")
		cls.setDocumentation('''
			Triggered transitions start at a {@link State} or a {@link TransitionPoint}.
			It defines a list of {@link Trigger}s that specify the conditions
			when the transition fires and is traversed. This kind of
			transition is only allowed in event driven and mixed (async) state
			machines.
		''')
		
		cls.getReference("triggers").setDocumentation(
			'''
				This is a list of all triggers of the transition.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("GuardedTransition")
		cls.setDocumentation('''
			A guarded transition is very similar to a {@link CPBranchTransition}.
			It defines a guard condition which lets the transition fire if
			evaluated to {@code true}. This kind of transition is only
			allowed in data driven or moixed (async) state machines.
		''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is the guard condition of the transition specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("CPBranchTransition")
		cls.setDocumentation('''
			The choice point branch transitions is allowed only as outgoing
			transition of {@link ChoicePoint}s.
		''')
		
		cls.getReference("condition").setDocumentation(
			'''
				This is the condition of the choice point branch specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefinedTransition")
		cls.setDocumentation('''
			The refined transition is only allowed in {@link StateGraph}s
			of derived {@link ActorClass}es. It targets a {@link Transition}
			of the base class state machine.
		''')
		
		cls.getReference("action").setDocumentation(
			'''
				This is an optional code in the code generator's target language.
				It is execute when the transition fires.
			''')
			
		cls.getReference("target").setDocumentation(
			'''
				This is the referenced transition in the base class state machine.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionTerminal")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link StateTerminal}</li>
			  <li>{@link TrPointTerminal}</li>
			  <li>{@link SubStateTrPointTerminal}</li>
			  <li>{@link ChoicepointTerminal}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link State}.
		''')
			
		cls.getReference("state").setDocumentation(
			'''
				This is the target state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TrPointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a local {@link TrPoint}.
		''')
			
		cls.getReference("trPoint").setDocumentation(
			'''
				This is the target transition, entry or exit point.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubStateTrPointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link TrPoint} of a sub {@link State}.
		''')
			
		cls.getReference("state").setDocumentation(
			'''
				This is the target state.
			''')
			
		cls.getReference("trPoint").setDocumentation(
			'''
				This is the target entry or exit point contained in the target state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ChoicepointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link ChoicepointTerminal}.
		''')
			
		cls.getReference("cp").setDocumentation(
			'''
				This is the target choice point.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Trigger")
		cls.setDocumentation('''
			A transition trigger is a list of {@link MessageFromIf} pairs
			and an optional {@link Guard}.
		''')
			
		cls.getReference("msgFromIfPairs").setDocumentation(
			'''
				This is a list of message/interface item pairs.
			''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is an optional guard condition of the trigger specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("MessageFromIf")
		cls.setDocumentation('''
			A pair consisting of a {@link Message} arising from an
			{@link InterfaceItem}.
		''')
		
		cls.getReference("message").setDocumentation(
			'''
				This is the triggerering message (or event).
			''')
		
		cls.getReference("from").setDocumentation(
			'''
				This is the interface item where the message occurred.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Guard")
		cls.setDocumentation('''
			A detail code that evaluates to a boolean in the target
			language.
		''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is a guard condition specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')
	
	}
	
}