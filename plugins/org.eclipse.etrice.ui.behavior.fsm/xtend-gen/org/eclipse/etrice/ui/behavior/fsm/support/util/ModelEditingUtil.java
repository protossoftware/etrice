/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.fsm.support.util;

import com.google.common.base.Objects;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Shared model editing
 */
@SuppressWarnings("all")
public class ModelEditingUtil {
  public static RefinedState getOrCreateRefinedStateFor(final State s, final ModelComponent mc) {
    final HashMap<State, RefinedState> target2rs = new HashMap<State, RefinedState>();
    EList<State> _states = mc.getStateMachine().getStates();
    for (final State st : _states) {
      if ((st instanceof RefinedState)) {
        target2rs.put(((RefinedState) st).getTarget(), ((RefinedState) st));
      }
    }
    RefinedState rs = null;
    boolean _containsKey = target2rs.containsKey(s);
    if (_containsKey) {
      rs = target2rs.get(s);
    } else {
      StateGraph sg = null;
      State parent = s;
      boolean break_ = false;
      while (((parent.eContainer().eContainer() instanceof State) && (!break_))) {
        {
          EObject _eContainer = s.eContainer().eContainer();
          parent = ((State) _eContainer);
          boolean _containsKey_1 = target2rs.containsKey(parent);
          if (_containsKey_1) {
            final RefinedState bestFitting = target2rs.get(parent);
            StateGraph _subgraph = bestFitting.getSubgraph();
            boolean _equals = Objects.equal(_subgraph, null);
            if (_equals) {
              bestFitting.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
            }
            sg = bestFitting.getSubgraph();
            break_ = true;
          }
        }
      }
      boolean _equals = Objects.equal(sg, null);
      if (_equals) {
        sg = mc.getStateMachine();
      }
      rs = FSMFactory.eINSTANCE.createRefinedState();
      rs.setTarget(s);
      sg.getStates().add(rs);
    }
    return rs;
  }
  
  public static StateGraph getOrCreateSubGraphOfRefinedStateFor(final State s, final ModelComponent mc) {
    final RefinedState rs = ModelEditingUtil.getOrCreateRefinedStateFor(s, mc);
    StateGraph _subgraph = rs.getSubgraph();
    boolean _equals = Objects.equal(_subgraph, null);
    if (_equals) {
      rs.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
    }
    return rs.getSubgraph();
  }
  
  public static StateGraph insertRefinedState(final StateGraph sg, final ModelComponent mc, final ContainerShape targetContainer, final IFeatureProvider fp) {
    EObject _eContainer = sg.eContainer();
    final StateGraph sg2 = ModelEditingUtil.getOrCreateSubGraphOfRefinedStateFor(((State) _eContainer), mc);
    fp.link(targetContainer, sg2);
    return sg2;
  }
}
