package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CppProcedureHelpers extends ProcedureHelpers {
  protected CharSequence getterHeader(final Attribute attribute, final String classname) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _and = false;
      int _size = attribute.getSize();
      boolean _equals = (_size == 0);
      if (!_equals) {
        _and = false;
      } else {
        boolean _or = false;
        RefableType _type = attribute.getType();
        DataType _type_1 = _type.getType();
        boolean _isPrimitive = this._typeHelpers.isPrimitive(_type_1);
        if (_isPrimitive) {
          _or = true;
        } else {
          RefableType _type_2 = attribute.getType();
          boolean _isRef = _type_2.isRef();
          _or = _isRef;
        }
        _and = _or;
      }
      if (_and) {
        _xifexpression = " const";
      } else {
        _xifexpression = "";
      }
      final String constModifier = _xifexpression;
      CharSequence _terHeader = super.getterHeader(attribute, classname);
      _xblockexpression = (_terHeader + constModifier);
    }
    return _xblockexpression;
  }
  
  public String declarationString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    if (!_matched) {
      int _size = it.getSize();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _matched=true;
        _switchResult = super.declarationString(it);
      }
    }
    if (!_matched) {
      RefableType _type = it.getType();
      String _signatureString = super.signatureString(_type);
      String _plus = (_signatureString + " ");
      String _name = it.getName();
      _switchResult = (_plus + _name);
    }
    return _switchResult;
  }
  
  public String signatureString(final RefableType type) {
    String _switchResult = null;
    final RefableType it = type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(it, null)) {
        _matched=true;
        _switchResult = "void";
      }
    }
    if (!_matched) {
      boolean _or = false;
      boolean _isRef = it.isRef();
      if (_isRef) {
        _or = true;
      } else {
        DataType _type = type.getType();
        boolean _isPrimitive = this._typeHelpers.isPrimitive(_type);
        _or = _isPrimitive;
      }
      boolean _not = (!_or);
      if (_not) {
        _matched=true;
        String _signatureString = super.signatureString(type);
        _switchResult = (_signatureString + "&");
      }
    }
    if (!_matched) {
      _switchResult = super.signatureString(type);
    }
    return _switchResult;
  }
  
  public String signatureString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    if (!_matched) {
      int _size = it.getSize();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _matched=true;
        String _signatureString = super.signatureString(attribute);
        _switchResult = (_signatureString + "&");
      }
    }
    if (!_matched) {
      RefableType _type = it.getType();
      _switchResult = this.signatureString(_type);
    }
    return _switchResult;
  }
  
  /**
   * @param attributes a list of {@link Attribute}s
   * @return an argument list for the attributes with const except for ref {@link Attribute}s
   */
  public String constArgList(final Iterable<Attribute> attributes) {
    final Function1<Attribute, String> _function = new Function1<Attribute, String>() {
      public String apply(final Attribute it) {
        String _xifexpression = null;
        RefableType _type = it.getType();
        boolean _isRef = _type.isRef();
        boolean _not = (!_isRef);
        if (_not) {
          _xifexpression = "const ";
        } else {
          _xifexpression = "";
        }
        String _signatureString = CppProcedureHelpers.this.signatureString(it);
        String _plus = (_xifexpression + _signatureString);
        String _plus_1 = (_plus + " ");
        String _name = it.getName();
        return (_plus_1 + _name);
      }
    };
    Iterable<String> _map = IterableExtensions.<Attribute, String>map(attributes, _function);
    return IterableExtensions.join(_map, ", ");
  }
}
