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

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.base.NullLogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.IRoomValidator;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author rentzhnr
 * 
 */
public class AbstractExecutionValidator implements IRoomValidator {

	// c&p in tests
	public static String DIAG_CODE_VIOLATION_TRIGGER = "etrice.violation_trigger";
	public static String DIAG_CODE_VIOLATION_MESSAGESEND = "etrice.violation_messagesend";
	public static String DIAG_CODE_MISSING_TRIGGER = "etrice.receive_message";
	public static String DIAG_CODE_MISSING_MESSAGESEND = "etrice.send_message";
	
	private static boolean traceExec = false;
	private static String traceName = "";
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/abstractexec");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceExec = true;
			}
			traceName = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/abstractexec/name");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.etrice.core.validation.IRoomValidator#validate(org.eclipse
	 * .emf.ecore.EObject,
	 * org.eclipse.xtext.validation.ValidationMessageAcceptor)
	 */
	@Override
	public void validate(EObject object,
			ValidationMessageAcceptor messageAcceptor) {

		if (!(object instanceof ActorClass))
			return;
		
		ActorClass ac = (ActorClass) object;
		
		if (traceExec) {
			if (!(traceName.isEmpty() || ac.getName().equals(traceName)))
				return;
			System.out.println("AbstractExecutionValidator checking class "
					+ ac.getName());
		}
		
		if (ValidationUtil.isCircularClassHierarchy(ac))
			// is checked elsewhere
			return;

		boolean oneProtocolsWithSemantics = false;
		List<InterfaceItem> ifItems = RoomHelpers.getAllInterfaceItems(ac);
		for (InterfaceItem item : ifItems) {
			GeneralProtocolClass pc = item.getGeneralProtocol();
			if (!(pc instanceof ProtocolClass))
				continue;

			if (traceExec)
				System.out.println("  Checking protocolClass " + pc.getName()
						+ " for semantics");
			if (((ProtocolClass) pc).getSemantics() != null) {
				oneProtocolsWithSemantics = true;
				if (traceExec)
					System.out
							.println("  Will execute because semantics defined for "
									+ pc.getName());
				break;
			}
		}
		if (oneProtocolsWithSemantics) {
			// begin abstract execution on state machine of expanded actor class
			System.out
					.println("  Reached where at least one interface items has semantics");
			NullDiagnostician diagnostician = new NullDiagnostician();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(
					new NullLogger(), diagnostician);
			ExpandedActorClass xpac = builder.createExpandedActorClass(ac);

			if (xpac != null && !diagnostician.isFailed()) {
				SemanticsCheck checker = new SemanticsCheck(xpac);
				checker.checkSemantics();

				if (traceExec)
					System.out.println("  Rule checking for "
							+ xpac.getActorClass().getName() + " is over");

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
									+ ac.getName());
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

	private void createMarkersForProposals(ProposalGenerator propGen,
			ValidationMessageAcceptor messageAcceptor, State st,
			ExpandedActorClass xpac) {
		List<MessageFromIf> incoming = propGen.getIncomingProposals();
		EObject orig = xpac.getOrig(st);
		EObject container = orig.eContainer();
		@SuppressWarnings("unchecked")
		int idx = ((List<? extends EObject>) container.eGet(orig
				.eContainingFeature())).indexOf(orig);

		for (MessageFromIf msg : incoming) {
			messageAcceptor.acceptWarning("State should handle the message "
					+ msg.getMessage().getName() + " from port "
					+ msg.getFrom().getName() + " ", container,
					orig.eContainingFeature(), idx, DIAG_CODE_MISSING_TRIGGER,
					st.getName());
		}
		List<MessageFromIf> outgoing = propGen.getOutgoingProposals();

		for (MessageFromIf msg : outgoing) {
			messageAcceptor.acceptInfo("State should send the message "
					+ msg.getMessage().getName() + " to port "
					+ msg.getFrom().getName() + " ", container,
					orig.eContainingFeature(), idx, DIAG_CODE_MISSING_MESSAGESEND,
					st.getName());

		}

	}

	private void createMarkersForWarnings(SemanticsCheck checker,
			ValidationMessageAcceptor messageAcceptor, StateGraphItem item,
			ExpandedActorClass xpac) {
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
													trig.getMsgFromIfPairs()
															.indexOf(trig),
													DIAG_CODE_VIOLATION_TRIGGER, trigger
															.getMsg().getName());
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
							DIAG_CODE_VIOLATION_MESSAGESEND);

				}
			}
	}
}
