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
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.base.logging.ILogger

@Singleton
class DataClassGen {

	@Inject IGeneratorFileIO fileIO
	@Inject extension RoomHelpers
	@Inject extension CExtensions
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		root.dataClasses.filter[!isDeprecatedGeneration].forEach[dc |
			val path = dc.getPath
			var file = dc.getCHeaderFileName

			// header file
			fileIO.generateFile("generating DataClass header", path + file, root.generateHeaderFile(dc))
			
			// utils file
			file = dc.getCUtilsFileName
			fileIO.generateFile("generating ProtocolClass utils", path + file, root.generateUtilsFile(dc))
			
			// source file
			file = dc.getCSourceFileName
			fileIO.generateFile("generating DataClass source", path + file, root.generateSourceFile(dc))
		]
	}
	
	def generateHeaderFile(Root root, DataClass dc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of DataClass �dc.name�
		 * 
		 */

		�generateIncludeGuardBegin(dc)�
		
		#include "etDatatypes.h"

		/* include all referenced room classes */
���		TODO: includes only for used DataClasses, also for other models
		�FOR path : (root.getReferencedDataClasses(dc) + root.getReferencedEnumClasses(dc)).map[includePath].sort�
			#include �path�
		�ENDFOR�
		
		�dc.userCode(1)�
				
		typedef struct {
			�dc.allAttributes.attributes�
		} �dc.name�;
		
		�FOR a:dc.allAttributes�
			�IF a.defaultValueLiteral!==null�
				�logger.logInfo(dc.name+" "+a.name+": Attribute initialization not supported in C")�
			�ENDIF�
		�ENDFOR�
		
���		TODO: do we need setters and getters for C and C++ ?
		
		�dc.latestOperations.operationsDeclaration(dc.name)�
		
		/* deep copy */
		void �dc.name�_deepCopy(�dc.name�* source, �dc.name�* target);
		
		�dc.userCode(2)�
		
		�generateIncludeGuardEnd(dc)�
		
		'''
	}
	
	def private generateUtilsFile(Root root, DataClass dc) {
		val filename = (dc.eContainer as RoomModel).name.replaceAll("\\.","_")+"_"+dc.name+"_Utils"
	'''
		/**
		 * @author generated by eTrice
		 *
		 * Utils File of DataClass �dc.name�
		 * 
		 */
		
		�generateIncludeGuardBegin(filename)�
		
		#include �dc.includePath�
		
		/*
		 * access macros for operations and attributes
		*/
		
		/* operations */
		�FOR op : dc.allOperations�
			�val params = op.operationParams�
			�val args = op.operationArgs�
			#define �op.name�(�params�) �dc.name�_�op.name�(self�IF !op.arguments.empty�, �args��ENDIF�)
		�ENDFOR�
		
		/* attributes */
		�FOR a : dc.allAttributes�
			#define �a.name� (self->�a.name�)
		�ENDFOR�
		
		�generateIncludeGuardEnd(filename)�
		
	'''
	}
	
	private def operationParams(Operation op) {
		op.arguments.map[
			switch it {
				case isVarargs: '...'
				default: name
			}
		].join(', ')
	}
	
	private def operationArgs(Operation op) {
		op.arguments.map[
			switch it {
				case isVarargs: '__VA_ARGS__'
				default: name
			}
		].join(', ')
	}
	
	def generateSourceFile(Root root, DataClass dc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of DataClass �dc.name�
		 * 
		 */
		
		#include <string.h>

		#include "�dc.getCHeaderFileName�"
		#include "�dc.getCUtilsFileName�"
		
		�dc.userCode(3)�
		
		���		TODO: do we need setters and getters for C and C++ ?

		�dc.latestOperations.operationsImplementation(dc.name)�
		
		void �dc.name�_deepCopy(�dc.name�* source, �dc.name�* target) {
			memcpy(target, source, sizeof(�dc.name�));
		}
		
	'''}
	
	
}