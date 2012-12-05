package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ConfigGenAddon {
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  public CharSequence genActorInstanceConfig(final ActorInstance ai, final String aiVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ActorClass _actorClass = ai.getActorClass();
      EList<Attribute> _attributes = _actorClass.getAttributes();
      for(final Attribute a : _attributes) {
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, null, aiVariableName, _union);
        _builder.append(_applyInstanceConfig, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      ActorClass _actorClass_1 = ai.getActorClass();
      List<Port> _allEndPorts = this._roomExtensions.getAllEndPorts(_actorClass_1);
      for(final Port p : _allEndPorts) {
        {
          GeneralProtocolClass _protocol = p.getProtocol();
          boolean _isConjugated = p.isConjugated();
          boolean _not = (!_isConjugated);
          List<Attribute> _attributes_1 = this.getAttributes(_protocol, _not);
          for(final Attribute a_1 : _attributes_1) {
            String _plus = (aiVariableName + ".");
            String _name = p.getName();
            CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
            String _plus_1 = (_plus + _invokeGetter);
            ArrayList<Attribute> _arrayList_1 = new ArrayList<Attribute>();
            List<Attribute> _union_1 = this._roomExtensions.<Attribute>union(_arrayList_1, a_1);
            CharSequence _applyInstanceConfig_1 = this.applyInstanceConfig(ai, p, _plus_1, _union_1);
            _builder.append(_applyInstanceConfig_1, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      ActorClass _actorClass_2 = ai.getActorClass();
      List<SAPRef> _allSAPs = this._roomExtensions.getAllSAPs(_actorClass_2);
      for(final SAPRef sap : _allSAPs) {
        {
          ProtocolClass _protocol_1 = sap.getProtocol();
          List<Attribute> _attributes_2 = this.getAttributes(_protocol_1, true);
          for(final Attribute a_2 : _attributes_2) {
            String _plus_2 = (aiVariableName + ".");
            String _name_1 = sap.getName();
            CharSequence _invokeGetter_1 = this.helpers.invokeGetter(_name_1, null);
            String _plus_3 = (_plus_2 + _invokeGetter_1);
            ArrayList<Attribute> _arrayList_2 = new ArrayList<Attribute>();
            List<Attribute> _union_2 = this._roomExtensions.<Attribute>union(_arrayList_2, a_2);
            CharSequence _applyInstanceConfig_2 = this.applyInstanceConfig(ai, sap, _plus_3, _union_2);
            _builder.append(_applyInstanceConfig_2, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  private List<Attribute> getAttributes(final GeneralProtocolClass gpc, final boolean regular) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    ArrayList<Attribute> result = _arrayList;
    if ((gpc instanceof ProtocolClass)) {
      ProtocolClass protocol = ((ProtocolClass) gpc);
      boolean _and = false;
      if (!regular) {
        _and = false;
      } else {
        PortClass _regular = protocol.getRegular();
        EList<Attribute> _attributes = _regular==null?(EList<Attribute>)null:_regular.getAttributes();
        boolean _notEquals = (!Objects.equal(_attributes, null));
        _and = (regular && _notEquals);
      }
      if (_and) {
        PortClass _regular_1 = protocol.getRegular();
        EList<Attribute> _attributes_1 = _regular_1.getAttributes();
        result.addAll(_attributes_1);
      } else {
        boolean _and_1 = false;
        boolean _not = (!regular);
        if (!_not) {
          _and_1 = false;
        } else {
          PortClass _conjugate = protocol.getConjugate();
          EList<Attribute> _attributes_2 = _conjugate==null?(EList<Attribute>)null:_conjugate.getAttributes();
          boolean _notEquals_1 = (!Objects.equal(_attributes_2, null));
          _and_1 = (_not && _notEquals_1);
        }
        if (_and_1) {
          PortClass _conjugate_1 = protocol.getConjugate();
          EList<Attribute> _attributes_3 = _conjugate_1.getAttributes();
          result.addAll(_attributes_3);
        }
      }
    }
    return result;
  }
  
  private CharSequence applyInstanceConfig(final ActorInstance ai, final InterfaceItem port, final String invokes, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      CharSequence _xifexpression = null;
      boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
      if (_isPrimitive) {
        CharSequence _xblockexpression_1 = null;
        {
          String _xifexpression_1 = null;
          boolean _equals = Objects.equal(port, null);
          if (_equals) {
            String _attrInstanceConfigValue = this.dataConfigExt.getAttrInstanceConfigValue(ai, path);
            _xifexpression_1 = _attrInstanceConfigValue;
          } else {
            String _attrInstanceConfigValue_1 = this.dataConfigExt.getAttrInstanceConfigValue(ai, port, path);
            _xifexpression_1 = _attrInstanceConfigValue_1;
          }
          String value = _xifexpression_1;
          CharSequence _xifexpression_2 = null;
          boolean _equals_1 = Objects.equal(value, null);
          if (_equals_1) {
            StringConcatenation _builder = new StringConcatenation();
            _xifexpression_2 = _builder;
          } else {
            CharSequence _xifexpression_3 = null;
            boolean _or = false;
            int _size = a.getSize();
            boolean _equals_2 = (_size == 0);
            if (_equals_2) {
              _or = true;
            } else {
              boolean _isCharacterType = this.typeHelpers.isCharacterType(aType);
              _or = (_equals_2 || _isCharacterType);
            }
            if (_or) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(invokes, "");
              _builder_1.append(".");
              String _name = a.getName();
              String _valueLiteral = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
              CharSequence _invokeSetter = this.helpers.invokeSetter(_name, null, _valueLiteral);
              _builder_1.append(_invokeSetter, "");
              _builder_1.append(";");
              _xifexpression_3 = _builder_1;
            } else {
              CharSequence _xifexpression_4 = null;
              int _size_1 = a.getSize();
              String[] _split = value.split(",");
              int _size_2 = ((List<String>)Conversions.doWrapArray(_split)).size();
              boolean _equals_3 = (_size_1 == _size_2);
              if (_equals_3) {
                CharSequence _xblockexpression_2 = null;
                {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("{ ");
                  {
                    String[] _split_1 = value.split(",");
                    boolean _hasElements = false;
                    for(final String s : _split_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder_2.appendImmediate(", ", "");
                      }
                      String _trim = s.trim();
                      String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), _trim);
                      _builder_2.append(_valueLiteral_1, "");
                    }
                  }
                  _builder_2.append(" }");
                  CharSequence arrayExpr = _builder_2;
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append(invokes, "");
                  _builder_3.append(".");
                  String _name_1 = a.getName();
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("new ");
                  String _typeName = this.typeHelpers.typeName(aType);
                  _builder_4.append(_typeName, "");
                  _builder_4.append("[] ");
                  _builder_4.append(arrayExpr, "");
                  String _string = _builder_4.toString();
                  CharSequence _invokeSetter_1 = this.helpers.invokeSetter(_name_1, null, _string);
                  _builder_3.append(_invokeSetter_1, "");
                  _builder_3.append(";");
                  _xblockexpression_2 = (_builder_3);
                }
                _xifexpression_4 = _xblockexpression_2;
              } else {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("{");
                _builder_2.newLine();
                _builder_2.append("\t");
                String _typeName = this.typeHelpers.typeName(aType);
                _builder_2.append(_typeName, "	");
                _builder_2.append("[] array = ");
                _builder_2.append(invokes, "	");
                _builder_2.append(".");
                String _name_1 = a.getName();
                CharSequence _invokeGetter = this.helpers.invokeGetter(_name_1, null);
                _builder_2.append(_invokeGetter, "	");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t");
                _builder_2.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder_2.append(_size_3, "	");
                _builder_2.append(";i++){");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("\t\t");
                _builder_2.append("array[i] = ");
                String _valueLiteral_1 = this.stdExt.toValueLiteral(((PrimitiveType) aType), value);
                _builder_2.append(_valueLiteral_1, "		");
                _builder_2.append(";");
                _builder_2.newLineIfNotEmpty();
                _builder_2.append("}");
                _xifexpression_4 = _builder_2;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xblockexpression_1 = (_xifexpression_2);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isDataClass = this.typeHelpers.isDataClass(aType);
        if (_isDataClass) {
          StringConcatenation _builder = new StringConcatenation();
          {
            EList<Attribute> _attributes = ((DataClass) aType).getAttributes();
            for(final Attribute e : _attributes) {
              String _plus = (invokes + ".");
              String _name = a.getName();
              CharSequence _invokeGetter = this.helpers.invokeGetter(_name, null);
              String _plus_1 = (_plus + _invokeGetter);
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
              CharSequence _applyInstanceConfig = this.applyInstanceConfig(ai, port, _plus_1, _union);
              _builder.append(_applyInstanceConfig, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _xifexpression_1 = _builder;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence genDynConfigGetterSetter(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
      for(final Attribute a : _dynConfigReadAttributes) {
        _builder.append("public ");
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this.typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" get");
        String _name = a.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder.append(_firstUpper, "");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name_1 = a.getName();
        _builder.append(_name_1, "	");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        String _name_2 = a.getName();
        _builder.append(_name_2, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_3 = a.getName();
        _builder.append(_name_3, "		");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return ");
        String _name_4 = a.getName();
        _builder.append(_name_4, "			");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public void set");
        String _name_5 = a.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_1, "");
        _builder.append("(");
        RefableType _refType_1 = a.getRefType();
        DataType _type_1 = _refType_1.getType();
        String _typeName_1 = this.typeHelpers.typeName(_type_1);
        _builder.append(_typeName_1, "");
        {
          int _size_1 = a.getSize();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_6 = a.getName();
        _builder.append(_name_6, "");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if(lock_");
        String _name_7 = a.getName();
        _builder.append(_name_7, "	");
        _builder.append(" == null)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_8 = a.getName();
        _builder.append(_name_8, "		");
        _builder.append(" = ");
        String _name_9 = a.getName();
        _builder.append(_name_9, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("else");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized(lock_");
        String _name_10 = a.getName();
        _builder.append(_name_10, "		");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("this.");
        String _name_11 = a.getName();
        _builder.append(_name_11, "			");
        _builder.append(" = ");
        String _name_12 = a.getName();
        _builder.append(_name_12, "			");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("public DynConfigLock get");
        String _name_13 = a.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_13);
        _builder.append(_firstUpper_2, "");
        _builder.append("Lock(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return lock_");
        String _name_14 = a.getName();
        _builder.append(_name_14, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    {
      List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
      for(final Attribute a_1 : _dynConfigWriteAttributes) {
        _builder.append("public void setAndWrite");
        String _name_15 = a_1.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_15);
        _builder.append(_firstUpper_3, "");
        _builder.append("(");
        RefableType _refType_2 = a_1.getRefType();
        DataType _type_2 = _refType_2.getType();
        String _typeName_2 = this.typeHelpers.typeName(_type_2);
        _builder.append(_typeName_2, "");
        {
          int _size_2 = a_1.getSize();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_16 = a_1.getName();
        _builder.append(_name_16, "");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("set");
        String _name_17 = a_1.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_17);
        _builder.append(_firstUpper_4, "		");
        _builder.append("(");
        String _name_18 = a_1.getName();
        _builder.append(_name_18, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("variableService.write(this.getInstancePath()+\"/");
        String _name_19 = a_1.getName();
        _builder.append(_name_19, "		");
        _builder.append("\", ");
        String _name_20 = a_1.getName();
        _builder.append(_name_20, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence genMinMaxConstants(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Attribute> _attributes = ac.getAttributes();
      for(final Attribute a : _attributes) {
        String _name = a.getName();
        ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
        List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
        CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _name, _union);
        _builder.append(_genMinMaxConstantsRec, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence result = _builder;
    int _length = result.length();
    boolean _notEquals = (_length != 0);
    if (_notEquals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("//--------------------- Attribute Specifications");
      String _plus = (result + _builder_1.toString());
      result = _plus;
    }
    return result;
  }
  
  private CharSequence genMinMaxConstantsRec(final ActorClass ac, final String varNamePath, final List<Attribute> path) {
    CharSequence _xblockexpression = null;
    {
      String temp = ((String) null);
      CharSequence _xifexpression = null;
      Attribute _last = IterableExtensions.<Attribute>last(path);
      RefableType _refType = _last.getRefType();
      DataType _type = _refType.getType();
      boolean _isDataClass = this.typeHelpers.isDataClass(_type);
      if (_isDataClass) {
        StringConcatenation _builder = new StringConcatenation();
        {
          Attribute _last_1 = IterableExtensions.<Attribute>last(path);
          RefableType _refType_1 = _last_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(((DataClass) _type_1));
          for(final Attribute e : _allAttributes) {
            String _plus = (varNamePath + "_");
            String _name = e.getName();
            String _plus_1 = (_plus + _name);
            List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
            CharSequence _genMinMaxConstantsRec = this.genMinMaxConstantsRec(ac, _plus_1, _union);
            _builder.append(_genMinMaxConstantsRec, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        Attribute _last_2 = IterableExtensions.<Attribute>last(path);
        RefableType _refType_2 = _last_2.getRefType();
        DataType _type_2 = _refType_2.getType();
        if ((_type_2 instanceof ExternalType)) {
          _xifexpression_1 = null;
        } else {
          CharSequence _xblockexpression_1 = null;
          {
            Attribute _last_3 = IterableExtensions.<Attribute>last(path);
            RefableType _refType_3 = _last_3.getRefType();
            DataType _type_3 = _refType_3.getType();
            PrimitiveType aType = ((PrimitiveType) _type_3);
            StringConcatenation _builder_1 = new StringConcatenation();
            {
              String _attrClassConfigMinValue = this.dataConfigExt.getAttrClassConfigMinValue(ac, path);
              String _temp = temp = _attrClassConfigMinValue;
              boolean _notEquals = (!Objects.equal(_temp, null));
              if (_notEquals) {
                _builder_1.append("public static ");
                String _minMaxType = this.getMinMaxType(aType);
                _builder_1.append(_minMaxType, "");
                _builder_1.append(" MIN_");
                _builder_1.append(varNamePath, "");
                _builder_1.append(" = ");
                String _valueLiteral = this.stdExt.toValueLiteral(aType, temp);
                _builder_1.append(_valueLiteral, "");
                _builder_1.append(";");
                _builder_1.newLineIfNotEmpty();
              }
            }
            {
              String _attrClassConfigMaxValue = this.dataConfigExt.getAttrClassConfigMaxValue(ac, path);
              String _temp_1 = temp = _attrClassConfigMaxValue;
              boolean _notEquals_1 = (!Objects.equal(_temp_1, null));
              if (_notEquals_1) {
                _builder_1.append("public static ");
                String _minMaxType_1 = this.getMinMaxType(aType);
                _builder_1.append(_minMaxType_1, "");
                _builder_1.append(" MAX_");
                _builder_1.append(varNamePath, "");
                _builder_1.append(" = ");
                String _valueLiteral_1 = this.stdExt.toValueLiteral(aType, temp);
                _builder_1.append(_valueLiteral_1, "");
                _builder_1.append(";");
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
  
  private String getMinMaxType(final PrimitiveType type) {
    String _switchResult = null;
    String _typeName = this.typeHelpers.typeName(type);
    final String _switchValue = _typeName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        _switchResult = "int";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        _switchResult = "double";
      }
    }
    if (!_matched) {
      String _typeName_1 = this.typeHelpers.typeName(type);
      _switchResult = _typeName_1;
    }
    return _switchResult;
  }
}
