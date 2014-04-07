/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.etrice.core.genmodel.util.RoomCrossReferencer;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;

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
public class DetailCodeTranslator {

	private static final String ATTR_SET = ".set";
	
	private static class Position {
		int pos = 0;
	}
	
	private ITranslationProvider provider;
	private HashMap<String, InterfaceItem> name2item = new HashMap<String, InterfaceItem>();
	private HashMap<String, Attribute> name2attr = new HashMap<String, Attribute>();
	private HashMap<String, Operation> name2op = new HashMap<String, Operation>();
	private EObject container;
	private boolean doTranslate;
	
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
	
	private DetailCodeTranslator(EObject container, ITranslationProvider provider, boolean doTranslate) {
		this.provider = provider;
		this.container = container;
		this.doTranslate = doTranslate;
		prepare(container);
	}
	
	/**
	 * @param code a {@link DetailCode} to translate
	 * @return the translated code as string
	 */
	public String translateDetailCode(DetailCode code) {
		if (code==null)
			return "";
		
		// concatenate lines
		StringBuilder text = new StringBuilder();
		for (String line : code.getLines()) {
			text.append(line+"\n");
		}

		String result = text.substring(0, Math.max(0, text.length()-1));
		
		if (!doTranslate)
			return result;
		
		if (provider.translateMembers())
			result = translateText(result);
		
		if (provider.translateTags())
			result = translateTags(result, code);
		
		if (provider.translateEnums())
			result = translateEnums(result);
		
		return result;
	}
	
	private String translateText(String text) {
		StringBuilder result = new StringBuilder();
		Position curr = new Position();
		int last = 0;
		
		while (curr.pos<text.length()) {
			proceedToToken(text, curr);
			
			last = appendParsed(text, curr, last, result);
			
			String token = getToken(text, curr);
			if (token.isEmpty()) {
				if (curr.pos<text.length() && !isTokenChar(text.charAt(curr.pos)))
					++curr.pos;
				last = appendParsed(text, curr, last, result);
			}
			else {
				// translate token if possible
				String translated = null;
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
							translated = provider.getAttributeSetter(attribute, index, transArg, orig);
						}
					}
					else {
						String orig = text.substring(last, curr.pos);
						translated = provider.getAttributeGetter(attribute, index, orig);
					}
				}
				else {
					Operation operation = name2op.get(token);
					if (operation!=null && (operation.eContainer() instanceof ActorClass || operation.eContainer() instanceof DataClass)) {
						ArrayList<String> args = getArgs(text, curr);
						if (args!=null && operation.getArguments().size()==args.size()) {
							// recursively apply this algorithm to each argument
							for (int i=0; i<args.size(); ++i) {
								String transArg = translateText(args.remove(i));
								args.add(i, transArg);
							}
							String orig = text.substring(last, curr.pos);
							translated = provider.getOperationText(operation, args, orig);
						}
					}
					else {
						InterfaceItem item = name2item.get(token);
						if (item!=null) {
							int start = curr.pos;
							String index = getArrayIndex(text, curr);
							if (index==null)
								curr.pos = start;
							Message msg = getMessage(text, curr, item, true);
							if (msg!=null) {
								ArrayList<String> args = getArgs(text, curr);
								if (args!=null) {
									if (argsMatching(msg, args)) {
										// recursively apply this algorithm to each argument
										for (int i=0; i<args.size(); ++i) {
											String transArg = translateText(args.remove(i));
											args.add(i, transArg);
										}
										String orig = text.substring(last, curr.pos);
										translated = provider.getInterfaceItemMessageText(item, msg, args, index, orig);
									}
								}
							}
							else {
								curr.pos = start;
								msg = getMessage(text, curr, item, false);
								if (msg!=null) {
									if (curr.pos>=text.length() || text.charAt(curr.pos)!='(') {
										String orig = text.substring(last, curr.pos);
										translated = provider.getInterfaceItemMessageValue(item, msg, orig);
									}
								}
							}
						}
					}
				}
				if (translated!=null) {
					last = curr.pos;
					result.append(translated);
				}
				else
					last = appendParsed(text, curr, last, result);
			}
		}
		
		return translateEnums(result.toString());
	}
	
	private String translateEnums(String text) {
		if (provider.translateEnums()) {
			
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
							String replacement = provider.getEnumText(lit);
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

	private String getArrayIndex(String text, Position curr) {
		proceedToToken(text, curr);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!='[')
			return null;
		++curr.pos;
		
		String token = getIndex(text, curr);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!=']')
			return null;
		++curr.pos;
		
		return translateText(token);
	}

	/**
	 * @param text
	 * @param result
	 * @return 
	 */
	private int appendParsed(String text, Position curr, int last, StringBuilder result) {
		String str = text.substring(last, curr.pos);
		result.append(str);
		return curr.pos;
	}

	private boolean argsMatching(Message msg, ArrayList<String> args) {
		if (msg.getData()==null && args.isEmpty())
			return true;
		if (msg.getData()!=null && args.size()==1)
			return true;
		
		return false;
	}

	private void proceedToToken(String text, Position curr) {
		proceedToToken(text, curr, true);
	}
	
	private void proceedToToken(String text, Position curr, boolean skipString) {
		boolean stop = false;
		while (curr.pos<text.length() && !stop) {
			if (text.charAt(curr.pos)=='"') {
				if (skipString)
					skipString(text, curr);
				else
					stop = true;
			}
			else if (text.charAt(curr.pos)=='/') {
				if (curr.pos+1<text.length()) {
					if (text.charAt(curr.pos+1)=='/') {
						skipSingleComment(text, curr);
					}
					else if (text.charAt(curr.pos+1)=='*') {
						skipMultiComment(text, curr);
					}
					else
						stop = true;
				}
				else
					stop = true;
			}
			else if (Character.isWhitespace(text.charAt(curr.pos))) {
				skipWhiteSpace(text, curr);
			}
			else
				stop = true;
		}
	}
	
	private Message getMessage(String text, Position curr, InterfaceItem item, boolean outgoing) {
		proceedToToken(text, curr);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!='.')
			return null;
		++curr.pos;
		
		proceedToToken(text, curr);
		
		String token = getToken(text, curr);
		
		List<Message> messages = RoomHelpers.getMessageListDeep(item, outgoing);
		for (Message message : messages) {
			if (message.getName().equals(token))
				return message;
		}
		
		return null;
	}
	
	private ArrayList<String> getArgs(String text, Position curr) {
		proceedToToken(text, curr);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!='(')
			return null;
		++curr.pos;
		
		ArrayList<String> result = new ArrayList<String>();
		
		boolean stop = false;
		do {
			proceedToToken(text, curr, false);
			if (curr.pos<text.length() && text.charAt(curr.pos)!=')') {
				String arg = getParam(text, curr);
				result.add(arg);
				proceedToToken(text, curr);
			}
			if (curr.pos<text.length() && text.charAt(curr.pos)==',')
				++curr.pos;
			else
				stop = true;
		}
		while (!stop);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!=')')
			return null;
		
		++curr.pos;
		
		return result;
	}

	private String getToken(String text, Position curr) {
		int begin = curr.pos;
		while (curr.pos<text.length() && isTokenChar(text.charAt(curr.pos)))
			++curr.pos;
		String token = text.substring(begin, curr.pos);
		return token;
	}

	private String getParam(String text, Position curr) {
		int begin = curr.pos;
		int parenthesisLevel = 0;
		while (curr.pos<text.length()) {
			if (text.charAt(curr.pos)=='(')
				++parenthesisLevel;
			else if (text.charAt(curr.pos)==')') {
				if (parenthesisLevel==0)
					break;
				else
					--parenthesisLevel;
			}
			else if (parenthesisLevel==0) {
				if (text.charAt(curr.pos)==',')
					break;
			}
			++curr.pos;
		}
		String token = text.substring(begin, curr.pos).trim();
		return token;
	}

	private String getIndex(String text, Position curr) {
		int begin = curr.pos;
		int parenthesisLevel = 0;
		while (curr.pos<text.length()) {
			if (text.charAt(curr.pos)=='[')
				++parenthesisLevel;
			else if (text.charAt(curr.pos)==']') {
				if (parenthesisLevel==0)
					break;
				else
					--parenthesisLevel;
			}
			++curr.pos;
		}
		String token = text.substring(begin, curr.pos).trim();
		return token;
	}

	private void skipWhiteSpace(String text, Position curr) {
		while (curr.pos<text.length() && Character.isWhitespace(text.charAt(curr.pos)))
			++curr.pos;
	}

	private void skipMultiComment(String text, Position curr) {
		curr.pos += 2;
		while (curr.pos<text.length()-1 && text.charAt(curr.pos++)!='*')
			if (text.charAt(curr.pos)=='/')
				break;
		if (curr.pos<text.length())
			++curr.pos;
	}

	private void skipSingleComment(String text, Position curr) {
		while (curr.pos<text.length() && text.charAt(curr.pos)!='\n')
			++curr.pos;
		if (curr.pos<text.length())
			++curr.pos;
	}

	private void skipString(String text, Position curr) {
		while (++curr.pos<text.length() && text.charAt(curr.pos)!='"')
			if (text.charAt(curr.pos)=='\\')
				++curr.pos;
		if (curr.pos<text.length())
			++curr.pos;
	}

	private boolean isTokenChar(char c) {
		return Character.isDigit(c) || Character.isLetter(c) || c=='_';
	}

	private void prepare(EObject container) {
		provider.setContainerClass(container);

		if (container instanceof ActorClass) {
			ActorClass ac = (ActorClass) container;

			List<InterfaceItem> items = RoomHelpers.getAllInterfaceItems(ac);
			for (InterfaceItem item : items) {
				name2item.put(item.getName(), item);
			}
		}

		List<Attribute> attributes = null;
		if (container instanceof ActorClass)
			attributes = RoomHelpers.getAllAttributes((ActorClass) container);
		else if (container instanceof DataClass)
			attributes = RoomHelpers.getAllAttributes((DataClass) container);
		else if (container instanceof PortClass)
			attributes = ((PortClass) container).getAttributes();
		if (attributes!=null)
			for (Attribute attribute : attributes) {
				name2attr.put(attribute.getName(), attribute);
			}
		
		List<? extends Operation> operations = null;
		if (container instanceof ActorClass)
			operations = RoomHelpers.getAllOperations((ActorClass) container);
		else if (container instanceof DataClass)
			operations = RoomHelpers.getAllOperations((DataClass) container);
		else if (container instanceof PortClass)
			operations = ((PortClass) container).getOperations();
		if (operations!=null)
			for (Operation operation : operations) {
				name2op.put(operation.getName(), operation);
			}
	}

	private String translateTags(String text, DetailCode code) {
		StringBuilder result = new StringBuilder();
		
		int last = 0;
		int next = text.indexOf(ITranslationProvider.TAG_START, last);
		while (next>=0) {
			result.append(text.substring(last, next));
			last = next+ITranslationProvider.TAG_START.length();
			next = text.indexOf(ITranslationProvider.TAG_END, last);
			if (next<0)
				break;
			
			String tag = text.substring(last, next);
			result.append(provider.translateTag(tag, code));
			last = next+ITranslationProvider.TAG_END.length();
			
			next = text.indexOf(ITranslationProvider.TAG_START, last);
		}
		result.append(text.substring(last));
		return result.toString();
	}
}
