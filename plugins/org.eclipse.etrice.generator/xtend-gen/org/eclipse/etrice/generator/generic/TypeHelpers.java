package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.xbase.lib.Conversions;

@Singleton
@SuppressWarnings("all")
public class TypeHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  public String typeName(final DataType type) {
    if ((type instanceof PrimitiveType)) {
      return ((PrimitiveType) type).getTargetName();
    } else {
      if ((type instanceof ExternalType)) {
        return ((ExternalType) type).getTargetName();
      } else {
        return type.getName();
      }
    }
  }
  
  public String defaultValue(final VarDecl a) {
    RefableType _refType = a.getRefType();
    DataType _type = _refType.getType();
    return this.languageExt.defaultValue(_type);
  }
  
  public String getArgumentList(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(0);
    return _get;
  }
  
  public String getTypedDataDefinition(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(1);
    return _get;
  }
  
  public String generateTypedArgumentList(final VarDecl data) {
    String[] _generateArglistAndTypedData = this.languageExt.generateArglistAndTypedData(data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(2);
    return _get;
  }
  
  public boolean isPrimitive(final DataType type) {
    return (type instanceof PrimitiveType);
  }
  
  public boolean isDataClass(final DataType type) {
    return (type instanceof DataClass);
  }
  
  public boolean isCharacterType(final PrimitiveType type) {
    LiteralType _type = type.getType();
    boolean _equals = Objects.equal(_type, LiteralType.CHAR);
    return _equals;
  }
  
  public boolean isCharacterType(final DataType type) {
    boolean _and = false;
    boolean _isPrimitive = this.isPrimitive(type);
    if (!_isPrimitive) {
      _and = false;
    } else {
      boolean _isCharacterType = this.isCharacterType(((PrimitiveType) type));
      _and = (_isPrimitive && _isCharacterType);
    }
    return _and;
  }
}
