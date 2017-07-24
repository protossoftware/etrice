/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * A model aware configuration for the {@link SourceViewerActionCodeEditor}.
 * Setters within this class could only be invoked before configuring the
 * {@link SourceViewer} with this configuration.
 * 
 * @author jayant
 */
public class ActionCodeEditorConfiguration extends SourceViewerConfiguration {

	/** Color Manager for action code editor */
	private ActionCodeColorManager fColorManager = null;

	private DetailExpressionUIProvider exprProvider;

	public ActionCodeEditorConfiguration(ActionCodeColorManager colorManager, IDetailExpressionProvider exprProvider) {
		fColorManager = colorManager;

		if (exprProvider == null)
			exprProvider = new EmptyDetailExpressionProvider();
		this.exprProvider = new DetailExpressionUIProvider(exprProvider);
		RoomUiModule.getInjector().injectMembers(this.exprProvider);
	}

	/**
	 * Getter for color manager.
	 * 
	 * @return the color manager for action code
	 */
	public ActionCodeColorManager getColorManager() {
		if (fColorManager == null)
			fColorManager = new ActionCodeColorManager();
		return fColorManager;
	}

	/**
	 * Setter for action code Color Manager.
	 * 
	 * @param colorManager
	 *            the color manager to use
	 */
	public void setColorManager(ActionCodeColorManager colorManager) {
		Assert.isNotNull(colorManager);
		fColorManager = colorManager;
	}

	public DetailExpressionUIProvider getDetailExpressionProvider() {
		return exprProvider;
	}

	class EmptyDetailExpressionProvider implements IDetailExpressionProvider {

		final List<ExpressionFeature> EMPTY_LIST = new ArrayList<ExpressionFeature>();

		@Override
		public List<ExpressionFeature> getInitialFeatures() {
			return EMPTY_LIST;
		}

		@Override
		public List<ExpressionFeature> getContextFeatures(ExpressionFeature ctx) {
			return EMPTY_LIST;
		}

	}
}