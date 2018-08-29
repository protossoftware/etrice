/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionRuntimeModule;
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionUtil;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.generator.base.logging.NullLogger;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class ReachabilityValidator implements ICustomValidator {

	public static final String DIAG_CODE_UNREACHABLE = "etrice.unreachable";
	
	private static final Set<EClass> classesToCheck = new HashSet<EClass>();
	{
		classesToCheck.add(FSMPackage.Literals.MODEL_COMPONENT);
	}
	
	@Override
	public void validate(EObject object, ValidationMessageAcceptor messageAcceptor, ICustomValidator.ValidationContext context) {

		if (!(object instanceof ModelComponent))
			return;
		
		if (context.isGeneration())
			return;
		
		ModelComponent mc = (ModelComponent) object;
		
		if (mc.isAbstract())
			return;
		
		if (AbstractExecutionUtil.getInstance().getRoomHelpers().isCircularClassHierarchy(mc))
			// is checked elsewhere
			return;

		Injector injector = Guice.createInjector(new AbstractExecutionRuntimeModule());
		NullDiagnostician diagnostician = new NullDiagnostician();
		ExtendedFsmGenBuilder builder = new ExtendedFsmGenBuilder(injector, diagnostician);
		GraphContainer gc;
		try {
			gc = builder.createTransformedModel(mc);
			NullLogger logger = new NullLogger();
			FsmGenChecker.check(gc, logger);
			if (logger.hasErrors()) {
				return;
			}
			builder.withTriggersInStates(gc);
		}
		catch (Throwable t) {
			return;
		}
		
		if (gc != null && gc.getGraph()!=null && !diagnostician.isFailed()) {
			ReachabilityCheck checker = new ReachabilityCheck(gc);
			checker.computeReachability();
			TreeIterator<EObject> it = gc.eAllContents();
			while (it.hasNext()) {
				EObject item = it.next();
				if (item instanceof GraphItem)
				{
					GraphItem toCheck = (GraphItem) item;
					if (!checker.isReachable(toCheck)) {
						String name = FsmGenExtensions.getName(toCheck);
						if (name==null) {
							name = "<no name>";
						}
						EObject stateGraphItem = (toCheck instanceof Node) ?
								((Node) toCheck).getStateGraphNode() : ((Link) toCheck).getTransition();
								
						EObject container = stateGraphItem.eContainer();
						@SuppressWarnings("unchecked")
						int idx = ((List<? extends EObject>)container.eGet(stateGraphItem.eContainingFeature())).indexOf(stateGraphItem);
						messageAcceptor.acceptWarning(
								"Unreachable state/point of graph",
								stateGraphItem.eContainer(), stateGraphItem.eContainingFeature(), idx,
								DIAG_CODE_UNREACHABLE, name);
					}
				}
			}
		}
	}

	@Override
	public String getName() {
		return "State Reachability Validator";
	}

	@Override
	public String getDescription() {
		return "This validator checks the reachability of state graph items.";
	}

	@Override
	public Set<EClass> getClassesToCheck() {
		return classesToCheck;
	}

}
