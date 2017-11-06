/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class BasicFsmGenBuilder {
  @Inject
  @Extension
  protected FSMHelpers fsmHelpers;
  
  protected final FsmGenFactory factory = FsmGenFactory.eINSTANCE;
  
  private int inheritanceLevel = 0;
  
  public BasicFsmGenBuilder(final Injector injector) {
    injector.injectMembers(this);
  }
  
  protected BasicFsmGenBuilder() {
  }
  
  public GraphContainer createTransformedModel(final ModelComponent mc) {
    return this.createContainer(mc);
  }
  
  private GraphContainer createContainer(final ModelComponent mc) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(mc);
    final GraphContainer _result;
    synchronized (_createCache_createContainer) {
      if (_createCache_createContainer.containsKey(_cacheKey)) {
        return _createCache_createContainer.get(_cacheKey);
      }
      GraphContainer _createGraphContainer = this.factory.createGraphContainer();
      _result = _createGraphContainer;
      _createCache_createContainer.put(_cacheKey, _result);
    }
    _init_createContainer(_result, mc);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, GraphContainer> _createCache_createContainer = CollectionLiterals.newHashMap();
  
  private void _init_createContainer(final GraphContainer it, final ModelComponent mc) {
    it.setComponent(mc);
    it.setGraph(this.createStateMachine(mc));
  }
  
  private Graph createStateMachine(final ModelComponent mc) {
    Graph _xblockexpression = null;
    {
      final StateGraph superFSM = this.fsmHelpers.getSuperStateMachine(mc);
      Graph _xifexpression = null;
      if ((superFSM != null)) {
        Graph _xblockexpression_1 = null;
        {
          final Graph baseGraph = this.createStateMachine(this.fsmHelpers.getModelComponent(superFSM));
          this.inheritanceLevel++;
          _xblockexpression_1 = this.mergeGraph(baseGraph, this.fsmHelpers.getActualStateMachine(mc));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        Graph _xifexpression_1 = null;
        StateGraph _actualStateMachine = this.fsmHelpers.getActualStateMachine(mc);
        boolean _tripleNotEquals = (_actualStateMachine != null);
        if (_tripleNotEquals) {
          StateGraph _actualStateMachine_1 = this.fsmHelpers.getActualStateMachine(mc);
          Graph _createGraph = null;
          if (_actualStateMachine_1!=null) {
            _createGraph=this.createGraph(_actualStateMachine_1);
          }
          _xifexpression_1 = _createGraph;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private Graph mergeGraph(final Graph graph, final StateGraph sg) {
    final Consumer<Node> _function = new Consumer<Node>() {
      @Override
      public void accept(final Node it) {
        it.setInherited(true);
      }
    };
    graph.getNodes().forEach(_function);
    final Consumer<Link> _function_1 = new Consumer<Link>() {
      @Override
      public void accept(final Link it) {
        it.setInherited(true);
      }
    };
    graph.getLinks().forEach(_function_1);
    this.createContents(graph, sg);
    graph.setStateGraph(sg);
    return graph;
  }
  
  private Graph createGraph(final StateGraph sg) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(sg);
    final Graph _result;
    synchronized (_createCache_createGraph) {
      if (_createCache_createGraph.containsKey(_cacheKey)) {
        return _createCache_createGraph.get(_cacheKey);
      }
      Graph _createGraph = this.factory.createGraph();
      _result = _createGraph;
      _createCache_createGraph.put(_cacheKey, _result);
    }
    _init_createGraph(_result, sg);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Graph> _createCache_createGraph = CollectionLiterals.newHashMap();
  
  private void _init_createGraph(final Graph it, final StateGraph sg) {
    it.setStateGraph(sg);
    this.createContents(it, sg);
  }
  
  private void createContents(final Graph graph, final StateGraph sg) {
    final Function1<ChoicePoint, Node> _function = new Function1<ChoicePoint, Node>() {
      @Override
      public Node apply(final ChoicePoint it) {
        return BasicFsmGenBuilder.this.createNode(it);
      }
    };
    graph.getNodes().addAll(ListExtensions.<ChoicePoint, Node>map(sg.getChPoints(), _function));
    final Function1<TrPoint, Node> _function_1 = new Function1<TrPoint, Node>() {
      @Override
      public Node apply(final TrPoint it) {
        return BasicFsmGenBuilder.this.createNode(it);
      }
    };
    graph.getNodes().addAll(ListExtensions.<TrPoint, Node>map(sg.getTrPoints(), _function_1));
    final Function1<SimpleState, Node> _function_2 = new Function1<SimpleState, Node>() {
      @Override
      public Node apply(final SimpleState it) {
        return BasicFsmGenBuilder.this.createNode(it);
      }
    };
    Iterables.<Node>addAll(graph.getNodes(), IterableExtensions.<SimpleState, Node>map(Iterables.<SimpleState>filter(sg.getStates(), SimpleState.class), _function_2));
    final Function1<Transition, Link> _function_3 = new Function1<Transition, Link>() {
      @Override
      public Link apply(final Transition it) {
        return BasicFsmGenBuilder.this.createLink(it);
      }
    };
    graph.getLinks().addAll(ListExtensions.<Transition, Link>map(sg.getTransitions(), _function_3));
    final Consumer<RefinedState> _function_4 = new Consumer<RefinedState>() {
      @Override
      public void accept(final RefinedState it) {
        BasicFsmGenBuilder.this.handleRefinedState(it);
      }
    };
    Iterables.<RefinedState>filter(sg.getStates(), RefinedState.class).forEach(_function_4);
    final Consumer<RefinedTransition> _function_5 = new Consumer<RefinedTransition>() {
      @Override
      public void accept(final RefinedTransition it) {
        BasicFsmGenBuilder.this.handleRefinedTransition(it);
      }
    };
    sg.getRefinedTransitions().forEach(_function_5);
  }
  
  private void handleRefinedState(final RefinedState s) {
    final Node refinedNode = this.createNode(this.fsmHelpers.getFinalTarget(s));
    StateGraph _subgraph = s.getSubgraph();
    boolean _tripleNotEquals = (_subgraph != null);
    if (_tripleNotEquals) {
      Graph _subgraph_1 = refinedNode.getSubgraph();
      boolean _tripleNotEquals_1 = (_subgraph_1 != null);
      if (_tripleNotEquals_1) {
        this.mergeGraph(refinedNode.getSubgraph(), s.getSubgraph());
      } else {
        refinedNode.setSubgraph(this.createGraph(s.getSubgraph()));
      }
    }
    final Node target = refinedNode;
    target.setStateGraphNode(s);
  }
  
  private void handleRefinedTransition(final RefinedTransition t) {
    Link _createLink = this.createLink(t.getTarget());
    _createLink.setTransition(t);
  }
  
  private Link createLink(final Transition tr) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(tr);
    final Link _result;
    synchronized (_createCache_createLink) {
      if (_createCache_createLink.containsKey(_cacheKey)) {
        return _createCache_createLink.get(_cacheKey);
      }
      Link _createLink = this.factory.createLink();
      _result = _createLink;
      _createCache_createLink.put(_cacheKey, _result);
    }
    _init_createLink(_result, tr);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Link> _createCache_createLink = CollectionLiterals.newHashMap();
  
  private void _init_createLink(final Link it, final Transition tr) {
    it.setTransition(tr);
    Node _xifexpression = null;
    if ((tr instanceof NonInitialTransition)) {
      _xifexpression = this.createNode(((NonInitialTransition)tr).getFrom());
    }
    it.setSource(_xifexpression);
    it.setTarget(this.createNode(tr.getTo()));
  }
  
  private Node _createNode(final StateGraphNode s) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(s);
    final Node _result;
    synchronized (_createCache_createNode) {
      if (_createCache_createNode.containsKey(_cacheKey)) {
        return _createCache_createNode.get(_cacheKey);
      }
      Node _createNode = this.factory.createNode();
      _result = _createNode;
      _createCache_createNode.put(_cacheKey, _result);
    }
    _init_createNode(_result, s);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Node> _createCache_createNode = CollectionLiterals.newHashMap();
  
  private void _init_createNode(final Node it, final StateGraphNode s) {
    it.setStateGraphNode(s);
    it.setInheritanceLevel(this.inheritanceLevel);
    Graph _xifexpression = null;
    if ((s instanceof State)) {
      StateGraph _subgraph = ((State)s).getSubgraph();
      Graph _createGraph = null;
      if (_subgraph!=null) {
        _createGraph=this.createGraph(_subgraph);
      }
      _xifexpression = _createGraph;
    }
    it.setSubgraph(_xifexpression);
  }
  
  private Node _createNode(final ChoicepointTerminal tt) {
    return this.createNode(tt.getCp());
  }
  
  private Node _createNode(final TrPointTerminal tt) {
    return this.createNode(tt.getTrPoint());
  }
  
  private Node _createNode(final StateTerminal tt) {
    return this.createNode(tt.getState());
  }
  
  private Node _createNode(final SubStateTrPointTerminal tt) {
    return this.createNode(tt.getTrPoint());
  }
  
  private Node createNode(final EObject tt) {
    if (tt instanceof ChoicepointTerminal) {
      return _createNode((ChoicepointTerminal)tt);
    } else if (tt instanceof StateGraphNode) {
      return _createNode((StateGraphNode)tt);
    } else if (tt instanceof StateTerminal) {
      return _createNode((StateTerminal)tt);
    } else if (tt instanceof SubStateTrPointTerminal) {
      return _createNode((SubStateTrPointTerminal)tt);
    } else if (tt instanceof TrPointTerminal) {
      return _createNode((TrPointTerminal)tt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tt).toString());
    }
  }
}
