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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionUtil;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.genmodel.fsm.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.base.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.builder.FSMGeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author rentzhnr
 * 
 */
public class AbstractExecutionValidator implements ICustomValidator {

	// c&p in tests
	public static final String DIAG_CODE_VIOLATION_TRIGGER = "etrice.violation_trigger";
	public static final String DIAG_CODE_VIOLATION_MESSAGESEND = "etrice.violation_messagesend";
	public static final String DIAG_CODE_MISSING_TRIGGER = "etrice.receive_message";
	public static final String DIAG_CODE_MISSING_MESSAGESEND = "etrice.send_message";
	
	private static final Set<EClass> classesToCheck = new HashSet<EClass>();
	private static boolean traceExec = false;
	private static String traceName = "";
	static {
		classesToCheck.add(FSMPackage.Literals.MODEL_COMPONENT);
		
		if (Activator.getDefault() != null && Activator.getDefault().isDebugging()) {
			String value = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/abstractexec");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceExec = true;
			}
			traceName = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/abstractexec/name");
		}
	}
	
	private FSMNameProvider fsmNameProvider = new FSMNameProvider();

	@Override
	public void validate(EObject object,
			ValidationMessageAcceptor messageAcceptor, ICustomValidator.ValidationContext context) {

		if (!(object instanceof ModelComponent))
			return;
		
		if(context.isGeneration())
			return;
		
		ModelComponent mc = (ModelComponent) object;
		
		if (traceExec) {
			if (!(traceName.isEmpty() || mc.getComponentName().equals(traceName)))
				return;
			System.out.println("AbstractExecutionValidator checking class "
					+ mc.getComponentName());
		}
		
		if (mc.isAbstract())
			return;
		
		if (AbstractExecutionUtil.getInstance().getRoomHelpers().isCircularClassHierarchy(mc))
			// is checked elsewhere
			return;

		boolean oneProtocolsWithSemantics = false;
		List<AbstractInterfaceItem> ifItems = mc.getAllAbstractInterfaceItems();
		for (AbstractInterfaceItem item : ifItems) {
			if (item.getSemantics()!=null) {
				oneProtocolsWithSemantics = true;
				if (traceExec)
					System.out
					.println("  Will execute because semantics defined for interface item "
							+ item.getName());
				break;
			}
		}
		if (oneProtocolsWithSemantics) {
			// begin abstract execution on state machine of expanded actor class
			if (traceExec)
				System.out.println("  Reached where at least one interface items has semantics");
			NullDiagnostician diagnostician = new NullDiagnostician();
			FSMGeneratorModelBuilder builder = new FSMGeneratorModelBuilder(
					new NullLogger(), diagnostician);
			ExpandedModelComponent xpac;
			try {
				xpac = builder.createExpandedModelComponent(mc);
			}
			catch (Throwable t) {
				return;
			}

			if (xpac != null && !diagnostician.isFailed()) {
				SemanticsCheck checker = new SemanticsCheck(xpac);
				checker.checkSemantics();

				if (traceExec)
					System.out.println("  Rule checking for "
							+ xpac.getModelComponent().getComponentName() + " is over");

				TreeIterator<EObject> it = xpac.getStateMachine()
						.eAllContents();
				while (it.hasNext()) {
					EObject obj = it.next();
					if (obj instanceof State) {
						ProposalGenerator propGen = new ProposalGenerator(xpac,
								checker);
						State st = (State) obj;
						propGen.createProposals(st);
						createMarkersForProposals(propGen, messageAcceptor, st,
								xpac);
					}
					// the following part takes care of all the warnings
					if (obj instanceof StateGraphItem) {
						StateGraphItem item = (StateGraphItem) obj;
						createMarkersForWarnings(checker, messageAcceptor,
								item, xpac);
					}
				}
				if (traceExec)
					System.out
							.println("AbstractExecutionValidator done checking class "
									+ mc.getComponentName());
			}
			else
				if(traceExec)
					System.out.println("No checking because internal generation failed");
		}
	}

	@Override
	public String getName() {
		return "Abstract FSM Execution Validator";
	}

	@Override
	public String getDescription() {
		return "This validator checks the state machine against the protocol semantics of its ports.";
	}
	
	@Override
	public Set<EClass> getClassesToCheck() {
		return classesToCheck;
	}

	private void createMarkersForProposals(ProposalGenerator propGen,
			ValidationMessageAcceptor messageAcceptor, State st,
			ExpandedModelComponent xpac) {
		List<MessageFromIf> incoming = propGen.getIncomingProposals();
		EObject orig = xpac.getOrig(st);
		EObject container = orig.eContainer();
		@SuppressWarnings("unchecked")
		int idx = ((List<? extends EObject>) container.eGet(orig
				.eContainingFeature())).indexOf(orig);

		for (MessageFromIf msg : incoming) {
			messageAcceptor.acceptWarning("State should handle the message "
					+ fsmNameProvider.getMessageName(msg.getMessage()) + " from port "
					+ msg.getFrom().getName() + " ", container, orig
					.eContainingFeature(), idx, DIAG_CODE_MISSING_TRIGGER, st
					.getName(), fsmNameProvider.getMessageName(msg.getMessage()), msg.getFrom()
					.getName());
		}
		List<MessageFromIf> outgoing = propGen.getOutgoingProposals();

		for (MessageFromIf msg : outgoing) {
			messageAcceptor.acceptInfo("State should send the message "
					+ fsmNameProvider.getMessageName(msg.getMessage()) + " to port "
					+ msg.getFrom().getName() + " ", container, orig
					.eContainingFeature(), idx, DIAG_CODE_MISSING_MESSAGESEND,
					st.getName(), fsmNameProvider.getMessageName(msg.getMessage()), msg.getFrom()
							.getName());
		}

	}

	private void createMarkersForWarnings(SemanticsCheck checker,
			ValidationMessageAcceptor messageAcceptor, StateGraphItem item,
			ExpandedModelComponent xpac) {
		List<HandledMessage> warningList = checker.getWarningMsg(item);
		if (traceExec && warningList != null) {
			System.out.println("Messages in the warning list for item "
					+ item.getName());
		}
		if (warningList != null)
			for (HandledMessage msg : warningList) {
				EObject origin = msg.getOrigin();
				if (origin instanceof ActiveTrigger) {
					ActiveTrigger trigger = (ActiveTrigger) origin;
					for (TriggeredTransition trans : trigger.getTransitions()) {
						// have to translate back the transition to our original
						// model
						TriggeredTransition orig = (TriggeredTransition) xpac
								.getOrig(trans);
						for (Trigger trig : orig.getTriggers()) {
							for (MessageFromIf mif : trig.getMsgFromIfPairs()) {
								// messages haven't been copied, so all point to
								// the same objects and we can just compare
								// pointers
								if (mif.getMessage() == msg.getMsg()
										&& mif.getFrom() == msg.getIfitem()) {
									messageAcceptor
											.acceptWarning(
													"The message violates the semantic rule",
													trig,
													mif.eContainingFeature(),
													trig.getMsgFromIfPairs().indexOf(trig),
													DIAG_CODE_VIOLATION_TRIGGER,
													fsmNameProvider.getMessageName(trigger.getMsg()),
													fsmNameProvider.getMessageName(mif.getMessage()),
													mif.getFrom().getName());
								}
							}
						}
					}
				} else if (origin instanceof DetailCode) {
					DetailCode dc = (DetailCode) origin;
					EObject orig = xpac.getOrig(dc);
					messageAcceptor.acceptWarning(
							"The message violates the semantic rule",
							orig.eContainer(), orig.eContainingFeature(),
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							DIAG_CODE_VIOLATION_MESSAGESEND,
							fsmNameProvider.getMessageName(msg.getMsg()),
							msg.getIfitem().getName());

				}
			}
	}
}
