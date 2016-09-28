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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.ui.FSMUiModule;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.fsm.util.FSMNewNamingUtil;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtil;
import org.eclipse.etrice.ui.behavior.fsm.commands.StateGraphContext;
import org.eclipse.etrice.ui.behavior.fsm.support.IPositionProvider.Pos;
import org.eclipse.etrice.ui.behavior.fsm.support.IPositionProvider.PosAndSize;
import org.eclipse.etrice.ui.common.base.support.CommonSupportUtil;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILinkService;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMSupportUtil {

	private static final String INITIAL = "init";
	private static final String STATE = "state:";
	private static final String TP = "tp:";
	private static final String CP = "cp:";
	private static final String SEP = ".";
	private static FSMSupportUtil instance = null;

	/**
	 * @return the instance
	 */
	public static FSMSupportUtil getInstance() {
		if (instance==null) {
			// this class has members that have to be filled by the FSMUi injector
			Injector injector = FSMUiModule.getInjector();
	        instance = injector.getInstance(FSMSupportUtil.class);
		}
		return instance;
	}

	@Inject
	private FSMHelpers fsmHelpers;
	@Inject
	private FSMValidationUtil fsmValidationUtil;
	@Inject
	private FSMNameProvider fsmNameProvider;
	@Inject
	private FSMNewNamingUtil fsmNewNamingUtil;

	/**
	 * @return the roomHelpers
	 */
	public FSMHelpers getFSMHelpers() {
		return fsmHelpers;
	}

	/**
	 * @return the validationUtil
	 */
	public FSMValidationUtil getFSMValidationUtil() {
		return fsmValidationUtil;
	}

	/**
	 * @return the roomUtil
	 */
	public FSMNewNamingUtil getFSMNewNamingUtil() {
		return fsmNewNamingUtil;
	}

	/**
	 * @return the roomNameProvider
	 */
	public FSMNameProvider getFSMNameProvider() {
		return fsmNameProvider;
	}

	public EObject getOwnObject(EObject obj, ResourceSet rs) {
		URI uri = EcoreUtil.getURI(obj);
		EObject own = rs.getEObject(uri, true);
		assert(own!=null): "own object must exist";
		return own;
	}

	public boolean isInherited(Diagram diag, EObject obj) {
		if(obj instanceof StateGraph)
			obj = obj.eContainer();
		else if (obj instanceof ModelComponent)
			return ((ModelComponent) obj).getBase() != null;
		
		return  obj instanceof RefinedState || obj instanceof RefinedTransition || !EcoreUtil.isAncestor(getModelComponent(diag), obj);
	}

	public boolean showAsInherited(Diagram diag, State obj) {
	
		if (obj instanceof RefinedState)
			return true;
	
		return fsmHelpers.getModelComponent(obj)!=getModelComponent(diag);
	}

	public Diagram getDiagram(GraphicsAlgorithm ga) {
		if (ga.eContainer() instanceof GraphicsAlgorithm)
			return getDiagram((GraphicsAlgorithm)ga.eContainer());
		return getDiagram(ga.getPictogramElement());
	}

	/**
	 * @param pictogramElement
	 * @return
	 */
	public Diagram getDiagram(PictogramElement pe) {
		while (pe.eContainer()!=null) {
			if (pe.eContainer() instanceof Diagram)
				return (Diagram) pe.eContainer();
			pe = (PictogramElement) pe.eContainer();
		}
		return null;
	}

	public ModelComponent getModelComponent(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ModelComponent)
			return (ModelComponent) bo;
		return null;
	}

	/**
	 * @param sg
	 * @param mc
	 * @param targetContainer
	 * @param fp
	 * @return
	 */
	public StateGraph insertRefinedState(StateGraph sg, ModelComponent mc, ContainerShape targetContainer,
			IFeatureProvider fp) {
				sg = getSubGraphOfRefinedStateFor((State) sg.eContainer(), mc);
				fp.link(targetContainer, sg);
				return sg;
			}

	/**
	 * @param sg
	 * @param mc
	 * @param targetContainer
	 */
	public void undoInsertRefinedState(StateGraph sg, ModelComponent mc,
			ContainerShape targetContainer, IFeatureProvider fp) {
				RefinedState rs = (RefinedState) sg.eContainer();
				fp.link(targetContainer, rs.getTarget().getSubgraph());
				
				if (!(fsmHelpers.hasDetailCode(rs.getEntryCode()) || fsmHelpers.hasDetailCode(rs.getExitCode()))) {
					mc.getStateMachine().getStates().remove(rs);
				}
			}

	/**
	 * @param s
	 * @param mc
	 * @return
	 */
	public StateGraph getSubGraphOfRefinedStateFor(State s, ModelComponent mc) {
		RefinedState rs = getRefinedStateFor(s, mc);
		
		if (rs.getSubgraph()==null)
			rs.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
	
		return rs.getSubgraph();
	}

	public RefinedState getRefinedStateFor(State s, ModelComponent mc) {
		HashMap<State, RefinedState> target2rs = new HashMap<State, RefinedState>();
		for (State st : mc.getStateMachine().getStates()) {
			if (st instanceof RefinedState)
				target2rs.put(((RefinedState) st).getTarget(), (RefinedState) st);
		}
		
		RefinedState rs = null;
		
		// do we already have a RefinedState pointing to s?
		if (target2rs.containsKey(s)) {
			rs = target2rs.get(s);
		}
		else {
			// we have to create one and place it in the best fitting context
			StateGraph sg = null;
			State parent = s;
			while (parent.eContainer().eContainer() instanceof State) {
				parent = (State) s.eContainer().eContainer();
				if (target2rs.containsKey(parent)) {
					RefinedState bestFitting = target2rs.get(parent);
					if (bestFitting.getSubgraph()==null)
						bestFitting.setSubgraph(FSMFactory.eINSTANCE.createStateGraph());
					sg = bestFitting.getSubgraph();
					break;
				}
			}
			
			if (sg==null)
				sg = mc.getStateMachine();
			
			rs = FSMFactory.eINSTANCE.createRefinedState();
			rs.setTarget(s);
			sg.getStates().add(rs);
		}
		return rs;
	}

	/**
	 * @param state
	 * @param diagram
	 * @return
	 */
	public State getTargettingState(State state, Diagram diagram) {
		ModelComponent mc = getModelComponent(diagram);
		return fsmHelpers.getTargettingState(state, mc);
	}

	/**
	 * This method exploits the fact that the immediate children of the diagram are
	 * associated with the state graphs.
	 * 
	 * @param shape
	 * @return the container shape that is associated with the state graph of the diagram
	 */
	public ContainerShape getStateGraphContainer(ContainerShape shape) {
		while (shape!=null) {
			ContainerShape parent = shape.getContainer();
			if (parent instanceof Diagram)
				return shape;
			shape = parent;
		}
		return null;
	}

	public StateGraph getStateGraph(ContainerShape cs, IFeatureProvider fp) {
		ContainerShape shape = getStateGraphContainer(cs);
		Object bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StateGraph)
			return (StateGraph) bo;
		else
			assert(false): "state graph expected";
			
		return null;
	}

	public TransitionTerminal getTransitionTerminal(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof TrPoint) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof State) {
					State state = (parent instanceof RefinedState)? ((RefinedState)parent).getTarget() : (State)parent;
					SubStateTrPointTerminal sstpt = FSMFactory.eINSTANCE.createSubStateTrPointTerminal();
					sstpt.setState(state);
					sstpt.setTrPoint((TrPoint) obj);
					return sstpt;
				}
				else {
					TrPointTerminal tpt = FSMFactory.eINSTANCE.createTrPointTerminal();
					tpt.setTrPoint((TrPoint) obj);
					return tpt;
				}
			}
			else if (obj instanceof State) {
				State state = (obj instanceof RefinedState)? ((RefinedState)obj).getTarget() : (State)obj;
				StateTerminal st = FSMFactory.eINSTANCE.createStateTerminal();
				st.setState(state);
				return st;
			}
			else if (obj instanceof ChoicePoint) {
				ChoicepointTerminal ct = FSMFactory.eINSTANCE.createChoicepointTerminal();
				ct.setCp((ChoicePoint) obj);
				return ct;
			}
		}
		return null;
	}

	public boolean isInitialPoint(Anchor anchor, IFeatureProvider fp) {
		if (anchor!=null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof StateGraph) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof StateGraph)
					return true;
			}
		}
		return false;
	}

	public boolean canConnect(Anchor asrc, Anchor atgt, ContainerShape cs, IFeatureProvider fp) {
		return canConnect(asrc, atgt, null, cs, fp);
	}

	public boolean canConnect(Anchor asrc, Anchor atgt, Transition trans,
			ContainerShape cs, IFeatureProvider fp) {
				TransitionTerminal src = getTransitionTerminal(asrc, fp);
				TransitionTerminal tgt = getTransitionTerminal(atgt, fp);
				
				if (src==null && !isInitialPoint(asrc, fp))
					return false;
				if (tgt==null)
					return false;
				
				StateGraph sg = getStateGraph(cs, fp);
				if (sg==null)
					return false;
				
				return fsmValidationUtil.isConnectable(src, tgt, trans, sg).isOk();
			}

	/**
	 * @param s the state whose sub structure should be deleted
	 * @param mc the ModelComponent
	 * @param diagram the current diagram
	 * @param fp the feature provider
	 */
	public void deleteSubStructureRecursive(State s, ModelComponent mc,
			Diagram diagram, IFeatureProvider fp) {
				if (fsmHelpers.hasSubStructure(s, mc)) {
					StateGraph subgraph = s.getSubgraph();
					
					// depth first
					for (State st : subgraph.getStates()) {
						deleteSubStructureRecursive(st, mc, diagram, fp);
					}
					
					ContainerShape subShape = ContextSwitcher.getContext(diagram, subgraph);
					CommonSupportUtil.deleteConnectionsRecursive(subShape, fp);
					EcoreUtil.delete(subShape, true);
				}
			}

	public List<State> getStates(ContainerShape shape, IFeatureProvider fp) {
		return getStates(shape, fp, null, null);
	}

	private List<State> getStates(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> item2anchor, List<Shape> stateShapes) {
		List<State> items = new ArrayList<State>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof State) {
				items.add((State)bo);
				if (item2anchor!=null)
					item2anchor.put(getKey((State)bo), ch.getAnchors().get(0));
				if (stateShapes!=null)
					stateShapes.add(ch);
			}
		}
		return items;
	}

	public List<ChoicePoint> getChoicePoints(ContainerShape shape, IFeatureProvider fp) {
		return getChoicePoints(shape, fp, null, null);
	}

	private List<ChoicePoint> getChoicePoints(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> item2anchor,
			List<Shape> cpShapes) {
				List<ChoicePoint> items = new ArrayList<ChoicePoint>();
				for (Shape ch : shape.getChildren()) {
					Object bo = fp.getBusinessObjectForPictogramElement(ch);
					if (bo instanceof ChoicePoint) {
						items.add((ChoicePoint)bo);
						if (item2anchor!=null)
							item2anchor.put(getKey((ChoicePoint)bo), ch.getAnchors().get(0));
						if (cpShapes!=null)
							cpShapes.add(ch);
					}
				}
				return items;
			}

	public List<TrPoint> getTrPoints(StateGraph sg, ContainerShape shape, IFeatureProvider fp) {
		return getTrPoints(sg, shape, fp, null, null);
	}

	private List<TrPoint> getTrPoints(StateGraph sg, ContainerShape shape, IFeatureProvider fp,
			Map<String, Anchor> item2anchor, List<Shape> tpShapes) {
				List<TrPoint> items = new ArrayList<TrPoint>();
				for (Shape ch : shape.getChildren()) {
					Object bo = fp.getBusinessObjectForPictogramElement(ch);
					if (bo instanceof TrPoint) {
						items.add((TrPoint)bo);
						if (item2anchor!=null)
							item2anchor.put(getKey((TrPoint)bo), ch.getAnchors().get(0));
						if (tpShapes!=null)
							tpShapes.add(ch);
					}
				}
				return items;
			}

	/**
	 * @param diagram
	 * @param fp
	 * @return
	 */
	public List<Transition> getTransitions(Diagram diagram, IFeatureProvider fp) {
		List<Transition> transitions = new ArrayList<Transition>();
		for (Connection conn : diagram.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			if (bo instanceof Transition)
				transitions.add((Transition) bo);
		}
		return transitions;
	}

	private Map<Transition, Connection> getTransitionsMap(ContainerShape sgShape, IFeatureProvider fp) {
		Diagram diagram = (Diagram) sgShape.eContainer();
		Map<Transition, Connection> transitions = new HashMap<Transition, Connection>();
		for (Connection conn : diagram.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			
			// we only collect connections that have a starting point contained in our sgShape
			if (bo instanceof Transition && EcoreUtil.isAncestor(sgShape, conn.getStart()))
				transitions.put((Transition) bo, conn);
		}
		return transitions;
	}

	/**
	 * @param sgShape
	 * @param node2anchor
	 */
	private void getSubTpAnchors(ContainerShape sgShape, HashMap<String, Anchor> node2anchor) {
		for (Shape childShape : sgShape.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(childShape);
			if (bo instanceof State)
				getAnchors((State) bo, childShape, node2anchor);
		}
	}

	public ContainerShape addStateGraph(StateGraphContext ctx, Diagram diagram, IFeatureProvider fp) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(ctx.getStateGraph());
		addContext.setTargetContainer(diagram);
		PosAndSize graphPosAndSize = ctx.getPositionProvider().getGraphPosAndSize(ctx.getStateGraph());
		if (graphPosAndSize!=null) {
			addContext.setX(graphPosAndSize.getX());
			addContext.setY(graphPosAndSize.getY());
			addContext.setWidth(graphPosAndSize.getWidth());
			addContext.setHeight(graphPosAndSize.getHeight());
		}
		else {
			addContext.setX(StateGraphSupport.MARGIN);
			addContext.setY(StateGraphSupport.MARGIN);
		}
		
		ContainerShape sgShape = (ContainerShape) fp.addIfPossible(addContext);
		if (sgShape==null)
			return null;
		
		final HashMap<String, Anchor> node2anchor = new HashMap<String, Anchor>();
		
		GraphicsAlgorithm borderRect = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
		ctx.getPositionProvider().setScale(borderRect.getWidth(), borderRect.getHeight());
		ctx.getPositionProvider().setPosition(sgShape.getGraphicsAlgorithm().getX(), sgShape.getGraphicsAlgorithm().getY());
		
		addInitialPointIff(ctx, ctx.getPositionProvider(), sgShape, fp, node2anchor);
		addStateGraphNodes(ctx.getTrPoints(), ctx.getPositionProvider(), sgShape, fp, node2anchor);
		addStateGraphNodes(ctx.getStates(), ctx.getPositionProvider(), sgShape, fp, node2anchor);
		addStateGraphNodes(ctx.getChPoints(), ctx.getPositionProvider(), sgShape, fp, node2anchor);
	
		for (StateGraphContext sub : ctx.getChildren()) {
			addStateGraph(sub, diagram, fp);
		}
		
		getSubTpAnchors(sgShape, node2anchor);
		
		addTransitions(ctx.getTransitions(), ctx.getPositionProvider(), sgShape, fp, node2anchor);
		
		return sgShape;
	}

	private void addInitialPointIff(StateGraphContext ctx, IPositionProvider positionProvider, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
			
				// model
				StateGraph sg = ctx.getInitialPoint();
				if(sg==null)
					// (super class) diagram
					sg = positionProvider.getInitialPoint(ctx.getStateGraph());
				if(sg==null)
					return;
				
				PosAndSize pos = positionProvider.getPosition(sg);		
				AddContext addContext = new AddContext();
				addContext.setNewObject(sg);
				addContext.setTargetContainer(sgShape);
				if(pos != null){
					addContext.setX(pos.getX());
					addContext.setY(pos.getY());
					if (pos.getWidth()>0 && pos.getHeight()>0) {
						addContext.setWidth(pos.getWidth());
						addContext.setHeight(pos.getHeight());
					}
				} else {
					addContext.setX(3*StateGraphSupport.MARGIN);
					addContext.setY(3*StateGraphSupport.MARGIN);
				}
				
				ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
				assert(pe!=null): "initial point should have been created";
				assert(!pe.getAnchors().isEmpty()): "initial point should have an anchor";
				node2anchor.put(INITIAL, pe.getAnchors().get(0));
			}

	public void updateStateGraph(StateGraph sg, StateGraphContext ctx, ContainerShape sgShape,
			IFeatureProvider fp) {
			
				HashMap<String, Anchor> node2anchor = new HashMap<String, Anchor>();
				
				GraphicsAlgorithm borderRect = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
				ctx.getPositionProvider().setScale(borderRect.getWidth(), borderRect.getHeight());
				ctx.getPositionProvider().setPosition(sgShape.getGraphicsAlgorithm().getX(), sgShape.getGraphicsAlgorithm().getY());
				
				// states
				{
					ArrayList<Shape> shapes = new ArrayList<Shape>();
					List<State> present = getStates(sgShape, fp, node2anchor, shapes);
					checkDuplicates(present);
					List<State> expected = ctx.getStates();
					List<State> toAdd = new ArrayList<State>();
					List<State> toUpdate = new ArrayList<State>();
					List<State> toRemove = new ArrayList<State>();
					for (State item : expected) {
						if (present.contains(item))
							toUpdate.add(item);
						else
							toAdd.add(item);
					}
					for(State item : present){
						if(!expected.contains(item))
							toRemove.add(item);
					}
			    	addStateGraphNodes(toAdd, ctx.getPositionProvider(), sgShape, fp, node2anchor);
			    	updateStateGraphNodes(toUpdate, shapes, ctx.getPositionProvider(), fp);
			    	removeGraphicalRepresentation(toRemove, shapes, fp);
				}
				
				// transition points
				{
					ArrayList<Shape> shapes = new ArrayList<Shape>();
					List<TrPoint> present = getTrPoints(sg, sgShape, fp, node2anchor, shapes);
					checkDuplicates(present);
					List<TrPoint> expected = ctx.getTrPoints();
					List<TrPoint> toAdd = new ArrayList<TrPoint>();
					List<TrPoint> toUpdate = new ArrayList<TrPoint>();
					List<TrPoint> toRemove = new ArrayList<TrPoint>();
					for (TrPoint item : expected) {
						if (present.contains(item))
							toUpdate.add(item);
						else
							toAdd.add(item);
					}
					for(TrPoint item : present){
						if(!expected.contains(item))
							toRemove.add(item);
					}
			    	addStateGraphNodes(toAdd, ctx.getPositionProvider(), sgShape, fp, node2anchor);
			    	updateStateGraphNodes(toUpdate, shapes, ctx.getPositionProvider(), fp);
			    	removeGraphicalRepresentation(toRemove, shapes, fp);
				}
				
				// choice points
				{
					ArrayList<Shape> shapes = new ArrayList<Shape>();
					List<ChoicePoint> present = getChoicePoints(sgShape, fp, node2anchor, shapes);
					checkDuplicates(present);
					List<ChoicePoint> expected = ctx.getChPoints();
					List<ChoicePoint> toAdd = new ArrayList<ChoicePoint>();
					List<ChoicePoint> toUpdate = new ArrayList<ChoicePoint>();
					List<ChoicePoint> toRemove = new ArrayList<ChoicePoint>();
					for (ChoicePoint item : expected) {
						if (present.contains(item))
							toUpdate.add(item);
						else
							toAdd.add(item);
					}
					for(ChoicePoint item : present){
						if(!expected.contains(item))
							toRemove.add(item);
					}
			    	addStateGraphNodes(toAdd, ctx.getPositionProvider(), sgShape, fp, node2anchor);
			    	updateStateGraphNodes(toUpdate, shapes, ctx.getPositionProvider(), fp);
			    	removeGraphicalRepresentation(toRemove, shapes, fp);
				}
				
				getSubTpAnchors(sgShape, node2anchor);
			
				// initial point
				{
					// exists in this diagram ?
					Shape present = null;
					for (Shape ch : sgShape.getChildren()) {
						Object bo = fp.getBusinessObjectForPictogramElement(ch);
						if (bo instanceof StateGraph)
							present = ch;
					}
					if(present != null)
						node2anchor.put(INITIAL, present.getAnchors().get(0));
					// exists in model ?
					StateGraph expected = ctx.getInitialPoint();
					if(expected == null)
						// exists in (super class) diagram ? 
						expected = ctx.getPositionProvider().getInitialPoint(ctx.getStateGraph());
					if(expected != null && present == null)
						addInitialPointIff(ctx, ctx.getPositionProvider(), sgShape, fp, node2anchor);
					else
						updateInitialPoint(present, ctx.getPositionProvider(), fp);
				}
				
				// transitions
				{
					// get transitions that belong to our state graph
					// (for other connections we might not have the node anchors yet)
					Map<Transition, Connection> present = getTransitionsMap(sgShape, fp);
					List<Transition> expected = ctx.getTransitions();
					List<Transition> toAdd = new ArrayList<Transition>();
					List<Transition> toRemove = new ArrayList<Transition>();
					for (Transition trans : expected)
						if (!present.containsKey(trans))
							toAdd.add(trans);
					for(Transition item : present.keySet()){
						if(!expected.contains(item))
							toRemove.add(item);
					}
					addTransitions(toAdd, ctx.getPositionProvider(), sgShape, fp, node2anchor);
					updateTransitions(present, ctx.getPositionProvider(), sgShape, fp, node2anchor);
					removeGraphicalRepresentation(toRemove, present.values(), fp);
				}
			}

	/**
	 * @param items
	 */
	private void checkDuplicates(List<? extends StateGraphItem> items) {
		for (StateGraphItem item : items) {
			if (items.indexOf(item)!=items.lastIndexOf(item)) {
				Assert.isTrue(
						items.indexOf(item)==items.lastIndexOf(item),
						"multiple occurrences of "+fsmNameProvider.getFullPath(item));
			}
		}
	}

	private void addTransitions(List<Transition> transitions, IPositionProvider positionProvider, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
			
				for (Transition trans : transitions) {
					String from = (trans instanceof InitialTransition)? INITIAL:getKey(((NonInitialTransition)trans).getFrom());
					String to = getKey(trans.getTo());
					Anchor src = node2anchor.get(from);
					Anchor dst = node2anchor.get(to);
			
					assert(src!=null && dst!=null): "transition endpoints must be present";
					
					AddConnectionContext context = new AddConnectionContext(src, dst);
					context.setNewObject(trans);
					PictogramElement pe = fp.addIfPossible(context);
					if (pe instanceof FreeFormConnection) {
						FreeFormConnection conn = (FreeFormConnection) pe;
						
						// JH: workaround for correct bend points of inherited self transition
						conn.getBendpoints().clear();
						
						List<Pos> points = positionProvider.getPoints(trans);
						if (points!=null && !points.isEmpty()) {
							Iterator<Pos> it = points.iterator();
							
							// first is label position
							Pos pos = it.next();
							ConnectionDecorator cd = conn.getConnectionDecorators().get(1);
							Graphiti.getGaService().setLocation(cd.getGraphicsAlgorithm(), pos.getX(), pos.getY());
							
							// remaining are bend points
							while (it.hasNext()) {
								pos = it.next();
								Point pt = Graphiti.getGaService().createPoint(pos.getX(), pos.getY());
								conn.getBendpoints().add(pt);
							}
						}
						else if (src==dst) {
							ILocation begin = Graphiti.getPeService().getLocationRelativeToDiagram(conn.getStart());
							Point pt = Graphiti.getGaService().createPoint(begin.getX(), begin.getY()+StateGraphSupport.MARGIN*3);
							conn.getBendpoints().add(pt);
						}
					}
				}
			}

	private void addStateGraphNodes(List<? extends StateGraphNode> nodes, IPositionProvider positionProvider, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
				
				List<PosAndSize> positions = positionProvider.getPositions(nodes);
				
				int idx = 0;
				for (StateGraphNode node : nodes) {
					addStateGraphNode(node, sgShape, positions.get(idx), fp, node2anchor);
					++idx;
				}
			}

	private void addStateGraphNode(StateGraphNode tp, ContainerShape sgShape, PosAndSize pos,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
				AddContext addContext = new AddContext();
				addContext.setNewObject(tp);
				addContext.setTargetContainer(sgShape);
				addContext.setX(pos.getX());
				addContext.setY(pos.getY());
				if (pos.getWidth()>0 && pos.getHeight()>0) {
					addContext.setWidth(pos.getWidth());
					addContext.setHeight(pos.getHeight());
				}
				
				ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
				assert(pe!=null): tp.eClass().getName()+" should have been created";
				assert(!pe.getAnchors().isEmpty()): tp.eClass().getName()+" should have an anchor";
				node2anchor.put(getKey(tp), pe.getAnchors().get(0));
			}

	private void updateInitialPoint(Shape shape, IPositionProvider positionProvider, IFeatureProvider fp) {
		if (shape==null)
			return;
		
		StateGraph sg = (StateGraph) fp.getBusinessObjectForPictogramElement(shape);
		PosAndSize ps = positionProvider.getPosition(sg);
		if (ps==null)
			return;
		
		// relocate and resize the invisible rectangle
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
	
		Graphiti.getLayoutService().setLocationAndSize(
			ga,
			ps.getX(),
			ps.getY(),
			ps.getWidth(),
			ps.getHeight()
		);
		
		// have to call the layout to adjust the visible border
		LayoutContext lc = new LayoutContext(shape);
		fp.layoutIfPossible(lc);
	}

	private void updateStateGraphNodes(List<? extends StateGraphNode> nodes, List<Shape> shapes,
			IPositionProvider positionProvider, IFeatureProvider fp) {
					
					ILinkService linkService = Graphiti.getLinkService();
					IGaService gaService = Graphiti.getGaService();
					
					for (StateGraphNode node : nodes) {
						PosAndSize ps = positionProvider.getPosition(node);
						if (ps==null)
							continue;
						
						// TODO: sub-optimal since quadratic effort - use combined list for nodes and shapes or similar solution
						for (Shape shape : shapes) {
							EObject bo = linkService.getBusinessObjectForLinkedPictogramElement(shape);
							if (bo==node) {
								// relocate and resize the invisible rectangle
								GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
//								System.out.println(node + ": "+ga.getX()+" "+ga.getY()+" "+ga.getWidth()+" "+ga.getHeight());
//								System.out.println("  -> "+ps.getX()+" "+ps.getY()+" "+ps.getWidth()+" "+ps.getHeight());
			
								int margin = 0;
								if (node instanceof State)
									margin = StateSupport.MARGIN;
								else if (node instanceof TrPoint)
									margin = TrPointSupport.MARGIN;
								
								gaService.setLocationAndSize(
										ga,
										ps.getX()-margin,
										ps.getY()-margin,
										ps.getWidth()+2*margin,
										ps.getHeight()+2*margin
									);
								
								// have to call the layout to adjust the visible border
								LayoutContext lc = new LayoutContext(shape);
								fp.layoutIfPossible(lc);
								
								// update position of sub items
								if(shape instanceof ContainerShape){
									ContainerShape container = (ContainerShape) shape;
									for(Shape child : container.getChildren()){
										EObject childBo = linkService.getBusinessObjectForLinkedPictogramElement(child);
										if(!(childBo instanceof StateGraphNode))
											continue;
										
										double[] relPos = positionProvider.getSubPosition((StateGraphNode) childBo);
										gaService.setLocation(child.getGraphicsAlgorithm(), (int)(relPos[0] * ps.getWidth()), (int)(relPos[1]*ps.getHeight()));
									}
								}
								
								break;
							}
						}
					}
				}
	
	public void removeGraphicalRepresentation(Collection<? extends EObject> toRemove, Collection<? extends PictogramElement> pictograms, IFeatureProvider fp) {
		for(EObject bo : toRemove)
			for(PictogramElement pe : pictograms)
				if(fp.getBusinessObjectForPictogramElement(pe) == bo){
					IRemoveContext rc = new RemoveContext(pe);
					IRemoveFeature removeFeature = fp.getRemoveFeature(rc);
					if (removeFeature != null)
						removeFeature.remove(rc);
					break;
				}
	}

	private void updateTransitions(Map<Transition, Connection> transitions, IPositionProvider positionProvider, ContainerShape sgShape,
			IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
				
				for(Entry<Transition, Connection> e: transitions.entrySet()){
					Transition trans = e.getKey();
					Connection conn = e.getValue();
					
					String from = (trans instanceof InitialTransition)? INITIAL:getKey(((NonInitialTransition)trans).getFrom());
					String to = getKey(trans.getTo());
					Anchor newSrc = node2anchor.get(from);
					Anchor newDst = node2anchor.get(to);
					
					assert(newSrc!=null && newDst!=null): "transition endpoints must be present";
					
					if(conn.getStart()!=newSrc)
						conn.setStart(newSrc);
					if(conn.getEnd()!=newDst)
						conn.setEnd(newDst);			
					
					List<Pos> points = positionProvider.getPoints(trans);
					Iterator<Pos> it = points.iterator();
					if (points==null || points.isEmpty())
						continue;
					
					// first is label position
					Pos pos = it.next();
					ConnectionDecorator cd = conn.getConnectionDecorators().get(1);
					Graphiti.getGaService().setLocation(cd.getGraphicsAlgorithm(), pos.getX(), pos.getY());
					
					if (conn instanceof FreeFormConnection) {
						FreeFormConnection fconn = (FreeFormConnection) conn;
			
						// remaining are bend points
						fconn.getBendpoints().clear();
						List<Point> bendpoints = new ArrayList<Point>();
						while (it.hasNext()) {
							pos = it.next();
							Point pt = Graphiti.getGaService().createPoint(pos.getX(), pos.getY());
							bendpoints.add(pt);
						}
						fconn.getBendpoints().addAll(bendpoints);
					}
				}
			}

	private void getAnchors(State state, PictogramElement stateShape, final HashMap<String, Anchor> node2anchor) {
		
		if (stateShape instanceof ContainerShape) {
			node2anchor.put(getKey(state), ((ContainerShape)stateShape).getAnchors().get(0));
			for (Shape child : ((ContainerShape) stateShape).getChildren()) {
				if (child instanceof ContainerShape) {
					ContainerShape childShape = (ContainerShape) child;
					if (!childShape.getAnchors().isEmpty()) {
						if (!childShape.getLink().getBusinessObjects().isEmpty()) {
							EObject obj = childShape.getLink().getBusinessObjects().get(0);
							if (obj instanceof EntryPoint || obj instanceof ExitPoint) {
								node2anchor.put(getKey(obj, true), childShape.getAnchors().get(0));
							}
						}
					}
				}
			}
		}
	}

	private String getKey(EObject obj) {
		return getKey(obj, false);
	}

	private String getKey(EObject obj, boolean subTp) {
		if (obj instanceof TrPoint) {
			TrPoint tp = (TrPoint) obj;
			if (!subTp)
				return TP+tp.getName();
			else {
				if (tp.eContainer().eContainer() instanceof State) {
					State s = (State) tp.eContainer().eContainer();
					return TP+tp.getName()+SEP+s.getName();
				}
				else {
					assert(false): "State expected";
				}
			}
		}
		else if (obj instanceof State) {
			return STATE+((State)obj).getName();
		}
		else if (obj instanceof ChoicePoint) {
			return CP+((ChoicePoint)obj).getName();
		}
		else if (obj instanceof TransitionTerminal) {
			TransitionTerminal tt = (TransitionTerminal) obj;
			if (tt instanceof ChoicepointTerminal) {
				return CP+((ChoicepointTerminal)tt).getCp().getName();
			}
			else if (tt instanceof StateTerminal) {
				return STATE+((StateTerminal)tt).getState().getName();
			}
			else if (tt instanceof SubStateTrPointTerminal) {
				SubStateTrPointTerminal sstt = (SubStateTrPointTerminal) tt;
				return TP+sstt.getTrPoint().getName()+SEP+sstt.getState().getName();
			}
			else if (tt instanceof TrPointTerminal) {
				return TP+((TrPointTerminal)tt).getTrPoint().getName();
			}
			else {
				assert(false): "unexpected sub type";
			}
		}
		assert(false): "unexpected type";
		return null;
	}

}
