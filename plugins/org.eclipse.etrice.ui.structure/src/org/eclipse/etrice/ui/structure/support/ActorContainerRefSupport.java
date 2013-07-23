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

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.naming.RoomNameProvider;
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
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.etrice.ui.common.support.CommonSupportUtil;
import org.eclipse.etrice.ui.common.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.DiagramTypeProvider;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.ActorContainerRefPropertyDialog;
import org.eclipse.etrice.ui.structure.support.context.InitialAddShapeContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.feature.ShapeUpdateFeature;
import org.eclipse.etrice.ui.structure.support.provider.DefaultPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.SuperDiagramPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.PosAndSize;
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
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.features.impl.Reason;
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

public class ActorContainerRefSupport {
	
	private static final int LINE_WIDTH = 1;
	public static final int DEFAULT_SIZE_X = 120;
	public static final int DEFAULT_SIZE_Y = 80;
	public static final int MIN_SIZE_X = 100;
	public static final int MIN_SIZE_Y = 60;
	public static final int MARGIN = 30;
	private static final int SIZE_FRAME_SIZE = 25;
	private static final int REPLICATED_RECT_OFFSET = 3;
	
	public static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	public static final IColorConstant OPTIONAL_COLOR = new ColorConstant(0, 0, 255);
	public static final IColorConstant INHERITED_COLOR = new ColorConstant(100, 100, 100);
	public static final IColorConstant BACKGROUND = new ColorConstant(200, 200, 200);

	private static class FeatureProvider extends DefaultFeatureProvider {
		
		private class CreateFeature extends AbstractCreateFeature {
	
			private boolean actorRef;
			private boolean doneChanges = false;

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
			public Object[] create(ICreateContext context) {
		        
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
		        
		        newRef.setName(RoomNameProvider.getUniqueActorContainerRefName(sc));

		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        EReference reference = (newRef instanceof ActorRef)?RoomPackage.eINSTANCE.getActorRef_Type():RoomPackage.eINSTANCE.getSubSystemRef_Type();
				IScope scope = scopeProvider.getScope(newRef.eContainer().eContainer(), reference);
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		        ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, newRef, scope, sc, true);
				if (dlg.open()!=Window.OK) {
			        if (sc instanceof ActorContainerClass)
			        	((ActorContainerClass)sc).getActorRefs().remove(newRef);
			        else if (sc instanceof LogicalSystem)
			        	((LogicalSystem) sc).getSubSystems().remove(newRef);
					return EMPTY;
				}
		        
		        addGraphicalRepresentation(context, newRef);
		        doneChanges = true;
		        
		        // return newly created business object(s)
		        return new Object[] { newRef };
			}
			
			@Override
			public boolean hasDoneChanges() {
				return doneChanges;
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
	
				EObject parent = (EObject) getBusinessObjectForPictogramElement(acShape);
				boolean inherited = isInherited(ar, parent);
			
				boolean isOptional = false;
				if (ar instanceof ActorRef) {
					isOptional = ((ActorRef) ar).getRefType()==ReferenceType.OPTIONAL;
				}
				
				Color lineColor = isOptional? manageColor(OPTIONAL_COLOR) : manageColor(inherited?INHERITED_COLOR:LINE_COLOR);
				{
					int width = context.getWidth() <= 0 ? DEFAULT_SIZE_X : context.getWidth();
					int height = context.getHeight() <= 0 ? DEFAULT_SIZE_Y : context.getHeight();
					final Rectangle invisibleRectangle = Graphiti.getGaService().createInvisibleRectangle(containerShape);
					Graphiti.getGaService().setLocationAndSize(invisibleRectangle,
							context.getX()-(width/2+MARGIN), context.getY()-(height/2+MARGIN), width + 2*MARGIN, height + 2*MARGIN);
					
					createRefFigure(ar, getDiagram(), containerShape, invisibleRectangle, lineColor, manageColor(BACKGROUND));
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
				boolean anythingChanged = false;
				ContainerShape containerShape = (ContainerShape) context
						.getPictogramElement();
	
				// our invisible rectangle
				GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
				
				int w = containerGa.getWidth();
				int h = containerGa.getHeight();
				int nw = w-2*MARGIN;
				int nh = h-2*MARGIN;
				
				/**
				 * TODO: (Keplar) use Ids to identify GraphicsAlgorithm children
				 * see Graphiti example "filesystem"
				 *  (org.eclipse.graphiti.examples.filesystem.patterns.FolderPattern)
				 */
				if(containerGa.getGraphicsAlgorithmChildren().size()>=1){
					GraphicsAlgorithm borderRect = null;
					Object obj = getBusinessObjectForPictogramElement(containerShape);
					if(obj instanceof ActorRef && ((ActorRef)obj).getSize()!=1){
						GraphicsAlgorithm replBorder = containerGa.getGraphicsAlgorithmChildren().get(0);
						replBorder.setWidth(nw);
						replBorder.setHeight(nh);
						borderRect = containerGa.getGraphicsAlgorithmChildren().get(1);
						GraphicsAlgorithm replFrame = containerGa.getGraphicsAlgorithmChildren().get(2);
						replFrame.setX(MARGIN+nw-SIZE_FRAME_SIZE);
					} else
						borderRect = containerGa.getGraphicsAlgorithmChildren().get(0);
					
					borderRect.setWidth(nw);
					borderRect.setHeight(nh);
					Object bo = getBusinessObjectForPictogramElement(containerShape);
					if (bo instanceof ActorContainerRef) {
						ActorContainerRef acr = (ActorContainerRef) bo;
						EObject parent = containerShape.getContainer().getLink().getBusinessObjects().get(0);
						Color lineColor = manageColor(isInherited(acr, parent)?INHERITED_COLOR:LINE_COLOR);
						// remove and recreate substructure hint
						while (!borderRect.getGraphicsAlgorithmChildren().isEmpty()) {
							EcoreUtil.delete(borderRect.getGraphicsAlgorithmChildren().get(0), true);
						}
						addSubStructureHint(acr, (Rectangle) borderRect, lineColor);
					}
					
					if (!containerShape.getChildren().isEmpty()) {
						GraphicsAlgorithm childGA = containerShape.getChildren().get(0).getGraphicsAlgorithm();
						assert(childGA instanceof Text): "label expected";
						childGA.setWidth(nw);
						childGA.setHeight(nh);
						
						if(obj instanceof ActorRef && ((ActorRef)obj).getSize()!=1){
							GraphicsAlgorithm replLabel = containerShape.getChildren().get(1).getGraphicsAlgorithm();
							replLabel.setX(MARGIN+nw-SIZE_FRAME_SIZE);
						}
					}
					
					anythingChanged = true;
				}
				
				return anythingChanged;
			}
		}

		private static class PropertyFeature extends AbstractCustomFeature {

			private boolean doneChanges = false;

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
			public void execute(ICustomContext context) {
				ContainerShape containerShape = (ContainerShape) context.getPictogramElements()[0];
				ActorContainerRef acr = (ActorContainerRef) getBusinessObjectForPictogramElement(containerShape);
				StructureClass sc = (StructureClass)acr.eContainer();
				
		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        EReference reference = (acr instanceof ActorRef)?RoomPackage.eINSTANCE.getActorRef_Type():RoomPackage.eINSTANCE.getSubSystemRef_Type();
				IScope scope = scopeProvider.getScope(acr.eContainer().eContainer(), reference);
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				ActorContainerRefPropertyDialog dlg = new ActorContainerRefPropertyDialog(shell, acr, scope, sc, false);
				if (dlg.open()!=Window.OK)
					return;
				
				doneChanges   = true;
				//updateLabel(acr, context.getPictogramElements()[0]);

				boolean isOptional = false;
				if (acr instanceof ActorRef) {
					isOptional = ((ActorRef) acr).getRefType()==ReferenceType.OPTIONAL;
				}
				
				EObject parent = (EObject) getBusinessObjectForPictogramElement(containerShape.getContainer());
				boolean inherited = isInherited(acr, parent);
				Color lineColor = isOptional? manageColor(OPTIONAL_COLOR) : manageColor(inherited?INHERITED_COLOR:LINE_COLOR);
				createRefFigure(acr, getDiagram(), containerShape, (Rectangle)containerShape.getGraphicsAlgorithm(), lineColor, manageColor(BACKGROUND));
			}
			
			@Override
			public boolean hasDoneChanges() {
				return doneChanges;
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
				boolean autoSave = store.getBoolean(PreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
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
				GraphicsAlgorithm invisibleRect = containerShape.getGraphicsAlgorithm();
				int borderShapeId = 0;
				
				String reason = "";
				
				// check replicated
				if(acr instanceof ActorRef){
					if(((ActorRef)acr).getSize()!=1){
						if(invisibleRect.getGraphicsAlgorithmChildren().size() < 3)
							reason += "ActorRef got replicated";
						else
							borderShapeId = 1;
					} else {
						if(invisibleRect.getGraphicsAlgorithmChildren().size() > 2){
							reason += "ActorRef is not replicated anymore";
							borderShapeId = 1;
						}
					}
				}
				
				// check if ref still owned/inherited anymore
				Object containerBo = getBusinessObjectForPictogramElement(containerShape);
				if (containerBo instanceof ActorClass) {
					ActorClass ac = (ActorClass) containerBo;
					boolean found = false;
					do {
						if (ac==acr.eContainer())
							found = true;
						ac = ac.getBase();
					}
					while (!found && ac!=null);
					
					if (!found)
						reason += "Ref not inherited anymore\n";
				}
				
				// check sub structure hint
				{
					boolean hasSubStruct = hasSubStructure(acr);
					if (!invisibleRect.getGraphicsAlgorithmChildren().isEmpty()) {
						GraphicsAlgorithm borderRect = invisibleRect.getGraphicsAlgorithmChildren().get(borderShapeId);
						if (!borderRect.getGraphicsAlgorithmChildren().isEmpty()) {
							GraphicsAlgorithm hint = borderRect.getGraphicsAlgorithmChildren().get(0);
							if (hasSubStruct && !hint.getLineVisible())
								reason += "state has sub structure now\n";
							if (!hasSubStruct && hint.getLineVisible())
								reason += "state has no sub structure anymore\n";
						}
					}
				}
				
				// check class name
				if (!containerShape.getChildren().isEmpty()) {
					GraphicsAlgorithm ga = containerShape.getChildren().get(0).getGraphicsAlgorithm();
					if (ga instanceof Text) {
						if (bo instanceof ActorContainerRef) {
							String label = RoomNameProvider.getRefLabelName((ActorContainerRef) bo);
							if (!((Text)ga).getValue().equals(label))
								reason += "Class name is out of date\n";
						}
					}
				}
				
				// check replicated label
				if(acr instanceof ActorRef && ((ActorRef)acr).getSize()!=1){
					if(containerShape.getChildren().size() >= 2){
						GraphicsAlgorithm ga = containerShape.getChildren().get(1).getGraphicsAlgorithm();
						if (ga instanceof Text) {
							String value = ((Text)ga).getValue();
							if (((ActorRef)acr).getSize()==-1) {
								if (!value.equals("*"))
									reason += "multiciply changed";
							}
							else if(!value.equals(((ActorRef)acr).getSize()+""))
								reason += "multiciply changed";
						}
					}
				}
				
				// check interface ports and spps added to model not present in diagram
				{
					ActorContainerClass acc = (acr instanceof ActorRef)?((ActorRef)acr).getType():((SubSystemRef)acr).getType();
					List<InterfaceItem> interfaceItems = RoomHelpers.getInterfaceItems(acc, true);
					List<InterfaceItem> presentItems = SupportUtil.getInterfaceItems(containerShape, fp);
					int missing = 0;
					for (InterfaceItem interfaceItem : interfaceItems) {
						if (!presentItems.contains(interfaceItem))
							++missing;
					}
					if (missing>0)
						reason += missing+" interface item(s) missing\n";
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
				int borderRectId = 0;
				
				if(context instanceof PositionUpdateContext)
					setPosition(acr, containerShape, (PositionUpdateContext) context);
				
				// check replicated
				if(acr instanceof ActorRef){
					if(((ActorRef)acr).getSize()!=1){
						if(invisibleRect.getGraphicsAlgorithmChildren().size() < 3){
							
							IGaService gaService = Graphiti.getGaService();
							int width = invisibleRect.getWidth()-2*MARGIN;
							int height = invisibleRect.getHeight()-2*MARGIN;
							Color lineColor = manageColor(isInherited(acr, acr.eContainer())?INHERITED_COLOR:LINE_COLOR);
							
							Rectangle replRect = gaService.createRectangle(invisibleRect);
							replRect.setForeground(lineColor);
							replRect.setBackground(manageColor(BACKGROUND));
							replRect.setLineWidth(LINE_WIDTH);
							gaService.setLocationAndSize(replRect, MARGIN+REPLICATED_RECT_OFFSET, MARGIN-REPLICATED_RECT_OFFSET, width, height);
							invisibleRect.getGraphicsAlgorithmChildren().move(0, replRect);
							
							Rectangle sizeFrame = gaService.createRectangle(invisibleRect);
							sizeFrame.setForeground(lineColor);
							sizeFrame.setBackground(manageColor(BACKGROUND));
							sizeFrame.setLineWidth(LINE_WIDTH);
							gaService.setLocationAndSize(sizeFrame, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
							invisibleRect.getGraphicsAlgorithmChildren().move(2, sizeFrame);
							
							Shape labelShape = Graphiti.getPeCreateService().createShape(containerShape, false);
							Integer size = ((ActorRef)acr).getSize();
							String txt = (size==-1)?"*":size.toString();
							Text label = gaService.createDefaultText(getDiagram(), labelShape, txt);
							label.setForeground(lineColor);
							label.setBackground(lineColor);
							label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
							label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
							gaService.setLocationAndSize(label, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
							containerShape.getChildren().move(1, labelShape);
						}
						borderRectId = 1;
					} else {
						if(invisibleRect.getGraphicsAlgorithmChildren().size() > 2){
							EcoreUtil.delete(invisibleRect.getGraphicsAlgorithmChildren().get(2), true);
							EcoreUtil.delete(invisibleRect.getGraphicsAlgorithmChildren().get(0), true);
							EcoreUtil.delete(containerShape.getChildren().get(1), true);
						}
					}
				}
				{
					if (!invisibleRect.getGraphicsAlgorithmChildren().isEmpty()) {
						GraphicsAlgorithm borderRect = invisibleRect.getGraphicsAlgorithmChildren().get(borderRectId);
						updateSubStructureHint(acr, (Rectangle) borderRect);
					}
				}

				updateLabel(acr, context.getPictogramElement());
				
				GraphicsAlgorithm innerRect = containerShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(borderRectId);
				IPositionProvider positionProvider = null;
				if(context instanceof PositionUpdateContext){
					positionProvider = ((PositionUpdateContext)context).getPositionProvider();
					positionProvider = positionProvider.setNewParent(acr, DiagramUtil.getPosAndSize(invisibleRect), DiagramUtil.getPosAndSize(innerRect));
				}
				
				Map<EObject, Shape> present = getChildrenShapesForBoClass(containerShape, RoomPackage.Literals.INTERFACE_ITEM);
				ActorContainerClass acc = (acr instanceof ActorRef)?((ActorRef)acr).getType():((SubSystemRef)acr).getType();
				List<InterfaceItem> expected = new ArrayList<InterfaceItem>(RoomHelpers.getInterfaceItems(acc, true));
				
				expected.removeAll(present.keySet());
				Map<EObject, Shape> newShapes = addShapesInitial(expected, containerShape);
				
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
					defaultPP = defaultPP.setNewParent(acr, DiagramUtil.getPosAndSize(invisibleRect), DiagramUtil.getPosAndSize(innerRect));
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
				GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();
				Object bo = getBusinessObjectForPictogramElement(containerShape);
				
				if(bo instanceof ActorRef && ((ActorRef)bo).getSize() != 1)
					resizeChildrenInterfaceItems(context, containerGa.getGraphicsAlgorithmChildren().get(1));
				else
					resizeChildrenInterfaceItems(context, containerGa.getGraphicsAlgorithmChildren().get(0));
				
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
						// calc mid point & align to inner rect
						int midX = childPos.getX() + childPos.getW()/2 - innerRectPos.getX();
						int midY = childPos.getY() + childPos.getH()/2 - innerRectPos.getY();
						// scale
						midX = (int) (sx*midX);
						midY = (int) (sy*midY);
						// first step reverse
						midX = midX - childPos.getW()/2 + innerRectPos.getX();
						midY = midY - childPos.getH()/2 + innerRectPos.getY();
						
						Graphiti.getGaService().setLocation(childGa, midX, midY);
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

		protected static void updateSubStructureHint(ActorContainerRef acr, GraphicsAlgorithm borderRect) {
			
			boolean hasSubStructure = hasSubStructure(acr);
			GraphicsAlgorithm hint = borderRect.getGraphicsAlgorithmChildren().get(0);
			hint.setLineVisible(hasSubStructure);
			hint = borderRect.getGraphicsAlgorithmChildren().get(1);
			hint.setLineVisible(hasSubStructure);
		}

		private static void updateLabel(ActorContainerRef acr, PictogramElement pe) {
			ContainerShape container = (ContainerShape)pe;
			
			// TODO: identify children properly
			if (!container.getChildren().isEmpty()) {
				GraphicsAlgorithm actorLabel = container.getChildren().get(0).getGraphicsAlgorithm();
				if (actorLabel instanceof Text)
					((Text)actorLabel).setValue(RoomNameProvider.getRefLabelName(acr));
				
				if(acr instanceof ActorRef && ((ActorRef)acr).getSize()!=1){
					if(container.getChildren().size()>1){
						GraphicsAlgorithm replLabel = container.getChildren().get(1).getGraphicsAlgorithm();
						if (replLabel instanceof Text)
							((Text)replLabel).setValue(((ActorRef)acr).getSize()+"");
					}
				}
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
            return new GraphicsAlgorithm[] { rectangle };
		}
		
		@Override
		public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();

            GraphicsAlgorithm rectangle =
                invisible.getGraphicsAlgorithmChildren().get(0);
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
	
	private static void createRefFigure(ActorContainerRef ar,
			Diagram diagram, ContainerShape containerShape, final Rectangle invisibleRectangle,
			Color lineColor, Color bgColor) {
		
		invisibleRectangle.getGraphicsAlgorithmChildren().clear();
		if (!containerShape.getChildren().isEmpty()) {
			// potentially there are two text labels which we remove before re-creating
			Shape shape = containerShape.getChildren().get(0);
			if (shape.getGraphicsAlgorithm() instanceof Text)
				containerShape.getChildren().remove(0);
			shape = containerShape.getChildren().get(0);
			if (shape.getGraphicsAlgorithm() instanceof Text)
				containerShape.getChildren().remove(0);
		}

		int width = invisibleRectangle.getWidth()-2*MARGIN;
		int height = invisibleRectangle.getHeight()-2*MARGIN;
		
		IGaService gaService = Graphiti.getGaService();
		if (ar instanceof ActorRef && ((ActorRef)ar).getSize()!=1) {
			Rectangle rect = gaService.createRectangle(invisibleRectangle);
			rect.setForeground(lineColor);
			rect.setBackground(bgColor);
			rect.setLineWidth(LINE_WIDTH);
			gaService.setLocationAndSize(rect, MARGIN+REPLICATED_RECT_OFFSET, MARGIN-REPLICATED_RECT_OFFSET, width, height);
		}

		Rectangle borderRect = gaService.createRectangle(invisibleRectangle);
		borderRect.setForeground(lineColor);
		borderRect.setBackground(bgColor);
		borderRect.setLineWidth(LINE_WIDTH);
		gaService.setLocationAndSize(borderRect, MARGIN, MARGIN, width, height);

		//hatchRectangle(borderRect, lineColor);
		
		if (ar instanceof ActorRef && ((ActorRef)ar).getSize()!=1) {
			Rectangle sizeFrame = gaService.createRectangle(invisibleRectangle);
			sizeFrame.setForeground(lineColor);
			sizeFrame.setBackground(bgColor);
			sizeFrame.setLineWidth(LINE_WIDTH);
			gaService.setLocationAndSize(sizeFrame, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
		}
		
		addSubStructureHint(ar, borderRect, lineColor);
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// anchor for layer connections
		if (containerShape.getAnchors().isEmpty()) {
			ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
			anchor.setReferencedGraphicsAlgorithm(borderRect);
		}
		else {
			// we just set the referenced GA
			containerShape.getAnchors().get(0).setReferencedGraphicsAlgorithm(borderRect);
		}
		
		// the first child shape is the label
		{
			Shape labelShape = peCreateService.createShape(containerShape, false);
			Text label = gaService.createDefaultText(diagram, labelShape, RoomNameProvider.getRefLabelName(ar));
			label.setForeground(lineColor);
			label.setBackground(lineColor);
			label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			gaService.setLocationAndSize(label, MARGIN, MARGIN, width, height);
		}
		
		if (ar instanceof ActorRef && ((ActorRef)ar).getSize()!=1) {
			Shape labelShape = peCreateService.createShape(containerShape, false);
			Integer size = ((ActorRef)ar).getSize();
			String txt = (size==-1)?"*":size.toString();
			Text label = gaService.createDefaultText(diagram, labelShape, txt);
			label.setForeground(lineColor);
			label.setBackground(lineColor);
			label.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			label.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			gaService.setLocationAndSize(label, MARGIN+width-SIZE_FRAME_SIZE, MARGIN, SIZE_FRAME_SIZE, SIZE_FRAME_SIZE);
		}
	}

	private static void hatchRectangle(Rectangle borderRect, Color lc) {
		int x0=0, y0=0;
		int x1=0, y1=0;
		int step=15;
		boolean down0=true;
		boolean right1=true;
		int width = borderRect.getWidth();
		int height = borderRect.getHeight();
		
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
			
			Polyline line = gaService.createPlainPolyline(borderRect, new int[] {x0, y0, x1, y1});
			line.setForeground(lc);
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
	
	private static void addSubStructureHint(ActorContainerRef acr,
			Rectangle borderRect, Color lineColor) {
		
		int x = borderRect.getWidth()-35;
		int y = borderRect.getHeight()-30;
		IGaService gaService = Graphiti.getGaService();
		Rectangle hint1 = gaService.createRectangle(borderRect);
		hint1.setForeground(lineColor);
		hint1.setFilled(false);
		hint1.setLineWidth(LINE_WIDTH);
		gaService.setLocationAndSize(hint1, x+5, y, 20, 10);
		Rectangle hint2 = gaService.createRectangle(borderRect);
		hint2.setForeground(lineColor);
		hint2.setFilled(false);
		hint2.setLineWidth(LINE_WIDTH);
		gaService.setLocationAndSize(hint2, x, y+15, 20, 10);

		if (!hasSubStructure(acr)) {
			hint1.setLineVisible(false);
			hint2.setLineVisible(false);
		}
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
