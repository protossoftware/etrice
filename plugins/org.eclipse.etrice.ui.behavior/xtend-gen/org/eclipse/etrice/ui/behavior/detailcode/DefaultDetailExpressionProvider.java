/**
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.detailcode;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.ui.behavior.detailcode.GuardDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Defines expression for fsm detail code of an ActorClass
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DefaultDetailExpressionProvider extends GuardDetailExpressionProvider {
  public List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures() {
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    boolean _notEquals = (!Objects.equal(this.transitionEventData, null));
    if (_notEquals) {
      IDetailExpressionProvider.ExpressionFeature _createExprFeature = this.createExprFeature(this.transitionEventData);
      scope.add(_createExprFeature);
    }
    List<InterfaceItem> _allInterfaceItems = this.roomHelpers.getAllInterfaceItems(this.actorClass);
    final Consumer<InterfaceItem> _function = new Consumer<InterfaceItem>() {
      public void accept(final InterfaceItem it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof SPP) {
            boolean _isEventDriven = ((SPP)it).isEventDriven();
            if (_isEventDriven) {
              _matched=true;
            }
          }
          if (!_matched) {
            if (it instanceof Port) {
              boolean _and = false;
              boolean _isEventDriven = ((Port)it).isEventDriven();
              if (!_isEventDriven) {
                _and = false;
              } else {
                boolean _isReplicated = ((Port)it).isReplicated();
                _and = _isReplicated;
              }
              if (_and) {
                _matched=true;
              }
            }
          }
          if (_matched) {
            IDetailExpressionProvider.ExpressionFeature _createExprFeature = DefaultDetailExpressionProvider.this.createExprFeature(it);
            scope.add(_createExprFeature);
            IDetailExpressionProvider.ExpressionFeature _createExprFeature_1 = DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
            scope.add(_createExprFeature_1);
          }
        }
        if (!_matched) {
          if (it instanceof Port) {
            boolean _isReplicated = ((Port)it).isReplicated();
            if (_isReplicated) {
              _matched=true;
            }
          }
          if (!_matched) {
            if (it instanceof SPP) {
              _matched=true;
            }
          }
          if (_matched) {
            IDetailExpressionProvider.ExpressionFeature _createExprFeature_2 = DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
            scope.add(_createExprFeature_2);
          }
        }
        if (!_matched) {
          IDetailExpressionProvider.ExpressionFeature _createExprFeature_3 = DefaultDetailExpressionProvider.this.createExprFeature(it);
          scope.add(_createExprFeature_3);
        }
      }
    };
    _allInterfaceItems.forEach(_function);
    List<StandardOperation> _latestOperations = this.roomHelpers.getLatestOperations(this.actorClass);
    final Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature> _function_1 = new Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature>() {
      public IDetailExpressionProvider.ExpressionFeature apply(final StandardOperation it) {
        return DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
      }
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map = ListExtensions.<StandardOperation, IDetailExpressionProvider.ExpressionFeature>map(_latestOperations, _function_1);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
    List<Attribute> _allAttributes = this.roomHelpers.getAllAttributes(this.actorClass);
    final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function_2 = new Function1<Attribute, IDetailExpressionProvider.ExpressionFeature>() {
      public IDetailExpressionProvider.ExpressionFeature apply(final Attribute it) {
        IDetailExpressionProvider.ExpressionFeature _switchResult = null;
        int _size = it.getSize();
        boolean _matched = false;
        if (!_matched) {
          int _size_1 = it.getSize();
          boolean _greaterThan = (_size_1 > 1);
          if (_greaterThan) {
            _matched=true;
            _switchResult = DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
          }
        }
        if (!_matched) {
          _switchResult = DefaultDetailExpressionProvider.this.createExprFeature(it);
        }
        return _switchResult;
      }
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function_2);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
    return scope;
  }
  
  public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
    this.assertNotNull(ctx);
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    Object _data = ctx.getData();
    final Object obj = _data;
    boolean _matched = false;
    if (!_matched) {
      if (obj instanceof Port) {
        int _multiplicity = ((Port)obj).getMultiplicity();
        boolean _equals = (_multiplicity == 1);
        if (_equals) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (obj instanceof SAP) {
          _matched=true;
        }
      }
      if (_matched) {
        ProtocolClass _protocol = this.roomHelpers.getProtocol(((InterfaceItem)obj));
        boolean _isConjugated = this.roomHelpers.isConjugated(((InterfaceItem)obj));
        boolean _not = (!_isConjugated);
        List<PortOperation> _allOperations = this.roomHelpers.getAllOperations(_protocol, _not);
        final Function1<PortOperation, IDetailExpressionProvider.ExpressionFeature> _function = new Function1<PortOperation, IDetailExpressionProvider.ExpressionFeature>() {
          public IDetailExpressionProvider.ExpressionFeature apply(final PortOperation it) {
            return DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
          }
        };
        List<IDetailExpressionProvider.ExpressionFeature> _map = ListExtensions.<PortOperation, IDetailExpressionProvider.ExpressionFeature>map(_allOperations, _function);
        Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
      }
    }
    Object _data_1 = ctx.getData();
    final Object obj_1 = _data_1;
    boolean _matched_1 = false;
    if (!_matched_1) {
      if (obj_1 instanceof InterfaceItem) {
        _matched_1=true;
        final ProtocolClass pc = this.roomHelpers.getProtocol(((InterfaceItem)obj_1));
        CommunicationType _commType = pc.getCommType();
        if (_commType != null) {
          switch (_commType) {
            case EVENT_DRIVEN:
              boolean _isConjugated_1 = this.roomHelpers.isConjugated(((InterfaceItem)obj_1));
              List<Message> _allMessages = this.roomHelpers.getAllMessages(pc, _isConjugated_1);
              final Function1<Message, IDetailExpressionProvider.ExpressionFeature> _function_1 = new Function1<Message, IDetailExpressionProvider.ExpressionFeature>() {
                public IDetailExpressionProvider.ExpressionFeature apply(final Message it) {
                  return DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
                }
              };
              List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<Message, IDetailExpressionProvider.ExpressionFeature>map(_allMessages, _function_1);
              Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
              break;
            case DATA_DRIVEN:
              boolean _isConjugated_2 = this.roomHelpers.isConjugated(((InterfaceItem)obj_1));
              if (_isConjugated_2) {
                List<Message> _allIncomingMessages = this.roomHelpers.getAllIncomingMessages(pc);
                final Function1<Message, IDetailExpressionProvider.ExpressionFeature> _function_2 = new Function1<Message, IDetailExpressionProvider.ExpressionFeature>() {
                  public IDetailExpressionProvider.ExpressionFeature apply(final Message it) {
                    return DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
                  }
                };
                List<IDetailExpressionProvider.ExpressionFeature> _map_2 = ListExtensions.<Message, IDetailExpressionProvider.ExpressionFeature>map(_allIncomingMessages, _function_2);
                Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_2);
              } else {
                List<Message> _allIncomingMessages_1 = this.roomHelpers.getAllIncomingMessages(pc);
                final Function1<Message, IDetailExpressionProvider.ExpressionFeature> _function_3 = new Function1<Message, IDetailExpressionProvider.ExpressionFeature>() {
                  public IDetailExpressionProvider.ExpressionFeature apply(final Message it) {
                    return DefaultDetailExpressionProvider.this.createExprFeature(it);
                  }
                };
                List<IDetailExpressionProvider.ExpressionFeature> _map_3 = ListExtensions.<Message, IDetailExpressionProvider.ExpressionFeature>map(_allIncomingMessages_1, _function_3);
                Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_3);
              }
              break;
            case SYNCHRONOUS:
              break;
            default:
              break;
          }
        }
      }
    }
    if (!_matched_1) {
      if (obj_1 instanceof Attribute) {
        RefableType _type = ((Attribute)obj_1).getType();
        DataType _type_1 = _type.getType();
        if ((_type_1 instanceof DataClass)) {
          _matched_1=true;
          RefableType _type_2 = ((Attribute)obj_1).getType();
          DataType _type_3 = _type_2.getType();
          final DataClass dc = ((DataClass) _type_3);
          List<Attribute> _allAttributes = this.roomHelpers.getAllAttributes(dc);
          final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function_1 = new Function1<Attribute, IDetailExpressionProvider.ExpressionFeature>() {
            public IDetailExpressionProvider.ExpressionFeature apply(final Attribute it) {
              IDetailExpressionProvider.ExpressionFeature _xifexpression = null;
              int _size = it.getSize();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                _xifexpression = DefaultDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
              } else {
                _xifexpression = DefaultDetailExpressionProvider.this.createExprFeature(it);
              }
              return _xifexpression;
            }
          };
          List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function_1);
          Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
        }
      }
    }
    return scope;
  }
  
  public DefaultDetailExpressionProvider(final ActorClass actorClass) {
    super(actorClass);
  }
}
