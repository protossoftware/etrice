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

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.ComplexType
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*

import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.TypeHelpers


@Singleton
class DataClassGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers typeHelpers
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (dc: root.usedDataClasses) {
			var path = dc.generationTargetPath+dc.getPath
			var file = dc.getJavaFileName
			logger.logInfo("generating DataClass implementation '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(dc))
		}
	}
	
	def generate(Root root, DataClass dc) {
		val ctor = dc.operations.filter(op|op.constructor).head
		val dtor = dc.operations.filter(op|op.destructor).head
		
	'''
		package «dc.getPackage()»;
		
		«var models = root.getReferencedModels(dc)»
		«FOR model : models»import «model.name».*;
		«ENDFOR»
		
		«helpers.userCode(dc.userCode1)»
		
		
		public class «dc.name»«IF dc.base!=null» extends «dc.base.name»«ENDIF» {
			
			«helpers.userCode(dc.userCode2)»
			
			«helpers.attributes(dc.attributes)»
			
			«helpers.attributeSettersGettersImplementation(dc.attributes, dc.name)»
			
			«helpers.operationsImplementation(dc.operations, dc.name)»
			
			// default constructor
			public «dc.name»() {
				super();
				
				«dc.attributes.attributeInitialization(true)»
				«IF ctor!=null»
					
					{
						// user defined constructor body
						«FOR l : ctor.detailCode.commands»
							«l»
						«ENDFOR»
					}
				«ENDIF»
			}
			
			// constructor using fields
			public «dc.name»(«dc.argList») {
				«IF dc.base!=null»
				super(«dc.base.paramList»);
				«ELSE»
				super();
				«ENDIF»
				
				«FOR a : dc.attributes»
					this.«a.name» = «a.name»;
				«ENDFOR»
			}
			
			// deep copy
			public «dc.name» deepCopy() {
				«dc.name» copy = new «dc.name»();
				«deepCopy(dc)»
				return copy;
			}
		};
	'''
	}
	
	def paramList(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = dc.attributes.paramList.toString + result
			dc = dc.base
			if (dc!=null)
				result = ", "+result
		}
		return result
	}
	
	def paramList(List<Attribute> attributes) {
		'''«FOR a: attributes SEPARATOR ", "»«a.name»«ENDFOR»'''
	}
	
	def argList(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = dc.attributes.argList.toString + result
			dc = dc.base
			if (dc!=null)
				result = ", "+result
		}
		return result
	}
	
	def deepCopy(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = deepCopy(dc.attributes).toString + result
			dc = dc.base
		}
		return result
	}
	
	def deepCopy(List<Attribute> attributes) {
		'''
		«FOR a : attributes»
			«IF a.refType.type instanceof ComplexType»
				if («a.name»!=null) {
					«IF a.size==0»
						copy.«a.name» = «a.name».deepCopy();
					«ELSE»
						for (int i=0;i<«a.name».length;i++){
							copy.«a.name»[i] = «a.name»[i].deepCopy();
						}
					«ENDIF»
				}
			«ELSE»
				«IF a.size==0»
					copy.«a.name» = «a.name»;
				«ELSE»
					for (int i=0;i<«a.name».length;i++){
						copy.«a.name»[i] = «a.name»[i];
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		'''
	}
}
