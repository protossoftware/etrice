/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/
package org.eclipse.etrice.generator.config.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DataConfigurationHelper {

	@Inject
	private ConfigUtil ConfigUtil;
	
	// static
	public Map<String, AttrClassConfig> actorClassAttrMap = new HashMap<String, AttrClassConfig>();
	public Map<String, AttrClassConfig> protocolClassAttrMap = new HashMap<String, AttrClassConfig>();
	public Map<String, AttrInstanceConfig> actorInstanceAttrMap = new HashMap<String, AttrInstanceConfig>();

	// dynamic
	public Map<String, SubSystemConfig> subSystemConfigMap = new HashMap<String, SubSystemConfig>();
	public Map<String, List<AttrInstanceConfig>> dynActorInstanceAttrMap = new HashMap<String, List<AttrInstanceConfig>>();
	public Map<ActorClass, List<AttrInstanceConfig>> dynActorClassAttrMap = new HashMap<ActorClass, List<AttrInstanceConfig>>();

	public boolean setConfigModels(ResourceSet rs, ILogger logger) {
		actorClassAttrMap.clear();
		protocolClassAttrMap.clear();
		actorInstanceAttrMap.clear();
		subSystemConfigMap.clear();
		dynActorInstanceAttrMap.clear();
		dynActorClassAttrMap.clear();

		boolean error = false;

		List<ConfigModel> configs = new ArrayList<ConfigModel>();
		for (Resource res : rs.getResources()) {
			for(EObject object : res.getContents()){
				if (object instanceof ConfigModel)
					configs.add((ConfigModel) object);
			}
		}

		if (!configs.isEmpty())
			logger.logInfo("-- loading configurations");

		Set<ActorClass> actorClasses = new HashSet<ActorClass>();
		Set<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		Set<String> actorInstances = new HashSet<String>();
		for (ConfigModel config : configs) {
			for (ActorClassConfig classConfig : config.getActorClassConfigs()) {
				if (actorClasses.contains(classConfig.getActor())) {
					logger.logError("Multiple configurations for actor class "
							+ classConfig.getActor().getName() + " found");
					error = true;
				} else {
					actorClasses.add(classConfig.getActor());
					collectConfigs(classConfig, actorClassAttrMap);
				}
			}
			for (ProtocolClassConfig protocolConfig : config
					.getProtocolClassConfigs()) {
				if (protocolClasses.contains(protocolConfig.getProtocol())) {
					logger.logError(
							"Multiple configurations for protocol class "
									+ protocolConfig.getProtocol().getName()
									+ " found");
					error = true;
				} else {
					protocolClasses.add(protocolConfig.getProtocol());
					collectConfigs(protocolConfig, protocolClassAttrMap);
				}
			}
			for (ActorInstanceConfig instanceConfig : config
					.getActorInstanceConfigs()) {
				String path = ConfigUtil.getPath(instanceConfig);
				if (actorInstances.contains(path)) {
					logger.logError(
							"Multiple configurations for actor instance "
									+ path + " found");
				} else {
					actorInstances.add(path);
					collectConfigs(instanceConfig, path, actorInstanceAttrMap);
				}
			}
			for (SubSystemConfig ssConfig : config.getSubSystemConfigs()) {
				String path = ConfigUtil.getPath(ssConfig);
				if (subSystemConfigMap.containsKey(path)) {
					logger.logError("Multiple configurations for subSystem"
							+ path + " found");
					error = true;
				} else
					subSystemConfigMap.put(path, ssConfig);
			}
		}

		return !error;
	}

	private void collectConfigs(ActorInstanceConfig actorConfig,
			String path, Map<String, AttrInstanceConfig> map) {
		for (AttrInstanceConfig c : actorConfig.getAttributes()) {
			collectConfigs(c, path + "/" + c.getAttribute().getName(), map);

			if (c.isDynConfig()) {
				List<AttrInstanceConfig> list = dynActorInstanceAttrMap
						.get(path);
				if (list == null)
					list = new ArrayList<AttrInstanceConfig>();
				list.add(c);
				dynActorInstanceAttrMap.put(path, list);

				ActorClass ac = ConfigUtil.getLastActorRef(
						actorConfig.getSubSystem().getType(),
						actorConfig.getPath()).getType();
				if ((list = dynActorClassAttrMap.get(ac)) == null)
					list = new ArrayList<AttrInstanceConfig>();
				list.add(c);
				dynActorClassAttrMap.put(ac, list);
			}
		}
		for (PortInstanceConfig c : actorConfig.getPorts()) {
			for (AttrInstanceConfig a : c.getAttributes())
				collectConfigs(a, path + "/" + c.getItem().getName() + "/"
						+ a.getAttribute().getName(), map);
		}
	}

	private void collectConfigs(ProtocolClassConfig protocolConfig,
			Map<String, AttrClassConfig> map) {
		String path = "/" + protocolConfig.getProtocol().getName();
		if (protocolConfig.getRegular() != null)
			for (AttrClassConfig c : protocolConfig.getRegular()
					.getAttributes())
				collectConfigs(c, path + "/regular/"
						+ c.getAttribute().getName(), map);
		if (protocolConfig.getConjugated() != null)
			for (AttrClassConfig c : protocolConfig.getConjugated()
					.getAttributes())
				collectConfigs(c, path + "/conjugated/"
						+ c.getAttribute().getName(), map);
	}

	private void collectConfigs(ActorClassConfig actorConfig,
			Map<String, AttrClassConfig> map) {
		String path = "/" + actorConfig.getActor().getName();
		for (AttrClassConfig c : actorConfig.getAttributes())
			collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
	}

	private void collectConfigs(AttrClassConfig config, String path,
			Map<String, AttrClassConfig> map) {
		Attribute a = config.getAttribute();
		if (a.getType().getType() instanceof DataClass)
			for (AttrClassConfig c : config.getAttributes())
				collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
		map.put(path, config);
	}

	private void collectConfigs(AttrInstanceConfig config, String path,
			Map<String, AttrInstanceConfig> map) {
		Attribute a = config.getAttribute();
		if (a.getType().getType() instanceof DataClass)
			for (AttrInstanceConfig c : config.getAttributes())
				collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
		map.put(path, config);
	}

	public String toStringPath(Iterable<String> path, String pathDelim) {
		StringBuilder b = new StringBuilder();
		for (String p : path)
			b.append(pathDelim + p);

		return b.toString();
	}
}
