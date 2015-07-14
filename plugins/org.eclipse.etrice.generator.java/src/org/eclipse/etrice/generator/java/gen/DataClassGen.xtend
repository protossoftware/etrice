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
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.generator.base.AbstractGenerator
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.room.util.RoomHelpers

@Singleton
class DataClassGen {

	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	@Inject extension Initialization
	@Inject extension FileSystemHelpers
	@Inject RoomHelpers roomHelpers
	
	def doGenerate(Root root) {
		for (dc: root.usedDataClasses.filter(cl|cl.isValidGenerationLocation)) {
			var path = dc.generationTargetPath+dc.getPath
			var infopath = dc.generationInfoPath+dc.getPath
			var file = dc.getJavaFileName
			fileIO.generateFile("generating DataClass implementation", path, infopath, file, root.generate(dc))
		}
	}
	
	def generate(Root root, DataClass dc) {
		val ctor = dc.structors.findFirst[isConstructor]
		val dtor = dc.structors.findFirst[!isConstructor]
		
	'''
		package «dc.getPackage()»;
		
		import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
		import java.io.Serializable;
		
		«var models = root.getReferencedModels(dc)»
		«FOR model : models»
			import «model.name».*;
		«ENDFOR»
		
		«dc.userCode(1)»
		
		
		public class «dc.name»«IF dc.base!=null» extends «dc.base.name»«ENDIF» implements Serializable {
			
			private static final long serialVersionUID = «(dc.package+dc.name).hashCode»L;
			
			«dc.userCode(2)»
			
			«dc.attributes.attributes»
			
			«dc.attributes.attributeSettersGettersImplementation(dc.name)»
			
			«dc.operations.operationsImplementation(dc.name)»
			
			//--------------------- destruction
			«getDestructorSignature(dc.name)» {
				«IF dc.base != null»super.dtor();«ENDIF»
				«IF dtor != null»«AbstractGenerator::getInstance().getTranslatedCode(dtor.detailCode)»«ENDIF»
			}
			
			// default constructor
			public «dc.name»() {
				super();
				
				«dc.attributes.attributeInitialization(dc, true)»
				«IF ctor!=null»
					{
						// user defined constructor body
						«AbstractGenerator::getInstance().getTranslatedCode(ctor.detailCode)»
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
	
	def private paramList(List<Attribute> attributes) {
		'''«FOR a: attributes SEPARATOR ", "»«a.name»«ENDFOR»'''
	}
	
	def argList(DataClass dc) {
		roomHelpers.getAllAttributes(dc).argList
	}
	
	def private deepCopy(DataClass _dc) {
		var result = ""
		var dc = _dc
		while (dc!=null) {
			result = deepCopy(dc.attributes).toString + result
			dc = dc.base
		}
		return result
	}
	
	def private deepCopy(List<Attribute> attributes) {
		'''
		«FOR a : attributes»
			«IF a.type.ref»
				copy.«a.name» = «a.name»;
			«ELSEIF a.type.type instanceof ComplexType»
				if («a.name»!=null) {
					«IF a.size<=1»
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
