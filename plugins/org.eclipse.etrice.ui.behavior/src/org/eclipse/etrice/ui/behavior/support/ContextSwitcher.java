package org.eclipse.etrice.ui.behavior.support;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

public class ContextSwitcher {

	public static void goUp(Diagram diagram, StateGraph sg) {
		// if the container is a state we can go up, else we are already on top
		if (sg.eContainer() instanceof State) {
			ActorClass ac = SupportUtil.getActorClass(diagram);
			StateGraph parent = getVirtualParent(sg, ac);
			
			if (parent.eContainer() instanceof ActorClass)
				ContextSwitcher.switchTop(diagram);
			else
				ContextSwitcher.switchTo(diagram, parent);
		}
	}

	/**
	 * @param sg
	 * @param ac
	 * @return
	 */
	private static StateGraph getVirtualParent(StateGraph sg, ActorClass ac) {
		State s = (State) sg.eContainer();
		
		// try to find a RefinedState pointing to the parent of s
		if (s.eContainer().eContainer() instanceof State) {
			ArrayList<ActorClass> hierarchy = new ArrayList<ActorClass>();
			do {
				hierarchy.add(0, ac);
				ac = ac.getBase();
			}
			while (ac!=null);
			
			RefinedState targeting = getTargetingState(hierarchy.iterator(), (State) s.eContainer().eContainer());
			if (targeting!=null)
				return targeting.getSubgraph();
		}
		
		// follow the target chain as long as the refined state resides in the top level
		while (s instanceof RefinedState && s.eContainer().eContainer() instanceof ActorClass)
			s = ((RefinedState)s).getTarget();
		
		return (StateGraph) s.eContainer();
	}

	/**
	 * @param it
	 * @param s
	 * @return
	 */
	private static RefinedState getTargetingState(Iterator<ActorClass> acit, State s) {
		ActorClass ac = acit.next();
		TreeIterator<EObject> it = ac.getStateMachine().eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof RefinedState) {
				if (((RefinedState) next).getTarget()==s)
					return (RefinedState) next;
			}
		}
		
		if (acit.hasNext())
			return getTargetingState(acit, s);
		
		return null;
	}

	public static void switchTop(Diagram diagram) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof ActorClass) {
			switchTo(diagram, ((ActorClass) bo).getStateMachine());
		}
	}
	
	public static void switchTo(Diagram diagram, StateGraph sg) {
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			if (bo.eIsProxy())
				continue;
			
			assert(bo instanceof StateGraph): "expected state graph";
			
			if (bo instanceof StateGraph && bo==sg)
				activateContext(ctxShape, true);
			else
				activateContext(ctxShape, false);
		}
		
		activateTransitions(diagram);
	}

	public static StateGraph getCurrentStateGraph(Diagram diagram) {
		for (Shape ctxShape : diagram.getChildren()) {
			if (ctxShape instanceof ContainerShape && ctxShape.isVisible()) {
				EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
				assert(bo instanceof StateGraph): "expected state graph";
				
				if (bo instanceof StateGraph)
					return (StateGraph) bo;
			}
		}
		return null;
	}
	
	public static ContainerShape getContext(Diagram diagram, StateGraph sg) {
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			assert(bo instanceof StateGraph): "expected state graph";
			
			if (bo instanceof StateGraph && bo==sg)
				return (ContainerShape) ctxShape;
		}
		return null;
	}
	
	private static void activateTransitions(Diagram diagram) {
		for (Connection conn : diagram.getConnections()) {
			if (conn.getStart()!=null) {
				boolean visible = conn.getStart().getParent().isVisible();
				conn.setVisible(visible);
				for (ConnectionDecorator dec : conn.getConnectionDecorators()) {
					dec.setVisible(visible);
				}
			}
			else {
				assert(false): "internal error";
			}
		}
	}

	private static void activateContext(Shape ctxShape, boolean activate) {
		ctxShape.setVisible(activate);
		TreeIterator<EObject> it = ctxShape.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof Shape) {
				((Shape) obj).setVisible(activate);
				EObject eobj = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement((Shape)obj);
				if (eobj instanceof State) {
					GraphicsAlgorithm border = ((Shape)obj).getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
					StateSupport.updateHints((State)eobj, border);
				}
			}
		}
	}
}
