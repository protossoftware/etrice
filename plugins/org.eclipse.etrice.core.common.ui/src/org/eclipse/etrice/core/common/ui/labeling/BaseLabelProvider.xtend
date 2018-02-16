/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.ui.labeling

import com.google.inject.Inject
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.etrice.core.common.base.Import
import org.eclipse.xtext.ui.label.StylerFactory
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class BaseLabelProvider extends org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider {

	protected static final String KEYWORD_COLOR = "KEYWORD_COLOR";

	@Inject
	protected StylerFactory stylerFactory;
	
	protected Styler keywordStyler = null;
	protected Styler typeStyler = null;
	
	@Inject
	new(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
		
		JFaceResources.getColorRegistry().put(KEYWORD_COLOR, new RGB(50, 50, 50));
	}

	def String image(Import mdl) {
		return null;
	}
	
	def StyledString text(Import im) {
		if (im.getImportedNamespace() === null) {
			var txt = new StyledString("import model " + im.getImportURI())
			txt.setStyle(0, 12, getKeywordStyler())
			return txt
		} else {
			var txt = new StyledString("import ns " + im.getImportedNamespace())
			txt.setStyle(0, 9, getKeywordStyler())
			return txt
		}
	}
	
	def protected Styler getKeywordStyler() {
		if (keywordStyler===null) {
			var font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT)
			var boldFont = font.setStyle(SWT.BOLD)
			keywordStyler = stylerFactory.createStyler(boldFont, KEYWORD_COLOR, null)
		}
		return keywordStyler
	}

	def protected Styler getTypeStyler() {
		if (typeStyler===null) {
			var font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT)
			var italicFont = font.setStyle(SWT.ITALIC)
			typeStyler = stylerFactory.createStyler(italicFont, null, null)
		}
		return typeStyler
	}
}
