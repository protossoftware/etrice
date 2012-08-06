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

package org.eclipse.etrice.ui.layout;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabeledGraphElement;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.config.VolatileLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.GefDiagramLayoutManager;
import de.cau.cs.kieler.kiml.graphiti.GraphitiLayoutCommand;
import de.cau.cs.kieler.kiml.graphiti.GraphitiLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.KimlGraphitiUtil;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.impl.KShapeLayoutImpl;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * The abstract class to support the creation of eTrice
 * {@link BehaviorDiagramLayoutManager } and
 * {@link StructureDiagramLayoutManager}
 * 
 * @author jayant
 */
@SuppressWarnings("restriction")
public abstract class ETriceDiagramLayoutManager extends
		GefDiagramLayoutManager<PictogramElement> {

	/**
	 * {@inheritDoc}
	 */
	public abstract boolean supports(Object object);

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getAdapter(final Object object, final Class adapterType) {
		if (adapterType.isAssignableFrom(GraphitiLayoutConfig.class)) {
			return layoutConfig;
		} else if (adapterType
				.isAssignableFrom(IPictogramElementEditPart.class)) {
			if (object instanceof IPictogramElementEditPart) {
				return object;
			} else if (object instanceof DiagramEditor) {
				return ((DiagramEditor) object).getGraphicalViewer()
						.getContents();
			}
		} else if (adapterType.isAssignableFrom(EObject.class)) {
			if (object instanceof IPictogramElementEditPart) {
				PictogramElement pe = ((IPictogramElementEditPart) object)
						.getPictogramElement();
				if (pe.getLink() != null) {
					List<EObject> businessObjects = pe.getLink()
							.getBusinessObjects();
					if (!businessObjects.isEmpty()) {
						return businessObjects.get(0);
					}
				}
			} else if (object instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) object;
				if (pe.getLink() != null) {
					List<EObject> businessObjects = pe.getLink()
							.getBusinessObjects();
					if (!businessObjects.isEmpty()) {
						return businessObjects.get(0);
					}
				}
			}
		} else if (adapterType.isAssignableFrom(PictogramElement.class)) {
			if (object instanceof PictogramElement) {
				return object;
			} else if (object instanceof IPictogramElementEditPart) {
				return ((IPictogramElementEditPart) object)
						.getPictogramElement();
			} else if (object instanceof DiagramEditor) {
				EditPart contents = ((DiagramEditor) object)
						.getGraphicalViewer().getContents();
				if (contents instanceof IPictogramElementEditPart) {
					return ((IPictogramElementEditPart) contents)
							.getPictogramElement();
				}
			}
		} else if (adapterType
				.isAssignableFrom(TransactionalEditingDomain.class)) {
			if (object instanceof DiagramEditor) {
				return ((DiagramEditor) object).getEditingDomain();
			} else if (object instanceof IPictogramElementEditPart) {
				return ((IPictogramElementEditPart) object)
						.getConfigurationProvider().getDiagramEditor()
						.getEditingDomain();
			}
		}
		if (object instanceof IAdaptable) {
			return ((IAdaptable) object).getAdapter(adapterType);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?>[] getAdapterList() {
		return new Class<?>[] { PictogramElement.class };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */

	@Override
	protected void transferLayout(final LayoutMapping<PictogramElement> mapping) {
		DiagramEditor diagramEditor = mapping
				.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR);

		ETriceLayoutCommand command = null;

		if (diagramEditor instanceof BehaviorEditor) {
			command = new BehaviorLayoutCommand(
					diagramEditor.getEditingDomain(), diagramEditor
							.getDiagramTypeProvider().getFeatureProvider());
		} else {
			command = new StructureLayoutCommand(
					diagramEditor.getEditingDomain(), diagramEditor
							.getDiagramTypeProvider().getFeatureProvider());
		}

		for (Entry<KGraphElement, PictogramElement> entry : mapping
				.getGraphMap().entrySet()) {
			command.add(entry.getKey(), entry.getValue());
		}
		mapping.setProperty(KimlGraphitiUtil.LAYOUT_COMMAND, command);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void applyLayout(final LayoutMapping<PictogramElement> mapping) {
		TransactionalEditingDomain editingDomain = mapping.getProperty(
				KimlGraphitiUtil.DIAGRAM_EDITOR).getEditingDomain();
		editingDomain.getCommandStack().execute(
				mapping.getProperty(KimlGraphitiUtil.LAYOUT_COMMAND));
	}

	/** the cached layout configuration for Graphiti. */
	private GraphitiLayoutConfig layoutConfig = new GraphitiLayoutConfig();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LayoutMapping<PictogramElement> buildLayoutGraph(
			final IWorkbenchPart workbenchPart, final Object diagramPart) {
		LayoutMapping<PictogramElement> mapping = new LayoutMapping<PictogramElement>(
				this);
		mapping.setProperty(KimlGraphitiUtil.CONNECTIONS,
				new LinkedList<Connection>());
		mapping.setProperty(KimlGraphitiUtil.STATIC_CONFIG,
				new VolatileLayoutConfig());

		if (workbenchPart instanceof RoomDiagramEditor) {
			mapping.setProperty(KimlGraphitiUtil.DIAGRAM_EDITOR,
					(RoomDiagramEditor) workbenchPart);
		}

		EditPart layoutRootPart = null;
		if (diagramPart instanceof IPictogramElementEditPart) {
			layoutRootPart = (EditPart) diagramPart;
		} else if (mapping.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR) != null) {
			layoutRootPart = mapping
					.getProperty(KimlGraphitiUtil.DIAGRAM_EDITOR)
					.getGraphicalViewer().getContents();
		}
		if (!(layoutRootPart instanceof IPictogramElementEditPart)) {
			throw new UnsupportedOperationException(
					"Not supported by this layout manager: Workbench part "
							+ workbenchPart + ", Edit part " + diagramPart);
		}
		PictogramElement element = ((IPictogramElementEditPart) layoutRootPart)
				.getPictogramElement();
		mapping.setParentElement(element);

		if (element instanceof Diagram) {

			KNode diagramNode = KimlUtil.createInitializedNode();
			KShapeLayout shapeLayout = diagramNode.getData(KShapeLayout.class);
			GraphicsAlgorithm ga = element.getGraphicsAlgorithm();
			shapeLayout.setPos(ga.getX(), ga.getY());
			shapeLayout.setSize(ga.getWidth(), ga.getHeight());
			mapping.getGraphMap().put(diagramNode, element);

			VolatileLayoutConfig staticConfig = mapping
					.getProperty(KimlGraphitiUtil.STATIC_CONFIG);

			if (workbenchPart instanceof BehaviorEditor)
				staticConfig.setValue(LayoutOptions.DIAGRAM_TYPE, diagramNode,
						LayoutContext.GRAPH_ELEM,
						ETriceSemanticLayoutConfig.BEHAVIOR_DIAGRAM_TYPE);

			// Node creation for currently visible top-level Container
			// Shape(Bounding Box) in
			// eTrice Diagrams
			buildLayoutGraphForBoundingBox(mapping, (Diagram) element,
					diagramNode, true);

			mapping.setLayoutGraph(diagramNode);

		} else if (element instanceof Shape) {

			if (isTopLevelBoundingBox((Shape) element)) {
				// The selected Element is the Top Level Top Level Bounding Box
				mapping.setLayoutGraph((KNode) buildAllLevels(mapping,
						(Shape) element, null));
			} else {

				KGraphElement internalKGraphElement = createKGaphElementFromShape(
						mapping, null, (Shape) element);

				if (internalKGraphElement instanceof KNode
						&& !isInternalPort((Shape) element)) {
					// The selected Element is a Node.
					for (Shape childShape : ((ContainerShape) element)
							.getChildren()) {

						createKGaphElementFromShape(mapping,
								internalKGraphElement, childShape);
					}

					mapping.setLayoutGraph((KNode) internalKGraphElement);

				} else {
					// The selected Element is a Port(Boundary or Internal) or
					// an Edge Label.
					// It is an illegal argument for layout
					throw new IllegalArgumentException(
							"The seleted element cannot be lay-outed separately");

				}

			}
		} else if (element instanceof FreeFormConnection) {
			// The selected element is an edge.
			// It is an illegal argument for layout
			throw new IllegalArgumentException(
					"A connection cannot be layouted separately");
		}

		for (Connection entry : mapping
				.getProperty(KimlGraphitiUtil.CONNECTIONS)) {
			KimlGraphitiUtil.createEdge(mapping, entry);
		}

		// create a layout configuration
		mapping.getLayoutConfigs().add(
				mapping.getProperty(KimlGraphitiUtil.STATIC_CONFIG));
		mapping.getLayoutConfigs().add(layoutConfig);

		return mapping;
	}

	/**
	 * Identifies the visible Bounding Box (Top Level Container) and delegates
	 * the control to {@link #buildAllLevels(LayoutMapping, Shape, KNode)}
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param diagram
	 *            The Diagram Containing the Bounding Box
	 * @param diagramNode
	 *            The Node for the diagram
	 * @param onlyVisible
	 *            If true, only the visible bounding box will be lay-outed.
	 *            Otherwise, all bounding boxes in current Diagram are
	 *            lay-outed.
	 * 
	 * @author jayant
	 */
	protected abstract void buildLayoutGraphForBoundingBox(
			final LayoutMapping<PictogramElement> mapping,
			final Diagram diagram, final KNode diagramNode,
			final boolean onlyVisible);

	/**
	 * Develops the complete LayoutGraph for the eTrice Diagram starting from
	 * the Bounding Box.
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param topLevelBoundingBox
	 *            The Top Level Container Shape containing all other shapes
	 * @param diagramNode
	 *            The KNode corresponding to the Diagram
	 * 
	 * @author jayant
	 */
	/* This is fairly general for both the eTrice editors */
	protected KNode buildAllLevels(LayoutMapping<PictogramElement> mapping,
			Shape topLevelBoundingBox, KNode diagramNode) {
		// Top Level
		KNode topLevelBoundingBoxNode = createNode(mapping, diagramNode,
				topLevelBoundingBox);

		for (Shape secondtLevelShape : ((ContainerShape) topLevelBoundingBox)
				.getChildren()) {
			// Second Level
			KGraphElement secondLevelKGraphElement = createKGaphElementFromShape(
					mapping, topLevelBoundingBoxNode, secondtLevelShape);

			if (secondLevelKGraphElement instanceof KNode) {
				for (Shape thirdLevelShape : ((ContainerShape) secondtLevelShape)
						.getChildren()) {
					// Third Level
					createKGaphElementFromShape(mapping,
							secondLevelKGraphElement, thirdLevelShape);
				}

				if (!isInternalPort(secondtLevelShape)) {
					// For KNodes which are not internal ports.
					setNodeLayoutOptions(mapping,
							(KNode) secondLevelKGraphElement, secondtLevelShape);
				}

			}
		}

		setNodeLayoutOptions(mapping, topLevelBoundingBoxNode,
				topLevelBoundingBox);

		return topLevelBoundingBoxNode;
	}

	/**
	 * Identifies the type of Shape (Label, Port or Node) and creates the
	 * corresponding KGraphElement Element
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param parent
	 *            the parent KNode
	 * @param shape
	 *            the shape for which a KGraphElement is required
	 * 
	 * @return the created KGraphElement for the given Shape
	 * 
	 * @author jayant
	 */
	/* This is fairly general for both the eTrice editors */
	private KGraphElement createKGaphElementFromShape(
			LayoutMapping<PictogramElement> mapping, KGraphElement parent,
			Shape shape) {

		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Checking whether this shape is a label
		if (ga instanceof AbstractText) {

			KInsets parentInsets = parent.getData(KShapeLayout.class)
					.getProperty(GraphitiLayoutCommand.INVIS_INSETS);

			assert (parentInsets != null) : "There must be an invisible insets attached to all ports and nodes(except diagramNode)";
			return KimlGraphitiUtil.createLabel((KLabeledGraphElement) parent,
					(AbstractText) ga, -parentInsets.getLeft(),
					-parentInsets.getTop());
		}

		else if (shape instanceof ContainerShape) {

			// Checking whether this shape is a boundary port
			if (isBoundaryPort(shape))
				return createPort(mapping, (KNode) parent, shape);

			else
				// This shape is considered to be a node (includes internal
				// Ports)
				return createNode(mapping, (KNode) parent, shape);

		} else
			return null;
	}

	/**
	 * Create a node for the layout graph.
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param parentNode
	 *            the parent node
	 * @param shape
	 *            the shape for a new node
	 * @return a new layout node
	 */
	protected abstract KNode createNode(
			final LayoutMapping<PictogramElement> mapping,
			final KNode parentNode, final Shape shape);

	/**
	 * Create a port for the layout graph.
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param parentNode
	 *            the parent node
	 * @param shape
	 *            the shape for a new port
	 * @return a new layout node
	 * 
	 * @author jayant
	 */
	/* This is fairly general for both the eTrice editors */
	protected KPort createPort(final LayoutMapping<PictogramElement> mapping,
			final KNode parentNode, final Shape shape) {
		KPort port = KimlUtil.createInitializedPort();
		port.setNode(parentNode);

		setCurrentPositionAndSize(mapping, parentNode, port, shape);

		mapping.getGraphMap().put(port, shape.getAnchors().get(0));

		// Set Port label
		Shape portLabelShape = ((ContainerShape) shape).getChildren().get(0);
		createKGaphElementFromShape(mapping, port, portLabelShape);

		// gather all connections connected to the parentNode via this port
		for (Anchor anchor : shape.getAnchors()) {
			mapping.getProperty(KimlGraphitiUtil.CONNECTIONS).addAll(
					anchor.getOutgoingConnections());
		}

		return port;
	}

	/**
	 * Sets the insets(border) and calculates the position and size of the
	 * KgraphElement.
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param parentNode
	 *            the parent node
	 * @param kelem
	 *            the kGraphElement whose size and position is to be determined
	 * @param shape
	 *            the corresponding shape
	 * 
	 * @author jayant
	 */
	/*
	 * This is fairly general for both the eTrice editors and same for Nodes and
	 * Ports
	 */
	protected void setCurrentPositionAndSize(
			final LayoutMapping<PictogramElement> mapping,
			final KNode parentNode, final KGraphElement kelem, final Shape shape) {

		VolatileLayoutConfig staticConfig = mapping
				.getProperty(KimlGraphitiUtil.STATIC_CONFIG);

		KShapeLayout shapeLayout = kelem.getData(KShapeLayout.class);
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Calculate and set the invisible insets
		KInsets shapeInsets = KimlGraphitiUtil.calcInsets(ga);
		shapeLayout
				.setProperty(GraphitiLayoutCommand.INVIS_INSETS, shapeInsets);
		staticConfig.setValue(GraphitiLayoutCommand.INVIS_INSETS, kelem,
				LayoutContext.GRAPH_ELEM, shapeInsets);

		// Get the parent insets
		KInsets parentInsets = parentNode == null ? null : parentNode.getData(
				KShapeLayout.class).getProperty(
				GraphitiLayoutCommand.INVIS_INSETS);

		// Set Position
		if (parentInsets == null) {
			shapeLayout.setPos(ga.getX() + shapeInsets.getLeft(), ga.getY()
					+ shapeInsets.getTop());
		} else {
			shapeLayout.setPos(
					ga.getX() + shapeInsets.getLeft() - parentInsets.getLeft(),
					ga.getY() + shapeInsets.getTop() - parentInsets.getTop());
		}

		// Set Size
		shapeLayout
				.setSize(
						ga.getWidth() - shapeInsets.getLeft()
								- shapeInsets.getRight(),
						ga.getHeight() - shapeInsets.getTop()
								- shapeInsets.getBottom());

		// the modification flag must initially be false
		((KShapeLayoutImpl) shapeLayout).resetModificationFlag();

	}

	/**
	 * Sets the heuristic layout options for nodes (like minimal width and
	 * minimal height)
	 * 
	 * @param mapping
	 *            the mapping of pictogram elements to graph elements
	 * @param node
	 *            the node for which layout options need to be set
	 * @param shape
	 *            the corresponding shape
	 * @author jayant
	 */
	/* This is fairly general for both the eTrice editors */
	protected void setNodeLayoutOptions(
			final LayoutMapping<PictogramElement> mapping, final KNode node,
			Shape shape) {

		// get label width and height for the node
		float labelWidth = 0.0f;
		float labelHeight = 0.0f;

		if (!node.getLabels().isEmpty()) {
			KShapeLayout labelLayout = node.getLabels().get(0)
					.getData(KShapeLayout.class);
			labelWidth = labelLayout.getWidth();
			labelHeight = labelLayout.getHeight();
		}

		VolatileLayoutConfig staticConfig = mapping
				.getProperty(KimlGraphitiUtil.STATIC_CONFIG);

		Dimension defaultSize = getDefaultSize(shape);
		staticConfig.setValue(LayoutOptions.MIN_WIDTH, node,
				LayoutContext.GRAPH_ELEM, defaultSize.width() + labelWidth);
		staticConfig.setValue(LayoutOptions.MIN_HEIGHT, node,
				LayoutContext.GRAPH_ELEM, defaultSize.height() + labelHeight);
	}

	/**
	 * Determines whether the given shape is a boundary port or not.
	 * 
	 * @param shape
	 *            the shape to be investigated
	 * @return true if the {@code shape} is a port else false
	 * 
	 * @author jayant
	 */
	public abstract boolean isBoundaryPort(Shape shape);

	/**
	 * Determines whether the given shape is an internal port or not.
	 * 
	 * @param shape
	 *            the shape to be investigated
	 * @return true if the {@code shape} is a port else false
	 * 
	 * @author jayant
	 */
	public abstract boolean isInternalPort(Shape shape);

	/**
	 * Determines whether the given shape is a Top Level Bounding Box or not.
	 * 
	 * @param shape
	 *            the shape to be investigated
	 * 
	 * @return true if the {@code shape} is the Top Level Bounding Box
	 * 
	 * @author jayant
	 */
	public abstract boolean isTopLevelBoundingBox(Shape shape);

	/**
	 * Gets the Default Minimal Size for a node
	 * 
	 * @param shape
	 *            The shape attached to the node
	 * 
	 * @return the defaults minimal size for a node
	 * 
	 * @author jayant
	 */
	protected abstract Dimension getDefaultSize(Shape shape);

}
