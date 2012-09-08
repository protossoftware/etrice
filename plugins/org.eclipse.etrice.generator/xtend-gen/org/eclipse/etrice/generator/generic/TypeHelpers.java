package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;

@Singleton
@SuppressWarnings("all")
public class TypeHelpers {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
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
  
  public String defaultValue(final DataType dt) {
    if ((dt instanceof PrimitiveType)) {
      return ((PrimitiveType) dt).getDefaultValueLiteral();
    } else {
      if ((dt instanceof ExternalType)) {
        String _targetName = ((ExternalType) dt).getTargetName();
        String _plus = ("new " + _targetName);
        return (_plus + "()");
      } else {
        String _name = dt.getName();
        String _plus_1 = ("new " + _name);
        return (_plus_1 + "()");
      }
    }
  }
  
  public String defaultValue(final VarDecl a) {
    RefableType _refType = a.getRefType();
    DataType _type = _refType.getType();
    return this.defaultValue(_type);
  }
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    return this.chainGenerator.generateTypedData(_data);
  }
}
