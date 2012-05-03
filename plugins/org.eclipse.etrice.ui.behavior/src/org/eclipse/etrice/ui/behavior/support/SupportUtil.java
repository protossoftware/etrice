/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.etrice.ui.behavior.commands.StateGraphContext;
import org.eclipse.etrice.ui.common.support.CommonSupportUtil;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 *
 */
public class SupportUtil {

	private static final String INITIAL = "init";
	private static final String STATE = "state:";
	private static final String TP = "tp:";
	private static final String CP = "cp:";
	private static final String SEP = ".";
	
	public static boolean isInherited(StateGraphItem item, ContainerShape cs) {
		EObject container = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(cs);
		if (container instanceof StateGraph) {
			StateGraph sg = (StateGraph) container;
			return item.eContainer()!=sg;
		}
		else if (container instanceof State) {
			assert(item instanceof EntryPoint || item instanceof ExitPoint): "this MUST be an entry or exit point";
			
			// have to check whether the State is inherited
			State s = (State) container;
			ContainerShape sCont = cs.getContainer();
			EObject cls = sCont.getLink().getBusinessObjects().get(0);
			return s.eContainer()!=cls;
		}

		return false;
	}
	
	public static boolean isInherited(Diagram diag, EObject obj) {
		if (obj instanceof RefinedState)
			return true;

		ActorClass parent = getActorClass(diag);
		while (obj!=null) {
			if (obj instanceof ActorClass)
				return obj!=parent;
			
			obj = obj.eContainer();
		}
		assert(false): "no parent actor class found";
		return false;
	}

	public static Diagram getDiagram(GraphicsAlgorithm ga) {
		if (ga.eContainer() instanceof GraphicsAlgorithm)
			return getDiagram((GraphicsAlgorithm)ga.eContainer());
		return getDiagram(ga.getPictogramElement());
	}
	
	/**
	 * @param pictogramElement
	 * @return
	 */
	public static Diagram getDiagram(PictogramElement pe) {
		while (pe.eContainer()!=null) {
			if (pe.eContainer() instanceof Diagram)
				return (Diagram) pe.eContainer();
			pe = (PictogramElement) pe.eContainer();
		}
		return null;
	}

	public static ActorClass getActorClass(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		return null;
	}

	/**
	 * @param sg
	 * @param ac
	 * @param targetContainer
	 * @param fp
	 * @return
	 */
	public static StateGraph insertRefinedState(StateGraph sg, ActorClass ac,
			ContainerShape targetContainer, IFeatureProvider fp) {

		State base = (State) sg.eContainer();
		
		RefinedState rs = null;
		for (State s : ac.getStateMachine().getStates()) {
			if (s instanceof RefinedState)
				if (((RefinedState) s).getTarget()==base) {
					rs = (RefinedState) s;
					break;
				}
		}
		if (rs==null) {
			// we have to insert a refined state first
			rs = RoomFactory.eINSTANCE.createRefinedState();
			rs.setTarget(base);
			ac.getStateMachine().getStates().add(rs);
		}
		
		// now we create a state graph and change the context
		sg = RoomFactory.eINSTANCE.createStateGraph();
		rs.setSubgraph(sg);
		fp.link(targetContainer, sg);
		return sg;
	}
	
	/**
	 * @param sg
	 * @param ac
	 * @param targetContainer
	 */
	public static void undoInsertRefinedState(StateGraph sg, ActorClass ac,
			ContainerShape targetContainer, IFeatureProvider fp) {
		RefinedState rs = (RefinedState) sg.eContainer();
		fp.link(targetContainer, rs.getTarget().getSubgraph());
		
		if (!(RoomHelpers.hasDetailCode(rs.getEntryCode()) || RoomHelpers.hasDetailCode(rs.getExitCode()))) {
			ac.getStateMachine().getStates().remove(rs);
		}
	}

	/**
	 * @param state
	 * @param diagram
	 * @return
	 */
	public static State getTargettingState(State state, Diagram diagram) {
		ActorClass ac = SupportUtil.getActorClass(diagram);
		return RoomHelpers.getTargettingState(state, ac);
	}
	
	/**
	 * This method exploits the fact that the immediate children of the diagram are
	 * associated with the state graphs.
	 * 
	 * @param shape
	 * @return the container shape that is associated with the state graph of the diagram
	 */
	public static ContainerShape getStateGraphContainer(ContainerShape shape) {
		while (shape!=null) {
			ContainerShape parent = shape.getContainer();
			if (parent instanceof Diagram)
				return shape;
			shape = parent;
		}
		return null;
	}
	
	public static StateGraph getStateGraph(ContainerShape cs, IFeatureProvider fp) {
		ContainerShape shape = getStateGraphContainer(cs);
		Object bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StateGraph)
			return (StateGraph) bo;
		else
			assert(false): "state graph expected";
			
		return null;
	}
	
	public static TransitionTerminal getTransitionTerminal(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof TrPoint) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof State) {
					State state = (parent instanceof RefinedState)? ((RefinedState)parent).getTarget() : (State)parent;
					SubStateTrPointTerminal sstpt = RoomFactory.eINSTANCE.createSubStateTrPointTerminal();
					sstpt.setState(state);
					sstpt.setTrPoint((TrPoint) obj);
					return sstpt;
				}
				else {
					TrPointTerminal tpt = RoomFactory.eINSTANCE.createTrPointTerminal();
					tpt.setTrPoint((TrPoint) obj);
					return tpt;
				}
			}
			else if (obj instanceof State) {
				State state = (obj instanceof RefinedState)? ((RefinedState)obj).getTarget() : (State)obj;
				StateTerminal st = RoomFactory.eINSTANCE.createStateTerminal();
				st.setState(state);
				return st;
			}
			else if (obj instanceof ChoicePoint) {
				ChoicepointTerminal ct = RoomFactory.eINSTANCE.createChoicepointTerminal();
				ct.setCp((ChoicePoint) obj);
				return ct;
			}
		}
		return null;
	}

	public static boolean isInitialPoint(Anchor anchor, IFeatureProvider fp) {
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

	public static boolean canConnect(Anchor asrc, Anchor atgt, ContainerShape cs, IFeatureProvider fp) {
		return canConnect(asrc, atgt, null, cs, fp);
	}
	
	public static boolean canConnect(Anchor asrc, Anchor atgt, Transition trans, ContainerShape cs, IFeatureProvider fp) {
		TransitionTerminal src = SupportUtil.getTransitionTerminal(asrc, fp);
		TransitionTerminal tgt = SupportUtil.getTransitionTerminal(atgt, fp);
		
		if (src==null && !isInitialPoint(asrc, fp))
			return false;
		if (tgt==null)
			return false;
		
		StateGraph sg = SupportUtil.getStateGraph(cs, fp);
		if (sg==null)
			return false;
		
		return ValidationUtil.isConnectable(src, tgt, trans, sg).isOk();
	}

	/**
	 * @param s the state whose sub structure should be deleted
	 * @param ac the ActorClass
	 * @param diagram the current diagram
	 * @param fp the feature provider
	 */
	public static void deleteSubStructureRecursive(State s, ActorClass ac, Diagram diagram, IFeatureProvider fp) {
		if (RoomHelpers.hasSubStructure(s, ac)) {
			StateGraph subgraph = s.getSubgraph();
			
			// depth first
			for (State st : subgraph.getStates()) {
				deleteSubStructureRecursive(st, ac, diagram, fp);
			}
			
			ContainerShape subShape = ContextSwitcher.getContext(diagram, subgraph);
			CommonSupportUtil.deleteConnectionsRecursive(subShape, fp);
			EcoreUtil.delete(subShape, true);
		}
	}
	
	public static List<State> getStates(ContainerShape shape, IFeatureProvider fp) {
		return getStates(shape, fp, null);
	}
	
	public static List<State> getStates(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> item2anchor) {
		List<State> items = new ArrayList<State>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof State) {
				items.add((State)bo);
				if (item2anchor!=null)
					item2anchor.put(getKey((State)bo, null), ch.getAnchors().get(0));
			}
		}
		return items;
	}

	public static List<ChoicePoint> getChoicePoints(ContainerShape shape, IFeatureProvider fp) {
		return getChoicePoints(shape, fp, null);
	}
	
	/**
	 * @param shape
	 * @param fp
	 * @return
	 */
	public static List<ChoicePoint> getChoicePoints(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> item2anchor) {
		List<ChoicePoint> items = new ArrayList<ChoicePoint>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof ChoicePoint) {
				items.add((ChoicePoint)bo);
				if (item2anchor!=null)
					item2anchor.put(getKey((ChoicePoint)bo, null), ch.getAnchors().get(0));
			}
		}
		return items;
	}
	
	public static List<TrPoint> getTrPoints(StateGraph sg, ContainerShape shape, IFeatureProvider fp) {
		return getTrPoints(sg, shape, fp, null);
	}
	
	public static List<TrPoint> getTrPoints(StateGraph sg, ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> item2anchor) {
		List<TrPoint> items = new ArrayList<TrPoint>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof TrPoint) {
				items.add((TrPoint)bo);
				if (item2anchor!=null)
					item2anchor.put(getKey((TrPoint)bo, sg), ch.getAnchors().get(0));
			}
		}
		return items;
	}

	/**
	 * @param diagram
	 * @param fp
	 * @return
	 */
	public static List<Transition> getTransitions(Diagram diagram, IFeatureProvider fp) {
		List<Transition> transitions = new ArrayList<Transition>();
		for (Connection conn : diagram.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			if (bo instanceof Transition)
				transitions.add((Transition) bo);
		}
		return transitions;
	}

	/**
	 * @param sgShape
	 * @param node2anchor
	 */
	public static void getSubTpAnchors(ContainerShape sgShape, HashMap<String, Anchor> node2anchor) {
		for (Shape childShape : sgShape.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(childShape);
			if (bo instanceof State)
				getAnchors((State) bo, childShape, node2anchor);
		}
	}

	public static ContainerShape addStateGraph(StateGraphContext ctx, Diagram diagram, IFeatureProvider fp) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(ctx.getStateGraph());
		addContext.setTargetContainer(diagram);
		addContext.setX(StateGraphSupport.MARGIN);
		addContext.setY(StateGraphSupport.MARGIN);
		
		ContainerShape sgShape = (ContainerShape) fp.addIfPossible(addContext);
		if (sgShape==null)
			return null;
		
		final HashMap<String, Anchor> node2anchor = new HashMap<String, Anchor>();
		
		addInitialPointIff(ctx.getTransitions(), sgShape, fp, node2anchor);
		addTransitionPoints(ctx.getTrPoints(), sgShape, fp, node2anchor);
		addStates(ctx.getStates(), sgShape, fp, node2anchor);
		addChoicePoints(ctx.getChPoints(), sgShape, fp, node2anchor);

		for (StateGraphContext sub : ctx.getChildren()) {
			addStateGraph(sub, diagram, fp);
		}
		
		getSubTpAnchors(sgShape, node2anchor);
		
		addTransitions(ctx.getTransitions(), sgShape, fp, node2anchor);
		
		return sgShape;
	}

	public static void addTransitions(List<Transition> transitions, ContainerShape sgShape, IFeatureProvider fp,
			HashMap<String, Anchor> node2anchor) {

		for (Transition trans : transitions) {
			String from = (trans instanceof InitialTransition)? INITIAL:getKey(((NonInitialTransition)trans).getFrom(), null);
			String to = getKey(trans.getTo(), null);
			Anchor src = node2anchor.get(from);
			Anchor dst = node2anchor.get(to);

			assert(src!=null && dst!=null): "transition endpoints must be present";
			
			AddConnectionContext context = new AddConnectionContext(src, dst);
			context.setNewObject(trans);
			PictogramElement pe = fp.addIfPossible(context);
			if (src==dst && pe instanceof FreeFormConnection) {
				FreeFormConnection conn = (FreeFormConnection) pe;
				ILocation begin = Graphiti.getPeService().getLocationRelativeToDiagram(conn.getStart());
				Point pt = Graphiti.getGaService().createPoint(begin.getX(), begin.getY()+StateGraphSupport.MARGIN*3);
				conn.getBendpoints().add(pt);
			}
		}
	}

	public static void addTransitionPoints(List<TrPoint> trps, ContainerShape sgShape, IFeatureProvider fp,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = trps.size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (TrPoint tp : trps) {
			addTrPoint(tp, sgShape, pos+StateSupport.MARGIN, fp, node2anchor);
			pos += delta;
		}
	}

	public static void addTrPoint(TrPoint tp, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(tp);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(0);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(!pe.getAnchors().isEmpty()): "transition point should have an anchor";
		node2anchor.put(getKey(tp, (StateGraph) tp.eContainer()), pe.getAnchors().get(0));
	}

	public static void addStates(List<State> states, ContainerShape sgShape, IFeatureProvider fp,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = states.size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (State s : states) {
			addState(s, sgShape, pos+StateSupport.MARGIN, fp, node2anchor);
			pos += delta;
		}
	}

	public static void addState(State s, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(s);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/4);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "state should have been created";
		assert(!pe.getAnchors().isEmpty()): "state should have an anchor";
		node2anchor.put(getKey(s, null), pe.getAnchors().get(0));
	}

	public static void addChoicePoints(List<ChoicePoint> cps, ContainerShape sgShape, IFeatureProvider fp,
			HashMap<String, Anchor> node2anchor) {
		
		int width = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();
		int n = cps.size();
		int delta = width/(n+1);
		
		int pos = delta;
		for (ChoicePoint cp : cps) {
			addChoicePoint(cp, sgShape, pos+ChoicePointSupport.ITEM_SIZE, fp, node2anchor);
			pos += delta;
		}
	}

	public static void addChoicePoint(ChoicePoint cp, ContainerShape sgShape,
			int pos, IFeatureProvider fp, HashMap<String, Anchor> node2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(cp);
		addContext.setTargetContainer(sgShape);
		addContext.setX(pos);
		addContext.setY(StateGraphSupport.DEFAULT_SIZE_Y/2);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "choice point should have been created";
		assert(!pe.getAnchors().isEmpty()): "choice point should have an anchor";
		node2anchor.put(getKey(cp, null), pe.getAnchors().get(0));
	}

	public static void addInitialPointIff(List<Transition> transitions, ContainerShape sgShape, IFeatureProvider fp,
			HashMap<String, Anchor> node2anchor) {

		StateGraph sg = null;
		for (Transition t : transitions) {
			if (t instanceof InitialTransition) {
				sg = (StateGraph) t.eContainer();
				break;
			}
		}
		if (sg==null)
			return;
		
		AddContext addContext = new AddContext();
		addContext.setNewObject(sg);
		addContext.setTargetContainer(sgShape);
		addContext.setX(3*StateGraphSupport.MARGIN);
		addContext.setY(3*StateGraphSupport.MARGIN);
		
		ContainerShape pe = (ContainerShape) fp.addIfPossible(addContext);
		assert(pe!=null): "initial point should have been created";
		assert(!pe.getAnchors().isEmpty()): "initial point should have an anchor";
		node2anchor.put(INITIAL, pe.getAnchors().get(0));
	}

	public static void getAnchors(State state, PictogramElement stateShape,
			final HashMap<String, Anchor> node2anchor) {
		
		if (stateShape instanceof ContainerShape) {
			node2anchor.put(getKey(state, null), ((ContainerShape)stateShape).getAnchors().get(0));
			for (Shape child : ((ContainerShape) stateShape).getChildren()) {
				if (child instanceof ContainerShape) {
					ContainerShape childShape = (ContainerShape) child;
					if (!childShape.getAnchors().isEmpty()) {
						if (!childShape.getLink().getBusinessObjects().isEmpty()) {
							EObject obj = childShape.getLink().getBusinessObjects().get(0);
							if (obj instanceof EntryPoint || obj instanceof ExitPoint) {
								node2anchor.put(getKey(obj, null), childShape.getAnchors().get(0));
							}
						}
					}
				}
			}
		}
	}

	public static String getKey(EObject obj, StateGraph sg) {
		if (obj instanceof TrPoint) {
			TrPoint tp = (TrPoint) obj;
			if (tp.eContainer()==sg)
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
