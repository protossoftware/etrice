package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.HashSet;
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
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
      boolean _hasElements = false;
      for(final String v : values) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("{", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _valueLiteral = this.languageExt.toValueLiteral(type, v);
        _builder.append(_valueLiteral, "");
      }
      if (_hasElements) {
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
    String[] configValues = this.getConfigClassValues(a);
    RefableType _refType = a.getRefType();
    DataType type = _refType.getType();
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      boolean _equals = Objects.equal(configValues, null);
      if (_equals) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (type instanceof PrimitiveType) {
        final PrimitiveType _primitiveType = (PrimitiveType)type;
        int _size = a.getSize();
        final String[] _converted_configValues = (String[])configValues;
        int _size_1 = ((List<String>)Conversions.doWrapArray(_converted_configValues)).size();
        boolean _notEquals = (_size != _size_1);
        if (_notEquals) {
          _matched=true;
          final String[] _converted_configValues_1 = (String[])configValues;
          String _get = ((List<String>)Conversions.doWrapArray(_converted_configValues_1)).get(0);
          String _valueLiteral = this.languageExt.toValueLiteral(_primitiveType, _get);
          _switchResult = _valueLiteral;
        }
      }
    }
    if (!_matched) {
      if (type instanceof PrimitiveType) {
        final PrimitiveType _primitiveType = (PrimitiveType)type;
        _matched=true;
        String _arrayValueLiteral = this.toArrayValueLiteral(_primitiveType, configValues);
        _switchResult = _arrayValueLiteral;
      }
    }
    String configValue = _switchResult;
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(configValue, null));
    if (_notEquals) {
      _xifexpression = configValue;
    } else {
      String _defaultValueLiteral = a.getDefaultValueLiteral();
      _xifexpression = _defaultValueLiteral;
    }
    return _xifexpression;
  }
  
  public String[] getConfigClassValues(final Attribute attr) {
    EObject _eContainer = attr.eContainer();
    if ((_eContainer instanceof DataClass)) {
      return null;
    }
    EObject _eContainer_1 = attr.eContainer();
    if ((_eContainer_1 instanceof ActorClass)) {
      EObject _eContainer_2 = attr.eContainer();
      ActorClass ac = ((ActorClass) _eContainer_2);
      ActorClassConfig _classConfig = this.getClassConfig(ac);
      EList<AttrClassConfig> _attributes = _classConfig==null?(EList<AttrClassConfig>)null:_classConfig.getAttributes();
      return _attributes==null?(String[])null:this.getConfigValue(_attributes, attr);
    } else {
      EObject _eContainer_3 = attr.eContainer();
      if ((_eContainer_3 instanceof PortClass)) {
        EObject _eContainer_4 = attr.eContainer();
        PortClass pc = ((PortClass) _eContainer_4);
        EObject _eContainer_5 = pc.eContainer();
        ProtocolClass protocol = ((ProtocolClass) _eContainer_5);
        ProtocolClassConfig prcConfig = this.getProtocolConfig(((ProtocolClass) protocol));
        PortClass _regular = protocol.getRegular();
        boolean _equals = pc.equals(_regular);
        if (_equals) {
          PortClassConfig _regular_1 = prcConfig==null?(PortClassConfig)null:prcConfig.getRegular();
          EList<AttrClassConfig> _attributes_1 = _regular_1==null?(EList<AttrClassConfig>)null:_regular_1.getAttributes();
          return _attributes_1==null?(String[])null:this.getConfigValue(_attributes_1, attr);
        } else {
          PortClassConfig _conjugated = prcConfig==null?(PortClassConfig)null:prcConfig.getConjugated();
          EList<AttrClassConfig> _attributes_2 = _conjugated==null?(EList<AttrClassConfig>)null:_conjugated.getAttributes();
          return _attributes_2==null?(String[])null:this.getConfigValue(_attributes_2, attr);
        }
      }
    }
    return null;
  }
  
  public String[] getConfigValue(final List<AttrClassConfig> attrConfigs, final Attribute attr) {
    final Function1<AttrClassConfig,Boolean> _function = new Function1<AttrClassConfig,Boolean>() {
        public Boolean apply(final AttrClassConfig attrConfig) {
          Attribute _attribute = attrConfig.getAttribute();
          boolean _equals = _attribute.equals(attr);
          return Boolean.valueOf(_equals);
        }
      };
    AttrClassConfig _findFirst = IterableExtensions.<AttrClassConfig>findFirst(attrConfigs, _function);
    LiteralArray _value = _findFirst==null?(LiteralArray)null:_findFirst.getValue();
    String[] _values = _value==null?(String[])null:this.getValues(_value);
    return _values;
  }
  
  public String[] getValues(final LiteralArray literalArray) {
    ArrayList<String> _arrayList = new ArrayList<String>();
    final ArrayList<String> result = _arrayList;
    EList<Literal> _literals = literalArray.getLiterals();
    final Procedure1<Literal> _function = new Procedure1<Literal>() {
        public void apply(final Literal l) {
          String _value = ConfigExtension.this.getValue(l);
          result.add(_value);
        }
      };
    IterableExtensions.<Literal>forEach(_literals, _function);
    ArrayList<String> _xifexpression = null;
    boolean _isEmpty = result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      _xifexpression = result;
    } else {
      _xifexpression = null;
    }
    return ((String[])Conversions.unwrapArray(_xifexpression, String.class));
  }
  
  public String getValue(final Literal literal) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (literal instanceof BooleanLiteral) {
        final BooleanLiteral _booleanLiteral = (BooleanLiteral)literal;
        _matched=true;
        boolean _isIsTrue = _booleanLiteral.isIsTrue();
        String _valueOf = String.valueOf(_isIsTrue);
        _switchResult = _valueOf;
      }
    }
    if (!_matched) {
      if (literal instanceof IntLiteral) {
        final IntLiteral _intLiteral = (IntLiteral)literal;
        _matched=true;
        long _value = _intLiteral.getValue();
        String _valueOf = String.valueOf(_value);
        _switchResult = _valueOf;
      }
    }
    if (!_matched) {
      if (literal instanceof RealLiteral) {
        final RealLiteral _realLiteral = (RealLiteral)literal;
        _matched=true;
        double _value = _realLiteral.getValue();
        String _valueOf = String.valueOf(_value);
        _switchResult = _valueOf;
      }
    }
    if (!_matched) {
      if (literal instanceof StringLiteral) {
        final StringLiteral _stringLiteral = (StringLiteral)literal;
        _matched=true;
        String _value = _stringLiteral.getValue();
        String _valueOf = String.valueOf(_value);
        _switchResult = _valueOf;
      }
    }
    return _switchResult;
  }
  
  public List<AttrInstanceConfig> getConfigAttributes(final ActorInstance ai) {
    String _path = ai.getPath();
    ActorInstanceConfig config = ConfigHelper.path2aiConfMap.get(_path);
    List<AttrInstanceConfig> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(config, null));
    if (_notEquals) {
      EList<AttrInstanceConfig> _attributes = config.getAttributes();
      _xifexpression = _attributes;
    } else {
      ArrayList<AttrInstanceConfig> _arrayList = new ArrayList<AttrInstanceConfig>();
      _xifexpression = _arrayList;
    }
    return _xifexpression;
  }
  
  public List<PortInstanceConfig> getConfigPorts(final ActorInstance ai) {
    ArrayList<PortInstanceConfig> _arrayList = new ArrayList<PortInstanceConfig>();
    final ArrayList<PortInstanceConfig> result = _arrayList;
    String _path = ai.getPath();
    ActorInstanceConfig config = ConfigHelper.path2aiConfMap.get(_path);
    EList<PortInstanceConfig> _ports = config==null?(EList<PortInstanceConfig>)null:config.getPorts();
    final Procedure1<PortInstanceConfig> _function = new Procedure1<PortInstanceConfig>() {
        public void apply(final PortInstanceConfig portConf) {
          result.add(portConf);
        }
      };
    if (_ports!=null) IterableExtensions.<PortInstanceConfig>forEach(_ports, _function);
    return result;
  }
  
  public boolean hasVariableService(final SubSystemClass ssc) {
    SubSystemConfig _subSystemConfig = this.getSubSystemConfig(ssc);
    DynamicConfig _dynConfig = _subSystemConfig==null?(DynamicConfig)null:_subSystemConfig.getDynConfig();
    boolean _notEquals = (!Objects.equal(_dynConfig, null));
    return _notEquals;
  }
  
  public List<AttrClassConfig> getAllAttrConfigFlat(final ActorClass ac) {
    ArrayList<AttrClassConfig> _arrayList = new ArrayList<AttrClassConfig>();
    ArrayList<AttrClassConfig> result = _arrayList;
    ActorClassConfig _classConfig = this.getClassConfig(ac);
    boolean _notEquals = (!Objects.equal(_classConfig, null));
    if (_notEquals) {
      LinkedList<AttrClassConfig> _linkedList = new LinkedList<AttrClassConfig>();
      LinkedList<AttrClassConfig> stack = _linkedList;
      ActorClassConfig _classConfig_1 = this.getClassConfig(ac);
      EList<AttrClassConfig> _attributes = _classConfig_1.getAttributes();
      stack.addAll(_attributes);
      boolean _isEmpty = stack.isEmpty();
      boolean _not = (!_isEmpty);
      boolean _while = _not;
      while (_while) {
        {
          AttrClassConfig c = stack.pop();
          result.add(c);
          EList<AttrClassConfig> _attributes_1 = c.getAttributes();
          stack.addAll(_attributes_1);
        }
        boolean _isEmpty_1 = stack.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _while = _not_1;
      }
    }
    return result;
  }
  
  public Iterable<AttrInstanceConfig> getAttrDynConfigs(final SubSystemClass ssc, final boolean read, final boolean write) {
    List<AttrInstanceConfig> _get = ConfigHelper.ssc2attrInstConfMap.get(ssc);
    final Function1<AttrInstanceConfig,Boolean> _function = new Function1<AttrInstanceConfig,Boolean>() {
        public Boolean apply(final AttrInstanceConfig c) {
          boolean _and = false;
          boolean _isDynConfig = c.isDynConfig();
          if (!_isDynConfig) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _and_1 = false;
            if (!read) {
              _and_1 = false;
            } else {
              boolean _isReadOnly = c.isReadOnly();
              _and_1 = (read && _isReadOnly);
            }
            if (_and_1) {
              _or = true;
            } else {
              boolean _and_2 = false;
              if (!write) {
                _and_2 = false;
              } else {
                boolean _isReadOnly_1 = c.isReadOnly();
                boolean _not = (!_isReadOnly_1);
                _and_2 = (write && _not);
              }
              _or = (_and_1 || _and_2);
            }
            _and = (_isDynConfig && _or);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<AttrInstanceConfig> _filter = IterableExtensions.<AttrInstanceConfig>filter(_get, _function);
    return _filter;
  }
  
  public List<String> getPath(final AttrConfig config, final boolean ss, final boolean actor, final boolean dc, final boolean attr) {
    LinkedList<String> _linkedList = new LinkedList<String>();
    LinkedList<String> result = _linkedList;
    AttrConfig c = config;
    EObject _eContainer = c.eContainer();
    boolean _while = (_eContainer instanceof AttrConfig);
    while (_while) {
      {
        EObject _eContainer_1 = c.eContainer();
        c = ((AttrConfig) _eContainer_1);
        if (dc) {
          Attribute _attribute = c.getAttribute();
          String _name = _attribute.getName();
          result.addFirst(_name);
        }
      }
      EObject _eContainer_1 = c.eContainer();
      _while = (_eContainer_1 instanceof AttrConfig);
    }
    EObject _eContainer_1 = c.eContainer();
    if ((_eContainer_1 instanceof ActorInstanceConfig)) {
      EObject _eContainer_2 = c.eContainer();
      ActorInstanceConfig aic = ((ActorInstanceConfig) _eContainer_2);
      if (actor) {
        RefPath _path = aic.getPath();
        EList<String> _refs = _path.getRefs();
        result.addAll(0, _refs);
      }
      if (ss) {
        SubSystemClass _root = aic.getRoot();
        String _name = _root.getName();
        result.addFirst(_name);
      }
    } else {
      EObject _eContainer_3 = c.eContainer();
      if ((_eContainer_3 instanceof ActorClassConfig)) {
        EObject _eContainer_4 = c.eContainer();
        ActorClassConfig ac = ((ActorClassConfig) _eContainer_4);
        if (actor) {
          ActorClass _actor = ac.getActor();
          String _name_1 = _actor.getName();
          result.addFirst(_name_1);
        }
      }
    }
    if (attr) {
      Attribute _attribute = config.getAttribute();
      String _name_2 = _attribute.getName();
      result.add(_name_2);
    }
    return result;
  }
  
  public String toPath(final Iterable<String> path, final String pathDelim) {
    String _path = ConfigHelper.toPath(path, pathDelim);
    return _path;
  }
  
  public HashSet<Attribute> getDynConfigAttributes(final ActorClass ac, final boolean read, final boolean write) {
    HashSet<Attribute> _hashSet = new HashSet<Attribute>();
    final HashSet<Attribute> result = _hashSet;
    List<ActorInstanceConfig> _get = ConfigHelper.ac2aiConfMap.get(ac);
    final Procedure1<ActorInstanceConfig> _function = new Procedure1<ActorInstanceConfig>() {
        public void apply(final ActorInstanceConfig aiConf) {
          EList<AttrInstanceConfig> _attributes = aiConf.getAttributes();
          final Function1<AttrInstanceConfig,Boolean> _function = new Function1<AttrInstanceConfig,Boolean>() {
              public Boolean apply(final AttrInstanceConfig c) {
                boolean _and = false;
                boolean _isDynConfig = c.isDynConfig();
                if (!_isDynConfig) {
                  _and = false;
                } else {
                  boolean _or = false;
                  boolean _and_1 = false;
                  if (!read) {
                    _and_1 = false;
                  } else {
                    boolean _isReadOnly = c.isReadOnly();
                    _and_1 = (read && _isReadOnly);
                  }
                  if (_and_1) {
                    _or = true;
                  } else {
                    boolean _and_2 = false;
                    if (!write) {
                      _and_2 = false;
                    } else {
                      boolean _isReadOnly_1 = c.isReadOnly();
                      boolean _not = (!_isReadOnly_1);
                      _and_2 = (write && _not);
                    }
                    _or = (_and_1 || _and_2);
                  }
                  _and = (_isDynConfig && _or);
                }
                return Boolean.valueOf(_and);
              }
            };
          Iterable<AttrInstanceConfig> _filter = IterableExtensions.<AttrInstanceConfig>filter(_attributes, _function);
          final Procedure1<AttrInstanceConfig> _function_1 = new Procedure1<AttrInstanceConfig>() {
              public void apply(final AttrInstanceConfig dynConf) {
                Attribute _attribute = dynConf.getAttribute();
                result.add(_attribute);
              }
            };
          IterableExtensions.<AttrInstanceConfig>forEach(_filter, _function_1);
        }
      };
    if (_get!=null) IterableExtensions.<ActorInstanceConfig>forEach(_get, _function);
    return result;
  }
}
