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

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FsmGenChecker {
  public static void check(final GraphContainer gc, final ILogger logger) {
    final Procedure1<Graph> _function = new Procedure1<Graph>() {
      @Override
      public void apply(final Graph it) {
        FsmGenChecker.checkGraph(it, logger);
      }
    };
    IteratorExtensions.<Graph>forEach(Iterators.<Graph>filter(gc.eAllContents(), Graph.class), _function);
    final Procedure1<Node> _function_1 = new Procedure1<Node>() {
      @Override
      public void apply(final Node it) {
        FsmGenChecker.checkNode(it, logger);
      }
    };
    IteratorExtensions.<Node>forEach(Iterators.<Node>filter(gc.eAllContents(), Node.class), _function_1);
    final Procedure1<Link> _function_2 = new Procedure1<Link>() {
      @Override
      public void apply(final Link it) {
        FsmGenChecker.checkLink(it, logger);
      }
    };
    IteratorExtensions.<Link>forEach(Iterators.<Link>filter(gc.eAllContents(), Link.class), _function_2);
  }
  
  private static void checkLink(final Link it, final ILogger logger) {
    TransitionBase _transition = it.getTransition();
    boolean _equals = Objects.equal(_transition, null);
    if (_equals) {
      logger.logError("graph doesn\'t point to ROOM transition");
    } else {
      boolean _eIsProxy = it.getTransition().eIsProxy();
      if (_eIsProxy) {
        logger.logError("unresolved ROOM transition");
      } else {
        EObject _eContainer = it.getTransition().eContainer();
        boolean _equals_1 = Objects.equal(_eContainer, null);
        if (_equals_1) {
          logger.logError("dangling ROOM transition");
        } else {
          Node _target = it.getTarget();
          boolean _equals_2 = Objects.equal(_target, null);
          if (_equals_2) {
            logger.logError("link without target");
          } else {
            if ((Objects.equal(it.getSource(), null) && (it.getTransition() instanceof NonInitialTransition))) {
              logger.logError("non-initial link without source");
            }
          }
        }
      }
    }
    Node _source = it.getSource();
    boolean _notEquals = (!Objects.equal(_source, null));
    if (_notEquals) {
      FsmGenChecker.checkLinkEnd(it, it.getSource(), logger);
    }
    FsmGenChecker.checkLinkEnd(it, it.getTarget(), logger);
  }
  
  private static void checkLinkEnd(final Link link, final Node node, final ILogger logger) {
    EObject _eContainer = node.eContainer();
    EObject _eContainer_1 = link.eContainer();
    boolean _equals = Objects.equal(_eContainer, _eContainer_1);
    if (_equals) {
      return;
    } else {
      StateGraphNode _stateGraphNode = node.getStateGraphNode();
      boolean _not = (!(_stateGraphNode instanceof TrPoint));
      if (_not) {
        logger.logError("subgraph item is not transition point");
      } else {
        EObject _eContainer_2 = node.eContainer().eContainer();
        boolean _not_1 = (!(_eContainer_2 instanceof Node));
        if (_not_1) {
          logger.logError("subgraph item is in unexpected container");
        } else {
          EObject _eContainer_3 = node.eContainer().eContainer();
          StateGraphNode _stateGraphNode_1 = ((Node) _eContainer_3).getStateGraphNode();
          boolean _not_2 = (!(_stateGraphNode_1 instanceof State));
          if (_not_2) {
            logger.logError("subgraph item is in unexpected container");
          } else {
            EObject _eContainer_4 = node.eContainer().eContainer().eContainer();
            EObject _eContainer_5 = link.eContainer();
            boolean _notEquals = (!Objects.equal(_eContainer_4, _eContainer_5));
            if (_notEquals) {
              logger.logError("subgraph item is in unexpected container");
            }
          }
        }
      }
    }
  }
  
  private static void checkNode(final Node it, final ILogger logger) {
    StateGraphNode _stateGraphNode = it.getStateGraphNode();
    boolean _equals = Objects.equal(_stateGraphNode, null);
    if (_equals) {
      logger.logError("graph doesn\'t point to ROOM state graph node");
    } else {
      boolean _eIsProxy = it.getStateGraphNode().eIsProxy();
      if (_eIsProxy) {
        logger.logError("unresolved ROOM graph node");
      } else {
        EObject _eContainer = it.getStateGraphNode().eContainer();
        boolean _equals_1 = Objects.equal(_eContainer, null);
        if (_equals_1) {
          logger.logError("dangling ROOM graph node");
        } else {
          String _name = it.getStateGraphNode().getName();
          boolean _equals_2 = Objects.equal(_name, null);
          if (_equals_2) {
            logger.logError("ROOM graph node without name");
          } else {
            Graph _graph = it.getGraph();
            boolean _equals_3 = Objects.equal(_graph, null);
            if (_equals_3) {
              logger.logError("node isn\'t contained in a graph");
            }
          }
        }
      }
    }
    EList<Link> _incoming = it.getIncoming();
    for (final Link l : _incoming) {
      StateGraphNode _stateGraphNode_1 = l.getTarget().getStateGraphNode();
      StateGraphNode _stateGraphNode_2 = it.getStateGraphNode();
      boolean _notEquals = (!Objects.equal(_stateGraphNode_1, _stateGraphNode_2));
      if (_notEquals) {
        logger.logError("ROOM target node of an incoming transition must be myself");
      }
    }
    EList<Link> _outgoing = it.getOutgoing();
    for (final Link l_1 : _outgoing) {
      StateGraphNode _stateGraphNode_3 = l_1.getSource().getStateGraphNode();
      StateGraphNode _stateGraphNode_4 = it.getStateGraphNode();
      boolean _notEquals_1 = (!Objects.equal(_stateGraphNode_3, _stateGraphNode_4));
      if (_notEquals_1) {
        logger.logError("ROOM source node of an outgoing transition must be myself");
      }
    }
  }
  
  private static void checkGraph(final Graph it, final ILogger logger) {
    StateGraph _stateGraph = it.getStateGraph();
    boolean _equals = Objects.equal(_stateGraph, null);
    if (_equals) {
      logger.logError("graph doesn\'t point to ROOM state graph");
    } else {
      boolean _eIsProxy = it.getStateGraph().eIsProxy();
      if (_eIsProxy) {
        logger.logError("unresolved ROOM graph");
      } else {
        EObject _eContainer = it.getStateGraph().eContainer();
        boolean _equals_1 = Objects.equal(_eContainer, null);
        if (_equals_1) {
          logger.logError("dangling ROOM graph");
        }
      }
    }
  }
}
