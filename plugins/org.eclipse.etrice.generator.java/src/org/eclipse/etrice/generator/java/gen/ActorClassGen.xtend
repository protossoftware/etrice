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
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.generator.base.AbstractGenerator
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.core.room.ReferenceType
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.Attribute

@Singleton
class ActorClassGen extends GenericActorClassGenerator {
	
	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject IDataConfiguration dataConfigExt
	@Inject ConfigGenAddon configGenAddon
	
	@Inject extension ProcedureHelpers
	@Inject extension Initialization
	@Inject extension StateMachineGen
	
	def doGenerate(Root root) {
		for (xpac: root.xpActorClasses) {
			val manualBehavior = xpac.actorClass.isBehaviorAnnotationPresent("BehaviorManual")
			val path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			val infopath = xpac.actorClass.generationInfoPath+xpac.actorClass.getPath
			var file = xpac.actorClass.getJavaFileName
			if (manualBehavior)
				file = "Abstract"+file
			fileIO.generateFile("generating ActorClass implementation", path, infopath, file, root.generate(xpac, manualBehavior))
		}
	}
	
	def generate(Root root, ExpandedActorClass xpac, boolean manualBehavior) {
		val ac = xpac.actorClass
		val clsname = if (manualBehavior) "Abstract"+ac.name else ac.name
		val ctor = ac.operations.filter(op|op.constructor).head
		val dtor = ac.operations.filter(op|op.destructor).head
		val models = root.getReferencedModels(ac)
		val impPersist = if (GlobalSettings::generatePersistenceInterface) "implements IPersistable " else ""
		
	'''
		package «ac.getPackage»;
		
		«IF !dataConfigExt.getDynConfigReadAttributes(ac).empty»
			import org.eclipse.etrice.runtime.java.config.DynConfigLock;
		«ENDIF»
		«IF GlobalSettings::generatePersistenceInterface»
			import org.eclipse.etrice.runtime.java.modelbase.IPersistable;
			import java.io.IOException;
			import java.io.ObjectInput;
			import java.io.ObjectOutput;
		«ENDIF»
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
		
		«FOR model : models»
			import «model.name».*;
		«ENDFOR»
		
		«FOR pc : root.getReferencedProtocolClasses(ac)»
			import «pc.package».«pc.name».*;
		«ENDFOR»

		«FOR sub : ac.actorRefs.filter(r|r.refType==ReferenceType.OPTIONAL)»
			import «sub.type.package».«sub.type.name»Interface;
		«ENDFOR»
		
		«ac.userCode(1)»
		
		
		public «IF manualBehavior || ac.^abstract»abstract «ENDIF»class «clsname» extends «IF ac.base!=null»«ac.base.name»«ELSE»ActorClassBase«ENDIF» «impPersist»{
		
			«ac.userCode(2)»
			
			//--------------------- ports
			«FOR ep : ac.getEndPorts()»
				protected «ep.getPortClassName()» «ep.name» = null;
			«ENDFOR»
			
			//--------------------- saps
			«FOR sap : ac.strSAPs»
				protected «sap.getPortClassName()» «sap.name» = null;
			«ENDFOR»
			
			//--------------------- services
			«FOR svc : ac.serviceImplementations»
				protected «svc.getPortClassName()» «svc.spp.name» = null;
			«ENDFOR»
			
			//--------------------- optional actors
			«FOR sub : ac.actorRefs.filter(r|r.refType==ReferenceType.OPTIONAL)»
				protected «sub.type.name»«IF sub.size!=1»Replicated«ENDIF»Interface «sub.name» = null;
			«ENDFOR»
			
			//--------------------- interface item IDs
			«xpac.genInterfaceItemConstants»
			
			«configGenAddon.genMinMaxConstants(ac)»
			«ac.attributes.attributes»
			«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
				private DynConfigLock lock_«a.name»;
			«ENDFOR»
			«ac.operationsImplementation»
		
			//--------------------- construction
			public «clsname»(IRTObject parent, String name) {
				super(parent, name);
				setClassName("«ac.name»");
				
				«ac.attributes.attributeInitialization(ac, false)»
		
				// own ports
				«FOR ep : ac.getEndPorts()»
					«ep.name» = new «ep.getPortClassName()»(this, "«ep.name»", IFITEM_«ep.name»);
				«ENDFOR»
				
				// own saps
				«FOR sap : ac.strSAPs»
					«sap.name» = new «sap.getPortClassName()»(this, "«sap.name»", IFITEM_«sap.name», 0);
				«ENDFOR»
				
				// own service implementations
				«FOR svc : ac.serviceImplementations»
					«svc.spp.name» = new «svc.getPortClassName()»(this, "«svc.spp.name»", IFITEM_«svc.spp.name»);
				«ENDFOR»
				
				// sub actors
				«FOR sub : ac.actorRefs»
					«IF sub.refType==ReferenceType.OPTIONAL»
						«sub.name» = new «sub.type.name»«IF sub.size!=1»Replicated«ENDIF»Interface(this, "«sub.name»");
					«ELSEIF sub.size>1»
						for (int i=0; i<«sub.size»; ++i) {
							«IF GlobalSettings::generateMSCInstrumentation»
								DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»_"+i);
							«ENDIF»
							new «sub.type.name»(this, "«sub.name»_"+i);
						}
					«ELSE»
						«IF GlobalSettings::generateMSCInstrumentation»
							DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»");
						«ENDIF»
						new «sub.type.name»(this, "«sub.name»");
					«ENDIF»
				«ENDFOR»
				«IF ctor!=null»
					
					{
						// user defined constructor body
						«AbstractGenerator::getInstance().getTranslatedCode(ctor.detailCode)»
					}
				«ENDIF»

				«IF !dataConfigExt.getDynConfigReadAttributes(ac).empty || !dataConfigExt.getDynConfigWriteAttributes(ac).empty»
					«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
						lock_«a.name» = new DynConfigLock();
					«ENDFOR»
				«ENDIF»
			}
			
			«attributeSettersGettersImplementation(ac.attributes.minus(dataConfigExt.getDynConfigReadAttributes(ac)), ac.name)»
			
			«configGenAddon.genDynConfigGetterSetter(ac)»
			
			//--------------------- port getters
			«FOR ep : ac.getEndPorts()»
				«ep.portClassName.getterImplementation(ep.name, ac.name)»
			«ENDFOR»
			«FOR sap : ac.strSAPs»
				«sap.portClassName.getterImplementation(sap.name, ac.name)»
			«ENDFOR»
			«FOR svc : ac.serviceImplementations»
				«svc.portClassName.getterImplementation(svc.spp.name, ac.name)»
			«ENDFOR»
		
			//--------------------- lifecycle functions
			«IF !ac.overridesStop()»
				«IF manualBehavior»
					public abstract void stop();
				«ELSE»
					public void stop(){
						stopUser();
						super.stop();
					}
				«ENDIF»
			«ENDIF»
			
			«IF dtor!=null»
				«IF manualBehavior»
					public abstract void destroy();
				«ELSE»
					public void destroy(){
						«ac.name.destructorCall»;
						«IF GlobalSettings::generateMSCInstrumentation»
							DebuggingService.getInstance().addMessageActorDestroy(this);
						«ENDIF»
						super.destroy();
					}
				«ENDIF»
			«ELSEIF GlobalSettings::generateMSCInstrumentation»
				public void destroy() {
					DebuggingService.getInstance().addMessageActorDestroy(this);
					super.destroy();
				}
			«ENDIF»
		
			«IF manualBehavior»
				public abstract void receiveEvent(InterfaceItemBase ifitem, int evt, Object data);
				public abstract void executeInitTransition();
			«ELSE»
				«IF ac.hasNonEmptyStateMachine»
					«xpac.genStateMachine()»
				«ELSEIF !xpac.hasStateMachine()»
					//--------------------- no state machine
					public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
						handleSystemEvent(ifitem, evt, data);
					}
					
					public void executeInitTransition() {}
				«ENDIF»
			«ENDIF»
			«IF GlobalSettings::generatePersistenceInterface»
				
				@Override
				public void saveObject(ObjectOutput output) throws IOException {
					«IF xpac.hasStateMachine()»
						// state and history
						output.writeInt(getState());
						for (int h: history) output.writeInt(h);
						
					«ENDIF»
					saveAttributes(output);
				}
				
				protected void saveAttributes(ObjectOutput output) throws IOException {
					«xpac.genSaveImpl»
				}
				
				@Override
				public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
					«IF xpac.hasStateMachine()»
						// state and history
						setState(input.readInt());
						for (int i=0; i<history.length; ++i) history[i] = input.readInt();
						
					«ENDIF»
					loadAttributes(input);
				}
				
				protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {
					«xpac.genLoadImpl»
				}
			«ENDIF»
		};
	'''
	}
	
	private def genSaveImpl(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			«IF ac.base!=null»
			super.saveAttributes(output);
			
			«ENDIF»
			«IF !ac.attributes.empty»
				«FOR att : ac.attributes»
					«IF att.refType.type instanceof PrimitiveType»
						«genSavePrimitive(att)»
					«ELSE»
«««						DataClass and ExternalType (the latter one has to implement Serializable)
						«IF att.size>1»
							for («att.refType.type.name» v: «att.name») output.writeObject(v);
						«ELSE»
							output.writeObject(«att.name»);
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		'''
	}
	
	private def genLoadImpl(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			«IF ac.base!=null»
			super.loadAttributes(input);
			
			«ENDIF»
			«IF !ac.attributes.empty»
				«FOR att : ac.attributes»
					«IF att.refType.type instanceof PrimitiveType»
						«genLoadPrimitive(att)»
					«ELSE»
«««						DataClass and ExternalType (the latter one has to implement Serializable)
						«IF att.size>1»
							for (int i=0; i< «att.name».length; ++i) «att.name»[i] = («att.refType.type.name») input.readObject();
						«ELSE»
							«att.name» = («att.refType.type.name») input.readObject();
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		'''
	}

	private def genSavePrimitive(Attribute att) {
		val type = (att.refType.type as PrimitiveType).targetName
		val method = type.saveMethod
		
		if (att.size>1)
			"for ("+type+" v: "+att.name+") output."+method+"(v);"
		else
			"output."+method+"("+att.name+");"
	}	
	
	private def getSaveMethod(String type) {
		switch (type) {
			case "boolean": "writeBoolean"
			case "char": "writeChar"
			case "byte": "writeByte"
			case "short": "writeShort"
			case "int": "write"
			case "long": "writeLong"
			case "float": "writeFloat"
			case "double": "writeDouble"
			case "String": "writeUTF"
		}
	}

	private def genLoadPrimitive(Attribute att) {
		val type = (att.refType.type as PrimitiveType).targetName
		val method = type.loadMethod
		
		if (att.size>1)
			"for (int i=0; i<"+att.name+".length; ++i) "+att.name+"[i] = input."+method+"();"
		else
			att.name+" = input."+method+"();"
	}	
	
	private def getLoadMethod(String type) {
		switch (type) {
			case "boolean": "readBoolean"
			case "char": "readChar"
			case "byte": "readByte"
			case "short": "readShort"
			case "int": "read"
			case "long": "readLong"
			case "float": "readFloat"
			case "double": "readDouble"
			case "String": "readUTF"
		}
	}
}
