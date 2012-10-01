package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.genmodel.base.ILogger;
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
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class VariableServiceGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ConfigExtension configExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root, final SubSystemInstance ssi) {
    SubSystemClass _subSystemClass = ssi.getSubSystemClass();
    String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
    SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
    String _path = this.roomExt.getPath(_subSystemClass_1);
    String path = (_generationTargetPath + _path);
    SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
    String _name = _subSystemClass_2.getName();
    String file = (_name + "VariableService.java");
    String _plus = ("generating VariableService implementation: \'" + file);
    String _plus_1 = (_plus + "\' in \'");
    String _plus_2 = (_plus_1 + path);
    String _plus_3 = (_plus_2 + "\'");
    this.logger.logInfo(_plus_3);
    this.fileAccess.setOutputPath(path);
    SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
    CharSequence _generate = this.generate(root, ssi, _subSystemClass_3);
    this.fileAccess.generateFile(file, _generate);
  }
  
  private CharSequence generate(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    SubSystemConfig _subSystemConfig = this.configExt.getSubSystemConfig(cc);
    final DynamicConfig dynConfig = _subSystemConfig.getDynConfig();
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _package = this.roomExt.getPackage(cc);
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
    _builder.append("import org.eclipse.etrice.runtime.java.config.VariableService;");
    _builder.newLine();
    {
      String _userCode1 = dynConfig.getUserCode1();
      boolean _notEquals = (!Objects.equal(_userCode1, null));
      if (_notEquals) {
        String _userCode1_1 = dynConfig.getUserCode1();
        _builder.append(_userCode1_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;");
        _builder.newLine();
      }
    }
    List<ActorInstance> ais = this.dynConfigsAIs(comp);
    _builder.newLineIfNotEmpty();
    {
      HashSet<RoomModel> _roomModels = this.getRoomModels(ais);
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
    String _name_1 = comp.getName();
    String _plus = (_name_1 + "VariableService");
    _builder.append(_plus, "");
    _builder.append(" extends VariableService{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    String _name_2 = cc.getName();
    _builder.append(_name_2, "	");
    _builder.append(" subSystem;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Actor instances");
    _builder.newLine();
    {
      for(final ActorInstance ai : ais) {
        _builder.append("\t");
        _builder.append("private ");
        ActorClass _actorClass = ai.getActorClass();
        String _name_3 = _actorClass.getName();
        _builder.append(_name_3, "	");
        _builder.append(" ");
        String _path = ai.getPath();
        String[] _split = _path.split("/");
        Iterable<String> _drop = IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(_split)), 2);
        String _path_1 = this.configExt.toPath(_drop, "_");
        _builder.append(_path_1, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_4 = comp.getName();
    String _plus_1 = (_name_4 + "VariableService");
    _builder.append(_plus_1, "	");
    _builder.append("(");
    String _name_5 = cc.getName();
    _builder.append(_name_5, "	");
    _builder.append(" subSystem) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    {
      String _filePath = dynConfig.getFilePath();
      boolean _notEquals_1 = (!Objects.equal(_filePath, null));
      if (_notEquals_1) {
        _builder.append("new ConfigSourceFile(\"");
        String _filePath_1 = dynConfig.getFilePath();
        _builder.append(_filePath_1, "		");
        _builder.append("\")");
      } else {
        String _userCode2 = dynConfig.getUserCode2();
        _builder.append(_userCode2, "		");
      }
    }
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
      for(final ActorInstance ai_1 : ais) {
        _builder.append("\t\t");
        String _path_2 = ai_1.getPath();
        String[] _split_1 = _path_2.split("/");
        Iterable<String> _drop_1 = IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(_split_1)), 2);
        String _path_3 = this.configExt.toPath(_drop_1, "_");
        _builder.append(_path_3, "		");
        _builder.append(" = (");
        ActorClass _actorClass_1 = ai_1.getActorClass();
        String _name_6 = _actorClass_1.getName();
        _builder.append(_name_6, "		");
        _builder.append(")subSystem.getInstance(\"");
        String _path_4 = ai_1.getPath();
        _builder.append(_path_4, "		");
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
    {
      Iterable<AttrInstanceConfig> _attrDynConfigs = this.configExt.getAttrDynConfigs(cc, true, false);
      for(final AttrInstanceConfig attrConfig : _attrDynConfigs) {
        _builder.append("\t\t");
        EObject _eContainer = attrConfig.eContainer();
        RefPath _path_5 = ((ActorInstanceConfig) _eContainer).getPath();
        EList<String> _refs = _path_5.getRefs();
        String aiName = this.configExt.toPath(_refs, "_");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("try{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("boolean changed = false;");
        _builder.newLine();
        {
          Map<Attribute,List<String>> _allAttributes = this.getAllAttributes(attrConfig);
          Set<Entry<Attribute,List<String>>> _entrySet = _allAttributes.entrySet();
          for(final Entry<Attribute,List<String>> entry : _entrySet) {
            _builder.append("\t\t");
            _builder.append("\t");
            Attribute a = entry.getKey();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            List<String> _path_6 = this.configExt.getPath(attrConfig, true, true, true, false);
            String _path_7 = this.configExt.toPath(_path_6, "/");
            List<String> _value = entry.getValue();
            String _path_8 = this.configExt.toPath(_value, "/");
            String _plus_2 = (_path_7 + _path_8);
            String _plus_3 = (_plus_2 + "/");
            String _name_7 = a.getName();
            String aPath = (_plus_3 + _name_7);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("id = \"");
            _builder.append(aPath, "			");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            {
              int _size = a.getSize();
              boolean _equals = (_size == 0);
              if (_equals) {
                RefableType _refType = a.getRefType();
                DataType _type = _refType.getType();
                String _typeName = this._typeHelpers.typeName(_type);
                String _wrapper = this.stdExt.toWrapper(_typeName);
                _builder.append(_wrapper, "			");
              } else {
                RefableType _refType_1 = a.getRefType();
                DataType _type_1 = _refType_1.getType();
                String _typeName_1 = this._typeHelpers.typeName(_type_1);
                _builder.append(_typeName_1, "			");
                _builder.append("[]");
              }
            }
            _builder.append(" _");
            String _name_8 = a.getName();
            _builder.append(_name_8, "			");
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("object = values.get(id);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if(object != null){");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("_");
            String _name_9 = a.getName();
            _builder.append(_name_9, "				");
            _builder.append(" = ensure");
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            String _typeName_2 = this._typeHelpers.typeName(_type_2);
            String _firstUpper = StringExtensions.toFirstUpper(_typeName_2);
            _builder.append(_firstUpper, "				");
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
                _builder.append(_size_3, "				");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            EObject _eContainer_1 = attrConfig.eContainer();
            ActorClassConfig _actorClassConfig = this.configExt.getActorClassConfig(((ActorInstanceConfig) _eContainer_1));
            CharSequence _genMinMaxCheck = this.genMinMaxCheck(attrConfig, _actorClassConfig);
            _builder.append(_genMinMaxCheck, "				");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if(!");
            {
              int _size_4 = a.getSize();
              boolean _equals_1 = (_size_4 == 0);
              if (_equals_1) {
                _builder.append("_");
                String _name_10 = a.getName();
                _builder.append(_name_10, "				");
                _builder.append(".equals(");
              } else {
                _builder.append("Arrays.equals(_");
                String _name_11 = a.getName();
                _builder.append(_name_11, "				");
                _builder.append(", ");
              }
            }
            _builder.append("(");
            {
              int _size_5 = a.getSize();
              boolean _equals_2 = (_size_5 == 0);
              if (_equals_2) {
                RefableType _refType_3 = a.getRefType();
                DataType _type_3 = _refType_3.getType();
                String _typeName_3 = this._typeHelpers.typeName(_type_3);
                String _wrapper_1 = this.stdExt.toWrapper(_typeName_3);
                _builder.append(_wrapper_1, "				");
              } else {
                RefableType _refType_4 = a.getRefType();
                DataType _type_4 = _refType_4.getType();
                String _typeName_4 = this._typeHelpers.typeName(_type_4);
                _builder.append(_typeName_4, "				");
                _builder.append("[]");
              }
            }
            _builder.append(")getDiffMap().get(id)))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("changed = true;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("} else");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("warning(id, \"is missing\");");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if(changed)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("synchronized(");
        _builder.append(aiName, "				");
        _builder.append(".");
        Attribute _attribute = attrConfig.getAttribute();
        String _name_12 = _attribute.getName();
        String _plus_4 = (_name_12 + "Lock");
        CharSequence _invokeGetter = this.helpers.invokeGetter(_plus_4, null);
        _builder.append(_invokeGetter, "				");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("if(");
        _builder.append(aiName, "					");
        _builder.append(".");
        Attribute _attribute_1 = attrConfig.getAttribute();
        String _name_13 = _attribute_1.getName();
        String _plus_5 = (_name_13 + "Lock");
        CharSequence _invokeGetter_1 = this.helpers.invokeGetter(_plus_5, null);
        _builder.append(_invokeGetter_1, "					");
        _builder.append(".isUpdate()){");
        _builder.newLineIfNotEmpty();
        {
          Map<Attribute,List<String>> _allAttributes_1 = this.getAllAttributes(attrConfig);
          Set<Entry<Attribute,List<String>>> _entrySet_1 = _allAttributes_1.entrySet();
          for(final Entry<Attribute,List<String>> entry_1 : _entrySet_1) {
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("if(_");
            Attribute _key = entry_1.getKey();
            String _name_14 = _key.getName();
            _builder.append(_name_14, "						");
            _builder.append(" != null){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append(aiName, "							");
            List<String> _value_1 = entry_1.getValue();
            String _invoke = this.toInvoke(_value_1);
            _builder.append(_invoke, "							");
            _builder.append(".");
            Attribute _key_1 = entry_1.getKey();
            String _name_15 = _key_1.getName();
            Attribute _key_2 = entry_1.getKey();
            String _name_16 = _key_2.getName();
            String _plus_6 = ("_" + _name_16);
            CharSequence _invokeSetter = this.helpers.invokeSetter(_name_15, null, _plus_6);
            _builder.append(_invokeSetter, "							");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("getDiffMap().put(\"");
            List<String> _path_9 = this.configExt.getPath(attrConfig, true, true, true, false);
            String _path_10 = this.configExt.toPath(_path_9, "/");
            List<String> _value_2 = entry_1.getValue();
            String _path_11 = this.configExt.toPath(_value_2, "/");
            String _plus_7 = (_path_10 + _path_11);
            String _plus_8 = (_plus_7 + "/");
            Attribute _key_3 = entry_1.getKey();
            String _name_17 = _key_3.getName();
            String _plus_9 = (_plus_8 + _name_17);
            _builder.append(_plus_9, "							");
            _builder.append("\", _");
            Attribute _key_4 = entry_1.getKey();
            String _name_18 = _key_4.getName();
            _builder.append(_name_18, "							");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("} ");
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
      Iterable<AttrInstanceConfig> _attrDynConfigs_1 = this.configExt.getAttrDynConfigs(cc, true, false);
      for(final AttrInstanceConfig attrConfig_1 : _attrDynConfigs_1) {
        _builder.append("\t\t");
        EObject _eContainer_2 = attrConfig_1.eContainer();
        RefPath _path_12 = ((ActorInstanceConfig) _eContainer_2).getPath();
        EList<String> _refs_1 = _path_12.getRefs();
        String aiName_1 = this.configExt.toPath(_refs_1, "_");
        _builder.newLineIfNotEmpty();
        {
          Map<Attribute,List<String>> _allAttributes_2 = this.getAllAttributes(attrConfig_1);
          Set<Entry<Attribute,List<String>>> _entrySet_2 = _allAttributes_2.entrySet();
          for(final Entry<Attribute,List<String>> entry_2 : _entrySet_2) {
            _builder.append("\t\t");
            Attribute _key_5 = entry_2.getKey();
            int _size_6 = _key_5.getSize();
            boolean array = (_size_6 > 0);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            List<String> _path_13 = this.configExt.getPath(attrConfig_1, true, true, true, false);
            String _path_14 = this.configExt.toPath(_path_13, "/");
            List<String> _value_3 = entry_2.getValue();
            String _path_15 = this.configExt.toPath(_value_3, "/");
            String _plus_10 = (_path_14 + _path_15);
            String _plus_11 = (_plus_10 + "/");
            Attribute _key_6 = entry_2.getKey();
            String _name_19 = _key_6.getName();
            String aPath_1 = (_plus_11 + _name_19);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("values.put(\"");
            _builder.append(aPath_1, "		");
            _builder.append("\", ");
            {
              if (array) {
                _builder.append("toObjectArray(");
              }
            }
            _builder.append(aiName_1, "		");
            List<String> _value_4 = entry_2.getValue();
            String _invoke_1 = this.toInvoke(_value_4);
            _builder.append(_invoke_1, "		");
            _builder.append(".");
            Attribute _key_7 = entry_2.getKey();
            String _name_20 = _key_7.getName();
            CharSequence _invokeGetter_2 = this.helpers.invokeGetter(_name_20, null);
            _builder.append(_invokeGetter_2, "		");
            {
              if (array) {
                _builder.append(")");
              }
            }
            _builder.append(");");
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
    {
      HashSet<DataClass> _dynDataClasses = this.getDynDataClasses(comp);
      for(final DataClass dc : _dynDataClasses) {
        _builder.append("\t\t");
        _builder.append("if(dcObject.getClass().equals(");
        String _typeName_5 = this._typeHelpers.typeName(dc);
        _builder.append(_typeName_5, "		");
        _builder.append(".class))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("writeDataClass(id, (");
        String _typeName_6 = this._typeHelpers.typeName(dc);
        _builder.append(_typeName_6, "			");
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
      HashSet<DataClass> _allDynDataClasses = this.getAllDynDataClasses(comp);
      for(final DataClass dc_1 : _allDynDataClasses) {
        _builder.append("\t");
        _builder.append("private void writeDataClass(String id, ");
        String _typeName_7 = this._typeHelpers.typeName(dc_1);
        _builder.append(_typeName_7, "	");
        _builder.append(" object, Map<String, Object> map){");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes = dc_1.getAttributes();
          for(final Attribute a_1 : _attributes) {
            {
              RefableType _refType_5 = a_1.getRefType();
              DataType _type_5 = _refType_5.getType();
              boolean _isPrimitive = this._typeHelpers.isPrimitive(_type_5);
              if (_isPrimitive) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("map.put(id+\"/");
                String _name_21 = a_1.getName();
                _builder.append(_name_21, "		");
                _builder.append("\", ");
                {
                  int _size_7 = a_1.getSize();
                  boolean _greaterThan_2 = (_size_7 > 0);
                  if (_greaterThan_2) {
                    _builder.append("toObjectArray(");
                  }
                }
                _builder.append("object.");
                String _name_22 = a_1.getName();
                CharSequence _invokeGetter_3 = this.helpers.invokeGetter(_name_22, null);
                _builder.append(_invokeGetter_3, "		");
                {
                  int _size_8 = a_1.getSize();
                  boolean _greaterThan_3 = (_size_8 > 0);
                  if (_greaterThan_3) {
                    _builder.append(")");
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("writeDataClass(id+\"/");
                String _name_23 = a_1.getName();
                _builder.append(_name_23, "		");
                _builder.append("\", object.");
                String _name_24 = a_1.getName();
                CharSequence _invokeGetter_4 = this.helpers.invokeGetter(_name_24, null);
                _builder.append(_invokeGetter_4, "		");
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
    int _polling = dynConfig.getPolling();
    _builder.append(_polling, "		");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence genMinMaxCheck(final AttrInstanceConfig instConf, final ActorClassConfig acConf) {
    CharSequence _xblockexpression = null;
    {
      List<String> _path = this.configExt.getPath(instConf, false, false, true, true);
      AttrClassConfig config = acConf==null?(AttrClassConfig)null:this.resolve(acConf, ((String[])Conversions.unwrapArray(_path, String.class)));
      boolean _and = false;
      NumberLiteral _min = config==null?(NumberLiteral)null:config.getMin();
      boolean _equals = Objects.equal(_min, null);
      if (!_equals) {
        _and = false;
      } else {
        NumberLiteral _max = config==null?(NumberLiteral)null:config.getMax();
        boolean _equals_1 = Objects.equal(_max, null);
        _and = (_equals && _equals_1);
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      }
      List<String> _path_1 = this.configExt.getPath(config, false, false, true, true);
      String path = this.configExt.toPath(_path_1, "_");
      EObject _eContainer = config.eContainer();
      ActorClass _actor = ((ActorClassConfig) _eContainer).getActor();
      String acName = _actor.getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("checkMinMax(_");
      Attribute _attribute = config.getAttribute();
      String _name = _attribute.getName();
      _builder_1.append(_name, "");
      _builder_1.append(", ");
      {
        NumberLiteral _min_1 = config.getMin();
        boolean _notEquals = (!Objects.equal(_min_1, null));
        if (_notEquals) {
          _builder_1.append(acName, "");
          _builder_1.append(".MIN");
          _builder_1.append(path, "");
        } else {
          _builder_1.append("null");
        }
      }
      _builder_1.append(", ");
      {
        NumberLiteral _max_1 = config.getMax();
        boolean _notEquals_1 = (!Objects.equal(_max_1, null));
        if (_notEquals_1) {
          _builder_1.append(acName, "");
          _builder_1.append(".MAX");
          _builder_1.append(path, "");
        } else {
          _builder_1.append("null");
        }
      }
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      _xblockexpression = (_builder_1);
    }
    return _xblockexpression;
  }
  
  private Map<Attribute,List<String>> getAllAttributes(final AttrInstanceConfig config) {
    HashMap<Attribute,List<String>> _hashMap = new HashMap<Attribute,List<String>>();
    HashMap<Attribute,List<String>> map = _hashMap;
    Attribute _attribute = config.getAttribute();
    RefableType _refType = _attribute.getRefType();
    DataType _type = _refType.getType();
    boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
    if (_isPrimitive) {
      Attribute _attribute_1 = config.getAttribute();
      ArrayList<String> _arrayList = new ArrayList<String>();
      map.put(_attribute_1, _arrayList);
    } else {
      Attribute _attribute_2 = config.getAttribute();
      LinkedList<String> _linkedList = new LinkedList<String>();
      this.getAllAttributes(_attribute_2, _linkedList, map);
    }
    return map;
  }
  
  private void getAllAttributes(final Attribute attribute, final List<String> path, final Map<Attribute,List<String>> map) {
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
    if (_isPrimitive) {
      map.put(attribute, path);
    } else {
      RefableType _refType_1 = attribute.getRefType();
      DataType _type_1 = _refType_1.getType();
      boolean _isDataClass = this._typeHelpers.isDataClass(_type_1);
      if (_isDataClass) {
        ArrayList<String> _arrayList = new ArrayList<String>(path);
        ArrayList<String> new_path = _arrayList;
        String _name = attribute.getName();
        new_path.add(_name);
        RefableType _refType_2 = attribute.getRefType();
        DataType _type_2 = _refType_2.getType();
        List<Attribute> _allAttributes = this.roomExt.getAllAttributes(((DataClass) _type_2));
        for (final Attribute dc : _allAttributes) {
          this.getAllAttributes(dc, new_path, map);
        }
      }
    }
  }
  
  private String toInvoke(final List<String> path) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder builder = _stringBuilder;
    for (final String p : path) {
      CharSequence _invokeGetter = this.helpers.invokeGetter(p, null);
      String _plus = ("." + _invokeGetter);
      builder.append(_plus);
    }
    return builder.toString();
  }
  
  private List<ActorInstance> dynConfigsAIs(final SubSystemInstance comp) {
    HashSet<String> _hashSet = new HashSet<String>();
    final HashSet<String> aiPaths = _hashSet;
    SubSystemClass _subSystemClass = comp.getSubSystemClass();
    Iterable<AttrInstanceConfig> _attrDynConfigs = this.configExt.getAttrDynConfigs(_subSystemClass, true, false);
    for (final AttrInstanceConfig attrConfig : _attrDynConfigs) {
      List<String> _path = this.configExt.getPath(attrConfig, true, true, false, false);
      String _path_1 = this.configExt.toPath(_path, "/");
      aiPaths.add(_path_1);
    }
    ArrayList<ActorInstance> _arrayList = new ArrayList<ActorInstance>();
    ArrayList<ActorInstance> ais = _arrayList;
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    for (final ActorInstance ai : _allContainedInstances) {
      String _path_2 = ai.getPath();
      boolean _contains = aiPaths.contains(_path_2);
      if (_contains) {
        ais.add(ai);
      }
    }
    return ais;
  }
  
  private HashSet<DataClass> getDynDataClasses(final SubSystemInstance comp) {
    HashSet<DataClass> _hashSet = new HashSet<DataClass>();
    HashSet<DataClass> dcs = _hashSet;
    SubSystemClass _subSystemClass = comp.getSubSystemClass();
    Iterable<AttrInstanceConfig> _attrDynConfigs = this.configExt.getAttrDynConfigs(_subSystemClass, false, true);
    for (final AttrInstanceConfig config : _attrDynConfigs) {
      Attribute _attribute = config.getAttribute();
      RefableType _refType = _attribute.getRefType();
      DataType _type = _refType.getType();
      boolean _isDataClass = this._typeHelpers.isDataClass(_type);
      if (_isDataClass) {
        Attribute _attribute_1 = config.getAttribute();
        RefableType _refType_1 = _attribute_1.getRefType();
        DataType _type_1 = _refType_1.getType();
        dcs.add(((DataClass) _type_1));
      }
    }
    return dcs;
  }
  
  private HashSet<DataClass> getAllDynDataClasses(final SubSystemInstance comp) {
    HashSet<DataClass> _hashSet = new HashSet<DataClass>();
    HashSet<DataClass> dcs = _hashSet;
    LinkedList<DataClass> _linkedList = new LinkedList<DataClass>();
    LinkedList<DataClass> stack = _linkedList;
    HashSet<DataClass> _dynDataClasses = this.getDynDataClasses(comp);
    stack.addAll(_dynDataClasses);
    Iterables.<DataClass>addAll(dcs, stack);
    boolean _isEmpty = stack.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      {
        DataClass dc = stack.pop();
        List<Attribute> _allAttributes = this.roomExt.getAllAttributes(dc);
        for (final Attribute a : _allAttributes) {
          RefableType _refType = a.getRefType();
          DataType _type = _refType.getType();
          boolean _isDataClass = this._typeHelpers.isDataClass(_type);
          if (_isDataClass) {
            RefableType _refType_1 = a.getRefType();
            DataType _type_1 = _refType_1.getType();
            dcs.add(((DataClass) _type_1));
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            stack.push(((DataClass) _type_2));
          }
        }
      }
      boolean _isEmpty_1 = stack.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
    return dcs;
  }
  
  private AttrClassConfig resolve(final ActorClassConfig config, final String[] path) {
    EList<AttrClassConfig> _attributes = config.getAttributes();
    final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
        public Boolean apply(final AttrClassConfig c) {
          Attribute _attribute = c.getAttribute();
          String _name = _attribute.getName();
          String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(path)));
          boolean _equals = _name.equals(_head);
          return Boolean.valueOf(_equals);
        }
      };
    AttrClassConfig result = IterableExtensions.<AttrClassConfig>findFirst(_attributes, _function);
    Iterable<String> _tail = IterableExtensions.<String>tail(((Iterable<String>)Conversions.doWrapArray(path)));
    for (final String ref : _tail) {
      {
        EList<AttrClassConfig> _attributes_1 = result==null?(EList<AttrClassConfig>)null:result.getAttributes();
        final Function1<AttrClassConfig,Boolean> _function_1 = new Function1<AttrClassConfig,Boolean>() {
            public Boolean apply(final AttrClassConfig c) {
              Attribute _attribute = c.getAttribute();
              String _name = _attribute.getName();
              boolean _equals = _name.equals(ref);
              return Boolean.valueOf(_equals);
            }
          };
        AttrClassConfig _findFirst = IterableExtensions.<AttrClassConfig>findFirst(_attributes_1, _function_1);
        result = _findFirst;
        boolean _equals = Objects.equal(result, null);
        if (_equals) {
          return null;
        }
      }
    }
    return result;
  }
  
  private HashSet<RoomModel> getRoomModels(final List<ActorInstance> ais) {
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
}
