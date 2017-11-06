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
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FsmGenExtensions {
  public static String _getName(final Node nd) {
    return nd.getStateGraphNode().getName();
  }
  
  public static String _getName(final Link l) {
    return l.getTransition().getName();
  }
  
  public static Iterable<Node> getStateNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof State));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllNodes(final Graph g) {
    return Iterators.<Node>filter(g.eAllContents(), Node.class);
  }
  
  public static Iterator<Node> getAllStateNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof State));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<Node> getChoicePointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof ChoicePoint));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllChoicePointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof ChoicePoint));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<Node> getTrPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof TrPoint));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllTrPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof TrPoint));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<Node> getTransitionPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof TransitionPoint));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllTransitionPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof TransitionPoint));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<Node> getEntryPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof EntryPoint));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllEntryPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof EntryPoint));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<Node> getExitPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof ExitPoint));
      }
    };
    return IterableExtensions.<Node>filter(g.getNodes(), _function);
  }
  
  public static Iterator<Node> getAllExitPointNodes(final Graph g) {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof ExitPoint));
      }
    };
    return IteratorExtensions.<Node>filter(FsmGenExtensions.getAllNodes(g), _function);
  }
  
  public static Iterable<State> getStates(final Graph g) {
    final Function1<Node, StateGraphNode> _function = new Function1<Node, StateGraphNode>() {
      @Override
      public StateGraphNode apply(final Node it) {
        return it.getStateGraphNode();
      }
    };
    return Iterables.<State>filter(IterableExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getStateNodes(g), _function), State.class);
  }
  
  public static Iterator<State> getAllStates(final Graph g) {
    final Function1<Node, StateGraphNode> _function = new Function1<Node, StateGraphNode>() {
      @Override
      public StateGraphNode apply(final Node it) {
        return it.getStateGraphNode();
      }
    };
    return Iterators.<State>filter(IteratorExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getAllStateNodes(g), _function), State.class);
  }
  
  public static Iterable<ChoicePoint> getChoicePoints(final Graph g) {
    final Function1<Node, StateGraphNode> _function = new Function1<Node, StateGraphNode>() {
      @Override
      public StateGraphNode apply(final Node it) {
        return it.getStateGraphNode();
      }
    };
    return Iterables.<ChoicePoint>filter(IterableExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getChoicePointNodes(g), _function), ChoicePoint.class);
  }
  
  public static Iterable<TrPoint> getTrPoints(final Graph g) {
    final Function1<Node, StateGraphNode> _function = new Function1<Node, StateGraphNode>() {
      @Override
      public StateGraphNode apply(final Node it) {
        return it.getStateGraphNode();
      }
    };
    return Iterables.<TrPoint>filter(IterableExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getTrPointNodes(g), _function), TrPoint.class);
  }
  
  public static InitialTransition getInitialTransition(final Graph g) {
    final Function1<Link, TransitionBase> _function = new Function1<Link, TransitionBase>() {
      @Override
      public TransitionBase apply(final Link it) {
        return it.getTransition();
      }
    };
    return IterableExtensions.<InitialTransition>head(Iterables.<InitialTransition>filter(ListExtensions.<Link, TransitionBase>map(g.getLinks(), _function), InitialTransition.class));
  }
  
  public static Iterator<Link> getAllLinks(final Graph g) {
    return Iterators.<Link>filter(g.eAllContents(), Link.class);
  }
  
  public static Iterator<Link> getAllInitialTranisitionLinks(final Graph g) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof InitialTransition));
      }
    };
    return IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(g), _function);
  }
  
  public static Iterator<Link> getAllTriggeredTranisitionLinks(final Graph g) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof TriggeredTransition));
      }
    };
    return IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(g), _function);
  }
  
  public static Iterator<Link> getAllContinuationTranisitionLinks(final Graph g) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof ContinuationTransition));
      }
    };
    return IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(g), _function);
  }
  
  public static Iterator<Link> getAllCPBranchTranisitionLinks(final Graph g) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof CPBranchTransition));
      }
    };
    return IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(g), _function);
  }
  
  /**
   * returns all links whose transitions are chain heads
   * 
   * @param g a graph
   * @return all deeply contained links that are chain heads
   * 
   * @see #isChainHead(Link))
   */
  public static Iterator<Link> getAllChainHeads(final Graph g) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        return Boolean.valueOf(FsmGenExtensions.isChainHead(it));
      }
    };
    return IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(g), _function);
  }
  
  /**
   * @param l a link
   * @return {@code true} if the transition associated with this link is a chain head
   * 
   * @see #isChainHead(TransitionBase))
   */
  public static boolean isChainHead(final Link l) {
    return FsmGenExtensions.isChainHead(l.getTransition());
  }
  
  /**
   * the head of a transition chain is an initial, a guarded or a triggered transition
   * 
   * @param l a link
   * @return {@code true} if this transition is of one of the above types
   */
  public static boolean isChainHead(final TransitionBase t) {
    boolean _xifexpression = false;
    if ((t instanceof RefinedTransition)) {
      _xifexpression = FsmGenExtensions.isChainHead(((RefinedTransition)t).getTarget());
    } else {
      _xifexpression = (((t instanceof InitialTransition) || 
        (t instanceof GuardedTransition)) || 
        (t instanceof TriggeredTransition));
    }
    return _xifexpression;
  }
  
  public static Iterable<Link> getOutgoingTriggeredTransitionLinks(final Node s) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof TriggeredTransition));
      }
    };
    return IterableExtensions.<Link>filter(s.getOutgoing(), _function);
  }
  
  public static Iterable<TriggeredTransition> getOutgoingTriggeredTransitions(final Node s) {
    final Function1<Link, TransitionBase> _function = new Function1<Link, TransitionBase>() {
      @Override
      public TransitionBase apply(final Link it) {
        return it.getTransition();
      }
    };
    return Iterables.<TriggeredTransition>filter(IterableExtensions.<Link, TransitionBase>map(FsmGenExtensions.getOutgoingTriggeredTransitionLinks(s), _function), TriggeredTransition.class);
  }
  
  public static List<TransitionBase> getOutgoingTransitionsHierarchically(final Node s) {
    final Function1<Link, TransitionBase> _function = new Function1<Link, TransitionBase>() {
      @Override
      public TransitionBase apply(final Link it) {
        return it.getTransition();
      }
    };
    return ListExtensions.<Link, TransitionBase>map(FsmGenExtensions.getOutgoingLinksHierarchically(s), _function);
  }
  
  public static ArrayList<Link> getOutgoingLinksHierarchically(final Node s) {
    final ArrayList<Link> result = CollectionLiterals.<Link>newArrayList();
    Node current = s;
    while ((current != null)) {
      {
        result.addAll(s.getOutgoing());
        final Function1<Node, EList<Link>> _function = new Function1<Node, EList<Link>>() {
          @Override
          public EList<Link> apply(final Node it) {
            return it.getOutgoing();
          }
        };
        Iterables.<Link>addAll(result, Iterables.<Link>concat(IterableExtensions.<Node, EList<Link>>map(FsmGenExtensions.getTransitionPointNodes(s.getGraph()), _function)));
        current = FsmGenExtensions.getParentState(current);
      }
    }
    return result;
  }
  
  public static boolean isTopLevel(final Graph g) {
    boolean _xifexpression = false;
    if ((g != null)) {
      EObject _eContainer = g.eContainer();
      _xifexpression = (_eContainer instanceof GraphContainer);
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  public static boolean isEmpty(final Graph g) {
    return ((g == null) || (g.getNodes().isEmpty() && g.getLinks().isEmpty()));
  }
  
  public static boolean isLeaf(final Node n) {
    Graph _subgraph = n.getSubgraph();
    return (_subgraph == null);
  }
  
  public static boolean isTopLevel(final Node n) {
    return FsmGenExtensions.isTopLevel(n.getGraph());
  }
  
  public static Node getParentState(final Node n) {
    Node _xifexpression = null;
    boolean _isTopLevel = FsmGenExtensions.isTopLevel(n);
    if (_isTopLevel) {
      _xifexpression = null;
    } else {
      EObject _eContainer = n.getGraph().eContainer();
      _xifexpression = ((Node) _eContainer);
    }
    return _xifexpression;
  }
  
  public static Link getChoicepointDefaultBranch(final Node n) {
    StateGraphNode _stateGraphNode = n.getStateGraphNode();
    boolean _not = (!(_stateGraphNode instanceof ChoicePoint));
    if (_not) {
      return null;
    }
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof ContinuationTransition));
      }
    };
    return IterableExtensions.<Link>head(IterableExtensions.<Link>filter(n.getOutgoing(), _function));
  }
  
  public static Node getParentState(final Link l) {
    Node _xifexpression = null;
    boolean _isTopLevel = FsmGenExtensions.isTopLevel(l.getGraph());
    if (_isTopLevel) {
      _xifexpression = null;
    } else {
      EObject _eContainer = l.getGraph().eContainer();
      _xifexpression = ((Node) _eContainer);
    }
    return _xifexpression;
  }
  
  public static boolean isHandler(final Link l) {
    boolean _xblockexpression = false;
    {
      final StateGraphNode sourceNode = l.getSource().getStateGraphNode();
      boolean _xifexpression = false;
      if ((sourceNode instanceof TransitionPoint)) {
        _xifexpression = ((TransitionPoint)sourceNode).isHandler();
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static List<DetailCode> getAllDetailCodes(final Graph graph) {
    final ArrayList<DetailCode> detailCodes = CollectionLiterals.<DetailCode>newArrayList();
    if ((graph != null)) {
      final Function1<Link, TransitionBase> _function = new Function1<Link, TransitionBase>() {
        @Override
        public TransitionBase apply(final Link it) {
          return it.getTransition();
        }
      };
      final Iterator<TransitionBase> allTransitions = IteratorExtensions.<Link, TransitionBase>map(FsmGenExtensions.getAllLinks(graph), _function);
      final Function1<TransitionBase, DetailCode> _function_1 = new Function1<TransitionBase, DetailCode>() {
        @Override
        public DetailCode apply(final TransitionBase it) {
          return it.getAction();
        }
      };
      List<DetailCode> _list = IteratorExtensions.<DetailCode>toList(IteratorExtensions.<TransitionBase, DetailCode>map(allTransitions, _function_1));
      Iterables.<DetailCode>addAll(detailCodes, _list);
      final Function1<Node, StateGraphNode> _function_2 = new Function1<Node, StateGraphNode>() {
        @Override
        public StateGraphNode apply(final Node it) {
          return it.getStateGraphNode();
        }
      };
      final Iterator<State> allStates = Iterators.<State>filter(IteratorExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getAllStateNodes(graph), _function_2), State.class);
      final Function1<State, DetailCode> _function_3 = new Function1<State, DetailCode>() {
        @Override
        public DetailCode apply(final State it) {
          return it.getEntryCode();
        }
      };
      List<DetailCode> _list_1 = IteratorExtensions.<DetailCode>toList(IteratorExtensions.<State, DetailCode>map(allStates, _function_3));
      Iterables.<DetailCode>addAll(detailCodes, _list_1);
      final Function1<State, DetailCode> _function_4 = new Function1<State, DetailCode>() {
        @Override
        public DetailCode apply(final State it) {
          return it.getDoCode();
        }
      };
      List<DetailCode> _list_2 = IteratorExtensions.<DetailCode>toList(IteratorExtensions.<State, DetailCode>map(allStates, _function_4));
      Iterables.<DetailCode>addAll(detailCodes, _list_2);
      final Function1<State, DetailCode> _function_5 = new Function1<State, DetailCode>() {
        @Override
        public DetailCode apply(final State it) {
          return it.getExitCode();
        }
      };
      List<DetailCode> _list_3 = IteratorExtensions.<DetailCode>toList(IteratorExtensions.<State, DetailCode>map(allStates, _function_5));
      Iterables.<DetailCode>addAll(detailCodes, _list_3);
    }
    return detailCodes;
  }
  
  public static Link getLinkFor(final GraphContainer gc, final TransitionBase t) {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition == t));
      }
    };
    return IteratorExtensions.<Link>findFirst(FsmGenExtensions.getAllLinks(gc.getGraph()), _function);
  }
  
  public static String getName(final GraphItem l) {
    if (l instanceof Link) {
      return _getName((Link)l);
    } else if (l instanceof Node) {
      return _getName((Node)l);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(l).toString());
    }
  }
}
