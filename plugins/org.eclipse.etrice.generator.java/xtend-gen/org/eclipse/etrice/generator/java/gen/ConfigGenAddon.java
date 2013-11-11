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
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  private RoomExtensions _roomExtensions;
  
  @Inject
  private Initialization initGen;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a : ai.actorClass.allAttributes�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�applyInstanceConfig(ai, aiVariableName, new ArrayList<Attribute>().union(a))�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("�FOR pi : ai.orderedIfItemInstances�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�var attribs = RoomHelpers::getPortClass(pi.interfaceItem)?.attributes�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF attribs != null�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�FOR a : attribs�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�applyInstanceConfig(pi, aiVariableName+\".\"+invokeGetter(pi.name, null), new ArrayList<Attribute>().union(a))�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence applyInstanceConfig(final InstanceBase instance, final String invokes, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _type = a.getType();
      DataType aType = _type.getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          final PrimitiveType _primitiveType = (PrimitiveType)aType;
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String value = this.typeHelpers.getAttrInstanceConfigValue(path, instance);
            CharSequence _xifexpression = null;
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              String _valueLiteral = this.stdExt.toValueLiteral(_primitiveType, value);
              CharSequence _genAttributeInitializer = this.initGen.genAttributeInitializer(a, _valueLiteral, invokes);
              _xifexpression = _genAttributeInitializer;
            }
            _xblockexpression_1 = (_xifexpression);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof DataClass) {
          final DataClass _dataClass = (DataClass)aType;
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("�FOR e : (aType as DataClass).allAttributes�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�applyInstanceConfig(instance, invokes+\".\"+a.name.invokeGetter(null), path.union(e))�");
          _builder.newLine();
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _switchResult = _builder;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public CharSequence genDynConfigGetterSetter(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a : dataConfigExt.getDynConfigReadAttributes(ac)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public �a.type.type.typeName��IF a.size>0�[]�ENDIF� get�a.name.toFirstUpper�(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(lock_�a.name� == null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return �a.name�;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("synchronized(lock_�a.name�){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return �a.name�;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void set�a.name.toFirstUpper�(�a.type.type.typeName��IF a.size>0�[]�ENDIF� �a.name�){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(lock_�a.name� == null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.�a.name� = �a.name�;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("synchronized(lock_�a.name�){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.�a.name� = �a.name�;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DynConfigLock get�a.name.toFirstUpper�Lock(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return lock_�a.name�;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("�FOR a : dataConfigExt.getDynConfigWriteAttributes(ac)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setAndWrite�a.name.toFirstUpper�(�a.type.type.typeName��IF a.size>0�[]�ENDIF� �a.name�){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("set�a.name.toFirstUpper�(�a.name�);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("getVariableService().write(this.getInstancePath()+\"/�a.name�\", �a.name�);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  public String genMinMaxConstants(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a : ac.allAttributes�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�genMinMaxConstantsRec(ac, a.name, new ArrayList<Attribute>().union(a))�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
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
      Attribute _last = IterableExtensions.<Attribute>last(path);
      RefableType _type = _last.getType();
      DataType aType = _type.getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (aType instanceof DataClass) {
          final DataClass _dataClass = (DataClass)aType;
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("�FOR e : (aType as DataClass).allAttributes�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�genMinMaxConstantsRec(ac, varNamePath+\"_\"+e.name, path.union(e))�");
          _builder.newLine();
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _switchResult = _builder;
        }
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          final PrimitiveType _primitiveType = (PrimitiveType)aType;
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            String temp = ((String) null);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("�IF (temp = dataConfigExt.getAttrClassConfigMinValue(ac, path)) != null�");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public static �aType.minMaxType� MIN_�varNamePath� = �aType.toValueLiteral(temp)�;");
            _builder.newLine();
            _builder.append("�ENDIF�");
            _builder.newLine();
            _builder.append("�IF (temp = dataConfigExt.getAttrClassConfigMaxValue(ac, path)) != null�");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public static �aType.minMaxType� MAX_�varNamePath� = �aType.toValueLiteral(temp)�;");
            _builder.newLine();
            _builder.append("�ENDIF�");
            _builder.newLine();
            _xblockexpression_1 = (_builder);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      _xblockexpression = (_switchResult);
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
