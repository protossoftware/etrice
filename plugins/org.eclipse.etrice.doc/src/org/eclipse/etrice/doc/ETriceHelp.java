/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.doc;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class ETriceHelp extends AbstractUIPlugin {

	/**
	 *  "Hot help replace":
	 *   deactivate caching of help contents and styling where possible
	 */
	public static final boolean DEV_MODE = false;
	
	private static ETriceHelp plugin;
	private HtmlHelpProvider keywordHoverProvider;
	//private ContextHelpProvider contextHelp;
	
	public static HtmlHelpProvider getKeywordHoverContentProvider(){
		if(getDefault().keywordHoverProvider == null)
			getDefault().keywordHoverProvider = new HtmlHelpProvider();
		
		return getDefault().keywordHoverProvider;
	}
	
//	public static ContextHelpProvider getContextHelpProvider(){
//		if(getDefault().contextHelp == null)
//			getDefault().contextHelp = new ContextHelpProvider();
//		
//		return getDefault().contextHelp;
//	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		
		super.stop(context);
	}
	
	public static ETriceHelp getDefault() {
		return plugin;
	}
	

}
