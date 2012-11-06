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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _attributeInit = this.attributeInit(roomClass, _union, useClassDefaultsOnly);
        _builder.append(_attributeInit, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence attributeInit(final EObject roomClass, final List<Attribute> path, final boolean useClassDefaultsOnly) {
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
          CharSequence _attributeInit = this.attributeInit(roomClass, _union, useClassDefaultsOnly);
          _builder.append(_attributeInit, "");
          _builder.newLineIfNotEmpty();
        }
      }
      CharSequence result = _builder;
      int _length = result.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        return result;
      }
    }
    String value = this.getInitValueLiteral(roomClass, path);
    String _xifexpression = null;
    int _size = path.size();
    boolean _greaterThan_1 = (_size > 1);
    if (_greaterThan_1) {
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
      boolean _notEquals = (!Objects.equal(value, null));
      if (_notEquals) {
        {
          boolean _or = false;
          int _size_2 = a.getSize();
          boolean _equals = (_size_2 == 0);
          if (_equals) {
            _or = true;
          } else {
            boolean _isCharacterType = this._typeHelpers.isCharacterType(aType);
            _or = (_equals || _isCharacterType);
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
      } else {
        boolean _and = false;
        int _size_5 = path.size();
        boolean _equals_1 = (_size_5 == 1);
        if (!_equals_1) {
          _and = false;
        } else {
          boolean _or_1 = false;
          boolean _or_2 = false;
          if ((aType instanceof ComplexType)) {
            _or_2 = true;
          } else {
            int _size_6 = a.getSize();
            boolean _greaterThan_2 = (_size_6 > 1);
            _or_2 = ((aType instanceof ComplexType) || _greaterThan_2);
          }
          if (_or_2) {
            _or_1 = true;
          } else {
            boolean _not = (!useClassDefaultsOnly);
            _or_1 = (_or_2 || _not);
          }
          _and = (_equals_1 && _or_1);
        }
        if (_and) {
          {
            int _size_7 = a.getSize();
            boolean _equals_2 = (_size_7 == 0);
            if (_equals_2) {
              {
                RefableType _refType_1 = a.getRefType();
                boolean _isRef = _refType_1.isRef();
                if (_isRef) {
                  String _name_6 = a.getName();
                  _builder_1.append(_name_6, "");
                  _builder_1.append(" = ");
                  String _nullPointer = this.languageExt.nullPointer();
                  _builder_1.append(_nullPointer, "");
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                } else {
                  String _name_7 = a.getName();
                  _builder_1.append(_name_7, "");
                  _builder_1.append(" = ");
                  String _defaultValue = this.languageExt.defaultValue(aType);
                  _builder_1.append(_defaultValue, "");
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                }
              }
            } else {
              String _name_8 = a.getName();
              _builder_1.append(_name_8, "");
              _builder_1.append(" = new ");
              String _typeName_3 = this._typeHelpers.typeName(aType);
              _builder_1.append(_typeName_3, "");
              _builder_1.append("[");
              int _size_8 = a.getSize();
              _builder_1.append(_size_8, "");
              _builder_1.append("];");
              _builder_1.newLineIfNotEmpty();
              {
                boolean _not_1 = (!useClassDefaultsOnly);
                if (_not_1) {
                  _builder_1.append("for (int i=0;i<");
                  int _size_9 = a.getSize();
                  _builder_1.append(_size_9, "");
                  _builder_1.append(";i++){");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  String _name_9 = a.getName();
                  _builder_1.append(_name_9, "	");
                  _builder_1.append("[i] = ");
                  {
                    RefableType _refType_2 = a.getRefType();
                    boolean _isRef_1 = _refType_2.isRef();
                    if (_isRef_1) {
                      String _nullPointer_1 = this.languageExt.nullPointer();
                      _builder_1.append(_nullPointer_1, "	");
                    } else {
                      String _defaultValue_1 = this.languageExt.defaultValue(aType);
                      _builder_1.append(_defaultValue_1, "	");
                    }
                  }
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("}");
                  _builder_1.newLine();
                }
              }
            }
          }
        }
      }
    }
    return _builder_1;
  }
  
  private String getInitValueLiteral(final EObject roomClass, final List<Attribute> path) {
    String _xblockexpression = null;
    {
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
              String _xblockexpression_1 = null;
              {
                EObject _eContainer_1 = _portClass.eContainer();
                ProtocolClass pc = ((ProtocolClass) _eContainer_1);
                PortClass _regular = pc.getRegular();
                boolean _equals = _regular.equals(_portClass);
                String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(pc, _equals, path);
                _xblockexpression_1 = (_attrClassConfigValue);
              }
              _xifexpression = _xblockexpression_1;
            }
            _switchResult = _xifexpression;
          }
        }
        String result = _switchResult;
        boolean _notEquals = (!Objects.equal(result, null));
        if (_notEquals) {
          String _xifexpression = null;
          boolean _or = false;
          int _size = a.getSize();
          boolean _equals = (_size == 0);
          if (_equals) {
            _or = true;
          } else {
            boolean _isCharacterType = this._typeHelpers.isCharacterType(aType);
            _or = (_equals || _isCharacterType);
          }
          if (_or) {
            String _valueLiteral = this.languageExt.toValueLiteral(aType, result);
            _xifexpression = _valueLiteral;
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("{ ");
            {
              String[] _split = result.split(",");
              boolean _hasElements = false;
              for(final String s : _split) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(" ,", "");
                }
                String _trim = s.trim();
                String _valueLiteral_1 = this.languageExt.toValueLiteral(aType, _trim);
                _builder.append(_valueLiteral_1, "");
              }
            }
            _builder.append(" }");
            String _string = _builder.toString();
            _xifexpression = _string;
          }
          return _xifexpression;
        }
      }
      String _xifexpression_1 = null;
      int _size_1 = path.size();
      boolean _equals_1 = (_size_1 == 1);
      if (_equals_1) {
        String _defaultValueLiteral = a.getDefaultValueLiteral();
        _xifexpression_1 = _defaultValueLiteral;
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
}
