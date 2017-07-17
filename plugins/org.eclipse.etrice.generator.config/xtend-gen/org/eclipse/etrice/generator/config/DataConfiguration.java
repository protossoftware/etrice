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
package org.eclipse.etrice.generator.config;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.ConfigStandaloneSetup;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.common.base.NumberLiteral;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigValue;
import org.eclipse.etrice.core.config.ConfigValueArray;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.EnumConfigValue;
import org.eclipse.etrice.core.config.LiteralConfigValue;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.config.util.DataConfigurationHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DataConfiguration implements IDataConfiguration {
  @Inject
  @Extension
  protected DataConfigurationHelper _dataConfigurationHelper;
  
  @Inject
  protected ILogger logger;
  
  @Inject
  protected ImportUriResolver uriResolver;
  
  @Override
  public void doSetup() {
    if ((!EMFPlugin.IS_ECLIPSE_RUNNING)) {
      ConfigStandaloneSetup.doSetup();
    }
  }
  
  @Override
  public boolean setResources(final ResourceSet resource, final ILogger logger) {
    return this._dataConfigurationHelper.setConfigModels(resource, logger);
  }
  
  @Override
  public String getAttrClassConfigValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    ConfigValueArray _value = null;
    if (_attrClassConfig!=null) {
      _value=_attrClassConfig.getValue();
    }
    String _stringExpr = null;
    if (_value!=null) {
      _stringExpr=this.toStringExpr(_value);
    }
    return _stringExpr;
  }
  
  @Override
  public String getAttrClassConfigMaxValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _max = null;
    if (_attrClassConfig!=null) {
      _max=_attrClassConfig.getMax();
    }
    String _stringExpr = null;
    if (_max!=null) {
      _stringExpr=this.toStringExpr(_max);
    }
    return _stringExpr;
  }
  
  @Override
  public String getAttrClassConfigMinValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _min = null;
    if (_attrClassConfig!=null) {
      _min=_attrClassConfig.getMin();
    }
    String _stringExpr = null;
    if (_min!=null) {
      _stringExpr=this.toStringExpr(_min);
    }
    return _stringExpr;
  }
  
  private AttrClassConfig getAttrClassConfig(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _name = actor.getName();
      _builder.append(_name, "");
      _builder.append("/");
      String _stringPath = this.toStringPath(path);
      _builder.append(_stringPath, "");
      String id = _builder.toString();
      _xblockexpression = this._dataConfigurationHelper.actorClassAttrMap.get(id);
    }
    return _xblockexpression;
  }
  
  @Override
  public String getAttrClassConfigValue(final ProtocolClass pc, final boolean regular, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _name = pc.getName();
      _builder.append(_name, "");
      _builder.append("/");
      {
        if (regular) {
          _builder.append("regular");
        } else {
          _builder.append("conjugated");
        }
      }
      _builder.append("/");
      String _stringPath = this.toStringPath(path);
      _builder.append(_stringPath, "");
      String id = _builder.toString();
      AttrClassConfig _get = this._dataConfigurationHelper.protocolClassAttrMap.get(id);
      ConfigValueArray _value = null;
      if (_get!=null) {
        _value=_get.getValue();
      }
      String _stringExpr = null;
      if (_value!=null) {
        _stringExpr=this.toStringExpr(_value);
      }
      _xblockexpression = _stringExpr;
    }
    return _xblockexpression;
  }
  
  private String toStringPath(final List<Attribute> path) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : path) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("/", "");
        }
        String _name = a.getName();
        _builder.append(_name, "");
      }
    }
    return _builder.toString();
  }
  
  @Override
  public String getAttrInstanceConfigValue(final ActorInstance ai, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      String _path = ai.getPath();
      String _plus = (_path + "/");
      String _stringPath = this.toStringPath(path);
      String id = (_plus + _stringPath);
      AttrInstanceConfig _get = this._dataConfigurationHelper.actorInstanceAttrMap.get(id);
      ConfigValueArray _value = null;
      if (_get!=null) {
        _value=_get.getValue();
      }
      String _stringExpr = null;
      if (_value!=null) {
        _stringExpr=this.toStringExpr(_value);
      }
      _xblockexpression = _stringExpr;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getAttrInstanceConfigValue(final InterfaceItemInstance item, final List<Attribute> path) {
    String _path = item.getPath();
    String _plus = (_path + "/");
    String _stringPath = this.toStringPath(path);
    String _plus_1 = (_plus + _stringPath);
    AttrInstanceConfig _get = this._dataConfigurationHelper.actorInstanceAttrMap.get(_plus_1);
    ConfigValueArray _value = null;
    if (_get!=null) {
      _value=_get.getValue();
    }
    String _stringExpr = null;
    if (_value!=null) {
      _stringExpr=this.toStringExpr(_value);
    }
    return _stringExpr;
  }
  
  @Override
  public long getPollingTimerUser(final SubSystemInstance subsystem) {
    long _xblockexpression = (long) 0;
    {
      SubSystemConfig _config = this.getConfig(subsystem);
      DynamicConfig _dynConfig = null;
      if (_config!=null) {
        _dynConfig=_config.getDynConfig();
      }
      final DynamicConfig dynConf = _dynConfig;
      long _xifexpression = (long) 0;
      boolean _equals = Objects.equal(dynConf, null);
      if (_equals) {
        _xifexpression = 0;
      } else {
        _xifexpression = dynConf.getPolling();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getUserCode1(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig _dynConfig = null;
    if (_config!=null) {
      _dynConfig=_config.getDynConfig();
    }
    DynamicConfig dynConfig = _dynConfig;
    String _xifexpression = null;
    String _filePath = null;
    if (dynConfig!=null) {
      _filePath=dynConfig.getFilePath();
    }
    boolean _notEquals = (!Objects.equal(_filePath, null));
    if (_notEquals) {
      _xifexpression = "import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;";
    } else {
      String _userCode1 = null;
      if (dynConfig!=null) {
        _userCode1=dynConfig.getUserCode1();
      }
      _xifexpression = _userCode1;
    }
    return _xifexpression;
  }
  
  @Override
  public String getUserCode2(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig _dynConfig = null;
    if (_config!=null) {
      _dynConfig=_config.getDynConfig();
    }
    DynamicConfig dynConfig = _dynConfig;
    String _xifexpression = null;
    String _filePath = null;
    if (dynConfig!=null) {
      _filePath=dynConfig.getFilePath();
    }
    boolean _notEquals = (!Objects.equal(_filePath, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new ConfigSourceFile(\"");
      String _filePath_1 = dynConfig.getFilePath();
      _builder.append(_filePath_1, "");
      _builder.append("\")");
      _xifexpression = _builder.toString();
    } else {
      String _userCode2 = null;
      if (dynConfig!=null) {
        _userCode2=dynConfig.getUserCode2();
      }
      _xifexpression = _userCode2;
    }
    return _xifexpression;
  }
  
  @Override
  public List<Attribute> getDynConfigReadAttributes(final ActorInstance ai) {
    final ArrayList<Attribute> result = new ArrayList<Attribute>();
    String _path = ai.getPath();
    List<AttrInstanceConfig> configs = this._dataConfigurationHelper.dynActorInstanceAttrMap.get(_path);
    if (configs!=null) {
      final Consumer<AttrInstanceConfig> _function = (AttrInstanceConfig c) -> {
        boolean _isReadOnly = c.isReadOnly();
        if (_isReadOnly) {
          Attribute _attribute = c.getAttribute();
          result.add(_attribute);
        }
      };
      configs.forEach(_function);
    }
    return result;
  }
  
  @Override
  public List<Attribute> getDynConfigWriteAttributes(final ActorInstance ai) {
    final ArrayList<Attribute> result = new ArrayList<Attribute>();
    String _path = ai.getPath();
    List<AttrInstanceConfig> configs = this._dataConfigurationHelper.dynActorInstanceAttrMap.get(_path);
    if (configs!=null) {
      final Consumer<AttrInstanceConfig> _function = (AttrInstanceConfig c) -> {
        boolean _isReadOnly = c.isReadOnly();
        boolean _not = (!_isReadOnly);
        if (_not) {
          Attribute _attribute = c.getAttribute();
          result.add(_attribute);
        }
      };
      configs.forEach(_function);
    }
    return result;
  }
  
  @Override
  public boolean hasVariableService(final SubSystemInstance subsystem) {
    SubSystemConfig _config = this.getConfig(subsystem);
    DynamicConfig _dynConfig = null;
    if (_config!=null) {
      _dynConfig=_config.getDynConfig();
    }
    return (!Objects.equal(_dynConfig, null));
  }
  
  private String toStringExpr(final ConfigValueArray literal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ConfigValue> _values = literal.getValues();
      boolean _hasElements = false;
      for(final ConfigValue l : _values) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _stringExpr = this.toStringExpr(l);
        _builder.append(_stringExpr, "");
      }
    }
    return _builder.toString();
  }
  
  private String toStringExpr(final ConfigValue configValue) {
    String _switchResult = null;
    boolean _matched = false;
    if (configValue instanceof LiteralConfigValue) {
      _matched=true;
      Literal _value = ((LiteralConfigValue)configValue).getValue();
      _switchResult = this.toStringExpr(_value);
    }
    if (!_matched) {
      if (configValue instanceof EnumConfigValue) {
        _matched=true;
        EnumLiteral _value = ((EnumConfigValue)configValue).getValue();
        _switchResult = _value.getFullName();
      }
    }
    return _switchResult;
  }
  
  private String toStringExpr(final Literal literal) {
    String _switchResult = null;
    boolean _matched = false;
    if (literal instanceof BooleanLiteral) {
      _matched=true;
      boolean _isIsTrue = ((BooleanLiteral)literal).isIsTrue();
      _switchResult = Boolean.valueOf(_isIsTrue).toString();
    }
    if (!_matched) {
      if (literal instanceof IntLiteral) {
        _matched=true;
        long _value = ((IntLiteral)literal).getValue();
        _switchResult = Long.valueOf(_value).toString();
      }
    }
    if (!_matched) {
      if (literal instanceof RealLiteral) {
        _matched=true;
        double _value = ((RealLiteral)literal).getValue();
        _switchResult = Double.valueOf(_value).toString();
      }
    }
    if (!_matched) {
      if (literal instanceof StringLiteral) {
        _matched=true;
        String _value = ((StringLiteral)literal).getValue();
        _switchResult = _value.toString();
      }
    }
    return _switchResult;
  }
  
  private SubSystemConfig getConfig(final SubSystemInstance cc) {
    String _path = cc.getPath();
    return this._dataConfigurationHelper.subSystemConfigMap.get(_path);
  }
  
  @Override
  public List<Attribute> getDynConfigReadAttributes(final ActorClass actor) {
    final HashSet<Attribute> result = new HashSet<Attribute>();
    final List<AttrInstanceConfig> configs = this._dataConfigurationHelper.dynActorClassAttrMap.get(actor);
    if (configs!=null) {
      final Consumer<AttrInstanceConfig> _function = (AttrInstanceConfig c) -> {
        boolean _isReadOnly = c.isReadOnly();
        if (_isReadOnly) {
          Attribute _attribute = c.getAttribute();
          result.add(_attribute);
        }
      };
      configs.forEach(_function);
    }
    return IterableExtensions.<Attribute>toList(result);
  }
  
  @Override
  public List<Attribute> getDynConfigWriteAttributes(final ActorClass actor) {
    final HashSet<Attribute> result = new HashSet<Attribute>();
    final List<AttrInstanceConfig> configs = this._dataConfigurationHelper.dynActorClassAttrMap.get(actor);
    if (configs!=null) {
      final Consumer<AttrInstanceConfig> _function = (AttrInstanceConfig c) -> {
        boolean _isReadOnly = c.isReadOnly();
        boolean _not = (!_isReadOnly);
        if (_not) {
          Attribute _attribute = c.getAttribute();
          result.add(_attribute);
        }
      };
      configs.forEach(_function);
    }
    return IterableExtensions.<Attribute>toList(result);
  }
}
