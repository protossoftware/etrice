/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.dialogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.ui.common.base.dialogs.AbstractPropertyDialog;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.etrice.ui.structure.support.SupportUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class SPPPropertyDialog extends AbstractPropertyDialog {

	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				Result result = SupportUtil.getInstance().getValidationUtil().isUniqueName(spp, name);
				if (!result.isOk())
					return ValidationStatus.error(result.getMsg());

				return Status.OK_STATUS;
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
	
	private SPP spp;
	private IScope scope;
	private boolean newSPP;
	private boolean refitem;

	public SPPPropertyDialog(Shell shell, SPP spp, IScope scope, boolean newSPP, boolean refitem) {
		super(shell, "Edit SPP");
		this.spp = spp;
		this.scope = scope;
		this.newSPP = newSPP;
		this.refitem = refitem;
	}

	@Override
	protected void initializeBounds() {
		super.initializeBounds();
		Point size = getShell().getSize();
		getShell().setSize((int)(size.x*1.2), size.y);
	}
	
	@Override
	protected void createContent(IManagedForm mform, Composite body, DataBindingContext bindingContext) {
		boolean connected = SupportUtil.getInstance().getValidationUtil().isReferencedInModel(spp);
		NameValidator nv = new NameValidator();
		ProtocolValidator pv = new ProtocolValidator();

		ArrayList<IEObjectDescription> protocols = new ArrayList<IEObjectDescription>();
        Iterator<IEObjectDescription> it = scope.getAllElements().iterator();
        while (it.hasNext()) {
        	IEObjectDescription desc = it.next();
        	EObject obj = desc.getEObjectOrProxy();
        	if (obj instanceof ProtocolClass)
        		protocols.add(desc);
		}
		
		Text name = createText(body, "Name:", spp, FSMPackage.eINSTANCE.getAbstractInterfaceItem_Name(), nv);
		Combo protocol = createComboUsingDesc(body, "Protocol:", spp, ProtocolClass.class, RoomPackage.eINSTANCE.getSPP_Protocol(), protocols, RoomPackage.eINSTANCE.getRoomClass_Name(), pv);
		
		if (!newSPP) {
			// TODOHRR: check whether spp is used externally?
			if (connected) {
				protocol.setEnabled(false);
			}
			if (refitem) {
				name.setEnabled(false);
				protocol.setEnabled(false);
			}
		}
		
		createDecorator(name, "invalid name");
		createDecorator(protocol, "no protocol selected");
		
		name.selectAll();
		name.setFocus();
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Structure.gif");
	}

	@Override
	protected String getFeatureContextHelpId() {
		return "SPPPropertyDialog";
	}
}
