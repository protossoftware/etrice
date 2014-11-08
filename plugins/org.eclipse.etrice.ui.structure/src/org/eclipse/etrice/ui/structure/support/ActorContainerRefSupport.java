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
import java.util.Set;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCreateFeature;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCustomFeature;
import org.eclipse.etrice.ui.common.base.support.CommonSupportUtil;
import org.eclipse.etrice.ui.common.base.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.DiagramTypeProvider;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.ActorContainerRefPropertyDialog;
import org.eclipse.etrice.ui.structure.support.context.InitialAddShapeContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.feature.ShapeUpdateFeature;
import org.eclipse.etrice.ui.structure.support.provider.DefaultPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.PosAndSize;
import org.eclipse.etrice.ui.structure.support.provider.SuperDiagramPositionProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ActorContainerRefSupport {
	
	private static final String VERSION_KEY = "actorref_version";
	
	private static final int LINE_WIDTH = 1;
	public static final int DEFAULT_SIZE_X = 180;
	public static final int DEFAULT_SIZE_Y = 80;
	public static final int MIN_SIZE_X = 100;
	public static final int MIN_SIZE_Y = 60;
	public static final int MARGIN = 30;
	private static final int SIZE_FRAME_SIZE = 25;
	private static final int REPLICATED_RECT_OFFSET = 3;
	
	public static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	public static final IColorConstant INHERITED_COLOR = new ColorConstant(100, 100, 100);
	public static final IColorConstant BACKGROUND = new ColorConstant(200, 200, 200);
	
	public static final String GRAPHIC_ITEM_KEY = "actorref_graphic_element";
	public static final String HATCHED_LINE = "hatched_line";
	public static final String LAYERCONN_ANCHOR = "layerconn_anchor";
	public static final String MAIN_BORDER = "mainborder";
	public static final String NAME_SHAPE = "name_shape";
	public static final String REPL_BORDER = "replborder";
	public static final String SIZE_FRAME = "sizeframe";
	public static final String SIZE_SHAPE = "size_shape";
	public static final String SUBSTRUCTURE = "substructure";
	
	private static class FeatureProvider extends DefaultFeatureProvider {
		
		private static class ActorRefGraphicsAccess {
			
			private IPeService peService;
			
			private ContainerShape containerShape;
			private GraphicsAlgorithm invRectangle;
			private Diagram diagram;
			
			public ActorRefGraphicsAccess(ContainerShape containerShape, Diagram diagram){
				this.containerShape = containerShape;
				this.invRectangle = containerShape.getGraphicsAlgorithm();
				this.diagram = diagram;
				peService = Graphiti.getPeService();
				
				String version = peService.getPropertyValue(containerShape, VERSION_KEY);
				if(!"2".equals(version))
					convertToVersion2();
				
			}
			
			private void convertToVersion2(){
				List<EObject> deleteList = new ArrayList<EObject>();
				for(Shape child : containerShape.getChildren())
					if(child.getGraphicsAlgorithm() instanceof Text)
						deleteList.add(child);
				for(GraphicsAlgorithm ga : invRectangle.getGraphicsAlgorithmChildren())
					deleteList.add(ga);
				
				createRefFigureInternal();
				for(Anchor anchor : containerShape.getAnchors())
					anchor.setReferencedGraphicsAlgorithm(getMainBorder());
				
				for(EObject toDelete : Lists.newArrayList(deleteList))
					EcoreUtil.delete(toDelete, true);
				
				peService.setPropertyValue(containerShape, VERSION_KEY, "2");
			}
			
			public Rectangle getMainBorder(){
				return (Rectangle) findFirst(invRectangle.getGraphicsAlgorithmChildren(), MAIN_BORDER);
			}
			
			public Rectangle getReplBorder(){
				return (Rectangle) findFirst(invRectangle.getGraphicsAlgorithmChildren(), REPL_BORDER);
			}
			
			public Rectangle getSizeFrame(){
				return (Rectangle) findFirst(invRectangle.getGraphicsAlgorithmChildren(), SIZE_FRAME);
			}
			
			@SuppressWarnings("unchecked")
			public List<GraphicsAlgorithm> getSubstructure(){
				Rectangle mainBorder = getMainBorder();
				return (List<GraphicsAlgorithm>) findAll(mainBorder.getGraphicsAlgorithmChildren(), SUBSTRUCTURE);
			}
			
			@SuppressWarnings("unchecked")
			public List<GraphicsAlgorithm> getHatchedLines(){
				Rectangle mainBorder = getMainBorder();
				return (List<GraphicsAlgorithm>) findAll(mainBorder.getGraphicsAlgorithmChildren(), HATCHED_LINE);
			}
			
			public Text getNameLabel(){
				Shape shape = (Shape) findFirst(containerShape.getChildren(), NAME_SHAPE);
				return (Text) shape.getGraphicsAlgorithm();
			}
			
			public Text getSizeLabel(){
				Shape shape = (Shape) findFirst(containerShape.getChildren(), SIZE_SHAPE);
				return (Text) shape.getGraphicsAlgorithm();
			}
			
			private List<? extends PropertyContainer> findAll(List<? extends PropertyContainer> items, String propValue){
				List<PropertyContainer> result = new ArrayList<PropertyContainer>();
				
				for(PropertyContainer p : items)
					if(propValue.equals(peService.getPropertyValue(p, GRAPHIC_ITEM_KEY)))
						result.add(p);
				
				return result;
			}
			
			private PropertyContainer findFirst(List<? extends PropertyContainer> items, String propValue){
				for(PropertyContainer p : items)
					if(propValue.equals(peService.getPropertyValue(p, GRAPHIC_ITEM_KEY)))
						return p;
				
				return null;
			}
			
			private void createRefFigureInternal() {
				int width = invRectangle.getWidth()-2*MARGIN;
				int height = invRectangle.getHeight()-2*MARGIN;
				
				IGaService gaService = Graphiti.getGaService();
				IPeService peService = Graphiti.getPeService();
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				
				{
					// repl borderRect
					Rectangle rect = gaService.createRectangle(invRectangle);
					peService.setPropertyValue(rect, GRAPHIC_ITEM_KEY, REPL_BORDER);
					rect.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(rect, MARGIN+REPLICATED_RECT_OFFSET, MARGIN-REPLICATED_RECT_OFFSET, width, height);
				}
				{
					// main borderRect
					Rectangle borderRect = gaService.createRectangle(invRectangle);
					peService.setPropertyValue(borderRect, GRAPHIC_ITEM_KEY, MAIN_BORDER);
					borderRect.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(borderRect, MARGIN, MARGIN, width, height);
					addSubStructureHint();
					createHatched();
				}
				{
					// size frame
					Rectangle sizeFrame = gaService.createRectangle(invRectangle);
					peService.setPropertyValue(sizeFrame, GRAPHIC_ITEM_KEY, SIZE_FRAME);
					sizeFrame.setLineWidth(LINE_WIDTH);
					gaService.setLocationAndSize(sizeFrame, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
				}
				{
					// acr name
					Shape labelShape = peCreateService.createShape(containerShape, false);
					peService.setPropertyValue(labelShape, GRAPHIC_ITEM_KEY, NAME_SHAPE);
					Text label = gaService.createDefaultText(diagram, labelShape);
					label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
					label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
					gaService.setLocationAndSize(label, MARGIN, MARGIN, width, height);
				}
				
				{
					// repl size
					Shape labelShape = peCreateService.createShape(containerShape, false);
					peService.setPropertyValue(labelShape, GRAPHIC_ITEM_KEY, SIZE_SHAPE);
					Text label = gaService.createDefaultText(diagram, labelShape);
					label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
					label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
					gaService.setLocationAndSize(label, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
				}
			}
			
			private void createRefFigureAnchor(){
				// anchor for layer connections
				ChopboxAnchor anchor = Graphiti.getPeCreateService().createChopboxAnchor(containerShape);
				peService.setPropertyValue(anchor, GRAPHIC_ITEM_KEY, LAYERCONN_ANCHOR);
				anchor.setReferencedGraphicsAlgorithm(getMainBorder());
			}
			
			/**
			 *  create graphics
			 *  <li>called only once
			 *  <li>creates all possible graphics like replication and sub structure
			 *  <li>index of graphics is fixed according to creation order
			 *  @see
			 *  {@link #updateRefFigure(ActorContainerRef, ContainerShape, boolean, Diagram) updateRefFigure}
			 */
			public void createRefFigure() {
				createRefFigureInternal();
				createRefFigureAnchor();
			}
			
			public void createHatched() {
				int x0=0, y0=0;
				int x1=0, y1=0;
				int step=15;
				boolean down0=true;
				boolean right1=true;
				Rectangle mainBorder = getMainBorder();
				int width = mainBorder.getWidth();
				int height = mainBorder.getHeight();
				
				IGaService gaService = Graphiti.getGaService();
				
				while (true) {
					if (down0) {
						y0+=step;
						if (y0>height) {
							down0=false;
							x0=y0-height;
							y0=height;
						}
					}
					else {
						x0+=step;
						if (x0>width)
							break;
					}
					
					if (right1) {
						x1+=step;
						if (x1>width) {
							right1=false;
							y1=x1-width;
							x1=width;
						}
					}
					else {
						y1+=step;
						if (y0>height)
							break;
					}
					
					Polyline line = gaService.createPlainPolyline(mainBorder, new int[] {x0, y0, x1, y1});
					Graphiti.getPeService().setPropertyValue(line, GRAPHIC_ITEM_KEY, HATCHED_LINE);
					line.setTransparency(0.4);
				}
			}
			
			private void addSubStructureHint() {
				Rectangle mainBorder = getMainBorder();
				int x = mainBorder.getWidth()-35;
				int y = mainBorder.getHeight()-30;
				IGaService gaService = Graphiti.getGaService();
				Rectangle hint1 = gaService.createRectangle(mainBorder);
				Graphiti.getPeService().setPropertyValue(hint1, GRAPHIC_ITEM_KEY, SUBSTRUCTURE);
				hint1.setFilled(false);
				hint1.setLineWidth(LINE_WIDTH);
				gaService.setLocationAndSize(hint1, x+5, y, 20, 10);
				Rectangle hint2 = gaService.createRectangle(mainBorder);
				Graphiti.getPeService().setPropertyValue(hint2, GRAPHIC_ITEM_KEY, SUBSTRUCTURE);
				hint2.setFilled(false);
				hint2.setLineWidth(LINE_WIDTH);
				gaService.setLocationAndSize(hint2, x, y+15, 20, 10);
			}
		}
		
		private class CreateFeature extends ChangeAwareCreateFeature {
	
			private boolean actorRef;
			
			public CreateFeature(IFeatureProvider fp, boolean actorRef) {
				super(fp, actorRef?"ActorRef":"SubSystemRef", "create "+(actorRef?"ActorRef":"SubSystemRef"));
				this.actorRef = actorRef;
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_REF;
			}
	
			@Override
			public boolean canCreate(ICreateContext context) {
				if (context.getTargetContainer().getLink()!=null)
					if (context.getTargetContainer().getLink().getBusinessObjects().size()==1) {
						EObject obj = context.getTargetContainer().getLink().getBusinessObjects().get(0);
						if (obj instanceof ActorContainerClass) {
							return actorRef;
						}
						if (obj instanceof LogicalSystem) {
							return !actorRef;
						}
					}
				return false;
			}
	
			
			@Override
			protected Object[] doCreate(ICreateContext context) {
				 StructureClass sc = (StructureClass) context.getTargetContainer().getLink().getBusinessObjects().get(0);
			        
			        ActorContainerRef newRef = null;
			        if (sc instanceof ActorContainerClass) {
			        	ActorContainerClass acc = (ActorContainerClass) sc;
			        	
			        	// create ActorRef
			        	ActorRef ar = RoomFactory.eINSTANCE.createActorRef();

				        acc.getActorRefs().add(ar);
			        	newRef = ar;
			        	
			        }
			        else if (sc instanceof LogicalSystem) {
			        	LogicalSystem sys = (LogicalSystem) sc;
			        	
			        	// create ActorRef
			        	SubSystemRef ssr = RoomFactory.eINSTANCE.createSubSystemRef();
			        	
			        	sys.getSubSystems().add(ssr);
			        	newRef = ssr;
			        }
			        
			        newRef.setName(SupportUtil.getInstance().getRoomUtil().getUniqueActorContainerRefName(sc));

			        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
			        EReference reference = (newRef instanceof ActorRef)?RoomPackage.eINSTANCE.getActorRef_Type():RoomPackage.eINSTANCE.getSubSystemRef_Type();
					IScope scope = scopeProvider.getScope(newRef.eContainer().eContainer(), reference);
			        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			        ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, newRef, scope, sc, true);
					
			        if (dlg.open()==Window.OK) {
			        	addGraphicalRepresentation(context, newRef);
			        	
			        	return new Object[] { newRef };
					}
			        
			        return EMPTY;
			}
		}
	
		private class AddFeature extends AbstractAddFeature {
	
			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canAdd(IAddContext context) {
				if (context.getNewObject() instanceof ActorContainerRef) {
					if (context.getTargetContainer().getLink().getBusinessObjects().size()==1) {
						EObject obj = context.getTargetContainer().getLink().getBusinessObjects().get(0);
						if (obj instanceof StructureClass) {
							return true;
						}
					}
				}
				return false;
			}
	
			@Override
			public PictogramElement add(IAddContext context) {
				ActorContainerRef ar = (ActorContainerRef) context.getNewObject();
				ContainerShape acShape = context.getTargetContainer();
	
				// CONTAINER SHAPE WITH RECTANGLE
				ContainerShape containerShape =
						Graphiti.getPeCreateService().createContainerShape(acShape, true);
				
				Graphiti.getPeService().setPropertyValue(containerShape, Constants.TYPE_KEY, Constants.REF_TYPE);
				Graphiti.getPeService().setPropertyValue(containerShape, VERSION_KEY, "2");
				
				{
					int width = context.getWidth() <= 0 ? DEFAULT_SIZE_X : context.getWidth();
					int height = context.getHeight() <= 0 ? DEFAULT_SIZE_Y : context.getHeight();
					final Rectangle invisibleRectangle = Graphiti.getGaService().createInvisibleRectangle(containerShape);
					Graphiti.getGaService().setLocationAndSize(invisibleRectangle,
							context.getX()-(width/2+MARGIN), context.getY()-(height/2+MARGIN), width + 2*MARGIN, height + 2*MARGIN);
					
					new ActorRefGraphicsAccess(containerShape, getDiagram()).createRefFigure();
				}
					
				// create link and wire it
				link(containerShape, ar);
				
				// do not update in first place, because there are no positions
				// therefore default positions for children interface items are needed -> expensive
				if(!(context instanceof InitialAddShapeContext))
					updatePictogramElement(containerShape);		
	
				// call the layout feature
				layoutPictogramElement(containerShape);
	
				return containerShape;
			}
	
		}
		
		private class LayoutFeature extends AbstractLayoutFeature {
	
			public LayoutFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canLayout(ILayoutContext context) {
				// return true, if pictogram element is linked to an ActorContainerRef
				PictogramElement pe = context.getPictogramElement();
				if (!(pe instanceof ContainerShape))
					return false;
	
				EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
				return businessObjects.size() == 1
						&& businessObjects.get(0) instanceof ActorContainerRef;
			}
	
			@Override
			public boolean layout(ILayoutContext context) {
				ContainerShape containerShape = (ContainerShape) context
						.getPictogramElement();
	
				// our invisible rectangle
				GraphicsAlgorithm invRectangle = containerShape.getGraphicsAlgorithm();
				ActorRefGraphicsAccess graphics = new ActorRefGraphicsAccess(containerShape, getDiagram());
				
				int w = invRectangle.getWidth();
				int h = invRectangle.getHeight();
				int nw = w-2*MARGIN;
				int nh = h-2*MARGIN;
			
				
				GraphicsAlgorithm replBorder = graphics.getReplBorder();
				replBorder.setWidth(nw);
				replBorder.setHeight(nh);
				
				Rectangle mainBorder = graphics.getMainBorder();
				mainBorder.setWidth(nw);
				mainBorder.setHeight(nh);
				
				int x = mainBorder.getWidth()-35;
				int y = mainBorder.getHeight()-30;
				Graphiti.getLayoutService().setLocationAndSize(graphics.getSubstructure().get(0), x+5, y, 20, 10);
				Graphiti.getLayoutService().setLocationAndSize(graphics.getSubstructure().get(1), x, y+15, 20, 10);
				
				for(GraphicsAlgorithm line : Lists.newArrayList(graphics.getHatchedLines()))
					EcoreUtil.delete(line, true);
				graphics.createHatched();
				
				GraphicsAlgorithm replFrame = graphics.getSizeFrame();
				replFrame.setX(MARGIN+nw-SIZE_FRAME_SIZE);
					
					
				GraphicsAlgorithm label = graphics.getNameLabel();
				label.setWidth(nw);
				label.setHeight(nh);
						
				GraphicsAlgorithm replLabel = graphics.getSizeLabel();
				replLabel.setX(MARGIN+nw-SIZE_FRAME_SIZE);
				
				
				ActorContainerRef acr = (ActorContainerRef) getBusinessObjectForPictogramElement(containerShape);
				EObject parent = (EObject) getBusinessObjectForPictogramElement(containerShape.getContainer());
				boolean inherited = isInherited(acr, parent);
				updateRefFigure(acr, containerShape, inherited, getDiagram());
				
				return true;
			}
		}

		private static class PropertyFeature extends ChangeAwareCustomFeature {

			public PropertyFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Edit Reference...";
			}
			
			@Override
			public String getDescription() {
				return "Edit Reference Properties";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorContainerRef) {
						EObject parent = (EObject) getBusinessObjectForPictogramElement((PictogramElement) pes[0].eContainer());
						return !isInherited((ActorContainerRef)bo, parent);
					}
				}
				return false;
			}
			
			@Override
			protected boolean doExecute(ICustomContext context) {
				ContainerShape containerShape = (ContainerShape) context.getPictogramElements()[0];
				ActorContainerRef acr = (ActorContainerRef) getBusinessObjectForPictogramElement(containerShape);
				StructureClass sc = (StructureClass)acr.eContainer();
				
		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        EReference reference = (acr instanceof ActorRef)?RoomPackage.eINSTANCE.getActorRef_Type():RoomPackage.eINSTANCE.getSubSystemRef_Type();
				IScope scope = scopeProvider.getScope(acr.eContainer().eContainer(), reference);
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, acr, scope, sc, false);
				
				if (dlg.open()==Window.OK){
					EObject parent = (EObject) getBusinessObjectForPictogramElement(containerShape.getContainer());
					updateRefFigure(acr, containerShape, isInherited(acr, parent), getDiagram());
					
					return true;
				}
				
				return false;
			}
			
		}
		
		private static class OpenRefStructureDiagram extends AbstractCustomFeature {

			public OpenRefStructureDiagram(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Open Ref Structure";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorContainerRef) {
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
					if (bo instanceof ActorContainerRef) {
						final ActorContainerRef ref = (ActorContainerRef) bo;
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				        shell.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								DiagramAccess diagramAccess = new DiagramAccess();
								if (ref instanceof ActorRef) {
									diagramAccess.openDiagramEditor(((ActorRef) ref).getType());
								}
								else if (ref instanceof SubSystemRef) {
									diagramAccess.openDiagramEditor(((SubSystemRef) ref).getType());
								}
							}
				        });
					}
				}
			}
			
			@Override
			public boolean hasDoneChanges() {
				return false;
			}
		}
		
		private static class OpenRefBehaviorDiagram extends AbstractCustomFeature {

			public OpenRefBehaviorDiagram(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Open Ref Behavior";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof ActorRef) {
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
					if (bo instanceof ActorContainerRef) {
						final ActorContainerRef ref = (ActorContainerRef) bo;
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				        shell.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								org.eclipse.etrice.ui.behavior.DiagramAccess diagramAccess = new org.eclipse.etrice.ui.behavior.DiagramAccess();
								if (ref instanceof ActorRef) {
									diagramAccess.openDiagramEditor(((ActorRef) ref).getType());
								}
							}
				        });
					}
				}
			}
			
			@Override
			public boolean hasDoneChanges() {
				ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.ui.common");
				boolean autoSave = store.getBoolean(UIBasePreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
				if (autoSave)
					return true;	// this is needed to trigger the save via a CommandStackListener after this command is completed
				else
					return false;
			}
		}
		
		private class UpdateFeature extends ShapeUpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			protected boolean canUpdate(EObject bo, PictogramElement pe) {
				return bo instanceof ActorContainerRef;
			}
			
			@Override
			protected IReason updateNeeded(EObject bo, IUpdateContext context) {
				ActorContainerRef acr = (ActorContainerRef) bo;
				ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
				ActorRefGraphicsAccess graphics = new ActorRefGraphicsAccess(containerShape, getDiagram());
				
				String reason = "";
				
				boolean isReplicated = (acr instanceof ActorRef)? ((ActorRef)acr).getMultiplicity()!=1:false;
				boolean isOptional = (acr instanceof ActorRef)? ((ActorRef)acr).getRefType() == ReferenceType.OPTIONAL:false;
				boolean hasSubStruct = hasSubStructure(acr);
				
				// check replicated
				boolean replFrameVisible = graphics.getReplBorder().getLineVisible();
				if(isReplicated && !replFrameVisible)
					reason += "ActorRef got replicated";
				else if(!isReplicated && replFrameVisible)
					reason += "ActorRef is not replicated anymore";
				
				// check if ref still owned/inherited anymore
				Object containerBo = getBusinessObjectForPictogramElement(containerShape);
				if (containerBo instanceof ActorClass) {
					ActorClass ac = (ActorClass) containerBo;
					boolean found = false;
					do {
						if (ac==acr.eContainer())
							found = true;
						ac = ac.getActorBase();
					}
					while (!found && ac!=null);
					
					if (!found)
						reason += "Ref not inherited anymore\n";
				}
				
				// check sub structure hint
				boolean subStructureVisible = graphics.getSubstructure().get(0).getLineVisible();
				if (hasSubStruct && !subStructureVisible)
					reason += "state has sub structure now\n";
				if (!hasSubStruct && subStructureVisible)
					reason += "state has no sub structure anymore\n";
						
				
				
				// check class name
				if (bo instanceof ActorContainerRef) {
					String label = SupportUtil.getInstance().getRoomNameProvider().getRefLabelName((ActorContainerRef) bo);
					if (!label.equals(graphics.getNameLabel().getValue()))
						reason += "Class name is out of date\n";
				}
				
				// check replicated label
				{
					if(isOptional || isReplicated){
						String label = (isOptional)?"*":((ActorRef)bo).getMultiplicity()+"";
						if(!label.equals(graphics.getSizeLabel().getValue()))
							reason += "multiplicity changed";
					}
				}
				
				// check interface ports and spps added to model not present in diagram
				{
					ActorContainerClass acc = (acr instanceof ActorRef)?((ActorRef)acr).getType():((SubSystemRef)acr).getType();
					Set<InterfaceItem> expectedItems = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getInterfaceItems(acc, true));
					Set<InterfaceItem> presentItems = Sets.newHashSet(SupportUtil.getInstance().getInterfaceItems(containerShape, fp));
					if(!expectedItems.equals(presentItems))
						reason += "interface item(s) missing or outdated\n";
				}
				
				if (!reason.isEmpty())
					return Reason.createTrueReason(reason.substring(0, reason.length()-1));
				
				return Reason.createFalseReason();
			}

			@Override
			protected boolean update(EObject bo, IUpdateContext context) {
				ContainerShape containerShape = (ContainerShape)context.getPictogramElement();				
				GraphicsAlgorithm invisibleRect = containerShape.getGraphicsAlgorithm();
				ActorContainerRef acr = (ActorContainerRef) bo;
				
				if(context instanceof PositionUpdateContext)
					setPosition(acr, containerShape, (PositionUpdateContext) context);
				
				EObject parent = (EObject) getBusinessObjectForPictogramElement(containerShape.getContainer());
				updateRefFigure(acr, containerShape, isInherited(acr, parent), getDiagram());
				
				GraphicsAlgorithm mainBorder = new ActorRefGraphicsAccess(containerShape, getDiagram()).getMainBorder();
				IPositionProvider positionProvider = null;
				if(context instanceof PositionUpdateContext){
					positionProvider = ((PositionUpdateContext)context).getPositionProvider();
					positionProvider = positionProvider.setNewParent(acr, DiagramUtil.getPosAndSize(invisibleRect), DiagramUtil.getPosAndSize(mainBorder));
				}
				
				ActorContainerClass acc = (acr instanceof ActorRef)?((ActorRef)acr).getType():((SubSystemRef)acr).getType();
				Map<EObject, Shape> present = getChildrenShapesForBoClass(containerShape, RoomPackage.Literals.INTERFACE_ITEM);
				Set<InterfaceItem> expected = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getInterfaceItems(acc, true));
				
				// add new items
				Map<EObject, Shape> newShapes = addShapesInitial(Sets.difference(expected, present.keySet()), containerShape);
				// remove outdated items
				for(EObject item : Sets.difference(present.keySet(), expected))
					removeGraphicalRepresentation(present.get(item));
				
				if(positionProvider != null)
					updatePictogramElements(newShapes.values(), positionProvider);
				// handle new shapes without position
				Map<EObject, Shape> withoutPosition = new HashMap<EObject, Shape>();
				if(positionProvider != null){
					for(EObject obj : newShapes.keySet())
						if(!positionProvider.contains(obj))
							withoutPosition.put(obj, newShapes.get(obj));
				} else if(!newShapes.isEmpty())
					withoutPosition.putAll(newShapes);
				
				if(!withoutPosition.isEmpty()){
					IPositionProvider defaultPP = new DefaultPositionProvider(acr);
					defaultPP = defaultPP.setNewParent(acr, DiagramUtil.getPosAndSize(invisibleRect), DiagramUtil.getPosAndSize(mainBorder));
					updatePictogramElements(newShapes.values(), defaultPP);
				}
				
				// only update positions if inherited
				if(positionProvider instanceof SuperDiagramPositionProvider)
					updatePictogramElements(present.values(), positionProvider);
				else
					updatePictogramElements(present.values());
				
				return true;				
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
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				
				if (bo instanceof ActorContainerRef) {
					ActorContainerRef ar = (ActorContainerRef) bo;
					ContainerShape acShape = (ContainerShape) context.getPictogramElement().eContainer();
					EObject parent = acShape.getLink().getBusinessObjects().get(0);
					return !isInherited(ar, parent);
				}
				
				return false;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.graphiti.ui.features.DefaultDeleteFeature#preDelete(org.eclipse.graphiti.features.context.IDeleteContext)
			 */
			@Override
			public void preDelete(IDeleteContext context) {
				super.preDelete(context);
				
				if (!(context.getPictogramElement() instanceof ContainerShape))
					return;
					
				ContainerShape container = (ContainerShape) context.getPictogramElement();
				CommonSupportUtil.deleteConnectionsRecursive(container, getFeatureProvider());
			}
		}
		
		private class MoveShapeFeature extends DefaultMoveShapeFeature {
	
			public MoveShapeFeature(IFeatureProvider fp) {
				super(fp);
			}
	
			@Override
			public boolean canMoveShape(IMoveShapeContext context) {
				boolean canMove = super.canMoveShape(context);
	
				if (canMove) {
					Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
					
					if (bo instanceof ActorContainerRef) {
						ActorContainerRef ar = (ActorContainerRef) bo;
						ContainerShape acShape = context.getTargetContainer();
						EObject parent = acShape.getLink().getBusinessObjects().get(0);
						
						// TODOHRR: also check coordinates (no overlap with actor boundaries)
						
						return !isInherited(ar, parent);
					}
				}
				
				return canMove;
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
				if (width>0 && height>0)
					if (width < MIN_SIZE_X+MARGIN || height < MIN_SIZE_Y+MARGIN)
						return false;
				
				return true;
			}
			
			@Override
			public void resizeShape(IResizeShapeContext context) {
				ContainerShape containerShape = (ContainerShape) context.getShape();
				Object bo = getBusinessObjectForPictogramElement(containerShape);
				if(bo instanceof ActorRef) {
					ActorRefGraphicsAccess arga = new ActorRefGraphicsAccess(containerShape, getDiagram());
					resizeChildrenInterfaceItems(context, arga.getMainBorder());
				}
				super.resizeShape(context);
			}
			
			
			private void resizeChildrenInterfaceItems(IResizeShapeContext context, GraphicsAlgorithm innerRect){
				PosAndSize innerRectPos = DiagramUtil.getPosAndSize(innerRect);
				
				double sx = (double)(context.getWidth() - 2*innerRectPos.getX()) / innerRectPos.getW();
				double sy = (double)(context.getHeight() - 2*innerRectPos.getY()) / innerRectPos.getH();
				
				for (Shape childShape : ((ContainerShape)context.getPictogramElement()).getChildren()) {
					Object childBo = getBusinessObjectForPictogramElement(childShape);
					if (childBo instanceof InterfaceItem) {
						GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
						
						PosAndSize childPos = DiagramUtil.getPosAndSize(childGa);
						double portMidX = (double)childPos.getW()/2.0F;
						double portMidY = (double)childPos.getH()/2.0F;
						
						// calc mid point & align to inner rect
						double midX = childPos.getX() + portMidX - innerRectPos.getX();
						double midY = childPos.getY() + portMidY - innerRectPos.getY();
						// scale
						midX = sx*midX;
						midY = sy*midY;
						// first step reverse
						midX = midX - portMidX + innerRectPos.getX();
						midY = midY - portMidY + innerRectPos.getY();
						
						Graphiti.getGaService().setLocation(childGa, (int)Math.round(midX), (int)Math.round(midY));
						updatePictogramElement(childShape);
					}
					
				}
				
			}
		}
		
		private IFeatureProvider fp;
	
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp);
			this.fp = fp;
		}
	
		@Override
		public ICreateFeature[] getCreateFeatures() {
			return new ICreateFeature[] { new CreateFeature(fp, true), new CreateFeature(fp, false) };
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
		public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
			return new MoveShapeFeature(fp);
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
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] {
					new PropertyFeature(fp),
					new OpenRefStructureDiagram(fp),
					new OpenRefBehaviorDiagram(fp)};
		}
		
		protected static boolean isInherited(ActorContainerRef ar, EObject parent) {
			return ar.eContainer()!=parent;
		}
		
		

		private static boolean hasSubStructure(ActorContainerRef acr) {
			if (acr instanceof ActorRef) {
				if (!((ActorRef) acr).getType().getActorRefs().isEmpty())
					return true;
			}
			else if (acr instanceof SubSystemRef) {
				if (!((SubSystemRef)acr).getType().getActorRefs().isEmpty())
					return true;
			}
			return false;
		}
		
		/**
		 * update graphics
		 * @see
		 * {@link #createRefFigure(ActorContainerRef, Diagram, ContainerShape, Rectangle) createRefFigure}
		 */
		private static void updateRefFigure(ActorContainerRef acr, ContainerShape containerShape, boolean inherited, Diagram diagram){
		
			boolean isReplicated = (acr instanceof ActorRef)? ((ActorRef)acr).getMultiplicity()!=1:false;
			boolean isOptional = (acr instanceof ActorRef)? ((ActorRef)acr).getRefType() == ReferenceType.OPTIONAL:false;
			boolean hasSubStructure = hasSubStructure(acr);
			
			IColorConstant lineColorConstant = inherited?INHERITED_COLOR:LINE_COLOR;
			Color lineColor = Graphiti.getGaService().manageColor(diagram, lineColorConstant);
			Color bgColor = Graphiti.getGaService().manageColor(diagram, BACKGROUND);
			
			ActorRefGraphicsAccess graphics = new ActorRefGraphicsAccess(containerShape, diagram);
			
			{
				// repl borderRect
				Rectangle rect = graphics.getReplBorder();
				rect.setForeground(lineColor);
				rect.setBackground(bgColor);
				rect.setLineVisible(isReplicated);
				rect.setFilled(isReplicated);
			}
			{
				// main borderRect
				GraphicsAlgorithm rect = graphics.getMainBorder();
				rect.setForeground(lineColor);
				rect.setBackground(bgColor);
				for(GraphicsAlgorithm line : graphics.getHatchedLines()){
					line.setLineVisible(isOptional);
					line.setForeground(lineColor);
				}
				
				// sub structure hint
				for(GraphicsAlgorithm hint : graphics.getSubstructure()){
					hint.setLineVisible(hasSubStructure);
					hint.setForeground(lineColor);
				}
			}
			{
				// repl frame
				GraphicsAlgorithm rect = graphics.getSizeFrame();
				rect.setForeground(lineColor);
				rect.setBackground(bgColor);
				rect.setLineVisible(isReplicated);
				rect.setFilled(isReplicated);
			}
			{
				// acr name
				Text label = graphics.getNameLabel();
				label.setValue(SupportUtil.getInstance().getRoomNameProvider().getRefLabelName(acr));
				label.setForeground(lineColor);
				label.setBackground(bgColor);
			}
			{
				// repl size
				Text label = graphics.getSizeLabel();
				if(acr instanceof ActorRef){
					ActorRef ar = (ActorRef)acr;
					String text = isOptional?"*":ar.getMultiplicity()+"";
					label.setValue(text);
				}
				label.setForeground(lineColor);
				label.setBackground(bgColor);
				label.getPictogramElement().setVisible(isReplicated);
			}
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
            if (!rectangle.getLineVisible())
            	rectangle = invisible.getGraphicsAlgorithmChildren().get(1);
            return new GraphicsAlgorithm[] { rectangle };
		}
		
		@Override
		public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();

            GraphicsAlgorithm rectangle =
                invisible.getGraphicsAlgorithmChildren().get(0);
        	if (!rectangle.getLineVisible())
        		rectangle = invisible.getGraphicsAlgorithmChildren().get(1);
            return rectangle;
		}
		
		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
			return new FeatureProvider.OpenRefStructureDiagram(getDiagramTypeProvider().getFeatureProvider());
		}
		
		@Override
		public IContextButtonPadData getContextButtonPad(
				IPictogramElementContext context) {
			
			IContextButtonPadData data = super.getContextButtonPad(context);
			PictogramElement pe = context.getPictogramElement();

			CreateConnectionContext ccc = new CreateConnectionContext();
			ccc.setSourcePictogramElement(pe);
			Anchor anchor = null;
			if (pe instanceof AnchorContainer) {
				// our spp has four fixed point anchor - we choose the first one
				anchor = ((ContainerShape)pe).getAnchors().get(0);
			}
			ccc.setSourceAnchor(anchor);
			
			ContextButtonEntry button = new ContextButtonEntry(null, context);
			button.setText("Create Layer Connection");
			button.setIconId(ImageProvider.IMG_LAYER_CONNECTION);
			ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
			for (ICreateConnectionFeature feature : features) {
				if (feature.isAvailable(ccc) && feature.canStartConnection(ccc))
					button.addDragAndDropFeature(feature);
			}

			if (button.getDragAndDropFeatures().size() > 0) {
				data.getDomainSpecificContextButtons().add(button);
			}

			return data;
		}
	}

	public static Style getStyle(Diagram diagram) {
		IGaService gaService = Graphiti.getGaService();

		// this is a child style of the common-values-style
		Style style = null;//gaService.findStyle(diagram, "line");

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(diagram, "line");
			style.setFilled(true);
			style.setForeground(gaService.manageColor(diagram, LINE_COLOR));
			// style.setBackground(gaService.manageColor(diagram,
			// E_CLASS_BACKGROUND));

			// no background color here, we have a gradient instead
			// see chapter "Color Schemas" in Tutorial
			gaService.setRenderingStyle(style, PredefinedColoredAreas.getBlueWhiteGlossAdaptions());
		}
		return style;
	}

	private FeatureProvider pfp;
	private BehaviorProvider tbp;

	
	
	public ActorContainerRefSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
		pfp = new FeatureProvider(dtp,fp);
		tbp = new BehaviorProvider(dtp);
	}
	
	public IFeatureProvider getFeatureProvider() {
		return pfp;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return tbp;
	}
}
