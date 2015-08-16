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

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Defines expression for fsm guards of an ActorClass
 * <ul>
 * <li>attributes and operations of ActorClass</li>
 * <li>data-driven incoming messages</li>
 * </ul>
 */
@SuppressWarnings("all")
public class GuardDetailExpressionProvider implements IDetailExpressionProvider {
  @Accessors
  protected final ActorClass actorClass;
  
  @Accessors
  protected Message currentEventMessage;
  
  @Extension
  protected final RoomHelpers roomHelpers;
  
  protected final Function<EObject, String> nameProvider = SimpleAttributeResolver.NAME_RESOLVER;
  
  public GuardDetailExpressionProvider(final ActorClass actorClass) {
    this.actorClass = actorClass;
    SupportUtil _instance = SupportUtil.getInstance();
    RoomHelpers _roomHelpers = _instance.getRoomHelpers();
    this.roomHelpers = _roomHelpers;
  }
  
  public List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures() {
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    boolean _notEquals = (!Objects.equal(this.currentEventMessage, null));
    if (_notEquals) {
      VarDecl _data = this.currentEventMessage.getData();
      IDetailExpressionProvider.ExpressionFeature _createExprFeature = this.createExprFeature(_data);
      scope.add(_createExprFeature);
    }
    List<InterfaceItem> _allInterfaceItems = this.roomHelpers.getAllInterfaceItems(this.actorClass);
    final Function1<InterfaceItem, Boolean> _function = new Function1<InterfaceItem, Boolean>() {
      public Boolean apply(final InterfaceItem it) {
        boolean _and = false;
        boolean _isDataDriven = GuardDetailExpressionProvider.this.roomHelpers.isDataDriven(it);
        if (!_isDataDriven) {
          _and = false;
        } else {
          boolean _isConjugated = GuardDetailExpressionProvider.this.roomHelpers.isConjugated(it);
          boolean _not = (!_isConjugated);
          _and = _not;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<InterfaceItem> _filter = IterableExtensions.<InterfaceItem>filter(_allInterfaceItems, _function);
    final Function1<InterfaceItem, IDetailExpressionProvider.ExpressionFeature> _function_1 = new Function1<InterfaceItem, IDetailExpressionProvider.ExpressionFeature>() {
      public IDetailExpressionProvider.ExpressionFeature apply(final InterfaceItem it) {
        IDetailExpressionProvider.ExpressionFeature _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof Port) {
            boolean _isReplicated = ((Port)it).isReplicated();
            if (_isReplicated) {
              _matched=true;
              _switchResult = GuardDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
            }
          }
        }
        if (!_matched) {
          _switchResult = GuardDetailExpressionProvider.this.createExprFeature(it);
        }
        return _switchResult;
      }
    };
    Iterable<IDetailExpressionProvider.ExpressionFeature> _map = IterableExtensions.<InterfaceItem, IDetailExpressionProvider.ExpressionFeature>map(_filter, _function_1);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
    List<StandardOperation> _latestOperations = this.roomHelpers.getLatestOperations(this.actorClass);
    final Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature> _function_2 = new Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature>() {
      public IDetailExpressionProvider.ExpressionFeature apply(final StandardOperation it) {
        return GuardDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
      }
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<StandardOperation, IDetailExpressionProvider.ExpressionFeature>map(_latestOperations, _function_2);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
    List<Attribute> _allAttributes = this.roomHelpers.getAllAttributes(this.actorClass);
    final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function_3 = new Function1<Attribute, IDetailExpressionProvider.ExpressionFeature>() {
      public IDetailExpressionProvider.ExpressionFeature apply(final Attribute it) {
        IDetailExpressionProvider.ExpressionFeature _switchResult = null;
        int _size = it.getSize();
        boolean _matched = false;
        if (!_matched) {
          int _size_1 = it.getSize();
          boolean _greaterThan = (_size_1 > 1);
          if (_greaterThan) {
            _matched=true;
            _switchResult = GuardDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
          }
        }
        if (!_matched) {
          _switchResult = GuardDetailExpressionProvider.this.createExprFeature(it);
        }
        return _switchResult;
      }
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map_2 = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function_3);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_2);
    return scope;
  }
  
  public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
    this.assertNotNull(ctx);
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    Object _data = ctx.getData();
    final Object obj = _data;
    boolean _matched = false;
    if (!_matched) {
      if (obj instanceof InterfaceItem) {
        _matched=true;
        final ProtocolClass pc = this.roomHelpers.getProtocol(((InterfaceItem)obj));
        CommunicationType _commType = pc.getCommType();
        if (_commType != null) {
          switch (_commType) {
            case DATA_DRIVEN:
              boolean _isConjugated = this.roomHelpers.isConjugated(((InterfaceItem)obj));
              boolean _not = (!_isConjugated);
              if (_not) {
                List<Message> _allIncomingMessages = this.roomHelpers.getAllIncomingMessages(pc);
                final Function1<Message, IDetailExpressionProvider.ExpressionFeature> _function = new Function1<Message, IDetailExpressionProvider.ExpressionFeature>() {
                  public IDetailExpressionProvider.ExpressionFeature apply(final Message it) {
                    return GuardDetailExpressionProvider.this.createExprFeature(it);
                  }
                };
                List<IDetailExpressionProvider.ExpressionFeature> _map = ListExtensions.<Message, IDetailExpressionProvider.ExpressionFeature>map(_allIncomingMessages, _function);
                Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
              }
              break;
            default:
              break;
          }
        }
      }
    }
    if (!_matched) {
      if (obj instanceof Attribute) {
        RefableType _type = ((Attribute)obj).getType();
        DataType _type_1 = _type.getType();
        if ((_type_1 instanceof DataClass)) {
          _matched=true;
          RefableType _type_2 = ((Attribute)obj).getType();
          DataType _type_3 = _type_2.getType();
          final DataClass dc = ((DataClass) _type_3);
          List<Attribute> _allAttributes = this.roomHelpers.getAllAttributes(dc);
          final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function = new Function1<Attribute, IDetailExpressionProvider.ExpressionFeature>() {
            public IDetailExpressionProvider.ExpressionFeature apply(final Attribute it) {
              IDetailExpressionProvider.ExpressionFeature _xifexpression = null;
              int _size = it.getSize();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                _xifexpression = GuardDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
              } else {
                _xifexpression = GuardDetailExpressionProvider.this.createExprFeature(it);
              }
              return _xifexpression;
            }
          };
          List<IDetailExpressionProvider.ExpressionFeature> _map = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function);
          Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
          List<StandardOperation> _latestOperations = this.roomHelpers.getLatestOperations(dc);
          final Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature> _function_1 = new Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature>() {
            public IDetailExpressionProvider.ExpressionFeature apply(final StandardOperation it) {
              return GuardDetailExpressionProvider.this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
            }
          };
          List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<StandardOperation, IDetailExpressionProvider.ExpressionFeature>map(_latestOperations, _function_1);
          Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
        }
      }
    }
    return scope;
  }
  
  protected IDetailExpressionProvider.ExpressionFeature createExprFeature(final EObject eObj) {
    return this.createExprFeature(eObj, IDetailExpressionProvider.ExpressionPostfix.NONE);
  }
  
  protected IDetailExpressionProvider.ExpressionFeature createExprFeature(final EObject eObj, final IDetailExpressionProvider.ExpressionPostfix postfix) {
    String _apply = this.nameProvider.apply(eObj);
    final IDetailExpressionProvider.ExpressionFeature feature = new IDetailExpressionProvider.ExpressionFeature(_apply, postfix);
    feature.setData(eObj);
    return feature;
  }
  
  protected void assertNotNull(final IDetailExpressionProvider.ExpressionFeature feature) {
    String _id = feature.getId();
    boolean _isNullOrEmpty = Strings.isNullOrEmpty(_id);
    boolean _not = (!_isNullOrEmpty);
    Assert.isTrue(_not);
    IDetailExpressionProvider.ExpressionPostfix _postfix = feature.getPostfix();
    Assert.isNotNull(_postfix);
    Object _data = feature.getData();
    Assert.isNotNull(_data);
  }
  
  @Pure
  public ActorClass getActorClass() {
    return this.actorClass;
  }
  
  @Pure
  public Message getCurrentEventMessage() {
    return this.currentEventMessage;
  }
  
  public void setCurrentEventMessage(final Message currentEventMessage) {
    this.currentEventMessage = currentEventMessage;
  }
}
