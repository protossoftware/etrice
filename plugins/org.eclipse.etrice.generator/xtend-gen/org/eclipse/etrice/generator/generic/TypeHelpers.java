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
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Singleton
public class TypeHelpers {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  public String typeName(final DataType type) {
    if ((type instanceof PrimitiveType)) {
      String _targetName = ((PrimitiveType) type).getTargetName();
      return _targetName;
    } else {
      if ((type instanceof ExternalType)) {
        String _targetName_1 = ((ExternalType) type).getTargetName();
        return _targetName_1;
      } else {
        String _name = type.getName();
        return _name;
      }
    }
  }
  
  public String defaultValue(final DataType dt) {
    if ((dt instanceof PrimitiveType)) {
      String _defaultValueLiteral = ((PrimitiveType) dt).getDefaultValueLiteral();
      return _defaultValueLiteral;
    } else {
      if ((dt instanceof ExternalType)) {
        String _targetName = ((ExternalType) dt).getTargetName();
        String _operator_plus = StringExtensions.operator_plus("new ", _targetName);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "()");
        return _operator_plus_1;
      } else {
        String _name = dt.getName();
        String _operator_plus_2 = StringExtensions.operator_plus("new ", _name);
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "()");
        return _operator_plus_3;
      }
    }
  }
  
  public String defaultValue(final VarDecl a) {
    RefableType _refType = a.getRefType();
    DataType _type = _refType.getType();
    String _defaultValue = this.defaultValue(_type);
    return _defaultValue;
  }
  
  public String getTypedDataDefinition(final Message m) {
    String _generateTypedData = this.chainGenerator.generateTypedData(m);
    return _generateTypedData;
  }
}
