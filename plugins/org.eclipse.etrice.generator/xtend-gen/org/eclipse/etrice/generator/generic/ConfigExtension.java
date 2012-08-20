package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.BooleanLiteral;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.Literal;
import org.eclipse.etrice.core.config.LiteralArray;
import org.eclipse.etrice.core.config.PortClassConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.ConfigHelper;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ConfigExtension {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private RoomExtensions roomExt;
  
  public String toArrayValueLiteral(final PrimitiveType type, final String[] values) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final String v : values) {
        if (!hasAnyElements) {
          hasAnyElements = true;
          _builder.append("{", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _valueLiteral = this.languageExt.toValueLiteral(type, v);
        _builder.append(_valueLiteral, "");
      }
      if (hasAnyElements) {
        _builder.append("}", "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  public ActorClassConfig getClassConfig(final ActorClass ac) {
    ActorClassConfig _get = ConfigHelper.ac2acConfMap.get(ac);
    return _get;
  }
  
  public ProtocolClassConfig getProtocolConfig(final ProtocolClass prc) {
    ProtocolClassConfig _get = ConfigHelper.pc2pcConfMap.get(prc);
    return _get;
  }
  
  public SubSystemConfig getSubSystemConfig(final SubSystemClass ssc) {
    SubSystemConfig _get = ConfigHelper.ssc2ssConfMap.get(ssc);
    return _get;
  }
  
  public ActorClassConfig getActorClassConfig(final ActorInstanceConfig ai) {
    ActorClass _get = ConfigHelper.aiConf2acMap.get(ai);
    ActorClassConfig _get_1 = ConfigHelper.ac2acConfMap.get(_get);
    return _get_1;
  }
  
  public String getInitValueLiteral(final Attribute a) {
      String _defaultValueLiteral = a.getDefaultValueLiteral();
      String result = _defaultValueLiteral;
      String[] _configClassValues = this.getConfigClassValues(a);
      String[] configValues = _configClassValues;
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(configValues, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, (_type instanceof PrimitiveType));
      }
      if (_operator_and) {
        {
          RefableType _refType_1 = a.getRefType();
          DataType _type_1 = _refType_1.getType();
          PrimitiveType type = ((PrimitiveType) _type_1);
          int _size = a.getSize();
          final String[] typeConverted_configValues = (String[])configValues;
          int _size_1 = ((List<String>)Conversions.doWrapArray(typeConverted_configValues)).size();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)_size_1));
          if (_operator_notEquals_1) {
            final String[] typeConverted_configValues_1 = (String[])configValues;
            String _get = ((List<String>)Conversions.doWrapArray(typeConverted_configValues_1)).get(0);
            String _valueLiteral = this.languageExt.toValueLiteral(type, _get);
            result = _valueLiteral;
          } else {
            String _arrayValueLiteral = this.toArrayValueLiteral(type, configValues);
            result = _arrayValueLiteral;
          }
        }
      }
      return result;
  }
  
  public String[] getConfigClassValues(final Attribute attr) {
    String[] _xblockexpression = null;
    {
      EObject _eContainer = attr.eContainer();
      if ((_eContainer instanceof DataClass)) {
        return null;
      }
      String[] _xifexpression = null;
      EObject _eContainer_1 = attr.eContainer();
      if ((_eContainer_1 instanceof ActorClass)) {
        {
          EObject _eContainer_2 = attr.eContainer();
          ActorClass ac = ((ActorClass) _eContainer_2);
          ActorClassConfig _classConfig = this.getClassConfig(ac);
          EList<AttrClassConfig> _attributes = _classConfig==null?(EList<AttrClassConfig>)null:_classConfig.getAttributes();
          String[] _configValue = _attributes==null?(String[])null:this.getConfigValue(_attributes, attr);
          return _configValue;
        }
      } else {
        String[] _xifexpression_1 = null;
        EObject _eContainer_3 = attr.eContainer();
        if ((_eContainer_3 instanceof PortClass)) {
          {
            EObject _eContainer_4 = attr.eContainer();
            PortClass pc = ((PortClass) _eContainer_4);
            EObject _eContainer_5 = pc.eContainer();
            ProtocolClass protocol = ((ProtocolClass) _eContainer_5);
            ProtocolClassConfig _protocolConfig = this.getProtocolConfig(((ProtocolClass) protocol));
            ProtocolClassConfig prcConfig = _protocolConfig;
            PortClass _regular = protocol.getRegular();
            boolean _equals = pc.equals(_regular);
            if (_equals) {
              PortClassConfig _regular_1 = prcConfig==null?(PortClassConfig)null:prcConfig.getRegular();
              EList<AttrClassConfig> _attributes_1 = _regular_1==null?(EList<AttrClassConfig>)null:_regular_1.getAttributes();
              String[] _configValue_1 = _attributes_1==null?(String[])null:this.getConfigValue(_attributes_1, attr);
              return _configValue_1;
            } else {
              PortClassConfig _conjugated = prcConfig==null?(PortClassConfig)null:prcConfig.getConjugated();
              EList<AttrClassConfig> _attributes_2 = _conjugated==null?(EList<AttrClassConfig>)null:_conjugated.getAttributes();
              String[] _configValue_2 = _attributes_2==null?(String[])null:this.getConfigValue(_attributes_2, attr);
              return _configValue_2;
            }
          }
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String[] getConfigValue(final List<AttrClassConfig> attrConfigs, final Attribute attr) {
    final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
        public Boolean apply(final AttrClassConfig attrConfig) {
          Attribute _attribute = attrConfig.getAttribute();
          boolean _equals = _attribute.equals(attr);
          return ((Boolean)_equals);
        }
      };
    AttrClassConfig _findFirst = IterableExtensions.<AttrClassConfig>findFirst(attrConfigs, _function);
    LiteralArray _value = _findFirst==null?(LiteralArray)null:_findFirst.getValue();
    String[] _values = _value==null?(String[])null:this.getValues(_value);
    return _values;
  }
  
  public String[] getValues(final LiteralArray literalArray) {
      ArrayList<String> _arrayList = new ArrayList<String>();
      ArrayList<String> values = _arrayList;
      EList<Literal> _literals = literalArray.getLiterals();
      EList<Literal> literals = _literals;
      Literal _get = literals.get(0);
      if ((_get instanceof StringLiteral)) {
        Literal _get_1 = literals.get(0);
        String _value = this.getValue(_get_1);
        values.add(_value);
      } else {
        EList<Literal> _literals_1 = literalArray.getLiterals();
        for (final Literal l : _literals_1) {
          String _value_1 = this.getValue(l);
          values.add(_value_1);
        }
      }
      boolean _isEmpty = values.isEmpty();
      if (_isEmpty) {
        return null;
      }
      return ((String[])Conversions.unwrapArray(values, String.class));
  }
  
  public String getValue(final Literal literal) {
      final Literal literal_1 = literal;
      boolean matched = false;
      if (!matched) {
        if (literal_1 instanceof BooleanLiteral) {
          final BooleanLiteral literal_2 = (BooleanLiteral) literal_1;
          matched=true;
          boolean _isIsTrue = literal_2.isIsTrue();
          String _valueOf = String.valueOf(_isIsTrue);
          return _valueOf;
        }
      }
      if (!matched) {
        if (literal_1 instanceof IntLiteral) {
          final IntLiteral literal_3 = (IntLiteral) literal_1;
          matched=true;
          long _value = literal_3.getValue();
          String _valueOf_1 = String.valueOf(_value);
          return _valueOf_1;
        }
      }
      if (!matched) {
        if (literal_1 instanceof RealLiteral) {
          final RealLiteral literal_4 = (RealLiteral) literal_1;
          matched=true;
          double _value_1 = literal_4.getValue();
          String _valueOf_2 = String.valueOf(_value_1);
          return _valueOf_2;
        }
      }
      if (!matched) {
        if (literal_1 instanceof StringLiteral) {
          final StringLiteral literal_5 = (StringLiteral) literal_1;
          matched=true;
          String _value_2 = literal_5.getValue();
          String _valueOf_3 = String.valueOf(_value_2);
          return _valueOf_3;
        }
      }
      return null;
  }
  
  public List<AttrInstanceConfig> getConfigAttributes(final ActorInstance ai) {
      ArrayList<AttrInstanceConfig> _arrayList = new ArrayList<AttrInstanceConfig>();
      ArrayList<AttrInstanceConfig> attrConfigs = _arrayList;
      String _path = ai.getPath();
      ActorInstanceConfig _get = ConfigHelper.path2aiConfMap.get(_path);
      ActorInstanceConfig config = _get;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(config, null);
      if (_operator_notEquals) {
        EList<AttrInstanceConfig> _attributes = config.getAttributes();
        return _attributes;
      }
      return attrConfigs;
  }
  
  public List<PortInstanceConfig> getConfigPorts(final ActorInstance ai) {
      ArrayList<PortInstanceConfig> _arrayList = new ArrayList<PortInstanceConfig>();
      ArrayList<PortInstanceConfig> portConfigs = _arrayList;
      String _path = ai.getPath();
      ActorInstanceConfig _get = ConfigHelper.path2aiConfMap.get(_path);
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
  
  public boolean hasVariableService(final SubSystemClass ssc) {
    SubSystemConfig _subSystemConfig = this.getSubSystemConfig(ssc);
    DynamicConfig _dynConfig = _subSystemConfig==null?(DynamicConfig)null:_subSystemConfig.getDynConfig();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_dynConfig, null);
    return _operator_notEquals;
  }
  
  public List<AttrClassConfig> getAllAttrConfigFlat(final ActorClass ac) {
      ArrayList<AttrClassConfig> _arrayList = new ArrayList<AttrClassConfig>();
      ArrayList<AttrClassConfig> result = _arrayList;
      ActorClassConfig _classConfig = this.getClassConfig(ac);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_classConfig, null);
      if (_operator_notEquals) {
        {
          LinkedList<AttrClassConfig> _linkedList = new LinkedList<AttrClassConfig>();
          LinkedList<AttrClassConfig> stack = _linkedList;
          ActorClassConfig _classConfig_1 = this.getClassConfig(ac);
          EList<AttrClassConfig> _attributes = _classConfig_1.getAttributes();
          stack.addAll(_attributes);
          boolean _isEmpty = stack.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          Boolean _xwhileexpression = _operator_not;
          while (_xwhileexpression) {
            {
              AttrClassConfig _pop = stack.pop();
              AttrClassConfig c = _pop;
              result.add(c);
              EList<AttrClassConfig> _attributes_1 = c.getAttributes();
              stack.addAll(_attributes_1);
            }
            boolean _isEmpty_1 = stack.isEmpty();
            boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
            _xwhileexpression = _operator_not_1;
          }
        }
      }
      return result;
  }
  
  public List<AttrInstanceConfig> getAttrDynConfigs(final SubSystemClass ssc, final boolean read, final boolean write) {
      List<AttrInstanceConfig> _get = ConfigHelper.ssc2attrInstConfMap.get(ssc);
      List<AttrInstanceConfig> configs = _get;
      int _size = configs.size();
      ArrayList<AttrInstanceConfig> _arrayList = new ArrayList<AttrInstanceConfig>(_size);
      final ArrayList<AttrInstanceConfig> result = _arrayList;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(configs, null);
      if (_operator_notEquals) {
        final Procedure1<AttrInstanceConfig> _function = new Procedure1<AttrInstanceConfig>() {
            public void apply(final AttrInstanceConfig c) {
              boolean _operator_or = false;
              boolean _operator_and = false;
              if (!read) {
                _operator_and = false;
              } else {
                boolean _isReadOnly = c.isReadOnly();
                _operator_and = BooleanExtensions.operator_and(read, _isReadOnly);
              }
              if (_operator_and) {
                _operator_or = true;
              } else {
                boolean _operator_and_1 = false;
                if (!write) {
                  _operator_and_1 = false;
                } else {
                  boolean _isReadOnly_1 = c.isReadOnly();
                  boolean _operator_not = BooleanExtensions.operator_not(_isReadOnly_1);
                  _operator_and_1 = BooleanExtensions.operator_and(write, _operator_not);
                }
                _operator_or = BooleanExtensions.operator_or(_operator_and, _operator_and_1);
              }
              if (_operator_or) {
                result.add(c);
              }
            }
          };
        IterableExtensions.<AttrInstanceConfig>forEach(configs, _function);
      }
      return result;
  }
  
  public List<String> getPath(final AttrConfig config, final boolean ss, final boolean actor, final boolean dc, final boolean attr) {
      LinkedList<String> _linkedList = new LinkedList<String>();
      LinkedList<String> result = _linkedList;
      AttrConfig c = config;
      EObject _eContainer = c.eContainer();
      Boolean _xwhileexpression = (_eContainer instanceof AttrConfig);
      while (_xwhileexpression) {
        {
          EObject _eContainer_1 = c.eContainer();
          c = ((AttrConfig) _eContainer_1);
          if (dc) {
            Attribute _attribute = c.getAttribute();
            String _name = _attribute.getName();
            result.addFirst(_name);
          }
        }
        EObject _eContainer_2 = c.eContainer();
        _xwhileexpression = (_eContainer_2 instanceof AttrConfig);
      }
      EObject _eContainer_3 = c.eContainer();
      if ((_eContainer_3 instanceof ActorInstanceConfig)) {
        {
          EObject _eContainer_4 = c.eContainer();
          ActorInstanceConfig aic = ((ActorInstanceConfig) _eContainer_4);
          if (actor) {
            RefPath _path = aic.getPath();
            EList<String> _refs = _path.getRefs();
            result.addAll(0, _refs);
          }
          if (ss) {
            SubSystemClass _root = aic.getRoot();
            String _name_1 = _root.getName();
            result.addFirst(_name_1);
          }
        }
      } else {
        EObject _eContainer_5 = c.eContainer();
        if ((_eContainer_5 instanceof ActorClassConfig)) {
          {
            EObject _eContainer_6 = c.eContainer();
            ActorClassConfig ac = ((ActorClassConfig) _eContainer_6);
            if (actor) {
              ActorClass _actor = ac.getActor();
              String _name_2 = _actor.getName();
              result.addFirst(_name_2);
            }
          }
        }
      }
      if (attr) {
        Attribute _attribute_1 = config.getAttribute();
        String _name_3 = _attribute_1.getName();
        result.add(_name_3);
      }
      return result;
  }
  
  public String toPath(final List<String> path, final String pathDelim) {
    String _path = ConfigHelper.toPath(path, pathDelim);
    return _path;
  }
  
  public List<Attribute> getDynConfigAttributes(final ActorClass ac, final boolean read, final boolean write) {
      ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
      ArrayList<Attribute> attributes = _arrayList;
      List<ActorInstanceConfig> _get = ConfigHelper.ac2aiConfMap.get(ac);
      List<ActorInstanceConfig> instanceConfigs = _get;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(instanceConfigs, null);
      if (_operator_notEquals) {
        for (final ActorInstanceConfig instanceConfig : instanceConfigs) {
          EList<AttrInstanceConfig> _attributes = instanceConfig.getAttributes();
          for (final AttrInstanceConfig attrConfig : _attributes) {
            boolean _isDynConfig = attrConfig.isDynConfig();
            if (_isDynConfig) {
              boolean _operator_or = false;
              boolean _operator_and = false;
              if (!read) {
                _operator_and = false;
              } else {
                boolean _isReadOnly = attrConfig.isReadOnly();
                _operator_and = BooleanExtensions.operator_and(read, _isReadOnly);
              }
              if (_operator_and) {
                _operator_or = true;
              } else {
                boolean _operator_and_1 = false;
                if (!write) {
                  _operator_and_1 = false;
                } else {
                  boolean _isReadOnly_1 = attrConfig.isReadOnly();
                  boolean _operator_not = BooleanExtensions.operator_not(_isReadOnly_1);
                  _operator_and_1 = BooleanExtensions.operator_and(write, _operator_not);
                }
                _operator_or = BooleanExtensions.operator_or(_operator_and, _operator_and_1);
              }
              if (_operator_or) {
                Attribute _attribute = attrConfig.getAttribute();
                attributes.add(_attribute);
              }
            }
          }
        }
      }
      return attributes;
  }
}
