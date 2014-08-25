/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Initialization {
  @Inject
  private CExtensions languageExt;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  public CharSequence generateAttributeInit(final InstanceBase instance, final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        String _initAttributeArray = this.initAttributeArray(instance, _union);
        _builder.append(_initAttributeArray, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private String initAttributeArray(final InstanceBase instance, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("/* ");
      String _name = a.getName();
      _builder.append(_name, "\t\t");
      {
        int _size = a.getSize();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          _builder.append("[");
          int _size_1 = a.getSize();
          _builder.append(_size_1, "\t\t");
          _builder.append("]");
        }
      }
      _builder.append(" */");
      String COMMENT = _builder.toString();
      String _xifexpression = null;
      boolean _or = false;
      int _size_2 = a.getSize();
      boolean _equals = (_size_2 == 0);
      if (_equals) {
        _or = true;
      } else {
        boolean _and = false;
        RefableType _type = a.getType();
        boolean _isRef = _type.isRef();
        boolean _not = (!_isRef);
        if (!_not) {
          _and = false;
        } else {
          RefableType _type_1 = a.getType();
          DataType _type_2 = _type_1.getType();
          boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(_type_2);
          _and = _isEnumerationOrPrimitive;
        }
        _or = _and;
      }
      if (_or) {
        CharSequence _initAttribute = this.initAttribute(instance, path);
        _xifexpression = (_initAttribute + COMMENT);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{ ");
        {
          int _size_3 = a.getSize();
          IntegerRange _upTo = new IntegerRange(1, _size_3);
          boolean _hasElements = false;
          for(final Integer i : _upTo) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder_1.appendImmediate(", ", "");
            }
            CharSequence _initAttribute_1 = this.initAttribute(instance, path);
            _builder_1.append(_initAttribute_1, "");
          }
        }
        _builder_1.append(" } ");
        _builder_1.append(COMMENT, "");
        _builder_1.newLineIfNotEmpty();
        _xifexpression = _builder_1.toString();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private CharSequence initAttribute(final InstanceBase instance, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _type = a.getType();
      DataType aType = _type.getType();
      RefableType _type_1 = a.getType();
      boolean _isRef = _type_1.isRef();
      if (_isRef) {
        String _xifexpression = null;
        String _defaultValueLiteral = a.getDefaultValueLiteral();
        boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
        if (_notEquals) {
          _xifexpression = a.getDefaultValueLiteral();
        } else {
          _xifexpression = this.languageExt.nullPointer();
        }
        return _xifexpression;
      }
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (aType instanceof DataClass) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{");
          _builder.newLine();
          {
            List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass) aType));
            boolean _hasElements = false;
            for(final Attribute subA : _allAttributes) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, subA);
              String _initAttributeArray = this.initAttributeArray(instance, _union);
              _builder.append(_initAttributeArray, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _switchResult = _builder;
        }
      }
      if (!_matched) {
        if (aType instanceof ExternalType) {
          _matched=true;
          String _xifexpression_1 = null;
          String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
          boolean _notEquals_1 = (!Objects.equal(_defaultValueLiteral_1, null));
          if (_notEquals_1) {
            _xifexpression_1 = a.getDefaultValueLiteral();
          } else {
            _xifexpression_1 = this.languageExt.defaultValue(aType);
          }
          _switchResult = _xifexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String value = this.getPrimitiveValue(instance, path);
            CharSequence _xifexpression_1 = null;
            boolean _and = false;
            boolean _and_1 = false;
            int _size = a.getSize();
            boolean _greaterThan = (_size > 0);
            if (!_greaterThan) {
              _and_1 = false;
            } else {
              boolean _isCharacterType = this._typeHelpers.isCharacterType(((PrimitiveType)aType));
              boolean _not = (!_isCharacterType);
              _and_1 = _not;
            }
            if (!_and_1) {
              _and = false;
            } else {
              String _trim = value.trim();
              boolean _startsWith = _trim.startsWith("{");
              boolean _not_1 = (!_startsWith);
              _and = _not_1;
            }
            if (_and) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("{");
              {
                int _size_1 = a.getSize();
                IntegerRange _upTo = new IntegerRange(1, _size_1);
                boolean _hasElements = false;
                for(final Integer i : _upTo) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(", ", "");
                  }
                  _builder.append(value, "");
                }
              }
              _builder.append("}");
              _xifexpression_1 = _builder;
            } else {
              _xifexpression_1 = value;
            }
            _xblockexpression_1 = _xifexpression_1;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof EnumerationType) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String value = this.getPrimitiveValue(instance, path);
            CharSequence _xifexpression_1 = null;
            boolean _and = false;
            int _size = a.getSize();
            boolean _greaterThan = (_size > 0);
            if (!_greaterThan) {
              _and = false;
            } else {
              String _trim = value.trim();
              boolean _startsWith = _trim.startsWith("{");
              boolean _not = (!_startsWith);
              _and = _not;
            }
            if (_and) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("{");
              {
                int _size_1 = a.getSize();
                IntegerRange _upTo = new IntegerRange(1, _size_1);
                boolean _hasElements = false;
                for(final Integer i : _upTo) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(", ", "");
                  }
                  _builder.append(value, "");
                }
              }
              _builder.append("}");
              _xifexpression_1 = _builder;
            } else {
              _xifexpression_1 = value;
            }
            _xblockexpression_1 = _xifexpression_1;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  private String getPrimitiveValue(final InstanceBase instance, final List<Attribute> path) {
    String value = this._typeHelpers.getAttrInstanceConfigValue(path, instance);
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (instance instanceof ActorInstance) {
          _matched=true;
          ActorClass _actorClass = ((ActorInstance)instance).getActorClass();
          _switchResult = this._typeHelpers.getAttrClassConfigValue(path, _actorClass, true);
        }
      }
      if (!_matched) {
        if (instance instanceof InterfaceItemInstance) {
          _matched=true;
          InterfaceItem _interfaceItem = ((InterfaceItemInstance)instance).getInterfaceItem();
          PortClass _portClass = this._roomHelpers.getPortClass(_interfaceItem);
          _switchResult = this._typeHelpers.getAttrClassConfigValue(path, _portClass);
        }
      }
      value = _switchResult;
    }
    boolean _equals_1 = Objects.equal(value, null);
    if (_equals_1) {
      Attribute _last = IterableExtensions.<Attribute>last(path);
      String _defaultValueLiteral = _last.getDefaultValueLiteral();
      value = _defaultValueLiteral;
    }
    Attribute _last_1 = IterableExtensions.<Attribute>last(path);
    RefableType _type = _last_1.getType();
    DataType type = _type.getType();
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(value, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _isPrimitive = this._typeHelpers.isPrimitive(type);
      _and = _isPrimitive;
    }
    if (_and) {
      _xifexpression = this.languageExt.toValueLiteral(((PrimitiveType) type), value);
    } else {
      String _xifexpression_1 = null;
      boolean _and_1 = false;
      boolean _notEquals_1 = (!Objects.equal(value, null));
      if (!_notEquals_1) {
        _and_1 = false;
      } else {
        boolean _isEnumeration = this._typeHelpers.isEnumeration(type);
        _and_1 = _isEnumeration;
      }
      if (_and_1) {
        _xifexpression_1 = this.languageExt.toEnumLiteral(((EnumerationType) type), value);
      } else {
        _xifexpression_1 = this.languageExt.defaultValue(type);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
