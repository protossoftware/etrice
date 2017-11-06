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
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.converter.TimeConverter;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class VariableServiceGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private JavaExtensions stdExt;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  private IDataConfiguration configExt;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  public void doGenerate(final Root root, final SubSystemInstance ssi) {
    final NodeRef nr = ETMapUtil.getNodeRef(ssi);
    final String clsname = this.stdExt.getJavaClassName(nr, ssi);
    String _generationTargetPath = this.roomExt.getGenerationTargetPath(ssi.getSubSystemClass());
    String _path = this.roomExt.getPath(ssi.getSubSystemClass());
    final String path = (_generationTargetPath + _path);
    String _generationInfoPath = this.roomExt.getGenerationInfoPath(ssi.getSubSystemClass());
    String _path_1 = this.roomExt.getPath(ssi.getSubSystemClass());
    final String infopath = (_generationInfoPath + _path_1);
    final String file = (clsname + "VariableService.java");
    this.fileIO.generateFile("generating VariableService implementation", path, infopath, file, this.generate(root, ssi));
  }
  
  private CharSequence generate(final Root root, final SubSystemInstance comp) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this.stdExt.getJavaClassName(nr, comp);
      final HashMap<ActorInstance, List<Attribute>> aisAttrMap = new HashMap<ActorInstance, List<Attribute>>();
      final Consumer<ActorInstance> _function = (ActorInstance ai) -> {
        boolean _isEmpty = this.configExt.getDynConfigReadAttributes(ai).isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          aisAttrMap.put(ai, this.configExt.getDynConfigReadAttributes(ai));
        }
      };
      comp.getAllContainedInstances().forEach(_function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("package ");
      String _package = this.roomExt.getPackage(comp.getSubSystemClass());
      _builder.append(_package);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Arrays;");
      _builder.newLine();
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.AbstractVariableService;");
      _builder.newLine();
      String _userCode1 = this.configExt.getUserCode1(comp);
      _builder.append(_userCode1);
      _builder.newLineIfNotEmpty();
      {
        HashSet<RoomModel> _roomModels = this.getRoomModels(aisAttrMap.keySet());
        for(final RoomModel model : _roomModels) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name);
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname);
      _builder.append("VariableService extends AbstractVariableService{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(clsname, "\t");
      _builder.append(" subSystem;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// Actor instances");
      _builder.newLine();
      {
        Set<ActorInstance> _keySet = aisAttrMap.keySet();
        for(final ActorInstance ai : _keySet) {
          _builder.append("\t");
          _builder.append("private ");
          String _name_1 = ai.getActorClass().getName();
          _builder.append(_name_1, "\t");
          _builder.append(" ");
          CharSequence _varName = this.getVarName(ai);
          _builder.append(_varName, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "\t");
      _builder.append("VariableService(");
      _builder.append(clsname, "\t");
      _builder.append(" subSystem) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(");
      String _userCode2 = this.configExt.getUserCode2(comp);
      _builder.append(_userCode2, "\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("this.subSystem = subSystem;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected void initInstances(){");
      _builder.newLine();
      {
        Set<ActorInstance> _keySet_1 = aisAttrMap.keySet();
        for(final ActorInstance ai_1 : _keySet_1) {
          _builder.append("\t\t");
          CharSequence _varName_1 = this.getVarName(ai_1);
          _builder.append(_varName_1, "\t\t");
          _builder.append(" = (");
          String _name_2 = ai_1.getActorClass().getName();
          _builder.append(_name_2, "\t\t");
          _builder.append(")subSystem.getInstance(\"");
          String _path = ai_1.getPath();
          _builder.append(_path, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected void setAttributeValues(Map<String, Object> values) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Object object;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String id = null;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        Set<ActorInstance> _keySet_2 = aisAttrMap.keySet();
        for(final ActorInstance ai_2 : _keySet_2) {
          {
            List<Attribute> _get = aisAttrMap.get(ai_2);
            for(final Attribute a : _get) {
              _builder.append("\t\t");
              _builder.append("try{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("boolean changed = false;");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              CharSequence _genSetAttributeValues1 = this.genSetAttributeValues1(this.roomExt.<Attribute>union(new ArrayList<Attribute>(), a), ai_2);
              _builder.append(_genSetAttributeValues1, "\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("if(changed)");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("synchronized(");
              CharSequence _varName_2 = this.getVarName(ai_2);
              _builder.append(_varName_2, "\t\t\t\t");
              _builder.append(".");
              String _name_3 = a.getName();
              String _plus = (_name_3 + "Lock");
              CharSequence _invokeGetter = this.helpers.invokeGetter(_plus, null);
              _builder.append(_invokeGetter, "\t\t\t\t");
              _builder.append("){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("if(");
              CharSequence _varName_3 = this.getVarName(ai_2);
              _builder.append(_varName_3, "\t\t\t\t\t");
              _builder.append(".");
              String _name_4 = a.getName();
              String _plus_1 = (_name_4 + "Lock");
              CharSequence _invokeGetter_1 = this.helpers.invokeGetter(_plus_1, null);
              _builder.append(_invokeGetter_1, "\t\t\t\t\t");
              _builder.append(".isUpdate()){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              CharSequence _genSetAttributeValues2 = this.genSetAttributeValues2(this.roomExt.<Attribute>union(new ArrayList<Attribute>(), a), ai_2);
              _builder.append(_genSetAttributeValues2, "\t\t\t\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}catch(IllegalArgumentException e){");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("error(id, e);");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected Map<String, Object> getAttributeValues(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<String, Object> values = new HashMap<String, Object>();");
      _builder.newLine();
      {
        Set<ActorInstance> _keySet_3 = aisAttrMap.keySet();
        for(final ActorInstance ai_3 : _keySet_3) {
          {
            List<Attribute> _get_1 = aisAttrMap.get(ai_3);
            for(final Attribute a_1 : _get_1) {
              _builder.append("\t\t");
              CharSequence _genGetAttributeValues = this.genGetAttributeValues(this.roomExt.<Attribute>union(new ArrayList<Attribute>(), a_1), ai_3);
              _builder.append(_genGetAttributeValues, "\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return values;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void writeDataClass(String id, Object dcObject, Map<String, Object> writeMap) {");
      _builder.newLine();
      _builder.append("\t\t");
      HashSet<DataClass> dataClasses = this.getDynConfigDataClasses(aisAttrMap.keySet());
      _builder.newLineIfNotEmpty();
      {
        for(final DataClass dc : dataClasses) {
          _builder.append("\t\t");
          _builder.append("if(dcObject.getClass().equals(");
          String _typeName = this._typeHelpers.typeName(dc);
          _builder.append(_typeName, "\t\t");
          _builder.append(".class))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("writeDataClass(id, (");
          String _typeName_1 = this._typeHelpers.typeName(dc);
          _builder.append(_typeName_1, "\t\t\t");
          _builder.append(") dcObject, writeTasks);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// DataClasses write operations");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        HashSet<DataClass> _allDataClasses = this.getAllDataClasses(dataClasses);
        for(final DataClass dc_1 : _allDataClasses) {
          _builder.append("\t");
          _builder.append("private void writeDataClass(String id, ");
          String _typeName_2 = this._typeHelpers.typeName(dc_1);
          _builder.append(_typeName_2, "\t");
          _builder.append(" object, Map<String, Object> map){");
          _builder.newLineIfNotEmpty();
          {
            List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(dc_1);
            for(final Attribute a_2 : _allAttributes) {
              {
                boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(a_2.getType().getType());
                if (_isEnumerationOrPrimitive) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("map.put(id+\"/");
                  String _name_5 = a_2.getName();
                  _builder.append(_name_5, "\t\t");
                  _builder.append("\", ");
                  {
                    int _size = a_2.getSize();
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("toObjectArray(");
                    }
                  }
                  _builder.append("object.");
                  CharSequence _invokeGetter_2 = this.helpers.invokeGetter(a_2.getName(), null);
                  _builder.append(_invokeGetter_2, "\t\t");
                  {
                    int _size_1 = a_2.getSize();
                    boolean _greaterThan_1 = (_size_1 > 0);
                    if (_greaterThan_1) {
                      _builder.append(")");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("writeDataClass(id+\"/");
                  String _name_6 = a_2.getName();
                  _builder.append(_name_6, "\t\t");
                  _builder.append("\", object.");
                  CharSequence _invokeGetter_3 = this.helpers.invokeGetter(a_2.getName(), null);
                  _builder.append(_invokeGetter_3, "\t\t");
                  _builder.append(", map);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected int getPollingTimerUser(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return ");
      long _split = TimeConverter.split(this.configExt.getPollingTimerUser(comp), TimeConverter.MILLI_SEC, true);
      _builder.append(_split, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence genMinMaxCheck(final List<Attribute> path, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      String aVarName = this.toAbsolutePath(path, "_");
      String _attrClassConfigMinValue = this.configExt.getAttrClassConfigMinValue(ac, path);
      boolean min = (!Objects.equal(_attrClassConfigMinValue, null));
      String _attrClassConfigMaxValue = this.configExt.getAttrClassConfigMaxValue(ac, path);
      boolean max = (!Objects.equal(_attrClassConfigMaxValue, null));
      CharSequence _xifexpression = null;
      if ((min || max)) {
        StringConcatenation _builder = new StringConcatenation();
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("for(");
            String _typeName = this._typeHelpers.typeName(a.getType().getType());
            _builder.append(_typeName);
            _builder.append(" e : ");
            _builder.append(aVarName);
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
          }
        }
        _builder.append("checkMinMax(");
        {
          int _size_1 = a.getSize();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("e");
          } else {
            _builder.append(aVarName);
          }
        }
        _builder.append(", ");
        {
          if (min) {
            String _name = ac.getName();
            _builder.append(_name);
            _builder.append(".MIN");
            _builder.append(aVarName);
          } else {
            _builder.append("null");
          }
        }
        _builder.append(", ");
        {
          if (max) {
            String _name_1 = ac.getName();
            _builder.append(_name_1);
            _builder.append(".MAX");
            _builder.append(aVarName);
          } else {
            _builder.append("null");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private HashSet<DataClass> getDynConfigDataClasses(final Iterable<ActorInstance> ais) {
    final HashSet<DataClass> result = new HashSet<DataClass>();
    final Consumer<ActorInstance> _function = (ActorInstance ai) -> {
      final Consumer<Attribute> _function_1 = (Attribute a) -> {
        boolean _isDataClass = this._typeHelpers.isDataClass(a.getType().getType());
        if (_isDataClass) {
          DataType _type = a.getType().getType();
          result.add(((DataClass) _type));
        }
      };
      this.configExt.getDynConfigReadAttributes(ai).forEach(_function_1);
    };
    ais.forEach(_function);
    return result;
  }
  
  private HashSet<DataClass> getAllDataClasses(final Iterable<DataClass> dcs) {
    final HashSet<DataClass> result = new HashSet<DataClass>();
    Iterables.<DataClass>addAll(result, dcs);
    final LinkedList<DataClass> visit = new LinkedList<DataClass>();
    Iterables.<DataClass>addAll(visit, dcs);
    while ((!visit.isEmpty())) {
      {
        DataClass dc = visit.pop();
        final Consumer<Attribute> _function = (Attribute a) -> {
          boolean _isDataClass = this._typeHelpers.isDataClass(a.getType().getType());
          if (_isDataClass) {
            DataType _type = a.getType().getType();
            visit.add(((DataClass) _type));
          }
        };
        this._roomHelpers.getAllAttributes(dc).forEach(_function);
      }
    }
    return result;
  }
  
  private HashSet<RoomModel> getRoomModels(final Collection<ActorInstance> ais) {
    final HashSet<RoomModel> models = new HashSet<RoomModel>();
    final Consumer<ActorInstance> _function = (ActorInstance ai) -> {
      EObject _eContainer = ai.getActorClass().eContainer();
      models.add(((RoomModel) _eContainer));
    };
    ais.forEach(_function);
    return models;
  }
  
  private String toAbsolutePath(final List<Attribute> path, final String pathDelim) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute p : path) {
        _builder.append(pathDelim);
        String _name = p.getName();
        _builder.append(_name);
      }
    }
    return _builder.toString();
  }
  
  private CharSequence getVarName(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<String> _drop = IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(ai.getPath().split("/"))), 2);
      boolean _hasElements = false;
      for(final String p : _drop) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("_", "");
        }
        _builder.append(p);
      }
    }
    return _builder;
  }
  
  private CharSequence genGetAttributeValues(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      final Attribute a = IterableExtensions.<Attribute>last(path);
      CharSequence _xifexpression = null;
      boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(a.getType().getType());
      if (_isEnumerationOrPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("values.put(\"");
        String _path = ai.getPath();
        _builder.append(_path);
        String _absolutePath = this.toAbsolutePath(path, "/");
        _builder.append(_absolutePath);
        _builder.append("\", ");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("toObjectArray(");
          }
        }
        CharSequence _varName = this.getVarName(ai);
        _builder.append(_varName);
        _builder.append(".");
        CharSequence _invokeGetters = this.helpers.invokeGetters(path, null);
        _builder.append(_invokeGetters);
        {
          int _size_1 = a.getSize();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append(")");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this._typeHelpers.isDataClass(a.getType().getType());
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            DataType _type = a.getType().getType();
            DataClass dataClass = ((DataClass) _type);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                CharSequence _genGetAttributeValues = this.genGetAttributeValues(this.roomExt.<Attribute>union(path, at), ai);
                _builder_1.append(_genGetAttributeValues);
                _builder_1.newLineIfNotEmpty();
              }
            }
            _xblockexpression_1 = _builder_1;
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private CharSequence genSetAttributeValues1(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      String aVarName = this.toAbsolutePath(path, "_");
      CharSequence _xifexpression = null;
      boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(a.getType().getType());
      if (_isEnumerationOrPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("id = \"");
        String _path = ai.getPath();
        _builder.append(_path);
        String _absolutePath = this.toAbsolutePath(path, "/");
        _builder.append(_absolutePath);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        {
          int _size = a.getSize();
          boolean _equals = (_size == 0);
          if (_equals) {
            String _wrapper = this.stdExt.toWrapper(this._typeHelpers.typeName(a.getType().getType()));
            _builder.append(_wrapper);
          } else {
            String _typeName = this._typeHelpers.typeName(a.getType().getType());
            _builder.append(_typeName);
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        _builder.append(aVarName);
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("object = values.get(id);");
        _builder.newLine();
        _builder.append("if(object != null){");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(aVarName, "\t");
        _builder.append(" = ensure");
        String _firstUpper = StringExtensions.toFirstUpper(this._typeHelpers.typeName(a.getType().getType()));
        _builder.append(_firstUpper, "\t");
        {
          int _size_1 = a.getSize();
          boolean _greaterThan = (_size_1 > 0);
          if (_greaterThan) {
            _builder.append("Array");
          }
        }
        _builder.append("(object");
        {
          int _size_2 = a.getSize();
          boolean _greaterThan_1 = (_size_2 > 0);
          if (_greaterThan_1) {
            _builder.append(", ");
            int _size_3 = a.getSize();
            _builder.append(_size_3, "\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _genMinMaxCheck = this.genMinMaxCheck(path, ai.getActorClass());
        _builder.append(_genMinMaxCheck, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(!");
        {
          int _size_4 = a.getSize();
          boolean _equals_1 = (_size_4 == 0);
          if (_equals_1) {
            _builder.append(aVarName, "\t");
            _builder.append(".equals(");
          } else {
            _builder.append("Arrays.equals(");
            _builder.append(aVarName, "\t");
            _builder.append(", ");
          }
        }
        _builder.append("(");
        {
          int _size_5 = a.getSize();
          boolean _equals_2 = (_size_5 == 0);
          if (_equals_2) {
            String _wrapper_1 = this.stdExt.toWrapper(this._typeHelpers.typeName(a.getType().getType()));
            _builder.append(_wrapper_1, "\t");
          } else {
            String _typeName_1 = this._typeHelpers.typeName(a.getType().getType());
            _builder.append(_typeName_1, "\t");
            _builder.append("[]");
          }
        }
        _builder.append(")getDiffMap().get(id)))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("changed = true;");
        _builder.newLine();
        _builder.append("} else");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("warning(id, \"is missing\");");
        _builder.newLine();
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this._typeHelpers.isDataClass(a.getType().getType());
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            DataType _type = a.getType().getType();
            DataClass dataClass = ((DataClass) _type);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                CharSequence _genSetAttributeValues1 = this.genSetAttributeValues1(this.roomExt.<Attribute>union(path, at), ai);
                _builder_1.append(_genSetAttributeValues1);
                _builder_1.newLineIfNotEmpty();
              }
            }
            _xblockexpression_1 = _builder_1;
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private CharSequence genSetAttributeValues2(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      String aVarName = this.toAbsolutePath(path, "_");
      CharSequence _xifexpression = null;
      boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(a.getType().getType());
      if (_isEnumerationOrPrimitive) {
        CharSequence _xblockexpression_1 = null;
        {
          String _xifexpression_1 = null;
          int _size = path.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            int _size_1 = path.size();
            int _minus = (_size_1 - 1);
            CharSequence _invokeGetters = this.helpers.invokeGetters(IterableExtensions.<Attribute>take(path, _minus), null);
            _xifexpression_1 = (_invokeGetters + ".");
          } else {
            _xifexpression_1 = "";
          }
          final String getters = _xifexpression_1;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("if(");
          _builder.append(aVarName);
          _builder.append(" != null){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _varName = this.getVarName(ai);
          _builder.append(_varName, "\t");
          _builder.append(".");
          _builder.append(getters, "\t");
          CharSequence _invokeSetter = this.helpers.invokeSetter(a.getName(), null, aVarName);
          _builder.append(_invokeSetter, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("getDiffMap().put(\"");
          String _path = ai.getPath();
          _builder.append(_path, "\t");
          String _absolutePath = this.toAbsolutePath(path, "/");
          _builder.append(_absolutePath, "\t");
          _builder.append("\", ");
          _builder.append(aVarName, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this._typeHelpers.isDataClass(a.getType().getType());
        if (_isDataClass) {
          CharSequence _xblockexpression_2 = null;
          {
            DataType _type = a.getType().getType();
            final DataClass dataClass = ((DataClass) _type);
            StringConcatenation _builder = new StringConcatenation();
            {
              List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                CharSequence _genSetAttributeValues2 = this.genSetAttributeValues2(this.roomExt.<Attribute>union(path, at), ai);
                _builder.append(_genSetAttributeValues2);
                _builder.newLineIfNotEmpty();
              }
            }
            _xblockexpression_2 = _builder;
          }
          _xifexpression_1 = _xblockexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
