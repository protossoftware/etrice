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
import java.util.List;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
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
  private /* RoomExtensions */Object _roomExtensions;
  
  @Inject
  private Initialization initGen;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes is undefined for the type ConfigGenAddon"
      + "\nThe method union is undefined for the type ConfigGenAddon"
      + "\nThe method union is undefined for the type ConfigGenAddon");
  }
  
  private CharSequence applyInstanceConfig(final InstanceBase instance, final String invokes, final List<Attribute> path) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes is undefined for the type ConfigGenAddon"
      + "\nThe method union is undefined for the type ConfigGenAddon");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes is undefined for the type ConfigGenAddon"
      + "\nThe method name is undefined for the type ConfigGenAddon"
      + "\nThe method union is undefined for the type ConfigGenAddon");
  }
  
  private CharSequence genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes is undefined for the type ConfigGenAddon"
      + "\nThe method name is undefined for the type ConfigGenAddon"
      + "\nThe method union is undefined for the type ConfigGenAddon");
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
