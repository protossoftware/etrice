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

import org.eclipse.core.runtime.Assert;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * A model aware configuration for the {@link SourceViewerActionCodeEditor}.
 * Setters within this class could only be invoked before configuring the
 * {@link SourceViewer} with this configuration.
 * 
 * @author jayant
 */
public class ActionCodeEditorConfiguration extends SourceViewerConfiguration {

	/** the actor class */
	private ActorClass fActorClass;
	/** use members */
	private boolean fMemberAware;
	/** use messages or operations */
	private boolean fMessageAware;
	/** use receive messages only */
	private boolean fRecvMessagesOnly;
	/** parser for Action Code of the associated actor class */
	private ActionCodeParser parser;

	/** Color Manager for action code editor */
	private ActionCodeColorManager fColorManager;

	public ActionCodeEditorConfiguration(ActionCodeColorManager colorManager) {
		fColorManager = colorManager;
		fActorClass = null;
		fMemberAware = false;
		fMessageAware = false;
		fRecvMessagesOnly = false;
	}

	public ActionCodeEditorConfiguration(ActionCodeColorManager colorManager,
			ActorClass ac) {
		super();
		fActorClass = ac;
		fColorManager = colorManager;
		fMemberAware = true;
		fMessageAware = true;
		fRecvMessagesOnly = false;
	}

	public ActionCodeEditorConfiguration(ActionCodeColorManager colorManager,
			ActorClass ac, boolean useMembers, boolean useMessages,
			boolean useRecvMessagesOnly) {
		super();
		fActorClass = ac;
		fColorManager = colorManager;
		fMemberAware = useMembers;
		fMessageAware = useMessages;
		fRecvMessagesOnly = useRecvMessagesOnly;
	}

	/**
	 * Getter for actor class.
	 * 
	 * @return the associated actor class
	 */
	public ActorClass getActorClass() {
		return fActorClass;
	}

	/**
	 * Getter for use members.
	 * 
	 * @return true if configuration is member aware else false
	 */
	public boolean isMemberAware() {
		return fMemberAware;
	}

	/**
	 * Getter for use messages.
	 * 
	 * @return true if configuration is message aware else false
	 */
	public boolean isMessageAware() {
		return fMessageAware;
	}

	/**
	 * Getter for use receive only messages.
	 * 
	 * @return true if configuration handles only receive only messages else
	 *         false
	 */
	public boolean isRecvOnly() {
		return fRecvMessagesOnly;
	}

	/**
	 * Getter for internal action code parser for the associated actor class.
	 * 
	 * @return the parser for action code of the associated actor class
	 */
	public ActionCodeParser getActionCodeParser() {
		if (parser == null)
			parser = new ActionCodeParser(fActorClass, fRecvMessagesOnly);
		return parser;
	}

	/**
	 * Getter for color manager.
	 * 
	 * @return the color manager for action code
	 */
	public ActionCodeColorManager getColorManager() {
		if (fColorManager == null)
			fColorManager = new ActionCodeColorManager();
		return fColorManager;
	}

	/**
	 * Setter for actor class. Invalidates the internal action code parser.
	 * 
	 * @param ac
	 *            the Actor Class to associate to.
	 */
	public void setActorClass(ActorClass ac) {
		if (!ac.equals(fActorClass)) {
			fActorClass = ac;
			parser = null;
		}
	}

	/**
	 * Setter for use members.
	 * 
	 * @param useMembers
	 *            true to make configuration member aware
	 */
	public void setMemberAware(boolean useMembers) {
		fMemberAware = useMembers;
	}

	/**
	 * Setter for use messages.
	 * 
	 * @param useMessages
	 *            true to make configuration message & operation aware
	 */
	public void setMessageAware(boolean useMessages) {
		fMessageAware = useMessages;
	}

	/**
	 * Setter for use receive messages only. Invalidates the internal action
	 * code parser.
	 * 
	 * @param useRecvMessagesOnly
	 *            true to use receive messages only
	 */
	public void setRecvOnly(boolean useRecvMessagesOnly) {
		if (useRecvMessagesOnly != fRecvMessagesOnly) {
			fRecvMessagesOnly = useRecvMessagesOnly;

			// Only invalidate parser if the configuration is message aware.
			if (fMessageAware)
				parser = null;
		}
	}

	/**
	 * Setter for action code Color Manager.
	 * 
	 * @param colorManager
	 *            the color manager to use
	 */
	public void setColorManager(ActionCodeColorManager colorManager) {
		Assert.isNotNull(colorManager);
		fColorManager = colorManager;
	}
}