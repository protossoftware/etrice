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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
      HashMap<ActorInstance,List<Attribute>> _hashMap = new HashMap<ActorInstance, List<Attribute>>();
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
      _builder.append("package �comp.subSystemClass.getPackage()�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.Arrays;");
      _builder.newLine();
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.AbstractVariableService;");
      _builder.newLine();
      _builder.append("�configExt.getUserCode1(comp)�");
      _builder.newLine();
      _builder.append("�FOR model : aisAttrMap.keySet.roomModels�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import �model.name�.*;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �clsname�VariableService extends AbstractVariableService{");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private �clsname� subSystem;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// Actor instances");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR ai : aisAttrMap.keySet�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private �ai.actorClass.name� �ai.varName�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �clsname�VariableService(�clsname� subSystem) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(�configExt.getUserCode2(comp)�);");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.append("�FOR ai : aisAttrMap.keySet�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ai.varName� = (�ai.actorClass.name�)subSystem.getInstance(\"�ai.path�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.append("�FOR ai : aisAttrMap.keySet�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR a : aisAttrMap.get(ai)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("try{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("boolean changed = false;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�genSetAttributeValues1(new ArrayList<Attribute>.union(a), ai)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if(changed)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("synchronized(�ai.varName�.�invokeGetter(a.name+\"Lock\", null)�){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(�ai.varName�.�invokeGetter(a.name+\"Lock\", null)�.isUpdate()){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�genSetAttributeValues2(new ArrayList<Attribute>.union(a), ai)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}catch(IllegalArgumentException e){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("error(id, e);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
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
      _builder.append("protected Map<String, Object> getAttributeValues(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<String, Object> values = new HashMap<String, Object>();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ai : aisAttrMap.keySet�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR a : aisAttrMap.get(ai)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�genGetAttributeValues(new ArrayList<Attribute>.union(a), ai)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("�var dataClasses = aisAttrMap.keySet.dynConfigDataClasses�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR dc : dataClasses�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if(dcObject.getClass().equals(�dc.typeName�.class))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("writeDataClass(id, (�dc.typeName�) dcObject, writeTasks);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("\t");
      _builder.append("�FOR dc : getAllDataClasses(dataClasses)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private void writeDataClass(String id, �dc.typeName� object, Map<String, Object> map){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR a : dc.allAttributes�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF a.type.type.primitive�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("map.put(id+\"/�a.name�\", �IF a.size>0�toObjectArray(�ENDIF�object.�invokeGetter(a.name, null)��IF a.size>0�)�ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("writeDataClass(id+\"/�a.name�\", object.�invokeGetter(a.name, null)�, map);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected int getPollingTimerUser(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return �configExt.getPollingTimerUser(comp)�;");
      _builder.newLine();
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
        _builder.append("�IF a.size>0�for(�a.type.type.typeName� e : �aVarName�)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDIF�checkMinMax(�IF a.size>0�e�ELSE��aVarName��ENDIF�, �IF min��ac.name�.MIN�aVarName��ELSE�null�ENDIF�, �IF max��ac.name�.MAX�aVarName��ELSE�null�ENDIF�);");
        _builder.newLine();
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
            RefableType _type = a.getType();
            DataType _type_1 = _type.getType();
            boolean _isDataClass = VariableServiceGen.this._typeHelpers.isDataClass(_type_1);
            if (_isDataClass) {
              RefableType _type_2 = a.getType();
              DataType _type_3 = _type_2.getType();
              result.add(((DataClass) _type_3));
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
            RefableType _type = a.getType();
            DataType _type_1 = _type.getType();
            boolean _isDataClass = VariableServiceGen.this._typeHelpers.isDataClass(_type_1);
            if (_isDataClass) {
              RefableType _type_2 = a.getType();
              DataType _type_3 = _type_2.getType();
              visit.add(((DataClass) _type_3));
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
    _builder.append("�FOR p : path��pathDelim��p.name��ENDFOR�");
    String _string = _builder.toString();
    return _string;
  }
  
  private CharSequence getVarName(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR p : ai.path.split(\'/\').drop(2) SEPARATOR \'_\'��p��ENDFOR�");
    return _builder;
  }
  
  private CharSequence genGetAttributeValues(final List<Attribute> path, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      final Attribute a = IterableExtensions.<Attribute>last(path);
      CharSequence _xifexpression = null;
      RefableType _type = a.getType();
      DataType _type_1 = _type.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type_1);
      if (_isPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("values.put(\"�ai.path��path.toAbsolutePath(\'/\')�\", �IF a.size>0�toObjectArray(�ENDIF��ai.varName�.�path.invokeGetters(null)��IF a.size>0�)�ENDIF�);");
        _builder.newLine();
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        RefableType _type_2 = a.getType();
        DataType _type_3 = _type_2.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_3);
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            RefableType _type_4 = a.getType();
            DataType _type_5 = _type_4.getType();
            DataClass dataClass = ((DataClass) _type_5);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("�FOR at : dataClass.allAttributes�");
            _builder_1.newLine();
            _builder_1.append("\t");
            _builder_1.append("�genGetAttributeValues(path.union(at), ai)�");
            _builder_1.newLine();
            _builder_1.append("�ENDFOR�");
            _builder_1.newLine();
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
      RefableType _type = a.getType();
      DataType _type_1 = _type.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type_1);
      if (_isPrimitive) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("id = \"�ai.path��path.toAbsolutePath(\"/\")�\";");
        _builder.newLine();
        _builder.append("�IF a.size==0��a.type.type.typeName.toWrapper��ELSE��a.type.type.typeName�[]�ENDIF� �aVarName� = null;");
        _builder.newLine();
        _builder.append("object = values.get(id);");
        _builder.newLine();
        _builder.append("if(object != null){");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�aVarName� = ensure�a.type.type.typeName.toFirstUpper��IF a.size>0�Array�ENDIF�(object�IF a.size>0�, �a.size��ENDIF�);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�genMinMaxCheck(path, ai.actorClass)�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(!�IF a.size==0��aVarName�.equals(�ELSE�Arrays.equals(�aVarName�, �ENDIF�(�IF a.size==0��a.type.type.typeName.toWrapper��ELSE��a.type.type.typeName�[]�ENDIF�)getDiffMap().get(id)))");
        _builder.newLine();
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
        RefableType _type_2 = a.getType();
        DataType _type_3 = _type_2.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_3);
        if (_isDataClass) {
          CharSequence _xblockexpression_1 = null;
          {
            RefableType _type_4 = a.getType();
            DataType _type_5 = _type_4.getType();
            DataClass dataClass = ((DataClass) _type_5);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("�FOR at : dataClass.allAttributes�");
            _builder_1.newLine();
            _builder_1.append("\t");
            _builder_1.append("�genSetAttributeValues1(path.union(at), ai)�");
            _builder_1.newLine();
            _builder_1.append("�ENDFOR�");
            _builder_1.newLine();
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
      RefableType _type = a.getType();
      DataType _type_1 = _type.getType();
      boolean _isPrimitive = this._typeHelpers.isPrimitive(_type_1);
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
          _builder.append("if(�aVarName� != null){");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ai.varName�.�getters��invokeSetter(a.name, null, aVarName)�;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("getDiffMap().put(\"�ai.path��path.toAbsolutePath(\"/\")�\", �aVarName�);");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _xblockexpression_1 = (_builder);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        RefableType _type_2 = a.getType();
        DataType _type_3 = _type_2.getType();
        boolean _isDataClass = this._typeHelpers.isDataClass(_type_3);
        if (_isDataClass) {
          CharSequence _xblockexpression_2 = null;
          {
            RefableType _type_4 = a.getType();
            DataType _type_5 = _type_4.getType();
            final DataClass dataClass = ((DataClass) _type_5);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("�FOR at : dataClass.allAttributes�");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("�genSetAttributeValues2(path.union(at), ai)�");
            _builder.newLine();
            _builder.append("�ENDFOR�");
            _builder.newLine();
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
