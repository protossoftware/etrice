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
		//boolean byVal = false;
		if (data.getRefType().getType() instanceof PrimitiveType) {
			typeName = ((PrimitiveType)data.getRefType().getType()).getTargetName();
			castTypeName = typeName+"*";
			String ct = ((PrimitiveType)data.getRefType().getType()).getCastName();
			//byVal = true;
			if (ct!=null && !ct.isEmpty()){
				castTypeName = ct;
			}
			if (data.getRefType().isRef()) {
				//byVal = false;
				typedData = typeName+" "+data.getName() + " = **(("+castTypeName+"*) generic_data);\n";
			} else {
				//byVal = true;
				typedData = typeName+" "+data.getName() + " = *(("+castTypeName+") generic_data);\n";
			}
		}
		else {
			if (data.getRefType().isRef()) {
				typeName = typeName+"*";
				typedData = typeName+" "+data.getName() + " = *(("+castTypeName+"*) generic_data);\n";
			}else{
				typeName = typeName+"*";
				typedData = typeName+" "+data.getName() + " = (("+castTypeName+") generic_data);\n";
			}
		}

		//typedData = typeName+" "+data.getName() + " = "+(byVal? "*":"")+"(("+castTypeName+") generic_data);\n";
		String dataArg = ", "+data.getName();
		String typedArgList = ", "+typeName+" "+data.getName();
		
		return new String[]{dataArg, typedData, typedArgList};
	}

}
