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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;

/**
 * A class for maintaining the current context during Content Assistance in
 * Action Code Editor. Helps in identifying the completion context (method or
 * InterafceItem/member) and also the {@link InterfaceItem} on which the assist
 * is invoked.
 * 
 * @author jayant
 */
public class ActionCodeContext extends ContentAssistInvocationContext {

	/** the character separating the method name and the interface item */
	public static final char METHOD_ITEM_SEPARATOR = '.';

	/** the associated interface item */
	private InterfaceItem fInterfaceItem;
	/** the action code parser object for getting the list of items */
	private ActionCodeParser fActionCodeParser;
	/** is method completion required or InterafceItem/member completion */
	private boolean methodContext;

	public ActionCodeContext(ActionCodeParser detailedCodeParser) {
		super();
		fInterfaceItem = null;
		methodContext = false;
		this.fActionCodeParser = detailedCodeParser;
	}

	public ActionCodeContext(IDocument document, int offset,
			ActionCodeParser detailedCodeParser) {
		super(document, offset);
		this.fActionCodeParser = detailedCodeParser;
	}

	public ActionCodeContext(ITextViewer viewer, int offset,
			ActionCodeParser detailedCodeParser) {
		super(viewer, offset);
		this.fActionCodeParser = detailedCodeParser;
	}

	public ActionCodeContext(ITextViewer viewer,
			ActionCodeParser detailedCodeParser) {
		super(viewer);
		this.fActionCodeParser = detailedCodeParser;
	}

	/**
	 * Compute the {@link InterfaceItem} for the invocation offset.
	 * 
	 * @return the associated interface item. Returns {@code null} is no
	 *         interface item associated with the invocation.
	 */
	public InterfaceItem computeInterfaceItem() {

		if (fInterfaceItem == null) {
			if (fActionCodeParser == null)
				return null;

			int newOffset;
			try {
				// get the position of character just before the prefix to be
				// complete.
				newOffset = getInvocationOffset()
						- computeIdentifierPrefix().length() - 1;

				// if the character is method separator, then proceed with
				// identification of interafecItem.
				if (getDocument().getChar(newOffset) == METHOD_ITEM_SEPARATOR) {
					// method completion is required
					methodContext = true;

					// use context API to get the interface name.
					ContentAssistInvocationContext context = new ContentAssistInvocationContext(
							getViewer(), newOffset);
					fInterfaceItem = fActionCodeParser
							.getInterfaceItemfromName(context
									.computeIdentifierPrefix().toString());
				}
			} catch (BadLocationException e) {
				fInterfaceItem = null;
			}
		}
		return fInterfaceItem;
	}

	/**
	 * Returns whether the required completion is for a method.
	 * 
	 * @return true if the method completion is required
	 */
	public boolean isMethodContext() {
		computeInterfaceItem();
		return methodContext;
	}

	/**
	 * Gets the string of the invocation context which need to be completed.
	 * 
	 * @return the string to be completed (prefix for completion)
	 */
	public String getPrefix() {
		String prefix;
		try {
			prefix = computeIdentifierPrefix().toString();
		} catch (BadLocationException e) {
			prefix = "";
		}
		return prefix;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) && obj instanceof ActionCodeContext) {
			ActionCodeContext other = (ActionCodeContext) obj;
			return fInterfaceItem.equals(other.fInterfaceItem);
		}
		return false;
	}
}