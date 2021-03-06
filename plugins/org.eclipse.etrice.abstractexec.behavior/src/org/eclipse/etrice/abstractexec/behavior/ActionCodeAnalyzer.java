/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.generator.fsm.base.DefaultFSMTranslationProvider;
import org.eclipse.etrice.generator.fsm.base.FSMDetailCodeTranslator;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ActionCodeAnalyzer {

	private class Collector extends DefaultFSMTranslationProvider {
		
		private ArrayList<HandledMessage> mifs = new ArrayList<HandledMessage>();
		
		public List<HandledMessage> getMifs() {
			return mifs;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.etrice.generator.base.DefaultTranslationProvider#getInterfaceItemMessageText(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.util.List, java.lang.String, java.lang.String)
		 */
		@Override
		public String getInterfaceItemMessageText(AbstractInterfaceItem item,
				EObject msg, List<String> args, String index, String orig) {
			
			HandledMessage sm = new HandledMessage(item, msg, origin);
			mifs.add(sm);
			
			return orig;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.etrice.generator.base.DefaultTranslationProvider#translateMembers()
		 */
		@Override
		public boolean translateMembers() {
			return true;
		}

		// create a new list and leave previous unchanged
		public void begin() {
			mifs = new ArrayList<HandledMessage>();
		}
	}
	
	private Collector collector;
	private FSMDetailCodeTranslator translator;
	private DetailCode origin;

	public ActionCodeAnalyzer(ModelComponent mc) {
		collector = new Collector();
		translator = new FSMDetailCodeTranslator(mc, collector, true);
	}
	
	public List<HandledMessage> analyze(DetailCode dc) {
		origin = dc;
		collector.begin();
		translator.translateDetailCode(dc);
		return collector.getMifs();
	}
}
