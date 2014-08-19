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

package org.eclipse.etrice.ui.behavior;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.util.FSMSwitch;
import org.eclipse.etrice.core.naming.RoomFragmentProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.InjectingFeatureProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.ChoicePointSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.DiagramUpdateFeature;
import org.eclipse.etrice.ui.behavior.fsm.support.InitialPointSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.StateGraphSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.StateSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.TrPointSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.TransitionSupport;
import org.eclipse.etrice.ui.common.base.support.CantDeleteFeature;
import org.eclipse.etrice.ui.common.base.support.CantRemoveFeature;
import org.eclipse.etrice.ui.common.base.support.RemoveBendpointsFeature;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.IShapeSelectionInfo;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.tb.ShapeSelectionInfoImpl;
import org.eclipse.graphiti.util.IColorConstant;

import com.google.inject.Injector;

public class ProviderDispatcher {

	private class FeatureProviderSwitch extends FSMSwitch<IFeatureProvider> {
		private ContainerShape parent = null;

		@Override
		public IFeatureProvider doSwitch(EObject theEObject) {
        	
			if (theEObject==null)
				return null;
			
			if (theEObject.eIsProxy()) {
        		if (RoomFragmentProvider.isState(theEObject))
        			return stateSupport.getFeatureProvider();
        		if (RoomFragmentProvider.isTrPoint(theEObject))
        			return trPointSupport.getFeatureProvider();
        		if (RoomFragmentProvider.isChoicePoint(theEObject))
        			return choicePointSupport.getFeatureProvider();
        		if (RoomFragmentProvider.isStateGraph(theEObject))
        			return stateGraphSupport.getFeatureProvider();
        		if (RoomFragmentProvider.isTransition(theEObject))
        			return transitionSupport.getFeatureProvider();
        		if (RoomFragmentProvider.isTransition(theEObject))
        			return transitionSupport.getFeatureProvider();
        	}
			return super.doSwitch(theEObject);
		}
		
		@Override
		public IFeatureProvider caseStateGraph(StateGraph object) {
			if (parent!=null && parent.getLink()!=null) {
				if (parent.getLink().getBusinessObjects().size()>0) {
					EObject bo = parent.getLink().getBusinessObjects().get(0);
					if (bo instanceof StateGraph)
						return initialPointSupport.getFeatureProvider();
				}
				parent = null;
			}
			return stateGraphSupport.getFeatureProvider();
		}
		
		@Override
		public IFeatureProvider caseTrPoint(TrPoint object) {
			return trPointSupport.getFeatureProvider();
		}
		@Override
		public IFeatureProvider caseChoicePoint(ChoicePoint object) {
			return choicePointSupport.getFeatureProvider();
		}
		@Override
		public IFeatureProvider caseState(State object) {
			return stateSupport.getFeatureProvider();
		}
		
		@Override
		public IFeatureProvider caseTransition(Transition object) {
			return transitionSupport.getFeatureProvider();
		}

		@Override
		public IFeatureProvider caseRefinedTransition(RefinedTransition object) {
			return transitionSupport.getFeatureProvider();
		}
		
		@Override
		public IFeatureProvider defaultCase(EObject object) {
			return null;
		}
	
		public ICreateFeature[] getCreateFeatures() {
			return concatAll(
					stateSupport.getFeatureProvider().getCreateFeatures(),
					initialPointSupport.getFeatureProvider().getCreateFeatures(),
					trPointSupport.getFeatureProvider().getCreateFeatures(),
					choicePointSupport.getFeatureProvider().getCreateFeatures()
				);
		}

		public ICreateConnectionFeature[] getCreateConnectionFeatures() {
			return transitionSupport.getFeatureProvider().getCreateConnectionFeatures();
		}

		public void setParentContainer(ContainerShape parent) {
			this.parent  = parent;
		}
	}

	private class ToolBehaviorProviderSwitch extends FSMSwitch<IToolBehaviorProvider> {
		private ContainerShape parent = null;

		@Override
		public IToolBehaviorProvider doSwitch(EObject theEObject) {
        	
			if (theEObject==null)
				return null;
      	
			if (theEObject.eIsProxy()) {
        		if (RoomFragmentProvider.isState(theEObject))
        			return stateGraphSupport.getToolBehaviorProvider();
        		if (RoomFragmentProvider.isTrPoint(theEObject))
        			return trPointSupport.getToolBehaviorProvider();
        		if (RoomFragmentProvider.isChoicePoint(theEObject))
        			return choicePointSupport.getToolBehaviorProvider();
        		if (RoomFragmentProvider.isStateGraph(theEObject))
        			return stateGraphSupport.getToolBehaviorProvider();
        		if (RoomFragmentProvider.isTransition(theEObject))
        			return transitionSupport.getToolBehaviorProvider();
        	}
			
			return super.doSwitch(theEObject);
		}
		
		@Override
		public IToolBehaviorProvider caseStateGraph(StateGraph object) {
			if (parent!=null && parent.getLink()!=null) {
				if (parent.getLink().getBusinessObjects().size()>0) {
					EObject bo = parent.getLink().getBusinessObjects().get(0);
					if (bo instanceof StateGraph)
						return initialPointSupport.getToolBehaviorProvider();
				}
				parent = null;
			}
			return stateGraphSupport.getToolBehaviorProvider();
		}
		@Override
		public IToolBehaviorProvider caseTrPoint(TrPoint object) {
			return trPointSupport.getToolBehaviorProvider();
		}
		@Override
		public IToolBehaviorProvider caseChoicePoint(ChoicePoint object) {
			return choicePointSupport.getToolBehaviorProvider();
		}
		@Override
		public IToolBehaviorProvider caseState(State object) {
			return stateSupport.getToolBehaviorProvider();
		}
		
		@Override
		public IToolBehaviorProvider caseTransition(Transition object) {
			return transitionSupport.getToolBehaviorProvider();
		}

		@Override
		public IToolBehaviorProvider defaultCase(EObject object) {
			return null;
		}

		public void setParentContainer(ContainerShape parent) {
			this.parent  = parent;
		}
		
	}

	private class DispatchingFeatureProvider extends InjectingFeatureProvider {

		public DispatchingFeatureProvider(IDiagramTypeProvider dtp, Injector injector) {
			super(dtp, injector);
		}
		
		@Override
	    public ICreateFeature[] getCreateFeatures() {
	        return getAllCreateFeatures();
	    }
		
		@Override
		public ICreateConnectionFeature[] getCreateConnectionFeatures() {
	        return getAllCreateConnectionFeatures();
		}
		
		@Override
		public IAddFeature getAddFeature(IAddContext context) {
			featureSwitch.setParentContainer(context.getTargetContainer());
			IFeatureProvider fp = featureSwitch.doSwitch(((EObject) context.getNewObject()));
			if (fp==null)
				return super.getAddFeature(context);
			else
				return fp.getAddFeature(context);
		}

		@Override
	    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getLayoutFeature(context);
			else
				return super.getLayoutFeature(context);
	    }
		
		@Override
		public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getMoveShapeFeature(context);
			else
				return super.getMoveShapeFeature(context);
		}
		
		@Override
		public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getResizeShapeFeature(context);
			else
				return super.getResizeShapeFeature(context);
		}
		
		@Override
		public IUpdateFeature getUpdateFeature(IUpdateContext context) {
			if (context.getPictogramElement() instanceof Diagram)
				return new DiagramUpdateFeature(this, getInjector());
			
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getUpdateFeature(context);
			else
				return super.getUpdateFeature(context);
		}
		
		@Override
		public IDeleteFeature getDeleteFeature(IDeleteContext context) {
			if (context.getPictogramElement() instanceof ConnectionDecorator) {
				return new CantDeleteFeature(this);
			}
			
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getDeleteFeature(context);
			else
				return super.getDeleteFeature(context);
		}
		
		@Override
		public IRemoveFeature getRemoveFeature(IRemoveContext context) {
			if (context.getPictogramElement() instanceof ConnectionDecorator) {
				return new CantRemoveFeature(this);
			}
			
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getRemoveFeature(context);
			else
				return super.getRemoveFeature(context);
		}
		
		@Override
		public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
			IFeatureProvider fp = getFeatureProvider(context);
			if (fp!=null)
				return fp.getReconnectionFeature(context);
			else
				return super.getReconnectionFeature(context);
		}
		
		@Override
		public ICustomFeature[] getCustomFeatures(ICustomContext context) {
			ArrayList<ICustomFeature> result = new ArrayList<ICustomFeature>();
			
			ICustomFeature[] custom;
	        IFeatureProvider fp = featureSwitch.doSwitch(getBusinessObject(context));
			if (fp!=null)
				custom = fp.getCustomFeatures(context);
			else
				custom = super.getCustomFeatures(context);
			
			for (ICustomFeature cust : custom) {
				result.add(cust);
			}
			
			boolean allFreeForm = true;
			PictogramElement[] pes = context.getPictogramElements();
			for (PictogramElement pe : pes) {
				if (!(pe instanceof FreeFormConnection))
					allFreeForm = false;
			}
			if (allFreeForm)
				result.add(new RemoveBendpointsFeature(fp));
			
			ICustomFeature features[] = new ICustomFeature[result.size()];
			return result.toArray(features);
		}
		
		private EObject getBusinessObject(IPictogramElementContext context) {
			PictogramElement pictogramElement = context.getPictogramElement();
			EObject bo = (EObject) getBusinessObjectForPictogramElement(pictogramElement);
			return bo;
		}
		
		private EObject getBusinessObject(ICustomContext context) {
			PictogramElement[] pes = context.getPictogramElements();
			if (pes.length>0) {
				PictogramElement pe = pes[0];
				if (pe instanceof ConnectionDecorator)
					pe = (PictogramElement) pe .eContainer();
				
				EObject bo = (EObject) getBusinessObjectForPictogramElement(pe);
				return bo;
			}
			return null;
		}
		
		private IFeatureProvider getFeatureProvider(IPictogramElementContext context) {
			EObject eco = context.getPictogramElement().eContainer();
			if (eco instanceof ContainerShape) {
				featureSwitch.setParentContainer((ContainerShape) eco);
				IFeatureProvider fp = featureSwitch.doSwitch(getBusinessObject(context));
				if (fp!=null)
					return fp;
			}
			return null;
		}
		
		private IFeatureProvider getFeatureProvider(IReconnectionContext context) {
			return featureSwitch.doSwitch((EObject) getBusinessObjectForPictogramElement(context.getConnection()));
		}
	}
	
	private class DispatchingToolBehaviorProvider extends DefaultToolBehaviorProvider {

		public DispatchingToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
			super(diagramTypeProvider);
		}

		@Override
	    public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {
	        IToolBehaviorProvider bp = getToolBehaviorProvider(pe);
	        if (bp==null)
	        	return super.getClickArea(pe);
	        else
	        	return bp.getClickArea(pe);
	    }

		@Override
	    public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
	        IToolBehaviorProvider bp = getToolBehaviorProvider(pe);
	        if (bp==null)
	        	return super.getSelectionBorder(pe);
	        else
	        	return bp.getSelectionBorder(pe);
	    }
		
		@Override
		public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
	        IToolBehaviorProvider bp = getToolBehaviorProvider(context.getPictogramElements()[0]);
	        if (bp==null)
	        	return super.getDoubleClickFeature(context);
	        else
	        	return bp.getDoubleClickFeature(context);
		}
		
		protected IToolBehaviorProvider getToolBehaviorProvider(PictogramElement pe) {
			IFeatureProvider fp = getFeatureProvider();
			if (pe instanceof ConnectionDecorator)
				pe = (PictogramElement) pe.eContainer();
			EObject bo = (EObject) fp.getBusinessObjectForPictogramElement(pe);
			if (bo==null)
				return null;

			EObject eco = pe.eContainer();
			if (eco instanceof ContainerShape) {
				behaviorSwitch.setParentContainer((ContainerShape) eco);
				IToolBehaviorProvider bp = behaviorSwitch.doSwitch(bo);
				if (bp!=null)
					return bp;
			}
			
			IToolBehaviorProvider bp = behaviorSwitch.doSwitch(bo);
			return bp;
		}
		
		@Override
		public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
	        IToolBehaviorProvider bp = getToolBehaviorProvider(context.getPictogramElement());
	        if (bp==null)
	        	return super.getContextButtonPad(context);
	        else
	        	return bp.getContextButtonPad(context);
		}

		public IShapeSelectionInfo getSelectionInfoForShape(Shape shape) {
			IShapeSelectionInfo ssi = new ShapeSelectionInfoImpl();
			ssi.setColor(IColorConstant.SHAPE_SELECTION_FG);
			ssi.setPrimarySelectionHandleForegroundColor(IColorConstant.HANDLE_FG);
			ssi.setPrimarySelectionHandleBackgroundColor(IColorConstant.HANDLE_BG);
			ssi.setLineStyle(LineStyle.DASH);
			ssi.setPrimarySelectionBackgroundColor(IColorConstant.LIGHT_ORANGE);
			ssi.setSecondarySelectionBackgroundColor(IColorConstant.LIGHT_ORANGE);
			return ssi;
		}
		
		@Override
		public Object getToolTip(GraphicsAlgorithm ga) {
	        IToolBehaviorProvider bp = getToolBehaviorProvider(ga.getPictogramElement());
	        if (bp==null)
	        	return super.getToolTip(ga);
	        else
	        	return bp.getToolTip(ga);
		}
		
		/** 
		 * @author jayant
		 **/
		@Override
		public IDecorator[] getDecorators(PictogramElement pe) {
			IToolBehaviorProvider bp = getToolBehaviorProvider(pe);
			if (bp==null)
				return super.getDecorators(pe);
			else
				return bp.getDecorators(pe);
		}
	}
	
	private StateGraphSupport stateGraphSupport;
	private TrPointSupport trPointSupport;
	private InitialPointSupport initialPointSupport;
	private ChoicePointSupport choicePointSupport;
	private StateSupport stateSupport;
	private TransitionSupport transitionSupport;
	
	private FeatureProviderSwitch featureSwitch;
	private ToolBehaviorProviderSwitch behaviorSwitch;
	
	private DispatchingFeatureProvider dispatchingFP;
	private DispatchingToolBehaviorProvider dispatchingBP;
	
	
	public ProviderDispatcher(IDiagramTypeProvider dtp, Injector injector) {
		// create those first before using them
		dispatchingFP = new DispatchingFeatureProvider(dtp, injector);
		dispatchingBP = new DispatchingToolBehaviorProvider(dtp);

		stateGraphSupport = new StateGraphSupport(dtp, dispatchingFP, injector);
		trPointSupport = new TrPointSupport(dtp, dispatchingFP, injector);
		initialPointSupport = new InitialPointSupport(dtp, dispatchingFP, injector);
		choicePointSupport = new ChoicePointSupport(dtp, dispatchingFP, injector);
		stateSupport = new StateSupport(dtp, dispatchingFP, injector);
		transitionSupport = new TransitionSupport(dtp, dispatchingFP, injector);
		
		featureSwitch = new FeatureProviderSwitch();
		behaviorSwitch = new ToolBehaviorProviderSwitch();
	}

	public IFeatureProvider getFeatureProvider() {
		return dispatchingFP;
	}
	
	public IToolBehaviorProvider getToolBehaviorProvider() {
		return dispatchingBP;
	}

	private ICreateFeature[] getAllCreateFeatures() {
		return featureSwitch.getCreateFeatures();
	}

	private ICreateConnectionFeature[] getAllCreateConnectionFeatures() {
		return featureSwitch.getCreateConnectionFeatures();
	}
	
	private static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
}
