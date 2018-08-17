/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.ui.labeling.BaseLabelProvider;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ETMapLabelProvider extends BaseLabelProvider {

	@Inject
	public ETMapLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String image(MappingModel mdl) {
		return "etmap_MappingModel.png";
	}

	@Override
	public String image(Import mdl) {
		return "etmap_Import.png";
	}

	String image(SubSystemMapping mdl) {
		return "etmap_SubSystemMapping.png";
	}

	String image(Mapping mdl) {
		return "etmap_Mapping.png";
	}

	String image(ThreadMapping mdl) {
		return "etmap_ThreadMapping.png";
	}
	
	String text(Mapping m) {
		return "Mapping "+m.getLogicalSys().getName()+" -> "+m.getPhysicalSys().getName();
	}
	
	String text(SubSystemMapping ssm) {
		return "SubSystemMapping "+ssm.getLogicalSubSys().getName()+" -> Node "+ssm.getNode().getName();
	}
	
	String text(ThreadMapping tm) {
		return "ThreadMapping "+tm.getLogicalThread().getName()+" -> "+tm.getPhysicalThread().getName();
	}
}
