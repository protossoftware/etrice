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

package org.eclipse.etrice.ui.behavior.fsm.actioneditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.swt.widgets.Composite;

/**
 * A Registry for Action Code Editors. Helps in lazy loading of the extensions
 * and instantiation of Editors.
 */
public class ActionCodeEditorRegistry {

	/**
	 * The Singleton instance of the Action Code Registry.
	 */
	public static final ActionCodeEditorRegistry INSTANCE = new ActionCodeEditorRegistry();

	/**
	 * Private constructor to prevent instantiation and make Singleton.
	 */
	private ActionCodeEditorRegistry() {
	}

	// Constants used when reading "actionCodeEditor" extension point.
	public static final String TAG_EDITOR = "editor";
	public static final String ATT_NAME = "editorName";
	public static final String ATT_CLASS = "class";
	public static final String ATT_ID = "id";
	public static final String ATT_TARGET_LANGUAGE = "targetLanguage";
	public static final String TARGET_LANGUAGE_ALL = "ALL";
	public static final String TARGET_LANGUAGE_JAVA = "JAVA";
	public static final String TARGET_LANGUAGE_CPP = "C++";
	public static final String TARGET_LANGUAGE_OTHER = "OTHER";

	public class ActionCodeEditorRegistryEntry {

		private IConfigurationElement configElem;
		private final String name;
		private final String id;
		private final String targetLanguage;
		private IActionCodeEditorFactory factory;

		public ActionCodeEditorRegistryEntry(IConfigurationElement configElem) {
			this.configElem = configElem;
			name = getAttribute(configElem, ATT_NAME);
			id = getAttribute(configElem, ATT_ID);
			targetLanguage = getAttribute(configElem, ATT_TARGET_LANGUAGE);

			// Make sure that class is defined,
			// but don't load it.
			getAttribute(configElem, ATT_CLASS);
		}

		/**
		 * The human readable name for the Action Code Editor
		 */
		public String getName() {
			return name;
		}

		/**
		 * The id for the Action Code Editor
		 */
		public String getId() {
			return id;
		}

		/**
		 * The Target language for the editor
		 */
		public String getTargetLanguage() {
			return targetLanguage;
		}

		/**
		 * Instantiates a new Action Code Editor which has been registered by
		 * this registry entry.
		 * 
		 * @param detailCode
		 *            the {@link DetailCode} to be shown
		 * @param parent
		 *            the parent {@link Composite} in which the Editor will be
		 *            shown
		 * 
		 * @return the {@link IActionCodeEditor} instance or <code>null</code>
		 */
		public IActionCodeEditor newActionCodeEditor(Composite parent, String text, IDetailExpressionProvider exprProvider) {
			IActionCodeEditorFactory factory = getFactory();
			if (factory == null)
				return null;
			return factory.createActionCodeEditor(parent, text, exprProvider);
		}

		/**
		 * Gives the factory for instantiating items of the associated Action
		 * Code Editor
		 * 
		 * @return the factory or <code>null</code> if the factory itself could
		 *         not be instantiated
		 */
		private IActionCodeEditorFactory getFactory() {
			if (factory != null) {
				return factory;
			}
			try {
				factory = (IActionCodeEditorFactory) configElem
						.createExecutableExtension(ATT_CLASS);
			} catch (Exception e) {
				MultiStatus status = new MultiStatus(Activator.PLUGIN_ID,
						Status.ERROR, "Failed to instantiate factory: "
								+ configElem.getAttribute(ATT_CLASS)
								+ " in id: "
								+ id
								+ " in plugin: "
								+ configElem.getDeclaringExtension()
										.getNamespaceIdentifier(), e);
				Activator.getDefault().getLog().log(status);
			}
			return factory;
		}

		/**
		 * Dispose of any OS resources
		 */
		public void dispose() {
			if (factory == null)
				return;
			factory.dispose();
			factory = null;
		}

		/**
		 * Protected Getter for creation of
		 * {@link ActionCodeEditorRegistry#UNKNOWN} Editor entry
		 */
		protected ActionCodeEditorRegistryEntry() {
			this.name = "Unknown";
			this.id = "Unknown";
			this.targetLanguage = TARGET_LANGUAGE_OTHER;
			this.configElem = null;
		}
	}

	/**
	 * An cache of {@link ActionCodeEditorRegistryEntry} objects loaded from the
	 * "actionCodeEditor" extension point.
	 */
	private ActionCodeEditorRegistryEntry[] cachedEditorEntries;

	/**
	 * Gets the {@link ActionCodeEditorRegistryEntry} object with the given id.
	 * 
	 * @param id
	 *            the id of the editor to be found
	 * 
	 * @return a {@code ActionCodeEditorRegistryEntry} object for editor with
	 *         given id. Returns {@code null} id no such object is present.
	 */
	public ActionCodeEditorRegistryEntry getEditorWithId(String id) {
		ActionCodeEditorRegistryEntry[] entries = getEditors();
		for (ActionCodeEditorRegistryEntry entry : entries)
			if (entry.getId().equals(id))
				return entry;
		return null;
	}

	/**
	 * Gives an array of {@link ActionCodeEditorRegistryEntry} loaded from the
	 * "actionCodeEditor" extension point for the given target language.
	 * 
	 * @param targetLanguage
	 *            the target language for which editor is required.
	 * 
	 * @return an array of {@link ActionCodeEditorRegistryEntry} (not
	 *         <code>null</code>)
	 */
	public ActionCodeEditorRegistryEntry[] getEditorsForTargetLanguage(
			String targetLanguage) {
		ActionCodeEditorRegistryEntry[] entries = getEditors();

		List<ActionCodeEditorRegistryEntry> found = new ArrayList<ActionCodeEditorRegistryEntry>();
		for (ActionCodeEditorRegistryEntry entry : entries) {
			String editorTargetLanguage = entry.getTargetLanguage();
			if (editorTargetLanguage.equals(targetLanguage)
					|| editorTargetLanguage.equals(TARGET_LANGUAGE_ALL))
				found.add(entry);
		}

		return (ActionCodeEditorRegistryEntry[]) found
				.toArray(new ActionCodeEditorRegistryEntry[found.size()]);
	}

	/**
	 * Gives an array of {@link ActionCodeEditorRegistryEntry} loaded from the
	 * "actionCodeEditor" extension point as necessary.
	 * 
	 * @return an array of {@link ActionCodeEditorRegistryEntry} (not
	 *         <code>null</code>)
	 */
	public ActionCodeEditorRegistryEntry[] getEditors() {
		if (cachedEditorEntries != null)
			return cachedEditorEntries;

		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(Activator.PLUGIN_ID, "actionCodeEditor")
				.getExtensions();

		List<ActionCodeEditorRegistryEntry> found = new ArrayList<ActionCodeEditorRegistryEntry>();

		for (IExtension extension : extensions) {
			IConfigurationElement[] configElements = extension
					.getConfigurationElements();
			for (IConfigurationElement configElement : configElements) {
				ActionCodeEditorRegistryEntry entry = parseEditorEntries(configElement);
				if (entry != null)
					found.add(entry);
			}
		}

		cachedEditorEntries = (ActionCodeEditorRegistryEntry[]) found
				.toArray(new ActionCodeEditorRegistryEntry[found.size()]);
		return cachedEditorEntries;
	}

	/**
	 * Parse a editor parameters to create {@link ActionCodeEditorRegistryEntry}
	 * 
	 * @param configElem
	 *            the configuration element containing the editor attributes.
	 * 
	 * @return the {@link ActionCodeEditorRegistryEntry} or <code>null</code> if
	 *         the parse has failed
	 */
	private ActionCodeEditorRegistryEntry parseEditorEntries(
			IConfigurationElement configElement) {
		if (!configElement.getName().equals(TAG_EDITOR))
			return null;
		try {
			return new ActionCodeEditorRegistryEntry(configElement);
		} catch (Exception e) {
			String id = configElement.getAttribute(ATT_ID);
			if (id == null)
				id = "[missing id attribute]";
			String msg = "Failed to load action code editor with id "
					+ id
					+ " in "
					+ configElement.getDeclaringExtension()
							.getNamespaceIdentifier();
			Activator
					.getDefault()
					.getLog()
					.log(new MultiStatus(Activator.PLUGIN_ID, Status.ERROR,
							msg, e));
			return null;
		}
	}

	/**
	 * Dispose of any OS resources. Must be called by the plugin before
	 * shutdown.
	 */
	public void dispose() {
		if (cachedEditorEntries == null)
			return;
		for (int i = 0; i < cachedEditorEntries.length; i++)
			cachedEditorEntries[i].dispose();
		cachedEditorEntries = null;
	}

	/**
	 * Get the given attribute value from the given
	 * {@link IConfigurationElement} instance. Throws exception if no value
	 * found.
	 * 
	 * @param configElem
	 *            the configuration element containing the editor attributes.
	 * @param attrName
	 *            the attribute required.
	 * 
	 * @return the value of the attribute.
	 */
	private static String getAttribute(IConfigurationElement configElem,
			String attrName) {
		String value = configElem.getAttribute(attrName);
		if (value != null)
			return value;
		throw new IllegalArgumentException("Missing " + attrName + " attribute");
	}
}