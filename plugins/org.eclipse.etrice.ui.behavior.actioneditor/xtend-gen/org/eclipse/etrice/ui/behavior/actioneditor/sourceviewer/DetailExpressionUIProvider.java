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
package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.actioneditor.Activator;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeColorManager;
import org.eclipse.etrice.ui.behavior.detailcode.RuntimeDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class DetailExpressionUIProvider implements IDetailExpressionProvider {
  private final static String IMAGE_RT_METHOD = "icons/rt_method.png";
  
  @Delegate
  private final IDetailExpressionProvider delegate;
  
  @Inject
  protected ILabelProvider labelProvider;
  
  @Inject
  protected RoomHelpers roomHelpers;
  
  /**
   * Return postfix string and its selection (relative start, length)
   */
  public Pair<String, Point> getPostfixReplacement(final IDetailExpressionProvider.ExpressionFeature feature) {
    Pair<String, Point> _xblockexpression = null;
    {
      this.assertNotNull(feature);
      String[] _switchResult = null;
      IDetailExpressionProvider.ExpressionPostfix _postfix = feature.getPostfix();
      if (_postfix != null) {
        switch (_postfix) {
          case PARENTHESES:
            _switchResult = new String[] { "(", ")" };
            break;
          case BRACKETS:
            _switchResult = new String[] { "[", "]" };
            break;
          default:
            return Pair.<String, Point>of("", null);
        }
      } else {
        return Pair.<String, Point>of("", null);
      }
      String[] brackets = _switchResult;
      String _switchResult_1 = null;
      Object _data = feature.getData();
      final Object data = _data;
      boolean _matched = false;
      if (!_matched) {
        if (data instanceof Operation) {
          _matched=true;
          EList<VarDecl> _arguments = ((Operation)data).getArguments();
          final Function1<VarDecl, String> _function = new Function1<VarDecl, String>() {
            public String apply(final VarDecl it) {
              return it.getName();
            }
          };
          List<String> _map = ListExtensions.<VarDecl, String>map(_arguments, _function);
          _switchResult_1 = IterableExtensions.join(_map, ", ");
        }
      }
      if (!_matched) {
        if (data instanceof Message) {
          VarDecl _data_1 = ((Message)data).getData();
          boolean _notEquals = (!Objects.equal(_data_1, null));
          if (_notEquals) {
            _matched=true;
            VarDecl _data_2 = ((Message)data).getData();
            _switchResult_1 = _data_2.getName();
          }
        }
      }
      if (!_matched) {
        if (data instanceof Attribute) {
          _matched=true;
        }
        if (!_matched) {
          if (data instanceof InterfaceItem) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult_1 = "0";
        }
      }
      if (!_matched) {
        _switchResult_1 = "";
      }
      String replacement = _switchResult_1;
      Point _xifexpression = null;
      boolean _isEmpty = replacement.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        int _length = replacement.length();
        _xifexpression = new Point(1, _length);
      }
      final Point selection = _xifexpression;
      final String[] _converted_brackets = (String[])brackets;
      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_converted_brackets)));
      String _plus = (_head + replacement);
      final String[] _converted_brackets_1 = (String[])brackets;
      String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(_converted_brackets_1)));
      String _plus_1 = (_plus + _last);
      _xblockexpression = Pair.<String, Point>of(_plus_1, selection);
    }
    return _xblockexpression;
  }
  
  /**
   * Return completion string and its selection (relative start, length)
   */
  public Pair<String, Point> getCompletion(final IDetailExpressionProvider.ExpressionFeature feature) {
    this.assertNotNull(feature);
    Pair<String, Point> postfix = this.getPostfixReplacement(feature);
    Point point = postfix.getValue();
    boolean _notEquals = (!Objects.equal(point, null));
    if (_notEquals) {
      int _x = point.x;
      String _id = feature.getId();
      int _length = _id.length();
      point.x = (_x + _length);
    }
    String _id_1 = feature.getId();
    String _key = postfix.getKey();
    String _plus = (_id_1 + _key);
    return Pair.<String, Point>of(_plus, point);
  }
  
  public RGB getColor(final IDetailExpressionProvider.ExpressionFeature feature) {
    this.assertNotNull(feature);
    RGB _switchResult = null;
    Object _data = feature.getData();
    final Object data = _data;
    boolean _matched = false;
    if (!_matched) {
      if (data instanceof InterfaceItem) {
        _matched=true;
        _switchResult = ActionCodeColorManager.INTERFACE_ITEM;
      }
    }
    if (!_matched) {
      if (data instanceof Attribute) {
        _matched=true;
        _switchResult = ActionCodeColorManager.ATTRIBUTE;
      }
    }
    if (!_matched) {
      if (data instanceof Operation) {
        _matched=true;
        _switchResult = ActionCodeColorManager.OPERATION;
      }
    }
    if (!_matched) {
      if (data instanceof EObject) {
        _matched=true;
        _switchResult = ActionCodeColorManager.SPECIAL_FEATURE;
      }
    }
    return _switchResult;
  }
  
  /**
   * Text format:
   * {@code completionInfo : typedInfo - classInfo}
   */
  public String getDisplayString(final IDetailExpressionProvider.ExpressionFeature feature) {
    this.assertNotNull(feature);
    final Object data = feature.getData();
    String _id = feature.getId();
    Pair<String, Point> _postfixReplacement = this.getPostfixReplacement(feature);
    String _key = _postfixReplacement.getKey();
    String completionInfo = (_id + _key);
    String typedInfo = "";
    String _xifexpression = null;
    if ((data instanceof EObject)) {
      EClass _eClass = ((EObject)data).eClass();
      _xifexpression = _eClass.getName();
    } else {
      _xifexpression = "";
    }
    String classInfo = _xifexpression;
    boolean _matched = false;
    if (!_matched) {
      if (data instanceof Attribute) {
        _matched=true;
        RefableType _type = ((Attribute)data).getType();
        DataType _type_1 = _type.getType();
        String _name = _type_1.getName();
        typedInfo = _name;
      }
    }
    if (!_matched) {
      if (data instanceof InterfaceItem) {
        _matched=true;
        ProtocolClass _protocol = this.roomHelpers.getProtocol(((InterfaceItem)data));
        String _name = _protocol.getName();
        typedInfo = _name;
      }
    }
    if (!_matched) {
      if (data instanceof RuntimeDetailExpressionProvider.RuntimeMethodExpressionData) {
        _matched=true;
        typedInfo = "int";
      }
    }
    if (!_matched) {
      {
        final String label = this.labelProvider.getText(data);
        String _commonPrefix = Strings.commonPrefix(label, completionInfo);
        boolean _isEmpty = _commonPrefix.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          completionInfo = label;
        }
      }
    }
    IDetailExpressionProvider.ExpressionPostfix _postfix = feature.getPostfix();
    boolean _equals = Objects.equal(_postfix, IDetailExpressionProvider.ExpressionPostfix.NONE);
    if (_equals) {
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (data instanceof SPP) {
          boolean _isEventDriven = ((SPP)data).isEventDriven();
          if (_isEventDriven) {
            _matched_1=true;
          }
        }
        if (!_matched_1) {
          if (data instanceof Port) {
            boolean _and = false;
            boolean _isReplicated = ((Port)data).isReplicated();
            if (!_isReplicated) {
              _and = false;
            } else {
              boolean _isEventDriven = ((Port)data).isEventDriven();
              _and = _isEventDriven;
            }
            if (_and) {
              _matched_1=true;
            }
          }
        }
        if (_matched_1) {
          completionInfo = (completionInfo + " (broadcast)");
        }
      }
    }
    boolean _isEmpty = typedInfo.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      typedInfo = (" : " + typedInfo);
    }
    boolean _isEmpty_1 = classInfo.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      classInfo = (" - " + classInfo);
    }
    return ((completionInfo + typedInfo) + classInfo);
  }
  
  public Image getImage(final IDetailExpressionProvider.ExpressionFeature feature) {
    Image _xblockexpression = null;
    {
      this.assertNotNull(feature);
      Image _switchResult = null;
      Object _data = feature.getData();
      boolean _matched = false;
      if (!_matched) {
        if (_data instanceof EObject) {
          _matched=true;
          Object _data_1 = feature.getData();
          _switchResult = this.labelProvider.getImage(_data_1);
        }
      }
      if (!_matched) {
        if (_data instanceof RuntimeDetailExpressionProvider.RuntimeMethodExpressionData) {
          _matched=true;
          _switchResult = Activator.getImage(DetailExpressionUIProvider.IMAGE_RT_METHOD);
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  /**
   * Filter by prefix
   */
  public Iterable<IDetailExpressionProvider.ExpressionFeature> getContextFeaturesWithPrefix(final IDetailExpressionProvider.ExpressionFeature ctx, final String prefix) {
    List<IDetailExpressionProvider.ExpressionFeature> _contextFeatures = this.delegate.getContextFeatures(ctx);
    final Function1<IDetailExpressionProvider.ExpressionFeature, Boolean> _function = new Function1<IDetailExpressionProvider.ExpressionFeature, Boolean>() {
      public Boolean apply(final IDetailExpressionProvider.ExpressionFeature it) {
        String _id = it.getId();
        return Boolean.valueOf(_id.startsWith(prefix));
      }
    };
    return IterableExtensions.<IDetailExpressionProvider.ExpressionFeature>filter(_contextFeatures, _function);
  }
  
  /**
   * Filter by prefix
   */
  public Iterable<IDetailExpressionProvider.ExpressionFeature> getInitialFeaturesWithPrefix(final String prefix) {
    List<IDetailExpressionProvider.ExpressionFeature> _initialFeatures = this.delegate.getInitialFeatures();
    final Function1<IDetailExpressionProvider.ExpressionFeature, Boolean> _function = new Function1<IDetailExpressionProvider.ExpressionFeature, Boolean>() {
      public Boolean apply(final IDetailExpressionProvider.ExpressionFeature it) {
        String _id = it.getId();
        return Boolean.valueOf(_id.startsWith(prefix));
      }
    };
    return IterableExtensions.<IDetailExpressionProvider.ExpressionFeature>filter(_initialFeatures, _function);
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
  
  public DetailExpressionUIProvider(final IDetailExpressionProvider delegate) {
    super();
    this.delegate = delegate;
  }
  
  public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
    return this.delegate.getContextFeatures(ctx);
  }
  
  public List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures() {
    return this.delegate.getInitialFeatures();
  }
}
