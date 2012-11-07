package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Initialization {
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ProcedureHelpers procedureHelpers;
  
  public CharSequence attributeInitialization(final List<Attribute> attribs, final EObject roomClass, final boolean useClassDefaultsOnly) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence tmp = _builder;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// initialize attributes");
      _builder_1.newLine();
      {
        for(final Attribute a : attribs) {
          ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
          List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
          CharSequence _dataConfigurationInit = this.dataConfigurationInit(roomClass, _union);
          CharSequence _tmp = tmp = _dataConfigurationInit;
          _builder_1.append(_tmp, "");
          _builder_1.newLineIfNotEmpty();
          {
            int _length = tmp.length();
            boolean _equals = (_length == 0);
            if (_equals) {
              ArrayList<Attribute> _arrayList_1 = new ArrayList<Attribute>();
              List<Attribute> _union_1 = this._roomExtensions.<Attribute>union(_arrayList_1, a);
              String _roomDefaulValue = this.getRoomDefaulValue(a);
              CharSequence _valueInit = this.valueInit(_union_1, _roomDefaulValue);
              CharSequence _tmp_1 = tmp = _valueInit;
              _builder_1.append(_tmp_1, "");
            }
          }
          _builder_1.newLineIfNotEmpty();
          {
            int _length_1 = tmp.length();
            boolean _equals_1 = (_length_1 == 0);
            if (_equals_1) {
              CharSequence _defaultInit = this.defaultInit(a, useClassDefaultsOnly);
              _builder_1.append(_defaultInit, "");
            }
          }
          _builder_1.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder_1);
    }
    return _xblockexpression;
  }
  
  private CharSequence dataConfigurationInit(final EObject roomClass, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      boolean _isDataClass = this._typeHelpers.isDataClass(aType);
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          EList<Attribute> _attributes = ((DataClass) aType).getAttributes();
          for(final Attribute e : _attributes) {
            List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
            CharSequence _dataConfigurationInit = this.dataConfigurationInit(roomClass, _union);
            _builder.append(_dataConfigurationInit, "");
            _builder.newLineIfNotEmpty();
          }
        }
        return _builder;
      } else {
        boolean _isPrimitive = this._typeHelpers.isPrimitive(aType);
        if (_isPrimitive) {
          String _dataConfigValue = this.getDataConfigValue(roomClass, path);
          return this.valueInit(path, _dataConfigValue);
        }
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _xblockexpression = (_builder_1);
    }
    return _xblockexpression;
  }
  
  private CharSequence valueInit(final List<Attribute> path, final String value) {
    CharSequence _xblockexpression = null;
    {
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      }
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      String _xifexpression = null;
      int _size = path.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        int _size_1 = path.size();
        int _minus = (_size_1 - 1);
        Iterable<Attribute> _take = IterableExtensions.<Attribute>take(path, _minus);
        CharSequence _invokeGetters = this.procedureHelpers.invokeGetters(_take, null);
        String _plus = (_invokeGetters + ".");
        _xifexpression = _plus;
      } else {
        _xifexpression = "";
      }
      String getter = _xifexpression;
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _or = false;
        int _size_2 = a.getSize();
        boolean _equals_1 = (_size_2 == 0);
        if (_equals_1) {
          _or = true;
        } else {
          boolean _isCharacterType = this._typeHelpers.isCharacterType(aType);
          _or = (_equals_1 || _isCharacterType);
        }
        if (_or) {
          _builder_1.append(getter, "");
          String _name = a.getName();
          CharSequence _invokeSetter = this.procedureHelpers.invokeSetter(_name, null, value);
          _builder_1.append(_invokeSetter, "");
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
        } else {
          boolean _startsWith = value.startsWith("{");
          if (_startsWith) {
            _builder_1.append(getter, "");
            String _name_1 = a.getName();
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("new ");
            String _typeName = this._typeHelpers.typeName(aType);
            _builder_2.append(_typeName, "");
            _builder_2.append("[] ");
            _builder_2.append(value, "");
            CharSequence _invokeSetter_1 = this.procedureHelpers.invokeSetter(_name_1, null, _builder_2.toString());
            _builder_1.append(_invokeSetter_1, "");
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
          } else {
            _builder_1.append("{");
            _builder_1.newLine();
            _builder_1.append("\t");
            String _typeName_1 = this._typeHelpers.typeName(aType);
            _builder_1.append(_typeName_1, "	");
            _builder_1.append("[] _");
            String _name_2 = a.getName();
            _builder_1.append(_name_2, "	");
            _builder_1.append(" = new ");
            String _typeName_2 = this._typeHelpers.typeName(aType);
            _builder_1.append(_typeName_2, "	");
            _builder_1.append("[");
            int _size_3 = a.getSize();
            _builder_1.append(_size_3, "	");
            _builder_1.append("];");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("for (int i=0;i<");
            int _size_4 = a.getSize();
            _builder_1.append(_size_4, "	");
            _builder_1.append(";i++){");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t");
            _builder_1.append("_");
            String _name_3 = a.getName();
            _builder_1.append(_name_3, "		");
            _builder_1.append("[i] = ");
            _builder_1.append(value, "		");
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("}");
            _builder_1.newLine();
            _builder_1.append("\t");
            _builder_1.append(getter, "	");
            String _name_4 = a.getName();
            String _name_5 = a.getName();
            String _plus_1 = ("_" + _name_5);
            CharSequence _invokeSetter_2 = this.procedureHelpers.invokeSetter(_name_4, null, _plus_1);
            _builder_1.append(_invokeSetter_2, "	");
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("}");
            _builder_1.newLine();
          }
        }
      }
      _xblockexpression = (_builder_1);
    }
    return _xblockexpression;
  }
  
  private CharSequence defaultInit(final Attribute a, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _or_1 = false;
      RefableType _refType = a.getRefType();
      DataType _type = _refType.getType();
      if ((_type instanceof ComplexType)) {
        _or_1 = true;
      } else {
        int _size = a.getSize();
        boolean _greaterThan = (_size > 1);
        _or_1 = ((_type instanceof ComplexType) || _greaterThan);
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _not = (!useClassDefaultsOnly);
        _or = (_or_1 || _not);
      }
      if (_or) {
        {
          int _size_1 = a.getSize();
          boolean _equals = (_size_1 == 0);
          if (_equals) {
            {
              RefableType _refType_1 = a.getRefType();
              boolean _isRef = _refType_1.isRef();
              if (_isRef) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                String _nullPointer = this.languageExt.nullPointer();
                _builder.append(_nullPointer, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                String _name_1 = a.getName();
                _builder.append(_name_1, "");
                _builder.append(" = ");
                RefableType _refType_2 = a.getRefType();
                DataType _type_1 = _refType_2.getType();
                String _defaultValue = this.languageExt.defaultValue(_type_1);
                _builder.append(_defaultValue, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            String _name_2 = a.getName();
            _builder.append(_name_2, "");
            _builder.append(" = new ");
            RefableType _refType_3 = a.getRefType();
            DataType _type_2 = _refType_3.getType();
            String _typeName = this._typeHelpers.typeName(_type_2);
            _builder.append(_typeName, "");
            _builder.append("[");
            int _size_2 = a.getSize();
            _builder.append(_size_2, "");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            {
              boolean _not_1 = (!useClassDefaultsOnly);
              if (_not_1) {
                _builder.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder.append(_size_3, "");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _name_3 = a.getName();
                _builder.append(_name_3, "	");
                _builder.append("[i] = ");
                {
                  RefableType _refType_4 = a.getRefType();
                  boolean _isRef_1 = _refType_4.isRef();
                  if (_isRef_1) {
                    String _nullPointer_1 = this.languageExt.nullPointer();
                    _builder.append(_nullPointer_1, "	");
                  } else {
                    RefableType _refType_5 = a.getRefType();
                    DataType _type_3 = _refType_5.getType();
                    String _defaultValue_1 = this.languageExt.defaultValue(_type_3);
                    _builder.append(_defaultValue_1, "	");
                  }
                }
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  private String getRoomDefaulValue(final Attribute a) {
    String _defaultValueLiteral = a.getDefaultValueLiteral();
    return _defaultValueLiteral;
  }
  
  private String getDataConfigValue(final EObject roomClass, final List<Attribute> path) {
    Attribute a = IterableExtensions.<Attribute>last(path);
    RefableType _refType = a.getRefType();
    DataType _type = _refType.getType();
    boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
    if (_isPrimitive) {
      RefableType _refType_1 = a.getRefType();
      DataType _type_1 = _refType_1.getType();
      PrimitiveType aType = ((PrimitiveType) _type_1);
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (roomClass instanceof ActorClass) {
          final ActorClass _actorClass = (ActorClass)roomClass;
          _matched=true;
          String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(_actorClass, path);
          _switchResult = _attrClassConfigValue;
        }
      }
      if (!_matched) {
        if (roomClass instanceof PortClass) {
          final PortClass _portClass = (PortClass)roomClass;
          _matched=true;
          String _xifexpression = null;
          EObject _eContainer = _portClass.eContainer();
          if ((_eContainer instanceof ProtocolClass)) {
            String _xblockexpression = null;
            {
              EObject _eContainer_1 = _portClass.eContainer();
              ProtocolClass pc = ((ProtocolClass) _eContainer_1);
              PortClass _regular = pc.getRegular();
              boolean _equals = _regular.equals(_portClass);
              String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(pc, _equals, path);
              _xblockexpression = (_attrClassConfigValue);
            }
            _xifexpression = _xblockexpression;
          }
          _switchResult = _xifexpression;
        }
      }
      String result = _switchResult;
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(result, null));
      if (_notEquals) {
        String _xifexpression_1 = null;
        boolean _and = false;
        int _size = a.getSize();
        boolean _greaterThan = (_size > 0);
        if (!_greaterThan) {
          _and = false;
        } else {
          boolean _isCharacterType = this._typeHelpers.isCharacterType(aType);
          boolean _not = (!_isCharacterType);
          _and = (_greaterThan && _not);
        }
        if (_and) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{ ");
          {
            String[] _split = result.split(",");
            boolean _hasElements = false;
            for(final String e : _split) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(", ", "");
              }
              String _valueLiteral = this.languageExt.toValueLiteral(aType, e);
              _builder.append(_valueLiteral, "");
            }
          }
          _builder.append("}");
          _xifexpression_1 = _builder.toString();
        } else {
          String _valueLiteral_1 = this.languageExt.toValueLiteral(aType, result);
          _xifexpression_1 = _valueLiteral_1;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    }
    return null;
  }
}
