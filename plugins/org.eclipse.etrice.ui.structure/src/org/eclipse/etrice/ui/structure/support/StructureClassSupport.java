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

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.commands.RoomOpeningHelper;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.etrice.ui.common.base.support.BaseToolBehaviorProvider;
import org.eclipse.etrice.ui.common.base.support.CantRemoveFeature;
import org.eclipse.etrice.ui.common.base.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.common.commands.ChangeDiagramInputJob;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class StructureClassSupport {

	public static final int MARGIN = 40;

	private static final int LINE_WIDTH = 4;
	public static final int DEFAULT_SIZE_X = 800;
	public static final int DEFAULT_SIZE_Y = 500;
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
					rect.setLineVisible(false);
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
						final ActorClass ac = (ActorClass) bo;
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				        shell.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								RoomOpeningHelper.openBehavior(ac);
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
		
		private class OpenClassModel extends AbstractCustomFeature {

			public OpenClassModel(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Open Class Model";
			}

			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					Object bo = getBusinessObjectForPictogramElement(pes[0]);
					if (bo instanceof StructureClass) {
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
					if (bo instanceof StructureClass) {
						final StructureClass ac = (StructureClass) bo;
				        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				        shell.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								RoomOpeningHelper.showInTextualEditor(ac);
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

		private class ReconnectToModel extends AbstractCustomFeature {

			public ReconnectToModel(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public void execute(ICustomContext context) {
				DiagramEditorBase editor = (DiagramEditorBase) getDiagramBehavior().getDiagramContainer();

				Job job = new ChangeDiagramInputJob("Change input for " + getDiagram().getName(), editor);
				job.setUser(true);
				job.schedule();
			}

			@Override
			public boolean canExecute(ICustomContext context) {
				return true;
			}

			@Override
			public String getName() {
				return "Reconnect Diagram to Model";
			}



			@Override
			public boolean hasDoneChanges() {
				return false;
			}

			@Override
			public boolean isAvailable(IContext context) {
				Object bo = fp.getBusinessObjectForPictogramElement(getDiagram());

				return bo instanceof EObject && ((EObject)bo).eIsProxy();
			}
		}

		private class ResizeFeature extends DefaultResizeShapeFeature{

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
							if (((ActorClass) sc).getInternalPorts().contains(childBo))
								onInterface = false;
						}
					}
				}
				return onInterface;
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
			return new StructureClassUpdate(fp);
		}

		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			return new ICustomFeature[] {
					new OpenBehaviorDiagram(fp),
					new OpenClassModel(fp),
					new ReconnectToModel(fp)}; // referenced by index below
		}

		@Override
		public IResizeShapeFeature getResizeShapeFeature(
				IResizeShapeContext context) {
			return new ResizeFeature(fp);
		}

		@Override
		public IRemoveFeature getRemoveFeature(IRemoveContext context) {
			return new CantRemoveFeature(fp);
		}

		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			return new DeleteFeature(fp);
		}
	}

	private class BehaviorProvider extends BaseToolBehaviorProvider {

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
                invisible.getGraphicsAlgorithmChildren().get(1);
            return rectangle;
		}

		@Override
		public IContextButtonPadData getContextButtonPad(
				IPictogramElementContext context) {
			IContextButtonPadData data = super.getContextButtonPad(context);

			ICustomContext customContext = new CustomContext();
			ICustomFeature reconnectToModel = afp.getCustomFeatures(customContext)[2];
			if(reconnectToModel.isAvailable(customContext)){
				IContextButtonEntry entry = new ContextButtonEntry(reconnectToModel, customContext);
				entry.setIconId(IPlatformImageConstants.IMG_ECLIPSE_QUICKASSIST);
				data.getDomainSpecificContextButtons().add(entry);
			}

			return data;
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

}
