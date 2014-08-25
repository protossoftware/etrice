/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ISelectionDialog;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class PortMessageSelectionDialog extends FormDialog implements ISelectionDialog {

	private static class MethodItemPair {
		InterfaceItem item;

		public MethodItemPair(InterfaceItem item) {
			super();
			this.item = item;
		}
	}
	
	private static class MsgItemPair extends MethodItemPair {
		Message msg;
		boolean out;
		
		public MsgItemPair(InterfaceItem item, Message msg, boolean out) {
			super(item);
			this.msg = msg;
			this.out = out;
		}
	}
	
	private static class OperationItemPair extends MethodItemPair {
		PortOperation op;
		
		public OperationItemPair(InterfaceItem item, PortOperation op) {
			super(item);
			this.op = op;
		}
	}
	
	private class PortMessageContentProvider implements ITreeContentProvider {

		private HashMap<InterfaceItem, ArrayList<MethodItemPair>> item2pairs;
		
		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			item2pairs = new HashMap<InterfaceItem, ArrayList<MethodItemPair>>();
			RoomHelpers roomHelpers = SupportUtil.getInstance().getRoomHelpers();
			List<InterfaceItem> items = roomHelpers.getAllInterfaceItems(ac);
			for (InterfaceItem item : items) {
				ArrayList<MethodItemPair> pairs = new ArrayList<MethodItemPair>();
				List<Message> out = roomHelpers.getMessageListDeep(item, true);
				if (!recvOnly) {
					for (Message msg : out) {
						if (!msg.isPriv())
							pairs.add(new MsgItemPair(item, msg, true));
					}
				}
				if (roomHelpers.getProtocol(item).getCommType()==CommunicationType.DATA_DRIVEN) {
					List<Message> in = roomHelpers.getMessageListDeep(item, false);
					for (Message msg : in) {
						if (!msg.isPriv())
							pairs.add(new MsgItemPair(item, msg, false));
					}
				}
				PortClass pcls = roomHelpers.getPortClass(item);
				if (pcls!=null) {
					for (PortOperation op : pcls.getOperations()) {
						if (op.getSendsMsg()!=null)
							pairs.add(new OperationItemPair(item, op));
					}
					for (PortOperation op : pcls.getOperations()) {
						if (op.getSendsMsg()==null)
							pairs.add(new OperationItemPair(item, op));
					}
				}
				item2pairs.put(item, pairs);
			}
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return SupportUtil.getInstance().getRoomHelpers().getAllInterfaceItems(ac).toArray();
		}

		@Override
		public Object[] getChildren(Object element) {
			if (element instanceof InterfaceItem) {
				ArrayList<MethodItemPair> list = item2pairs.get(element);
				return list.toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof MsgItemPair)
				return ((MsgItemPair) element).item;
			
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof InterfaceItem) {
				InterfaceItem item = (InterfaceItem)element;
				if (!SupportUtil.getInstance().getRoomHelpers().getMessageListDeep(item, true).isEmpty())
					return true;
				
				if (SupportUtil.getInstance().getRoomHelpers().getProtocol(item).getCommType()==CommunicationType.DATA_DRIVEN)
					if (!SupportUtil.getInstance().getRoomHelpers().getMessageListDeep(item, false).isEmpty())
						return true;
			}
			
			return false;
		}
		
	}
	
	private class PortMessageLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex==0) {
				if (element instanceof MsgItemPair)
					element = ((MsgItemPair) element).msg;
				else if (element instanceof OperationItemPair) {
					PortOperation op = ((OperationItemPair) element).op;
					element = op;
				}
				return labelProvider.getImage(element);
			}
			
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				if (element instanceof InterfaceItem)
					return ((InterfaceItem) element).getName();
				else if (element instanceof MsgItemPair)
					return ((MsgItemPair) element).msg.getName();
				else if (element instanceof OperationItemPair) {
					PortOperation op = ((OperationItemPair) element).op;
					String add = "";
					if (op.getSendsMsg()!=null)
						add = " sends "+op.getSendsMsg().getName();
					return op.getName()+add;
				}
				break;
			case 1:
				if (element instanceof MsgItemPair)
					return ((MsgItemPair) element).out? "send" : "recv";
				else if (element instanceof OperationItemPair) {
					if (((OperationItemPair) element).op.getSendsMsg()!=null)
						return "send";
					else
						return "n/a";
				}
				break;
			case 2:
				if (element instanceof MsgItemPair) {
					Message msg = ((MsgItemPair) element).msg;
					if (msg.getData()!=null)
						return msg.getData().getName()+" : "+msg.getData().getRefType().getType().getName();
				}
				else if (element instanceof OperationItemPair) {
					String sig = SupportUtil.getInstance().getRoomNameProvider().getTypedArgumentList(((OperationItemPair) element).op);
					return sig.substring(1, sig.length()-1);	// omit round brackets
				}
				break;
			}
			return null;
		}
		
		@Override
		public String getText(Object element) {
			return getColumnText(element, 0);
		}
		
		@Override
		public Image getImage(Object element) {
			return labelProvider.getImage(element);
		}
	}
	
	private ActorClass ac;
	private boolean recvOnly;
	private TreeViewer viewer;
	private String selected = null;

	@Inject
	ILabelProvider labelProvider;

	/**
	 * @param shell
	 */
	public PortMessageSelectionDialog(Shell shell, ActorClass ac, boolean recvOnly) {
		super(shell);
		this.ac = ac;
		this.recvOnly = recvOnly;
		
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}
	
	@Override
	protected void createFormContent(IManagedForm mform) {
		FormToolkit toolkit = mform.getToolkit();

		Form form = mform.getForm().getForm();
		form.setText("Select a port.message Combination");

		form.setImage(Activator.getImage("icons/Behavior.gif"));
		toolkit.decorateFormHeading(form);

		Composite body = form.getBody();
		
		viewer = new TreeViewer(body, SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL);
		
		TreeColumn col0 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col0.setText("interface item/msg or op");
		TreeColumn col1 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col1.setText("direction");
		TreeColumn col2 = new TreeColumn(viewer.getTree(), SWT.NONE);
		col2.setText("data");

		viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.setContentProvider(new PortMessageContentProvider());
		viewer.setLabelProvider(new PortMessageLabelProvider());
		
		viewer.getTree().setHeaderVisible(true);
		viewer.setInput(ac);
		viewer.expandAll();
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Button ok = getButton(OK);
				if (ok!=null) {
					if (event.getSelection() instanceof IStructuredSelection) {
						Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
						ok.setEnabled(element instanceof MethodItemPair);
					}
				}
			}
		});

		// the tree layout is crucial!
		TreeColumnLayout layout = new TreeColumnLayout();
		body.setLayout(layout);

		layout.setColumnData(col0, new ColumnWeightData(40));
		layout.setColumnData(col1, new ColumnWeightData(20));
		layout.setColumnData(col2, new ColumnWeightData(40));
	}
	
	@Override
	protected void okPressed() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof MsgItemPair) {
				MsgItemPair pair = (MsgItemPair) element;
				if (pair.out) {
					String data = pair.msg.getData()!=null? pair.msg.getData().getName() : "";
					String index = "";
					if (pair.item instanceof Port && ((Port)pair.item).getMultiplicity()!=1)
						index = "[idx]";
					selected = pair.item.getName()+index+"."+pair.msg.getName()+"("+data+")";
				}
				else
					selected = pair.item.getName()+"."+pair.msg.getName();
			}
			if (element instanceof OperationItemPair) {
				OperationItemPair pair = (OperationItemPair) element;
				String arglist = SupportUtil.getInstance().getRoomNameProvider().getArguments(pair.op);
				selected = pair.item.getName()+"."+pair.op.getName()+arglist;
			}
		}
		super.okPressed();
	}

	public String getSelected() {
		return selected;
	}
}
