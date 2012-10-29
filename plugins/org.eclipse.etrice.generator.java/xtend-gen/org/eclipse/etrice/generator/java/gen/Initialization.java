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
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      CharSequence _xifexpression = null;
      RefableType _refType = a.getRefType();
      DataType _type = _refType.getType();
      boolean _isDataClass = this._typeHelpers.isDataClass(_type);
      if (_isDataClass) {
        CharSequence _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          RefableType _refType_1 = a.getRefType();
          DataType _type_1 = _refType_1.getType();
          EList<Attribute> _attributes = ((DataClass) _type_1).getAttributes();
          final Procedure1<Attribute> _function = new Procedure1<Attribute>() {
              public void apply(final Attribute e) {
                List<Attribute> _union = Initialization.this._roomExtensions.<Attribute>union(path, e);
                Initialization.this.attributeInit(roomClass, _union, useClassDefaultsOnly);
              }
            };
          IterableExtensions.<Attribute>forEach(_attributes, _function);
          CharSequence result = _builder;
          CharSequence _xifexpression_1 = null;
          int _length = result.length();
          boolean _greaterThan = (_length > 0);
          if (_greaterThan) {
            _xifexpression_1 = result;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        RefableType _refType_1 = a.getRefType();
        DataType aType = _refType_1.getType();
        _builder.newLineIfNotEmpty();
        String value = this.getInitValueLiteral(a, roomClass);
        _builder.newLineIfNotEmpty();
        {
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            {
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
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                _builder.append(value, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                boolean _startsWith = value.startsWith("{");
                if (_startsWith) {
                  String _name_1 = a.getName();
                  _builder.append(_name_1, "");
                  _builder.append(" = new ");
                  String _typeName = this._typeHelpers.typeName(aType);
                  _builder.append(_typeName, "");
                  _builder.append("[] ");
                  _builder.append(value, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  String _name_2 = a.getName();
                  _builder.append(_name_2, "");
                  _builder.append(" = new ");
                  String _typeName_1 = this._typeHelpers.typeName(aType);
                  _builder.append(_typeName_1, "");
                  _builder.append("[");
                  int _size_1 = a.getSize();
                  _builder.append(_size_1, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  _builder.append("for (int i=0;i<");
                  int _size_2 = a.getSize();
                  _builder.append(_size_2, "");
                  _builder.append(";i++){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _name_3 = a.getName();
                  _builder.append(_name_3, "	");
                  _builder.append("[i] = ");
                  _builder.append(value, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            boolean _or_1 = false;
            boolean _or_2 = false;
            if ((aType instanceof ComplexType)) {
              _or_2 = true;
            } else {
              int _size_3 = a.getSize();
              boolean _greaterThan = (_size_3 > 1);
              _or_2 = ((aType instanceof ComplexType) || _greaterThan);
            }
            if (_or_2) {
              _or_1 = true;
            } else {
              boolean _not = (!useClassDefaultsOnly);
              _or_1 = (_or_2 || _not);
            }
            if (_or_1) {
              {
                int _size_4 = a.getSize();
                boolean _equals_1 = (_size_4 == 0);
                if (_equals_1) {
                  {
                    RefableType _refType_2 = a.getRefType();
                    boolean _isRef = _refType_2.isRef();
                    if (_isRef) {
                      String _name_4 = a.getName();
                      _builder.append(_name_4, "");
                      _builder.append(" = ");
                      String _nullPointer = this.languageExt.nullPointer();
                      _builder.append(_nullPointer, "");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _name_5 = a.getName();
                      _builder.append(_name_5, "");
                      _builder.append(" = ");
                      String _defaultValue = this.languageExt.defaultValue(aType);
                      _builder.append(_defaultValue, "");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  String _name_6 = a.getName();
                  _builder.append(_name_6, "");
                  _builder.append(" = new ");
                  String _typeName_2 = this._typeHelpers.typeName(aType);
                  _builder.append(_typeName_2, "");
                  _builder.append("[");
                  int _size_5 = a.getSize();
                  _builder.append(_size_5, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _not_1 = (!useClassDefaultsOnly);
                    if (_not_1) {
                      _builder.append("for (int i=0;i<");
                      int _size_6 = a.getSize();
                      _builder.append(_size_6, "");
                      _builder.append(";i++){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _name_7 = a.getName();
                      _builder.append(_name_7, "	");
                      _builder.append("[i] = ");
                      {
                        RefableType _refType_3 = a.getRefType();
                        boolean _isRef_1 = _refType_3.isRef();
                        if (_isRef_1) {
                          String _nullPointer_1 = this.languageExt.nullPointer();
                          _builder.append(_nullPointer_1, "	");
                        } else {
                          String _defaultValue_1 = this.languageExt.defaultValue(aType);
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
        }
        _xifexpression = _builder;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String getInitValueLiteral(final Attribute a, final EObject roomClass) {
    String _xblockexpression = null;
    {
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
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(_actorClass, _union);
            _switchResult = _attrClassConfigValue;
          }
        }
        if (!_matched) {
          if (roomClass instanceof PortClass) {
            final PortClass _portClass = (PortClass)roomClass;
            _matched=true;
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(_portClass, _union);
            _switchResult = _attrClassConfigValue;
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
      String _defaultValueLiteral = a.getDefaultValueLiteral();
      _xblockexpression = (_defaultValueLiteral);
    }
    return _xblockexpression;
  }
}
