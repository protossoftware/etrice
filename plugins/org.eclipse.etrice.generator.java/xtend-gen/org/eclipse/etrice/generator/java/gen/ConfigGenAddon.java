package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ConfigGenAddon {
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private ConfigExtension configExt;
  
  public CharSequence applyInstanceConfig(final String instance, final String className, final List<AttrInstanceConfig> attrConfigs) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final AttrInstanceConfig attrConfig : attrConfigs) {
        Attribute a = attrConfig.getAttribute();
        _builder.newLineIfNotEmpty();
        RefableType _refType = a.getRefType();
        DataType aType = _refType.getType();
        _builder.newLineIfNotEmpty();
        {
          boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
          if (_isPrimitive) {
            LiteralArray _value = attrConfig.getValue();
            String[] values = _value==null?(String[])null:this.configExt.getValues(_value);
            _builder.newLineIfNotEmpty();
            {
              boolean _equals = Objects.equal(values, null);
              if (_equals) {
              } else {
                boolean _or = false;
                int _size = a.getSize();
                boolean _equals_1 = (_size == 0);
                if (_equals_1) {
                  _or = true;
                } else {
                  boolean _isCharacterType = this.typeHelpers.isCharacterType(aType);
                  _or = (_equals_1 || _isCharacterType);
                }
                if (_or) {
                  _builder.append(instance, "");
                  _builder.append(".");
                  String _name = a.getName();
                  final String[] _converted_values = (String[])values;
                  String _get = ((List<String>)Conversions.doWrapArray(_converted_values)).get(0);
                  String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), _get);
                  CharSequence _invokeSetter = this.helpers.invokeSetter(_name, className, _valueLiteral);
                  _builder.append(_invokeSetter, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  int _size_1 = a.getSize();
                  final String[] _converted_values_1 = (String[])values;
                  int _size_2 = ((List<String>)Conversions.doWrapArray(_converted_values_1)).size();
                  boolean _equals_2 = (_size_1 == _size_2);
                  if (_equals_2) {
                    _builder.append(instance, "");
                    _builder.append(".");
                    String _name_1 = a.getName();
                    String _typeName = this.typeHelpers.typeName(aType);
                    String _plus = ("new " + _typeName);
                    String _plus_1 = (_plus + "[]");
                    String _arrayValueLiteral = this.configExt.toArrayValueLiteral(((PrimitiveType) aType), values);
                    String _plus_2 = (_plus_1 + _arrayValueLiteral);
                    CharSequence _invokeSetter_1 = this.helpers.invokeSetter(_name_1, className, _plus_2);
                    _builder.append(_invokeSetter_1, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("\t");
                    String _typeName_1 = this.typeHelpers.typeName(aType);
                    _builder.append(_typeName_1, "	");
                    _builder.append("[] array = ");
                    _builder.append(instance, "	");
                    _builder.append(".");
                    String _name_2 = a.getName();
                    CharSequence _invokeGetter = this.helpers.invokeGetter(_name_2, className);
                    _builder.append(_invokeGetter, "	");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("for (int i=0;i<");
                    int _size_3 = a.getSize();
                    _builder.append(_size_3, "	");
                    _builder.append(";i++){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("array[i] = ");
                    final String[] _converted_values_2 = (String[])values;
                    String _get_1 = ((List<String>)Conversions.doWrapArray(_converted_values_2)).get(0);
                    String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), _get_1);
                    _builder.append(_valueLiteral_1, "		");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          } else {
            boolean _isDataClass = this.typeHelpers.isDataClass(aType);
            if (_isDataClass) {
              String _plus_3 = (instance + ".");
              String _name_3 = a.getName();
              CharSequence _invokeGetter_1 = this.helpers.invokeGetter(_name_3, className);
              String _plus_4 = (_plus_3 + _invokeGetter_1);
              String _typeName_2 = this.typeHelpers.typeName(aType);
              EList<AttrInstanceConfig> _attributes = attrConfig.getAttributes();
              CharSequence _applyInstanceConfig = this.applyInstanceConfig(_plus_4, _typeName_2, _attributes);
              _builder.append(_applyInstanceConfig, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence genDynConfigGetterSetter(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      HashSet<Attribute> _dynConfigAttributes = this.configExt.getDynConfigAttributes(ac, true, false);
      for(final Attribute a : _dynConfigAttributes) {
        _builder.append("public ");
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this.typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" get");
        String _name = a.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder.append(_firstUpper, "");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name_1 = a.getName();
        _builder.append(_name_1, "	");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_2 = a.getName();
        _builder.append(_name_2, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_3 = a.getName();
        _builder.append(_name_3, "		");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        String _name_4 = a.getName();
        _builder.append(_name_4, "			");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public void set");
        String _name_5 = a.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_1, "");
        _builder.append("(");
        RefableType _refType_1 = a.getRefType();
        DataType _type_1 = _refType_1.getType();
        String _typeName_1 = this.typeHelpers.typeName(_type_1);
        _builder.append(_typeName_1, "");
        {
          int _size_1 = a.getSize();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_6 = a.getName();
        _builder.append(_name_6, "");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name_7 = a.getName();
        _builder.append(_name_7, "	");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_8 = a.getName();
        _builder.append(_name_8, "		");
        _builder.append(" = ");
        String _name_9 = a.getName();
        _builder.append(_name_9, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_10 = a.getName();
        _builder.append(_name_10, "		");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("this.");
        String _name_11 = a.getName();
        _builder.append(_name_11, "			");
        _builder.append(" = ");
        String _name_12 = a.getName();
        _builder.append(_name_12, "			");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public DynConfigLock get");
        String _name_13 = a.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_13);
        _builder.append(_firstUpper_2, "");
        _builder.append("Lock(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return lock_");
        String _name_14 = a.getName();
        _builder.append(_name_14, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    {
      HashSet<Attribute> _dynConfigAttributes_1 = this.configExt.getDynConfigAttributes(ac, false, true);
      for(final Attribute a_1 : _dynConfigAttributes_1) {
        _builder.append("public void setAndWrite");
        String _name_15 = a_1.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_15);
        _builder.append(_firstUpper_3, "");
        _builder.append("(");
        RefableType _refType_2 = a_1.getRefType();
        DataType _type_2 = _refType_2.getType();
        String _typeName_2 = this.typeHelpers.typeName(_type_2);
        _builder.append(_typeName_2, "");
        {
          int _size_2 = a_1.getSize();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_16 = a_1.getName();
        _builder.append(_name_16, "");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("set");
        String _name_17 = a_1.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_17);
        _builder.append(_firstUpper_4, "		");
        _builder.append("(");
        String _name_18 = a_1.getName();
        _builder.append(_name_18, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("variableService.write(this.getInstancePath()+\"/");
        String _name_19 = a_1.getName();
        _builder.append(_name_19, "		");
        _builder.append("\", ");
        String _name_20 = a_1.getName();
        _builder.append(_name_20, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence genMinMaxConstants(final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      List<AttrClassConfig> _allAttrConfigFlat = this.configExt.getAllAttrConfigFlat(ac);
      final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
          public Boolean apply(final AttrClassConfig c) {
            boolean _or = false;
            NumberLiteral _min = c.getMin();
            boolean _notEquals = (!Objects.equal(_min, null));
            if (_notEquals) {
              _or = true;
            } else {
              NumberLiteral _max = c.getMax();
              boolean _notEquals_1 = (!Objects.equal(_max, null));
              _or = (_notEquals || _notEquals_1);
            }
            return Boolean.valueOf(_or);
          }
        };
      Iterable<AttrClassConfig> attrConfigs = IterableExtensions.<AttrClassConfig>filter(_allAttrConfigFlat, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = IterableExtensions.isEmpty(attrConfigs);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("//--------------------- attribute specifications");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      {
        for(final AttrClassConfig c : attrConfigs) {
          Attribute _attribute = c.getAttribute();
          RefableType _refType = _attribute.getRefType();
          DataType _type = _refType.getType();
          PrimitiveType aType = ((PrimitiveType) _type);
          _builder.newLineIfNotEmpty();
          {
            NumberLiteral _min = c.getMin();
            boolean _notEquals = (!Objects.equal(_min, null));
            if (_notEquals) {
              _builder.append("public static ");
              String _minMaxType = this.getMinMaxType(aType);
              _builder.append(_minMaxType, "");
              _builder.append(" MIN");
              List<String> _path = this.configExt.getPath(c, false, false, true, true);
              String _path_1 = this.configExt.toPath(_path, "_");
              _builder.append(_path_1, "");
              _builder.append(" = ");
              NumberLiteral _min_1 = c.getMin();
              String _value = this.configExt.getValue(_min_1);
              String _valueLiteral = this.stdExt.toValueLiteral(aType, _value);
              _builder.append(_valueLiteral, "");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            NumberLiteral _max = c.getMax();
            boolean _notEquals_1 = (!Objects.equal(_max, null));
            if (_notEquals_1) {
              _builder.append("public static ");
              String _minMaxType_1 = this.getMinMaxType(aType);
              _builder.append(_minMaxType_1, "");
              _builder.append(" MAX");
              List<String> _path_2 = this.configExt.getPath(c, false, false, true, true);
              String _path_3 = this.configExt.toPath(_path_2, "_");
              _builder.append(_path_3, "");
              _builder.append(" = ");
              NumberLiteral _max_1 = c.getMax();
              String _value_1 = this.configExt.getValue(_max_1);
              String _valueLiteral_1 = this.stdExt.toValueLiteral(aType, _value_1);
              _builder.append(_valueLiteral_1, "");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getMinMaxType(final PrimitiveType type) {
    String _typeName = this.typeHelpers.typeName(type);
    final String _switchValue = _typeName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        return "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        return "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        return "double";
      }
    }
    return this.typeHelpers.typeName(type);
  }
}
