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
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.ui.common.dialogs.AbstractPropertyDialog;
import org.eclipse.etrice.ui.common.dialogs.MultiValidator2;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.etrice.ui.structure.dialogs.PortPropertyDialog.Multiplicity2StringConverter;
import org.eclipse.etrice.ui.structure.dialogs.PortPropertyDialog.String2MultiplicityConverter;
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

public class ActorContainerRefPropertyDialog extends AbstractPropertyDialog {
	
	class NameValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value instanceof String) {
				String name = (String) value;
				
				if (name.isEmpty())
					return ValidationStatus.error("name must not be empty");
				
				// TODOHRR: check valid identifier
				// TODOHRR: use ValidationUtil
				
				if (sc instanceof ActorClass) {
					if (nameExists((ActorClass) sc, name))
						return ValidationStatus.error("name already exists");
				}
				else if (sc instanceof SubSystemClass) {
					SubSystemClass ssc = (SubSystemClass) sc;
					for (ActorRef ar : ssc.getActorRefs()) {
						if (ar!=ref && ar.getName().equals(name))
							return ValidationStatus.error("name already exists");
					}
				}
				else if (sc instanceof LogicalSystem) {
					LogicalSystem ssc = (LogicalSystem) sc;
					for (SubSystemRef ssr : ssc.getSubSystems()) {
						if (ssr!=ref && ssr.getName().equals(name))
							return ValidationStatus.error("name already exists");
					}
				}
				else {
					assert(false): "unexpected type";
				}
				return Status.OK_STATUS;
			}
			return Status.OK_STATUS;
		}

		private boolean nameExists(ActorClass ac, String name) {
			for (ActorRef ar : ac.getActorRefs()) {
				if (ar!=ref && ar.getName().equals(name))
					return true;
			}
			if (ac.getActorBase()!=null)
				return nameExists(ac.getActorBase(), name);
			
			return false;
		}
	}
	
	class ProtocolValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if (value==null)
				return ValidationStatus.error("select a class");
			
			return Status.OK_STATUS;
		}
	}
	
	class SizeAndRefTypeValidator extends MultiValidator2{

		public SizeAndRefTypeValidator(DataBindingContext bindingContext) {
			super(bindingContext, 2);
		}

		@Override
		public IStatus validate(List<Object> values) {
			int m = (Integer) values.get(0);
			ReferenceType rt = (ReferenceType) values.get(1);
			if (m==0)
				return ValidationStatus.error("multiplicity must not be 0");
			if (m<-1)
				return ValidationStatus.error("multiplicity must be -1 or positive");
			if (rt==ReferenceType.OPTIONAL) {
				if (m>1)
					return ValidationStatus.error("multiplicity >1 not allowed (only fixed actors)");
			}
			else {
				if (m==-1)
					return ValidationStatus.error("multiplicity * not allowed (only optional actors)");
			}
			
			return ValidationStatus.ok();
		}
		
	}
	
	class SizeValidator implements IValidator {

		@Override
		public IStatus validate(Object value) {
			if(value instanceof Integer){
				int m = (Integer) value;
				if (m==0)
					return ValidationStatus.error("multiplicity must not be 0");
				if (m<-1)
					return ValidationStatus.error("multiplicity must be -1 or positive");
			}
			
			return ValidationStatus.ok();
		}
	}

	private ActorContainerRef ref;
	private IScope scope;
	private StructureClass sc;
	private boolean newRef;

	public ActorContainerRefPropertyDialog(Shell shell, ActorContainerRef ref, IScope scope, StructureClass sc, boolean newRef) {
		super(shell, "Edit Reference");
		this.ref = ref;
		this.scope = scope;
		this.sc = sc;
		this.newRef = newRef;
	}

	@Override
	protected void initializeBounds() {
		super.initializeBounds();
		Point size = getShell().getSize();
		getShell().setSize((int)(size.x*1.2), size.y);
	}

	@Override
	protected void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext) {

		NameValidator nv = new NameValidator();
		ProtocolValidator pv = new ProtocolValidator();

		boolean refIsActor = sc instanceof ActorContainerClass;
		boolean containerIsActor = sc instanceof ActorClass;

		ArrayList<IEObjectDescription> actors = new ArrayList<IEObjectDescription>();
        Iterator<IEObjectDescription> it = scope.getAllElements().iterator();
        while (it.hasNext()) {
        	IEObjectDescription desc = it.next();
        	EObject obj = desc.getEObjectOrProxy();
        	if (refIsActor && obj instanceof ActorClass) {
        		if (containerIsActor) {
        			if (!SupportUtil.getInstance().getRoomHelpers().isReferencing((ActorClass)obj, (ActorClass)sc))
        				actors.add(desc);
        		}
        		else
        			actors.add(desc);
        	}
        	else if (!refIsActor && obj instanceof SubSystemClass) {
        		if (obj!=sc)
        			actors.add(desc);
        	}
		}
		
		Text name = createText(body, "&Name:", ref, RoomPackage.eINSTANCE.getActorContainerRef_Name(), nv);
		Combo refClass = refIsActor?
				createComboUsingDesc(body, "Actor &Class:", ref, ActorClass.class, RoomPackage.eINSTANCE.getActorRef_Type(), actors, RoomPackage.eINSTANCE.getRoomClass_Name(), pv)
			:	createComboUsingDesc(body, "SubSystem &Class:", ref, SubSystemClass.class, RoomPackage.eINSTANCE.getSubSystemRef_Type(), actors, RoomPackage.eINSTANCE.getRoomClass_Name(), pv);

		createDecorator(name, "invalid name");
		createDecorator(refClass, "no class selected");

		if (!newRef) {
			refClass.setEnabled(false);
			createInfoDecorator(refClass, "class fixed for exisiting ref");
		}

		if (ref instanceof ActorRef) {
			Multiplicity2StringConverter m2s = new Multiplicity2StringConverter();
			String2MultiplicityConverter s2m = new String2MultiplicityConverter();
			MultiValidator2 multiValidator = new SizeAndRefTypeValidator(bindingContext);
			
			IValidator sizeValidator = new SizeValidator();
			Text size = createText(body, "&Multiplicity", ref, RoomPackage.eINSTANCE.getActorRef_Multiplicity(), sizeValidator, multiValidator, s2m, m2s, false);
			if (hasInterfacePortWithMultiplicityAny(((ActorRef) ref).getType())) {
				size.setEnabled(false);
				createInfoDecorator(size, "size fixed since actor has interface ports with multiplicity *");
			}
			else {
				createDecorator(size, "multiplicity");
			}
			
			Combo refType = createCombo(body, "Reference &Type:", ref, ReferenceType.class, RoomPackage.eINSTANCE.getActorRef_RefType(), ReferenceType.VALUES, null, multiValidator);
			createDecorator(refType, "invalid ref type");
		}
		
		name.selectAll();
		name.setFocus();
	}

	/**
	 * @param ac
	 * @return
	 */
	private boolean hasInterfacePortWithMultiplicityAny(ActorClass ac) {
		if (ac==null)
			return false;
		
		for (Port p : ac.getInterfacePorts()) {
			if (p.getMultiplicity()<0)
				return true;
		}
		return false;
	}

	@Override
	protected Image getImage() {
		return Activator.getImage("icons/Structure.gif");
	}

}
