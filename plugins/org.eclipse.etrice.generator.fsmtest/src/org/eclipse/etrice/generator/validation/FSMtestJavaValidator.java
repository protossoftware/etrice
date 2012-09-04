package org.eclipse.etrice.generator.validation;

import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.Testscript;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;
import org.eclipse.xtext.validation.Check;
 

public class FSMtestJavaValidator extends AbstractFSMtestJavaValidator {


	@Check
	public void checkState(org.eclipse.etrice.generator.fsmtest.State state) {
		if (!canReach(state))
			error("You cannot reach state "+state.getName(), FsmtestPackage.Literals.STATE__NAME);
		if (!canLeave(state))
			error("You cannot leave state "+state.getName(), FsmtestPackage.Literals.STATE__NAME);
	}

	private boolean canReach(org.eclipse.etrice.generator.fsmtest.State state) {
		Testscript s = (Testscript) state.eContainer().eContainer();
		for (TransitionDeclaration t:s.getTransitionDeclarations()) {
			if (t.getDestination().getRef()==state)
				return true;
		}
		return false;
	}

	private boolean canLeave(org.eclipse.etrice.generator.fsmtest.State state) {
		Testscript s = (Testscript) state.eContainer().eContainer();
		for (TransitionDeclaration t:s.getTransitionDeclarations()) {
			if (t.getSource().getRef()==state)
				return true;
		}
		return false;
	}

}
