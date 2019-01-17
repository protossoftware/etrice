/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.util.RoomCrossReferencer;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.FSMDetailCodeTranslator;

/**
 * This class parses detail code in a pretty naive and heuristic way to recognize
 * and replace
 * <ul>
 *   <li>attributes</li>
 *   <li>operations</li>
 *   <li>port.message</li>
 *   <li>tags of the form <code><|tag|></code></li>
 * </ul>
 * 
 * <p>
 * The recognized constructs are passed to the configured {@link ITranslationProvider}
 * which returns a text that replaces the original one.
 * </p>
 * 
 * <p>
 * This way target language independent access to attributes (getters and setters),
 * to sending messages via ports and to member operation calls can be achieved.
 * </p>
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DetailCodeTranslator extends FSMDetailCodeTranslator {

	private static final String ATTR_SET = ".set";
	
	private RoomHelpers roomHelpers = new RoomHelpers();
	private HashMap<String, Attribute> name2attr = new HashMap<String, Attribute>();
	private HashMap<String, Operation> name2op = new HashMap<String, Operation>();
	
	/**
	 * Constructor to be used with actor classes
	 * 
	 * @param ac an {@link ActorClass}
	 * @param provider a {@link ITranslationProvider}
	 */
	public DetailCodeTranslator(ActorClass ac, ITranslationProvider provider, boolean doTranslate) {
		this((EObject) ac, provider, doTranslate);
	}
	
	/**
	 * @param pc a {@link ProtocolClass}
	 * @param provider a {@link ITranslationProvider}
	 */
	public DetailCodeTranslator(ProtocolClass pc, ITranslationProvider provider, boolean doTranslate) {
		this((EObject) pc, provider, doTranslate);
	}
	
	/**
	 * @param pc a {@link PortClass}
	 * @param provider a {@link ITranslationProvider}
	 */
	public DetailCodeTranslator(PortClass pc, ITranslationProvider provider, boolean doTranslate) {
		this((EObject) pc, provider, doTranslate);
	}
	
	/**
	 * @param dc a {@link DataClass}
	 * @param provider a {@link ITranslationProvider}
	 */
	public DetailCodeTranslator(DataClass dc, ITranslationProvider provider, boolean doTranslate) {
		this((EObject) dc, provider, doTranslate);
	}
	
	protected DetailCodeTranslator(EObject container, ITranslationProvider provider, boolean doTranslate) {
		super(container, provider, doTranslate);
	}
	
	/**
	 * @param code a {@link DetailCode} to translate
	 * @return the translated code as string
	 */
	public String translateDetailCode(DetailCode code) {
		String result = super.translateDetailCode(code);
		
		if (doTranslate && provider instanceof ITranslationProvider && ((ITranslationProvider)provider).translateEnums())
			result = translateEnums(result);
		
		return result;
	}
	
	// translate token if possible
	protected String translateToken(String text, Position curr, int last, String token) {
		if (!(provider instanceof ITranslationProvider))
			return null;
		
		ITranslationProvider prov = (ITranslationProvider) provider;
		
		String translated = null;
		
		// first try attributes
		Attribute attribute = name2attr.get(token);
		if (attribute!=null) {
			int start = curr.pos;
			String index = getArrayIndex(text, curr);
			if (index==null)
				curr.pos = start;
			int endSet = curr.pos+ATTR_SET.length();
			if (text.length()>=endSet && text.substring(curr.pos, endSet).equals(ATTR_SET)) {
				curr.pos = endSet;
				ArrayList<String> args = getArgs(text, curr);
				if (args!=null && args.size()==1) {
					String orig = text.substring(last, curr.pos);
					String transArg = translateText(args.get(0));
					translated = prov.getAttributeSetter(attribute, index, transArg, orig);
				}
			}
			else {
				String orig = text.substring(last, curr.pos);
				translated = prov.getAttributeGetter(attribute, index, orig);
			}
		}
		
		if (translated==null) {
			// if not successful try operations
			
			Operation operation = name2op.get(token);
			if (operation!=null && (operation.eContainer() instanceof ActorClass || operation.eContainer() instanceof DataClass)) {
				ArrayList<String> args = getArgs(text, curr);
				boolean isVarargs = operation.getArguments().stream().anyMatch(arg -> arg.isVarargs());
				if (args!=null && (operation.getArguments().size()==args.size() || isVarargs)) {
					// recursively apply this algorithm to each argument
					for (int i=0; i<args.size(); ++i) {
						String transArg = translateText(args.remove(i));
						args.add(i, transArg);
					}
					String orig = text.substring(last, curr.pos);
					translated = prov.getOperationText(operation, args, orig);
				}
			}
		}
		
		if (translated==null) {
			// if still not successful call super
			translated = super.translateToken(text, curr, last, token);
		}
		
		return translated;
	}
	
	protected String translateInterfaceItemToken(AbstractInterfaceItem item, String text, Position curr, int last, String token) {
		if (!(provider instanceof ITranslationProvider))
			return null;
		
		ITranslationProvider prov = (ITranslationProvider) provider;
		String translated = null;
		
		// try message value (for data driven port)
		int start = curr.pos;
		EObject msg = getMessage(text, curr, item, false);
		if (msg!=null) {
			if (curr.pos>=text.length() || text.charAt(curr.pos)!='(') {
				String orig = text.substring(last, curr.pos);
				translated = prov.getInterfaceItemMessageValue((InterfaceItem)item, (Message)msg, orig);
			}
		}
		
		if (translated==null) {
			// try port operation
			
			curr.pos = start;
			if (item instanceof InterfaceItem) {
				PortOperation operation = getPortOperation((InterfaceItem)item, text, curr);
				if (operation!=null) {
					ArrayList<String> args = getArgs(text, curr);
					if (argsMatching(operation, args)) {
						// recursively apply this algorithm to each argument
						for (int i=0; i<args.size(); ++i) {
							String transArg = translateText(args.remove(i));
							args.add(i, transArg);
						}
						String orig = text.substring(last, curr.pos);
						translated = prov.getInterfaceItemOperationText(item, operation, args, orig);
					}
				}
			}
		}
		
		return translated;
	}

	/**
	 * @param item
	 * @param text
	 * @param curr
	 * @return
	 */
	private PortOperation getPortOperation(InterfaceItem item, String text, Position curr) {
		PortClass portClass = roomHelpers.getPortClass(item);
		
		PortOperation operation = null;
		if (portClass!=null) {
			proceedToToken(text, curr);
			
			if (curr.pos>=text.length() || text.charAt(curr.pos)!='.')
				return null;
			++curr.pos;
			
			proceedToToken(text, curr);
			
			String token = getToken(text, curr);
			for (PortOperation op : portClass.getOperations()) {
				if (op.getName().equals(token)) {
					operation = op;
					break;
				}
			}
		}
		
		return operation;
	}
	
	protected String translateEnums(String text) {
		if (!(provider instanceof ITranslationProvider))
			return text;
		
		ITranslationProvider prov = (ITranslationProvider) provider;
		
		if (prov.translateEnums()) {
			
			RoomCrossReferencer crossReferencer = new RoomCrossReferencer();
			
			Set<EnumerationType> enumClasses = null;
			if (container instanceof ActorClass) {
				enumClasses = crossReferencer.getReferencedEnumClasses((ActorClass)container);
			} else if (container instanceof DataClass)
				enumClasses = crossReferencer.getReferencedEnumClasses((DataClass)container);
			else if (container instanceof PortClass)
				enumClasses = crossReferencer.getReferencedEnumClasses((PortClass)container);
			else if (container instanceof ProtocolClass)
				enumClasses = crossReferencer.getReferencedEnumClasses((ProtocolClass)container);
			
			if (enumClasses!=null) {
				for (EnumerationType et : enumClasses) {
					for (EnumLiteral lit : et.getLiterals()) {
						String pattern = et.getName()+"."+lit.getName();
						if (text.contains(pattern)) {
							String replacement = prov.getEnumText(lit);
							text = text.replace(pattern, replacement);
						}
					}
				}
			}
			return text;
		}
		else
			return text;
	}

	@Override
	protected boolean argsMatching(EObject amsg, ArrayList<String> args) {
		if (!(amsg instanceof Message))
			return super.argsMatching(amsg, args);
		
		Message msg = (Message) amsg;
		if (msg.getData()==null && args.isEmpty())
			return true;
		if (msg.getData()!=null && args.size()==1)
			return true;
		
		return false;
	}
	
	protected boolean argsMatching(PortOperation op, ArrayList<String> args) {
		if (op.getArguments()==null && args.isEmpty())
			return true;
		if (op.getArguments().size()==args.size())
			return true;
		
		return false;
	}
	
	@Override
	protected void prepare() {
		super.prepare();

		List<Attribute> attributes = null;
		if (container instanceof ActorClass)
			attributes = roomHelpers.getAllAttributes((ActorClass) container);
		else if (container instanceof DataClass)
			attributes = roomHelpers.getAllAttributes((DataClass) container);
		else if (container instanceof PortClass)
			attributes = ((PortClass) container).getAttributes();
		if (attributes!=null)
			for (Attribute attribute : attributes) {
				name2attr.put(attribute.getName(), attribute);
			}
		
		List<? extends Operation> operations = null;
		if (container instanceof ActorClass)
			operations = roomHelpers.getAllOperations((ActorClass) container);
		else if (container instanceof DataClass)
			operations = roomHelpers.getAllOperations((DataClass) container);
		else if (container instanceof PortClass)
			operations = ((PortClass) container).getOperations();
		if (operations!=null)
			for (Operation operation : operations) {
				name2op.put(operation.getName(), operation);
			}
	}
}
