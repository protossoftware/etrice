package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.BooleanLiteral;
import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.Literal;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.PortClassConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.ConfigHelper;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ConfigExtension {
  @Inject
  private ILanguageExtension languageExt;
  
  public String getInitValue(final Attribute a) {
    String value = this.getConfigDefaultValue(a);
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      String _defaultValueLiteral = a.getDefaultValueLiteral();
      value = _defaultValueLiteral;
    }
    return value;
  }
  
  public String getConfigDefaultValue(final Attribute attr) {
    EObject _eContainer = attr.eContainer();
    if ((_eContainer instanceof ActorClass)) {
      EObject _eContainer_1 = attr.eContainer();
      ActorClass ac = ((ActorClass) _eContainer_1);
      ActorClassConfig _classConfig = this.getClassConfig(ac);
      EList<AttrClassConfig> _attributes = _classConfig==null?(EList<AttrClassConfig>)null:_classConfig.getAttributes();
      return _attributes==null?(String)null:this.getConfigValue(_attributes, attr);
    } else {
      EObject _eContainer_2 = attr.eContainer();
      if ((_eContainer_2 instanceof PortClass)) {
        EObject _eContainer_3 = attr.eContainer();
        PortClass pc = ((PortClass) _eContainer_3);
        EObject _eContainer_4 = pc.eContainer();
        ProtocolClass protocol = ((ProtocolClass) _eContainer_4);
        ProtocolClassConfig prcConfig = this.getProtocolConfig(((ProtocolClass) protocol));
        PortClass _regular = protocol.getRegular();
        boolean _equals = pc.equals(_regular);
        if (_equals) {
          PortClassConfig _regular_1 = prcConfig==null?(PortClassConfig)null:prcConfig.getRegular();
          EList<AttrClassConfig> _attributes_1 = _regular_1==null?(EList<AttrClassConfig>)null:_regular_1.getAttributes();
          return _attributes_1==null?(String)null:this.getConfigValue(_attributes_1, attr);
        } else {
          PortClassConfig _conjugated = prcConfig==null?(PortClassConfig)null:prcConfig.getConjugated();
          EList<AttrClassConfig> _attributes_2 = _conjugated==null?(EList<AttrClassConfig>)null:_conjugated.getAttributes();
          return _attributes_2==null?(String)null:this.getConfigValue(_attributes_2, attr);
        }
      }
    }
    return null;
  }
  
  public String getConfigValue(final List<AttrClassConfig> attrConfigs, final Attribute attr) {
    final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
        public Boolean apply(final AttrClassConfig attrConfig) {
          Attribute _attribute = attrConfig.getAttribute();
          boolean _equals = _attribute.equals(attr);
          return Boolean.valueOf(_equals);
        }
      };
    AttrClassConfig _findFirst = IterableExtensions.<AttrClassConfig>findFirst(attrConfigs, _function);
    LiteralArray _value = _findFirst==null?(LiteralArray)null:_findFirst.getValue();
    String _stringValue = _value==null?(String)null:this.stringValue(_value, attr);
    return _stringValue;
  }
  
  public ActorClassConfig getClassConfig(final ActorClass ac) {
    ActorClassConfig _get = ConfigHelper.actorMap.get(ac);
    return _get;
  }
  
  public ProtocolClassConfig getProtocolConfig(final ProtocolClass prc) {
    ProtocolClassConfig _get = ConfigHelper.protocolMap.get(prc);
    return _get;
  }
  
  public String stringValue(final LiteralArray literalArray, final Attribute attr) {
    String string = "";
    boolean _and = false;
    boolean _isArray = this.isArray(attr);
    if (!_isArray) {
      _and = false;
    } else {
      EList<Literal> _literals = literalArray.getLiterals();
      int _size = _literals.size();
      boolean _greaterThan = (_size > 1);
      _and = (_isArray && _greaterThan);
    }
    if (_and) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ ");
      {
        EList<Literal> _literals_1 = literalArray.getLiterals();
        for(final Literal literal : _literals_1) {
          String _stringValue = this.stringValue(literal);
          _builder.append(_stringValue, "");
          _builder.append(", ");
        }
      }
      String _plus = (string + _builder.toString());
      string = _plus;
      int _length = string.length();
      int _minus = (_length - 2);
      String _substring = string.substring(0, _minus);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("}");
      String _plus_1 = (_substring + _builder_1.toString());
      string = _plus_1;
    } else {
      EList<Literal> _literals_2 = literalArray.getLiterals();
      Literal _get = _literals_2.get(0);
      String _stringValue_1 = this.stringValue(_get);
      string = _stringValue_1;
    }
    return string;
  }
  
  private String stringValue(final Literal literal) {
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
        int _value = _intLiteral.getValue();
        String _string = Integer.valueOf(_value).toString();
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
        String _xblockexpression = null;
        {
          String _value = _stringLiteral.getValue();
          String value = _value.toString();
          String _xifexpression = null;
          int _length = value.length();
          boolean _equals = (_length == 1);
          if (_equals) {
            String _plus = ("\'" + value);
            String _plus_1 = (_plus + "\'");
            _xifexpression = _plus_1;
          } else {
            String _charArrayExpr = this.languageExt.toCharArrayExpr(value);
            _xifexpression = _charArrayExpr;
          }
          _xblockexpression = (_xifexpression);
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }
  
  public boolean isArray(final Attribute attr) {
    boolean _xblockexpression = false;
    {
      boolean isChar = false;
      RefableType _refType = attr.getRefType();
      DataType _type = _refType.getType();
      if ((_type instanceof PrimitiveType)) {
        RefableType _refType_1 = attr.getRefType();
        DataType _type_1 = _refType_1.getType();
        PrimitiveType primitive = ((PrimitiveType) _type_1);
        LiteralType _type_2 = primitive.getType();
        boolean _equals = Objects.equal(_type_2, LiteralType.CHAR);
        isChar = _equals;
      }
      boolean _and = false;
      boolean _not = (!isChar);
      if (!_not) {
        _and = false;
      } else {
        int _size = attr.getSize();
        boolean _greaterThan = (_size > 0);
        _and = (_not && _greaterThan);
      }
      _xblockexpression = (_and);
    }
    return _xblockexpression;
  }
  
  public List<AttrInstanceConfig> getConfigAttributes(final ActorInstance ai) {
    ArrayList<AttrInstanceConfig> _arrayList = new ArrayList<AttrInstanceConfig>();
    ArrayList<AttrInstanceConfig> attrConfigs = _arrayList;
    String _path = ai.getPath();
    ActorInstanceConfig config = ConfigHelper.instanceMap.get(_path);
    boolean _notEquals = (!Objects.equal(config, null));
    if (_notEquals) {
      EList<AttrInstanceConfig> _attributes = config.getAttributes();
      for (final AttrInstanceConfig attrConfig : _attributes) {
        LiteralArray _value = attrConfig.getValue();
        boolean _notEquals_1 = (!Objects.equal(_value, null));
        if (_notEquals_1) {
          attrConfigs.add(attrConfig);
        }
      }
    }
    return attrConfigs;
  }
  
  public List<PortInstanceConfig> getConfigPorts(final ActorInstance ai) {
    ArrayList<PortInstanceConfig> _arrayList = new ArrayList<PortInstanceConfig>();
    ArrayList<PortInstanceConfig> portConfigs = _arrayList;
    String _path = ai.getPath();
    ActorInstanceConfig config = ConfigHelper.instanceMap.get(_path);
    boolean _notEquals = (!Objects.equal(config, null));
    if (_notEquals) {
      EList<PortInstanceConfig> _ports = config.getPorts();
      for (final PortInstanceConfig portConfig : _ports) {
        portConfigs.add(portConfig);
      }
    }
    return portConfigs;
  }
}
