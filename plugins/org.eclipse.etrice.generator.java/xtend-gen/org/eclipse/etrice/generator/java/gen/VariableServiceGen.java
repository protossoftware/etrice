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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  public void doGenerate(final Root root, final SubSystemInstance ssi) {
    final NodeRef nr = ETMapUtil.getNodeRef(ssi);
    final String clsname = this.stdExt.getJavaClassName(nr, ssi);
    SubSystemClass _subSystemClass = ssi.getSubSystemClass();
    String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
    SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
    String _path = this.roomExt.getPath(_subSystemClass_1);
    final String path = (_generationTargetPath + _path);
    SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
    String _generationInfoPath = this.roomExt.getGenerationInfoPath(_subSystemClass_2);
    SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
    String _path_1 = this.roomExt.getPath(_subSystemClass_3);
    final String infopath = (_generationInfoPath + _path_1);
    final String file = (clsname + "VariableService.java");
    CharSequence _generate = this.generate(root, ssi);
    this.fileIO.generateFile("generating VariableService implementation", path, infopath, file, _generate);
  }
  
  private CharSequence generate(final Root root, final SubSystemInstance comp) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this.stdExt.getJavaClassName(nr, comp);
      HashMap<ActorInstance,List<Attribute>> _hashMap = new HashMap<ActorInstance,List<Attribute>>();
      final HashMap<ActorInstance,List<Attribute>> aisAttrMap = _hashMap;
      EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
      final Procedure1<ActorInstance> _function = new Procedure1<ActorInstance>() {
          public void apply(final ActorInstance ai) {
            List<Attribute> _dynConfigReadAttributes = VariableServiceGen.this.configExt.getDynConfigReadAttributes(ai);
            boolean _isEmpty = _dynConfigReadAttributes.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              List<Attribute> _dynConfigReadAttributes_1 = VariableServiceGen.this.configExt.getDynConfigReadAttributes(ai);
              aisAttrMap.put(ai, _dynConfigReadAttributes_1);
            }
          }
        };
      IterableExtensions.<ActorInstance>forEach(_allContainedInstances, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("package ");
      SubSystemClass _subSystemClass = comp.getSubSystemClass();
      String _package = this.roomExt.getPackage(_subSystemClass);
      _builder.append(_package, "");
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
      _builder.append(_userCode1, "");
      _builder.newLineIfNotEmpty();
      {
        Set<ActorInstance> _keySet = aisAttrMap.keySet();
        HashSet<RoomModel> _roomModels = this.getRoomModels(_keySet);
        for(final RoomModel model : _roomModels) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname, "");
      _builder.append("VariableService extends AbstractVariableService{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(clsname, "	");
      _builder.append(" subSystem;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// Actor instances");
      _builder.newLine();
      {
        Set<ActorInstance> _keySet_1 = aisAttrMap.keySet();
        for(final ActorInstance ai : _keySet_1) {
          _builder.append("\t");
          _builder.append("private ");
          ActorClass _actorClass = ai.getActorClass();
          String _name_1 = _actorClass.getName();
          _builder.append(_name_1, "	");
          _builder.append(" ");
          CharSequence _varName = this.getVarName(ai);
          _builder.append(_varName, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "	");
      _builder.append("VariableService(");
      _builder.append(clsname, "	");
      _builder.append(" subSystem) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(");
      String _userCode2 = this.configExt.getUserCode2(comp);
      _builder.append(_userCode2, "		");
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
        Set<ActorInstance> _keySet_2 = aisAttrMap.keySet();
        for(final ActorInstance ai_1 : _keySet_2) {
          _builder.append("\t\t");
          CharSequence _varName_1 = this.getVarName(ai_1);
          _builder.append(_varName_1, "		");
          _builder.append(" = (");
          ActorClass _actorClass_1 = ai_1.getActorClass();
          String _name_2 = _actorClass_1.getName();
          _builder.append(_name_2, "		");
          _builder.append(")subSystem.getInstance(\"");
          String _path = ai_1.getPath();
          _builder.append(_path, "		");
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
        Set<ActorInstance> _keySet_3 = aisAttrMap.keySet();
        for(final ActorInstance ai_2 : _keySet_3) {
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
              ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
              List<Attribute> _union = this.roomExt.<Attribute>union(_arrayList, a);
              CharSequence _genSetAttributeValues1 = this.genSetAttributeValues1(_union, ai_2);
              _builder.append(_genSetAttributeValues1, "			");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("if(changed)");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("synchronized(");
              CharSequence _varName_2 = this.getVarName(ai_2);
              _builder.append(_varName_2, "				");
              _builder.append(".");
              String _name_3 = a.getName();
              String _plus = (_name_3 + "Lock");
              CharSequence _invokeGetter = this.helpers.invokeGetter(_plus, null);
              _builder.append(_invokeGetter, "				");
              _builder.append("){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("if(");
              CharSequence _varName_3 = this.getVarName(ai_2);
              _builder.append(_varName_3, "					");
              _builder.append(".");
              String _name_4 = a.getName();
              String _plus_1 = (_name_4 + "Lock");
              CharSequence _invokeGetter_1 = this.helpers.invokeGetter(_plus_1, null);
              _builder.append(_invokeGetter_1, "					");
              _builder.append(".isUpdate()){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              ArrayList<Attribute> _arrayList_1 = new ArrayList<Attribute>();
              List<Attribute> _union_1 = this.roomExt.<Attribute>union(_arrayList_1, a);
              CharSequence _genSetAttributeValues2 = this.genSetAttributeValues2(_union_1, ai_2);
              _builder.append(_genSetAttributeValues2, "						");
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
        Set<ActorInstance> _keySet_4 = aisAttrMap.keySet();
        for(final ActorInstance ai_3 : _keySet_4) {
          {
            List<Attribute> _get_1 = aisAttrMap.get(ai_3);
            for(final Attribute a_1 : _get_1) {
              _builder.append("\t\t");
              ArrayList<Attribute> _arrayList_2 = new ArrayList<Attribute>();
              List<Attribute> _union_2 = this.roomExt.<Attribute>union(_arrayList_2, a_1);
              CharSequence _genGetAttributeValues = this.genGetAttributeValues(_union_2, ai_3);
              _builder.append(_genGetAttributeValues, "		");
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
      Set<ActorInstance> _keySet_5 = aisAttrMap.keySet();
      HashSet<DataClass> dataClasses = this.getDynConfigDataClasses(_keySet_5);
      _builder.newLineIfNotEmpty();
      {
        for(final DataClass dc : dataClasses) {
          _builder.append("\t\t");
          _builder.append("if(dcObject.getClass().equals(");
          String _typeName = this._typeHelpers.typeName(dc);
          _builder.append(_typeName, "		");
          _builder.append(".class))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("writeDataClass(id, (");
          String _typeName_1 = this._typeHelpers.typeName(dc);
          _builder.append(_typeName_1, "			");
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
          _builder.append(_typeName_2, "	");
          _builder.append(" object, Map<String, Object> map){");
          _builder.newLineIfNotEmpty();
          {
            List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(dc_1);
            for(final Attribute a_2 : _allAttributes) {
              {
                RefableType _refType = a_2.getRefType();
                DataType _type = _refType.getType();
                boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
                if (_isPrimitive) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("map.put(id+\"/");
                  String _name_5 = a_2.getName();
                  _builder.append(_name_5, "		");
                  _builder.append("\", ");
                  {
                    int _size = a_2.getSize();
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("toObjectArray(");
                    }
                  }
                  _builder.append("object.");
                  String _name_6 = a_2.getName();
                  CharSequence _invokeGetter_2 = this.helpers.invokeGetter(_name_6, null);
                  _builder.append(_invokeGetter_2, "		");
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
                  String _name_7 = a_2.getName();
                  _builder.append(_name_7, "		");
                  _builder.append("\", object.");
                  String _name_8 = a_2.getName();
                  CharSequence _invokeGetter_3 = this.helpers.invokeGetter(_name_8, null);
                  _builder.append(_invokeGetter_3, "		");
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
      int _pollingTimerUser = this.configExt.getPollingTimerUser(comp);
      _builder.append(_pollingTimerUser, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
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
      boolean _or = false;
      if (min) {
        _or = true;
      } else {
        _or = (min || max);
      }
      if (_or) {
        StringConcatenation _builder = new StringConcatenation();
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("for(");
            RefableType _refType = a.getRefType();
            DataType _type = _refType.getType();
            String _typeName = this._typeHelpers.typeName(_type);
            _builder.append(_typeName, "");
            _builder.append(" e : ");
            _builder.append(aVarName, "");
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
            _builder.append(aVarName, "");
          }
        }
        _builder.append(", ");
        {
          if (min) {
            String _name = ac.getName();
            _builder.append(_name, "");
            _builder.append(".MIN");
            _builder.append(aVarName, "");
          } else {
            _builder.append("null");
          }
        }
        _builder.append(", ");
        {
          if (max) {
            String _name_1 = ac.getName();
            _builder.append(_name_1, "");
            _builder.append(".MAX");
            _builder.append(aVarName, "");
          } else {
            _builder.append("null");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private HashSet<DataClass> getDynConfigDataClasses(final Iterable<ActorInstance> ais) {
    HashSet<DataClass> _hashSet = new HashSet<DataClass>();
    final HashSet<DataClass> result = _hashSet;
    final Procedure1<ActorInstance> _function = new Procedure1<ActorInstance>() {
        public void apply(final ActorInstance ai) {
          List<Attribute> _dynConfigReadAttributes = VariableServiceGen.this.configExt.getDynConfigReadAttributes(ai);
          final Procedure1<Attribute> _function = new Procedure1<Attribute>() {
              public void apply(final Attribute a) {
                RefableType _refType = a.getRefType();
                DataType _type = _refType.getType();
                boolean _isDataClass = VariableServiceGen.this._typeHelpers.isDataClass(_type);
                if (_isDataClass) {
                  RefableType _refType_1 = a.getRefType();
                  DataType _type_1 = _refType_1.getType();
                  result.add(((DataClass) _type_1));
                }
              }
            };
          IterableExtensions.<Attribute>forEach(_dynConfigReadAttributes, _function);
        }
      };
    IterableExtensions.<ActorInstance>forEach(ais, _function);
    return result;
  }
  
  private HashSet<DataClass> getAllDataClasses(final Iterable<DataClass> dcs) {
    HashSet<DataClass> _hashSet = new HashSet<DataClass>();
    final HashSet<DataClass> result = _hashSet;
    Iterables.<DataClass>addAll(result, dcs);
    LinkedList<DataClass> _linkedList = new LinkedList<DataClass>();
    final LinkedList<DataClass> visit = _linkedList;
    Iterables.<DataClass>addAll(visit, dcs);
    boolean _isEmpty = visit.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      {
        DataClass dc = visit.pop();
        List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(dc);
        final Procedure1<Attribute> _function = new Procedure1<Attribute>() {
            public void apply(final Attribute a) {
              RefableType _refType = a.getRefType();
              DataType _type = _refType.getType();
              boolean _isDataClass = VariableServiceGen.this._typeHelpers.isDataClass(_type);
              if (_isDataClass) {
                RefableType _refType_1 = a.getRefType();
                DataType _type_1 = _refType_1.getType();
                visit.add(((DataClass) _type_1));
              }
            }
          };
        IterableExtensions.<Attribute>forEach(_allAttributes, _function);
      }
      boolean _isEmpty_1 = visit.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
    return result;
  }
  
  private HashSet<RoomModel> getRoomModels(final Collection<ActorInstance> ais) {
    HashSet<RoomModel> _hashSet = new HashSet<RoomModel>();
    final HashSet<RoomModel> models = _hashSet;
    final Procedure1<ActorInstance> _function = new Procedure1<ActorInstance>() {
        public void apply(final ActorInstance ai) {
          ActorClass _actorClass = ai.getActorClass();
          EObject _eContainer = _actorClass.eContainer();
          models.add(((RoomModel) _eContainer));
        }
      };
    IterableExtensions.<ActorInstance>forEach(ais, _function);
    return models;
  }
  
  private String toAbsolutePath(final List<Attribute> path, final String pathDelim) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute p : path) {
        _builder.append(pathDelim, "");
        String _name = p.getName();
        _builder.append(_name, "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  private CharSequence getVarName(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _path = ai.getPath();
      String[] _split = _path.split("/");
      Iterable<String> _drop = IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(_split)), 2);
      boolean _hasElements = false;
      for(final String p : _drop) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("_", "");
        }
        _builder.append(p, "");
      }
    }
    return _builder;
  }
  
  private CharSequence genGetAttributeValues(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      final Attribute a = IterableExtensions.<Attribute>last(path);
      CharSequence _xifexpression = null;
      RefableType _refType = a.getRefType();
      DataType _type = _refType.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
      if (_isPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("values.put(\"");
        String _path = ai.getPath();
        _builder.append(_path, "");
        String _absolutePath = this.toAbsolutePath(path, "/");
        _builder.append(_absolutePath, "");
        _builder.append("\", ");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("toObjectArray(");
          }
        }
        CharSequence _varName = this.getVarName(ai);
        _builder.append(_varName, "");
        _builder.append(".");
        CharSequence _invokeGetters = this.helpers.invokeGetters(path, null);
        _builder.append(_invokeGetters, "");
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
        RefableType _refType_1 = a.getRefType();
        DataType _type_1 = _refType_1.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_1);
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            DataClass dataClass = ((DataClass) _type_2);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                List<Attribute> _union = this.roomExt.<Attribute>union(path, at);
                CharSequence _genGetAttributeValues = this.genGetAttributeValues(_union, ai);
                _builder_1.append(_genGetAttributeValues, "");
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
  
  private CharSequence genSetAttributeValues1(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      String aVarName = this.toAbsolutePath(path, "_");
      CharSequence _xifexpression = null;
      RefableType _refType = a.getRefType();
      DataType _type = _refType.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
      if (_isPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("id = \"");
        String _path = ai.getPath();
        _builder.append(_path, "");
        String _absolutePath = this.toAbsolutePath(path, "/");
        _builder.append(_absolutePath, "");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        {
          int _size = a.getSize();
          boolean _equals = (_size == 0);
          if (_equals) {
            RefableType _refType_1 = a.getRefType();
            DataType _type_1 = _refType_1.getType();
            String _typeName = this._typeHelpers.typeName(_type_1);
            String _wrapper = this.stdExt.toWrapper(_typeName);
            _builder.append(_wrapper, "");
          } else {
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            String _typeName_1 = this._typeHelpers.typeName(_type_2);
            _builder.append(_typeName_1, "");
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        _builder.append(aVarName, "");
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("object = values.get(id);");
        _builder.newLine();
        _builder.append("if(object != null){");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(aVarName, "	");
        _builder.append(" = ensure");
        RefableType _refType_3 = a.getRefType();
        DataType _type_3 = _refType_3.getType();
        String _typeName_2 = this._typeHelpers.typeName(_type_3);
        String _firstUpper = StringExtensions.toFirstUpper(_typeName_2);
        _builder.append(_firstUpper, "	");
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
            _builder.append(_size_3, "	");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        ActorClass _actorClass = ai.getActorClass();
        CharSequence _genMinMaxCheck = this.genMinMaxCheck(path, _actorClass);
        _builder.append(_genMinMaxCheck, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(!");
        {
          int _size_4 = a.getSize();
          boolean _equals_1 = (_size_4 == 0);
          if (_equals_1) {
            _builder.append(aVarName, "	");
            _builder.append(".equals(");
          } else {
            _builder.append("Arrays.equals(");
            _builder.append(aVarName, "	");
            _builder.append(", ");
          }
        }
        _builder.append("(");
        {
          int _size_5 = a.getSize();
          boolean _equals_2 = (_size_5 == 0);
          if (_equals_2) {
            RefableType _refType_4 = a.getRefType();
            DataType _type_4 = _refType_4.getType();
            String _typeName_3 = this._typeHelpers.typeName(_type_4);
            String _wrapper_1 = this.stdExt.toWrapper(_typeName_3);
            _builder.append(_wrapper_1, "	");
          } else {
            RefableType _refType_5 = a.getRefType();
            DataType _type_5 = _refType_5.getType();
            String _typeName_4 = this._typeHelpers.typeName(_type_5);
            _builder.append(_typeName_4, "	");
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
        RefableType _refType_6 = a.getRefType();
        DataType _type_6 = _refType_6.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_6);
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            RefableType _refType_7 = a.getRefType();
            DataType _type_7 = _refType_7.getType();
            DataClass dataClass = ((DataClass) _type_7);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                List<Attribute> _union = this.roomExt.<Attribute>union(path, at);
                CharSequence _genSetAttributeValues1 = this.genSetAttributeValues1(_union, ai);
                _builder_1.append(_genSetAttributeValues1, "");
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
  
  private CharSequence genSetAttributeValues2(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      String aVarName = this.toAbsolutePath(path, "_");
      CharSequence _xifexpression = null;
      RefableType _refType = a.getRefType();
      DataType _type = _refType.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
      if (_isPrimitive) {
        CharSequence _xblockexpression_1 = null;
        {
          String _xifexpression_1 = null;
          int _size = path.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            int _size_1 = path.size();
            int _minus = (_size_1 - 1);
            Iterable<Attribute> _take = IterableExtensions.<Attribute>take(path, _minus);
            CharSequence _invokeGetters = this.helpers.invokeGetters(_take, null);
            String _plus = (_invokeGetters + ".");
            _xifexpression_1 = _plus;
          } else {
            _xifexpression_1 = "";
          }
          final String getters = _xifexpression_1;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("if(");
          _builder.append(aVarName, "");
          _builder.append(" != null){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _varName = this.getVarName(ai);
          _builder.append(_varName, "	");
          _builder.append(".");
          _builder.append(getters, "	");
          String _name = a.getName();
          CharSequence _invokeSetter = this.helpers.invokeSetter(_name, null, aVarName);
          _builder.append(_invokeSetter, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("getDiffMap().put(\"");
          String _path = ai.getPath();
          _builder.append(_path, "	");
          String _absolutePath = this.toAbsolutePath(path, "/");
          _builder.append(_absolutePath, "	");
          _builder.append("\", ");
          _builder.append(aVarName, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _xblockexpression_1 = (_builder);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        RefableType _refType_1 = a.getRefType();
        DataType _type_1 = _refType_1.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_1);
        if (_isDataClass) {
          CharSequence _xblockexpression_2 = null;
          {
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            final DataClass dataClass = ((DataClass) _type_2);
            StringConcatenation _builder = new StringConcatenation();
            {
              List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(dataClass);
              for(final Attribute at : _allAttributes) {
                List<Attribute> _union = this.roomExt.<Attribute>union(path, at);
                CharSequence _genSetAttributeValues2 = this.genSetAttributeValues2(_union, ai);
                _builder.append(_genSetAttributeValues2, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _xblockexpression_2 = (_builder);
          }
          _xifexpression_1 = _xblockexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
