/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.ui.common.base.dialogs.AbstractPropertyDialog;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.etrice.ui.structure.support.SupportUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class PortPropertyDialog extends AbstractPropertyDialog {

	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = SupportUtil.getInstance().getValidationUtil().isUniqueName(port, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());
			}
			return Status.OK_STATUS;
		}
	}
	
	class ProtocolValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value==null)
				return ValidationStatus.error("select a protocol");
			
			return Status.OK_STATUS;
		}
	}
	
	class MultiplicityValidator implements IValidator {

		private boolean mayChange;
		private int old;
		private boolean multAnyAllowed;

		public MultiplicityValidator(boolean mayChange, int old, boolean multAnyAllowed) {
			this.mayChange = mayChange;
			this.old = old;
			this.multAnyAllowed = multAnyAllowed;
		}

		@Override
		public IStatus validate(Object value) {
			if (value instanceof Integer) {
				int m = (Integer) value;
				if (m==0)
					return ValidationStatus.error("multiplicity must not be 0");
				if (m<-1)
					return ValidationStatus.error("multiplicity must be -1 or positive");
				if (!mayChange) {
					if (old==1 && (m>1 || m==-1))
						return ValidationStatus.error("cannot change connected port to replicated");
					if ((old>1 || old==-1) && m==1)
						return ValidationStatus.error("cannot change connected port to not replicated");
				}
				if (m==-1 && !multAnyAllowed)
					return ValidationStatus.error("multiplicity * not allowed (actor used replicated)");
				
				if (port.getProtocol()!=null)
					if (port.getProtocol() instanceof ProtocolClass && ((ProtocolClass)port.getProtocol()).getCommType()==CommunicationType.DATA_DRIVEN) {
					if (m!=1)
						return ValidationStatus.error("data driven ports can not be replicated");
				}
			}
			else if (value instanceof String) {
				if (!value.equals("*")) {
					try {
						Integer.parseInt((String) value);
					}
					catch (NumberFormatException e) {
						return ValidationStatus.error("Multiplicity must be * or integer > 0");
					}
				}
			}
			else {
				return ValidationStatus.error("Multiplicity must be * or integer > 0");
			}
			return Status.OK_STATUS;
		}
	}
	
	static class Multiplicity2StringConverter extends Converter {
		
		public Multiplicity2StringConverter() {
			super(Integer.class, String.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject instanceof Integer) {
				int val = (Integer) fromObject;
				if (val==-1)
					return "*";
				else
					return fromObject.toString();
			}
			return fromObject;
		}
		
	}
	
	static class String2MultiplicityConverter extends Converter {
		String2MultiplicityConverter() {
			super(String.class, Integer.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject.equals("*"))
				return -1;
			else {
				try {
					return Integer.parseInt((String) fromObject);
				}
				catch (NumberFormatException e) {
					return "";
				}
			}
		}
	}
	
	private Port port;
	private IScope scope;
	private ActorContainerClass acc;
	private boolean newPort;
	private boolean refitem;
	private boolean internal;
	private boolean relay;
	private boolean oldRelay;

	public PortPropertyDialog(Shell shell, Port port, IScope scope, ActorContainerClass acc, boolean newPort, boolean refitem, boolean internal) {
		super(shell, "Edit Port");
		this.port = port;
		this.scope = scope;
		this.acc = acc;
		this.newPort = newPort;
		this.refitem = refitem;
		this.internal = internal;
		
		relay = isPortRelay();
		oldRelay = relay;
	}

	private boolean isPortRelay() {
		if (internal)
			return false;
		
		if (acc instanceof SubSystemClass)
			return true;
		else if (acc instanceof ActorClass) {
			for (ExternalPort xp : ((ActorClass) acc).getExternalPorts()) {
				if (xp.getInterfacePort()==port)
					return false;
			}
			return true;
		}
		
		return false;
	}

	@Override
	protected void initializeBounds() {
		super.initializeBounds();
		Point size = getShell().getSize();
		getShell().setSize((int)(size.x*1.2), size.y);
	}
	
	@Override
	protected void createContent(IManagedForm mform, Composite body, DataBindingContext bindingContext) {
		Result notReferenced = SupportUtil.getInstance().getValidationUtil().isFreeOfReferences(port);
		boolean multiplicityAnyAllowed = true;
		ActorContainerClass parent = (ActorContainerClass) port.eContainer();
		if (parent instanceof ActorClass) {
			 if (SupportUtil.getInstance().getValidationUtil().isReferencedAsReplicatedInModel((ActorClass) parent))
				 multiplicityAnyAllowed = false;
		}
		NameValidator nv = new NameValidator();
		ProtocolValidator pv = new ProtocolValidator();
		MultiplicityValidator mv = new MultiplicityValidator(newPort || notReferenced.isOk(), port.getMultiplicity(), multiplicityAnyAllowed);

		ArrayList<IEObjectDescription> protocols = new ArrayList<IEObjectDescription>();
        Iterator<IEObjectDescription> it = scope.getAllElements().iterator();
        while (it.hasNext()) {
        	IEObjectDescription desc = it.next();
        	EObject obj = desc.getEObjectOrProxy();
        	if (obj instanceof ProtocolClass)
        		protocols.add(desc);
		}
		
		Text name = createText(body, "&Name:", port, FSMPackage.eINSTANCE.getAbstractInterfaceItem_Name(), nv);
		Combo protocol = createComboUsingDesc(body, "&Protocol:", port, ProtocolClass.class, RoomPackage.eINSTANCE.getInterfaceItem_Protocol(), protocols, pv);
		Button conj = createCheck(body, "&Conjugated:", port, RoomPackage.eINSTANCE.getPort_Conjugated());
		
		Multiplicity2StringConverter m2s = new Multiplicity2StringConverter();
		String2MultiplicityConverter s2m = new String2MultiplicityConverter();
		Text multi = createText(body, "&Multiplicity:", port, RoomPackage.eINSTANCE.getPort_Multiplicity(), mv, s2m, m2s, false);
		
		if (!newPort) {
			if (!notReferenced.isOk()) {
				protocol.setEnabled(false);
				createInfoDecorator(protocol, notReferenced.getMsg());
				conj.setEnabled(false);
				createInfoDecorator(conj, notReferenced.getMsg());
				if (port.getMultiplicity()==1) {
					multi.setEnabled(false);
					createInfoDecorator(multi, notReferenced.getMsg());
				}
			}
			
			if (refitem) {
				name.setEnabled(false);
				createInfoDecorator(name, "inherited");
				protocol.setEnabled(false);
				createInfoDecorator(protocol, "inherited");
				conj.setEnabled(false);
				createInfoDecorator(conj, "inherited");
				multi.setEnabled(false);
				createInfoDecorator(multi, "inherited");
			}
		}
		
		createDecorator(name, "invalid name");
		createDecorator(protocol, "no protocol selected");
		createDecorator(multi, "multiplicity must be greater 1");
		
		name.selectAll();
		name.setFocus();
	}

	@Override
	protected void okPressed() {
		if (relay!=oldRelay) {
			// we know it's an ActorClass (else the flag couldn't have changed)
			ActorClass ac = (ActorClass) acc;
			
			if (relay) {
				for (ExternalPort xp : ac.getExternalPorts()) {
					if (xp.getInterfacePort()==port) {
						ac.getExternalPorts().remove(xp);
						break;
					}
				}
			}
			else {
				ExternalPort xp = RoomFactory.eINSTANCE.createExternalPort();
				xp.setInterfacePort(port);
				ac.getExternalPorts().add(xp);
			}
		}
		
		super.okPressed();
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Structure.gif");
	}

	public boolean isRelay() {
		return relay;
	}

	public void setRelay(boolean relay) {
		this.relay = relay;
	}

	@Override
	protected String getFeatureContextHelpId() {
		return "PortPropertyDialog";
	}
}
