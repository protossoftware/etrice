package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.EnumSet;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil.Result;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.jface.dialogs.MessageDialog;
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
				
				Result result = SupportUtil.getInstance().getValidationUtil().isUniqueName(state, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}

	private State state;
	private boolean inherited;

	/**
	 * Enum for quickfix. Used when {@link StatePropertyDialog} is invoked from
	 * {@link QuickFixDialog}.
	 * 
	 * @author jayant
	 * 
	 */
	public enum Where {
		ENTRY, EXIT, DO 
	}

	private boolean addCode = false;
	private String codeSelectionString = "";
	private EnumSet<Where> where = EnumSet.noneOf(Where.class);
	private String messageToDisplay = "";
	private String messageTitle = "";

	public StatePropertyDialog(Shell shell, ActorClass ac, State s, boolean edit) {
		super(shell, edit?"Edit State":"View State", ac);
		this.state = s;
		
		inherited = SupportUtil.getInstance().getRoomHelpers().getActorClass(s)!=ac;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {

		if (state instanceof SimpleState && !inherited) {
			NameValidator nv = new NameValidator();
			
			Text name = createText(body, "&Name:", state, RoomPackage.eINSTANCE.getSimpleState_Name(), nv);
			configureMemberAware(name);
			
			createDecorator(name, "invalid name");
			
			name.setFocus();
			name.selectAll();

			if (!where.isEmpty())
				name.setEnabled(false);
		}
		else {
			createFixedText(body, "Name:", state.getName(), false);
		}

		DetailCodeToString m2s = new DetailCodeToString();
		StringToDetailCode s2m = new StringToDetailCode();
		
		RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
		
		if (inherited) {
			String code = roomHelpers.getDetailCode(state.getEntryCode());
			if (state instanceof RefinedState)
				code += roomHelpers.getBaseEntryCode((RefinedState)state);
			Text entry = createFixedText(body, "Entry Code:", code, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			entry.setLayoutData(gd);

			if (where.contains(Where.ENTRY)) {
				if (addCode)
					entry.append(codeSelectionString + "();\n");
				setTextSelectionAndFocus(entry, codeSelectionString);
			}
		}
		else {
			if (state instanceof RefinedState)
			{
				String code = roomHelpers.getBaseEntryCode((RefinedState)state);
				Text entry = createFixedText(body, "Base Entry Code:", code, true);
				GridData gd = new GridData(GridData.FILL_BOTH);
				gd.heightHint = 100;
				entry.setLayoutData(gd);

				if (where.contains(Where.ENTRY)) {
					if (addCode)
						entry.append(codeSelectionString + "();\n");
					setTextSelectionAndFocus(entry, codeSelectionString);
				}
			}
			
			{
				Text entry = createText(body, "&Entry Code:", state, RoomPackage.eINSTANCE.getState_EntryCode(), null, s2m, m2s, true);
				configureMemberAware(entry, true, true);
				GridData gd = new GridData(GridData.FILL_BOTH);
				gd.heightHint = 100;
				entry.setLayoutData(gd);

				if (where.contains(Where.ENTRY)) {
					if (addCode)
						entry.append(codeSelectionString + "();\n");
					setTextSelectionAndFocus(entry, codeSelectionString);
				}
			}
		}
		
		if (inherited) {
			String code = roomHelpers.getDetailCode(state.getExitCode());
			if (state instanceof RefinedState)
				code = roomHelpers.getBaseExitCode((RefinedState)state) + code;
			Text entry = createFixedText(body, "Exit Code:", code, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			entry.setLayoutData(gd);

			if (where.contains(Where.EXIT)) {
				if (addCode)
					entry.append(codeSelectionString + "();\n");
				setTextSelectionAndFocus(entry, codeSelectionString);
			}
		}
		else {
			{
				Text exit = createText(body, "E&xit Code:", state, RoomPackage.eINSTANCE.getState_ExitCode(), null, s2m, m2s, true);
				configureMemberAware(exit, true, true);
				GridData gd = new GridData(GridData.FILL_BOTH);
				gd.heightHint = 100;
				exit.setLayoutData(gd);

				if (where.contains(Where.EXIT)) {
					if (addCode)
						exit.append(codeSelectionString + "();\n");
					setTextSelectionAndFocus(exit, codeSelectionString);
				}
			}
			
			if (state instanceof RefinedState)
			{
				String code = roomHelpers.getBaseExitCode((RefinedState)state);
				Text entry = createFixedText(body, "Base Exit Code:", code, true);
				GridData gd = new GridData(GridData.FILL_BOTH);
				gd.heightHint = 100;
				entry.setLayoutData(gd);

				if (where.contains(Where.EXIT)) {
					if (addCode)
						entry.append(codeSelectionString + "();\n");
					setTextSelectionAndFocus(entry, codeSelectionString);
				}
			}
		}
		
		ActorClass ac = roomHelpers.getActorClass(state);
		if (ac.getCommType()!=ActorCommunicationType.EVENT_DRIVEN)
		{
			Text dotxt = createText(body, "&Do Code:", state, RoomPackage.eINSTANCE.getState_DoCode(), null, s2m, m2s, true);
			configureMemberAware(dotxt, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			dotxt.setLayoutData(gd);

			if (where.contains(Where.DO)) {
				if (addCode)
					dotxt.append(codeSelectionString + "();\n");
				setTextSelectionAndFocus(dotxt, codeSelectionString);
			}
		}
		
		createMembersAndMessagesButtons(body);

		if (!messageToDisplay.isEmpty()) {
			getShell().getParent().getDisplay().asyncExec(new Runnable() {
				public void run() {
					MessageDialog.openInformation(getShell(), messageTitle,
							messageToDisplay);
				}
			});
		}
	}

	public void setAddCode(boolean add) {
		addCode = add;
	}

	public void setCodeSelectionString(String selectionString, EnumSet<Where> where) {
		this.where = where;
		codeSelectionString = selectionString;
	}

	public void setMessageDialogContents(String message, String title) {
		messageToDisplay = message;
		messageTitle = title;
	}
}
