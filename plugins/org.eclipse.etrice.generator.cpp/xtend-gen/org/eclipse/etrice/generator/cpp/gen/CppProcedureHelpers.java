package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CppProcedureHelpers extends ProcedureHelpers {
  @Override
  protected CharSequence getterHeader(final Attribute attribute, final String classname) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if (((attribute.getSize() == 0) && (this._typeHelpers.isPrimitive(attribute.getType().getType()) || attribute.getType().isRef()))) {
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
  
  @Override
  public String declarationString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    int _size = it.getSize();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _matched=true;
      _switchResult = super.declarationString(it);
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
  
  @Override
  public String signatureString(final RefableType type) {
    String _switchResult = null;
    final RefableType it = type;
    boolean _matched = false;
    if (Objects.equal(it, null)) {
      _matched=true;
      _switchResult = "void";
    }
    if (!_matched) {
      boolean _not = (!(it.isRef() || this._typeHelpers.isPrimitive(type.getType())));
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
  
  @Override
  public String signatureString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    int _size = it.getSize();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _matched=true;
      String _signatureString = super.signatureString(attribute);
      _switchResult = (_signatureString + "&");
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
      @Override
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
