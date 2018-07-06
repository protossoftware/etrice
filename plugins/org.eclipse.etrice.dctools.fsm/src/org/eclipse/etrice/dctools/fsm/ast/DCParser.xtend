/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast

import java.util.ArrayList
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstArrayAccessNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode.BracketType
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstFeatureCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierBracketNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstMatchNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOperationCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstPeriodNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstWhitespaceNode
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken.BracketKind
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCTextToken
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken.Kind

/**
 * 
 * Grammar:
 * 
 * PartialMatch: BracketExpression | FeatureCall
 * 
 * BracketExpression: RoundBracketExpression | CurlyBracketExpression | SquareBracketExpression
 * RoundBracketExpression: LEFT_ROUNDBRACKET Match RIGHT_ROUNDBRACKET
 * CurlyBracketExpression: LEFT_CURLYBRACKET Match RIGHT_CORLYBRACKET
 * SquareBracketExpression: LEFT_SQUAREBRACKET Match RIGHT_SQUAREBRACKET
 * 
 * FeatureCall: Call Whitespace (PERIOD Whitespace Call Whitespace)*
 * Call: ArrayAccess | OperationCall | IDENTIFIER
 * ArrayAccess: IDENTIFIER Whitespace SquareBracketExpression
 * OperationCall: IDENTIFIER Whitespace RoundBracketExpression
 * 
 * Whitespace: WHITESPACE*
 * 
 * Match: (PartialMatch* Other)*
 * 
 * Other: *
 */
class DCParser {
	
	val DCScanner scanner
	String text
	ArrayList<DCTextToken> tokens
	int currentPosition = 0
	
	new(DCLanguage language) {
		scanner = new DCScanner(language)
	}
	
	def parse(String text) {
		this.text = text
		this.tokens = scanner.scan(text)
		
		Match(null)
	}
	
	/*
	 * rules
	 */
	private def DCAstMatchNode Match(DCAstNode parent) {
		val mNode = new DCAstMatchNode(parent)
		
		var continue = true
		while (continue) {
			while (PartialMatch(mNode)!==null) {}
			if (Other(mNode)===null) {
				continue = false
			}
		}
		
		return mNode
	}
	
	private def DCAstOtherNode Other(DCAstNode parent) {
		var DCAstOtherNode lastNode = null
		var token = read
		
		if (token!==null) {
			while (token!==null) {
				if (stopOther(token)) {
					unread
					token = null
				}
				else {
					// we consumed a token
					lastNode = new DCAstOtherNode(parent, text.substring(token.begin, token.begin + token.length), token)
					
					// do we have a partial match after that token?
					val pNode = PartialMatch(null)
					if (pNode!==null) {
						unread(pNode)
						token = null
					}
					else {
						token = read
					}
				}
			}
		}
		
		return lastNode
	}
	
	private def boolean stopOther(DCTextToken token) {
		if (token.token instanceof DCBracketToken) {
			return true
		}
		if (token.token.kind==Kind.IDENTIFIER) {
			return true
		}
		return false
	}
	
	private def DCAstNode PartialMatch(DCAstNode parent) {
		var node = ConcreteBracketExpression(parent) as DCAstNode
		if (node===null) {
			node = FeatureCall(parent)
		}
		return node
	}
	
	private def DCAstBracketNode ConcreteBracketExpression(DCAstNode parent) {
		var node = RoundBracketExpression(parent)
		if (node===null) {
			node = CurlyBracketExpression(parent)
		}
		if (node===null) {
			node = SquareBracketExpression(parent)
		}
		return node
	}
	
	private def DCAstBracketNode RoundBracketExpression(DCAstNode parent) {
		return ConcreteBracketExpression(parent, BracketKind.LEFT_ROUND, BracketKind.RIGHT_ROUND, BracketType.ROUND)
	}
	
	private def DCAstBracketNode CurlyBracketExpression(DCAstNode parent) {
		return ConcreteBracketExpression(parent, BracketKind.LEFT_CURLY, BracketKind.RIGHT_CURLY, BracketType.CURLY)
	}
	
	private def DCAstBracketNode SquareBracketExpression(DCAstNode parent) {
		return ConcreteBracketExpression(parent, BracketKind.LEFT_SQUARE, BracketKind.RIGHT_SQUARE, BracketType.SQUARE)
	}
	
	private def DCAstBracketNode ConcreteBracketExpression(DCAstNode parent, BracketKind left, BracketKind right, BracketType type) {
		var token = read
		
		if (token!==null) {
			if (token.token instanceof DCBracketToken) {
				var b = token.token as DCBracketToken
				if (b.bracketKind==left) {
					val contents = Match(parent)
					val leftPos = token.begin
					token = read
					if (token!==null) {
						if (token.token instanceof DCBracketToken) {
							val rightPos = token.begin
							b = token.token as DCBracketToken
							if (b.bracketKind==right) {
								return new DCAstBracketNode(parent, type, contents, leftPos, rightPos)
							}
						}
						unread // second token
					}
					else {
						// we reached the end without a matching right bracket
						return new DCAstBracketNode(parent, type, contents, leftPos)
					}
					unread(contents)
				}
			}
			unread // first token
		}
		
		return null
	}
	
	private def DCAstFeatureCallNode FeatureCall(DCAstNode parent) {
		val callNode = Call(parent)
		
		if (callNode!==null) {
			val fcNode = new DCAstFeatureCallNode(parent)
			callNode.parent = fcNode
			
			// optional whitespace
			Whitespace(fcNode)
			
			// (PERIOD Whitespace Call)*
			var token = read
			while (token!==null) {
				if (token.token.kind==Kind.PERIOD) {
					val pNode = new DCAstPeriodNode(null, token.begin)
					val wsNode = Whitespace(null)
					val cNode = Call(null)
					val wsNode2 = Whitespace(null)
					if (pNode!==null) {
						pNode.parent = fcNode
						if (wsNode!==null) {
							wsNode.parent = fcNode
						}
						if (cNode!==null) {
							cNode.parent = fcNode
						} 
						if (wsNode2!==null) {
							wsNode2.parent = fcNode
						}
						
						if (cNode!==null) {
							// next token
							token = read
						}
						else {
							token = null
						}
					}
					else {
						unread(pNode)
						unread(wsNode)
						unread(pNode)
						unread(wsNode2)
						unread // the token itself
						token = null
					}
				}
				else {
					unread // the token itself
					token = null
				}
			}
			
			return fcNode
		}
		
		unread(callNode)
		
		return null
	}
	
	private def DCAstNode Call(DCAstNode parent) {
		// try ArrayAccess
		var node = BracketExpressionCall(parent, [SquareBracketExpression], [p, i, w, b| new DCAstArrayAccessNode(p, i, w, b)])
		if (node===null) {
			// try OperationCall
			node = BracketExpressionCall(parent, [RoundBracketExpression], [p, i, w, b| new DCAstOperationCallNode(p, i, w, b)])
		}
		if (node!==null) {
			return node
		}
		else {
			// try IDENTIFIER
			val token = read
			if (token!==null) {
				if (token.token.kind==Kind.IDENTIFIER) {
					val id = text.substring(token.begin, token.begin + token.length)
					return new DCAstIdentifierNode(parent, id, token)
				}
				unread
			}
		}
		return null
	}
	
	private def DCAstIdentifierBracketNode BracketExpressionCall(
		DCAstNode parent,
		(DCAstNode)=>DCAstBracketNode bracketExpression,
		(DCAstNode, DCAstIdentifierNode, DCAstWhitespaceNode, DCAstBracketNode)=>DCAstIdentifierBracketNode factory
	) {
		val token = read
		if (token!==null) {
			if (token.token.kind==Kind.IDENTIFIER) {
				// first child is ID
				val id = text.substring(token.begin, token.begin + token.length)
				val idNode = new DCAstIdentifierNode(parent, id, token)
				
				// optional whitespace
				val wsNode = Whitespace(parent)
				
				// second child is BracketExpression
				val node = bracketExpression.apply(parent)
				if (node!==null) {
					// the node of the bracket expression call
					val callNode = factory.apply(parent, idNode, wsNode, node)
					return callNode
				}
				
				unread(idNode)
				unread(wsNode)
			}
			else {
				unread
			}
		}
		
		return null
	}
	
	private def DCAstWhitespaceNode Whitespace(DCAstNode parent) {
		var token = read
		val begin = if (token!==null) token.begin else 0
		var int end = 0
		var count = 0
		while (token!==null) {
			if (token.token.kind==Kind.WHITESPACE) {
				end = token.begin + token.length
				count++
				token = read
			}
			else {
				token = null
				unread
			}
		}
		
		if (count>0) {
			val ws = text.substring(begin, end)
			return new DCAstWhitespaceNode(parent, count, begin, ws)
		}
		
		return null
	}
	
	/*
	 * helpers
	 */
	private def DCTextToken read() {
		if (currentPosition<tokens.size) {
			tokens.get(currentPosition++)
		}
		else {
			null
		}
	}
	
	private def void unread() {
		unread(1)
	}
	
	private def void unread(int i) {
		currentPosition = currentPosition - i
		if (currentPosition<0) {
			println("oops")
		}
	}
	
	private def void unread(DCAstNode node) {
		if (node!==null) {
			node.parent = null
			unread(node.totallyReadTokens)
		}
	}
}