/*******************************************************************************
 * Copyright (c) 2013 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

/**
 * A Utility Class for rendering error, warning and info markers in Behavior
 * Graphical Editor.
 * 
 * @author jayant
 */
public class DecoratorUtil {

	/**
	 * Private Constructor to prevent instanstiation.
	 */
	private DecoratorUtil() {
	}

	/**
	 * Converts the list of {@link Diagnostic}s (associated with a
	 * {@link PictogramElement}) to a list of {@link IDecorator}s to be rendered
	 * over the element.
	 * 
	 * @param diagnostics
	 * @return A list of IDecorators
	 */
	public static ArrayList<IDecorator> getMarkersFromDiagnostics(
			ArrayList<Diagnostic> diagnostics) {

		if (diagnostics == null)
			return new ArrayList<IDecorator>();

		// Classify each Diagnostic as Error, Warning or Info.
		HashMap<Integer, Set<String>> severityMessageMap = new HashMap<Integer, Set<String>>();
		for (Diagnostic diagnostic : diagnostics) {

			switch (diagnostic.getSeverity()) {
			case Diagnostic.ERROR:
				addMessage(severityMessageMap, Diagnostic.ERROR,
						diagnostic.getMessage());
				break;

			case Diagnostic.WARNING:
				addMessage(severityMessageMap, Diagnostic.WARNING,
						diagnostic.getMessage());
				break;

			case Diagnostic.INFO:
				addMessage(severityMessageMap, Diagnostic.INFO,
						diagnostic.getMessage());
				break;
			}
		}

		ArrayList<IDecorator> decorators = new ArrayList<IDecorator>();
		// Form a combined marker for all Errors
		if (severityMessageMap.containsKey(Diagnostic.ERROR)) {
			IDecorator decorator = new ImageDecorator(
					IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
			decorator.setMessage(convertSetToString(severityMessageMap
					.get(Diagnostic.ERROR)));
			decorators.add(decorator);
		}

		// Form a combined marker for all Warnings
		if (severityMessageMap.containsKey(Diagnostic.WARNING)) {
			IDecorator decorator = new ImageDecorator(
					IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
			decorator.setMessage(convertSetToString(severityMessageMap
					.get(Diagnostic.WARNING)));
			decorators.add(decorator);
		}

		// Form a combined marker for all Infos
		if (severityMessageMap.containsKey(Diagnostic.INFO)) {
			IDecorator decorator = new ImageDecorator(
					IPlatformImageConstants.IMG_ECLIPSE_INFORMATION_TSK);
			decorator.setMessage(convertSetToString(severityMessageMap
					.get(Diagnostic.INFO)));
			decorators.add(decorator);
		}

		return decorators;
	}

	/**
	 * Adds message to the set of messages associated with the given key in the
	 * map.
	 * 
	 * @param map
	 * @param key
	 * @param message
	 * 
	 * @author jayant
	 */
	private static void addMessage(HashMap<Integer, Set<String>> map, int key,
			String message) {
		if (!map.containsKey(key)) {
			map.put(key, new HashSet<String>());
		}
		map.get(key).add(message);
	}

	/**
	 * Form a single message for all messages of the set.
	 * 
	 * @param stringSet
	 * @return a single combined message string for all the messages in the set
	 * 
	 * @author jayant
	 */
	private static String convertSetToString(Set<String> stringSet) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : stringSet) {
			stringBuilder.append("- ").append(string).append("\n");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		if (stringSet.size() == 1)
			return stringBuilder.substring(2);
		else
			return stringBuilder.toString();
	}
}