/**
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Mirza Klimenta (initial contribution)
 */
package org.eclipse.etrice.core.fsm.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FSMValidationUtilXtend {
  public static class Result {
    private boolean ok;
    
    private String msg;
    
    private EObject source;
    
    private EStructuralFeature feature;
    
    private int index;
    
    public static FSMValidationUtilXtend.Result ok() {
      return new FSMValidationUtilXtend.Result(true, "", null, null, 0);
    }
    
    public static FSMValidationUtilXtend.Result error(final String msg) {
      return new FSMValidationUtilXtend.Result(false, msg, null, null, (-1));
    }
    
    public static FSMValidationUtilXtend.Result error(final String msg, final EObject source, final EStructuralFeature feature) {
      return new FSMValidationUtilXtend.Result(false, msg, source, feature, (-1));
    }
    
    public static FSMValidationUtilXtend.Result error(final String msg, final EObject source, final EStructuralFeature feature, final int index) {
      return new FSMValidationUtilXtend.Result(false, msg, source, feature, index);
    }
    
    public Result(final boolean ok, final String msg, final EObject source, final EStructuralFeature feature, final int index) {
      this.ok = ok;
      this.msg = msg;
      this.source = source;
      this.feature = feature;
      this.index = index;
    }
    
    public boolean isOk() {
      return this.ok;
    }
    
    public String getMsg() {
      return this.msg;
    }
    
    public EObject getSource() {
      return this.source;
    }
    
    public EStructuralFeature getFeature() {
      return this.feature;
    }
    
    public int getIndex() {
      return this.index;
    }
  }
  
  @Inject
  @Extension
  private FSMNameProvider _fSMNameProvider;
  
  public ArrayList<FSMValidationUtilXtend.Result> uniqueOriginTriggers(final State myState) {
    final StateGraph parent = this.getStateGraph(myState);
    final HashMap<String, TriggeredTransition> trig2trans = CollectionLiterals.<String, TriggeredTransition>newHashMap();
    final ArrayList<FSMValidationUtilXtend.Result> result = CollectionLiterals.<FSMValidationUtilXtend.Result>newArrayList();
    EList<Transition> _transitions = parent.getTransitions();
    final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition t) {
        boolean _and = false;
        if (!((t instanceof TriggeredTransition) && (((TriggeredTransition) t).getFrom() instanceof StateTerminal))) {
          _and = false;
        } else {
          TransitionTerminal _from = ((TriggeredTransition) t).getFrom();
          State _state = ((StateTerminal) _from).getState();
          boolean _equals = Objects.equal(myState, _state);
          _and = _equals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_transitions, _function);
    for (final Transition t : _filter) {
      EList<Trigger> _triggers = ((TriggeredTransition) t).getTriggers();
      final Function1<Trigger, Boolean> _function_1 = new Function1<Trigger, Boolean>() {
        public Boolean apply(final Trigger k) {
          Guard _guard = k.getGuard();
          return Boolean.valueOf(Objects.equal(_guard, null));
        }
      };
      Iterable<Trigger> _filter_1 = IterableExtensions.<Trigger>filter(_triggers, _function_1);
      for (final Trigger k : _filter_1) {
        EList<MessageFromIf> _msgFromIfPairs = k.getMsgFromIfPairs();
        for (final MessageFromIf specMethod : _msgFromIfPairs) {
          {
            final String triggerName = this.getTriggerName(specMethod);
            boolean _containsKey = trig2trans.containsKey(triggerName);
            if (_containsKey) {
              final TriggeredTransition ot = trig2trans.get(triggerName);
              FSMValidationUtilXtend.Result _error = FSMValidationUtilXtend.Result.error("Triggers originating from a state should be unique.", t, FSMPackage.Literals.TRIGGERED_TRANSITION__TRIGGERS);
              result.add(_error);
              FSMValidationUtilXtend.Result _error_1 = FSMValidationUtilXtend.Result.error("Triggers originating from a state should be unique.", ot, FSMPackage.Literals.TRIGGERED_TRANSITION__TRIGGERS);
              result.add(_error_1);
            }
            trig2trans.put(triggerName, ((TriggeredTransition) t));
          }
        }
      }
    }
    return result;
  }
  
  private String getTriggerName(final MessageFromIf mif) {
    AbstractInterfaceItem _from = mif.getFrom();
    String _name = _from.getName();
    String _plus = (_name + "#");
    EObject _message = mif.getMessage();
    String _messageName = this._fSMNameProvider.getMessageName(_message);
    return (_plus + _messageName);
  }
  
  public StateGraph getStateGraph(final EObject obj) {
    EObject parent = obj.eContainer();
    boolean _notEquals = (!Objects.equal(parent, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        if ((parent instanceof StateGraph)) {
          return ((StateGraph) parent);
        }
        EObject _eContainer = parent.eContainer();
        parent = _eContainer;
      }
      boolean _notEquals_1 = (!Objects.equal(parent, null));
      _while = _notEquals_1;
    }
    return null;
  }
}
