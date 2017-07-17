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
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Defines expression for fsm guards of an ActorClass
 * <ul>
 * <li>attributes and operations of ActorClass</li>
 * <li>data-driven incoming messages</li>
 * </ul>
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class GuardDetailExpressionProvider implements IDetailExpressionProvider {
  protected final ActorClass actorClass;
  
  @Extension
  protected final RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
  
  protected final Function<EObject, String> nameProvider = SimpleAttributeResolver.NAME_RESOLVER;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  protected VarDecl transitionEventData;
  
  @Override
  public List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures() {
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    boolean _notEquals = (!Objects.equal(this.transitionEventData, null));
    if (_notEquals) {
      IDetailExpressionProvider.ExpressionFeature _createExprFeature = this.createExprFeature(this.transitionEventData, IDetailExpressionProvider.ExpressionPostfix.NONE);
      scope.add(_createExprFeature);
    }
    List<InterfaceItem> _allInterfaceItems = this.roomHelpers.getAllInterfaceItems(this.actorClass);
    final Function1<InterfaceItem, Boolean> _function = (InterfaceItem it) -> {
      return Boolean.valueOf((it.isEventDriven() || (!this.roomHelpers.isConjugated(it))));
    };
    Iterable<InterfaceItem> _filter = IterableExtensions.<InterfaceItem>filter(_allInterfaceItems, _function);
    final Function1<InterfaceItem, IDetailExpressionProvider.ExpressionFeature> _function_1 = (InterfaceItem it) -> {
      IDetailExpressionProvider.ExpressionFeature _switchResult = null;
      boolean _matched = false;
      if (it instanceof Port) {
        boolean _isReplicated = ((Port)it).isReplicated();
        if (_isReplicated) {
          _matched=true;
          _switchResult = this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
        }
      }
      if (!_matched) {
        _switchResult = this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.NONE);
      }
      return _switchResult;
    };
    Iterable<IDetailExpressionProvider.ExpressionFeature> _map = IterableExtensions.<InterfaceItem, IDetailExpressionProvider.ExpressionFeature>map(_filter, _function_1);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
    List<StandardOperation> _latestOperations = this.roomHelpers.getLatestOperations(this.actorClass);
    final Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature> _function_2 = (StandardOperation it) -> {
      return this.createExprFeature(it);
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<StandardOperation, IDetailExpressionProvider.ExpressionFeature>map(_latestOperations, _function_2);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
    List<Attribute> _allAttributes = this.roomHelpers.getAllAttributes(this.actorClass);
    final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function_3 = (Attribute it) -> {
      return this.createExprFeature(it);
    };
    List<IDetailExpressionProvider.ExpressionFeature> _map_2 = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function_3);
    Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_2);
    return scope;
  }
  
  @Override
  public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
    this.assertNotNull(ctx);
    final List<IDetailExpressionProvider.ExpressionFeature> scope = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
    Object _data = ctx.getData();
    final Object obj = _data;
    boolean _matched = false;
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
      final Function1<PortOperation, IDetailExpressionProvider.ExpressionFeature> _function = (PortOperation it) -> {
        return this.createExprFeature(it);
      };
      List<IDetailExpressionProvider.ExpressionFeature> _map = ListExtensions.<PortOperation, IDetailExpressionProvider.ExpressionFeature>map(_allOperations, _function);
      Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map);
    }
    Object _data_1 = ctx.getData();
    final Object obj_1 = _data_1;
    boolean _matched_1 = false;
    if (obj_1 instanceof InterfaceItem) {
      _matched_1=true;
      final ProtocolClass pc = this.roomHelpers.getProtocol(((InterfaceItem)obj_1));
      CommunicationType _commType = pc.getCommType();
      if (_commType != null) {
        switch (_commType) {
          case DATA_DRIVEN:
            boolean _isConjugated_1 = this.roomHelpers.isConjugated(((InterfaceItem)obj_1));
            boolean _not_1 = (!_isConjugated_1);
            if (_not_1) {
              List<Message> _allIncomingMessages = this.roomHelpers.getAllIncomingMessages(pc);
              final Function1<Message, IDetailExpressionProvider.ExpressionFeature> _function_1 = (Message it) -> {
                return this.createExprFeature(it);
              };
              List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<Message, IDetailExpressionProvider.ExpressionFeature>map(_allIncomingMessages, _function_1);
              Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
            }
            break;
          case EVENT_DRIVEN:
            break;
          case SYNCHRONOUS:
            break;
          default:
            break;
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
          final Function1<Attribute, IDetailExpressionProvider.ExpressionFeature> _function_1 = (Attribute it) -> {
            return this.createExprFeature(it);
          };
          List<IDetailExpressionProvider.ExpressionFeature> _map_1 = ListExtensions.<Attribute, IDetailExpressionProvider.ExpressionFeature>map(_allAttributes, _function_1);
          Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_1);
          List<StandardOperation> _latestOperations = this.roomHelpers.getLatestOperations(dc);
          final Function1<StandardOperation, IDetailExpressionProvider.ExpressionFeature> _function_2 = (StandardOperation it) -> {
            return this.createExprFeature(it);
          };
          List<IDetailExpressionProvider.ExpressionFeature> _map_2 = ListExtensions.<StandardOperation, IDetailExpressionProvider.ExpressionFeature>map(_latestOperations, _function_2);
          Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(scope, _map_2);
        }
      }
    }
    return scope;
  }
  
  public IDetailExpressionProvider.ExpressionFeature createExprFeature(final Operation it) {
    return this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
  }
  
  public IDetailExpressionProvider.ExpressionFeature createExprFeature(final Message it) {
    return this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
  }
  
  public IDetailExpressionProvider.ExpressionFeature createExprFeature(final Attribute it) {
    IDetailExpressionProvider.ExpressionFeature _switchResult = null;
    int _size = it.getSize();
    boolean _matched = false;
    int _size_1 = it.getSize();
    boolean _greaterThan = (_size_1 > 1);
    if (_greaterThan) {
      _matched=true;
      _switchResult = this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.BRACKETS);
    }
    if (!_matched) {
      _switchResult = this.createExprFeature(it, IDetailExpressionProvider.ExpressionPostfix.NONE);
    }
    return _switchResult;
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
  
  public GuardDetailExpressionProvider(final ActorClass actorClass) {
    super();
    this.actorClass = actorClass;
  }
  
  public void setTransitionEventData(final VarDecl transitionEventData) {
    this.transitionEventData = transitionEventData;
  }
}
