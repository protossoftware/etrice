/**
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.fsm.generic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Henrik Rentz-Reichert
 */
@SuppressWarnings("all")
public class FSMExtensions {
  @Inject
  @Extension
  protected FSMHelpers _fSMHelpers;
  
  /**
   * the template type is T
   * @param l an iterable of type T
   * @param e a single element of type T
   * @return the union of the iterable and the element as new list
   */
  public <T extends Object> List<T> union(final Iterable<T> l, final T e) {
    ArrayList<T> ret = new ArrayList<T>();
    Iterables.<T>addAll(ret, l);
    ret.add(e);
    return ret;
  }
  
  /**
   * the template type is T
   * @param l1 an iterable of type T
   * @param l2 a second iterable of type T
   * @return the union of the two iterables as new list
   */
  public <T extends Object> List<T> union(final Iterable<T> l1, final Iterable<T> l2) {
    ArrayList<T> ret = new ArrayList<T>();
    Iterables.<T>addAll(ret, l1);
    Iterables.<T>addAll(ret, l2);
    return ret;
  }
  
  /**
   * the template type is T
   * @param l1 a list of elements of type T
   * @param l2 a second list of elements of type T
   * @return a new list with the contents of l1
   */
  public <T extends Object> List<T> minus(final List<T> l1, final List<T> l2) {
    ArrayList<T> ret = new ArrayList<T>(l1);
    ret.removeAll(l2);
    return ret;
  }
  
  /**
   * @param ac an {@link ExpandedActorClass}
   * @param s a {@link State}
   * @return a list of {@link Transition}s starting at the state and going up in the hierarchy
   * 		following the logic of evaluation of firing conditions
   */
  public List<Transition> getOutgoingTransitionsHierarchical(final ExpandedModelComponent ac, final State s) {
    ArrayList<Transition> result = new ArrayList<Transition>();
    EList<Transition> _outgoingTransitions = ac.getOutgoingTransitions(s);
    result.addAll(_outgoingTransitions);
    EObject _eContainer = s.eContainer();
    StateGraph sg = ((StateGraph) _eContainer);
    EList<TrPoint> _trPoints = sg.getTrPoints();
    for (final TrPoint tp : _trPoints) {
      if ((tp instanceof TransitionPoint)) {
        EList<Transition> _outgoingTransitions_1 = ac.getOutgoingTransitions(tp);
        result.addAll(_outgoingTransitions_1);
      }
    }
    EObject _eContainer_1 = sg.eContainer();
    if ((_eContainer_1 instanceof State)) {
      EObject _eContainer_2 = sg.eContainer();
      List<Transition> _outgoingTransitionsHierarchical = this.getOutgoingTransitionsHierarchical(ac, ((State) _eContainer_2));
      result.addAll(_outgoingTransitionsHierarchical);
    }
    return result;
  }
  
  /**
   * @param states a list of {@link State}s
   * @return a list ordered such that leaf states are last
   */
  public List<State> getLeafStatesLast(final List<State> states) {
    List<State> _xblockexpression = null;
    {
      final Function1<State, Boolean> _function = (State s) -> {
        return Boolean.valueOf(this._fSMHelpers.isLeaf(s));
      };
      final Iterable<State> leaf = IterableExtensions.<State>filter(states, _function);
      final Function1<State, Boolean> _function_1 = (State s) -> {
        boolean _isLeaf = this._fSMHelpers.isLeaf(s);
        return Boolean.valueOf((!_isLeaf));
      };
      final Iterable<State> nonLeaf = IterableExtensions.<State>filter(states, _function_1);
      _xblockexpression = this.<State>union(nonLeaf, leaf);
    }
    return _xblockexpression;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return a list of all leaf states
   */
  public List<State> getAllLeafStates(final ModelComponent mc) {
    StateGraph _stateMachine = mc.getStateMachine();
    return this._fSMHelpers.getLeafStateList(_stateMachine);
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return a list of simple states with leaf states last
   */
  public List<State> getAllBaseStatesLeavesLast(final ModelComponent mc) {
    List<State> _allBaseStates = this._fSMHelpers.getAllBaseStates(mc);
    return this.getLeafStatesLast(_allBaseStates);
  }
  
  /**
   * @param ac an {@link ModelComponent}
   * @return the number of all inherited states
   */
  public int getNumberOfInheritedStates(final ModelComponent mc) {
    ModelComponent _base = mc.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ModelComponent _base_1 = mc.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _stateList = this._fSMHelpers.getStateList(_stateMachine);
      int _size = _stateList.size();
      ModelComponent _base_2 = mc.getBase();
      int _numberOfInheritedStates = this.getNumberOfInheritedStates(_base_2);
      return (_size + _numberOfInheritedStates);
    }
  }
  
  /**
   * @param ac an {@link ModelComponent}
   * @return the number of all inherited base (or simple) states
   */
  public int getNumberOfInheritedBaseStates(final ModelComponent ac) {
    ModelComponent _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ModelComponent _base_1 = ac.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _baseStateList = this._fSMHelpers.getBaseStateList(_stateMachine);
      int _size = _baseStateList.size();
      ModelComponent _base_2 = ac.getBase();
      int _numberOfInheritedBaseStates = this.getNumberOfInheritedBaseStates(_base_2);
      return (_size + _numberOfInheritedBaseStates);
    }
  }
  
  public boolean isConditionOrGuard(final DetailCode dc) {
    boolean _xblockexpression = false;
    {
      final EObject parent = dc.eContainer();
      boolean _switchResult = false;
      boolean _matched = false;
      if (parent instanceof Guard) {
        _matched=true;
        _switchResult = true;
      }
      if (!_matched) {
        if (parent instanceof CPBranchTransition) {
          _matched=true;
          DetailCode _condition = ((CPBranchTransition)parent).getCondition();
          _switchResult = Objects.equal(_condition, dc);
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
