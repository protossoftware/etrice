/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.etrice.ui.behavior.fsm.support.ContextSwitcher;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import com.google.common.base.Function;

/**
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

	@Override
	public void initializeGraphicalViewer() {
		// Start observing the Room Model for rendering Markers
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
		// Stop observing the Room Model
		diagnosingModelObserver.removeObserver();
		super.dispose();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {
			protected void doExecute() {
				removeEmptySubgraphs();
				rebaseRefinedStates();
				removeUnusedRefinedStates();
			}
		});
		
		super.doSave(monitor);
	}

	/**
	 * 
	 */
	protected void removeUnusedRefinedStates() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		ModelComponent ac = FSMSupportUtil.getInstance().getModelComponent(diagram);
		
		if (ac.getStateMachine()!=null) {
			ArrayList<RefinedState> toBeRemoved = new ArrayList<RefinedState>();
			for (State s : ac.getStateMachine().getStates()) {
				if (s instanceof RefinedState) {
					if (isUnused((RefinedState)s))
						toBeRemoved.add((RefinedState) s);
				}
			}
			
			ac.getStateMachine().getStates().removeAll(toBeRemoved);
		}
	}

	/**
	 * @param s
	 * @return
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
		ModelComponent ac = getModelComponent();
	
		if (ac.getStateMachine()==null)
			return;
		
		Function<RefinedState, String> nameProvider = FSMSupportUtil.getInstance().getFSMNameProvider().getRefinedStateNameProvider();
		Map<RefinedState, RefinedState> rs2parent = FSMSupportUtil.getInstance().getFSMHelpers().getRefinedStatesToRelocate(ac, nameProvider);
		
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
