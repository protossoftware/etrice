package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class Initialization {
  @Inject
  private ConfigExtension _configExtension;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILanguageExtension languageExt;
  
  public CharSequence attributeInitialization(final List<Attribute> attribs, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        RefableType _refType = a.getRefType();
        DataType aType = _refType.getType();
        _builder.newLineIfNotEmpty();
        String value = this._configExtension.getInitValueLiteral(a);
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
                    RefableType _refType_1 = a.getRefType();
                    boolean _isRef = _refType_1.isRef();
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
                        RefableType _refType_2 = a.getRefType();
                        boolean _isRef_1 = _refType_2.isRef();
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
      }
    }
    return _builder;
  }
}
