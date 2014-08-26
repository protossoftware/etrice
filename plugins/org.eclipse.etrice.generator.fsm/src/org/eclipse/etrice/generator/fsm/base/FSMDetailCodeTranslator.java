/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMDetailCodeTranslator {
	
	public static class Position {
		public int pos = 0;
	}

	protected IFSMTranslationProvider provider;
	protected EObject container;
	protected boolean doTranslate;
	private boolean isPrepared = false;
	private FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	protected HashMap<String, AbstractInterfaceItem> name2item = new HashMap<String, AbstractInterfaceItem>();
	
	public FSMDetailCodeTranslator(ModelComponent container, IFSMTranslationProvider provider, boolean doTranslate) {
		this((EObject)container, provider, doTranslate);
	}
	
	protected FSMDetailCodeTranslator(EObject container, IFSMTranslationProvider provider, boolean doTranslate) {
		this.provider = provider;
		this.container = container;
		this.doTranslate = doTranslate;
	}

	protected void prepare() {
		provider.setContainerClass(container);

		if (container instanceof ModelComponent) {
			ModelComponent mc = (ModelComponent) container;

			List<AbstractInterfaceItem> items = mc.getAllAbstractInterfaceItems();
			for (AbstractInterfaceItem item : items) {
				name2item.put(item.getName(), item);
			}
		}
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
		
		return result;
	}
	
	public String translateText(String text) {
		if (!isPrepared) {
			isPrepared = true;
			prepare();
		}
		
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
				String translated = translateToken(text, curr, last, token);
				if (translated!=null) {
					last = curr.pos;
					result.append(translated);
				}
				else
					last = appendParsed(text, curr, last, result);
			}
		}
		return result.toString();
	}

	protected String translateTags(String text, DetailCode code) {
		StringBuilder result = new StringBuilder();
		
		int last = 0;
		int next = text.indexOf(IFSMTranslationProvider.TAG_START, last);
		while (next>=0) {
			result.append(text.substring(last, next));
			last = next+IFSMTranslationProvider.TAG_START.length();
			next = text.indexOf(IFSMTranslationProvider.TAG_END, last);
			if (next<0)
				break;
			
			String tag = text.substring(last, next);
			result.append(provider.translateTag(tag, code));
			last = next+IFSMTranslationProvider.TAG_END.length();
			
			next = text.indexOf(IFSMTranslationProvider.TAG_START, last);
		}
		result.append(text.substring(last));
		return result.toString();
	}
	
	protected String translateToken(String text, Position curr, int last, String token) {
		String translated = null;
		
		AbstractInterfaceItem item = name2item.get(token);
		if (item!=null) {
			int start = curr.pos;
			String index = getArrayIndex(text, curr);
			if (index==null)
				curr.pos = start;
			EObject msg = getMessage(text, curr, item, true);
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
				
				translated = translateInterfaceItemToken(item, text, curr, last, token);
			}
		}
		
		return translated;
	}
	
	protected String translateInterfaceItemToken(AbstractInterfaceItem item, String text, Position curr, int last, String token) {
		return null;
	}

	protected EObject getMessage(String text, Position curr, AbstractInterfaceItem item, boolean outgoing) {
		proceedToToken(text, curr);

		if (curr.pos>=text.length() || text.charAt(curr.pos)!='.')
			return null;
		++curr.pos;
		
		proceedToToken(text, curr);
		
		String token = getToken(text, curr);
		
		List<EObject> messages = outgoing? item.getAllOutgoingAbstractMessages() : item.getAllIncomingAbstractMessages();
		for (EObject message : messages) {
			if (fsmNameProvider.getMessageName(message).equals(token))
				return message;
		}
		
		return null;
	}

	protected String getArrayIndex(String text, Position curr) {
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
	protected int appendParsed(String text, Position curr, int last,
			StringBuilder result) {
				String str = text.substring(last, curr.pos);
				result.append(str);
				return curr.pos;
			}

	protected void proceedToToken(String text, Position curr) {
		proceedToToken(text, curr, true);
	}

	protected void proceedToToken(String text, Position curr, boolean skipString) {
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

	protected ArrayList<String> getArgs(String text, Position curr) {
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

	protected String getToken(String text, Position curr) {
		int begin = curr.pos;
		while (curr.pos<text.length() && isTokenChar(text.charAt(curr.pos)))
			++curr.pos;
		String token = text.substring(begin, curr.pos);
		return token;
	}

	protected String getParam(String text, Position curr) {
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

	protected String getIndex(String text, Position curr) {
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

	protected void skipWhiteSpace(String text, Position curr) {
		while (curr.pos<text.length() && Character.isWhitespace(text.charAt(curr.pos)))
			++curr.pos;
	}

	protected void skipMultiComment(String text, Position curr) {
		curr.pos += 2;
		while (curr.pos<text.length()-1 && text.charAt(curr.pos++)!='*')
			if (text.charAt(curr.pos)=='/')
				break;
		if (curr.pos<text.length())
			++curr.pos;
	}

	protected void skipSingleComment(String text, Position curr) {
		while (curr.pos<text.length() && text.charAt(curr.pos)!='\n')
			++curr.pos;
		if (curr.pos<text.length())
			++curr.pos;
	}

	protected void skipString(String text, Position curr) {
		while (++curr.pos<text.length() && text.charAt(curr.pos)!='"')
			if (text.charAt(curr.pos)=='\\')
				++curr.pos;
		if (curr.pos<text.length())
			++curr.pos;
	}
	
	protected boolean argsMatching(EObject msg, ArrayList<String> args) {
		return true;
	}

	protected boolean isTokenChar(char c) {
		return Character.isDigit(c) || Character.isLetter(c) || c=='_';
	}
}
