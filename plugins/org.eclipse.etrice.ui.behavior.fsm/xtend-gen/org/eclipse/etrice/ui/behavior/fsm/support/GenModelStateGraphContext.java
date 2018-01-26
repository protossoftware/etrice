/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.fsm.support;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.BaseDiagramProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.GenModelProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.BaseDiagramPositionProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.IPositionProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.IStateGraphContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * StateGraphContext based on newfsmgen.
 */
@SuppressWarnings("all")
public class GenModelStateGraphContext implements IStateGraphContext {
  private final GenModelProvider genModel;
  
  private final BaseDiagramPositionProvider baseDiagram;
  
  private final Graph graph;
  
  public GenModelStateGraphContext(final AbstractFSMDiagramTypeProvider diagramTypeProvider) {
    this.genModel = diagramTypeProvider.getGenModelProvider();
    BaseDiagramProvider _baseDiagramProvider = new BaseDiagramProvider(diagramTypeProvider);
    BaseDiagramPositionProvider _baseDiagramPositionProvider = new BaseDiagramPositionProvider(_baseDiagramProvider);
    this.baseDiagram = _baseDiagramPositionProvider;
    this.graph = this.genModel.getModel().getGraph();
  }
  
  public GenModelStateGraphContext(final Graph graph, final GenModelStateGraphContext other) {
    this.genModel = other.genModel;
    this.baseDiagram = other.baseDiagram;
    this.graph = graph;
  }
  
  @Override
  public List<ChoicePoint> getChPoints() {
    final Function1<Node, StateGraphNode> _function = (Node it) -> {
      return it.getStateGraphNode();
    };
    return IterableExtensions.<ChoicePoint>toList(Iterables.<ChoicePoint>filter(ListExtensions.<Node, StateGraphNode>map(this.graph.getNodes(), _function), ChoicePoint.class));
  }
  
  @Override
  public List<IStateGraphContext> getChildren() {
    final Function1<Node, Boolean> _function = (Node it) -> {
      Graph _subgraph = it.getSubgraph();
      return Boolean.valueOf((_subgraph != null));
    };
    final Function1<Node, IStateGraphContext> _function_1 = (Node it) -> {
      Graph _subgraph = it.getSubgraph();
      GenModelStateGraphContext _genModelStateGraphContext = new GenModelStateGraphContext(_subgraph, this);
      return ((IStateGraphContext) _genModelStateGraphContext);
    };
    return IterableExtensions.<IStateGraphContext>toList(IterableExtensions.<Node, IStateGraphContext>map(IterableExtensions.<Node>filter(this.graph.getNodes(), _function), _function_1));
  }
  
  @Override
  public StateGraph getInitialPoint() {
    StateGraph _xifexpression = null;
    final Function1<Link, TransitionBase> _function = (Link it) -> {
      return it.getTransition();
    };
    boolean _isEmpty = IterableExtensions.isEmpty(Iterables.<InitialTransition>filter(ListExtensions.<Link, TransitionBase>map(this.graph.getLinks(), _function), InitialTransition.class));
    boolean _not = (!_isEmpty);
    if (_not) {
      _xifexpression = this.graph.getStateGraph();
    }
    return _xifexpression;
  }
  
  @Override
  public State getParentState() {
    StateGraphNode _stateGraphNode = this.graph.getNode().getStateGraphNode();
    return ((State) _stateGraphNode);
  }
  
  @Override
  public IPositionProvider getPositionProvider() {
    return this.baseDiagram;
  }
  
  @Override
  public StateGraph getStateGraph() {
    return this.graph.getStateGraph();
  }
  
  @Override
  public List<State> getStates() {
    final Function1<Node, StateGraphNode> _function = (Node it) -> {
      return it.getStateGraphNode();
    };
    return IterableExtensions.<State>toList(Iterables.<State>filter(ListExtensions.<Node, StateGraphNode>map(this.graph.getNodes(), _function), State.class));
  }
  
  @Override
  public List<TrPoint> getTrPoints() {
    final Function1<Node, StateGraphNode> _function = (Node it) -> {
      return it.getStateGraphNode();
    };
    return IterableExtensions.<TrPoint>toList(Iterables.<TrPoint>filter(ListExtensions.<Node, StateGraphNode>map(this.graph.getNodes(), _function), TrPoint.class));
  }
  
  @Override
  public List<Transition> getTransitions() {
    List<Transition> _xblockexpression = null;
    {
      final Function1<Link, TransitionBase> _function = (Link it) -> {
        return it.getTransition();
      };
      final List<TransitionBase> baseTransitions = ListExtensions.<Link, TransitionBase>map(this.graph.getLinks(), _function);
      Iterable<Transition> _filter = Iterables.<Transition>filter(baseTransitions, Transition.class);
      final Function1<RefinedTransition, Transition> _function_1 = (RefinedTransition it) -> {
        return it.getTarget();
      };
      Iterable<Transition> _map = IterableExtensions.<RefinedTransition, Transition>map(Iterables.<RefinedTransition>filter(baseTransitions, RefinedTransition.class), _function_1);
      _xblockexpression = IterableExtensions.<Transition>toList(Iterables.<Transition>concat(_filter, _map));
    }
    return _xblockexpression;
  }
}
