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
package org.eclipse.etrice.core.room.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CommonDataCalculator implements ICommonDataCalculator {
  private RoomHelpers roomHelpers = new RoomHelpers();
  
  @Override
  public EObject calculateCommonData(final Link l) {
    boolean _isIfitemTriggered = l.isIfitemTriggered();
    boolean _not = (!_isIfitemTriggered);
    if (_not) {
      return null;
    } else {
      final Function1<Link, TransitionBase> _function = (Link it) -> {
        return CommonDataCalculator.realTransition(it.getTransition());
      };
      Iterable<TriggeredTransition> transitions = Iterables.<TriggeredTransition>filter(ListExtensions.<Link, TransitionBase>map(l.getChainHeads(), _function), TriggeredTransition.class);
      final Function1<TriggeredTransition, EList<Trigger>> _function_1 = (TriggeredTransition it) -> {
        return it.getTriggers();
      };
      final Iterable<Trigger> triggers = Iterables.<Trigger>concat(IterableExtensions.<TriggeredTransition, EList<Trigger>>map(transitions, _function_1));
      final Function1<Trigger, EList<MessageFromIf>> _function_2 = (Trigger it) -> {
        return it.getMsgFromIfPairs();
      };
      final Function1<MessageFromIf, VarDecl> _function_3 = (MessageFromIf it) -> {
        EObject _message = it.getMessage();
        return ((Message) _message).getData();
      };
      final Iterable<VarDecl> varDeclarations = IterableExtensions.<MessageFromIf, VarDecl>map(Iterables.<MessageFromIf>concat(IterableExtensions.<Trigger, EList<MessageFromIf>>map(triggers, _function_2)), _function_3);
      final Function1<VarDecl, DataType> _function_4 = (VarDecl it) -> {
        RefableType _refType = null;
        if (it!=null) {
          _refType=it.getRefType();
        }
        DataType _type = null;
        if (_refType!=null) {
          _type=_refType.getType();
        }
        return _type;
      };
      final Set<DataType> allData = IterableExtensions.<DataType>toSet(IterableExtensions.<VarDecl, DataType>map(varDeclarations, _function_4));
      int _size = allData.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        return IterableExtensions.<VarDecl>head(varDeclarations);
      } else {
        final Function1<VarDecl, RefableType> _function_5 = (VarDecl it) -> {
          RefableType _refType = null;
          if (it!=null) {
            _refType=it.getRefType();
          }
          return _refType;
        };
        final List<RefableType> types = IterableExtensions.<RefableType>toList(IterableExtensions.<VarDecl, RefableType>map(varDeclarations, _function_5));
        final RefableType rt = this.roomHelpers.getLastCommonSuperType(types);
        boolean _notEquals = (!Objects.equal(rt, null));
        if (_notEquals) {
          final VarDecl vd = RoomFactory.eINSTANCE.createVarDecl();
          vd.setName("data");
          vd.setRefType(rt);
          return vd;
        }
      }
    }
    return null;
  }
  
  private static TransitionBase realTransition(final TransitionBase t) {
    TransitionBase tr = t;
    while ((tr instanceof RefinedTransition)) {
      tr = ((RefinedTransition)tr).getTarget();
    }
    return tr;
  }
}
