/**
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
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
  private RoomExtensions _roomExtensions;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ActorClass _actorClass = ai.getActorClass();
      List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(_actorClass);
      for(final Attribute a : _allAttributes) {
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, aiVariableName, _union);
        _builder.append(_applyInstanceConfig, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
        InterfaceItem _interfaceItem = pi.getInterfaceItem();
        PortClass _portClass = RoomHelpers.getPortClass(_interfaceItem);
        EList<Attribute> attribs = _portClass==null?(EList<Attribute>)null:_portClass.getAttributes();
        _builder.newLineIfNotEmpty();
        {
          boolean _notEquals = (!Objects.equal(attribs, null));
          if (_notEquals) {
            {
              for(final Attribute a_1 : attribs) {
                String _plus = (aiVariableName + ".");
                String _name = pi.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
                String _plus_1 = (_plus + _invokeGetter);
                ArrayList<Attribute> _arrayList_1 = new ArrayList<Attribute>();
                List<Attribute> _union_1 = this._roomExtensions.<Attribute>union(_arrayList_1, a_1);
                CharSequence _applyInstanceConfig_1 = this.applyInstanceConfig(pi, _plus_1, _union_1);
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
  
  private CharSequence applyInstanceConfig(final InstanceBase instance, final String invokes, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      CharSequence _xifexpression = null;
      boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
      if (_isPrimitive) {
        CharSequence _xblockexpression_1 = null;
        {
          String value = this.typeHelpers.getAttrInstanceConfigValue(path, instance);
          CharSequence _xifexpression_1 = null;
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            StringConcatenation _builder = new StringConcatenation();
            _xifexpression_1 = _builder;
          } else {
            CharSequence _xifexpression_2 = null;
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
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(invokes, "");
              _builder_1.append(".");
              String _name = a.getName();
              String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
              CharSequence _invokeSetter = this.helpers.invokeSetter(_name, null, _valueLiteral);
              _builder_1.append(_invokeSetter, "");
              _builder_1.append(";");
              _xifexpression_2 = _builder_1;
            } else {
              CharSequence _xifexpression_3 = null;
              int _size_1 = a.getSize();
              String[] _split = value.split(",");
              int _size_2 = ((List<String>)Conversions.doWrapArray(_split)).size();
              boolean _equals_2 = (_size_1 == _size_2);
              if (_equals_2) {
                CharSequence _xblockexpression_2 = null;
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
                  _xblockexpression_2 = (_builder_3);
                }
                _xifexpression_3 = _xblockexpression_2;
              } else {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("{");
                _builder_2.newLine();
                _builder_2.append("\t");
                String _typeName = this.typeHelpers.typeName(aType);
                _builder_2.append(_typeName, "	");
                _builder_2.append("[] array = ");
                _builder_2.append(invokes, "	");
                _builder_2.append(".");
                String _name_1 = a.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name_1, null);
                _builder_2.append(_invokeGetter, "	");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t");
                _builder_2.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder_2.append(_size_3, "	");
                _builder_2.append(";i++){");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t");
                _builder_2.append("array[i] = ");
                String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
                _builder_2.append(_valueLiteral_1, "		");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("}");
                _xifexpression_3 = _builder_2;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this.typeHelpers.isDataClass(aType);
        if (_isDataClass) {
          StringConcatenation _builder = new StringConcatenation();
          {
            EList<Attribute> _attributes = ((DataClass) aType).getAttributes();
            for(final Attribute e : _attributes) {
              String _plus = (invokes + ".");
              String _name = a.getName();
              CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
              String _plus_1 = (_plus + _invokeGetter);
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
              Object _applyInstanceConfig = this.applyInstanceConfig(instance, _plus_1, _union);
              _builder.append(_applyInstanceConfig, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _xifexpression_1 = _builder;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence genDynConfigGetterSetter(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
      for(final Attribute a : _dynConfigReadAttributes) {
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
      List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
      for(final Attribute a_1 : _dynConfigWriteAttributes) {
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
  
  public String genMinMaxConstants(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Attribute> _attributes = ac.getAttributes();
      for(final Attribute a : _attributes) {
        String _name = a.getName();
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _name, _union);
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
  
  private CharSequence genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      String temp = ((String) null);
      CharSequence _xifexpression = null;
      Attribute _last = IterableExtensions.<Attribute>last(path);
      RefableType _refType = _last.getRefType();
      DataType _type = _refType.getType();
      boolean _isDataClass = this.typeHelpers.isDataClass(_type);
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          Attribute _last_1 = IterableExtensions.<Attribute>last(path);
          RefableType _refType_1 = _last_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(((DataClass) _type_1));
          for(final Attribute e : _allAttributes) {
            String _plus = (varNamePath + "_");
            String _name = e.getName();
            String _plus_1 = (_plus + _name);
            List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
            Object _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus_1, _union);
            _builder.append(_genMinMaxConstantsRec, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        Attribute _last_2 = IterableExtensions.<Attribute>last(path);
        RefableType _refType_2 = _last_2.getRefType();
        DataType _type_2 = _refType_2.getType();
        if ((_type_2 instanceof ExternalType)) {
          _xifexpression_1 = null;
        } else {
          CharSequence _xblockexpression_1 = null;
          {
            Attribute _last_3 = IterableExtensions.<Attribute>last(path);
            RefableType _refType_3 = _last_3.getRefType();
            DataType _type_3 = _refType_3.getType();
            PrimitiveType aType = ((PrimitiveType) _type_3);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              String _attrClassConfigMinValue = this.dataConfigExt.getAttrClassConfigMinValue(ac, path);
              String _temp = temp = _attrClassConfigMinValue;
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
              String _temp_1 = temp = _attrClassConfigMaxValue;
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
            _xblockexpression_1 = (_builder_1);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String getMinMaxType(final PrimitiveType type) {
    String _switchResult = null;
    String _typeName = this.typeHelpers.typeName(type);
    final String _switchValue = _typeName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      String _typeName_1 = this.typeHelpers.typeName(type);
      _switchResult = _typeName_1;
    }
    return _switchResult;
  }
}
