package org.eclipse.etrice.generator.c.gen;

import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;

public class CLanguageGenerator extends AbstractTransitionChainGenerator {
	
	public String[] generateArglistAndTypedData(VarDecl data) {
		if (data==null)
			return new String[] {"", "", ""};
		
		String typeName = data.getRefType().getType().getName();
		String castTypeName = typeName+"*";
		String typedData;
		String ref = "";
		if (data.getRefType().getType() instanceof PrimitiveType) {
			typeName = ((PrimitiveType)data.getRefType().getType()).getTargetName();
			castTypeName = typeName+"*";
			String ct = ((PrimitiveType)data.getRefType().getType()).getCastName();
			if (ct!=null && !ct.isEmpty()){
				castTypeName = ct;
			}
			if (data.getRefType().isRef()) {
				ref = "*";
				typedData = typeName+" "+data.getName() + " = **(("+castTypeName+"*) generic_data);\n";
			}
			else {
				typedData = typeName+" "+data.getName() + " = *(("+castTypeName+") generic_data);\n";
			}
		}
		else {
			if (data.getRefType().isRef()) {
				ref = "*";
				typeName = typeName+"*";
				typedData = typeName+" "+data.getName() + " = *(("+castTypeName+"*) generic_data);\n";
			}
			else{
				typeName = typeName+"*";
				typedData = typeName+" "+data.getName() + " = (("+castTypeName+") generic_data);\n";
			}
		}

		String dataArg = ", "+data.getName();
		String typedArgList = ", "+typeName+" "+ref+data.getName();
		
		return new String[]{dataArg, typedData, typedArgList};
	}

}
