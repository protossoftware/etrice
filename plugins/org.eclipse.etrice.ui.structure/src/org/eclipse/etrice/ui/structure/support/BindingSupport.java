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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.base.support.BaseToolBehaviorProvider;
import org.eclipse.etrice.ui.common.base.support.CantRemoveFeature;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCreateConnectionFeature;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCustomFeature;
import org.eclipse.etrice.ui.common.base.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.structure.ImageProvider;
import org.eclipse.etrice.ui.structure.dialogs.SubProtocolSelectionDialog;
import org.eclipse.etrice.ui.structure.support.context.ConnectionUpdateContext;
import org.eclipse.etrice.ui.structure.support.context.InitialAddConnectionContext;
import org.eclipse.etrice.ui.structure.support.feature.ConnectionUpdateFeature;
import org.eclipse.etrice.ui.structure.support.provider.ConnectionProvider;
import org.eclipse.etrice.ui.structure.support.provider.DecorationProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class BindingSupport {

	public static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	public static final IColorConstant INHERITED_COLOR = new ColorConstant(100, 100, 100);

	static class FeatureProvider extends DefaultFeatureProvider {
		
		private class CreateFeature extends ChangeAwareCreateConnectionFeature {
			
			public CreateFeature(IFeatureProvider fp) {
				super(fp, "Binding", "create Binding");
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_BINDING;
			}
	
			@Override
			public boolean canCreate(ICreateConnectionContext context) {
				IFeatureProvider featureProvider = getFeatureProvider();
				Port src = SupportUtil.getInstance().getPort(context.getSourceAnchor(), featureProvider);
				Port tgt = SupportUtil.getInstance().getPort(context.getTargetAnchor(), featureProvider);
				ActorContainerRef srcRef = SupportUtil.getInstance().getRef(context.getSourceAnchor(), featureProvider);
				
				if (src==null || tgt==null) {
					return false;
				}
				
				StructureClass ac = SupportUtil.getInstance().getParent(context, featureProvider);
				if (ac==null) {
					return false;
				}
				
				ActorContainerRef tgtRef = SupportUtil.getInstance().getRef(context.getTargetAnchor(), featureProvider);
				
				return SupportUtil.getInstance().getValidationUtil().isConnectable(src, srcRef, null, tgt, tgtRef, null, ac, null, false).isOk();
			}
			
			public boolean canStartConnection(ICreateConnectionContext context) {
				if (context.getSourceAnchor()==null)
					return false;
				
				Port src = SupportUtil.getInstance().getPort(context.getSourceAnchor(), getFeatureProvider());
				boolean canStart = src!=null;
				if (canStart) {
					ActorContainerRef ref = SupportUtil.getInstance().getRef(context.getSourceAnchor(), getFeatureProvider());
					if (ref==null) {
						// this port is local, i.e. owned by the parent itself
						ActorContainerClass acc = (ActorContainerClass) src.eContainer();
						if (!SupportUtil.getInstance().getValidationUtil().isConnectable(src, null, acc).isOk())
							canStart = false;
					}
					else {
						StructureClass acc = (StructureClass) ref.eContainer();
						if (!SupportUtil.getInstance().getValidationUtil().isConnectable(src, ref, acc).isOk())
							canStart = false;
					}
				}

				return canStart;
			}
			
			@Override
			public void attachedToSource(ICreateConnectionContext context) {
				Port src = SupportUtil.getInstance().getPort(context.getSourceAnchor(), getFeatureProvider());
				ActorContainerRef ref = SupportUtil.getInstance().getRef(context.getSourceAnchor(), getFeatureProvider());
				StructureClass sc = SupportUtil.getInstance().getParent(context, getFeatureProvider());
				
				beginHighLightMatches(sc, src, ref);
			}
			
			@Override
			public void canceledAttaching(ICreateConnectionContext context) {
				endHighLightMatches();
			}
			
			@Override
			public void endConnecting() {
				endHighLightMatches();
			}
			
			private void beginHighLightMatches(StructureClass sc, Port src, ActorContainerRef srcRef) {
				if (src==null)
					return;
				
				ContainerShape scContainer = (ContainerShape) getDiagram().getChildren().get(0);
				for (Shape subShape : scContainer.getChildren()) {
					Object bo = getBusinessObjectForPictogramElement(subShape);
					if (bo instanceof Port) {
						if (SupportUtil.getInstance().getValidationUtil().isConnectable(src, srcRef, null, (Port) bo, null, null, sc, null, false).isOk()) {
							DecorationProvider.addAllowedPortShape(subShape);
							getDiagramBehavior().refreshRenderingDecorators(subShape);
						}
					}
					else if (bo instanceof ActorContainerRef) {
						ActorContainerRef tgtRef = (ActorContainerRef) bo;
						for (Shape subSubShape : ((ContainerShape)subShape).getChildren()) {
							bo = getBusinessObjectForPictogramElement(subSubShape);
							if (bo instanceof Port) {
								if (SupportUtil.getInstance().getValidationUtil().isConnectable(src, srcRef, null, (Port) bo, tgtRef, null, sc, null, false).isOk()) {
									DecorationProvider.addAllowedPortShape(subSubShape);
									getDiagramBehavior().refreshRenderingDecorators(subSubShape);
								}
							}
						}
					}
					
				}
			}

			private void endHighLightMatches() {
				DecorationProvider.clearAllowedPortShapes();
				getDiagramBehavior().refresh();
			}
			
			@Override
			protected Connection doCreate(ICreateConnectionContext context) {
				Connection newConnection = null;
				
				endHighLightMatches();
				
				IFeatureProvider featureProvider = getFeatureProvider();
				Port src = SupportUtil.getInstance().getPort(context.getSourceAnchor(), featureProvider);
				Port dst = SupportUtil.getInstance().getPort(context.getTargetAnchor(), featureProvider);
				StructureClass sc = SupportUtil.getInstance().getParent(context, featureProvider);
				if (src!=null && dst!=null && sc!=null) {
					Binding bind = RoomFactory.eINSTANCE.createBinding();
					BindingEndPoint ep1 = RoomFactory.eINSTANCE.createBindingEndPoint();
					ActorContainerRef ar1 = SupportUtil.getInstance().getRef(context.getSourceAnchor(), featureProvider);
					ep1.setPort(src);
					ep1.setActorRef(ar1);
					BindingEndPoint ep2 = RoomFactory.eINSTANCE.createBindingEndPoint();
					ActorContainerRef ar2 = SupportUtil.getInstance().getRef(context.getTargetAnchor(), featureProvider);
					ep2.setPort(dst);
					ep2.setActorRef(ar2);
					bind.setEndpoint1(ep1);
					bind.setEndpoint2(ep2);

					GeneralProtocolClass srcGPC = src.getProtocol();
					GeneralProtocolClass dstGPC = dst.getProtocol();
					if (srcGPC instanceof CompoundProtocolClass || dstGPC instanceof CompoundProtocolClass) {
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
						SubProtocolSelectionDialog dlg = new SubProtocolSelectionDialog(shell, src, ar1, dst, ar2, null, sc);
						if (dlg.open()!=Window.OK)
							return null;
						
						ep1.setSub(dlg.getSelected().getLeft());
						ep2.setSub(dlg.getSelected().getRight());
					}
					
					sc.getBindings().add(bind);
					
					AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
					addContext.setNewObject(bind);
					newConnection = (Connection) featureProvider.addIfPossible(addContext);
				}
				
				return newConnection;
			}
		}
		
		private class AddFeature extends AbstractAddFeature {

			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public boolean canAdd(IAddContext context) {
				if(context.getNewObject() instanceof Binding)
					return true;
				
				return false;
			}

			@Override
			public PictogramElement add(IAddContext context) {
				Binding bind = (Binding) context.getNewObject();

				boolean inherited = isInherited(getDiagram(), bind);
				
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				// CONNECTION WITH POLYLINE
				Connection connection = peCreateService.createFreeFormConnection(getDiagram());
				if(context instanceof InitialAddConnectionContext){
					ConnectionProvider cp = ((InitialAddConnectionContext)context).getConnectionProvider();
					Anchor a1 = cp.getAnchor(bind.getEndpoint1());
					Anchor a2 = cp.getAnchor(bind.getEndpoint2());
					assert(a1 != null && a2 != null) : "start and end anchor must be present";
					connection.setStart(a1);
					connection.setEnd(a2);
				} else {
					IAddConnectionContext addConContext = (IAddConnectionContext) context;
					connection.setStart(addConContext.getSourceAnchor());
					connection.setEnd(addConContext.getTargetAnchor());
				}
				Graphiti.getPeService().setPropertyValue(connection, Constants.TYPE_KEY, Constants.BIND_TYPE);

				IGaService gaService = Graphiti.getGaService();
				Polyline polyline = gaService.createPolyline(connection);
				polyline.setForeground(manageColor(inherited?INHERITED_COLOR:LINE_COLOR));

				// create link and wire it
				link(connection, bind);
				
				// call update
				updatePictogramElement(connection);	

				return connection;
			}
			
		}
		
		private class ReconnectionFeature extends DefaultReconnectionFeature {

			private boolean doneChanges = false;

			public ReconnectionFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canReconnect(IReconnectionContext context) {
				if (!super.canReconnect(context))
					return false;
				
				Binding bind = (Binding) getBusinessObjectForPictogramElement(context.getConnection());
				if (isInherited(getDiagram(), bind))
					return false;
				
				Anchor asrc = context.getConnection().getStart();
				Anchor atgt = context.getConnection().getEnd();
				if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE))
					asrc = context.getNewAnchor();
				else
					atgt = context.getNewAnchor();
				
				IFeatureProvider featureProvider = getFeatureProvider();
				Port src = SupportUtil.getInstance().getPort(asrc, featureProvider);
				Port tgt = SupportUtil.getInstance().getPort(atgt, featureProvider);
				ActorContainerRef srcRef = SupportUtil.getInstance().getRef(asrc, featureProvider);
				
				if (src==null || tgt==null) {
					return false;
				}
				
				StructureClass ac = SupportUtil.getInstance().getParent(getDiagram(), featureProvider);
				if (ac==null) {
					return false;
				}
				
				ActorContainerRef tgtRef = SupportUtil.getInstance().getRef(atgt, featureProvider);
				
				return SupportUtil.getInstance().getValidationUtil().isConnectable(
						src, srcRef, bind.getEndpoint1().getSub(),
						tgt, tgtRef, bind.getEndpoint2().getSub(),
						ac, bind, true).isOk();
			}
			
			@Override
			public void postReconnect(IReconnectionContext context) {
				super.postReconnect(context);

				IFeatureProvider featureProvider = getFeatureProvider();
				Port src = SupportUtil.getInstance().getPort(context.getConnection().getStart(), featureProvider);
				Port dst = SupportUtil.getInstance().getPort(context.getConnection().getEnd(), featureProvider);
				StructureClass sc = SupportUtil.getInstance().getParent(getDiagram(), featureProvider);
				if (src!=null && dst!=null && sc!=null) {
					Binding bind = (Binding) getBusinessObjectForPictogramElement(context.getConnection());
					BindingEndPoint ep1 = RoomFactory.eINSTANCE.createBindingEndPoint();
					ActorContainerRef ar1 = SupportUtil.getInstance().getRef(context.getConnection().getStart(), featureProvider);
					ep1.setPort(src);
					ep1.setActorRef(ar1);
					BindingEndPoint ep2 = RoomFactory.eINSTANCE.createBindingEndPoint();
					ActorContainerRef ar2 = SupportUtil.getInstance().getRef(context.getConnection().getEnd(), featureProvider);
					ep2.setPort(dst);
					ep2.setActorRef(ar2);
					
					GeneralProtocolClass srcGPC = src.getProtocol();
					GeneralProtocolClass dstGPC = dst.getProtocol();
					if (srcGPC != null || dstGPC != null) {
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
						SubProtocolSelectionDialog dlg = new SubProtocolSelectionDialog(shell, src, ar1, dst, ar2, bind, sc);
						if (dlg.open()!=Window.OK)
							return;
						
						ep1.setSub(dlg.getSelected().getLeft());
						ep2.setSub(dlg.getSelected().getRight());
					}
					
					bind.setEndpoint1(ep1);
					bind.setEndpoint2(ep2);

					doneChanges = true;
				}
			}
			
			@Override
			public boolean hasDoneChanges() {
				return doneChanges ;
			}
		}
		
		private class UpdateFeature extends ConnectionUpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			protected boolean canUpdate(EObject bo, PictogramElement pe) {
				return bo instanceof Binding;				
			}
			
			@Override
			protected boolean update(EObject bo, IUpdateContext context) {
				boolean success = super.update(bo, context);
				
				Connection conn = (Connection) context.getPictogramElement();
				if(context instanceof ConnectionUpdateContext){
					ConnectionProvider cp = ((ConnectionUpdateContext) context).getConnectionProvider();
					Binding bind = (Binding)bo;
					Anchor newStart = cp.getAnchor(bind.getEndpoint1());
					Anchor newEnd = cp.getAnchor(bind.getEndpoint2());
					assert(newStart != null && newEnd != null) : "start and end anchor must be not null";
					if(newStart != conn.getStart())
						conn.setStart(newEnd);
					if(newEnd != conn.getEnd())
						conn.setEnd(newEnd);
				}
				
				return success;
			}
		}
		
		private class DeleteFeature extends DeleteWithoutConfirmFeature {

			public DeleteFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canDelete(IDeleteContext context) {
				EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getPictogramElement());
				if (bo instanceof Binding) {
					Binding b = (Binding) bo;
					if (isInherited(getDiagram(), b))
						return false;
				}
				
				return true;
			}
		}
		
		private static class PropertyFeature extends ChangeAwareCustomFeature {

			public PropertyFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Edit Binding...";
			}
			
			@Override
			public String getDescription() {
				return "Edit Binding Properties";
			}

			public boolean canExecute(ICustomContext context) {
				return getBusinessObjectForPictogramElement(context.getPictogramElements()[0]) instanceof Binding;
			}

			@Override
			public boolean doExecute(ICustomContext context) {
				Binding bind = (Binding) getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
				StructureClass sc = (StructureClass) bind.eContainer();
				
		        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				SubProtocolSelectionDialog dlg = new SubProtocolSelectionDialog(
						shell,
						bind.getEndpoint1().getPort(), bind.getEndpoint1().getActorRef(),
						bind.getEndpoint2().getPort(), bind.getEndpoint2().getActorRef(),
						bind, sc);
				
				if (dlg.open()==Window.OK){
					bind.getEndpoint1().setSub(dlg.getSelected().getLeft());
					bind.getEndpoint2().setSub(dlg.getSelected().getRight());
					
					return true;
				}
				
				return false;
			}
			
		}
		
		private IFeatureProvider fp;
		
		public FeatureProvider(IDiagramTypeProvider dtp, IFeatureProvider fp) {
			super(dtp);
			this.fp = fp;
		}

		private boolean isInherited(Diagram diag, Binding b) {
			StructureClass ac = (StructureClass) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag.getChildren().get(0));
			return (b.eContainer()!=ac);
		}
		
		@Override
		public ICreateConnectionFeature[] getCreateConnectionFeatures() {
			return new ICreateConnectionFeature[] { new CreateFeature(fp) };
		}
		
		@Override
		public IAddFeature getAddFeature(IAddContext context) {
			return new AddFeature(fp);
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			return new UpdateFeature(fp);
		}

		@Override
		public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
			return new ReconnectionFeature(fp);
		}
		
		@Override
		public IRemoveFeature getRemoveFeature(IRemoveContext context) {
			return new CantRemoveFeature(fp);
		}
		
		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			return new DeleteFeature(fp);
		}
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] { new PropertyFeature(fp) };
		}
	}
	
	class BehaviorProvider extends BaseToolBehaviorProvider {
		
		@Override
		public Object getToolTip(GraphicsAlgorithm ga) {
			// if this is called we know there is a business object!=null
			PictogramElement pe = ga.getPictogramElement();
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe.eContainer();
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof Binding) {
				Binding bind = (Binding) bo;
				return SupportUtil.getInstance().getRoomNameProvider().getDisplayName(bind);
			}
			
			return super.getToolTip(ga);
		}

		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
			return new FeatureProvider.PropertyFeature(getDiagramTypeProvider().getFeatureProvider());
		}

		public BehaviorProvider(IDiagramTypeProvider dtp) {
			super(dtp);
		}
	}
	
	private FeatureProvider pfp;
	private BehaviorProvider tbp;
	
	public BindingSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
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
