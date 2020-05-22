/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.ui.structure.DiagramTypeProvider;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.PortPropertyDialog;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
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

public class PortSupport extends InterfaceItemSupport {
	
	private static final int REPL_OFFSET = ITEM_SIZE/8;
	private static final int REPL_OFFSET_SMALL = ITEM_SIZE_SMALL/8;
	
	private static class FeatureProvider extends InterfaceItemSupport.FeatureProvider {
		
		private class CreateFeature extends InterfaceItemSupport.FeatureProvider.CreateFeature {
	
			public CreateFeature(IFeatureProvider fp, boolean internal) {
				super(fp, internal, internal?"Internal Port":"Interface Port", internal?"create internal Port":"create interface Port");
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_PORT;
			}
	
			@Override
			public Object[] doCreate(ICreateContext context) {
				ActorContainerClass acc = (ActorContainerClass) context.getTargetContainer().getLink().getBusinessObjects().get(0);

				// create Port
		        Port port = RoomFactory.eINSTANCE.createPort();
		        port.setName(SupportUtil.getInstance().getRoomUtil().getUniqueName("p", acc));
		        ExternalPort xp = null;
		        
		        if (acc instanceof ActorClass) {
		        	ActorClass ac = (ActorClass) acc;
		        	if (internal)
		        		ac.getInternalPorts().add(port);
		        	else {
		        		ac.getInterfacePorts().add(port);
		        		
						xp = RoomFactory.eINSTANCE.createExternalPort();
						xp.setInterfacePort(port);
						ac.getExternalPorts().add(xp);
		        	}
		        }
		        else if (acc instanceof SubSystemClass) {
		        	SubSystemClass ssc = (SubSystemClass) acc;
		        	ssc.getRelayPorts().add(port);
		        }
		        else {
		        	assert(false): "ActorClass or SubSystemClass expected";
		        }
		        
		        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
		        IScope scope = scopeProvider.getScope(port, RoomPackage.eINSTANCE.getInterfaceItem_Protocol());
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		        PortPropertyDialog dlg = new PortPropertyDialog(shell, port, scope, acc, true, false, internal);
				if (dlg.open()==Window.OK) {
					// do the add
					addGraphicalRepresentation(context, port);
					
					// return newly created business object(s)
					return new Object[] { port };
				}

				return null;
			}
	        
		}
		
		private static class AddFeature extends InterfaceItemSupport.FeatureProvider.AddFeature {
	
			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			protected String getItemKind(InterfaceItem item) {
				if (item instanceof Port)
					return getPortKind((Port) item);
				
				return "";
			}

			@Override
			protected void createItemFigure(InterfaceItem item,
					boolean refitem, ContainerShape containerShape,
					GraphicsAlgorithm invisibleRectangle, Color darkColor,
					Color brightDolor) {
				
				if (item instanceof Port)
					createPortFigure((Port) item, refitem, containerShape, invisibleRectangle, darkColor, brightDolor);
			}
	
		}
		
		private static class PropertyFeature extends InterfaceItemSupport.FeatureProvider.PropertyFeature {

			public PropertyFeature(IFeatureProvider fp) {
				super(fp, "Edit Port...", "Edit Port Properties");
			}

			@Override
			public boolean canExecute(ICustomContext context) {
				if (!super.canExecute(context))
					return false;
				
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1 && pes[0] instanceof ContainerShape) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					return (bo instanceof Port);
				}
				return false;
			}
			
			@Override
			public boolean doExecute(ICustomContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
				if (bo instanceof Port) {
					Port port = (Port) bo;
					ActorContainerClass acc = (ActorContainerClass)port.eContainer();
					boolean internal = isInternal(port);
					boolean refport = isRefItem(context.getPictogramElements()[0]);
					
			        IScopeProvider scopeProvider = ((DiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider()).getScopeProvider();
			        IScope scope = scopeProvider.getScope(port.eContainer().eContainer(), RoomPackage.eINSTANCE.getInterfaceItem_Protocol());
			        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			        PortPropertyDialog dlg = new PortPropertyDialog(shell, port, scope, acc, false, refport, internal);
					if (dlg.open()==Window.OK){
						updatePortFigure(port, context.getPictogramElements()[0], manageColor(DARK_COLOR), manageColor(BRIGHT_COLOR));
						String kind = getPortKind(port);
						Graphiti.getPeService().setPropertyValue(context.getPictogramElements()[0], PROP_KIND, kind);
						
						return true;
					}
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
				if (item instanceof Port)
					return getPortKind((Port)item);
				
				return "";
			}

			@Override
			protected void updateFigure(InterfaceItem item,
					PictogramElement pe, Color dark, Color bright) {
				updatePortFigure((Port)item, pe, dark, bright);
			}
			
		}
		
		private static class DeleteFeature extends InterfaceItemSupport.FeatureProvider.DeleteFeature {

			private ArrayList<Binding> external = new ArrayList<Binding>();
			private ArrayList<Binding> internal = new ArrayList<Binding>();
			
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
				
				if (!(bo instanceof Port))
					return false;
				
				return true;
			}

			@Override
			public void delete(IDeleteContext context) {
				// check for bindings first
				external.clear();
				internal.clear();
				Port port = (Port) getBusinessObjectForPictogramElement(context.getPictogramElement());
				StructureClass sc = (StructureClass) port.eContainer();
				Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(port, port.eResource().getResourceSet());
				for (Setting ref : refs) {
					if (ref.getEObject() instanceof BindingEndPoint) {
						if (ref.getEObject().eContainer().eContainer() instanceof StructureClass
								&& ref.getEObject().eContainer().eContainer()==sc)
							internal.add((Binding) ref.getEObject().eContainer());
						else
							external.add((Binding) ref.getEObject().eContainer());
					}
					else if (ref.getEObject() instanceof MessageFromIf) {
						MessageDialog.openInformation(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"Delete Port",
								"This port cannot be deleted since it is referenced from the state machine.");
						return;
					}
				}
				if (!external.isEmpty()) {
					boolean proceed = MessageDialog.openQuestion(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Delete Port",
							"This port is connected externally.\n"
							+"It can only be deleted if the external bindings are also deleted.\n\n"
							+"Proceed?");
					if (!proceed)
						return;
				}
				
				super.delete(context);
			}
			
			@Override
			public void preDelete(IDeleteContext context) {
				// delete all bindings
				for (Binding bind: internal) {
					PictogramElement connection = getFeatureProvider().getPictogramElementForBusinessObject(bind);
					DeleteContext ctx = new DeleteContext(connection);
					ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
					IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
					if (deleteFeature!=null)
						deleteFeature.delete(ctx);
				}
				for (Binding bind: external) {
					EcoreUtil.delete(bind);
				}

				super.preDelete(context);
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.graphiti.ui.features.DefaultDeleteFeature#deleteBusinessObject(java.lang.Object)
			 */
			@Override
			protected void deleteBusinessObject(Object bo) {
				if (bo instanceof Port) {
					Port port = (Port) bo;
					if (port.eContainer() instanceof ActorClass) {
						ExternalPort external = null;
						ActorClass ac = (ActorClass) port.eContainer();
						for (ExternalPort extp : ac.getExternalPorts()) {
							if (extp.getInterfacePort()==port) {
								external = extp;
								break;
							}
						}
						if (external!=null)
							super.deleteBusinessObject(external);
					}
				}
				super.deleteBusinessObject(bo);
			}
		}
		
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp, fp);
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
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			List<ICustomFeature> features = new ArrayList<>();
			features.add(new PropertyFeature(fp));
			Arrays.stream(super.getCustomFeatures(context)).forEach(e -> features.add(e));
			
			return features.toArray(new ICustomFeature[0]);
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			return new UpdateFeature(fp);
		}

		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			return new DeleteFeature(fp);
		}
		
		protected static void createPortFigure(Port port, boolean refport,
				ContainerShape containerShape,
				GraphicsAlgorithm invisibleRectangle, Color darkColor, Color brightDolor) {

			boolean relay = SupportUtil.getInstance().getRoomHelpers().isRelay(port);
			
			int size = refport?ITEM_SIZE_SMALL:ITEM_SIZE;
			int margin = refport?MARGIN_SMALL:MARGIN;
			int offset = refport?REPL_OFFSET_SMALL:REPL_OFFSET;
			int line = refport?LINE_WIDTH/2:LINE_WIDTH;
			
			Color bg = brightDolor;
			if (refport) {
				if (port.isConjugated())
					bg = brightDolor;
				else
					bg = darkColor;
			}
			else {
				if (!port.isConjugated() && !relay)
					bg = darkColor;
				else
					bg = brightDolor;
			}

			IGaService gaService = Graphiti.getGaService();
			if (port.isReplicated()) {
				Rectangle rect = gaService.createRectangle(invisibleRectangle);
				rect.setForeground(darkColor);
				rect.setBackground(brightDolor);
				rect.setLineWidth(line);
				gaService.setLocationAndSize(rect, margin-size/2+offset, margin-size/2-offset, size, size);
			}
			
			Rectangle rect = gaService.createRectangle(invisibleRectangle);
			rect.setForeground(darkColor);
			rect.setBackground(bg);
			if (!refport && relay && !port.isConjugated())
				rect.setLineWidth(4*line);
			else
				rect.setLineWidth(line);
			gaService.setLocationAndSize(rect, margin-size/2, margin-size/2, size, size);

			if (containerShape.getAnchors().isEmpty()) {
				// here we place our anchor
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
				anchor.setReferencedGraphicsAlgorithm(rect);
			}
			else {
				// we just set the referenced GA
				containerShape.getAnchors().get(0).setReferencedGraphicsAlgorithm(rect);
			}
			
			if (!refport) {
				if (port.isConjugated() || !relay) {
					// we have more details
					
					if (relay) {
						// conjugated relay
						Rectangle inset = gaService.createRectangle(invisibleRectangle);
						inset.setForeground(darkColor);
						inset.setBackground(darkColor);
						inset.setLineWidth(LINE_WIDTH);
						gaService.setLocationAndSize(inset, margin-size/4, margin-size/4, size/2, size/2);
					}
					else {
						Color fill = port.isConjugated()?darkColor:brightDolor;
						
						Ellipse inset = gaService.createEllipse(invisibleRectangle);
						inset.setForeground(fill);
						inset.setBackground(fill);
						inset.setLineWidth(LINE_WIDTH);
						gaService.setLocationAndSize(inset, margin-size/4, margin-size/4, size/2, size/2);
					}
				}
			}
		}

		private static void updatePortFigure(Port port, PictogramElement pe, Color dark, Color bright) {
			ContainerShape container = (ContainerShape)pe;
			
			// we clear the figure and rebuild it
			GraphicsAlgorithm invisibleRect = pe.getGraphicsAlgorithm();
			invisibleRect.getGraphicsAlgorithmChildren().clear();

			boolean refport = isRefItem(pe);
			createPortFigure(port, refport, container, invisibleRect, dark, bright);
			
			GraphicsAlgorithm ga = container.getChildren().get(0).getGraphicsAlgorithm();
			if (ga instanceof Text) {
				((Text)ga).setValue(port.getName());
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
				// our port has a chopbox anchor
				anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
			}
			ccc.setSourceAnchor(anchor);
			
			ContextButtonEntry button = new ContextButtonEntry(null, context);
			button.setText("Create Binding");
			button.setIconId(ImageProvider.IMG_BINDING);
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
	
	public PortSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
		pfp = new FeatureProvider(dtp,fp);
		tbp = new BehaviorProvider(dtp);
	}
	
	public IFeatureProvider getFeatureProvider() {
		return pfp;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return tbp;
	}
	
	private static String getPortKind(Port port) {
		String kind = "";
		if (port.isConjugated())
			kind += "C";
		if (SupportUtil.getInstance().getRoomHelpers().isRelay(port))
			kind += "R";
		if (port.isReplicated())
			kind += "M";
		return kind;
	}
}
