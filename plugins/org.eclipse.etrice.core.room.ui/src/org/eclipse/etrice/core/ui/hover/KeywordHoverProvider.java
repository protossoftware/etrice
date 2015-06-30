/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		https://borisdevnotes.wordpress.com/2014/02/28/xtext-usability-hovers-on-keywords/
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.doc.ETriceHelp;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class KeywordHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	protected ILabelProvider labelProvider;

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		if (element instanceof Keyword) {
			String html = getHoverInfoAsHtml(element);
			if (html != null) {
				StringBuffer buffer = new StringBuffer(html);
				HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
				HTMLPrinter.addPageEpilog(buffer);
				return new XtextBrowserInformationControlInput(previous, element, buffer.toString(), labelProvider);
			}
		}
		return super.getHoverInfo(element, hoverRegion, previous);
	}
	
	@Override
	protected String getHoverInfoAsHtml(EObject o) {
		if(o instanceof Keyword){
			String help = ETriceHelp.getKeywordHoverContentProvider().getHTMLContent(((Keyword)o).getValue());
			if(help != null)
				return help;
		}
		return super.getHoverInfoAsHtml(o);
	}
}
