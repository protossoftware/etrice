package org.eclipse.etrice.core.config

import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.ConfigStandaloneSetup
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.base.IDataConfiguration
import java.util.ArrayList

class DataConfiguration implements IDataConfiguration {
	

	override doSetup() {
		ConfigStandaloneSetup::doSetup()
	}
	
	override setResources(ResourceSet resource, ILogger logger) {
		DataConfigurationHelper::setConfigModels(resource, logger)
	}
	
	// static
	
	override getAttrClassConfigValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.value?.toStringExpr
	}
	
	override getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.min?.toStringExpr
	}
	
	override getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.max?.toStringExpr
	}
	
	def private getAttrClassConfig(ActorClass actor, List<Attribute> path){
		var id = '''/«actor.name»/«path.toStringPath»'''.toString
		DataConfigurationHelper::actorClassAttrMap.get(id)
	}
	
	override getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path) {
		var id = '''/«pc.name»/«IF regular»regular«ELSE»conjugated«ENDIF»/«path.toStringPath»'''.toString
		DataConfigurationHelper::protocolClassAttrMap.get(id)?.value?.toStringExpr
	}
	
	def private toStringPath(List<Attribute> path){
		'''«FOR a : path SEPARATOR '/'»«a.name»«ENDFOR»'''.toString
	}
	
	override getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path) {
		var id = ai.path+"/"+path.toStringPath
		DataConfigurationHelper::actorInstanceAttrMap.get(id)?.value?.toStringExpr
	}
	
	// dynamic
	
	override getAllDynConfigReadAttributes(ActorClass actor) {
		return new ArrayList<Attribute>
	}
	
	override getAllDynConfigWriteAttributes(ActorClass actor) {
		return new ArrayList<Attribute>
	}

	override getDynConfigReadAttributes(SubSystemClass subsystem) {
		return new ArrayList<Attribute>
	}
	
	override getDynConfigWriteAttributes(SubSystemClass subsystem) {
		return new ArrayList<Attribute>
	}
	
	override hasDynConfigReadAttributes(ActorClass actor) {
		false
	}
	
	override hasDynConfigWriteAttributes(ActorClass actor) {
		false
	}
	
	override hasVariableService(SubSystemClass subsystem) {
		false
	}
	
	def private toStringExpr(LiteralArray literal){
		'''«FOR l : literal.literals SEPARATOR ','»«l.toStringExpr»«ENDFOR»'''.toString
	}
	
	def private toStringExpr(Literal literal){
		switch(literal){
			BooleanLiteral: literal.isTrue.toString
			IntLiteral: literal.value.toString
			RealLiteral: literal.value.toString
			StringLiteral: literal.value.toString
		}
	}
	
}