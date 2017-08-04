package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;

public class StringToDetailCode extends Converter {

	private boolean emptyIsNull;

	public StringToDetailCode(boolean emptyIsNull) {
		super(String.class, DetailCode.class);
		this.emptyIsNull = emptyIsNull;
	}

	public StringToDetailCode() {
		this(true);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof String) {
			String code = (String) fromObject;
			if (code.isEmpty() || code.trim().isEmpty())
				return emptyIsNull? null:createEmptyDetailCode();
			
			DetailCode dc = FSMFactory.eINSTANCE.createDetailCode();
			dc.getLines().add(code);
			
			return dc;
		}
		return null;
	}

	/**
	 * @return
	 */
	private DetailCode createEmptyDetailCode() {
		DetailCode dc = FSMFactory.eINSTANCE.createDetailCode();
		dc.getLines().add("");
		dc.setUsed(false);
		return dc;
	}

}
