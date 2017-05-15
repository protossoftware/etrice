package org.eclipse.etrice.generator.generic

import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.etmap.eTMap.ETMapFactory
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger
import org.eclipse.etrice.core.room.RoomFactory
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.StructureClass
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class TestInstanceCreator {

	static val ANNOTATION_TYPE_NAME = "TestInstance"

	val extension RoomFactory = RoomFactory.eINSTANCE
	val extension ETMapFactory = ETMapFactory.eINSTANCE

	// ctor
	val ILogger logger

	/**
	 * Creates instance and mapping for classes having <code>@TestInstance</code> annotation:
	 * <p>
	 * a) In case of a single SubSystemClass, a new LogicalSystem with a SubSystemRef will be created<br>
	 * b) For ActorClasses, one new SubSystem- and LogicalSystem with necessary refs will be created</br>
	 * Resulting ROOM classes are stored in new RoomModel within a new memory-only resource.</br>
	 * Resulting mapping is stored in a new MappingModel within a new memory-only resource.</br>
	 * </p>
	 * 
	 * Note: currently only one class having <code>@TestInstance</code> annotation is supported
	 * 
	 * @param rs ResourceSet for new resources
	 * @return false, if creation failed and generation should stop
	 */
	def boolean createInstancesAndMapping(ResourceSet rs) {
		val roomModels = newArrayList
		val physModels = newArrayList
		rs.resources.forEach[contents.forall[switch it { RoomModel: roomModels += it PhysicalModel: physModels += it }]]

		// try find annotated SubSystemClass
		val allTestSubSystems = roomModels.fold(newArrayList, [list, model | list += model.subSystemClasses.filter[hasTestAnnotation] return list])
		val List<StructureClass> allAnnotatedClasses = newArrayList(allTestSubSystems)

		// try find annotated ActorClasses and map them to virtual sub system
		{
			val derivedSubSystem = createSubSystemClass => [name = "DerivedTestSubSystem"]
			roomModels.forEach[model|
				// actors to actorRef into subsystem
				derivedSubSystem.actorRefs += model.actorClasses.filter[hasTestAnnotation].map[ac|
					allAnnotatedClasses += ac
					createActorRef => [
						name = "ref_" + ac.name
						type = ac
					]]]
			if (!derivedSubSystem.actorRefs.isEmpty)
				allTestSubSystems += derivedSubSystem
		}

		if(allTestSubSystems.isEmpty) return true
//		if (roomModels.exists[model|!model.systems.empty]) {
//			allAnnotatedClasses.forEach[roomCls|
//				logger.logInfo(
//					'''TestInstanceCreator: ignored annotation '@«ANNOTATION_TYPE_NAME»' at «roomCls.name»:«roomCls.eClass.name», because there is already a LogicalSystem («roomCls.eResource.URI»)''')]
//			return true
//		}
		
		// validation
		if (allAnnotatedClasses.size > 1) {
			allAnnotatedClasses.forEach[roomCls|
				logger.logError('''TestInstanceCreator: mapping failed, multiple test instances present''', roomCls)]
			return false
		}

		// get physical system
		val List<PhysicalSystem> allPhysSystems = physModels.fold(newArrayList,[list, model|list += model.systems return list])
		if (allPhysSystems.size != 1) {
			logger.logError('''TestInstanceCreator: mapping failed, found «allPhysSystems.size» physical systems''', null)
			return false
		}

		// create mapping
		logger.logInfo('''TestInstanceCreator: creating instance and mapping for «allAnnotatedClasses.head.name»:«allAnnotatedClasses.head.eClass.name»''')
		val physSystem = allPhysSystems.head
		val testSubSystem = allTestSubSystems.head
		val testSystem = createLogicalSystem => [name = "DerivedTestSystem"]
		testSystem.subSystems += createSubSystemRef => [name = "ref_" + testSubSystem.name type = testSubSystem]
		val testRoomModel = createRoomModel => [
			name = "DerivedTestRoomModel"
			systems += testSystem
			if(testSubSystem.eResource === null) subSystemClasses += testSubSystem
		]
		val testMappingModel = createMappingModel => [
			name = "DerivedTestMappingModel"
			mappings += createMapping => [
				logicalSys = testSystem
				physicalSys = physSystem
				subsysMappings += testSystem.subSystems.map [ subSysRef |
					createSubSystemMapping => [
						logicalSubSys = subSysRef
						node = physSystem.nodeRefs.head
					]
				]
			]
		]

		// create memory resource with same uri locations as test instance
		val Resource existingResource = if(testSubSystem.eResource !== null) testSubSystem.eResource else allAnnotatedClasses.head.eResource
		val uriPath = existingResource.URI.trimFileExtension.trimSegments(1)
		rs.createResource(uriPath.appendSegment("DerivedTestMappingModel").appendFileExtension("etmap")).contents += testMappingModel
		rs.createResource(uriPath.appendSegment("DerivedTestRoomModel").appendFileExtension("room")).contents += testRoomModel
			
	}

	def protected hasTestAnnotation(StructureClass cls) {
		cls.annotations.exists[type.name == ANNOTATION_TYPE_NAME]
	}
}
