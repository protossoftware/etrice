package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.etrice.core.validation.ValidationUtil.Result;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class TransitionPropertyDialog extends AbstractMemberAwarePropertyDialog {
	
	private class TriggerContentProvider implements IStructuredContentProvider {
		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getElements(Object inputElement) {
			if (trans instanceof TriggeredTransition) {
				return ((TriggeredTransition) trans).getTriggers().toArray();
			}
			return new Object[] {};
		}

	}

	private class TriggerLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof Trigger) {
				Trigger trig = (Trigger) element;
				return RoomNameProvider.getTriggerLabel(trig);
			}
			return super.getText(element);
		}
	}

	private class MessageFromInterfaceContentProvider implements IStructuredContentProvider {
		private Trigger currentTrigger = null;

		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Trigger)
				currentTrigger = (Trigger) newInput;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Trigger) {
				return ((Trigger) inputElement).getMsgFromIfPairs().toArray();
			}
			return new Object[] {};
		}

		public Trigger getCurrentTrigger() {
			return currentTrigger;
		}

	}

	private class MessageFromInterfaceLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof MessageFromIf) {
				MessageFromIf mif = (MessageFromIf) element;
				return RoomNameProvider.getMsgFromIfLabel(mif);
			}
			return super.getText(element);
		}
	}

	private class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = ValidationUtil.isUniqueName(trans, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}
	private class GuardValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				if (name.isEmpty())
					return ValidationStatus.error("guard must not be empty");
			}
			else if (value instanceof DetailCode) {
				if (RoomHelpers.getDetailCode((DetailCode)value).isEmpty())
					return ValidationStatus.error("guard must not be empty");
			}
			return Status.OK_STATUS;
		}
	}
	
	private Transition trans;
	private Combo messageCombo;
	private Combo interfaceCombo;
	private TableViewer mifViewer;
	private List<InterfaceItem> interfaceItems = new ArrayList<InterfaceItem>();
	private TableViewer triggerViewer;
	private List<Message> currentMsgs;
	private DetailCodeToString m2s;
	private StringToDetailCode s2m;
	private StringToDetailCode s2m_not_null;
	private DetailCodeToString m2s_null_empty;
	private Text guardText;
	private Button removeMifButton;
	private boolean triggerError = false;
	private boolean inherited;

	public TransitionPropertyDialog(Shell shell, ActorClass ac, Transition trans) {
		super(shell, "Edit Transition", ac);
		this.trans = trans;

		m2s = new DetailCodeToString();
		m2s_null_empty = new DetailCodeToString(true);
		s2m = new StringToDetailCode();
		s2m_not_null = new StringToDetailCode(false);
		
		interfaceItems = RoomHelpers.getAllInterfaceItems(ac);
		inherited = RoomHelpers.getActorClass(trans)!=ac;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body, DataBindingContext bindingContext) {
		
		if (!(trans instanceof InitialTransition)) {
			NameValidator nv = new NameValidator();
			
			Text name = createText(body, "&Name:", trans, RoomPackage.eINSTANCE.getTransition_Name(), nv);
			configureMemberAware(name);
			
			createDecorator(name, "invalid name");
			
			name.selectAll();
			name.setFocus();
		}
		
		if (trans instanceof TriggeredTransition) {
			FormToolkit toolkit = mform.getToolkit();

			Label l = toolkit.createLabel(body, "Triggers:", SWT.NONE);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			l.setLayoutData(gd);

			if (triggersAvailable()) {
				createTriggerCompartment(body, toolkit);
				addListeners();
				triggerViewer.setSelection(new StructuredSelection(((TriggeredTransition) trans).getTriggers().get(0)), true);
			}
			else {
				Label error = toolkit.createLabel(body, "No triggers available (interface item with incoming message missing).", SWT.NONE);
				gd = new GridData(GridData.FILL_HORIZONTAL);
				gd.horizontalSpan = 2;
				error.setLayoutData(gd);
				triggerError  = true;
			}
		}

		if (trans instanceof GuardedTransition) {
			GuardValidator gv = new GuardValidator();
			
			Text cond = createText(body, "&Guard:", trans, RoomPackage.eINSTANCE.getGuardedTransition_Guard(), gv, s2m_not_null, m2s_null_empty, true);
			configureMemberAware(cond, true, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			cond.setLayoutData(gd);
			
			createDecorator(cond, "empty guard");
		}
		
		if (trans instanceof CPBranchTransition) {
			Text cond = createText(body, "&Condition:", trans, RoomPackage.eINSTANCE.getCPBranchTransition_Condition(), null, s2m, m2s, true);
			configureMemberAware(cond, true, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			cond.setLayoutData(gd);
		}
		
		{
			Text action = createText(body, "&Action Code:", trans, RoomPackage.eINSTANCE.getTransition_Action(), null, s2m, m2s, true);
			configureMemberAware(action, true, true);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 100;
			action.setLayoutData(gd);
		}
		
		createMembersAndMessagesButtons(body);
		
		if (inherited)
			disableAll(body);
	}

	private void disableAll(Composite parent) {
		for (Control child : parent.getChildren()) {
			child.setEnabled(false);
			if (child instanceof Composite)
				disableAll((Composite) child);
		}
	}

	private boolean triggersAvailable() {
		if (interfaceItems.isEmpty())
			return false;
		
		for (InterfaceItem item : interfaceItems) {
			if (!RoomHelpers.getMessageList(item, false).isEmpty())
				return true;
		}
		return false;
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
		if (ok && inherited) {
			ok = false;
			setValidationText("inherited transition not editable");
		}
		super.updateValidationFeedback(ok);
	}
	
	private void createTriggerCompartment(Composite body, FormToolkit toolkit) {
		Composite triggerCompartment = toolkit.createComposite(body);
		triggerCompartment.setLayout(new GridLayout(3, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		triggerCompartment.setLayoutData(gd);
		
		createTriggerTable(triggerCompartment, toolkit);
		createMifTable(triggerCompartment, toolkit);
		
		createMifCompartment(triggerCompartment, toolkit);
	}

	private void createTriggerTable(Composite triggerCompartment, FormToolkit toolkit) {
		Composite tableCompartment = toolkit.createComposite(triggerCompartment);
		tableCompartment.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		tableCompartment.setLayoutData(gd);

		Table triggerTable = toolkit.createTable(tableCompartment, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 50;
		gd.widthHint = 100;
		gd.horizontalSpan = 2;
		triggerTable.setLayoutData(gd);
		triggerViewer = new TableViewer(triggerTable);
		triggerViewer.setContentProvider(new TriggerContentProvider());
		triggerViewer.setLabelProvider(new TriggerLabelProvider());
		triggerViewer.setInput(trans);
		configureMemberAware(triggerTable);
		
		if (((TriggeredTransition) trans).getTriggers().isEmpty())
			addNewTrigger();
		
		Button add = toolkit.createButton(tableCompartment, "Add", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		add.setLayoutData(gd);
		configureMemberAware(add);
		
		final Button remove = toolkit.createButton(tableCompartment, "Remove", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		remove.setLayoutData(gd);
		if (((TriggeredTransition) trans).getTriggers().size()==1)
			remove.setEnabled(false);
		configureMemberAware(remove);
		
		add.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addNewTrigger();
				remove.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		remove.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeCurrentTrigger();
				if (((TriggeredTransition) trans).getTriggers().size()==1)
					remove.setEnabled(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}

	private void createMifTable(Composite triggerCompartment, FormToolkit toolkit) {
		Composite tableCompartment = toolkit.createComposite(triggerCompartment);
		tableCompartment.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		tableCompartment.setLayoutData(gd);

		Table mifTable = toolkit.createTable(tableCompartment, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 50;
		gd.widthHint = 100;
		gd.horizontalSpan = 2;
		mifTable.setLayoutData(gd);
		mifViewer = new TableViewer(mifTable);
		mifViewer.setContentProvider(new MessageFromInterfaceContentProvider());
		mifViewer.setLabelProvider(new MessageFromInterfaceLabelProvider());
		configureMemberAware(mifTable);
		
		Button add = toolkit.createButton(tableCompartment, "Add", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		add.setLayoutData(gd);
		configureMemberAware(add);
		
		removeMifButton = toolkit.createButton(tableCompartment, "Remove", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		removeMifButton.setLayoutData(gd);
		configureMemberAware(removeMifButton);
		
		add.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addNewMif();
				removeMifButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		removeMifButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeCurrentMif();
				updateMifButton();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}

	private void updateMifButton() {
		removeMifButton.setEnabled(mifViewer.getTable().getItemCount()>1);
	}

	private void createMifCompartment(Composite triggerCompartment, FormToolkit toolkit) {
		Composite mifCompartment = toolkit.createComposite(triggerCompartment);
		mifCompartment.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalAlignment = SWT.BEGINNING;
		mifCompartment.setLayoutData(gd);

		createInterfaceCombo(mifCompartment, toolkit);
		createMessageCombo(mifCompartment, toolkit);
		
		Label l = toolkit.createLabel(mifCompartment, "Guard:", SWT.NONE);
		l.setLayoutData(new GridData());

		guardText = toolkit.createText(mifCompartment, "", SWT.BORDER | SWT.MULTI);
		configureMemberAware(guardText, true, true, true);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 50;
		guardText.setLayoutData(gd);
	}

	private void createInterfaceCombo(Composite triggerCompartment,
			FormToolkit toolkit) {
		
		Label l = toolkit.createLabel(triggerCompartment, "Interface Item:", SWT.NONE);
		l.setLayoutData(new GridData());

		interfaceCombo = new Combo(triggerCompartment, SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		interfaceCombo.setLayoutData(gd);
		interfaceCombo.setVisibleItemCount(10);
		toolkit.adapt(interfaceCombo, true, true);
		configureMemberAware(interfaceCombo);
		
		for (InterfaceItem item : interfaceItems) {
			interfaceCombo.add(item.getName());
		}
	}

	private void createMessageCombo(Composite triggerCompartment, FormToolkit toolkit) {
		
		Label l = toolkit.createLabel(triggerCompartment, "Message:", SWT.NONE);
		l.setLayoutData(new GridData());

		messageCombo = new Combo(triggerCompartment, SWT.READ_ONLY);
		messageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		messageCombo.setVisibleItemCount(10);
		toolkit.adapt(messageCombo, true, true);
		configureMemberAware(messageCombo);
	}

	private void addListeners() {
		triggerViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateMifAndGuard();
			}
		});

		mifViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateCombos();
			}
		});
		
		interfaceCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateInterfaceItem();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		messageCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateMessage();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		guardText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				refreshGuard();
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}

	private void updateMessage() {
		String msgName = messageCombo.getItem(messageCombo.getSelectionIndex());
		for (Message message : currentMsgs) {
			if (msgName.equals(message.getName())) {
				MessageFromIf mif = (MessageFromIf) ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
				mif.setMessage(message);
				break;
			}
		}
		
		triggerViewer.refresh();
		mifViewer.refresh();
	}

	private void updateInterfaceItem() {
		String ifName = interfaceCombo.getItem(interfaceCombo.getSelectionIndex());
		for (InterfaceItem item : interfaceItems) {
			if (item.getName().equals(ifName)) {
				MessageFromIf mif = (MessageFromIf) ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
				mif.setFrom(item);
				updateCombos();
				break;
			}
		}
		
		triggerViewer.refresh();
		mifViewer.refresh();
	}

	private void updateCombos() {
		messageCombo.removeAll();
		
		if (mifViewer.getSelection() instanceof IStructuredSelection) {
			Object sel = ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
			if (sel instanceof MessageFromIf) {
				MessageFromIf mif = (MessageFromIf) sel;
				String[] items = interfaceCombo.getItems();
				for (int i = 0; i < items.length; i++) {
					if (items[i].equals(mif.getFrom().getName())) {
						interfaceCombo.select(i);
						currentMsgs = RoomHelpers.getMessageList(mif.getFrom(), false);
						int pos = 0;
						int idx = -1;
						for (Message message : currentMsgs) {
							messageCombo.add(message.getName());
							if (message==mif.getMessage())
								idx = pos;
							++pos;
						}
						if (idx==-1) {
							idx = 0;
							mif.setMessage(currentMsgs.get(idx));
							triggerViewer.refresh();
							mifViewer.refresh();
						}
						messageCombo.select(idx);
						break;
					}
				}
			}
		}
	}

	private void addNewTrigger() {
		Trigger tri = RoomFactory.eINSTANCE.createTrigger();
		EList<Trigger> triggers = ((TriggeredTransition) trans).getTriggers();
		triggers.add(tri);

		if (!interfaceItems.isEmpty()) {
			MessageFromIf mif = createDefaultMif();
			tri.getMsgFromIfPairs().add(mif);
		}

		triggerViewer.refresh();
		triggerViewer.setSelection(new StructuredSelection(triggers.get(triggers.size()-1)), true);
	}

	private MessageFromIf createDefaultMif() {
		MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
		for (InterfaceItem item : interfaceItems) {
			List<Message> msgs = RoomHelpers.getMessageList(item, false);
			if (!msgs.isEmpty()) {
				mif.setFrom(item);
				mif.setMessage(msgs.get(0));
				return mif;
			}
		}
		return null;
	}

	private void removeCurrentTrigger() {
		Object element = ((IStructuredSelection)triggerViewer.getSelection()).getFirstElement();
		((TriggeredTransition) trans).getTriggers().remove(element);
		triggerViewer.refresh();
		triggerViewer.setSelection(new StructuredSelection(((TriggeredTransition) trans).getTriggers().get(0)), true);
	}

	private void addNewMif() {
		Trigger trigger = ((MessageFromInterfaceContentProvider)mifViewer.getContentProvider()).getCurrentTrigger();
		if (trigger!=null) {
			MessageFromIf mif = createDefaultMif();
			trigger.getMsgFromIfPairs().add(mif);
			mifViewer.refresh();
			triggerViewer.refresh();
			mifViewer.setSelection(new StructuredSelection(mif), true);
		}
	}

	private void removeCurrentMif() {
		Object element = ((IStructuredSelection)mifViewer.getSelection()).getFirstElement();
		Trigger trigger = ((MessageFromInterfaceContentProvider)mifViewer.getContentProvider()).getCurrentTrigger();
		if (trigger!=null) {
			trigger.getMsgFromIfPairs().remove(element);
			mifViewer.refresh();
			triggerViewer.refresh();
			mifViewer.setSelection(new StructuredSelection(trigger.getMsgFromIfPairs().get(0)), true);
		}
	}

	private void updateMifAndGuard() {
		Object selected = ((IStructuredSelection) triggerViewer.getSelection()).getFirstElement();
		mifViewer.setInput(selected);
		updateMifButton();
		if (selected instanceof Trigger) {
			mifViewer.setSelection(new StructuredSelection(((Trigger)selected).getMsgFromIfPairs().get(0)), true);
			Guard guard2 = ((Trigger) selected).getGuard();
			String text = null;
			if (guard2!=null)
				text = (String) m2s.convert(guard2.getGuard());
			if (text==null)
				text = "";
			guardText.setText(text);
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		if (inherited || !triggersAvailable())
			getButton(IDialogConstants.OK_ID).setEnabled(false);
	}
	
	private void refreshGuard() {
		Object element = ((IStructuredSelection)triggerViewer.getSelection()).getFirstElement();
		if (element instanceof Trigger) {
			DetailCode dc = (DetailCode) s2m.convert(guardText.getText());
			Guard guard = null;
			if (dc!=null) {
				guard = RoomFactory.eINSTANCE.createGuard();
				guard.setGuard(dc);
			}
			((Trigger) element).setGuard(guard);
		}
	}
}
