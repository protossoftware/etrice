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

package org.eclipse.etrice.core.etmap.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.etmap.eTMap.Import;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider; 
import org.eclipse.xtext.ui.label.StylerFactory;
 
import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ETMapLabelProvider extends DefaultEObjectLabelProvider {

	private static final String KEYWORD_COLOR = "KEYWORD_COLOR";

	@Inject
	private StylerFactory stylerFactory;
	private Styler keywordStyler = null;

	@Inject
	public ETMapLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
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
	
	StyledString text(Import im) {
		if (im.getImportedNamespace()==null) {
			StyledString txt = new StyledString("import model "+im.getImportURI());
			txt.setStyle(0, 12, getKeywordStyler());
			return txt;
		}
		else {
			StyledString txt = new StyledString("import ns "+im.getImportedNamespace());
			txt.setStyle(0, 9, getKeywordStyler());
			return txt;
		}
	}
	
	private Styler getKeywordStyler() {
		if (keywordStyler==null) {
			FontDescriptor font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT);
			FontDescriptor boldFont = font.setStyle(SWT.BOLD);
			keywordStyler = stylerFactory.createStyler(boldFont, KEYWORD_COLOR, null);
		}
		return keywordStyler;
	}
}
