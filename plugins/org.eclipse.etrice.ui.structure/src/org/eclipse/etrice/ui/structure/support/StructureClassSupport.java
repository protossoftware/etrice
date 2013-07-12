/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.common.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class StructureClassSupport {
	
	public static final int MARGIN = 40;
	
	private static final int LINE_WIDTH = 4;
	public static final int DEFAULT_SIZE_X = 600;
	public static final int DEFAULT_SIZE_Y = 400;
	private static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	private static final IColorConstant BACKGROUND = new ColorConstant(255, 255, 255);

	private class FeatureProvider extends DefaultFeatureProvider {
	
		private class AddFeature extends AbstractAddFeature {
	
			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canAdd(IAddContext context) {
				if (context.getNewObject() instanceof StructureClass) {
					if (context.getTargetContainer() instanceof Diagram) {
						return true;
					}
				}
				return false;
			}
	
			@Override
			public PictogramElement add(IAddContext context) {
				StructureClass ac = (StructureClass) context.getNewObject();
				Diagram diag = (Diagram) context.getTargetContainer();
	
				// CONTAINER SHAPE WITH RECTANGLE
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				ContainerShape containerShape =
					peCreateService.createContainerShape(diag, true);
				
				Graphiti.getPeService().setPropertyValue(containerShape, Constants.TYPE_KEY, Constants.CLS_TYPE);

				// check whether the context has a size (e.g. from a create feature)
				// otherwise define a default size for the shape
				int width = context.getWidth() <= 0 ? DEFAULT_SIZE_X : context.getWidth();
				int height = context.getHeight() <= 0 ? DEFAULT_SIZE_Y : context.getHeight();
	
				{
					IGaService gaService = Graphiti.getGaService();

					// create invisible outer rectangle expanded by
					// the width needed for the ports
					Rectangle invisibleRectangle =
						gaService.createInvisibleRectangle(containerShape);
	
					gaService.setLocationAndSize(invisibleRectangle,
							context.getX(), context.getY(), width + 2*MARGIN, height + 2*MARGIN);
	
					// create and set visible rectangle inside invisible rectangle
					// transparent first
					Rectangle rect = gaService.createRectangle(invisibleRectangle);
					rect.setForeground(manageColor(LINE_COLOR));
					rect.setBackground(manageColor(BACKGROUND));
					rect.setTransparency(0.5);
					rect.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(rect, MARGIN, MARGIN, width, height);
					// then unfilled opaque
					rect = gaService.createRectangle(invisibleRectangle);
					rect.setForeground(manageColor(LINE_COLOR));
					rect.setFilled(false);
					rect.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(rect, MARGIN, MARGIN, width, height);
	
					// create link and wire it
					link(containerShape, ac);
					link(getDiagram(), ac);
				}
	
				// call the layout feature
				layoutPictogramElement(containerShape);
	
				return containerShape;
	
			}
	
		}
	
		private class LayoutFeature extends AbstractLayoutFeature {
	
			private static final int MIN_HEIGHT = 100;
			private static final int MIN_WIDTH = 250;
	
			public LayoutFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canLayout(ILayoutContext context) {
				// return true, if pictogram element is linked to an ActorClass
				PictogramElement pe = context.getPictogramElement();
				if (!(pe instanceof ContainerShape))
					return false;
	
				EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
				return businessObjects.size() == 1
						&& businessObjects.get(0) instanceof StructureClass;
			}
	
			@Override
			public boolean layout(ILayoutContext context) {
				boolean anythingChanged = false;
				ContainerShape containerShape = (ContainerShape) context
						.getPictogramElement();
	
				GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
	
				// height
				if (containerGa.getHeight() < MIN_HEIGHT) {
					containerGa.setHeight(MIN_HEIGHT);
					anythingChanged = true;
				}
	
				// width
				if (containerGa.getWidth() < MIN_WIDTH) {
					containerGa.setWidth(MIN_WIDTH);
					anythingChanged = true;
				}
	
				int w = containerGa.getWidth();
				int h = containerGa.getHeight();
	
				if (containerGa.getGraphicsAlgorithmChildren().size()==2) {
					GraphicsAlgorithm ga = containerGa.getGraphicsAlgorithmChildren().get(0);
					ga.setWidth(w-2*MARGIN);
					ga.setHeight(h-2*MARGIN);
					ga = containerGa.getGraphicsAlgorithmChildren().get(1);
					ga.setWidth(w-2*MARGIN);
					ga.setHeight(h-2*MARGIN);
					anythingChanged = true;
				}
	
				return anythingChanged;
			}
	
		}
		
		private class UpdateFeature extends AbstractUpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public boolean canUpdate(IUpdateContext context) {
				if (context.getPictogramElement() instanceof Diagram)
					return false;
				
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy())
					return true;
				
				return bo instanceof StructureClass;
			}

			@Override
			public IReason updateNeeded(IUpdateContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy()) {
					return Reason.createTrueReason("Structure class deleted from model");
				}
				
				StructureClass sc = (StructureClass) bo;
				ContainerShape shape = (ContainerShape) context.getPictogramElement();
				
				String reason = "";
				int missing = 0;
				
				// check for interface items added in model not present in diagram (including inherited)
				{
					List<InterfaceItem> expectedItems = RoomHelpers.getInterfaceItems(sc, true);
					List<InterfaceItem> presentItems = SupportUtil.getInterfaceItems(shape, fp);
					for (InterfaceItem interfaceItem : expectedItems) {
						if (!presentItems.contains(interfaceItem))
							++missing;
					}
					if (missing>0)
						reason += missing+" missing interface items\n";
				}
				
				// check for refs added in model not present in diagram (including inherited)
				{
					missing = 0;
					List<ActorContainerRef> expectedRefs = RoomHelpers.getRefs(sc, true);
					List<ActorContainerRef> presentRefs = SupportUtil.getRefs(shape, fp);
					for (ActorContainerRef actorContainerRef : expectedRefs) {
						if (!presentRefs.contains(actorContainerRef))
							++missing;
					}
					if (missing>0)
						reason += missing+" missing refs\n";
				}

				// check for bindings added in model not present in diagram (including inherited)
				{
					missing = 0;
					List<Binding> expectedBindings = RoomHelpers.getBindings(sc, true);
					List<Binding> presentBindings = SupportUtil.getBindings(getDiagram(), fp);
					for (Binding binding : expectedBindings) {
						if (!presentBindings.contains(binding))
							++missing;
					}
					if (missing>0)
						reason += missing+" missing bindings\n";
				}

				// check for layer connections added in model not present in diagram (including inherited)
				{
					missing = 0;
					List<LayerConnection> expectedBindings = RoomHelpers.getConnections(sc, true);
					List<LayerConnection> presentBindings = SupportUtil.getConnections(getDiagram(), fp);
					for (LayerConnection binding : expectedBindings) {
						if (!presentBindings.contains(binding))
							++missing;
					}
					if (missing>0)
						reason += missing+" missing layer connections\n";
				}
				
				if (!reason.isEmpty())
					return Reason.createTrueReason(reason.substring(0, reason.length()-1));
				
				return Reason.createFalseReason();
			}

			@Override
			public boolean update(IUpdateContext context) {
				ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
				if (containerShape instanceof Diagram)
					containerShape = (ContainerShape) containerShape.getChildren().get(0);
				Object bo = getBusinessObjectForPictogramElement(containerShape);
				if (bo instanceof EObject && ((EObject)bo).eIsProxy()) {
					IRemoveContext rc = new RemoveContext(containerShape);
					IFeatureProvider featureProvider = getFeatureProvider();
					IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
					if (removeFeature != null) {
						removeFeature.remove(rc);
					}
					EcoreUtil.delete((EObject) bo);
					return true;
				}

				StructureClass sc = (StructureClass) bo;
				addMissingItems(sc, containerShape, fp);
				
				return true;
			}
		}
		
		private class OpenBehaviorDiagram extends AbstractCustomFeature {

			public OpenBehaviorDiagram(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Open Class Behavior";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorClass) {
						return true;
					}
				}
				return false;
			}

			/* (non-Javadoc)
			 * @see org.eclipse.graphiti.features.custom.ICustomFeature#execute(org.eclipse.graphiti.features.context.ICustomContext)
			 */
			@Override
			public void execute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorClass) {
						org.eclipse.etrice.ui.behavior.DiagramAccess diagramAccess = new org.eclipse.etrice.ui.behavior.DiagramAccess();
						diagramAccess.openDiagramEditor((ActorClass)bo);
					}
				}
			}
			
			@Override
			public boolean hasDoneChanges() {
				return false;
			}
		}
		
		private class ResizeFeature extends DefaultResizeShapeFeature {

			public ResizeFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canResizeShape(IResizeShapeContext context) {
				if (!super.canResizeShape(context))
					return false;

				int width = context.getWidth()-MARGIN;
				int height = context.getHeight()-MARGIN;
				int xmax = 0;
				int ymax = 0;
				ContainerShape containerShape = (ContainerShape)context.getShape();
				StructureClass sc = (StructureClass) getBusinessObjectForPictogramElement(containerShape);
				for (Shape childShape : containerShape.getChildren()) {
					if (isOnInterface(sc, getBusinessObjectForPictogramElement(childShape)))
						continue;
					
					GraphicsAlgorithm ga = childShape.getGraphicsAlgorithm();
					int x = ga.getX()+ga.getWidth()-ActorContainerRefSupport.MARGIN;
					int y = ga.getY()+ga.getHeight()-ActorContainerRefSupport.MARGIN;
					if (x>xmax)
						xmax = x;
					if (y>ymax)
						ymax = y;
				}
				if (width>0 && width<xmax)
					return false;
				if (height>0 && height<ymax)
					return false;
				
				return true;
			}
			
			@Override
			public void resizeShape(IResizeShapeContext context) {
				ContainerShape containerShape = (ContainerShape) context.getShape();
				StructureClass sc = (StructureClass) getBusinessObjectForPictogramElement(containerShape);
				
				if (containerShape.getGraphicsAlgorithm()!=null) {
					GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
					if (containerGa.getGraphicsAlgorithmChildren().size()==2) {
						// scale interface item coordinates
						// we refer to the visible rectangle which defines the border of our structure class
						// since the margin is not scaled
						GraphicsAlgorithm ga = containerGa.getGraphicsAlgorithmChildren().get(0);
						double sx = (context.getWidth()-2*MARGIN)/(double)ga.getWidth();
						double sy = (context.getHeight()-2*MARGIN)/(double)ga.getHeight();
						
						for (Shape childShape : containerShape.getChildren()) {
							if (isOnInterface(sc, getBusinessObjectForPictogramElement(childShape))) {
								ga = childShape.getGraphicsAlgorithm();
								ga.setX((int) (ga.getX()*sx));
								ga.setY((int) (ga.getY()*sy));
							}
						}
					}
				}
				super.resizeShape(context);
			}

			private boolean isOnInterface(StructureClass sc, Object childBo) {
				boolean onInterface = false;
				if (childBo instanceof InterfaceItem) {
					// in general InterfaceItem sit on the interface...
					onInterface = true;
					
					// ...with the exception of internal end ports
					if (childBo instanceof Port) {
						if (sc instanceof ActorClass) {
							if (((ActorClass) sc).getIntPorts().contains(childBo))
								onInterface = false;
						}
					}
				}
				return onInterface;
			}
		}
		
		private class RemoveFeature extends DefaultRemoveFeature {

			public RemoveFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canRemove(IRemoveContext context) {
				return false;
			}
		}
		
		private class DeleteFeature extends DeleteWithoutConfirmFeature {

			public DeleteFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canDelete(IDeleteContext context) {
				return false;
			}
		}
		
		private IFeatureProvider fp;
	
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp);
			this.fp = fp;
		}
		
		@Override
		public IAddFeature getAddFeature(IAddContext context) {
			return new AddFeature(fp);
		}
		
		@Override
		public ILayoutFeature getLayoutFeature(ILayoutContext context) {
			return new LayoutFeature(fp);
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			return new UpdateFeature(fp);
		}
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] {
					new OpenBehaviorDiagram(fp)};
		}
		
		@Override
		public IResizeShapeFeature getResizeShapeFeature(
				IResizeShapeContext context) {
			return new ResizeFeature(fp);
		}
		
		@Override
		public IRemoveFeature getRemoveFeature(IRemoveContext context) {
			return new RemoveFeature(fp);
		}
		
		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			return new DeleteFeature(fp);
		}
	}

	private class BehaviorProvider extends DefaultToolBehaviorProvider {

		public BehaviorProvider(IDiagramTypeProvider dtp) {
			super(dtp);
		}
		
		@Override
		public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
            GraphicsAlgorithm rectangle =
                            invisible.getGraphicsAlgorithmChildren().get(0);
            return new GraphicsAlgorithm[] { rectangle };
		}
		
		@Override
		public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();

            GraphicsAlgorithm rectangle =
                invisible.getGraphicsAlgorithmChildren().get(0);
            return rectangle;
		}
	}

	private FeatureProvider afp;
	private BehaviorProvider tbp;
		
	public StructureClassSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
		afp = new FeatureProvider(dtp, fp);
		tbp = new BehaviorProvider(dtp);
	}
	
	public IFeatureProvider getFeatureProvider() {
		return afp;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return tbp;
	}

	public static void addInheritedItems(ActorClass ac, ContainerShape acShape, Map<String,Anchor> ifitem2anchor, IFeatureProvider fp) {
		
		// we don't have to recurse since the base class diagram already contains all inherited items
		Diagram diag = (Diagram) acShape.eContainer();
		ResourceSet rs = ac.eResource().getResourceSet();
		List<InterfaceItem> presentIfItems = SupportUtil.getInterfaceItems(acShape, fp, ifitem2anchor);
		List<ActorContainerRef> presentRefs = SupportUtil.getRefs(acShape, fp, ifitem2anchor);
		List<Binding> presentBindings = SupportUtil.getBindings(diag, fp);
		List<LayerConnection> presentConnections = SupportUtil.getConnections(diag, fp);
		
		Diagram refDiag = new DiagramAccess().getDiagram(ac);
		if (!refDiag.getChildren().isEmpty()) {
			ContainerShape refAcShape = (ContainerShape) refDiag.getChildren().get(0);
			Object bo = fp.getBusinessObjectForPictogramElement(refAcShape);
			if (bo instanceof StructureClass) {
				StructureClass extRefClass = (StructureClass) bo;
				assert(extRefClass.getName().equals(ac.getName())): "actor class names must match";
				
				int scaleX = refAcShape.getGraphicsAlgorithm().getWidth()/acShape.getGraphicsAlgorithm().getWidth();
				int scaleY = refAcShape.getGraphicsAlgorithm().getHeight()/acShape.getGraphicsAlgorithm().getHeight();
				
				for (Shape childShape : refAcShape.getChildren()) {
					bo = fp.getBusinessObjectForPictogramElement(childShape);
					GraphicsAlgorithm ga = childShape.getGraphicsAlgorithm();
					if (bo instanceof InterfaceItem || bo instanceof ActorContainerRef) {
						EObject ownObject = SupportUtil.getOwnObject((EObject)bo, rs);
						if (!presentIfItems.contains(ownObject) && !presentRefs.contains(ownObject)) {
							int x = (ga.getX()+ga.getWidth()/2)/scaleX;
							int y = (ga.getY()+ga.getHeight()/2)/scaleY;
							SupportUtil.addItem(ownObject, x, y, acShape, ifitem2anchor, fp);
						}
					}
				}
				for (Connection conn : refDiag.getConnections()) {
					bo = fp.getBusinessObjectForPictogramElement(conn);
					if (bo instanceof Binding) {
						Binding bind = (Binding) SupportUtil.getOwnObject((Binding)bo, rs);
						if (!presentBindings.contains(bind))
							SupportUtil.addBinding(bind, fp, ifitem2anchor);
					}
					else if (bo instanceof LayerConnection) {
						LayerConnection lc = (LayerConnection) SupportUtil.getOwnObject((LayerConnection)bo, rs);
						if (!presentConnections.contains(lc))
							SupportUtil.addLayerConnection(lc, fp, ifitem2anchor);
					}
				}
			}
		}
	}
	
	private static void addMissingItems(StructureClass sc, ContainerShape acShape, IFeatureProvider fp) {

		int width = acShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0).getWidth();

		HashMap<String, Anchor> ifitem2anchor = new HashMap<String, Anchor>();
		
		// interface items
		{
			List<InterfaceItem> present = SupportUtil.getInterfaceItems(acShape, fp, ifitem2anchor);
			{
				List<InterfaceItem> expected = RoomHelpers.getInterfaceItems(sc, false);
				List<InterfaceItem> items = new ArrayList<InterfaceItem>();
				for (InterfaceItem item : expected) {
					if (!present.contains(item))
						items.add(item);
				}
				SupportUtil.addInterfaceItems(items, 0, acShape, width, fp, ifitem2anchor);
			}
			if (sc instanceof ActorClass) {
				
				List<InterfaceItem> ports = new ArrayList<InterfaceItem>();
				for (Port port : ((ActorClass) sc).getIntPorts()) {
					if (!present.contains(port))
						ports.add(port);
				}
				SupportUtil.addInterfaceItems(ports, 3*StructureClassSupport.MARGIN, acShape, width, fp, ifitem2anchor);
			}
		}
		
		// actor container references
		{
			List<ActorContainerRef> present = SupportUtil.getRefs(acShape, fp, ifitem2anchor);
			List<ActorContainerRef> expected = RoomHelpers.getRefs(sc, false);
			List<ActorContainerRef> items = new ArrayList<ActorContainerRef>();
			for (ActorContainerRef item : expected) {
				if (!present.contains(item))
					items.add(item);
			}
        	SupportUtil.addRefItems(items, acShape, width, fp, ifitem2anchor);
		}
		
		// base class items
		if (sc instanceof ActorClass) {
			ActorClass base = ((ActorClass) sc).getBase();
			
			// add inherited ports and refs and bindings (and preserve layout)
			if (base!=null)
				StructureClassSupport.addInheritedItems(base, acShape, ifitem2anchor, fp);
		}
		
		Diagram diag = (Diagram) acShape.eContainer();
		
		// bindings
		{
			List<Binding> present = SupportUtil.getBindings(diag, fp);
			List<Binding> expected = RoomHelpers.getBindings(sc, false);
			for (Binding bind : expected) {
				if (!present.contains(bind))
					SupportUtil.addBinding(bind, fp, ifitem2anchor);
			}
		}
		
		// layer connections
		{
			List<LayerConnection> present = SupportUtil.getConnections(diag, fp);
			List<LayerConnection> expected = RoomHelpers.getConnections(sc, false);
			for (LayerConnection lc : expected) {
				if (!present.contains(lc))
					SupportUtil.addLayerConnection(lc, fp, ifitem2anchor);
			}
		}
	}
}
