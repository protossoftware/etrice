/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		jci (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.dialogs.AbstractPropertyDialog;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author jci
 *
 */
public class TransitionTriggerCompartment {
	
	protected static class TriggerContentProvider implements IStructuredContentProvider {
		
		private Transition trans;
		
		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Transition) {
				trans = (Transition) newInput;
			}
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (trans instanceof TriggeredTransition) {
				return ((TriggeredTransition) trans).getTriggers().toArray();
			}
			return new Object[] {};
		}

	}

	protected static class TriggerLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof Trigger) {
				Trigger trig = (Trigger) element;
				return FSMSupportUtil.getInstance().getFSMNameProvider().getTriggerLabel(trig);
			}
			return super.getText(element);
		}
	}

	protected static class MessageFromInterfaceContentProvider implements IStructuredContentProvider {
		private Trigger currentTrigger = null;

		@Override
		public void dispose() {}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Trigger)
				currentTrigger = (Trigger) newInput;
			else
				currentTrigger = null;
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

	protected static class MessageFromInterfaceLabelProvider extends LabelProvider implements
			IBaseLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof MessageFromIf) {
				MessageFromIf mif = (MessageFromIf) element;
				return FSMSupportUtil.getInstance().getFSMNameProvider().getMsgFromIfLabel(mif);
			}
			return super.getText(element);
		}
	}
	
	private AbstractPropertyDialog parent;
	private Transition trans;
	private List<AbstractInterfaceItem> interfaceItems;
	private boolean inherited;
	
	private TableViewer triggerViewer;
	private TableViewer mifViewer;
	private Combo messageCombo;
	private Combo interfaceCombo;
	private Button removeMifButton;
	private List<EObject> currentMsgs;
	private Text guardText;
	private DetailCodeToString m2s;
	private StringToDetailCode s2m;
	private IMemberAwareConfiguration memberAwareConfiguration;
	private FSMNameProvider nameProvider = new FSMNameProvider();
	
	public TransitionTriggerCompartment(AbstractPropertyDialog parent, Transition trans, List<AbstractInterfaceItem> interfaceItems, boolean inherited, IMemberAwareConfiguration memberAwareConfiguration) {
		this.parent = parent;
		this.trans = trans;
		this.interfaceItems = interfaceItems;
		this.inherited = inherited;
		this.memberAwareConfiguration = memberAwareConfiguration;
		
		m2s = new DetailCodeToString();
		s2m = new StringToDetailCode();
	}

	public boolean triggersAvailable() {
		if (interfaceItems.isEmpty())
			return false;
		
		for (AbstractInterfaceItem item : interfaceItems) {
			if (!item.getAllIncomingAbstractMessages().isEmpty())
				return true;
		}
		return false;
	}
	
	public void createTriggerCompartment(Composite body, FormToolkit toolkit) {
		Label l = toolkit.createLabel(body, "Triggers:", SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		l.setLayoutData(gd);

		if (triggersAvailable()) {
			createTriggerCompartmentInternal(body, toolkit);
		}
		else {
			Label error = toolkit.createLabel(body, "No triggers available (no incoming messages).", SWT.NONE);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			error.setLayoutData(gd);
		}
	}
	
	private void createTriggerCompartmentInternal(Composite body, FormToolkit toolkit) {
		Composite triggerCompartment = toolkit.createComposite(body);
		triggerCompartment.setLayout(new GridLayout(3, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		triggerCompartment.setLayoutData(gd);
		
		createTriggerTable(triggerCompartment, toolkit);
		createMifTable(triggerCompartment, toolkit);
		
		createMifCompartment(triggerCompartment, toolkit);
		
		if (inherited)
			disableAll(triggerCompartment);
		
		addListeners();
		triggerViewer.setSelection(new StructuredSelection(((TriggeredTransition) trans).getTriggers().get(0)), true);
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
		memberAwareConfiguration.configureMemberAwareness(triggerTable);
		
		if (((TriggeredTransition) trans).getTriggers().isEmpty())
			addNewTrigger();
		
		Button add = toolkit.createButton(tableCompartment, "Add", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		add.setLayoutData(gd);
		memberAwareConfiguration.configureMemberAwareness(add);
		
		final Button remove = toolkit.createButton(tableCompartment, "Remove", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		remove.setLayoutData(gd);
		if (((TriggeredTransition) trans).getTriggers().size()==1)
			remove.setEnabled(false);
		memberAwareConfiguration.configureMemberAwareness(remove);
		
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
		memberAwareConfiguration.configureMemberAwareness(mifTable);
		
		Button add = toolkit.createButton(tableCompartment, "Add", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		add.setLayoutData(gd);
		memberAwareConfiguration.configureMemberAwareness(add);
		
		removeMifButton = toolkit.createButton(tableCompartment, "Remove", SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		removeMifButton.setLayoutData(gd);
		memberAwareConfiguration.configureMemberAwareness(removeMifButton);
		
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
		memberAwareConfiguration.configureMemberAwareness(guardText, true, true, true);
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
		memberAwareConfiguration.configureMemberAwareness(interfaceCombo);
		
		for (AbstractInterfaceItem item : interfaceItems) {
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
		memberAwareConfiguration.configureMemberAwareness(messageCombo);
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
		
		guardText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				refreshGuard();
			}
		});
	}

	private void updateMessage() {
		String msgName = messageCombo.getItem(messageCombo.getSelectionIndex());
		for (EObject message : currentMsgs) {
			if (msgName.equals(nameProvider.getMessageName(message))) {
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
		for (AbstractInterfaceItem item : interfaceItems) {
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
						currentMsgs = mif.getFrom().getAllIncomingAbstractMessages();
						int pos = 0;
						int idx = -1;
						for (EObject message : currentMsgs) {
							messageCombo.add(nameProvider.getMessageName(message));
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
		Trigger tri = FSMFactory.eINSTANCE.createTrigger();
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
		MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
		for (AbstractInterfaceItem item : interfaceItems) {
			List<EObject> msgs = item.getAllIncomingAbstractMessages();
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

	private void disableAll(Composite parent) {
		for (Control child : parent.getChildren()) {
			child.setEnabled(false);
			if (child instanceof Composite)
				disableAll((Composite) child);
		}
	}
	
	private void refreshGuard() {
		Object element = ((IStructuredSelection)triggerViewer.getSelection()).getFirstElement();
		if (element instanceof Trigger) {
			DetailCode dc = (DetailCode) s2m.convert(guardText.getText());
			Guard guard = null;
			if (dc!=null) {
				guard = FSMFactory.eINSTANCE.createGuard();
				guard.setGuard(dc);
			}
			((Trigger) element).setGuard(guard);
			
			parent.checkValidation();
		}
	}

}
