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
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Initialization {
  @Inject
  private CExtensions languageExt;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
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
        CharSequence _initAttributeArray = this.initAttributeArray(instance, _union);
        _builder.append(_initAttributeArray, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence initAttributeArray(final InstanceBase instance, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("/* ");
      String _name = a.getName();
      _builder.append(_name, "		");
      {
        int _size = a.getSize();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          _builder.append("[");
          int _size_1 = a.getSize();
          _builder.append(_size_1, "		");
          _builder.append("]");
        }
      }
      _builder.append(" */");
      String COMMENT = _builder.toString();
      CharSequence _xifexpression = null;
      boolean _or = false;
      int _size_2 = a.getSize();
      boolean _equals = (_size_2 == 0);
      if (_equals) {
        _or = true;
      } else {
        boolean _and = false;
        RefableType _refType = a.getRefType();
        boolean _isRef = _refType.isRef();
        boolean _not = (!_isRef);
        if (!_not) {
          _and = false;
        } else {
          RefableType _refType_1 = a.getRefType();
          DataType _type = _refType_1.getType();
          boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
          _and = (_not && _isPrimitive);
        }
        _or = (_equals || _and);
      }
      if (_or) {
        String _initAttribute = this.initAttribute(instance, path);
        String _plus = (_initAttribute + COMMENT);
        _xifexpression = _plus;
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
            String _initAttribute_1 = this.initAttribute(instance, path);
            _builder_1.append(_initAttribute_1, "");
          }
        }
        _builder_1.append(" } ");
        _builder_1.append(COMMENT, "");
        _builder_1.newLineIfNotEmpty();
        _xifexpression = _builder_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String initAttribute(final InstanceBase instance, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      RefableType _refType_1 = a.getRefType();
      boolean _isRef = _refType_1.isRef();
      if (_isRef) {
        String _xifexpression = null;
        String _defaultValueLiteral = a.getDefaultValueLiteral();
        boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
        if (_notEquals) {
          String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
          _xifexpression = _defaultValueLiteral_1;
        } else {
          String _nullPointer = this.languageExt.nullPointer();
          _xifexpression = _nullPointer;
        }
        return _xifexpression;
      }
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (aType instanceof DataClass) {
          final DataClass _dataClass = (DataClass)aType;
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{");
          _builder.newLine();
          {
            List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(((DataClass) _dataClass));
            boolean _hasElements = false;
            for(final Attribute subA : _allAttributes) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, subA);
              CharSequence _initAttributeArray = this.initAttributeArray(instance, _union);
              _builder.append(_initAttributeArray, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (aType instanceof ExternalType) {
          final ExternalType _externalType = (ExternalType)aType;
          _matched=true;
          String _xifexpression_1 = null;
          String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
          boolean _notEquals_1 = (!Objects.equal(_defaultValueLiteral_2, null));
          if (_notEquals_1) {
            String _defaultValueLiteral_3 = a.getDefaultValueLiteral();
            _xifexpression_1 = _defaultValueLiteral_3;
          } else {
            String _defaultValue = this.languageExt.defaultValue(_externalType);
            _xifexpression_1 = _defaultValue;
          }
          _switchResult = _xifexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          final PrimitiveType _primitiveType = (PrimitiveType)aType;
          _matched=true;
          String _xblockexpression_1 = null;
          {
            String value = this.getPrimitiveValue(instance, path);
            String _xifexpression_1 = null;
            boolean _and = false;
            boolean _and_1 = false;
            int _size = a.getSize();
            boolean _greaterThan = (_size > 0);
            if (!_greaterThan) {
              _and_1 = false;
            } else {
              boolean _isCharacterType = this._typeHelpers.isCharacterType(_primitiveType);
              boolean _not = (!_isCharacterType);
              _and_1 = (_greaterThan && _not);
            }
            if (!_and_1) {
              _and = false;
            } else {
              String _trim = value.trim();
              boolean _startsWith = _trim.startsWith("{");
              boolean _not_1 = (!_startsWith);
              _and = (_and_1 && _not_1);
            }
            if (_and) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("{ ");
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
              _builder.append(" }");
              _xifexpression_1 = _builder.toString();
            } else {
              _xifexpression_1 = value;
            }
            _xblockexpression_1 = (_xifexpression_1);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      _xblockexpression = (_switchResult);
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
          final ActorInstance _actorInstance = (ActorInstance)instance;
          _matched=true;
          ActorClass _actorClass = _actorInstance.getActorClass();
          String _attrClassConfigValue = this._typeHelpers.getAttrClassConfigValue(path, _actorClass, true);
          _switchResult = _attrClassConfigValue;
        }
      }
      if (!_matched) {
        if (instance instanceof InterfaceItemInstance) {
          final InterfaceItemInstance _interfaceItemInstance = (InterfaceItemInstance)instance;
          _matched=true;
          InterfaceItem _interfaceItem = _interfaceItemInstance.getInterfaceItem();
          PortClass _portClass = RoomHelpers.getPortClass(_interfaceItem);
          String _attrClassConfigValue = this._typeHelpers.getAttrClassConfigValue(path, _portClass);
          _switchResult = _attrClassConfigValue;
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
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      Attribute _last_1 = IterableExtensions.<Attribute>last(path);
      RefableType _refType = _last_1.getRefType();
      DataType _type = _refType.getType();
      String _valueLiteral = this.languageExt.toValueLiteral(((PrimitiveType) _type), value);
      _xifexpression = _valueLiteral;
    } else {
      Attribute _last_2 = IterableExtensions.<Attribute>last(path);
      RefableType _refType_1 = _last_2.getRefType();
      DataType _type_1 = _refType_1.getType();
      String _defaultValue = this.languageExt.defaultValue(_type_1);
      _xifexpression = _defaultValue;
    }
    return _xifexpression;
  }
}
