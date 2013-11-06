/*******************************************************************************
 * Copyright (c) 2013 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 *		Jayant Gupta (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.etrice.ui.behavior.ImageProvider;
import org.eclipse.etrice.ui.behavior.dialogs.QuickFixDialog;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.etrice.ui.behavior.quickfix.BehaviorQuickfixProvider;
import org.eclipse.etrice.ui.common.quickfix.IssueResolution;
import org.eclipse.etrice.ui.common.support.ChangeAwareCustomFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

public class QuickFixFeature extends ChangeAwareCustomFeature {
	
	public QuickFixFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Quick Fix";
	}

	@Override
	public String getDescription() {
		return "Apply Quick fixes";
	}

	@Override
	public String getImageId() {
		return ImageProvider.IMG_QUICKFIX;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public boolean doExecute(ICustomContext context) {

		// Get the issue Resolutions Map
		Object bo = getBusinessObjectForPictogramElement(context
				.getPictogramElements()[0]);
		ArrayList<Diagnostic> issues = ((BehaviorEditor) getDiagramBehavior()
				.getDiagramContainer()).getDiagnosingModelObserver()
				.getElementDiagonsticMap().get(bo);

		HashMap<FeatureBasedDiagnostic, List<IssueResolution>> issueResolutionsMap = new HashMap<FeatureBasedDiagnostic, List<IssueResolution>>();
		BehaviorQuickfixProvider behaviorQuickfixProvider = new BehaviorQuickfixProvider();
		for (Diagnostic issue : issues) {
			issueResolutionsMap.put((FeatureBasedDiagnostic) issue,
					behaviorQuickfixProvider
							.getResolutions((FeatureBasedDiagnostic) issue));
		}

		// Create & Open the Quick Fix Dialog
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		QuickFixDialog dlg = new QuickFixDialog(shell, issueResolutionsMap);

		if (dlg.open() == Window.OK) {
			Object[] result = dlg.getResult();
			if (result != null)
				return ((IssueResolution) result[0]).apply(getDiagram(),
						getFeatureProvider());
		}

		return false;
	}
}