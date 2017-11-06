/**
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ConfigGenAddon {
  @Inject
  @Extension
  private CppExtensions stdExt;
  
  @Inject
  @Extension
  private TypeHelpers typeHelpers;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(ai.getActorClass());
      for(final Attribute a : _allAttributes) {
        String _applyInstanceConfig = this.applyInstanceConfig(ai, aiVariableName, this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a));
        _builder.append(_applyInstanceConfig);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
        PortClass _portClass = this._roomHelpers.getPortClass(pi.getInterfaceItem());
        EList<Attribute> _attributes = null;
        if (_portClass!=null) {
          _attributes=_portClass.getAttributes();
        }
        EList<Attribute> attribs = _attributes;
        _builder.newLineIfNotEmpty();
        {
          boolean _notEquals = (!Objects.equal(attribs, null));
          if (_notEquals) {
            {
              for(final Attribute a_1 : attribs) {
                CharSequence _invokeGetter = this.helpers.invokeGetter(pi.getName(), null);
                String _plus = ((aiVariableName + ".") + _invokeGetter);
                String _applyInstanceConfig_1 = this.applyInstanceConfig(pi, _plus, this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a_1));
                _builder.append(_applyInstanceConfig_1);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  private String applyInstanceConfig(final InstanceBase instance, final String invokes, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      DataType aType = a.getType().getType();
      String _xifexpression = null;
      boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
      if (_isPrimitive) {
        String _xblockexpression_1 = null;
        {
          String value = this.typeHelpers.getAttrInstanceConfigValue(path, instance);
          String _xifexpression_1 = null;
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            StringConcatenation _builder = new StringConcatenation();
            _xifexpression_1 = _builder.toString();
          } else {
            String _xifexpression_2 = null;
            if (((a.getSize() == 0) || this.typeHelpers.isCharacterType(aType))) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(invokes);
              _builder_1.append(".");
              CharSequence _invokeSetter = this.helpers.invokeSetter(a.getName(), null, this.stdExt.toValueLiteral(((PrimitiveType) aType), value));
              _builder_1.append(_invokeSetter);
              _builder_1.append(";");
              _xifexpression_2 = _builder_1.toString();
            } else {
              String _xifexpression_3 = null;
              int _size = a.getSize();
              int _size_1 = ((List<String>)Conversions.doWrapArray(value.split(","))).size();
              boolean _equals_1 = (_size == _size_1);
              if (_equals_1) {
                String _xblockexpression_2 = null;
                {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("{ ");
                  {
                    String[] _split = value.split(",");
                    boolean _hasElements = false;
                    for(final String s : _split) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder_2.appendImmediate(", ", "");
                      }
                      String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), s.trim());
                      _builder_2.append(_valueLiteral);
                    }
                  }
                  _builder_2.append(" }");
                  String arrayExpr = _builder_2.toString();
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append(invokes);
                  _builder_3.append(".");
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("new ");
                  String _typeName = this.typeHelpers.typeName(aType);
                  _builder_4.append(_typeName);
                  _builder_4.append("[] ");
                  _builder_4.append(arrayExpr);
                  CharSequence _invokeSetter_1 = this.helpers.invokeSetter(a.getName(), null, _builder_4.toString());
                  _builder_3.append(_invokeSetter_1);
                  _builder_3.append(";");
                  _xblockexpression_2 = _builder_3.toString();
                }
                _xifexpression_3 = _xblockexpression_2;
              } else {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("{");
                _builder_2.newLine();
                _builder_2.append("\t");
                String _typeName = this.typeHelpers.typeName(aType);
                _builder_2.append(_typeName, "\t");
                _builder_2.append("[] array = ");
                _builder_2.append(invokes, "\t");
                _builder_2.append(".");
                CharSequence _invokeGetter = this.helpers.invokeGetter(a.getName(), null);
                _builder_2.append(_invokeGetter, "\t");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t");
                _builder_2.append("for (int i=0;i<");
                int _size_2 = a.getSize();
                _builder_2.append(_size_2, "\t");
                _builder_2.append(";i++){");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t");
                _builder_2.append("array[i] = ");
                String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
                _builder_2.append(_valueLiteral, "\t\t");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("}");
                _xifexpression_3 = _builder_2.toString();
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _xifexpression_1 = null;
        boolean _isDataClass = this.typeHelpers.isDataClass(aType);
        if (_isDataClass) {
          StringConcatenation _builder = new StringConcatenation();
          {
            EList<Attribute> _attributes = ((DataClass) aType).getAttributes();
            for(final Attribute e : _attributes) {
              CharSequence _invokeGetter = this.helpers.invokeGetter(a.getName(), null);
              String _plus = ((invokes + ".") + _invokeGetter);
              String _applyInstanceConfig = this.applyInstanceConfig(instance, _plus, this._roomExtensions.<Attribute>union(path, e));
              _builder.append(_applyInstanceConfig);
              _builder.newLineIfNotEmpty();
            }
          }
          _xifexpression_1 = _builder.toString();
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence genDynConfigGetterSetter(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
      for(final Attribute a : _dynConfigReadAttributes) {
        _builder.append("public ");
        String _typeName = this.typeHelpers.typeName(a.getType().getType());
        _builder.append(_typeName);
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" get");
        String _firstUpper = StringExtensions.toFirstUpper(a.getName());
        _builder.append(_firstUpper);
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name = a.getName();
        _builder.append(_name, "\t");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_1 = a.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_2 = a.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        String _name_3 = a.getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(a.getName());
        _builder.append(_firstUpper_1);
        _builder.append("(");
        String _typeName_1 = this.typeHelpers.typeName(a.getType().getType());
        _builder.append(_typeName_1);
        {
          int _size_1 = a.getSize();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_4 = a.getName();
        _builder.append(_name_4);
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name_5 = a.getName();
        _builder.append(_name_5, "\t");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_6 = a.getName();
        _builder.append(_name_6, "\t\t");
        _builder.append(" = ");
        String _name_7 = a.getName();
        _builder.append(_name_7, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_8 = a.getName();
        _builder.append(_name_8, "\t\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("this.");
        String _name_9 = a.getName();
        _builder.append(_name_9, "\t\t\t");
        _builder.append(" = ");
        String _name_10 = a.getName();
        _builder.append(_name_10, "\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public DynConfigLock get");
        String _firstUpper_2 = StringExtensions.toFirstUpper(a.getName());
        _builder.append(_firstUpper_2);
        _builder.append("Lock(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return lock_");
        String _name_11 = a.getName();
        _builder.append(_name_11, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    {
      List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
      for(final Attribute a_1 : _dynConfigWriteAttributes) {
        _builder.append("public void setAndWrite");
        String _firstUpper_3 = StringExtensions.toFirstUpper(a_1.getName());
        _builder.append(_firstUpper_3);
        _builder.append("(");
        String _typeName_2 = this.typeHelpers.typeName(a_1.getType().getType());
        _builder.append(_typeName_2);
        {
          int _size_2 = a_1.getSize();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_12 = a_1.getName();
        _builder.append(_name_12);
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("set");
        String _firstUpper_4 = StringExtensions.toFirstUpper(a_1.getName());
        _builder.append(_firstUpper_4, "\t\t");
        _builder.append("(");
        String _name_13 = a_1.getName();
        _builder.append(_name_13, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("variableService.write(this.getInstancePath()+\"/");
        String _name_14 = a_1.getName();
        _builder.append(_name_14, "\t\t");
        _builder.append("\", ");
        String _name_15 = a_1.getName();
        _builder.append(_name_15, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public String genMinMaxConstants(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Attribute> _attributes = ac.getAttributes();
      for(final Attribute a : _attributes) {
        String _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, a.getName(), this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a));
        _builder.append(_genMinMaxConstantsRec);
        _builder.newLineIfNotEmpty();
      }
    }
    String result = _builder.toString();
    int _length = result.length();
    boolean _notEquals = (_length != 0);
    if (_notEquals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("//--------------------- Attribute Specifications");
      String _plus = (result + _builder_1);
      result = _plus;
    }
    return result;
  }
  
  private String genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      String temp = ((String) null);
      String _xifexpression = null;
      boolean _isDataClass = this.typeHelpers.isDataClass(IterableExtensions.<Attribute>last(path).getType().getType());
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          DataType _type = IterableExtensions.<Attribute>last(path).getType().getType();
          List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass) _type));
          for(final Attribute e : _allAttributes) {
            String _name = e.getName();
            String _plus = ((varNamePath + "_") + _name);
            String _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus, this._roomExtensions.<Attribute>union(path, e));
            _builder.append(_genMinMaxConstantsRec);
            _builder.newLineIfNotEmpty();
          }
        }
        _xifexpression = _builder.toString();
      } else {
        String _xifexpression_1 = null;
        DataType _type_1 = IterableExtensions.<Attribute>last(path).getType().getType();
        if ((_type_1 instanceof ExternalType)) {
          _xifexpression_1 = null;
        } else {
          String _xifexpression_2 = null;
          DataType _type_2 = IterableExtensions.<Attribute>last(path).getType().getType();
          if ((_type_2 instanceof EnumerationType)) {
            _xifexpression_2 = null;
          } else {
            String _xblockexpression_1 = null;
            {
              DataType _type_3 = IterableExtensions.<Attribute>last(path).getType().getType();
              PrimitiveType aType = ((PrimitiveType) _type_3);
              StringConcatenation _builder_1 = new StringConcatenation();
              {
                boolean _notEquals = (!Objects.equal((temp = this.dataConfigExt.getAttrClassConfigMinValue(ac, path)), null));
                if (_notEquals) {
                  _builder_1.append("public static ");
                  String _minMaxType = this.getMinMaxType(aType);
                  _builder_1.append(_minMaxType);
                  _builder_1.append(" MIN_");
                  _builder_1.append(varNamePath);
                  _builder_1.append(" = ");
                  String _valueLiteral = this.stdExt.toValueLiteral(aType, temp);
                  _builder_1.append(_valueLiteral);
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                }
              }
              {
                boolean _notEquals_1 = (!Objects.equal((temp = this.dataConfigExt.getAttrClassConfigMaxValue(ac, path)), null));
                if (_notEquals_1) {
                  _builder_1.append("public static ");
                  String _minMaxType_1 = this.getMinMaxType(aType);
                  _builder_1.append(_minMaxType_1);
                  _builder_1.append(" MAX_");
                  _builder_1.append(varNamePath);
                  _builder_1.append(" = ");
                  String _valueLiteral_1 = this.stdExt.toValueLiteral(aType, temp);
                  _builder_1.append(_valueLiteral_1);
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                }
              }
              _xblockexpression_1 = _builder_1.toString();
            }
            _xifexpression_2 = _xblockexpression_1;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private String getMinMaxType(final PrimitiveType type) {
    String _switchResult = null;
    String _typeName = this.typeHelpers.typeName(type);
    if (_typeName != null) {
      switch (_typeName) {
        case "byte":
          _switchResult = "int";
          break;
        case "short":
          _switchResult = "int";
          break;
        case "float":
          _switchResult = "double";
          break;
        default:
          _switchResult = this.typeHelpers.typeName(type);
          break;
      }
    } else {
      _switchResult = this.typeHelpers.typeName(type);
    }
    return _switchResult;
  }
}
