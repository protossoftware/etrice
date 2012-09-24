package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;

@Singleton
@SuppressWarnings("all")
public class TypeHelpers {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
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
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    return this.chainGenerator.generateTypedData(_data);
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
