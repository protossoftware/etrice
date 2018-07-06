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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.ArrayList;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.IFSMDialogFactory;
import org.eclipse.etrice.ui.behavior.fsm.dialogs.ITransitionPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMEditor;
import org.eclipse.etrice.ui.behavior.fsm.editor.DecoratorUtil;
import org.eclipse.etrice.ui.behavior.fsm.provider.IInjectorProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.ImageProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.etrice.ui.behavior.fsm.support.util.ModelEditingUtil;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.etrice.ui.common.base.support.CantRemoveFeature;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCreateConnectionFeature;
import org.eclipse.etrice.ui.common.base.support.ChangeAwareCustomFeature;
import org.eclipse.etrice.ui.common.base.support.DeleteWithoutConfirmFeature;
import org.eclipse.etrice.ui.common.base.support.RemoveBendpointsFeature;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.features.impl.DefaultMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Injector;

public class TransitionSupport {

	private static final IColorConstant LINE_COLOR = new ColorConstant(0, 0, 0);
	private static final IColorConstant INHERITED_COLOR = new ColorConstant(100, 100, 100);
	private static final IColorConstant FILL_COLOR = new ColorConstant(255, 255, 255);
	private static final int LINE_WIDTH = 1;
	private static final String newLine = Strings.newLine();
	private static final int newLineLength = Strings.newLine().length();
	
	static class FeatureProvider extends DefaultFeatureProvider {
		
		private class CreateFeature extends ChangeAwareCreateConnectionFeature {

			public CreateFeature(IFeatureProvider fp) {
				super(fp, "Transition", "create Transition");
			}
			
			@Override
			public String getCreateImageId() {
				return ImageProvider.IMG_TRANSITION;
			}
	
			@Override
			public boolean canCreate(ICreateConnectionContext context) {
				return FSMSupportUtil.getInstance().canConnect(
						context.getSourceAnchor(),
						context.getTargetAnchor(),
						(ContainerShape)context.getSourcePictogramElement().eContainer(), fp);
			}
			
			public boolean canStartConnection(ICreateConnectionContext context) {
				TransitionTerminal src = FSMSupportUtil.getInstance().getTransitionTerminal(context.getSourceAnchor(), fp);
				if (src==null && !FSMSupportUtil.getInstance().isInitialPoint(context.getSourceAnchor(), fp))
					return false;
				
				StateGraph sg = FSMSupportUtil.getInstance().getStateGraph((ContainerShape) context.getSourcePictogramElement().eContainer(), fp);
				if (sg==null)
					return false;
				
				return FSMSupportUtil.getInstance().getFSMValidationUtil().isConnectable(src, sg).isOk();
			}
			
			@Override
			public Connection doCreate(ICreateConnectionContext context) {
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
				
				TransitionTerminal src = FSMSupportUtil.getInstance().getTransitionTerminal(context.getSourceAnchor(), fp);
				TransitionTerminal dst = FSMSupportUtil.getInstance().getTransitionTerminal(context.getTargetAnchor(), fp);
				StateGraph sg = FSMSupportUtil.getInstance().getStateGraph((ContainerShape) context.getSourcePictogramElement().eContainer(), fp);
				if (dst!=null && sg!=null) {

					// TODOHRR-B transition dialog
					// allow switch between default and non-default CP branch? This would change the transition type
					
					Transition trans = null;
					if (src==null) {
						InitialTransition t = FSMFactory.eINSTANCE.createInitialTransition();
						t.setTo(dst);
						trans = t;
					}
					else if (src instanceof SubStateTrPointTerminal
							|| (src instanceof TrPointTerminal && ((TrPointTerminal)src).getTrPoint() instanceof EntryPoint)) {
						ContinuationTransition t = FSMFactory.eINSTANCE.createContinuationTransition();
						t.setFrom(src);
						t.setTo(dst);
						trans = t;
					}
					else if (src instanceof ChoicepointTerminal) {
						boolean dfltBranch = true;
						for (Transition tr : FSMSupportUtil.getInstance().getFSMHelpers().getAllTransitions(sg)) {
							if (tr instanceof ContinuationTransition) {
								TransitionTerminal from = ((ContinuationTransition) tr).getFrom();
								if (from instanceof ChoicepointTerminal) {
									if (((ChoicepointTerminal) from).getCp()==((ChoicepointTerminal)src).getCp())
										dfltBranch = false;
								}
							}
						}
						NonInitialTransition t = dfltBranch? FSMFactory.eINSTANCE.createContinuationTransition()
								: FSMFactory.eINSTANCE.createCPBranchTransition();
						
						if (t instanceof CPBranchTransition) {
							DetailCode dc = FSMFactory.eINSTANCE.createDetailCode();
							dc.setUsed(false);
							((CPBranchTransition) t).setCondition(dc);
						}
						
						t.setFrom(src);
						t.setTo(dst);
						trans = t;
					}
					else {
						NonInitialTransition t = null;
						switch (mc.getCommType()) {
						case DATA_DRIVEN:
							t = FSMFactory.eINSTANCE.createGuardedTransition();
							break;
						case ASYNCHRONOUS:
							// let user choose between triggered and guarded transition
				        	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				        	MessageDialog dlg = new MessageDialog(
				        			shell,
				        			"Create new transition",
									null, 	// accept the default window icon
				        			"Select the kind of transition",
									MessageDialog.QUESTION,
									new String[] {
				        				"triggered",
				        				"guarded"
				        			},
									0		// default button index
								);
				        	
				        	switch (dlg.open()) {	// open returns index of pressed button
							case 0:
								t = FSMFactory.eINSTANCE.createTriggeredTransition();
								break;
							case 1:
								t = FSMFactory.eINSTANCE.createGuardedTransition();
								break;
				        	}
							break;
						case EVENT_DRIVEN:
							t = FSMFactory.eINSTANCE.createTriggeredTransition();
							break;
						case SYNCHRONOUS:
							break;
						default:
							break; 
						}
						if (t==null)
							return null;
						
						t.setFrom(src);
						t.setTo(dst);
						trans = t;
					}

					if (trans instanceof InitialTransition) {
						trans.setName(FSMSupportUtil.getInstance().getFSMNewNamingUtil().getUniqueName("init", sg));
					}
					else {
						trans.setName(FSMSupportUtil.getInstance().getFSMNewNamingUtil().getUniqueName("tr", sg));
					}

					ContainerShape targetContainer = FSMSupportUtil.getInstance().getStateGraphContainer((ContainerShape) context.getSourcePictogramElement().eContainer());
					if (!FSMSupportUtil.getInstance().isOwnedBy(mc, sg)) {
						sg = ModelEditingUtil.insertRefinedState(sg, mc, targetContainer, getFeatureProvider());
					}

					sg.getTransitions().add(trans);
					
		        	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		        	Injector injector = ((IInjectorProvider) getFeatureProvider()).getInjector();
		        	IFSMDialogFactory factory = injector.getInstance(IFSMDialogFactory.class);
		        	ITransitionPropertyDialog dlg = factory.createTransitionPropertyDialog(shell, FSMSupportUtil.getInstance().getModelComponent(getDiagram()), trans);
					if (dlg.open()==Window.OK) {
						AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
						addContext.setNewObject(trans);
						return (Connection) getFeatureProvider().addIfPossible(addContext);
					}
				}
				
				return null;
			}
		}
		
		private class AddFeature extends AbstractAddFeature {

			public AddFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public boolean canAdd(IAddContext context) {
				if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Transition) {
					return true;
				}
				return false;
			}

			@Override
			public PictogramElement add(IAddContext context) {
				IAddConnectionContext addConContext = (IAddConnectionContext) context;
				Transition trans = (Transition) context.getNewObject();
				
				// a transition target can not be the initial point (which has a StateGraph associated)
				// so we use the target anchor to determine the StateGraph container
				ContainerShape container = ((ContainerShape) addConContext.getTargetAnchor().getParent()).getContainer();
				Object bo = getBusinessObjectForPictogramElement(container);
				if (!(bo instanceof StateGraph))
					container = container.getContainer();
				boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				
				IPeCreateService peCreateService = Graphiti.getPeCreateService();
				FreeFormConnection connection = peCreateService.createFreeFormConnection(getDiagram());
				connection.setStart(addConContext.getSourceAnchor());
				connection.setEnd(addConContext.getTargetAnchor());

				if (addConContext.getSourceAnchor()==addConContext.getTargetAnchor()) {
					Point pt = createSelfTransitionBendPoint(connection);
					connection.getBendpoints().add(pt);
				}

				Graphiti.getPeService().setPropertyValue(connection, Constants.TYPE_KEY, Constants.TRANS_TYPE);

				IGaService gaService = Graphiti.getGaService();
				Polyline polyline = gaService.createPolyline(connection);
				Color lineColor = manageColor(inherited?INHERITED_COLOR:LINE_COLOR);
				polyline.setForeground(lineColor);
				polyline.setLineWidth(LINE_WIDTH);

		        ConnectionDecorator cd = peCreateService
		              .createConnectionDecorator(connection, false, 1.0, true);
		        Color fillColor = FSMSupportUtil.getInstance().getFSMHelpers().hasDetailCode(trans.getAction())?
		        		lineColor:manageColor(FILL_COLOR);
				createArrow(cd, lineColor, fillColor);
		        
		        ConnectionDecorator textDecorator =
		            peCreateService.createConnectionDecorator(connection, true,
		            0.5, true);
		        Text text = gaService.createDefaultText(getDiagram(), textDecorator, getLabel(trans));
		        text.setForeground(lineColor);
		        gaService.setLocation(text, 10, 0);


				// create link and wire it
				link(connection, trans);

				return connection;
			}

			private Point createSelfTransitionBendPoint(FreeFormConnection connection) {
				ILocation begin = Graphiti.getPeService().getLocationRelativeToDiagram(connection.getStart());
				
				// TODOHRR: algorithm to determine self transition bend point position 
				int deltaX = 0;
				int deltaY = StateGraphSupport.MARGIN*3;
				
				return Graphiti.getGaService().createPoint(begin.getX()+deltaX, begin.getY()+deltaY);
			}
			
			private Polyline createArrow(GraphicsAlgorithmContainer gaContainer, Color lineColor, Color fillColor) {

				IGaService gaService = Graphiti.getGaService();
				Polygon polygon =
					gaService.createPolygon(gaContainer, new int[] { -15, 5, 0, 0, -15, -5 });

				polygon.setForeground(lineColor);
				polygon.setBackground(fillColor);
				polygon.setLineWidth(LINE_WIDTH);

				return polygon;
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
				
				Transition trans = (Transition) getBusinessObjectForPictogramElement(context.getConnection());
				boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				if (inherited)
					return false;

				Anchor src = context.getConnection().getStart();
				Anchor tgt = context.getConnection().getEnd();
				if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE))
					src = context.getNewAnchor();
				else
					tgt = context.getNewAnchor();
				
				return FSMSupportUtil.getInstance().canConnect(src, tgt, trans, (ContainerShape) context.getTargetPictogramElement().eContainer(), fp);
			}
			
			@Override
			public void postReconnect(IReconnectionContext context) {
				super.postReconnect(context);

				TransitionTerminal src = FSMSupportUtil.getInstance().getTransitionTerminal(context.getConnection().getStart(), fp);
				TransitionTerminal dst = FSMSupportUtil.getInstance().getTransitionTerminal(context.getConnection().getEnd(), fp);
				StateGraph sg = FSMSupportUtil.getInstance().getStateGraph((ContainerShape) context.getTargetPictogramElement().eContainer(), fp);

				// in the following we set source and target of the connection regardless of whether they have changed
				// if the type of the transition changed we create a new one and open the property dialog
				
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
				Transition orig = (Transition) getBusinessObjectForPictogramElement(context.getConnection());
				Transition trans = null;
				if (src==null) {
					InitialTransition t = (orig instanceof InitialTransition)?
							(InitialTransition)orig : FSMFactory.eINSTANCE.createInitialTransition();
					t.setTo(dst);
					trans = t;
				}
				else if (src instanceof SubStateTrPointTerminal
						|| (src instanceof TrPointTerminal && ((TrPointTerminal)src).getTrPoint() instanceof EntryPoint)) {
					ContinuationTransition t = (orig instanceof ContinuationTransition)?
							(ContinuationTransition)orig : FSMFactory.eINSTANCE.createContinuationTransition();
					t.setFrom(src);
					t.setTo(dst);
					trans = t;
				}
				else if (src instanceof ChoicepointTerminal) {
					NonInitialTransition t = null;
					if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
						boolean dfltBranch = true;
						for (Transition tr : FSMSupportUtil.getInstance().getFSMHelpers().getAllTransitions(sg)) {
							if (tr instanceof ContinuationTransition) {
								TransitionTerminal from = ((ContinuationTransition) tr).getFrom();
								if (from instanceof ChoicepointTerminal) {
									if (((ChoicepointTerminal) from).getCp()==((ChoicepointTerminal)src).getCp())
										dfltBranch = false;
								}
							}
						}
						t = dfltBranch? FSMFactory.eINSTANCE.createContinuationTransition()
								: FSMFactory.eINSTANCE.createCPBranchTransition();
					}
					else
						t = (NonInitialTransition) orig;
					
					t.setFrom(src);
					t.setTo(dst);
					trans = t;
				}
				else {
					TransitionChainStartTransition t = null;
					switch(mc.getCommType()){
						case EVENT_DRIVEN:
							if(orig instanceof TriggeredTransition)
								t = (TransitionChainStartTransition) orig;
							else
								t = FSMFactory.eINSTANCE.createTriggeredTransition();
							break;
						case DATA_DRIVEN:
							if(orig instanceof GuardedTransition)
								t = (TransitionChainStartTransition) orig;
							else
								t = FSMFactory.eINSTANCE.createGuardedTransition();
							break;
						case ASYNCHRONOUS:
							if(orig instanceof TriggeredTransition || orig instanceof GuardedTransition )
								t = (TransitionChainStartTransition) orig;
							else {
								// let user choose between triggered and guarded transition
					        	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					        	MessageDialog dlg = new MessageDialog(
					        			shell,
					        			"Create new transition",
										null, 	// accept the default window icon
					        			"Select the kind of transition",
										MessageDialog.QUESTION,
										new String[] {
					        				"triggered",
					        				"guarded"
					        			},
										0		// default button index
									);
					        	
					        	switch (dlg.open()) {	// open returns index of pressed button
									case 0:
										t = FSMFactory.eINSTANCE.createTriggeredTransition();
										break;
									case 1:
										t = FSMFactory.eINSTANCE.createGuardedTransition();
										break;
					        	}
							}
						break;
						case SYNCHRONOUS:
							break;
						default:
							break;
					}
					
					t.setFrom(src);
					t.setTo(dst);
					trans = t;
				}

				if (orig!=trans) {
					if (trans instanceof InitialTransition) {
						trans.setName("init");
					}
					else {
						trans.setName(orig.getName());
					}
					
					trans.setAction(orig.getAction());
					trans.setName(orig.getName());
					
					sg.getTransitions().remove(orig);
					sg.getTransitions().add(trans);
					
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		        	Injector injector = ((IInjectorProvider) getFeatureProvider()).getInjector();
		        	IFSMDialogFactory factory = injector.getInstance(IFSMDialogFactory.class);
					ITransitionPropertyDialog dlg = factory.createTransitionPropertyDialog(shell, mc, trans);
					if (dlg.open()!=Window.OK) {
						sg.getTransitions().add(orig);
						sg.getTransitions().remove(trans);
						if (context.getNewAnchor()==context.getConnection().getStart())
							context.getConnection().setStart(context.getOldAnchor());
						else
							context.getConnection().setEnd(context.getOldAnchor());
						return;
					}

					link(context.getConnection(), trans);
				}
				
				doneChanges = true;
		        Color fillColor = FSMSupportUtil.getInstance().getFSMHelpers().hasDetailCode(trans.getAction())?
		        		manageColor(LINE_COLOR):manageColor(FILL_COLOR);
				updateLabel(trans, context.getConnection(), fillColor);
			}
			
			@Override
			public boolean hasDoneChanges() {
				return doneChanges;
			}
		}
		
		private class UpdateFeature extends AbstractUpdateFeature {

			public UpdateFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public boolean canUpdate(IUpdateContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy())
					return true;
				
				if (bo instanceof Transition)
					return true;
				
				return false;
			}

			@Override
			public IReason updateNeeded(IUpdateContext context) {
				Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
				if (bo instanceof EObject && ((EObject)bo).eIsProxy()) {
					return Reason.createTrueReason("Transition deleted from model");
				}

				if (bo instanceof Transition) {
					Transition t = (Transition) bo;
					Connection conn = (Connection)context.getPictogramElement();
					if (conn.getConnectionDecorators().size()>=2) {
						ConnectionDecorator cd = conn.getConnectionDecorators().get(0);
						if (cd.getGraphicsAlgorithm() instanceof Polygon) {
							ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
							boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), t);
							Color lineColor = inherited? manageColor(INHERITED_COLOR):manageColor(LINE_COLOR);
							boolean hasActionCode = FSMSupportUtil.getInstance().getFSMHelpers().hasActionCode(t, mc);
							Color fillColor = hasActionCode? lineColor : manageColor(FILL_COLOR);
							if (!equal(cd.getGraphicsAlgorithm().getBackground(), fillColor))
								return Reason.createTrueReason("Arrow head needs update");
						}
						cd = conn.getConnectionDecorators().get(1);
						if (cd.getGraphicsAlgorithm() instanceof Text) {
							Text label = (Text) cd.getGraphicsAlgorithm();
							if (!label.getValue().equals(getLabel(t)))
								return Reason.createTrueReason("Label needs update");
						}
					}
				}

				return Reason.createFalseReason();
			}
			
			private boolean equal(Color c1, Color c2) {
				return c1.getRed()==c2.getRed() && c1.getGreen()==c2.getGreen() && c1.getBlue()==c2.getBlue();
			}

			@Override
			public boolean update(IUpdateContext context) {
				Connection containerShape = (Connection)context.getPictogramElement();
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
				
				boolean updated = false;
				
				if (bo instanceof Transition) {
					ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
					Transition trans = (Transition) bo;
					Connection conn = (Connection)context.getPictogramElement();
					boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
					Color lineColor = inherited? manageColor(INHERITED_COLOR):manageColor(LINE_COLOR);
					boolean hasActionCode = FSMSupportUtil.getInstance().getFSMHelpers().hasActionCode(trans, mc);
			        Color fillColor = hasActionCode? lineColor : manageColor(FILL_COLOR);
					updateLabel(trans, conn, fillColor);
					updated = true;
					if (updateNeeded(context).toBoolean())
						updated = false;
				}

				return updated;
			}
		}
		
		private static class PropertyFeature extends ChangeAwareCustomFeature {

			private boolean editable;

			public PropertyFeature(IFeatureProvider fp, boolean editable) {
				super(fp);
				this.editable = editable;
			}

			@Override
			public String getName() {
				return editable? "Edit Transition..." : "View Transition";
			}
			
			@Override
			public String getDescription() {
				return editable? "Edit Transition Properties" : "View Transition Properties";
			}
			
			private Pair<Connection, Transition> getTransition(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					PictogramElement pe = pes[0];
					if (pe instanceof ConnectionDecorator)
						pe = (PictogramElement) pe.eContainer();
					if (!(pe instanceof Connection))
						return null;
					
					Object bo = getBusinessObjectForPictogramElement(pe);
					if (bo instanceof Transition) {
						return new Pair<Connection, Transition>((Connection) pe, (Transition) bo);
					}
				}
				return null;
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				return getTransition(context)!=null;
			}

			@Override
			public boolean doExecute(ICustomContext context) {
				Pair<Connection, Transition> pair = getTransition(context);
				Transition trans = pair.getValue();
				Connection conn = pair.getKey();
				
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	        	Injector injector = ((IInjectorProvider) getFeatureProvider()).getInjector();
	        	IFSMDialogFactory factory = injector.getInstance(IFSMDialogFactory.class);
	        	ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
				ITransitionPropertyDialog dlg = factory.createTransitionPropertyDialog(shell, mc, trans);
				if (dlg.open()==Window.OK){
					boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
					Color lineColor = inherited? manageColor(INHERITED_COLOR):manageColor(LINE_COLOR);
			        Color fillColor = FSMSupportUtil.getInstance().getFSMHelpers().hasActionCode(trans, mc)?
			        		lineColor:manageColor(FILL_COLOR);
					updateLabel(trans, conn, fillColor);
				
					return true;
				}
				
				return false;	
			}
		}
		
		private static class RefineTransitionFeature extends AbstractCustomFeature {

			/**
			 * @param fp
			 */
			public RefineTransitionFeature(IFeatureProvider fp) {
				super(fp);
			}

			@Override
			public String getName() {
				return "Refine Transition";
			}
			
			@Override
			public String getDescription() {
				return "Refine transition to add action code";
			}
			
			@Override
			public boolean canExecute(ICustomContext context) {
				PictogramElement[] pes = context.getPictogramElements();
				if (pes != null && pes.length == 1) {
					PictogramElement pe = pes[0];
					if (pe instanceof ConnectionDecorator)
						pe = (PictogramElement) pe.eContainer();
					if (!(pe instanceof Connection))
						return false;
					
					Object bo = getBusinessObjectForPictogramElement(pe);
					if (bo instanceof Transition) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void execute(ICustomContext context) {
				PictogramElement pe = context.getPictogramElements()[0];
				if (pe instanceof ConnectionDecorator)
					pe = (PictogramElement) pe.eContainer();
				Transition trans = (Transition) getBusinessObjectForPictogramElement(pe);
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
				if (mc.getStateMachine()==null)
					mc.setStateMachine(FSMFactory.eINSTANCE.createStateGraph());
				
				RefinedTransition rt = FSMFactory.eINSTANCE.createRefinedTransition();
				rt.setTarget(trans);
				mc.getStateMachine().getRefinedTransitions().add(rt);
				// the connection pe is still linked to the former transition that was refined!

				ICustomFeature[] features = getFeatureProvider().getCustomFeatures(context);
				for (ICustomFeature cf : features) {
					if (cf instanceof PropertyFeature) {
						cf.execute(context);
						break;
					}
				}
			}
			
		}
		
		protected static class DeleteFeature extends DeleteWithoutConfirmFeature {

			public DeleteFeature(IFeatureProvider fp) {
				super(fp);
			}
			
			@Override
			public boolean canDelete(IDeleteContext context) {
				PictogramElement pe = context.getPictogramElement();
				if (pe instanceof ConnectionDecorator)
					pe = (PictogramElement) pe.eContainer();
				if (!(pe instanceof Connection))
					return false;
				
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof Transition) {
					boolean inherited = FSMSupportUtil.getInstance().isInherited(getDiagram(), (Transition) bo);
					if (inherited)
						return false;

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
		public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
			return new DefaultAddBendpointFeature(fp){
				@Override
				public boolean canAddBendpoint(IAddBendpointContext context) {
					Transition trans = (Transition) getBusinessObjectForPictogramElement(context.getConnection());
					return !FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				}
			};
		}
		
		@Override
		public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
			return new DefaultRemoveBendpointFeature(fp){
				@Override
				public boolean canRemoveBendpoint(IRemoveBendpointContext context) {
					Transition trans = (Transition) getBusinessObjectForPictogramElement(context.getConnection());
					return !FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				}
			};
		}
		
		@Override
		public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
			return new DefaultMoveBendpointFeature(fp){				
				@Override
				public boolean canMoveBendpoint(IMoveBendpointContext context) {
					Transition trans = (Transition) getBusinessObjectForPictogramElement(context.getConnection());
					return !FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				}
			};
		}
		
		@Override
		public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
			return new DefaultMoveConnectionDecoratorFeature(fp){
				@Override
				public boolean canMoveConnectionDecorator(IMoveConnectionDecoratorContext context) {
					Transition trans = (Transition) getBusinessObjectForPictogramElement(context.getConnectionDecorator().getConnection());
					return !FSMSupportUtil.getInstance().isInherited(getDiagram(), trans);
				}
			};
		}
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			PictogramElement pe = context.getPictogramElements()[0];
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe .eContainer();
			Object bo = getBusinessObjectForPictogramElement(pe);
			
			ArrayList<ICustomFeature> result = new ArrayList<ICustomFeature>();

			if (bo instanceof Transition) {
				Transition trans = (Transition) bo;
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagramTypeProvider().getDiagram());
				boolean editable = FSMSupportUtil.getInstance().getFSMHelpers().getModelComponent(trans)==mc;
				
				// let's check whether we already refined this transition
				if (!editable)
					if (mc.getStateMachine()!=null)
						for (RefinedTransition rt : mc.getStateMachine().getRefinedTransitions()) {
							if (rt.getTarget()==trans) {
								editable = true;
								break;
							}
						}
				
				result.add(new PropertyFeature(fp, editable));
				
				if (!editable)
					result.add(new RefineTransitionFeature(fp));
				
				RemoveBendpointsFeature removeAllBendpoints = new RemoveBendpointsFeature(fp){
					@Override
					public boolean canExecute(ICustomContext context) {
						Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
						return !FSMSupportUtil.getInstance().isInherited(getDiagram(), (Transition) bo);
					}
				};
				result.add(removeAllBendpoints);
			}

			// Provide quick fix feature only for those edit parts which have
			// errors, warnings or infos.
			ArrayList<Diagnostic> diagnostics = ((AbstractFSMEditor) getDiagramTypeProvider()
					.getDiagramBehavior().getDiagramContainer())
					.getDiagnosingModelObserver().getElementDiagonsticMap()
					.get(bo);
			if (diagnostics != null)
				result.add(new QuickFixFeature(fp));
			
			ICustomFeature features[] = new ICustomFeature[result.size()];
			return result.toArray(features);
		}
		
		protected static void updateLabel(Transition trans, Connection conn, Color fillColor) {
			if (conn.getConnectionDecorators().size()<2)
				return;
			
			ConnectionDecorator cd = conn.getConnectionDecorators().get(0);
			if (cd.getGraphicsAlgorithm() instanceof Polygon) {
				Polygon p = (Polygon) cd.getGraphicsAlgorithm();
				p.setBackground(fillColor);
			}
			
			cd = conn.getConnectionDecorators().get(1);
			if (cd.getGraphicsAlgorithm() instanceof Text) {
				Text label = (Text) cd.getGraphicsAlgorithm();
				label.setValue(getLabel(trans));
			}
		}
		
		protected static String getLabel(Transition trans) {
			IPreferenceStore store = UIBaseActivator.getDefault().getPreferenceStore();
			int MAX_LINE_LENGTH = store.getInt(UIBasePreferenceConstants.MAX_LABEL_LINE_LENGTH);
			int MAX_LINES = store.getInt(UIBasePreferenceConstants.MAX_LABEL_LINES);
			String label = FSMSupportUtil.getInstance().getFSMNameProvider().getTransitionLabelName(trans);
			StringBuilder result = new StringBuilder();
			int i = 0;
			for (; i+MAX_LINE_LENGTH<label.length(); i+=MAX_LINE_LENGTH) {
				result.append(label.substring(i, i+MAX_LINE_LENGTH)+newLine);
			}
			result.append(label.subSequence(i, label.length()));
			int maxLen = (MAX_LINE_LENGTH+newLineLength)*MAX_LINES-newLineLength;
			if (result.length()>maxLen)
				return result.substring(0, maxLen)+"...";
			else
				return result.toString();
		}
	}
	
	class BehaviorProvider extends DefaultToolBehaviorProvider {

		public BehaviorProvider(IDiagramTypeProvider dtp) {
			super(dtp);
		}
		
		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
			PictogramElement pe = context.getPictogramElements()[0];
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe.eContainer();
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof Transition) {
				Transition trans = (Transition) bo;
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagramTypeProvider().getDiagram());
				boolean editable = FSMSupportUtil.getInstance().getFSMHelpers().getModelComponent(trans)==mc;
				return new FeatureProvider.PropertyFeature(getDiagramTypeProvider().getFeatureProvider(), editable);
			}
			
			return null;
		}
		
		@Override
		public Object getToolTip(GraphicsAlgorithm ga) {
			// if this is called we know there is a business object!=null
			PictogramElement pe = ga.getPictogramElement();
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe.eContainer();
			
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof Transition) {
				Transition tr = (Transition) bo;
				String label = FSMSupportUtil.getInstance().getFSMNameProvider().getTransitionLabelName(tr);
				ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagramTypeProvider().getDiagram());
				String code = FSMSupportUtil.getInstance().getFSMHelpers().getAllActionCode(tr, mc);
				if (code!=null && !code.isEmpty()) {
					if (label.length()>0)
						label += "\n";
					label += "action:\n"+code;
				}
				return label;
			}
			
			return super.getToolTip(ga);
		}
		
		/**
		 * @author jayant
		 */
		@Override
		public IDecorator[] getDecorators(PictogramElement pe) {
			if (pe.isVisible()) {
				// Constants for positioning decorators
				int xOrigin = -20, yOrigin = 0; // Position to the left of label
				int xGap = 0, yGap = -10;
				
				// Get the linked Business Object
				EObject bo = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(
								(PictogramElement) pe.eContainer());
				
				// Get Diagnostics associated with the business object
				ArrayList<Diagnostic> diagnostics = ((AbstractFSMEditor) getDiagramTypeProvider()
						.getDiagramBehavior().getDiagramContainer())
						.getDiagnosingModelObserver().getElementDiagonsticMap()
						.get(bo);
				
				// Form Decorators based on Diagnostics
				ArrayList<IDecorator> decorators = DecoratorUtil
						.getMarkersFromDiagnostics(diagnostics);
				
				if (!decorators.isEmpty()) {
					int i = 0;
					for (IDecorator decorator : decorators) {
						((ImageDecorator) decorator).setX(xOrigin + i * xGap);
						((ImageDecorator) decorator).setY(yOrigin + i * yGap);
						i++;
					}
					
					return (IDecorator[]) decorators
							.toArray(new IDecorator[decorators.size()]);
				}
			}
			
			return super.getDecorators(pe);
		}
	}
	
	private FeatureProvider pfp;
	private BehaviorProvider tbp;
	
	public TransitionSupport(IDiagramTypeProvider dtp, IFeatureProvider fp) {
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
