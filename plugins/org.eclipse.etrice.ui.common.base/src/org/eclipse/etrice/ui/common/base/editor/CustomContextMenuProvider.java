/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.editor;

import java.util.Set;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.graphiti.ui.editor.DiagramEditorContextMenuProvider;
import org.eclipse.graphiti.ui.platform.IConfigurationProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;

import com.google.common.collect.Sets;

public class CustomContextMenuProvider extends DiagramEditorContextMenuProvider {

	protected Set<IContributionItem> graphitiItems = Sets.newHashSet();
	
	public CustomContextMenuProvider(EditPartViewer viewer, ActionRegistry registry,
			IConfigurationProvider configurationProvider) {
		super(viewer, registry, configurationProvider);
	}
	
	@Override
	public void buildContextMenu(IMenuManager manager) {
		super.buildContextMenu(manager);
		
		// remember built items
		graphitiItems = Sets.newHashSet(getItems());
	}
	
	@Override
	protected void update(boolean force, boolean recursive) {	
		
		// remove external items
		for(IContributionItem item : getItems().clone()){
			if(graphitiItems.contains(item))
				continue;
			if(item.getId() != null){
				if(item.getId().startsWith("de.cau.cs.kieler"))
					continue;
				
			}
				
			remove(item);
		}
		
		super.update(force, recursive);
	}
	
	@Override
	protected boolean allowItem(IContributionItem itemToAdd) {
		// filtering items here does not work, Bug 93279 
		return super.allowItem(itemToAdd);
	}

	@Override
	protected void addDefaultMenuGroupEdit(IMenuManager manager) {
	}

	@Override
	protected void addDefaultMenuGroupPrint(IMenuManager manager) {
	}
}
