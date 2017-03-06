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
import java.util.HashMap
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ReferenceType
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.java.Main

@Singleton
class ActorClassGen extends GenericActorClassGenerator {

	@Inject protected IGeneratorFileIo fileIO
	@Inject protected extension JavaExtensions
	@Inject protected extension RoomExtensions
	@Inject protected IDataConfiguration dataConfigExt
	final protected ConfigGenAddon configGenAddon

	@Inject protected extension ProcedureHelpers
	@Inject protected extension Initialization
	@Inject protected extension StateMachineGen
	@Inject protected extension TypeHelpers
	@Inject protected extension FileSystemHelpers

	@Inject
	new (ConfigGenAddon configGenAddon) {
		this.configGenAddon = configGenAddon
	}

	def doGenerate(Root root) {
		val HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>
		root.wiredInstances.filter(w|w instanceof WiredActorClass).forEach[w|ac2wired.put((w as WiredActorClass).actorClass, w as WiredActorClass)]
		for (xpac: root.xpActorClasses.filter(cl|cl.actorClass.isValidGenerationLocation)) {
			val wired = ac2wired.get(xpac.actorClass)
			val manualBehavior = xpac.actorClass.isBehaviorAnnotationPresent("BehaviorManual")
			val path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			val infopath = xpac.actorClass.generationInfoPath+xpac.actorClass.getPath
			var file = xpac.actorClass.getJavaFileName
			if (manualBehavior)
				file = "Abstract"+file
			fileIO.generateFile("generating ActorClass implementation", path, infopath, file, root.generate(xpac, wired, manualBehavior))
		}
	}

	def generate(Root root, ExpandedActorClass xpac, WiredActorClass wired, boolean manualBehavior) {
		val ac = xpac.actorClass
		val clsname = if (manualBehavior) "Abstract"+ac.name else ac.name
		val models = root.getReferencedModels(ac)
		val impPersist = if (Main::settings.generatePersistenceInterface) "implements IPersistable " else ""
		val dataObjClass = ac.name+"_DataObject"
		val baseClass = if (ac.actorBase!=null) ac.actorBase.name
			else if (!ac.getAttribute("ActorBaseClass", "class").empty) ac.getAttribute("ActorBaseClass", "class")
			else if (Main::settings.generateStoreDataObj) "ActorClassFinalActionBase"
			else "ActorClassBase"

	'''
		package «ac.getPackage»;

		«IF !dataConfigExt.getDynConfigReadAttributes(ac).empty»
			import org.eclipse.etrice.runtime.java.config.DynConfigLock;
		«ENDIF»
		«IF Main::settings.generatePersistenceInterface»
			import org.eclipse.etrice.runtime.java.modelbase.IPersistable;
			import java.io.IOException;
			import java.io.ObjectInput;
			import java.io.ObjectOutput;
		«ENDIF»
		«IF Main::settings.isGenerateStoreDataObj»
			import java.util.Arrays;
		«ENDIF»
		import org.eclipse.etrice.runtime.java.messaging.*;
		import org.eclipse.etrice.runtime.java.modelbase.*;
		import org.eclipse.etrice.runtime.java.debugging.*;

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

		«ac.userCode(1, true)»


		public «IF manualBehavior || ac.^abstract»abstract «ENDIF»class «clsname» extends «baseClass» «impPersist»{

			«ac.userCode(2, false)»

			//--------------------- ports
			«FOR ep : ac.getEndPorts()»
				protected «ep.getPortClassName()» «ep.name» = null;
			«ENDFOR»

			//--------------------- saps
			«FOR sap : ac.serviceAccessPoints»
				protected «sap.getPortClassName()» «sap.name» = null;
			«ENDFOR»

			//--------------------- services
			«FOR svc : ac.serviceImplementations»
				protected «svc.getPortClassName()» «svc.spp.name» = null;
			«ENDFOR»

			//--------------------- optional actors
			«FOR sub : ac.actorRefs.filter(r|r.refType==ReferenceType.OPTIONAL)»
				protected «sub.type.name»«IF sub.multiplicity!=1»Replicated«ENDIF»Interface «sub.name» = null;
			«ENDFOR»

			//--------------------- interface item IDs
			«xpac.genInterfaceItemConstants»

			«configGenAddon.genMinMaxConstants(ac)»
			«ac.attributes.attributes»
			«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
				private DynConfigLock lock_«a.name»;
			«ENDFOR»

			«operationsImplementation(ac.operations, ac.name)»


			//--------------------- construction
			public «clsname»(IRTObject parent, String name) {
				super(parent, name);
				setClassName("«ac.name»");

				«ac.attributes.attributeInitialization(ac, false)»

				// own ports
				«FOR ep : ac.getEndPorts()»
					«ep.name» = new «ep.getPortClassName()»(this, "«ep.name»", «ep.ifItemId»);
				«ENDFOR»

				// own saps
				«FOR sap : ac.serviceAccessPoints»
					«sap.name» = new «sap.getPortClassName()»(this, "«sap.name»", «sap.ifItemId», 0);
				«ENDFOR»

				// own service implementations
				«FOR svc : ac.serviceImplementations»
					«svc.spp.name» = new «svc.getPortClassName()»(this, "«svc.spp.name»", «svc.spp.ifItemId»);
				«ENDFOR»

				// sub actors
				«FOR sub : ac.actorRefs»
					«IF sub.refType==ReferenceType.OPTIONAL»
						«sub.name» = new «sub.type.name»«IF sub.multiplicity!=1»Replicated«ENDIF»Interface(this, "«sub.name»");
					«ELSEIF sub.multiplicity>1»
						for (int i=0; i<«sub.multiplicity»; ++i) {
							«IF Main::settings.generateMSCInstrumentation»
								DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»«GenmodelConstants::INDEX_SEP»"+i);
							«ENDIF»
							new «sub.type.name»(this, "«sub.name»«GenmodelConstants::INDEX_SEP»"+i);
						}
					«ELSE»
						«IF Main::settings.generateMSCInstrumentation»
							DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»");
						«ENDIF»
						new «sub.type.name»(this, "«sub.name»");
					«ENDIF»
				«ENDFOR»

				// wiring
				«FOR wire: wired.wires»
					«if (wire.dataDriven) "DataPortBase" else "InterfaceItemBase"».connect(this, "«wire.path1.join('/')»", "«wire.path2.join('/')»");
				«ENDFOR»

				«IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN»
					// activate polling for data-driven communication
					RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(getThread()).addPollingMessageReceiver(this);
				«ENDIF»

				«ac.userStructorBody(true)»

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
			«FOR sap : ac.serviceAccessPoints»
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

			«IF manualBehavior»
				public abstract void destroy();
			«ELSE»
				public void destroy(){
					«ac.userStructorBody(false)»
					«IF Main::settings.generateMSCInstrumentation»
						DebuggingService.getInstance().addMessageActorDestroy(this);
					«ENDIF»
					«IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN»
						RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(getThread()).removePollingMessageReceiver(this);
					«ENDIF»
					super.destroy();
				}
			«ENDIF»

			«IF manualBehavior»
				public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
					«FOR ifitem : ac.allInterfaceItems SEPARATOR "else "»
						if (ifitem==«ifitem.name») {
							switch (evt) {
								«FOR msg: ifitem.incoming»
									case «msg.protocolClass.name».«if (msg.incoming) "IN_" else "OUT_"»«msg.name»:
										«IF (msg.data!=null)»
											{«msg.typedDataDefinition»
										«ENDIF»
										on_«ifitem.name»_«msg.name»(ifitem«IF (msg.data!=null)», «msg.data.name»«ENDIF»);
										break;
										«IF (msg.data!=null)»
											}
										«ENDIF»
								«ENDFOR»
							}
						}
					«ENDFOR»
				}
				«FOR ifitem : ac.allInterfaceItems»
					«FOR msg: ifitem.incoming»
						protected void on_«ifitem.name»_«msg.name»(InterfaceItemBase ifitem«IF msg.data!=null»«msg.data.generateArglistAndTypedData.get(2)»«ENDIF») {}
					«ENDFOR»
				«ENDFOR»

				public abstract void executeInitTransition();
			«ELSE»
				«IF ac.hasNonEmptyStateMachine»
					«xpac.genStateMachine()»
					«IF ac.commType == ComponentCommunicationType::DATA_DRIVEN»
						public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
							handleSystemEvent(ifitem, evt, generic_data);
						}
					«ENDIF»
					«IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN»
						@Override
						public void receive(Message msg) {
							«IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS»
								receiveEvent(null, -1, null);
							«ELSE»
								receiveEventInternal();
							«ENDIF»
						}
					«ENDIF»
				«ELSEIF xpac.stateMachine.empty»
«««					no state machine in the super classes
					//--------------------- no state machine
					public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
						handleSystemEvent(ifitem, evt, data);
					}

					public void executeInitTransition() {}
				«ENDIF»
			«ENDIF»

			«IF Main::settings.generatePersistenceInterface»

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
			«IF Main::settings.isGenerateStoreDataObj»

				protected void store(IActorClassDataObject obj) {
					if (!(obj instanceof «dataObjClass»))
						return;

					«dataObjClass» dataObject = («dataObjClass») obj;
					«IF ac.actorBase!=null»

						super.store(dataObject);
					«ENDIF»
					«IF ac.hasNonEmptyStateMachine»

						dataObject.setState(getState());
						dataObject.setHistory(Arrays.copyOf(history, history.length));
					«ENDIF»
					«IF !ac.attributes.empty»

						«FOR att : ac.attributes»
							«IF att.type.type.enumerationOrPrimitive»
								«IF att.size>1»
									dataObject.set«att.name.toFirstUpper»(Arrays.copyOf(«att.name», «att.name».length));
								«ELSE»
									dataObject.set«att.name.toFirstUpper»(«att.name»);
								«ENDIF»
							«ELSE»
«««						DataClass and ExternalType
								«IF att.size>1»
									{
										«att.type.type.name»[] arr = Arrays.copyOf(«att.name», «att.name».length);
										for(int i=0; i<arr.length; ++i) arr[i] = arr[i].deepCopy();
										dataObject.set«att.name.toFirstUpper»(arr);
									}
								«ELSE»
									dataObject.set«att.name.toFirstUpper»(«att.name».deepCopy());
								«ENDIF»
							«ENDIF»
						«ENDFOR»
					«ENDIF»
				}

				protected void restore(IActorClassDataObject obj) {
					if (!(obj instanceof «dataObjClass»))
						return;

					«dataObjClass» dataObject = («dataObjClass») obj;
					«IF ac.actorBase!=null»

						super.restore(dataObject);
					«ENDIF»
					«IF ac.hasNonEmptyStateMachine»

						setState(dataObject.getState());
						history = Arrays.copyOf(dataObject.getHistory(), dataObject.getHistory().length);
					«ENDIF»
					«IF !ac.attributes.empty»

						«FOR att : ac.attributes»
							«IF att.type.type.enumerationOrPrimitive»
								«IF att.size>1»
									set«att.name.toFirstUpper»(Arrays.copyOf(dataObject.get«att.name.toFirstUpper»(), «att.name».length));
								«ELSE»
									set«att.name.toFirstUpper»(dataObject.get«att.name.toFirstUpper»());
								«ENDIF»
							«ELSE»
«««						DataClass and ExternalType
								«IF att.size>1»
									{
										«att.type.type.name»[] arr = Arrays.copyOf(dataObject.get«att.name.toFirstUpper»(), «att.name».length);
										for(int i=0; i<arr.length; ++i) arr[i] = arr[i].deepCopy();
										set«att.name.toFirstUpper»(arr);
									}
								«ELSE»
									set«att.name.toFirstUpper»(dataObject.get«att.name.toFirstUpper»().deepCopy());
								«ENDIF»
							«ENDIF»
						«ENDFOR»
					«ENDIF»
				}

				protected «dataObjClass» newDataObject() {
					return new «dataObjClass»();
				}
			«ENDIF»
		};
	'''
	}

	private def genSaveImpl(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		'''
			«IF ac.actorBase!=null»
				super.saveAttributes(output);

			«ENDIF»
			«IF !ac.attributes.empty»
				«FOR att : ac.attributes»
					«IF att.type.type.enumerationOrPrimitive»
						«genSavePrimitive(att)»
					«ELSE»
«««						DataClass and ExternalType (the latter one has to implement Serializable)
						«IF att.size>1»
							for («att.type.type.name» v: «att.name») output.writeObject(v);
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
			«IF ac.actorBase!=null»
				super.loadAttributes(input);

			«ENDIF»
			«IF !ac.attributes.empty»
				«FOR att : ac.attributes»
					«IF att.type.type.enumerationOrPrimitive»
						«genLoadPrimitive(att)»
					«ELSE»
«««						DataClass and ExternalType (the latter one has to implement Serializable)
						«IF att.size>1»
							for (int i=0; i< «att.name».length; ++i) «att.name»[i] = («att.type.type.name») input.readObject();
						«ELSE»
							«att.name» = («att.type.type.name») input.readObject();
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		'''
	}

	private def genSavePrimitive(Attribute att) {
		val type = if (att.type.type instanceof EnumerationType && (att.type.type as EnumerationType).primitiveType==null)
			"int"
		else
			att.type.type.typeName
		val method = type.saveMethod

		if (att.size>0)
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
		val type = if (att.type.type instanceof EnumerationType && (att.type.type as EnumerationType).primitiveType==null)
			"int"
		else
			att.type.type.typeName
		val method = type.loadMethod

		if (att.size>0)
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
