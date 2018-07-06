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

package org.eclipse.etrice.dctools.fsm.ast.nodes

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.etrice.dctools.fsm.ast.util.IDCAstNodeVisitor

@Accessors
abstract class DCAstNode {
	
	DCAstNode parent
	int readTokens
	List<DCAstNode> children = newArrayList
	EObject linkedObject
	Object linkedData
	
	new() {
		this(null, 0)
	}
	
	new(DCAstNode parent, int readTokens) {
		this.parent = parent
		this.readTokens = readTokens
		if (parent!==null) {
			parent.children.add(this)
		}
	}
	
	def DCAstNode c(int i) {
		children.get(i)
	}
	
	def void setParent(DCAstNode parent) {
		if (this.parent!==null) {
			this.parent.children.remove(this)
		}
		this.parent = parent
		if (parent!==null) {
			this.parent.children.add(this)
		}
	}
	
	def int totallyReadTokens() {
		var sum = readTokens
		for (child : children) {
			sum += child.totallyReadTokens
		}
		return sum
	}
	
	def void print() {
		printRecursive("")
	}
	
	def void visit(IDCAstNodeVisitor visitor) {
		val descend = visitor.visitBegin(this)
		
		if (descend) {
			for (child : children) {
				child.visit(visitor)
			}
		}
		
		visitor.visitEnd(this)
	}
	
	protected def void printRecursive(String indent) {
		doPrint(indent)
		for (child : children) {
			child.printRecursive(indent + "  ")
		}
	}
	
	protected def String getLinkedObjectText() {
		if (linkedObject!==null) {
			return " --> " + linkedObject.eClass.name
		}
		else {
			""
		}
	}
	
	protected abstract def void doPrint(String indent)
}