/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.contractmonitor.gen

class DetailCodeGen {
	
	// TODO proper mechanism for generator options
	var String language
	
	def void setTargetLanguage(String language) {
		this.language = language.toLowerCase
	}
	
	def String mscComment(String comment, boolean addLocation) {
		switch language.toLowerCase {
			case "c": mscCommentC(comment, addLocation)
			case "java": mscCommentJava(comment, addLocation)
			default: throw new IllegalArgumentException('Unsupported target language: ' + language)
		}
	}
	
	protected def String mscCommentJava(String comment, boolean addLocation) {
		val getLocationCode = {
			if (addLocation) 
				'''" location: " + this.getInstancePath() + " : " + ifitem.toString()''' 
			else ''
		}
		'''
			DebuggingService.getInstance().addVisibleComment("«comment»" + «getLocationCode»);
		'''
	}
	
	protected def String mscCommentC(String comment, boolean addLocation) '''
		ET_MSC_LOGGER_VISIBLE_COMMENT("«comment»");
	'''
}