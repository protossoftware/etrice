package org.eclipse.etrice.generator.java.gen;

import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;

public class JavaLanguageGenerator extends AbstractTransitionChainGenerator {

	@Override
	public String[] generateArglistAndTypedData(VarDecl data) {
		if (data==null)
			return new String[] {"", "", ""};
		
		String typeName = data.getRefType().getType().getName();
		String castTypeName = typeName;
		if (data.getRefType().getType() instanceof PrimitiveType) {
			typeName = ((PrimitiveType)data.getRefType().getType()).getTargetName();
			String ct = ((PrimitiveType)data.getRefType().getType()).getCastName();
			if (ct!=null && !ct.isEmpty())
				castTypeName = ct;
		}

		String typedData = typeName+" "+data.getName() + " = ("+castTypeName+") generic_data;\n";
		String dataArg = ", "+data.getName();
		String typedArgList = ", "+typeName+" "+data.getName();
		
		return new String[]{dataArg, typedData, typedArgList};
	}

}
