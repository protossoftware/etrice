package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.EnumSet;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.AbstractMemberAwarePropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.DetailCodeToString;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IStatePropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.QuickFixDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.StringToDetailCode;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class StatePropertyDialog extends AbstractMemberAwarePropertyDialog implements IStatePropertyDialog {

	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = SupportUtil.getInstance().getFSMValidationUtil().isUniqueName(state, name);
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

		Activator.getDefault().getInjector().injectMembers(this);
		
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
			
			Text name = createText(body, "&Name:", state, FSMPackage.eINSTANCE.getSimpleState_Name(), nv);
			configureMemberAwareness(name);
			
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

			createActionCodeEditor(body, "&Entry Code:", state.getEntryCode(),
					FSMPackage.eINSTANCE.getState_EntryCode(), s2m, m2s);
		}

		if (inherited) {
			String code = roomHelpers.getDetailCode(state.getExitCode());
			if (state instanceof RefinedState)
				code = roomHelpers.getBaseExitCode((RefinedState)state) + code;
			Text entry = createFixedText(body, "Exit Code:", code, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			entry.setLayoutData(gd);
		}
		else {
			createActionCodeEditor(body, "E&xit Code:", state.getExitCode(),
					FSMPackage.eINSTANCE.getState_ExitCode(), s2m, m2s);

			if (state instanceof RefinedState)
			{
				String code = roomHelpers.getBaseExitCode((RefinedState)state);
				Text entry = createFixedText(body, "Base Exit Code:", code, true);
				GridData gd = new GridData(GridData.FILL_BOTH);
				gd.heightHint = 100;
				entry.setLayoutData(gd);
			}
		}

		ActorClass ac = roomHelpers.getActorClass(state);
		if (ac.getCommType()!=ComponentCommunicationType.EVENT_DRIVEN)
			createActionCodeEditor(body, "&Do Code:", state.getDoCode(),
					FSMPackage.eINSTANCE.getState_DoCode(), s2m, m2s);

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

	/**
	 * Creates Action Code Editor with the given parameters for the
	 * {@link #state} and binds it with the model.
	 * 
	 * @author jayant
	 * 
	 * @param parent
	 *            the {@link Composite} which will hold the editor
	 * @param label
	 *            the label for the editor
	 * @param detailCode
	 *            the {@link DetailCode} object to be represented
	 * @param feat
	 *            the {@link EStructuralFeature} associated with the code
	 * @param s2m
	 *            a String to Model converter
	 * @param m2s
	 *            a Model to string converter
	 * 
	 * @return the constructed instance of {@link IActionCodeEditor}
	 */
	private void createActionCodeEditor(Composite parent, String label,
			DetailCode detailCode, EStructuralFeature feat,
			StringToDetailCode s2m, DetailCodeToString m2s) {

		IActionCodeEditor entry = super.createActionCodeEditor(parent, label,
				detailCode, state, feat, s2m, m2s);

		Control control;
		if (entry != null)
			control = entry.getControl();
		else {
			// if action editor cannot be created, create a simple SWT Text
			// widget.
			Text textEntry = createText(parent, label, state, feat, null, s2m,
					m2s, true);
			configureMemberAwareness(textEntry, true, true);
			control = textEntry;
		}

		//set layout for the created control
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 100;
		control.setLayoutData(gd);

		// TODO Change IActionCodeEditor API to allow append or change
		// the quick fix method
		/*if (where.contains(Where.ENTRY)) {
			if (addCode)
				entry.append(codeSelectionString + "();\n");
			setTextSelectionAndFocus(entry, codeSelectionString);
		}*/
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

	@Override
	protected String getFeatureContextHelpId() {
		// TODO add context help
		return null;
	}
}
