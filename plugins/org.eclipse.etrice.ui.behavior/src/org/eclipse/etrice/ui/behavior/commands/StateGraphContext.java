package org.eclipse.etrice.ui.behavior.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.etrice.ui.behavior.support.StateGraphSupport;
import org.eclipse.etrice.ui.behavior.support.StateSupport;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

public class StateGraphContext {
	private ArrayList<StateGraphContext> children = new ArrayList<StateGraphContext>();
	
	private StateGraph stateGraph;
	private ArrayList<State> states = new ArrayList<State>();
	private ArrayList<ChoicePoint> chPoints = new ArrayList<ChoicePoint>();
	private ArrayList<TrPoint> trPoints = new ArrayList<TrPoint>();
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private HashMap<EObject, Point> obj2pos = null;
	
	private static HashMap<EObject, StateGraphContext> obj2ctx = new HashMap<EObject, StateGraphContext>();
	
	public static StateGraphContext createContextTree(ActorClass ac) {
		
		// the top level state graph is always the one of our actor class
		if (ac.getStateMachine()==null || ac.getStateMachine().eIsProxy()) {
			ac.setStateMachine(RoomFactory.eINSTANCE.createStateGraph());
		}
		
		// base classes in reverse order
		ArrayList<ActorClass> classes = new ArrayList<ActorClass>();
		{
			ActorClass a = ac;
			while (a!=null) {
				classes.add(0, a);
				a = a.getBase();
			}
		}
		
		// build and merge contexts from base classes to derived classes
		obj2ctx.clear();
		StateGraphContext tree = null;
		for (ActorClass cls : classes) {
			if (cls.getStateMachine()!=null) {
				if (tree==null)
					tree = new StateGraphContext(cls.getStateMachine());
				else
					tree.merge(cls.getStateMachine());
			}
		}
		
		tree.obj2pos = new HashMap<EObject, Point>();
		mapPositions(ac.getBase(), ac.eResource().getResourceSet(), tree.obj2pos);
		
		makePositionsAvailableToChildrenContexts(tree);
		
		return tree;
	}
	
	/**
	 * Propagate the position map to all children recursively
	 * 
	 * @param tree
	 */
	private static void makePositionsAvailableToChildrenContexts(StateGraphContext tree) {
		for (StateGraphContext child : tree.getChildren()) {
			child.obj2pos = tree.obj2pos;
			makePositionsAvailableToChildrenContexts(child);
		}
	}

	/**
	 * Load base class diagrams recursively and put midpoint positions relative to boundary rectangle into map
	 * 
	 * @param ac
	 * @param obj2pos
	 */
	private static void mapPositions(ActorClass ac, ResourceSet rs, HashMap<EObject, Point> obj2pos) {
		if (ac==null)
			return;

		Diagram diagram = new DiagramAccess().getDiagram(ac);
		if (diagram==null)
			return;
		
		ILinkService linkService = Graphiti.getLinkService();
		for (Shape sgShape : diagram.getChildren()) {
			// this is the level of StateGraphs
			if (sgShape instanceof ContainerShape) {
				for (Shape sgItemShape : ((ContainerShape)sgShape).getChildren()) {
					// this is the level of States, TrPoints and ChoicePoints
					EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(sgItemShape);
					EObject ownObject = SupportUtil.getOwnObject(obj, rs);
					GraphicsAlgorithm ga = sgItemShape.getGraphicsAlgorithm();
					if (ownObject!=null && ga!=null) {
						Point pos = StylesFactory.eINSTANCE.createPoint();
						pos.setX(ga.getX() + ga.getWidth() /2 - StateGraphSupport.MARGIN);
						pos.setY(ga.getY() + ga.getHeight()/2 - StateGraphSupport.MARGIN);
						obj2pos.put(ownObject, pos);
					}
					if (sgItemShape instanceof ContainerShape) {
						for (Shape trPointShape : ((ContainerShape) sgShape).getChildren()) {
							// this is the level of entry/exit points located on states
							obj = linkService.getBusinessObjectForLinkedPictogramElement(trPointShape);
							ownObject = SupportUtil.getOwnObject(obj, rs);
							ga = trPointShape.getGraphicsAlgorithm();
							if (ownObject!=null && ga!=null) {
								Point pos = StylesFactory.eINSTANCE.createPoint();
								pos.setX(ga.getX() + ga.getWidth() /2 - StateSupport.MARGIN);
								pos.setY(ga.getY() + ga.getHeight()/2 - StateSupport.MARGIN);
								obj2pos.put(ownObject, pos);
							}
						}
					}
				}
			}
		}
		
		// recursion
		mapPositions(ac.getBase(), rs, obj2pos);
	}

	private StateGraphContext(StateGraph sg) {
		this.stateGraph = sg;
		
		init(sg);
	}

	private void init(StateGraph sg) {
		for (State s : sg.getStates()) {
			states.add(s);
			obj2ctx.put(s, this);
		}
		for (ChoicePoint cp : sg.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : sg.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : sg.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}

		// recurse
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				children.add(new StateGraphContext(s.getSubgraph()));
		}
	}

	private void merge(StateGraph derived) {
		stateGraph = derived;
		
		// add derived contents up to refined states
		for (State s : derived.getStates()) {
			if (s instanceof SimpleState) {
				states.add(s);
				obj2ctx.put(s, this);
			}
		}
		for (ChoicePoint cp : derived.getChPoints()) {
			chPoints.add(cp);
			obj2ctx.put(cp, this);
		}
		for (TrPoint tp : derived.getTrPoints()) {
			trPoints.add(tp);
			obj2ctx.put(tp, this);
		}
		for (Transition t : derived.getTransitions()) {
			transitions.add(t);
			obj2ctx.put(t, this);
		}

		// recurse for non-refined states
		for (State s : derived.getStates()) {
			if (s instanceof SimpleState)
				if (s.getSubgraph()!=null)
					children.add(new StateGraphContext(s.getSubgraph()));
		}
		
		// refined states
		for (State refined : derived.getStates()) {
			if (refined instanceof RefinedState) {
				State base = ((RefinedState) refined).getTarget();
				StateGraphContext ctx = obj2ctx.get(base);
				assert(ctx!=null): "should have visited base state already";
				
				// remove base and put refined in place
				ctx.getStates().remove(base);
				ctx.getStates().add(refined);
				obj2ctx.put(refined, this);
				
				// merge sub contexts
				if (RoomHelpers.hasDirectSubStructure(base)) {
					StateGraphContext basesub = null;
					for (StateGraphContext bs : ctx.getChildren()) {
						if (bs.getParentState()==base) {
							basesub = bs;
							break;
						}
					}
					if (basesub!=null) {
						if (RoomHelpers.hasDirectSubStructure(refined)) {
							basesub.merge(refined.getSubgraph());
						}
					}
					else {
						assert(false): "context not found";
					}
				}
				else if (RoomHelpers.hasDirectSubStructure(refined)) {
					StateGraphContext sub = new StateGraphContext(refined.getSubgraph());
					ctx.getChildren().add(sub);
				}
			}
		}
	}

	public State getParentState() {
		if (stateGraph.eContainer() instanceof State)
			return (State) stateGraph.eContainer();
		
		return null;
	}

	public ArrayList<StateGraphContext> getChildren() {
		return children;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public ArrayList<ChoicePoint> getChPoints() {
		return chPoints;
	}

	public StateGraph getStateGraph() {
		return stateGraph;
	}

	public ArrayList<TrPoint> getTrPoints() {
		return trPoints;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return dump("");
	}
	
	/**
	 * @param indent
	 * @return context tree in human readable form
	 */
	private String dump(String indent) {
		StringBuilder result = new StringBuilder();
		result.append(indent+">>> "+getText(stateGraph)+"\n");
		indent += "  ";
		for (State s : states) {
			result.append(indent+getText(s)+"\n");
		}
		
		for (StateGraphContext child : children) {
			result.append(child.dump(indent));
		}
		return result.toString();
	}

	private String getText(StateGraph sg) {
		ActorClass ac = getActorClass(sg);
		EObject parent = sg.eContainer();
		String item = parent instanceof ActorClass? "diagram" : (parent.eClass().getName()+" "+((State)parent).getName());
		return "state graph of "+item+" of "+(ac==null? "?":ac.getName());
	}

	private String getText(StateGraphItem item) {
		ActorClass ac = getActorClass(item);
		return item.eClass().getName()+" "+item.getName()+" of "+(ac==null? "?":ac.getName());
	}

	private ActorClass getActorClass(EObject obj) {
		EObject parent = obj.eContainer();
		while (parent!=null) {
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
			parent = parent.eContainer();
		}
		return null;
	}
}
