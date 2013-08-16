/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.quickfix;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This class is intended to be sub-classed and the derived class should define
 * methods that match the signature assumed by {@link #getFixMethodPredicate(String)} and that
 * are annotated with {@link Fix}.
 * 
 * @author Henrik Rentz-Reichert
 * 
 * (copied from Xtext and modified for our purposes)
 *
 */
public abstract class AbstractQuickfixProvider {

	protected Predicate<Method> getFixMethodPredicate(final String issueCode) {
		return new Predicate<Method>() {
			public boolean apply(Method input) {
				Fix annotation = input.getAnnotation(Fix.class);
				boolean result = annotation != null && issueCode.equals(annotation.value())
						&& input.getParameterTypes().length == 2 && Void.TYPE == input.getReturnType()
						&& input.getParameterTypes()[0].isAssignableFrom(Issue.class)
						&& input.getParameterTypes()[1].isAssignableFrom(IssueResolutionAcceptor.class);
				return result;
			}
		};
	}

	protected List<IssueResolution> getResolutions(Issue issue, List<Method> fixMethods) {
		IssueResolutionAcceptor issueResolutionAcceptor = new IssueResolutionAcceptor();
		for (Method fixMethod : fixMethods) {
			try {
				fixMethod.setAccessible(true);
				fixMethod.invoke(this, issue, issueResolutionAcceptor);
			} catch (Exception e) {
			}
		}
		return issueResolutionAcceptor.getIssueResolutions();
	}

	protected Iterable<Method> collectMethods(Class<? extends AbstractQuickfixProvider> clazz, String issueCode) {
		List<Method> methods = Lists.newArrayList(clazz.getMethods());
		return Iterables.filter(methods, getFixMethodPredicate(issueCode));
	}

	protected List<Method> getFixMethods(final Issue issue) {
		return Lists.newArrayList(collectMethods(getClass(), issue.getCode()));
	}

	public boolean hasResolutionFor(final String issueCode) {
		if (issueCode == null)
			return false;
		Iterable<Method> methods = collectMethods(getClass(), issueCode);
		return methods.iterator().hasNext();
	}

	public List<IssueResolution> getResolutions(final Issue issue) {
		List<Method> fixMethods = getFixMethods(issue);
		return getResolutions(issue, fixMethods);
	}

}
