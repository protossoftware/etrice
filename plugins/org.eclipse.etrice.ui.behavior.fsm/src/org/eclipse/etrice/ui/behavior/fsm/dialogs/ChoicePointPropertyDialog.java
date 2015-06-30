package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.dialogs.AbstractPropertyDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class ChoicePointPropertyDialog extends AbstractPropertyDialog implements IChoicePointPropertyDialog {
	
	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = FSMSupportUtil.getInstance().getFSMValidationUtil().isUniqueName(cp, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}

	private ChoicePoint cp;

	public ChoicePointPropertyDialog(Shell shell, ChoicePoint cp) {
		super(shell, "Edit Choice Point");
		this.cp = cp;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {

		NameValidator nv = new NameValidator();
		
		Text name = createText(body, "&Name:", cp, FSMPackage.eINSTANCE.getChoicePoint_Name(), nv);
		
		createDecorator(name, "invalid name");
		
		name.setFocus();
		name.selectAll();
	}

	@Override
	protected String getFeatureContextHelpId() {
		// TODO Auto-generated method stub
		return null;
	}

}
