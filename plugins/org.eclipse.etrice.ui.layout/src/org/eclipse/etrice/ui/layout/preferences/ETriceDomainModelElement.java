/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.ui.layout.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.TreeNode;

import de.cau.cs.kieler.core.util.Pair;

/**
 * A class to represent Domain Model Elements(classes of eTrice). The class
 * extends {@code TreeNode} which helps in :
 * <ul>
 * <li>Representing the class hierarchy
 * <li>Making it a valid object to be passes to {@code TreeNodeContentProvider},
 * thus eliminates the need of a custom Content Provider.
 * </ul>
 * 
 * @author jayant
 * 
 */
public class ETriceDomainModelElement extends TreeNode {

	/**
	 * Constructs a new instance of {@code ETriceDomainModelElement} with the
	 * given id and no children.
	 * 
	 * @param id
	 *            The String which represents the Fully Qualified Domain Name of
	 *            the Class
	 * 
	 * @author jayant
	 */
	public ETriceDomainModelElement(String id) {
		super(id.substring(id.lastIndexOf('.') + 1));
		this.id = id;
	}

	/**
	 * Constructs a new instance of {@code ETriceDomainModelElement} with given
	 * id and array of children
	 * 
	 * @param id
	 *            The String which represents the Fully Qualified Domain Name of
	 *            the Class
	 * @param children
	 *            The array of children fo this element(node)
	 * 
	 * @author jayant
	 */
	public ETriceDomainModelElement(String id,
			ETriceDomainModelElement[] children) {
		super(id.substring(id.lastIndexOf('.') + 1));
		this.id = id;
		setChildren(children);
	}

	/**
	 * The id of the Domain Model Class. This is a string which is the Fully
	 * Qualified Domain Name of the class.
	 */
	private String id;

	/**
	 * The public instance of {@code ETriceDomainModelElement} which encompasses
	 * the complete class hierarchy of configurable Structure diagram elements
	 */
	public static final ETriceDomainModelElement STRUCTURE_MODEL = new ETriceDomainModelElement(
			"StructureRoot",
			new ETriceDomainModelElement[] {
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.ActorContainerRef",
							new ETriceDomainModelElement[] {
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.ActorRef"),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.SubSystemRef") }),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.InterfaceItem",
							new ETriceDomainModelElement[] {
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.Port"),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.SAPRef"),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.SPPRef") }),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.StructureClass",
							new ETriceDomainModelElement[] {
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.ActorContainerClass",
											new ETriceDomainModelElement[] {
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.ActorClass"),
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.SubSystemClass") }),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.LogicalSystem") }),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.SAPoint",
							new ETriceDomainModelElement[] {
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.RefSAPoint"),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.RelaySAPoint") }),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.SPPoint"),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.Binding") });

	/**
	 * The public instance of {@code ETriceDomainModelElement} which encompasses
	 * the complete class hierarchy of configurable Behavior diagram elements
	 */
	public static final ETriceDomainModelElement BEHAVIOR_MODEL = new ETriceDomainModelElement(
			"BehaviorRoot",
			new ETriceDomainModelElement[] {
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.StateGraph"),
					new ETriceDomainModelElement(
							"org.eclipse.etrice.core.room.StateGraphItem",
							new ETriceDomainModelElement[] {
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.StateGraphNode",
											new ETriceDomainModelElement[] {
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.ChoicePoint"),
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.State",
															new ETriceDomainModelElement[] {
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.RefinedState"),
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.SimpleState") }),
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.TrPoint",
															new ETriceDomainModelElement[] {
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.EntryPoint"),
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.ExitPoint"),
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.TransitionPoint") }) }),
									new ETriceDomainModelElement(
											"org.eclipse.etrice.core.room.Transition",
											new ETriceDomainModelElement[] {
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.InitialTransition"),
													new ETriceDomainModelElement(
															"org.eclipse.etrice.core.room.NonInitialTransition",
															new ETriceDomainModelElement[] {
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.ContinuationTransition"),
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.CPBranchTransition"),
																	new ETriceDomainModelElement(
																			"org.eclipse.etrice.core.room.TransitionChainStartTransition",
																			new ETriceDomainModelElement[] {
																					new ETriceDomainModelElement(
																							"org.eclipse.etrice.core.room.GuardedTransition"),
																					new ETriceDomainModelElement(
																							"org.eclipse.etrice.core.room.TriggeredTransition") }) }) }) }), });

	/**
	 * public list of {@code Pair<String, <String>>} enumerating all diagram
	 * types relevant for Structure Diagrams
	 */
	@SuppressWarnings("unchecked")
	public static final List<Pair<String, String>> STRUCTURE_DIAGRAM_TYPES = new ArrayList<Pair<String, String>>(
			Arrays.asList(
					new Pair<String, String>(
							"de.cau.cs.kieler.layout.diagrams.gereral",
							"General"),
					new Pair<String, String>(
							"org.eclipse.etrice.ui.layout.eTriceStructureDiagram",
							"eTrice Structure Diagram")));

	/**
	 * public list of {@code Pair<String, <String>>} enumerating all diagram
	 * types relevant for Behavior Diagrams
	 */
	@SuppressWarnings("unchecked")
	public static final List<Pair<String, String>> BEHAVIOR_DIAGRAM_TYPES = new ArrayList<Pair<String, String>>(
			Arrays.asList(
					new Pair<String, String>(
							"de.cau.cs.kieler.layout.diagrams.gereral",
							"General"),
					new Pair<String, String>(
							"org.eclipse.etrice.ui.layout.eTriceBehaviorDiagram",
							"eTrice Behavior Diagram")));

	/**
	 * Finds whether the given id belongs to a particular domain model class
	 * (for behavior diagram elements)
	 * 
	 * @param id
	 *            The id to be checked (found)
	 * @return true, if there is a class in behavior model hierarchy with same
	 *         id, otherwise false
	 */
	public static boolean isBehaviorModelElement(String id) {
		return (BEHAVIOR_MODEL.traverseModel(id));
	}

	/**
	 * Finds whether the given id belongs to a particular domain model class
	 * (for structure diagram elements)
	 * 
	 * @param id
	 *            The id to be found
	 * @return true, if there is a class in structure model hierarchy with same
	 *         id, otherwise false
	 */
	public static boolean isStructureModelElement(String id) {
		return (STRUCTURE_MODEL.traverseModel(id));
	}

	/**
	 * Traverses the n-ary tree recursively from the invoking node and try to
	 * find the given id.
	 * 
	 * @param findId
	 *            The id to be found
	 * @return true, if id matches with any node of the tree (with root as the
	 *         invoking node), otherwise false
	 */
	public boolean traverseModel(final String findId) {

		if (Util.equals(this.id, findId)) {
			return true;
		} else {
			TreeNode[] children = getChildren();
			if (children != null) {
				for (TreeNode child : children) {
					if (((ETriceDomainModelElement) child)
							.traverseModel(findId))
						return true;
				}
			}

			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean equals(final Object object) {
		if (object instanceof ETriceDomainModelElement) {
			return Util.equals(this.id, ((ETriceDomainModelElement) object).id);
		}

		return false;
	}

	/**
	 * Getter for id
	 * 
	 * @return the id
	 * 
	 * @author jayant
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for id
	 * 
	 * @param id
	 *            the id to set
	 * 
	 * @author jayant
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Useful for using this class with default {@code LabelProvider}
	 * 
	 * @author jayant
	 */
	@Override
	public String toString() {
		return ((String) value + " (" + id + ")");
	}

}
