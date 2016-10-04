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
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
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
      ActorClass _actorClass = ai.getActorClass();
      List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(_actorClass);
      for(final Attribute a : _allAttributes) {
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        String _applyInstanceConfig = this.applyInstanceConfig(ai, aiVariableName, _union);
        _builder.append(_applyInstanceConfig, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
        InterfaceItem _interfaceItem = pi.getInterfaceItem();
        PortClass _portClass = this._roomHelpers.getPortClass(_interfaceItem);
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
                String _name = pi.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
                String _plus = ((aiVariableName + ".") + _invokeGetter);
                ArrayList<Attribute> _arrayList_1 = new ArrayList<Attribute>();
                List<Attribute> _union_1 = this._roomExtensions.<Attribute>union(_arrayList_1, a_1);
                String _applyInstanceConfig_1 = this.applyInstanceConfig(pi, _plus, _union_1);
                _builder.append(_applyInstanceConfig_1, "");
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
      RefableType _type = a.getType();
      DataType aType = _type.getType();
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
              _builder_1.append(invokes, "");
              _builder_1.append(".");
              String _name = a.getName();
              String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
              CharSequence _invokeSetter = this.helpers.invokeSetter(_name, null, _valueLiteral);
              _builder_1.append(_invokeSetter, "");
              _builder_1.append(";");
              _xifexpression_2 = _builder_1.toString();
            } else {
              String _xifexpression_3 = null;
              int _size = a.getSize();
              String[] _split = value.split(",");
              int _size_1 = ((List<String>)Conversions.doWrapArray(_split)).size();
              boolean _equals_1 = (_size == _size_1);
              if (_equals_1) {
                String _xblockexpression_2 = null;
                {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("{ ");
                  {
                    String[] _split_1 = value.split(",");
                    boolean _hasElements = false;
                    for(final String s : _split_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder_2.appendImmediate(", ", "");
                      }
                      String _trim = s.trim();
                      String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), _trim);
                      _builder_2.append(_valueLiteral_1, "");
                    }
                  }
                  _builder_2.append(" }");
                  String arrayExpr = _builder_2.toString();
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append(invokes, "");
                  _builder_3.append(".");
                  String _name_1 = a.getName();
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("new ");
                  String _typeName = this.typeHelpers.typeName(aType);
                  _builder_4.append(_typeName, "");
                  _builder_4.append("[] ");
                  _builder_4.append(arrayExpr, "");
                  String _string = _builder_4.toString();
                  CharSequence _invokeSetter_1 = this.helpers.invokeSetter(_name_1, null, _string);
                  _builder_3.append(_invokeSetter_1, "");
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
                String _name_1 = a.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name_1, null);
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
                String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
                _builder_2.append(_valueLiteral_1, "\t\t");
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
              String _name = a.getName();
              CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
              String _plus = ((invokes + ".") + _invokeGetter);
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
              String _applyInstanceConfig = this.applyInstanceConfig(instance, _plus, _union);
              _builder.append(_applyInstanceConfig, "");
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
        RefableType _type = a.getType();
        DataType _type_1 = _type.getType();
        String _typeName = this.typeHelpers.typeName(_type_1);
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
        _builder.append(_name_1, "\t");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_2 = a.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_3 = a.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        String _name_4 = a.getName();
        _builder.append(_name_4, "\t\t\t");
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
        RefableType _type_2 = a.getType();
        DataType _type_3 = _type_2.getType();
        String _typeName_1 = this.typeHelpers.typeName(_type_3);
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
        _builder.append(_name_7, "\t");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_8 = a.getName();
        _builder.append(_name_8, "\t\t");
        _builder.append(" = ");
        String _name_9 = a.getName();
        _builder.append(_name_9, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_10 = a.getName();
        _builder.append(_name_10, "\t\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("this.");
        String _name_11 = a.getName();
        _builder.append(_name_11, "\t\t\t");
        _builder.append(" = ");
        String _name_12 = a.getName();
        _builder.append(_name_12, "\t\t\t");
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
        _builder.append(_name_14, "\t");
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
        String _name_15 = a_1.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_15);
        _builder.append(_firstUpper_3, "");
        _builder.append("(");
        RefableType _type_4 = a_1.getType();
        DataType _type_5 = _type_4.getType();
        String _typeName_2 = this.typeHelpers.typeName(_type_5);
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
        _builder.append(_firstUpper_4, "\t\t");
        _builder.append("(");
        String _name_18 = a_1.getName();
        _builder.append(_name_18, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("variableService.write(this.getInstancePath()+\"/");
        String _name_19 = a_1.getName();
        _builder.append(_name_19, "\t\t");
        _builder.append("\", ");
        String _name_20 = a_1.getName();
        _builder.append(_name_20, "\t\t");
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
        String _name = a.getName();
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        String _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _name, _union);
        _builder.append(_genMinMaxConstantsRec, "");
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
      Attribute _last = IterableExtensions.<Attribute>last(path);
      RefableType _type = _last.getType();
      DataType _type_1 = _type.getType();
      boolean _isDataClass = this.typeHelpers.isDataClass(_type_1);
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          Attribute _last_1 = IterableExtensions.<Attribute>last(path);
          RefableType _type_2 = _last_1.getType();
          DataType _type_3 = _type_2.getType();
          List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass) _type_3));
          for(final Attribute e : _allAttributes) {
            String _name = e.getName();
            String _plus = ((varNamePath + "_") + _name);
            List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
            String _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus, _union);
            _builder.append(_genMinMaxConstantsRec, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _xifexpression = _builder.toString();
      } else {
        String _xifexpression_1 = null;
        Attribute _last_2 = IterableExtensions.<Attribute>last(path);
        RefableType _type_4 = _last_2.getType();
        DataType _type_5 = _type_4.getType();
        if ((_type_5 instanceof ExternalType)) {
          _xifexpression_1 = null;
        } else {
          String _xifexpression_2 = null;
          Attribute _last_3 = IterableExtensions.<Attribute>last(path);
          RefableType _type_6 = _last_3.getType();
          DataType _type_7 = _type_6.getType();
          if ((_type_7 instanceof EnumerationType)) {
            _xifexpression_2 = null;
          } else {
            String _xblockexpression_1 = null;
            {
              Attribute _last_4 = IterableExtensions.<Attribute>last(path);
              RefableType _type_8 = _last_4.getType();
              DataType _type_9 = _type_8.getType();
              PrimitiveType aType = ((PrimitiveType) _type_9);
              StringConcatenation _builder_1 = new StringConcatenation();
              {
                String _attrClassConfigMinValue = this.dataConfigExt.getAttrClassConfigMinValue(ac, path);
                String _temp = (temp = _attrClassConfigMinValue);
                boolean _notEquals = (!Objects.equal(_temp, null));
                if (_notEquals) {
                  _builder_1.append("public static ");
                  String _minMaxType = this.getMinMaxType(aType);
                  _builder_1.append(_minMaxType, "");
                  _builder_1.append(" MIN_");
                  _builder_1.append(varNamePath, "");
                  _builder_1.append(" = ");
                  String _valueLiteral = this.stdExt.toValueLiteral(aType, temp);
                  _builder_1.append(_valueLiteral, "");
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                }
              }
              {
                String _attrClassConfigMaxValue = this.dataConfigExt.getAttrClassConfigMaxValue(ac, path);
                String _temp_1 = (temp = _attrClassConfigMaxValue);
                boolean _notEquals_1 = (!Objects.equal(_temp_1, null));
                if (_notEquals_1) {
                  _builder_1.append("public static ");
                  String _minMaxType_1 = this.getMinMaxType(aType);
                  _builder_1.append(_minMaxType_1, "");
                  _builder_1.append(" MAX_");
                  _builder_1.append(varNamePath, "");
                  _builder_1.append(" = ");
                  String _valueLiteral_1 = this.stdExt.toValueLiteral(aType, temp);
                  _builder_1.append(_valueLiteral_1, "");
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
    boolean _matched = false;
    if (Objects.equal(_typeName, "byte")) {
      _matched=true;
      _switchResult = "int";
    }
    if (!_matched) {
      if (Objects.equal(_typeName, "short")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_typeName, "float")) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      _switchResult = this.typeHelpers.typeName(type);
    }
    return _switchResult;
  }
}
