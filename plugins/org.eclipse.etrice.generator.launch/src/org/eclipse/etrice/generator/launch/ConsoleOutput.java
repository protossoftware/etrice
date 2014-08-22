/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.generator.fsm.base.ILineOutput;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.shared.SharedStateModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class ConsoleOutput implements ILineOutput {

	@Inject
	private IURIEditorOpener uriEditorOpener;

	private MessageConsoleStream stream;

	public ConsoleOutput(MessageConsoleStream stream) {
		this.stream = stream;

		// - activate hyperlinks
		Injector injector = Guice.createInjector(new SharedStateModule());
		uriEditorOpener = injector.getInstance(IURIEditorOpener.class);
		stream.getConsole().addPatternMatchListener(new URIHyperlinkSetter());
		// ----
	}

	@Override
	public void println(String txt) {
		stream.println(txt);
	}

	/**
	 * Provides hyperlinks for uri strings.
	 * <ul>
	 * <li>creates hyperlinks for valid {@link URI}s<br>
	 * <li>hyperlink delegates to {@link IURIEditorOpener}, which considers uri fragments
	 * <li>hyperlink can read line number, that comes from {@link org.eclipse.xtext.validation.Issue#toString()}
	 * </ul>
	 */
	private class URIHyperlinkSetter implements IPatternMatchListener {

		private final static int URI_GROUP = 1;
		private final static int LINE_NUMBER_GROUP = 4;
		private final static String LINE_REGEX = "line\\s?:\\s?(\\d+)";
		private final static String URI_REGEX = "(resource|platform|file):/[^\\s\\(\\)\\[\\]]+";
		// match simplified URI and optional line number
		private final static String HYPERLINK_REGEX = "(" + URI_REGEX + ")(\\s" + LINE_REGEX + ")?";

		private Pattern hyperlinkPattern = Pattern.compile(HYPERLINK_REGEX);

		@Override
		public void connect(TextConsole console) {
		}

		@Override
		public void disconnect() {
		}

		@Override
		public void matchFound(PatternMatchEvent event) {
			try {
				String match = stream.getConsole().getDocument().get(event.getOffset(), event.getLength());

				Matcher lineMatcher = hyperlinkPattern.matcher(match);
				if (!lineMatcher.matches())
					return;

				URI uri = URI.createURI(lineMatcher.group(URI_GROUP), true);

				// provide hyperlink for uri ?
				if (uri == null || uri.fileExtension() == null)
					return;

				String lineNumber = lineMatcher.group(LINE_NUMBER_GROUP);
				stream.getConsole().addHyperlink(new XtextLink(uri, lineNumber), event.getOffset(), event.getLength());
			}
			catch (Throwable e) {
				// invalid URI
			}
		}

		@Override
		public String getPattern() {
			return HYPERLINK_REGEX;
		}

		@Override
		public int getCompilerFlags() {
			return 0;
		}

		@Override
		public String getLineQualifier() {
			return null;
		}
	}

	private class XtextLink implements IHyperlink {

		private URI uri;
		private String lineNumber;

		public XtextLink(URI uri, String lineNumber) {
			this.uri = uri;
			this.lineNumber = lineNumber;
		}

		@Override
		public void linkEntered() {
		}

		@Override
		public void linkExited() {
		}

		@Override
		public void linkActivated() {
			int line = -1;
			if (lineNumber != null && !uri.hasFragment()) {
				try {
					line = Integer.parseInt(lineNumber);
				}
				catch (NumberFormatException e) {
				}
			}
			IEditorPart editor = uriEditorOpener.open(uri, true);
			if (editor instanceof ITextEditor && line > 0) {
				ITextEditor textEditor = (ITextEditor) editor;
				IDocument document = textEditor.getDocumentProvider().getDocument(editor.getEditorInput());
				if (document == null)
					return;
				try {
					int lineOffset = document.getLineOffset(line - 1);
					textEditor.selectAndReveal(lineOffset, 0);
				}
				catch (BadLocationException e) {
				}
			}

		}

	}
}