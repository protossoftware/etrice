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
package org.eclipse.etrice.generator.java.gen;

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
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ConfigGenAddon {
  @Inject
  @Extension
  private JavaExtensions stdExt;
  
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
  
  @Inject
  private Initialization initGen;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(ai.getActorClass());
      for(final Attribute a : _allAttributes) {
        CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, aiVariableName, this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a));
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
                CharSequence _applyInstanceConfig_1 = this.applyInstanceConfig(pi, _plus, this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a_1));
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
  
  private CharSequence applyInstanceConfig(final InstanceBase instance, final String invokes, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      DataType aType = a.getType().getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (aType instanceof PrimitiveType) {
        _matched=true;
        CharSequence _xblockexpression_1 = null;
        {
          String value = this.typeHelpers.getAttrInstanceConfigValue(path, instance);
          CharSequence _xifexpression = null;
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            _xifexpression = this.initGen.genAttributeInitializer(a, this.stdExt.toValueLiteral(((PrimitiveType)aType), value), invokes);
          }
          _xblockexpression_1 = _xifexpression;
        }
        _switchResult = _xblockexpression_1;
      }
      if (!_matched) {
        if (aType instanceof EnumerationType) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String value = this.typeHelpers.getAttrInstanceConfigValue(path, instance);
            CharSequence _xifexpression = null;
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              _xifexpression = this.initGen.genAttributeInitializer(a, value, invokes);
            }
            _xblockexpression_1 = _xifexpression;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof DataClass) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          {
            List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass) aType));
            for(final Attribute e : _allAttributes) {
              CharSequence _invokeGetter = this.helpers.invokeGetter(a.getName(), null);
              String _plus = ((invokes + ".") + _invokeGetter);
              CharSequence _applyInstanceConfig = this.applyInstanceConfig(instance, _plus, this._roomExtensions.<Attribute>union(path, e));
              _builder.append(_applyInstanceConfig);
              _builder.newLineIfNotEmpty();
            }
          }
          _switchResult = _builder;
        }
      }
      _xblockexpression = _switchResult;
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
        _builder.append("getVariableService().write(this.getInstancePath()+\"/");
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
      List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(ac);
      for(final Attribute a : _allAttributes) {
        CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, a.getName(), this._roomExtensions.<Attribute>union(new ArrayList<Attribute>(), a));
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
  
  private CharSequence genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      DataType aType = IterableExtensions.<Attribute>last(path).getType().getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (aType instanceof DataClass) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        {
          List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass) aType));
          for(final Attribute e : _allAttributes) {
            String _name = e.getName();
            String _plus = ((varNamePath + "_") + _name);
            CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus, this._roomExtensions.<Attribute>union(path, e));
            _builder.append(_genMinMaxConstantsRec);
            _builder.newLineIfNotEmpty();
          }
        }
        _switchResult = _builder;
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String temp = ((String) null);
            StringConcatenation _builder = new StringConcatenation();
            {
              boolean _notEquals = (!Objects.equal((temp = this.dataConfigExt.getAttrClassConfigMinValue(ac, path)), null));
              if (_notEquals) {
                _builder.append("public static ");
                String _minMaxType = this.getMinMaxType(((PrimitiveType)aType));
                _builder.append(_minMaxType);
                _builder.append(" MIN_");
                _builder.append(varNamePath);
                _builder.append(" = ");
                String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType)aType), temp);
                _builder.append(_valueLiteral);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _notEquals_1 = (!Objects.equal((temp = this.dataConfigExt.getAttrClassConfigMaxValue(ac, path)), null));
              if (_notEquals_1) {
                _builder.append("public static ");
                String _minMaxType_1 = this.getMinMaxType(((PrimitiveType)aType));
                _builder.append(_minMaxType_1);
                _builder.append(" MAX_");
                _builder.append(varNamePath);
                _builder.append(" = ");
                String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType)aType), temp);
                _builder.append(_valueLiteral_1);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            _xblockexpression_1 = _builder;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      _xblockexpression = _switchResult;
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
