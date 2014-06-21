/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.text;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.AbstractActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.support.SupportUtil;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * An Implementation of the {@link IActionCodeEditor} interface using the SWT
 * {@link Text} widget.
 * <p>
 * Sub-classes may supply a custom {@link SourceViewerConfiguration} using the
 * {@link #setSourceViewerConfiguration(SourceViewerConfiguration)} method and a
 * custom {@link Document} creation methodology using the
 * {@link #createDocument(DetailCode)} method.
 * </p>
 * 
 * @author jayant
 */
public class TextActionCodeEditor extends AbstractActionCodeEditor {

	/** the internal SWT Text widget instance */
	private Text text;

	@Override
	public void init(DetailCode detailCode) throws CoreException {
		setDetailCode(detailCode);
	}

	@Override
	public void createControl(Composite parent) {
		int style = SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
		text = new Text(parent, style);
		if (fDetailCode != null)
			text.setText(SupportUtil.getInstance().getRoomHelpers()
					.getDetailCode(fDetailCode));
		text.setEnabled(true);
	}

	@Override
	public Control getControl() {
		return text;
	}

	@Override
	public void insertText(String txt) {
		int begin = txt.indexOf('(');
		int end = txt.indexOf(')');
		int offset = text.getSelection().x;
		text.insert(txt);
		if (begin >= 0 && end >= 0 && end > begin + 1)
			text.setSelection(offset + begin + 1, offset + end);
		text.setFocus();
	}
}