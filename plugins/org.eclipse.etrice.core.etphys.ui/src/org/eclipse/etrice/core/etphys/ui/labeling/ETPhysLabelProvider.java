/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.ui.labeling.BaseLabelProvider;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.jface.viewers.StyledString;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ETPhysLabelProvider extends BaseLabelProvider {

	@Inject
	public ETPhysLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String image(PhysicalModel mdl) {
		return "etphys_PhysicalModel.png";
	}

	@Override
	public String image(Import mdl) {
		return "etphys_Import.png";
	}

	String image(NodeClass mdl) {
		return "etphys_NodeClass.png";
	}

	String image(NodeRef mdl) {
		return "etphys_NodeRef.png";
	}

	String image(PhysicalSystem mdl) {
		return "etphys_PhysicalSystem.png";
	}

	String image(PhysicalThread mdl) {
		return "etphys_PhysicalThread.png";
	}

	String image(RuntimeClass mdl) {
		return "etphys_RuntimeClass.png";
	}

	String text(PhysicalModel mdl) {
		return "PhysicalModel "+mdl.getName();
	}

	String text(NodeClass mdl) {
		return "NodeClass "+mdl.getName();
	}

	String text(PhysicalSystem mdl) {
		return "PhysicalSystem "+mdl.getName();
	}

	String text(PhysicalThread mdl) {
		return "PhysicalThread "+mdl.getName();
	}
	
	String text(RuntimeClass rc) {
		return rc.getName()+"("+rc.getThreadModel().getLiteral()+")";
	}
	
	StyledString text(NodeRef ref) {
		String cls = ref.getType()!=null? (" : "+ref.getType().getName()):"";
		StyledString txt = new StyledString("NodeRef "+ref.getName()+cls);
		if (!cls.isEmpty())
			txt.setStyle(txt.length()-cls.length()+2, cls.length()-2, getTypeStyler());
		return txt;
	}
	
}
