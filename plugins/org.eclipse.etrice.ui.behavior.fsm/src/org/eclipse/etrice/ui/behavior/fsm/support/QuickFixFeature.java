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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.QuickFixDialog;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMEditor;
import org.eclipse.etrice.ui.behavior.fsm.provider.IInjectorProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.ImageProvider;
import org.eclipse.etrice.ui.common.base.quickfix.IssueResolution;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCustomFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

import com.google.inject.Injector;

public class QuickFixFeature extends ChangeAwareCustomFeature {
	
	private HashMap<FeatureBasedDiagnostic, List<IssueResolution>> issueResolutionsMap;

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
		Object bo = getBusinessObject(context);

		computeResolutions(bo);
		
		return !issueResolutionsMap.isEmpty();
	}
		
	@Override
	public boolean doExecute(ICustomContext context) {

		// Get the issue Resolutions Map
		Object bo = getBusinessObject(context);
		computeResolutions(bo);
		
		// Create & Open the Quick Fix Dialog
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		QuickFixDialog dlg = new QuickFixDialog(shell, issueResolutionsMap);

		if (dlg.open() == Window.OK) {
			Object[] result = dlg.getResult();
			if (result != null)
				return ((IssueResolution) result[0]).apply(getDiagram(),
						getFeatureProvider());
		}

		return false;
	}

	private Object getBusinessObject(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			PictogramElement pe = pes[0];
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe.eContainer();
			
			return getBusinessObjectForPictogramElement(pe);
		}
		return null;
	}
	
	private void computeResolutions(Object bo) {
		if (issueResolutionsMap==null) {
			ArrayList<Diagnostic> issues = ((AbstractFSMEditor) getDiagramBehavior()
					.getDiagramContainer()).getDiagnosingModelObserver()
					.getElementDiagonsticMap().get(bo);
			
			issueResolutionsMap = new HashMap<FeatureBasedDiagnostic, List<IssueResolution>>();
        	Injector injector = ((IInjectorProvider) getFeatureProvider()).getInjector();
			IBehaviorQuickfixProvider behaviorQuickfixProvider = injector.getInstance(IBehaviorQuickfixProvider.class);
			for (Diagnostic issue : issues) {
				if (((FeatureBasedDiagnostic) issue).getIssueCode()!=null) {
					issueResolutionsMap.put((FeatureBasedDiagnostic) issue,
							behaviorQuickfixProvider
							.getResolutions((FeatureBasedDiagnostic) issue));
				}
			}
		}
	}
}