/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.fsm.editor;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtil;
import org.eclipse.etrice.ui.behavior.fsm.support.ContextSwitcher;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Function;

/**
 * Plugins that extend and use this class should also extend and use 
 * {@link AbstractFSMDiagramTypeProvider}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractFSMEditor extends DiagramEditorBase {

	protected DiagnosingModelObserver diagnosingModelObserver;
	/**
	 * @param textEditorClass
	 */
	public AbstractFSMEditor(Object textEditorClass) {
		super(textEditorClass);
	}

	public DiagnosingModelObserver getDiagnosingModelObserver() {
		return diagnosingModelObserver;
	}
	
	/**
	 * Attaches the DiagnosingModelObserver to the current RoomModel. If the 
	 * Observer is already attached, it is first detached.
	 */
	public void attachDiagnosingModelObserver() {
		DiagnosingModelObserver dmObserver = this.getDiagnosingModelObserver();
		// dmObserver may be null if graphical viewer is not yet initialized
		if(dmObserver != null) {
			// Ensure that the dmObserver is not bound to the previous RoomModel
			dmObserver.removeObserver();
			dmObserver.observeModel(getModel());
		}
	}
	
	/**
	 * Detaches the DiagnosingModelObserver from the diagram's associated 
	 * business model.
	 */
	public void detachDiagnosingModelObserver() {
		DiagnosingModelObserver dmObserver = this.getDiagnosingModelObserver();
		// dmObserver may be null if graphical viewer is not yet initialized
		if(dmObserver != null) {
			dmObserver.removeObserver();
		}
	}

	@Override
	public void initializeGraphicalViewer() {
		// Start observing the diagram business model for rendering Markers
		diagnosingModelObserver = new DiagnosingModelObserver();
		diagnosingModelObserver.observeModel(getModel());
		
		super.initializeGraphicalViewer();
		
		Command cmd = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				ContextSwitcher.switchTop(getDiagramTypeProvider().getDiagram());
			}
		};
		getEditingDomain().getCommandStack().execute(cmd);
		getEditingDomain().getCommandStack().flush();
	}

	public boolean showStateGraph(StateGraph sg) {
		URI boUri = EcoreUtil.getURI(sg);
		final StateGraph mySG = (StateGraph) getEditingDomain().getResourceSet().getEObject(boUri, true);
		if (mySG==null)
			return false;
		
		Command cmd = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				ContextSwitcher.switchTo(getDiagramTypeProvider().getDiagram(), mySG);
			}
		};
		getEditingDomain().getCommandStack().execute(cmd);
		getEditingDomain().getCommandStack().flush();
		
		return true;
	}

	@Override
	public void dispose() {
		// Stop observing the diagram business model
		if(diagnosingModelObserver != null) {
			diagnosingModelObserver.removeObserver();
		}
		
		super.dispose();
	}
	
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new AbstractFSMDiagramBehavior(this);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		
		FSMValidationUtil fsmValidationUtil = FSMSupportUtil.getInstance().getFSMValidationUtil();
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(diagram);
		if (mc.getStateMachine()!=null) {
			for (State s : mc.getStateMachine().getStates()) {
				if (s instanceof RefinedState) {
					if (fsmValidationUtil.isRefinedStateEmpty((RefinedState) s)) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(),
								"Check of Refined State",
								"A Refined State with empty action codes must have a non-empty sub state graph.");
						return;
					}
				}
			}
		}

		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {
			protected void doExecute() {
				cleanupBeforeSave();
			}
		});
		
		super.doSave(monitor);
	}

	/**
	 * is called before actually saving the model
	 */
	protected void cleanupBeforeSave() {
		removeEmptySubgraphs();
		rebaseRefinedStates();
		removeUnusedRefinedStates();
	}
	
	/**
	 * removes dangling refined states
	 */
	protected void removeUnusedRefinedStates() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(diagram);
		
		if (mc.getStateMachine()!=null) {
			ArrayList<RefinedState> toBeRemoved = new ArrayList<RefinedState>();
			for (State s : mc.getStateMachine().getStates()) {
				if (s instanceof RefinedState) {
					if (isUnused((RefinedState)s))
						toBeRemoved.add((RefinedState) s);
				}
			}
			
			mc.getStateMachine().getStates().removeAll(toBeRemoved);
		}
	}

	/**
	 * determines whether a refined state is actually used.
	 * I.e. it has at least one of
	 * <ul>
	 * <li>direct substructure</li>
	 * <li>entry code</li>
	 * <li>exit code</li>
	 * </ul>
	 * 
	 * @param s
	 * @return whether a refined state is actually used
	 */
	private boolean isUnused(RefinedState s) {
		FSMHelpers fsmHelpers = FSMSupportUtil.getInstance().getFSMHelpers();
		if (fsmHelpers.hasDirectSubStructure(s))
			return false;
		if (fsmHelpers.hasDetailCode(s.getEntryCode()))
			return false;
		if (fsmHelpers.hasDetailCode(s.getExitCode()))
			return false;
		
		return true;
	}

	/**
	 * removes empty subgraphs
	 */
	protected void removeEmptySubgraphs() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		FSMHelpers fsmHelpers = FSMSupportUtil.getInstance().getFSMHelpers();
	
		// if our current context is an empty state graph we go one level up
		StateGraph current = ContextSwitcher.getCurrentStateGraph(diagram);
		if (current!=null && current.eContainer() instanceof State) {
			State s = (State) current.eContainer();
			if (!fsmHelpers.hasDirectSubStructure(s)) {
				ContextSwitcher.goUp(diagram, current);
			}
		}
		
		ArrayList<Shape> toBeRemoved = new ArrayList<Shape>();
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			if (bo.eIsProxy()) {
				toBeRemoved.add(ctxShape);
				continue;
			}
			
			assert(bo instanceof StateGraph): "expected state graph";
			
			StateGraph sg = (StateGraph) bo;
			if (sg.eContainer() instanceof State) {
				State s = (State) sg.eContainer();
				if (!fsmHelpers.hasDirectSubStructure(s)) {
					EcoreUtil.delete(sg);
					toBeRemoved.add(ctxShape);
				}
			}
		}
		
		// need to recursively delete the shapes to avoid dangling HREFs
		for (Shape shape : toBeRemoved) {
			EcoreUtil.delete(shape, true);
		}
	}

	protected void rebaseRefinedStates() {
		ModelComponent mc = getModelComponent();
	
		if (mc.getStateMachine()==null)
			return;
		
		Function<RefinedState, String> nameProvider = FSMSupportUtil.getInstance().getFSMNameProvider().getRefinedStateNameProvider();
		Map<RefinedState, RefinedState> rs2parent = FSMSupportUtil.getInstance().getFSMHelpers().getRefinedStatesToRelocate(mc, nameProvider);
		
		// move all to the new context
		for (RefinedState rs : rs2parent.keySet()) {
			RefinedState parent = rs2parent.get(rs);
			if (parent.getSubgraph()==null)
				parent.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
			parent.getSubgraph().getStates().add(rs);
		}
	}

	@Override
	protected void superClassChanged() {
		IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
		Diagram diagram = diagramTypeProvider.getDiagram();
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
		IUpdateContext updateCtx = new UpdateContext(diagram);
		featureProvider.updateIfPossible(updateCtx);
		diagramTypeProvider.getDiagramBehavior().refresh();
	}
}
