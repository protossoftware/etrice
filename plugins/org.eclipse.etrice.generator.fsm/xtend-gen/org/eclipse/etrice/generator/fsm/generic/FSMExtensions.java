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

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;

/**
 * @author Henrik Rentz-Reichert
 */
@SuppressWarnings("all")
public class FSMExtensions {
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
}
