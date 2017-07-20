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

package org.eclipse.etrice.core.common.ui.hover;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.ETriceCoreCommonActivator;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.util.Files;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@SuppressWarnings("restriction")
public class KeywordHoverProvider extends DefaultEObjectHoverProvider {
	
	public final static String STYLE_SHEET_KEY = "keywordHoverStyleSheetFileName";

	@Inject(optional=true) @Named(STYLE_SHEET_KEY)
	private String styleSheetFileName;

	@Inject
	protected AbstractUIPlugin plugin;
	
	@Inject
	protected ILabelProvider labelProvider;
	
	@Inject
	protected IKeywordHoverContentProvider contentProvider;

	private String styleSheet = null;

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		if (element instanceof Keyword) {
			Keyword keyword = (Keyword) element;
			String html = contentProvider.getHTMLContent(keyword.getValue());
			if (html != null) {
				StringBuffer buffer = new StringBuffer(html);
				HTMLPrinter.insertPageProlog(buffer, 0, getKeywordStyleSheet());
				HTMLPrinter.addPageEpilog(buffer);
				return new XtextBrowserInformationControlInput(previous, element, buffer.toString(), labelProvider);
			}
		}
		return super.getHoverInfo(element, hoverRegion, previous);
	}

	protected String getKeywordStyleSheet() {
		String superStyle = super.getStyleSheet();
		if (styleSheet == null) {
			styleSheet = "";
			try {
				URL url = null;
				if(plugin != null && styleSheetFileName != null) {
					url = plugin.getBundle().getEntry(styleSheetFileName);
				}
				else {
					url = ETriceCoreCommonActivator.getInstance().getBundle().getEntry("/eTriceKeywordHoverStyle.css");
				}
				styleSheet = Files.readStreamIntoString(url.openStream());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		return superStyle + styleSheet;
	}
}
