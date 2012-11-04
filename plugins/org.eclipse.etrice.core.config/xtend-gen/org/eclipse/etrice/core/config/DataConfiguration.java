package org.eclipse.etrice.core.config;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.ConfigStandaloneSetup;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.BooleanLiteral;
import org.eclipse.etrice.core.config.DataConfigurationHelper;
import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.Literal;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DataConfiguration implements IDataConfiguration {
  public void doSetup() {
    ConfigStandaloneSetup.doSetup();
  }
  
  public boolean setResources(final ResourceSet resource, final ILogger logger) {
    boolean _setConfigModels = DataConfigurationHelper.setConfigModels(resource, logger);
    return _setConfigModels;
  }
  
  public String getAttrClassConfigValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    LiteralArray _value = _attrClassConfig==null?(LiteralArray)null:_attrClassConfig.getValue();
    String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
    return _stringExpr;
  }
  
  public String getAttrClassConfigMaxValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _min = _attrClassConfig==null?(NumberLiteral)null:_attrClassConfig.getMin();
    String _stringExpr = _min==null?(String)null:this.toStringExpr(_min);
    return _stringExpr;
  }
  
  public String getAttrClassConfigMinValue(final ActorClass actor, final List<Attribute> path) {
    AttrClassConfig _attrClassConfig = this.getAttrClassConfig(actor, path);
    NumberLiteral _max = _attrClassConfig==null?(NumberLiteral)null:_attrClassConfig.getMax();
    String _stringExpr = _max==null?(String)null:this.toStringExpr(_max);
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
      AttrClassConfig _get = DataConfigurationHelper.actorClassAttrMap.get(id);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
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
      AttrClassConfig _get = DataConfigurationHelper.protocolClassAttrMap.get(id);
      LiteralArray _value = _get==null?(LiteralArray)null:_get.getValue();
      String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
      _xblockexpression = (_stringExpr);
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
    String _string = _builder.toString();
    return _string;
  }
  
  public String getAttrInstanceConfigValue(final ActorInstance ai, final List<Attribute> path) {
    String _xblockexpression = null;
    {
      String _path = ai.getPath();
      String _plus = (_path + "/");
      String _stringPath = this.toStringPath(path);
      String id = (_plus + _stringPath);
      AttrInstanceConfig _get = DataConfigurationHelper.actorInstanceAttrMap.get(id);
      LiteralArray _value = _get==null?(LiteralArray)null:_get.getValue();
      String _stringExpr = _value==null?(String)null:this.toStringExpr(_value);
      _xblockexpression = (_stringExpr);
    }
    return _xblockexpression;
  }
  
  public List<Attribute> getAllDynConfigReadAttributes(final ActorClass actor) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    return _arrayList;
  }
  
  public List<Attribute> getAllDynConfigWriteAttributes(final ActorClass actor) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    return _arrayList;
  }
  
  public List<Attribute> getDynConfigReadAttributes(final SubSystemClass subsystem) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    return _arrayList;
  }
  
  public List<Attribute> getDynConfigWriteAttributes(final SubSystemClass subsystem) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    return _arrayList;
  }
  
  public boolean hasDynConfigReadAttributes(final ActorClass actor) {
    return false;
  }
  
  public boolean hasDynConfigWriteAttributes(final ActorClass actor) {
    return false;
  }
  
  public boolean hasVariableService(final SubSystemClass subsystem) {
    return false;
  }
  
  private String toStringExpr(final LiteralArray literal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Literal> _literals = literal.getLiterals();
      boolean _hasElements = false;
      for(final Literal l : _literals) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _stringExpr = this.toStringExpr(l);
        _builder.append(_stringExpr, "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  private String toStringExpr(final Literal literal) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (literal instanceof BooleanLiteral) {
        final BooleanLiteral _booleanLiteral = (BooleanLiteral)literal;
        _matched=true;
        boolean _isIsTrue = _booleanLiteral.isIsTrue();
        String _string = Boolean.valueOf(_isIsTrue).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof IntLiteral) {
        final IntLiteral _intLiteral = (IntLiteral)literal;
        _matched=true;
        long _value = _intLiteral.getValue();
        String _string = Long.valueOf(_value).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof RealLiteral) {
        final RealLiteral _realLiteral = (RealLiteral)literal;
        _matched=true;
        double _value = _realLiteral.getValue();
        String _string = Double.valueOf(_value).toString();
        _switchResult = _string;
      }
    }
    if (!_matched) {
      if (literal instanceof StringLiteral) {
        final StringLiteral _stringLiteral = (StringLiteral)literal;
        _matched=true;
        String _value = _stringLiteral.getValue();
        String _string = _value.toString();
        _switchResult = _string;
      }
    }
    return _switchResult;
  }
}
