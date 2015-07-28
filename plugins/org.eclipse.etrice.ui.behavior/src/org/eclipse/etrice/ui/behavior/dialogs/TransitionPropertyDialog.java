package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.detailcode.GuardDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.detailcode.RuntimeDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.AbstractMemberAwarePropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.DetailCodeToString;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ITransitionPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.StringToDetailCode;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.TransitionTriggerCompartment;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;

public class TransitionPropertyDialog extends AbstractMemberAwarePropertyDialog implements ITransitionPropertyDialog {

	protected static class NameValidator implements IValidator {

		private Transition trans;

		public NameValidator(Transition trans) {
			this.trans = trans;
		}
		
		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = SupportUtil.getInstance().getFSMValidationUtil().isUniqueName(trans, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}
	
	protected static class GuardValidator implements IValidator {

		private String text;
		
		public GuardValidator(String text) {
			this.text = text;
			
		}
		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				if (name.isEmpty())
					return ValidationStatus.error(text);
			}
			else if (value instanceof DetailCode) {
				if (SupportUtil.getInstance().getFSMHelpers().getDetailCode((DetailCode)value).trim().isEmpty())
					return ValidationStatus.error(text);
			}
			return Status.OK_STATUS;
		}
	}
	
	private ActorClass ac;
	private Transition trans;
	private List<AbstractInterfaceItem> interfaceItems = new ArrayList<AbstractInterfaceItem>();
	private DetailCodeToString m2s;
	private StringToDetailCode s2m;
	private StringToDetailCode s2m_not_null;
	private DetailCodeToString m2s_null_empty;
	private boolean triggerError = false;
	private boolean inherited;
	private RefinedTransition refined;
	private String codeSelectionString = "";
	private String messageToDisplay = "";
	private String messageTitle = "";
	private TransitionTriggerCompartment triggerCompartment = null;

	public TransitionPropertyDialog(Shell shell, ActorClass ac, Transition trans) {
		super(shell, "Edit Transition", ac);
		this.ac = ac;
		this.trans = trans;

		Activator.getDefault().getInjector().injectMembers(this);
		
		m2s = new DetailCodeToString();
		m2s_null_empty = new DetailCodeToString(true);
		s2m = new StringToDetailCode();
		s2m_not_null = new StringToDetailCode(false);
		
		RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
		for(InterfaceItem item : roomHelpers.getAllInterfaceItems(ac)){
			ProtocolClass pc = roomHelpers.getProtocol(item);
			if(pc != null && pc.getCommType() == CommunicationType.EVENT_DRIVEN)
				interfaceItems.add(item);
		}
		
		inherited = roomHelpers.getActorClass(trans)!=ac;
		
		refined = null;
		if (inherited) {
			if (getModelComponent().getStateMachine()!=null)
				for (RefinedTransition rt : getModelComponent().getStateMachine().getRefinedTransitions()) {
					if (rt.getTarget()==trans) {
						refined = rt;
						break;
					}
				}
		}
		
		if (inherited && refined==null)
			setTitle("View Transition");
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body, DataBindingContext bindingContext) {
		
		if (!(trans instanceof InitialTransition)) {
			NameValidator nv = new NameValidator(trans);
			
			if (inherited) {
				createFixedText(body, "&Name:", trans.getName(), false);
			}
			else {
				Text name = createText(body, "&Name:", trans, FSMPackage.eINSTANCE.getTransition_Name(), nv);
				configureMemberAwareness(name);
				
				createDecorator(name, "invalid name");
				
				name.selectAll();
				name.setFocus();
				if (!codeSelectionString.isEmpty())
					name.setEnabled(false);
			}
		}
		
		if (trans instanceof TriggeredTransition) {
			triggerCompartment = new TransitionTriggerCompartment(this, trans, interfaceItems, inherited, this);
			triggerCompartment.createTriggerCompartment(body, mform.getToolkit());

			triggerError = !triggerCompartment.triggersAvailable();
		}
		
		FSMHelpers fsmHelpers = SupportUtil.getInstance().getFSMHelpers();

		if (trans instanceof GuardedTransition) {
			GuardedTransition guardedTrans = (GuardedTransition) trans;
			if (inherited) {
				String code = fsmHelpers.getDetailCode(guardedTrans.getGuard());
				createFixedText(body, "&Guard:", code, true);
			}
			else {
				GuardValidator gv = new GuardValidator("guard must not be empty");

				createActionCodeEditor(body, "&Guard:", guardedTrans.getGuard(),
						trans,
						FSMPackage.eINSTANCE.getGuardedTransition_Guard(), gv,
						s2m_not_null, m2s_null_empty, true, true, true,
						"empty guard", new GuardDetailExpressionProvider(ac));
			}
		}
		
		if (trans instanceof CPBranchTransition) {
			if (inherited) {
				String code = fsmHelpers.getDetailCode(((CPBranchTransition) trans).getCondition());
				createFixedText(body, "&Condition", code, true);
			}
			else {
				GuardValidator gv = new GuardValidator("condition must not be empty");

				createActionCodeEditor(
						body,
						"&Condition:",
						trans.getAction(),
						trans,
						FSMPackage.eINSTANCE.getCPBranchTransition_Condition(),
						gv, s2m_not_null, m2s_null_empty, true, true, true,
						"empty condition", new GuardDetailExpressionProvider(ac));
			}
		}

		{
			String code = fsmHelpers.getInheritedActionCode(trans, getModelComponent());
			if (code!=null){
				Text baseActionCode = createFixedText(body, "Base Action Code:", code, true);
				setTextSelectionAndFocus(baseActionCode, codeSelectionString);
			}
		}
		
		if (inherited) {
			if (refined!=null) {
				createActionCodeEditor(body, "&Action Code:",
						refined.getAction(), refined,
						FSMPackage.eINSTANCE.getRefinedTransition_Action(),
						null, s2m, m2s, true, true, false, null, new RuntimeDetailExpressionProvider(ac));
			}
		}
		else
		{
			createActionCodeEditor(body, "&Action Code:", trans.getAction(),
					trans, FSMPackage.eINSTANCE.getTransition_Action(), null,
					s2m, m2s, true, true, false, null, new RuntimeDetailExpressionProvider(ac));
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

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog#updateValidationFeedback(boolean)
	 */
	@Override
	protected void updateValidationFeedback(boolean ok) {
		if (ok && triggerError) {
			ok = false;
			setValidationText("no triggers available");
		}
		if (ok && inherited && refined==null) {
			setValidationFeedbackOff();
			return;
		}
		super.updateValidationFeedback(ok);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		if (inherited || triggerCompartment==null || !triggerCompartment.triggersAvailable()) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
	}

	public void setCodeSelectionString(String selectionString){
		this.codeSelectionString = selectionString;
	}

	public void setMessageDialogContents(String message, String title) {
		messageToDisplay = message;
		messageTitle = title; 
	}
	
	
	/**
	 * Creates Action Code Editor for the Transition/Guard with the given
	 * parameters and binds it with the model.
	 * 
	 * @author jayant
	 * 
	 * @param parent
	 *            the {@link Composite} which will hold the editor
	 * @param label
	 *            the label for the editor
	 * @param detailCode
	 *            the {@link DetailCode} object to be represented
	 * @param obj
	 *            the EMF object containing the detailCode code
	 * @param feat
	 *            the {@link EStructuralFeature} associated with the code
	 * @param singleValidator
	 *            an {@link IValidator} for the JFace Data binding
	 * @param s2m
	 *            a String to Model converter
	 * @param m2s
	 *            a Model to string converter
	 * @param useMembers
	 *            true if the editor is to be member aware
	 * @param useMessages
	 *            true if the editor is to be message aware
	 * @param useRecvMessagesOnly
	 *            true if the editor could use receive messages only
	 * @param decoratorString
	 *            the decorator string to attach to the editor's control
	 * 
	 * @return the constructed instance of {@link IActionCodeEditor}
	 */
	private void createActionCodeEditor(Composite parent, String label,
			DetailCode detailCode, EObject obj, EStructuralFeature feat,
			IValidator singleValidator, IConverter s2m, IConverter m2s,
			boolean useMembers, boolean useMessages,
			boolean useRecvMessagesOnly, String decoratorString, IDetailExpressionProvider exprProvider) {

		IActionCodeEditor entry = super.createActionCodeEditor(parent, label,
				detailCode, obj, feat, singleValidator, null, s2m, m2s,
				useMembers, useMessages, useRecvMessagesOnly, exprProvider);

		Control control;
		if (entry != null)
			control = entry.getControl();
		else {
			// if action editor cannot be created, create a simple SWT Text
			// widget.
			Text textEntry = createText(parent, label, obj, feat, null, s2m,
					m2s, true);
			configureMemberAwareness(textEntry, useMembers, useMessages,
					useRecvMessagesOnly);
			control = textEntry;
		}

		// set layout for the created control
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 100;
		control.setLayoutData(gd);
		if (decoratorString != null)
			createDecorator(control, decoratorString);

		// TODO Change IActionCodeEditor API to allow append or change
		// the quick fix method
		// setTextSelectionAndFocus(entry, codeSelectionString);
	}

	@Override
	protected String getFeatureContextHelpId() {
		// TODO add context help
		return null;
	}
}
