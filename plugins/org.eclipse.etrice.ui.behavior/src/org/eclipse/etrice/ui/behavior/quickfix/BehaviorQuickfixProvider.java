/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Jayant Gupta (Added Fix methods)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.quickfix;

import java.util.EnumSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.abstractexec.behavior.AbstractExecutionValidator;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.ui.behavior.dialogs.StatePropertyDialog;
import org.eclipse.etrice.ui.behavior.dialogs.StatePropertyDialog.Where;
import org.eclipse.etrice.ui.behavior.dialogs.TransitionPropertyDialog;
import org.eclipse.etrice.ui.behavior.fsm.support.IBehaviorQuickfixProvider;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.etrice.ui.common.base.quickfix.AbstractQuickfixProvider;
import org.eclipse.etrice.ui.common.base.quickfix.IDiagramModification;
import org.eclipse.etrice.ui.common.base.quickfix.IssueResolutionAcceptor;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

/**
 * @author Henrik Rentz-Reichert
 * @author jayant
 * 
 */
public class BehaviorQuickfixProvider extends AbstractQuickfixProvider implements IBehaviorQuickfixProvider {

	private static final String ADD_IMG = "icons/quickfix/add.gif";
	private static final String SUB_IMG = "icons/quickfix/add.gif";

	@Fix(AbstractExecutionValidator.DIAG_CODE_MISSING_TRIGGER)
	public void fixMissingTrigger(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		final String msgName = issue.getIssueData()[1];
		final String ifItemName = issue.getIssueData()[2];
		acceptor.accept(issue, "Add the missing trigger",
				"Adds a new self-transition with trigger to handle message "
						+ msgName + " from port " + ifItemName, ADD_IMG,
				new IDiagramModification() {

					@Override
					public boolean apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// make a new self-transition & add a Trigger to handle
						// message

						// check preconditions & get pictogram element
						EObject obj = issue.getSourceEObject();
						if (!(obj instanceof StateGraph))
							return false;

						State state = ((StateGraph) obj).getStates().get(
								issue.getIndex());
						List<PictogramElement> pes = Graphiti.getLinkService()
								.getPictogramElements(diagram, state);
						if (pes.size() != 1
								|| !(pes.get(0) instanceof ContainerShape))
							// unexpected
							return false;

						// find matching interface item and message
						ActorClass ac = SupportUtil.getInstance().getActorClass(diagram);

						// it is crucial that we consider all emitters of
						// messages (port, saps, spps)
						// including base classes
						List<InterfaceItem> items = SupportUtil.getInstance().getRoomHelpers()
								.getAllInterfaceItems(ac);
						for (InterfaceItem item : items) {
							if (item.getName().equals(ifItemName)) {
								List<Message> msgs = SupportUtil.getInstance().getRoomHelpers()
										.getIncoming(item);
								for (Message msg : msgs) {
									if (msg.getName().equals(msgName)) {
										// create triggered transition with our
										// trigger and add it to the state graph
										TriggeredTransition trans = FSMFactory.eINSTANCE
												.createTriggeredTransition();
										trans.setName(SupportUtil.getInstance().getFSMNewNamingUtil()
												.getUniqueName("tr", (StateGraph) state
														.eContainer()));
										Trigger tri = FSMFactory.eINSTANCE
												.createTrigger();
										trans.getTriggers().add(tri);
										MessageFromIf mif = FSMFactory.eINSTANCE
												.createMessageFromIf();
										mif.setFrom(item);
										mif.setMessage(msg);
										tri.getMsgFromIfPairs().add(mif);
										((StateGraph) obj).getTransitions()
												.add(trans);

										// connect both ends to our state
										// caution: the returned
										// TransitionTerminal is created by this
										// call and will be
										// owned by the transition. Therefore we
										// have to do it twice
										ContainerShape shape = (ContainerShape) pes
												.get(0);
										Anchor anchor = shape.getAnchors().get(
												0);
										TransitionTerminal src = SupportUtil.getInstance()
												.getTransitionTerminal(anchor, fp);
										TransitionTerminal tgt = SupportUtil.getInstance()
												.getTransitionTerminal(anchor, fp);
										trans.setFrom(src);
										trans.setTo(tgt);

										// prepare a context for Graphiti
										AddConnectionContext addContext = new AddConnectionContext(
												anchor, anchor);
										addContext.setNewObject(trans);

										// and let the feature provider delegate
										// to the correct feature
										return fp.addIfPossible(addContext) != null;
									}
								}
							}
						}
						return false;
					}
				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_MISSING_MESSAGESEND)
	public void fixMissingMessageSend(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		final String msgName = issue.getIssueData()[1];
		final String ifItemName = issue.getIssueData()[2];
		final String codeString = ifItemName + '.' + msgName;
		acceptor.accept(issue, "Add Entry Code to send message",
				"Adds Entry Code to send " + msgName + " to port " + ifItemName
						+ " in Edit State Dialog", ADD_IMG,
				new IDiagramModification() {
					@Override
					public boolean apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// open the State Property Dialog & add detail code to
						// send message to the port

						// check preconditions & get pictogram element
						EObject obj = issue.getSourceEObject();
						if (!(obj instanceof StateGraph))
							return false;

						State state = ((StateGraph) obj).getStates().get(
								issue.getIndex());
						List<PictogramElement> pes = Graphiti.getLinkService()
								.getPictogramElements(diagram, state);
						if (pes.size() != 1
								|| !(pes.get(0) instanceof ContainerShape))
							// unexpected
							return false;

						// Open StatePropertyDialog, add line, select added line
						ActorClass ac = SupportUtil.getInstance().getActorClass(diagram);
						Shell shell = PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell();
						StatePropertyDialog dlg = new StatePropertyDialog(
								shell, ac, state, true);
						dlg.setCodeSelectionString(codeString,
								EnumSet.of(Where.ENTRY));
						dlg.setAddCode(true);
						dlg.setMessageDialogContents(
								"Please complete the code with the newly inserted and highlighted fragment.",
								"Quick Fix");
						if (dlg.open() == Window.OK) {
							return true;
						}
						return false;
					}
				});

		acceptor.accept(issue, "Add Exit Code to send message",
				"Adds Exit Code to send " + msgName + " to port " + ifItemName
						+ " in Edit State Dialog", ADD_IMG,
				new IDiagramModification() {
					@Override
					public boolean apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// add new detail code lines to send message to the exit
						// code section of the state and open the
						// StatePropertyDialog.

						// check preconditions & get pictogram element
						EObject obj = issue.getSourceEObject();
						if (!(obj instanceof StateGraph))
							return false;

						State state = ((StateGraph) obj).getStates().get(
								issue.getIndex());
						List<PictogramElement> pes = Graphiti.getLinkService()
								.getPictogramElements(diagram, state);
						if (pes.size() != 1
								|| !(pes.get(0) instanceof ContainerShape))
							// unexpected
							return false;

						// Open StatePropertyDialog, add line, select added line
						ActorClass ac = SupportUtil.getInstance().getActorClass(diagram);
						Shell shell = PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell();
						StatePropertyDialog dlg = new StatePropertyDialog(
								shell, ac, state, true);
						dlg.setCodeSelectionString(codeString,
								EnumSet.of(Where.EXIT));
						dlg.setAddCode(true);
						dlg.setMessageDialogContents(
								"Please complete the code with the newly inserted and highlighted fragment.",
								"Quick Fix");
						if (dlg.open() == Window.OK) {
							return true;
						}
						return false;
					}
				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_VIOLATION_TRIGGER)
	public void fixViolationTrigger(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		final String msgName = issue.getIssueData()[1];
		final String ifItemName = issue.getIssueData()[2];
		acceptor.accept(
				issue,
				"Remove the Violating Messgae from Trigger",
				"Remove the handled message "
						+ msgName
						+ " from port "
						+ ifItemName
						+ " from the trigger.\n"
						+ " If there are no more Messages handled by the trigger, the trigger would be removed.\n"
						+ " If there are no more triggers, the transition would be removed.",
				SUB_IMG, new IDiagramModification() {
					@Override
					public boolean apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {

						// Get the pictogram element
						EObject obj = issue.getSourceEObject();
						if (!(obj instanceof Trigger))
							return false;

						MessageFromIf mifToDelete = null;
						Trigger trig = (Trigger) obj;
						TriggeredTransition trans = (TriggeredTransition) trig
								.eContainer();

						List<PictogramElement> pes = Graphiti.getLinkService()
								.getPictogramElements(diagram, trans);
						if (pes.size() != 1)
							// unexpected
							return false;

						// Test Remove the message from the trigger
						for (MessageFromIf mif : trig.getMsgFromIfPairs()) {
							if (((Message)mif.getMessage()).getName() == msgName
									&& mif.getFrom().getName() == ifItemName) {
								mifToDelete = mif;
								break;
							}
						}

						if (mifToDelete != null) {

							if (trig.getMsgFromIfPairs().size() - 1 == 0) {
								// the trigger would be deleted

								if (trans.getTriggers().size() - 1 == 0) {
									// The transition would be deleted

									if (trans.getAction() != null) {
										Shell shell = PlatformUI.getWorkbench()
												.getActiveWorkbenchWindow()
												.getShell();
										if (!(MessageDialog
												.openQuestion(shell, "Warning",
														"Transition being removed contains Action Code. Do you want to continue?")))
											return false;
									}

									IRemoveContext rc = new RemoveContext(pes
											.get(0));
									IRemoveFeature removeFeature = fp
											.getRemoveFeature(rc);
									if (removeFeature != null) {
										removeFeature.remove(rc);
									}
									EcoreUtil.delete(trans);
									return true;

								} else
									trans.getTriggers().remove(trig);

							} else
								trig.getMsgFromIfPairs().remove(mifToDelete);

							UpdateContext updateContext = new UpdateContext(pes
									.get(0));
							return fp.updateIfPossible(updateContext) != null;
						}
						return false;
					}
				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_VIOLATION_MESSAGESEND)
	public void fixViolationMessageSend(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		final String msgName = issue.getIssueData()[0];
		final String ifItemName = issue.getIssueData()[1];
		final String codeString = ifItemName + '.' + msgName;
		acceptor.accept(issue, "Inspect & remove the offending message",
				"Removes the message " + msgName + " sent to the port "
						+ ifItemName + " in Edit State Dialog.", ADD_IMG,
				new IDiagramModification() {

					@Override
					public boolean apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// Select the offending piece of action code in Property
						// Dialogs.

						EObject obj = issue.getSourceEObject();
						if (obj instanceof State || obj instanceof StateGraph) {

							// get the pictogram element for State
							State state;
							if (obj instanceof StateGraph)
								state = ((StateGraph) obj).getStates().get(
										issue.getIndex());
							else
								state = (State) obj;

							List<PictogramElement> pes = Graphiti
									.getLinkService().getPictogramElements(
											diagram, state);
							if (pes.size() != 1
									|| !(pes.get(0) instanceof ContainerShape))
								// unexpected
								return false;

							// Open StatePropertyDialog & select the offending
							// code
							ActorClass ac = SupportUtil.getInstance().getActorClass(diagram);
							Shell shell = PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell();
							StatePropertyDialog dlg = new StatePropertyDialog(
									shell, ac, state, true);
							dlg.setCodeSelectionString(codeString, EnumSet.of(
									Where.ENTRY, Where.EXIT, Where.DO));
							dlg.setMessageDialogContents(
									"Please remove the highlighted code after inspection.",
									"Quick Fix");
							if (dlg.open() == Window.OK) {
								return true;
							}
							return false;

						} else if (obj instanceof Transition
								|| obj instanceof Trigger) {
							// Get pictogram element for Transition
							Transition transition;
							if (obj instanceof Trigger)
								transition = (Transition) obj.eContainer();
							else
								transition = (Transition) obj;

							List<PictogramElement> pes = Graphiti
									.getLinkService().getPictogramElements(
											diagram, transition);
							if (pes.size() != 1)
								// unexpected
								return false;

							// Open TransitionPropertyDialog & select the
							// offending piece of code
							Shell shell = PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell();
							TransitionPropertyDialog dlg = new TransitionPropertyDialog(
									shell, SupportUtil.getInstance().getActorClass(diagram),
									transition);
							dlg.setCodeSelectionString(codeString);
							dlg.setMessageDialogContents(
									"Please remove the highlighted code after inspection.",
									"Quick Fix");
							if (dlg.open() == Window.OK) {
								return true;
							}
						}
						return false;
					}
				});
	}
}