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
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.base.support.NoResizeFeature;
import org.eclipse.etrice.ui.structure.DiagramTypeProvider;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.SPPPropertyDialog;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

public class SPPSupport extends InterfaceItemSupport {
	
	private static class FeatureProvider extends InterfaceItemSupport.FeatureProvider {
		
		private static class CreateFeature extends InterfaceItemSupport.FeatureProvider.CreateFeature {
	
			public CreateFeature(IFeatureProvider fp) {
				super(fp, false, "SPP", "create SPP");
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_SPP;
			}
	
			@Override
			public Object[] doCreate(ICreateContext context) {
				ActorContainerClass acc = (ActorContainerClass) context.getTargetContainer().getLink().getBusinessObjects().get(0);

				// create SPP
		        SPP spp = RoomFactory.eINSTANCE.createSPP();
		        spp.setName(SupportUtil.getInstance().getRoomUtil().getUniqueName("spp", acc));
				
				acc.getServiceProvisionPoints().add(spp);
		        
		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        IScope scope = scopeProvider.getScope(spp.eContainer().eContainer(), RoomPackage.eINSTANCE.getSAP_Protocol());
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		        SPPPropertyDialog dlg = new SPPPropertyDialog(shell, spp, scope, true, false);
				if (dlg.open()==Window.OK) {
			        // do the add
			        addGraphicalRepresentation(context, spp);
		
			        // return newly created business object(s)
			        return new Object[] { spp };
				}
				
				return null;
			}
		}
		
		private class AddFeature extends InterfaceItemSupport.FeatureProvider.AddFeature {
	
			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			protected String getItemKind(InterfaceItem item) {
				if (item instanceof SPP)
					return getSPPKind((SPP)item);
				
				return "";
			}

			@Override
			protected void createItemFigure(InterfaceItem item,
					boolean refitem, ContainerShape containerShape,
					GraphicsAlgorithm invisibleRectangle, Color darkColor,
					Color brightDolor) {
				
				if (item instanceof SPP)
					createSPPFigure((SPP) item, refitem, containerShape, invisibleRectangle, darkColor, brightDolor);
			}
	
		}
	
		private static class PropertyFeature extends InterfaceItemSupport.FeatureProvider.PropertyFeature {

			public PropertyFeature(IFeatureProvider fp) {
				super(fp, "Edit SPP...", "Edit SPP Properties");
			}

			@Override
			public boolean canExecute(ICustomContext context) {
				if (!super.canExecute(context))
					return false;
				
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1 && pes[0] instanceof ContainerShape) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					return (bo instanceof SPP);
				}
				return false;
			}

			@Override
			public boolean doExecute(ICustomContext context) {
				SPP spp = (SPP) getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
				boolean refport = isRefItem(context.getPictogramElements()[0]);
				
		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        IScope scope = scopeProvider.getScope(spp.eContainer().eContainer(), RoomPackage.eINSTANCE.getSAP_Protocol());
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				SPPPropertyDialog dlg = new SPPPropertyDialog(shell, spp, scope, false, refport);
				if (dlg.open()==Window.OK){
					updateSPPFigure(spp, context.getPictogramElements()[0], manageColor(DARK_COLOR), manageColor(BRIGHT_COLOR));
					
					return true;
				}
				
				return false;
			}
			
		}
		
		private class UpdateFeature extends InterfaceItemSupport.FeatureProvider.UpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			protected String getItemKind(InterfaceItem item) {
				if (item instanceof SPP)
					return getSPPKind((SPP)item);
				
				return "";
			}

			@Override
			protected void updateFigure(InterfaceItem item,
					PictogramElement pe, Color dark, Color bright) {
				updateSPPFigure((SPP)item, pe, dark, bright);
			}
			
		}
		
		private static class DeleteFeature extends InterfaceItemSupport.FeatureProvider.DeleteFeature {

			private ArrayList<LayerConnection> external = new ArrayList<LayerConnection>();
			private ArrayList<LayerConnection> internal = new ArrayList<LayerConnection>();
			
			public DeleteFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canDelete(IDeleteContext context) {
				if (!super.canDelete(context))
					return false;

				ContainerShape shape = (ContainerShape) context.getPictogramElement();
				Object bo = getBusinessObjectForPictogramElement(shape);
				if (bo instanceof EObject && ((EObject)bo).eIsProxy())
					return true;
				
				if (!(bo instanceof SPP))
					return false;
				
				return true;
			}

			@Override
			public void delete(IDeleteContext context) {
				// check for bindings first
				external.clear();
				internal.clear();
				SPP spp = (SPP) getBusinessObjectForPictogramElement(context.getPictogramElement());
				StructureClass sc = (StructureClass) spp.eContainer();
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(spp, spp.eResource().getResourceSet());
				for (Setting ref : refs) {
					if (ref.getEObject() instanceof RelaySAPoint || ref.getEObject() instanceof SPPoint) {
						if (ref.getEObject().eContainer().eContainer() instanceof StructureClass
								&& ref.getEObject().eContainer().eContainer()==sc)
							internal.add((LayerConnection) ref.getEObject().eContainer());
						else
							external.add((LayerConnection) ref.getEObject().eContainer());
					}
					else if (ref.getEObject() instanceof ServiceImplementation) {
						MessageDialog.openInformation(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"Delete SPP",
								"This spp cannot be deleted since it is referenced by a service implementation.");
						return;
					}
				}
				if (!external.isEmpty()) {
					boolean proceed = MessageDialog.openQuestion(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Delete SPP",
							"This spp is connected externally.\n"
							+"It can only be deleted if the external layer connections are also deleted.\n\n"
							+"Proceed?");
					if (!proceed)
						return;
				}
				
				super.delete(context);
			}
			
			@Override
			public void preDelete(IDeleteContext context) {
				// delete all bindings
				for (LayerConnection bind: internal) {
					PictogramElement connection = getFeatureProvider().getPictogramElementForBusinessObject(bind);
					DeleteContext ctx = new DeleteContext(connection);
					ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
					IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
					if (deleteFeature!=null)
						deleteFeature.delete(ctx);
				}
				for (LayerConnection bind: external) {
					EcoreUtil.delete(bind);
				}

				super.preDelete(context);
			}
		}
		
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp, fp);
		}
		
		@Override
		public ICreateFeature[] getCreateFeatures() {
			return new ICreateFeature[] { new CreateFeature(fp) };
		}
		
		@Override
		public IAddFeature getAddFeature(IAddContext context) {
			return new AddFeature(fp);
		}
	
		@Override
		public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
			return new MoveShapeFeature(fp);
		}
		
		@Override
		public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
			return new NoResizeFeature(fp);
		}
	
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] { new PropertyFeature(fp) };
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			return new UpdateFeature(fp);
		}
		
		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			return new DeleteFeature(fp);
		}

		protected static void createSPPFigure(SPP spp, boolean refspp,
				ContainerShape containerShape,
				GraphicsAlgorithm invisibleRectangle, Color darkColor, Color brightDolor) {

			boolean relay = SupportUtil.getInstance().getValidationUtil().isRelay(spp);
			
			int size = refspp?ITEM_SIZE_SMALL:ITEM_SIZE;
			int margin = refspp?MARGIN_SMALL:MARGIN;
			int line = refspp?LINE_WIDTH/2:LINE_WIDTH;
			
			Color bg = brightDolor;
			if (refspp) {
				bg = darkColor;
			}
			else {
				if (relay)
					bg = brightDolor;
				else
					bg = darkColor;
			}

			IGaService gaService = Graphiti.getGaService();
			
			// TODOHRR: depicting SPPs as diamond using polygon didn't work
//			int s2 = margin-size/2;
//			int xy[] = new int[] { s2, 0, margin, s2, s2, margin, 0, s2};
//			Polygon rect = gaService.createPolygon(invisibleRectangle, xy);
//			rect.setForeground(darkColor);
//			rect.setBackground(bg);
//			rect.setLineWidth(line);
//			gaService.setLocation(rect, s2, s2);
			//Rectangle rect = gaService.createRectangle(invisibleRectangle);
			
			Ellipse rect = gaService.createEllipse(invisibleRectangle);
			rect.setForeground(darkColor);
			rect.setBackground(bg);
			rect.setLineWidth(line);
			gaService.setLocationAndSize(rect, margin-size/2, margin-size/2, size, size);

			if (containerShape.getAnchors().isEmpty()) {
				// here we place our anchor
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
//				FixPointAnchor anchor = peCreateService.createFixPointAnchor(containerShape);
//				anchor.setLocation(gaService.createPoint(xy[0], xy[1]));
//				anchor = peCreateService.createFixPointAnchor(containerShape);
//				anchor.setLocation(gaService.createPoint(xy[2], xy[3]));
//				anchor = peCreateService.createFixPointAnchor(containerShape);
//				anchor.setLocation(gaService.createPoint(xy[4], xy[5]));
//				anchor = peCreateService.createFixPointAnchor(containerShape);
//				anchor.setLocation(gaService.createPoint(xy[6], xy[7]));
				// TODOHRR:  EllipseAnchor would be nice
				ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
				anchor.setReferencedGraphicsAlgorithm(rect);
			}
			else {
				// we just set the referenced GA
				containerShape.getAnchors().get(0).setReferencedGraphicsAlgorithm(rect);
			}
		}

		private static void updateSPPFigure(SPP spp, PictogramElement pe, Color dark, Color bright) {
			ContainerShape container = (ContainerShape)pe;
			
			// we clear the figure and rebuild it
			GraphicsAlgorithm invisibleRect = pe.getGraphicsAlgorithm();
			invisibleRect.getGraphicsAlgorithmChildren().clear();
			
			createSPPFigure(spp, isRefItem(pe), container, invisibleRect, dark, bright);
			
			GraphicsAlgorithm ga = container.getChildren().get(0).getGraphicsAlgorithm();
			if (ga instanceof Text) {
				((Text)ga).setValue(spp.getName());
			}

		}
		
	}

	private class BehaviorProvider extends InterfaceItemSupport.BehaviorProvider {

		public BehaviorProvider(IDiagramTypeProvider dtp) {
			super(dtp);
		}
		
		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
			return new FeatureProvider.PropertyFeature(getDiagramTypeProvider().getFeatureProvider());
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
	
	private FeatureProvider pfp;
	private BehaviorProvider tbp;
	
	public SPPSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
		pfp = new FeatureProvider(dtp,fp);
		tbp = new BehaviorProvider(dtp);
	}
	
	public IFeatureProvider getFeatureProvider() {
		return pfp;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return tbp;
	}
	
	protected static String getSPPKind(SPP spp) {
		String kind = "";
		if (SupportUtil.getInstance().getValidationUtil().isRelay(spp))
			kind += "R";
		return kind;
	}
	
}
