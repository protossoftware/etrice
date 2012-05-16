package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.etrice.core.validation.ValidationUtil.Result;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class StatePropertyDialog extends AbstractMemberAwarePropertyDialog {

	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = ValidationUtil.isUniqueName(state, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}

	private State state;

	public StatePropertyDialog(Shell shell, ActorClass ac, State s) {
		super(shell, "Edit State", ac);
		this.state = s;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {

		if (state instanceof SimpleState) {
			NameValidator nv = new NameValidator();
			
			Text name = createText(body, "&Name:", state, RoomPackage.eINSTANCE.getSimpleState_Name(), nv);
			configureMemberAware(name);
			
			createDecorator(name, "invalid name");
			
			name.setFocus();
			name.selectAll();
		}
		else {
			Text name = mform.getToolkit().createText(body, "Name:", SWT.BORDER);
			name.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			name.setEnabled(false);
		}

		DetailCodeToString m2s = new DetailCodeToString();
		StringToDetailCode s2m = new StringToDetailCode();
		
		{
			Text entry = createText(body, "&Entry Code:", state, RoomPackage.eINSTANCE.getState_EntryCode(), null, s2m, m2s, true);
			configureMemberAware(entry, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			entry.setLayoutData(gd);
		}
		
		{
			Text exit = createText(body, "E&xit Code:", state, RoomPackage.eINSTANCE.getState_ExitCode(), null, s2m, m2s, true);
			configureMemberAware(exit, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			exit.setLayoutData(gd);
		}
		
		ActorClass ac = RoomHelpers.getActorClass(state);
		if (ac.getCommType()!=ActorCommunicationType.EVENT_DRIVEN)
		{
			Text dotxt = createText(body, "&Do Code:", state, RoomPackage.eINSTANCE.getState_DoCode(), null, s2m, m2s, true);
			configureMemberAware(dotxt, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			dotxt.setLayoutData(gd);
		}
		
		createMembersAndMessagesButtons(body);
	}

}
