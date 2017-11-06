/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrr@protos.de (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.BasicFsmGenBuilder;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExtendedFsmGenBuilder extends BasicFsmGenBuilder {
  @Inject
  @Extension
  protected ICommonDataCalculator _iCommonDataCalculator;
  
  @Inject
  @Extension
  protected TriggerExtensions _triggerExtensions;
  
  protected IDiagnostician validator;
  
  private final FsmGenFactory factory = FsmGenFactory.eINSTANCE;
  
  public ExtendedFsmGenBuilder(final Injector injector, final IDiagnostician validator) {
    super();
    injector.injectMembers(this);
    this.validator = validator;
  }
  
  /**
   * computes the available triggers for all leaf states
   */
  public GraphContainer withTriggersInStates(final GraphContainer gc) {
    boolean _isInitializedTriggersInStates = gc.isInitializedTriggersInStates();
    boolean _not = (!_isInitializedTriggersInStates);
    if (_not) {
      Graph _graph = gc.getGraph();
      boolean _tripleNotEquals = (_graph != null);
      if (_tripleNotEquals) {
        final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
          @Override
          public Boolean apply(final Node it) {
            Graph _subgraph = it.getSubgraph();
            return Boolean.valueOf((_subgraph == null));
          }
        };
        final Procedure1<Node> _function_1 = new Procedure1<Node>() {
          @Override
          public void apply(final Node it) {
            ExtendedFsmGenBuilder.this.computeTriggers(it);
          }
        };
        IteratorExtensions.<Node>forEach(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(gc.getGraph()), _function), _function_1);
      }
      gc.setInitializedTriggersInStates(true);
    }
    return gc;
  }
  
  /**
   * determines all transition chain heads of all transitions
   */
  public GraphContainer withChainHeads(final GraphContainer gc) {
    boolean _isInitializedChainHeads = gc.isInitializedChainHeads();
    boolean _not = (!_isInitializedChainHeads);
    if (_not) {
      Graph _graph = gc.getGraph();
      boolean _tripleNotEquals = (_graph != null);
      if (_tripleNotEquals) {
        final Procedure1<Link> _function = new Procedure1<Link>() {
          @Override
          public void apply(final Link it) {
            ExtendedFsmGenBuilder.this.followChain(it, it);
          }
        };
        IteratorExtensions.<Link>forEach(FsmGenExtensions.getAllChainHeads(gc.getGraph()), _function);
      }
      gc.setInitializedChainHeads(true);
    }
    return gc;
  }
  
  /**
   * calculates and stores the common data. Prerequisite is the computation of the
   * chain heads, which is performed if not done already.
   */
  public GraphContainer withCommonData(final GraphContainer gc) {
    boolean _isInitializedChainHeads = gc.isInitializedChainHeads();
    boolean _not = (!_isInitializedChainHeads);
    if (_not) {
      this.withChainHeads(gc);
    }
    boolean _isInitializedCommonData = gc.isInitializedCommonData();
    boolean _not_1 = (!_isInitializedCommonData);
    if (_not_1) {
      Graph _graph = gc.getGraph();
      boolean _tripleNotEquals = (_graph != null);
      if (_tripleNotEquals) {
        final Procedure1<Link> _function = new Procedure1<Link>() {
          @Override
          public void apply(final Link it) {
            it.setCommonData(ExtendedFsmGenBuilder.this._iCommonDataCalculator.calculateCommonData(it));
          }
        };
        IteratorExtensions.<Link>forEach(FsmGenExtensions.getAllLinks(gc.getGraph()), _function);
      }
      gc.setInitializedCommonData(true);
    }
    return gc;
  }
  
  private void followChain(final Link l, final Link head) {
    TransitionBase _transition = head.getTransition();
    boolean _not = (!(_transition instanceof TriggeredTransition));
    if (_not) {
      l.setIfitemTriggered(false);
    }
    l.getChainHeads().add(head);
    final StateGraphNode target = l.getTarget().getStateGraphNode();
    if (((target instanceof State) || (target instanceof TransitionPoint))) {
      return;
    } else {
      EList<Link> _outgoing = l.getTarget().getOutgoing();
      for (final Link next : _outgoing) {
        this.followChain(next, head);
      }
    }
  }
  
  private void computeTriggers(final Node s) {
    final LinkedHashMap<String, CommonTrigger> caughtTriggers = CollectionLiterals.<String, CommonTrigger>newLinkedHashMap();
    this.computeTriggersRecursive(s, caughtTriggers);
    s.getCaughtTriggers().clear();
    s.getCaughtTriggers().addAll(caughtTriggers.values());
  }
  
  private void computeTriggersRecursive(final Node s, final HashMap<String, CommonTrigger> caughtTriggers) {
    this.computeTriggers(IterableExtensions.<Link>toList(FsmGenExtensions.getOutgoingTriggeredTransitionLinks(s)), caughtTriggers);
    final Function1<Node, Iterable<Link>> _function = new Function1<Node, Iterable<Link>>() {
      @Override
      public Iterable<Link> apply(final Node it) {
        return FsmGenExtensions.getOutgoingTriggeredTransitionLinks(it);
      }
    };
    final List<Link> trPointTransitions = IterableExtensions.<Link>toList(Iterables.<Link>concat(IterableExtensions.<Node, Iterable<Link>>map(FsmGenExtensions.getTransitionPointNodes(s.getGraph()), _function)));
    this.computeTriggers(trPointTransitions, caughtTriggers);
    boolean _isTopLevel = FsmGenExtensions.isTopLevel(s.getGraph());
    boolean _not = (!_isTopLevel);
    if (_not) {
      this.computeTriggersRecursive(FsmGenExtensions.getParentState(s), caughtTriggers);
    }
  }
  
  private void computeTriggers(final List<Link> sameLevelLinks, final HashMap<String, CommonTrigger> caughtTriggers) {
    final HashMap<TransitionBase, Link> trans2link = CollectionLiterals.<TransitionBase, Link>newHashMap();
    final Consumer<Link> _function = new Consumer<Link>() {
      @Override
      public void accept(final Link it) {
        trans2link.put(it.getTransition(), it);
      }
    };
    sameLevelLinks.forEach(_function);
    for (final Link l : sameLevelLinks) {
      TransitionBase _transition = l.getTransition();
      EList<Trigger> _triggers = ((TriggeredTransition) _transition).getTriggers();
      for (final Trigger tr : _triggers) {
        {
          final boolean triggerHasGuard = this.fsmHelpers.hasGuard(tr);
          EList<MessageFromIf> _msgFromIfPairs = tr.getMsgFromIfPairs();
          for (final MessageFromIf mif : _msgFromIfPairs) {
            {
              final String tag = this._triggerExtensions.getTriggerTag(mif);
              CommonTrigger ct = caughtTriggers.get(tag);
              if ((ct == null)) {
                ct = this.createCommonTrigger(l, mif, tag);
                ct.setHasGuard(triggerHasGuard);
                caughtTriggers.put(tag, ct);
              } else {
                final Function1<Link, EList<Trigger>> _function_1 = new Function1<Link, EList<Trigger>>() {
                  @Override
                  public EList<Trigger> apply(final Link it) {
                    TransitionBase _transition = it.getTransition();
                    return ((TriggeredTransition) _transition).getTriggers();
                  }
                };
                final Function1<Trigger, Boolean> _function_2 = new Function1<Trigger, Boolean>() {
                  @Override
                  public Boolean apply(final Trigger it) {
                    return Boolean.valueOf((ExtendedFsmGenBuilder.this.hasMatchingTrigger(it, tag) && (!ExtendedFsmGenBuilder.this.fsmHelpers.hasGuard(it))));
                  }
                };
                Trigger _head = IterableExtensions.<Trigger>head(IterableExtensions.<Trigger>filter(Iterables.<Trigger>concat(ListExtensions.<Link, EList<Trigger>>map(ct.getLinks(), _function_1)), _function_2));
                EObject _eContainer = null;
                if (_head!=null) {
                  _eContainer=_head.eContainer();
                }
                final TriggeredTransition unguarded = ((TriggeredTransition) _eContainer);
                if ((unguarded != null)) {
                  final Link unguardedLink = trans2link.get(unguarded);
                  boolean _contains = sameLevelLinks.contains(unguardedLink);
                  if (_contains) {
                    if (triggerHasGuard) {
                      final int idx = ct.getLinks().indexOf(unguardedLink);
                      ct.setHasGuard(triggerHasGuard);
                      ct.getLinks().add(idx, l);
                    } else {
                      this.validationError("Transitions with same trigger on same level have to be guarded!", l.getTransition(), FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
                    }
                  }
                } else {
                  ct.getLinks().add(l);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean hasMatchingTrigger(final Trigger trig, final String tag) {
    EList<MessageFromIf> _msgFromIfPairs = trig.getMsgFromIfPairs();
    for (final MessageFromIf mifp2 : _msgFromIfPairs) {
      {
        final String tr2 = this._triggerExtensions.getTriggerTag(mifp2);
        boolean _equals = tr2.equals(tag);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
  }
  
  private CommonTrigger createCommonTrigger(final Link l, final MessageFromIf mif, final String tag) {
    final CommonTrigger it = this.factory.createCommonTrigger();
    it.setTrigger(tag);
    it.setIfitem(mif.getFrom());
    it.setMsg(mif.getMessage());
    it.getLinks().add(l);
    return it;
  }
  
  protected void validationError(final String msg, final EObject obj, final EStructuralFeature feature) {
    this.validationError(msg, obj, feature, IDiagnostician.INSIGNIFICANT_INDEX);
  }
  
  protected void validationError(final String msg, final EObject obj, final EStructuralFeature feature, final int idx) {
    this.validator.error(msg, obj, feature, idx);
  }
}
