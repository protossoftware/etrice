package org.eclipse.etrice.generator.generic;

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
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ConfigExtension {
  @Inject
  private ILanguageExtension languageExt;
  
  public String getInitValue(final Attribute a) {
      String _configDefaultValue = this.getConfigDefaultValue(a);
      String value = _configDefaultValue;
      boolean _operator_equals = ObjectExtensions.operator_equals(value, null);
      if (_operator_equals) {
        String _defaultValueLiteral = a.getDefaultValueLiteral();
        value = _defaultValueLiteral;
      }
      return value;
  }
  
  public String getConfigDefaultValue(final Attribute attr) {
    String _xifexpression = null;
    EObject _eContainer = attr.eContainer();
    if ((_eContainer instanceof ActorClass)) {
      {
        EObject _eContainer_1 = attr.eContainer();
        ActorClass ac = ((ActorClass) _eContainer_1);
        ActorClassConfig _classConfig = this.getClassConfig(ac);
        EList<AttrClassConfig> _attributes = _classConfig==null?(EList<AttrClassConfig>)null:_classConfig.getAttributes();
        String _configValue = _attributes==null?(String)null:this.getConfigValue(_attributes, attr);
        return _configValue;
      }
    } else {
      String _xifexpression_1 = null;
      EObject _eContainer_2 = attr.eContainer();
      if ((_eContainer_2 instanceof PortClass)) {
        {
          EObject _eContainer_3 = attr.eContainer();
          PortClass pc = ((PortClass) _eContainer_3);
          EObject _eContainer_4 = pc.eContainer();
          ProtocolClass protocol = ((ProtocolClass) _eContainer_4);
          ProtocolClassConfig _protocolConfig = this.getProtocolConfig(((ProtocolClass) protocol));
          ProtocolClassConfig prcConfig = _protocolConfig;
          PortClass _regular = protocol.getRegular();
          boolean _equals = pc.equals(_regular);
          if (_equals) {
            PortClassConfig _regular_1 = prcConfig==null?(PortClassConfig)null:prcConfig.getRegular();
            EList<AttrClassConfig> _attributes_1 = _regular_1==null?(EList<AttrClassConfig>)null:_regular_1.getAttributes();
            String _configValue_1 = _attributes_1==null?(String)null:this.getConfigValue(_attributes_1, attr);
            return _configValue_1;
          } else {
            PortClassConfig _conjugated = prcConfig==null?(PortClassConfig)null:prcConfig.getConjugated();
            EList<AttrClassConfig> _attributes_2 = _conjugated==null?(EList<AttrClassConfig>)null:_conjugated.getAttributes();
            String _configValue_2 = _attributes_2==null?(String)null:this.getConfigValue(_attributes_2, attr);
            return _configValue_2;
          }
        }
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String getConfigValue(final List<AttrClassConfig> attrConfigs, final Attribute attr) {
    final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
        public Boolean apply(final AttrClassConfig attrConfig) {
          Attribute _attribute = attrConfig.getAttribute();
          boolean _equals = _attribute.equals(attr);
          return ((Boolean)_equals);
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
      boolean _operator_and = false;
      boolean _isArray = this.isArray(attr);
      if (!_isArray) {
        _operator_and = false;
      } else {
        EList<Literal> _literals = literalArray.getLiterals();
        int _size = _literals.size();
        boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)1));
        _operator_and = BooleanExtensions.operator_and(_isArray, _operator_greaterThan);
      }
      if (_operator_and) {
        {
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
          String _operator_plus = StringExtensions.operator_plus(string, _builder);
          string = _operator_plus;
          int _length = string.length();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)2));
          String _substring = string.substring(0, _operator_minus);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("}");
          String _operator_plus_1 = StringExtensions.operator_plus(_substring, _builder_1);
          string = _operator_plus_1;
        }
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
    final Literal literal_1 = literal;
    boolean matched = false;
    if (!matched) {
      if (literal_1 instanceof BooleanLiteral) {
        final BooleanLiteral literal_2 = (BooleanLiteral) literal_1;
        matched=true;
        boolean _isIsTrue = literal_2.isIsTrue();
        String _string = ((Boolean)_isIsTrue).toString();
        _switchResult = _string;
      }
    }
    if (!matched) {
      if (literal_1 instanceof IntLiteral) {
        final IntLiteral literal_3 = (IntLiteral) literal_1;
        matched=true;
        int _value = literal_3.getValue();
        String _string_1 = ((Integer)_value).toString();
        _switchResult = _string_1;
      }
    }
    if (!matched) {
      if (literal_1 instanceof RealLiteral) {
        final RealLiteral literal_4 = (RealLiteral) literal_1;
        matched=true;
        double _value_1 = literal_4.getValue();
        String _string_2 = ((Double)_value_1).toString();
        _switchResult = _string_2;
      }
    }
    if (!matched) {
      if (literal_1 instanceof StringLiteral) {
        final StringLiteral literal_5 = (StringLiteral) literal_1;
        matched=true;
        String _xblockexpression = null;
        {
          String _value_2 = literal_5.getValue();
          String _string_3 = _value_2.toString();
          String value = _string_3;
          String _xifexpression = null;
          int _length = value.length();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_length), ((Integer)1));
          if (_operator_equals) {
            String _operator_plus = StringExtensions.operator_plus("\'", value);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'");
            _xifexpression = _operator_plus_1;
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
        {
          RefableType _refType_1 = attr.getRefType();
          DataType _type_1 = _refType_1.getType();
          PrimitiveType primitive = ((PrimitiveType) _type_1);
          LiteralType _type_2 = primitive.getType();
          boolean _operator_equals = ObjectExtensions.operator_equals(_type_2, LiteralType.CHAR);
          isChar = _operator_equals;
        }
      }
      boolean _operator_and = false;
      boolean _operator_not = BooleanExtensions.operator_not(isChar);
      if (!_operator_not) {
        _operator_and = false;
      } else {
        int _size = attr.getSize();
        boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
        _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_greaterThan);
      }
      _xblockexpression = (_operator_and);
    }
    return _xblockexpression;
  }
  
  public List<AttrInstanceConfig> getConfigAttributes(final ActorInstance ai) {
      ArrayList<AttrInstanceConfig> _arrayList = new ArrayList<AttrInstanceConfig>();
      ArrayList<AttrInstanceConfig> attrConfigs = _arrayList;
      String _path = ai.getPath();
      ActorInstanceConfig _get = ConfigHelper.instanceMap.get(_path);
      ActorInstanceConfig config = _get;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(config, null);
      if (_operator_notEquals) {
        EList<AttrInstanceConfig> _attributes = config.getAttributes();
        for (final AttrInstanceConfig attrConfig : _attributes) {
          LiteralArray _value = attrConfig.getValue();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_value, null);
          if (_operator_notEquals_1) {
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
      ActorInstanceConfig _get = ConfigHelper.instanceMap.get(_path);
      ActorInstanceConfig config = _get;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(config, null);
      if (_operator_notEquals) {
        EList<PortInstanceConfig> _ports = config.getPorts();
        for (final PortInstanceConfig portConfig : _ports) {
          portConfigs.add(portConfig);
        }
      }
      return portConfigs;
  }
}
