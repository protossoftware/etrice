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

package org.eclipse.etrice.core.ui.quickfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BaseFactory;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.ui.quickfix.FSMQuickfixProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.MessageData;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.validation.RoomJavaValidator;
import org.eclipse.etrice.core.validation.WiringValidator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

public class RoomQuickfixProvider extends FSMQuickfixProvider {

	/**
	 * @author Henrik Rentz-Reichert
	 *
	 */
	private final class ChangeAnnotationAttributeModification implements ISemanticModification {
		private String val;
		
		private ChangeAnnotationAttributeModification(String val) {
			this.val = val;
		}
		
		@Override
		public void apply(EObject element, IModificationContext context) throws Exception {
			KeyValue kv = (KeyValue) element;
			StringLiteral sl = BaseFactory.eINSTANCE.createStringLiteral();
			sl.setValue(val);
			kv.setValue(sl);
		}
	}
	
	@Inject QualifiedNameValueConverter fqnConverter;

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		List<IssueResolution> result = new ArrayList<IssueResolution>();
		
		result.addAll(super.getResolutions(issue));
		
		IssueResolutionAcceptor acceptor = getIssueResolutionAcceptorProvider().get();
		QuickfixExtensionManager.getInstance().getResolutions(issue, acceptor);
		
		result.addAll(acceptor.getIssueResolutions());
		
		return result;
	}
	
	@Override
	public boolean hasResolutionFor(String issueCode) {
		return super.hasResolutionFor(issueCode) || QuickfixExtensionManager.getInstance().hasResolutionFor(issueCode);
	}
	
	@Fix(RoomJavaValidator.WRONG_MODEL_NAME)
	public void renameModel(final Issue issue, IssueResolutionAcceptor acceptor) {
		String replacement = fqnConverter.toString(issue.getData()[1]);
		acceptor.accept(issue, "Rename model", "Replace model name with its location on the modelpath \nfollowed by its file name",
				"correction_change.gif", new ReplaceModification(issue, replacement));
	}
	
	@Fix(RoomJavaValidator.THREAD_MISSING)
	public void fixMissingThread(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add a default thread", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = issue.getOffset()+issue.getLength()-1;
				String insertion = "\n\t\t"+issue.getData()[0]+"\n\t";
				xtextDocument.replace(offset, 0, insertion);
			}
		});
	}

	@Fix(RoomJavaValidator.DUPLICATE_ACTOR_INSTANCE_MAPPING)
	public void removeDuplicateThreadMapping(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate mapping", "remove this mapping", "remove.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}
	
	@Fix(RoomJavaValidator.WRONG_NAMESPACE)
	public void fixWrongNamespace(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace with root namespace", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String replacement = issue.getData()[0];
				xtextDocument.replace(issue.getOffset(), issue.getLength(), replacement);
			}
		});
	}
	
	@Fix(RoomJavaValidator.CIRCULAR_CONTAINMENT)
	public void fixCircularContainment(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make attribute a reference", "add 'ref' keyword", "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = Integer.parseInt(issue.getData()[0]);
				xtextDocument.replace(issue.getOffset()+offset, 0, " ref");
			}
		});
	}
	
	@Fix(WiringValidator.ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL)
	public void makeActorRefRefTypeOptional(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make actor reference fixed", "optional ActorRef...", "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				ActorRef ar = (ActorRef) element;
				ar.setRefType(ReferenceType.OPTIONAL);
			}
		});
	}
	
	@Fix(RoomJavaValidator.INVALID_ANNOTATION_TARGET)
	public void fixInvalidAnnotationTarget(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove this annotation", "remove @"+issue.getData()[0]+"...", "add.gif", new ISemanticModification() {
			@SuppressWarnings("unchecked")
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Annotation ann = (Annotation) element;
				Object getterResult = ann.eContainer().eGet(ann.eContainingFeature());
				((List<? extends EObject>) getterResult).remove(ann);
			}
		});
		
		acceptor.accept(issue, "Add this target to the definition", issue.getData()[1], "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Annotation ann = (Annotation) element;
				ann.getType().getTargets().add(issue.getData()[2]);
			}
		});
	}
	
	@Fix(RoomJavaValidator.DUPLICATE_ANNOTATION_TARGETS)
	public void fixDuplicateAnnotationTarget(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove the duplicate target", "remove "+issue.getData()[0], "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				AnnotationType at = (AnnotationType) element;
				Iterator<String> it = at.getTargets().iterator();
				while (it.hasNext()) {
					String tgt = it.next();
					if (tgt.equals(issue.getData()[0]))
						it.remove();
				}
				at.getTargets().add(issue.getData()[0]);
			}
		});
	}
	
	@Fix(RoomJavaValidator.MANDATORY_ATTRIBUTE_MISSING)
	public void fixMissingAttribute(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add missing attribute", "add "+issue.getData()[0], "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Annotation ann = (Annotation) element;
				KeyValue kv = BaseFactory.eINSTANCE.createKeyValue();
				kv.setKey(issue.getData()[0]);
				for (AnnotationAttribute att : ann.getType().getAttributes()) {
					if (att.getName().equals(issue.getData()[0])) {
						if (att instanceof SimpleAnnotationAttribute) {
							switch (((SimpleAnnotationAttribute) att).getType()) {
								case BOOL: {
									BooleanLiteral bl = BaseFactory.eINSTANCE.createBooleanLiteral();
									kv.setValue(bl);
									break;
								}
								case CHAR: {
									StringLiteral sl = BaseFactory.eINSTANCE.createStringLiteral();
									sl.setValue("");
									kv.setValue(sl);
									break;
								}
								case INT: {
									IntLiteral il = BaseFactory.eINSTANCE.createIntLiteral();
									il.setValue(0);
									kv.setValue(il);
									break;
								}
								case REAL: {
									RealLiteral rl = BaseFactory.eINSTANCE.createRealLiteral();
									rl.setValue(0);
									kv.setValue(rl);
									break;
								}
							}
						}
						else if (att instanceof EnumAnnotationAttribute) {
							StringLiteral sl = BaseFactory.eINSTANCE.createStringLiteral();
							sl.setValue(((EnumAnnotationAttribute) att).getValues().get(0));
							kv.setValue(sl);
						}
						else {
							assert(false): "unexpected sub type";
						}
						ann.getAttributes().add(kv);
						break;
					}
				}
			}
		});
	}
	
	@Fix(RoomJavaValidator.UNDEFINED_ANNOTATION_ATTRIBUTE)
	public void fixUndefinedAnnotationAttribute(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove undefined attribute", "remove "+issue.getData()[0], "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Annotation ann = (Annotation) element;
				Iterator<KeyValue> it = ann.getAttributes().iterator();
				while (it.hasNext()) {
					KeyValue kv = it.next();
					if (kv.getKey().equals(issue.getData()[0])) {
						it.remove();
						break;
					}
				}
			}
		});
	}
	
	@Fix(RoomJavaValidator.UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE)
	public void fixUndefinedAnnotationAttributeValue(final Issue issue, IssueResolutionAcceptor acceptor) {
		for (int i=0; i<issue.getData().length; ++i) {
			acceptor.accept(issue, "Change attribute value to "+issue.getData()[i], "... = "+issue.getData()[i], "add.gif",
					new ChangeAnnotationAttributeModification(issue.getData()[i]));
		}
	}
	
	@Fix(RoomJavaValidator.DUPLICATE_ANNOTATION_ATTRIBUTE)
	public void fixDuplicateAnnotationAttribute(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate attribute "+issue.getData()[0], "remove "+issue.getData()[0], "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Annotation ann = (Annotation) element;
				for (int i=ann.getAttributes().size()-1; i>=0; --i) {
					KeyValue kv = ann.getAttributes().get(i);
					if (kv.getKey().equals(issue.getData()[0])) {
						ann.getAttributes().remove(i);
						break;
					}
				}
			}
		});

	}
	
	@Fix(RoomJavaValidator.OPERATION_MISSING_OVERRIDE)
	public void fixOperationMissingOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Mark operation as override", "add 'override' keyword", "add.gif", new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				((StandardOperation)element).setOverride(true);	
			}
		});
	}
	
	@Fix(RoomJavaValidator.OPERATION_EXTRANEOUS_OVERRIDE)
	public void fixOperationExtraneousOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove 'override' keyword", "", "remove.gif", new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				((StandardOperation)element).setOverride(false);	
			}
		});
	}
	
	@Fix(RoomJavaValidator.INCONSISTENT_COMMUNICATION_TYPE)
	public void makeActorClassCommTypeLikeBaseClass(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Set communication type as for base class.", issue.getData()[0]+" ActorClass "+issue.getData()[1]+" ...", "correction_change.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				ActorClass ac = (ActorClass) element;
				ac.setCommType(ComponentCommunicationType.get(issue.getData()[0]));
			}
		});
	}
	
	@Fix(RoomJavaValidator.DEPRECATED_MESSAGE_DATA_NAME)
	public void removeDeprecatedMessageDataName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Omit message data name.", "Remove the deprecated name for the message data.", "correction_change.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				MessageData d = (MessageData) element;
				d.setDeprecatedName(null);
			}
		});
	}

}
