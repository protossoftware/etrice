package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;

public class NullLogger implements ILogger {

	private int errors = 0;
	
    @Override
    public void logInfo(String text) {
    }

    @Override
    public void logError(String text, EObject obj) {
    	++errors;
    }

	@Override
	public void logError(String text) {
    	++errors;
	}

	@Override
	public boolean hasErrors() {
		return errors!=0;
	}

}
