package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.etrice.core.room.DetailCode;

public class DetailCodeToString extends Converter {

	private boolean nullIsEmpty;

	public DetailCodeToString() {
		this(false);
	}

	public DetailCodeToString(boolean nullIsEmpty) {
		super(DetailCode.class, String.class);
		this.nullIsEmpty = nullIsEmpty;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof DetailCode) {
			String result = "";
			for (String cmd : ((DetailCode) fromObject).getLines()) {
				result += cmd+"\n";
			}
			return result;
		}
		return nullIsEmpty? "":null;
	}
}
