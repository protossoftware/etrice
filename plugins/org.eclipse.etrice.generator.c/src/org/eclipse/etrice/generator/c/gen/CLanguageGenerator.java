package org.eclipse.etrice.generator.c.gen;

import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractLanguageGenerator;

public class CLanguageGenerator extends AbstractLanguageGenerator {
	
	public String[] getArglistAndTypedData(VarDecl data) {
		if (data==null)
			return new String[] {"", "", ""};
		
		String typeName = data.getRefType().getType().getName();
		String castTypeName = typeName+"*";
		boolean byVal = false;
		if (data.getRefType().getType() instanceof PrimitiveType) {
			typeName = ((PrimitiveType)data.getRefType().getType()).getTargetName();
			castTypeName = typeName+"*";
			String ct = ((PrimitiveType)data.getRefType().getType()).getCastName();
			byVal = true;
			if (ct!=null && !ct.isEmpty())
				castTypeName = ct;
		}
		else {
			typeName = typeName+"*";
		}

		String typedData = typeName+" "+data.getName() + " = "+(byVal? "*":"")+"(("+castTypeName+") generic_data);\n";
		String dataArg = ", "+data.getName();
		String typedArgList = ", "+typeName+" "+data.getName();
		
		return new String[]{dataArg, typedData, typedArgList};
	}

}
