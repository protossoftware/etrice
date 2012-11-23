package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Initialization {
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private ProcedureHelpers procedureHelpers;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  public CharSequence attributeInitialization(final List<Attribute> attribs, final EObject roomClass, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        CharSequence _attributeClassInit = this.attributeClassInit(a, roomClass, useClassDefaultsOnly);
        _builder.append(_attributeClassInit, "");
        _builder.newLineIfNotEmpty();
        {
          RefableType _refType = a.getRefType();
          DataType _type = _refType.getType();
          boolean _isDataClass = this.typeHelpers.isDataClass(_type);
          if (_isDataClass) {
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            CharSequence _attributeInitPrimitiveRec = this.attributeInitPrimitiveRec(_union, roomClass);
            _builder.append(_attributeInitPrimitiveRec, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence attributeClassInit(final Attribute a, final EObject roomClass, final boolean useClassDefaultsOnly) {
    CharSequence _xblockexpression = null;
    {
      RefableType _refType = a.getRefType();
      DataType aType = _refType.getType();
      CharSequence _xifexpression = null;
      RefableType _refType_1 = a.getRefType();
      boolean _isRef = _refType_1.isRef();
      if (_isRef) {
        CharSequence _xifexpression_1 = null;
        String _defaultValueLiteral = a.getDefaultValueLiteral();
        boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
        if (_notEquals) {
          String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
          CharSequence _attributeInit = this.attributeInit(a, _defaultValueLiteral_1);
          _xifexpression_1 = _attributeInit;
        } else {
          CharSequence _xifexpression_2 = null;
          boolean _not = (!useClassDefaultsOnly);
          if (_not) {
            String _nullPointer = this.languageExt.nullPointer();
            CharSequence _attributeInit_1 = this.attributeInit(a, _nullPointer);
            _xifexpression_2 = _attributeInit_1;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        CharSequence _xifexpression_3 = null;
        boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
        if (_isPrimitive) {
          CharSequence _xblockexpression_1 = null;
          {
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            String value = this.getDataConfigValueLiteral(_union, roomClass);
            boolean _equals = Objects.equal(value, null);
            if (_equals) {
              String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
              value = _defaultValueLiteral_2;
            }
            CharSequence _xifexpression_4 = null;
            boolean _notEquals_1 = (!Objects.equal(value, null));
            if (_notEquals_1) {
              String _valueLiteral = this.languageExt.toValueLiteral(((PrimitiveType) aType), value);
              CharSequence _attributeInit_2 = this.attributeInit(a, _valueLiteral);
              _xifexpression_4 = _attributeInit_2;
            } else {
              CharSequence _xifexpression_5 = null;
              boolean _not_1 = (!useClassDefaultsOnly);
              if (_not_1) {
                String _defaultValue = this.languageExt.defaultValue(aType);
                CharSequence _attributeInit_3 = this.attributeInit(a, _defaultValue);
                _xifexpression_5 = _attributeInit_3;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xblockexpression_1 = (_xifexpression_4);
          }
          _xifexpression_3 = _xblockexpression_1;
        } else {
          String _defaultValue = this.languageExt.defaultValue(aType);
          CharSequence _attributeInit_2 = this.attributeInit(a, _defaultValue);
          _xifexpression_3 = _attributeInit_2;
        }
        _xifexpression = _xifexpression_3;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private CharSequence attributeInitPrimitiveRec(final List<Attribute> path, final EObject roomClass) {
    Attribute a = IterableExtensions.<Attribute>last(path);
    RefableType _refType = a.getRefType();
    DataType aType = _refType.getType();
    boolean _isDataClass = this.typeHelpers.isDataClass(aType);
    if (_isDataClass) {
      StringConcatenation _builder = new StringConcatenation();
      {
        List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(((DataClass) aType));
        for(final Attribute e : _allAttributes) {
          List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
          CharSequence _attributeInitPrimitiveRec = this.attributeInitPrimitiveRec(_union, roomClass);
          _builder.append(_attributeInitPrimitiveRec, "");
          _builder.newLineIfNotEmpty();
        }
      }
      return _builder;
    } else {
      boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
      if (_isPrimitive) {
        String value = this.getDataConfigValueLiteral(path, roomClass);
        CharSequence _xifexpression = null;
        boolean _notEquals = (!Objects.equal(value, null));
        if (_notEquals) {
          CharSequence _attributeInit = this.attributeInit(path, value);
          _xifexpression = _attributeInit;
        }
        return _xifexpression;
      }
    }
    return null;
  }
  
  private CharSequence attributeInit(final Attribute a, final String value) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
    CharSequence _attributeInit = this.attributeInit(_union, value);
    return _attributeInit;
  }
  
  private CharSequence attributeInit(final List<Attribute> path, final String value) {
    Attribute a = IterableExtensions.<Attribute>last(path);
    RefableType _refType = a.getRefType();
    DataType aType = _refType.getType();
    String _xifexpression = null;
    int _size = path.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      int _size_1 = path.size();
      int _minus = (_size_1 - 1);
      Iterable<Attribute> _take = IterableExtensions.<Attribute>take(path, _minus);
      CharSequence _invokeGetters = this.procedureHelpers.invokeGetters(_take, null);
      String _plus = (_invokeGetters + ".");
      _xifexpression = _plus;
    } else {
      _xifexpression = "";
    }
    String getter = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      int _size_2 = a.getSize();
      boolean _equals = (_size_2 == 0);
      if (_equals) {
        _or = true;
      } else {
        boolean _isCharacterType = this.typeHelpers.isCharacterType(aType);
        _or = (_equals || _isCharacterType);
      }
      if (_or) {
        _builder.append(getter, "");
        String _name = a.getName();
        CharSequence _invokeSetter = this.procedureHelpers.invokeSetter(_name, null, value);
        _builder.append(_invokeSetter, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        String _trim = value.trim();
        boolean _startsWith = _trim.startsWith("{");
        boolean _not = (!_startsWith);
        if (_not) {
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          String _typeName = this.typeHelpers.typeName(aType);
          _builder.append(_typeName, "	");
          _builder.append("[] ");
          String _name_1 = a.getName();
          _builder.append(_name_1, "	");
          _builder.append(" = new ");
          String _typeName_1 = this.typeHelpers.typeName(aType);
          _builder.append(_typeName_1, "	");
          _builder.append("[");
          int _size_3 = a.getSize();
          _builder.append(_size_3, "	");
          _builder.append("];");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("for (int i=0;i<");
          int _size_4 = a.getSize();
          _builder.append(_size_4, "	");
          _builder.append(";i++){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          String _name_2 = a.getName();
          _builder.append(_name_2, "		");
          _builder.append("[i] = ");
          _builder.append(value, "		");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(getter, "	");
          String _name_3 = a.getName();
          String _name_4 = a.getName();
          CharSequence _invokeSetter_1 = this.procedureHelpers.invokeSetter(_name_3, null, _name_4);
          _builder.append(_invokeSetter_1, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append(getter, "");
          String _name_5 = a.getName();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("new ");
          String _typeName_2 = this.typeHelpers.typeName(aType);
          _builder_1.append(_typeName_2, "");
          _builder_1.append("[] ");
          _builder_1.append(value, "");
          CharSequence _invokeSetter_2 = this.procedureHelpers.invokeSetter(_name_5, null, _builder_1.toString());
          _builder.append(_invokeSetter_2, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }
  
  private String getDataConfigValueLiteral(final List<Attribute> path, final EObject roomClass) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (roomClass instanceof ActorClass) {
        final ActorClass _actorClass = (ActorClass)roomClass;
        _matched=true;
        String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(_actorClass, path);
        _switchResult = _attrClassConfigValue;
      }
    }
    if (!_matched) {
      if (roomClass instanceof PortClass) {
        final PortClass _portClass = (PortClass)roomClass;
        _matched=true;
        String _xifexpression = null;
        EObject _eContainer = _portClass.eContainer();
        if ((_eContainer instanceof ProtocolClass)) {
          String _xblockexpression = null;
          {
            EObject _eContainer_1 = _portClass.eContainer();
            ProtocolClass pc = ((ProtocolClass) _eContainer_1);
            PortClass _regular = pc.getRegular();
            boolean _equals = _regular.equals(_portClass);
            String _attrClassConfigValue = this.dataConfigExt.getAttrClassConfigValue(pc, _equals, path);
            _xblockexpression = (_attrClassConfigValue);
          }
          _xifexpression = _xblockexpression;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (roomClass instanceof DataClass) {
        final DataClass _dataClass = (DataClass)roomClass;
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }
}
