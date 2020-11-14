/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.fsm.validation.FSMValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ImportUriValidator;

@ComposedChecks(validators = {ImportUriValidator.class, ValidatorExtensionManager.class, RoomNamesAreUniqueValidator.class, InterfaceContractValidator.class, WiringValidator.class})
public abstract class AbstractRoomValidator extends FSMValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
		result.add(org.eclipse.etrice.core.room.RoomPackage.eINSTANCE);
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/etrice/core/fsm/FSM"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/etrice/core/common/Base"));
		return result;
	}
}
