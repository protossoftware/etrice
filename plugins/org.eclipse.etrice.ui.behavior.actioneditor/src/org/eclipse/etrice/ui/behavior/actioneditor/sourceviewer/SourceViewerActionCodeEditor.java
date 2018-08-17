/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * An Implementation of the {@link IActionCodeEditor} interface using the JFace
 * {@link SourceViewer}.
 * <p>
 * Sub-classes may supply a custom {@link SourceViewerConfiguration} using the
 * {@link #setSourceViewerConfiguration(SourceViewerConfiguration)} method and a
 * custom {@link Document} creation methodology using the
 * {@link #createDocument(DetailCode)} method.
 * </p>
 * 
 * @author jayant
 */
public class SourceViewerActionCodeEditor extends AbstractActionCodeEditor {

	/**
	 * An {@link IHandler} implementation for handling the Operations in this
	 * editor.
	 * 
	 * @author jayant
	 * 
	 */
	public class ActionCodeHandler extends AbstractHandler {

		int fOperation;

		public ActionCodeHandler(int operation) {
			fOperation = operation;
		}

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			fSourceViewer.getTextOperationTarget().doOperation(fOperation);
			return null;
		}
	}

	public static final String CONTENT_ASSIST_COMMAND_ID = "org.eclipse.etrice.ui.behavior.actioneditor.contentAssist";
	public static final String UNDO_COMMAND_ID = "org.eclipse.etrice.ui.behavior.actioneditor.undo";
	public static final String REDO_COMMAND_ID = "org.eclipse.etrice.ui.behavior.actioneditor.redo";

	/**
	 * The Id of custom context for the Action Code Editor Key-bindings for
	 * commands
	 */
	public static final String ACTION_EDITOR_CONTEXT_ID = "org.eclipse.etrice.ui.behavior.actioneditor.context";

	/** The editor's source viewer. */
	private ISourceViewer fSourceViewer;
	/** The editor's source viewer configuration. */
	private SourceViewerConfiguration fConfiguration;
	/** The editor's document. */
	private IDocument fDocument;

	/** The activation context Token for Action Editor Context */
	protected IContextActivation fActivation;
	/** The collection of all active handler tokens */
	protected Map<String, IHandlerActivation> activatedHandlers;

	/**
	 * Getter for the editor's document.
	 * 
	 * @return the {@link IDocument} instance of the editor
	 */
	public IDocument getDocument() {
		return fDocument;
	}

	/**
	 * Returns the editor's source viewer configuration. May return
	 * <code>null</code> before the editor's part has been created and after
	 * disposal.
	 * 
	 * @return the editor's source viewer configuration which may be
	 *         <code>null</code>
	 */
	public final SourceViewerConfiguration getSourceViewerConfiguration() {
		return fConfiguration;
	}

	/**
	 * Returns the editor's source viewer. May return <code>null</code> before
	 * the editor's part has been created and after disposal.
	 * 
	 * @return the editor's source viewer which may be <code>null</code>
	 */
	public final ISourceViewer getSourceViewer() {
		return fSourceViewer;
	}

	/**
	 * Sets this editor's source viewer configuration used to configure its
	 * internal source viewer. This method must be called before the editor's
	 * control is created. If not, this editor uses a
	 * <code>SourceViewerConfiguration</code>.
	 * 
	 * @param configuration
	 *            the source viewer configuration object
	 */
	protected void setSourceViewerConfiguration(SourceViewerConfiguration configuration) {
		Assert.isNotNull(configuration);
		fConfiguration = configuration;
	}

	/**
	 * Creates the document for the given Detailed Code.
	 * <p>
	 * Subclasses may implement this method.
	 * </p>
	 * 
	 * @param detailCode
	 *            the {@link DetailCode} object to be represented.
	 * @return the document being created.
	 */
	protected IDocument createDocument(String detailCode) {
		IDocument document = new Document(detailCode);
		return document;
	};

	/**
	 * Creates the source viewer to be used by this editor. Subclasses may
	 * re-implement this method.
	 * 
	 * @param parent
	 *            the parent control
	 * @param ruler
	 *            the vertical ruler
	 * @param styles
	 *            style bits, <code>SWT.WRAP</code> is currently not supported
	 * @return the source viewer
	 */
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {
		return new SourceViewer(parent, ruler, styles);
	}

	/**
	 * Returns whether the editor is editable or not.
	 * 
	 * @return true if editor is editable else false.
	 */
	public boolean isEditable() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Sub-classes overriding this should call
	 * {@link #doSetDetailCode(DetailCode)}.
	 * </p>
	 */
	@Override
	public void init(String detailCode) {
		doSetDetailCode(detailCode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		int styles = SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION;
		fSourceViewer = createSourceViewer(parent, null, styles);

		if (fConfiguration == null)
			fConfiguration = new SourceViewerConfiguration();
		fSourceViewer.configure(fConfiguration);

		StyledText styledText = fSourceViewer.getTextWidget();
		
		// set font to global default for editors
		styledText.setFont(JFaceResources.getTextFont());

		// Focus listener to activate and deactivate context
		styledText.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// Deactivate context when focus lost
				deactivateContext();
			}

			@Override
			public void focusGained(FocusEvent e) {
				// Activate context when focus gained
				activateContext();
			}
		});

		// Dispose listener to dispose resources
		styledText.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		// Disable orientation switching
		styledText.addListener(SWT.OrientationChange, new Listener() {
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		// Workaround: Forward changes, that are applied directly on the underlying document, to widget listeners.
		// Ensures that content assist changes are registered by swt observables + databinding.
		fSourceViewer.addTextListener(new ITextListener() {
			@Override
			public void textChanged(TextEvent event) {
				fSourceViewer.getTextWidget().notifyListeners(SWT.Modify, null);
			}
		});

		getControl()
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		initializeSourceViewer();
	}

	public void setDetailCode(String detailCode) {	
		doSetDetailCode(detailCode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control getControl() {
		return fSourceViewer.getTextWidget();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertText(String text) {
		if (fSourceViewer != null && fSourceViewer.getTextWidget() != null) {
			int braceBegin = text.indexOf('(');
			int braceEnd = text.indexOf(')');

			int offset = fSourceViewer.getSelectedRange().x;
			int length = fSourceViewer.getSelectedRange().y;

			try {
				fDocument.replace(offset, length, text);
			} catch (BadLocationException e) {
			}
			if (braceBegin >= 0 && braceEnd >= 0 && braceEnd > braceBegin + 1)
				fSourceViewer.setSelectedRange(offset + braceBegin + 1,
						braceEnd - braceBegin - 1);
			fSourceViewer.getTextWidget().setFocus();
		}
	}

	/**
	 * Method which actually sets the detailed code. This is called by
	 * {@link #init(DetailCode)} as well as by
	 * {@link #setDetailCode(DetailCode)} method.
	 * 
	 * @param detailCode
	 *            the {code DetailCode} to be set
	 * @throws CoreException
	 *             if the {code detailCode} could not be set
	 */
	protected void doSetDetailCode(String detailCode)  {
		fDocument = createDocument(detailCode);
		if (fSourceViewer != null) {
			initializeSourceViewer();
		}
	}

	/**
	 * Initializes the editor's source viewer based on the given detailed Code.
	 * 
	 * @param detailCode
	 *            the detailed Code to be used to initialize the source viewer
	 */
	private void initializeSourceViewer() {
		if (fDocument != null) {
			fSourceViewer.setDocument(fDocument, null);
			fSourceViewer.setEditable(isEditable());
			fSourceViewer.showAnnotations(false);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		deactivateContext();

		fDocument = null;
		fSourceViewer = null;
		fConfiguration = null;
	}

	/**
	 * Activates ActionEditor context and attaches handlers with the Editor's
	 * commands.
	 */
	protected void activateContext() {
		IContextService contextService = (IContextService) PlatformUI
				.getWorkbench().getService(IContextService.class);
		if (contextService != null)
			fActivation = contextService
					.activateContext(ACTION_EDITOR_CONTEXT_ID);

		activateHandler(CONTENT_ASSIST_COMMAND_ID,
				ISourceViewer.CONTENTASSIST_PROPOSALS);
		activateHandler(UNDO_COMMAND_ID, ITextOperationTarget.UNDO);
		activateHandler(REDO_COMMAND_ID, ITextOperationTarget.REDO);
	}

	/**
	 * Deactivate editors context and command handlers.
	 */
	protected void deactivateContext() {
		IContextService contextService = (IContextService) PlatformUI
				.getWorkbench().getService(IContextService.class);
		if (contextService != null)
			contextService.deactivateContext(fActivation);

		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
		if (handlerService != null && activatedHandlers != null) {
			handlerService.deactivateHandlers(activatedHandlers.values());
			activatedHandlers = null;
		}
	}

	/**
	 * Create and activate a new handler for the command with given
	 * {@code commandId} to execute the given {@code operation}.
	 * 
	 * @param commandId
	 *            the Id of the command
	 * @param operation
	 *            the operation code for the required operation to be performed
	 */
	protected void activateHandler(String commandId, int operation) {
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
		if (handlerService != null) {
			IHandlerActivation contentAssistHandlerActivation = handlerService
					.activateHandler(commandId,
							new ActionCodeHandler(operation));
			if (activatedHandlers == null)
				activatedHandlers = new HashMap<String, IHandlerActivation>();
			activatedHandlers.put(commandId, contentAssistHandlerActivation);
		}
	}

	/**
	 * Deactivate handler for the given command.
	 * 
	 * @param commandId
	 *            the Id of the command.
	 */
	protected void deactivateHandler(String commandId) {
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
		if (handlerService != null && activatedHandlers != null) {
			handlerService.deactivateHandler(activatedHandlers.get(commandId));
			activatedHandlers.remove(commandId);
		}
	}
}