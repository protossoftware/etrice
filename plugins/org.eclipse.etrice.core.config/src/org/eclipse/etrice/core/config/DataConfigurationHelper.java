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
package org.eclipse.etrice.core.config;

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
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;

public class DataConfigurationHelper {

	// static
	public static Map<String, AttrClassConfig> actorClassAttrMap = new HashMap<String, AttrClassConfig>();
	public static Map<String, AttrClassConfig> protocolClassAttrMap = new HashMap<String, AttrClassConfig>();
	public static Map<String, AttrInstanceConfig> actorInstanceAttrMap = new HashMap<String, AttrInstanceConfig>();

	// dynamic
	public static Map<SubSystemClass, SubSystemConfig> ssc2ssConfMap = new HashMap<SubSystemClass, SubSystemConfig>();
	public static Map<SubSystemClass, List<AttrInstanceConfig>> ssc2attrInstConfMap = new HashMap<SubSystemClass, List<AttrInstanceConfig>>();
	public static Map<ActorClass, List<ActorInstanceConfig>> ac2aiConfMap = new HashMap<ActorClass, List<ActorInstanceConfig>>();
	public static Map<ActorInstanceConfig, ActorClass> aiConf2acMap = new HashMap<ActorInstanceConfig, ActorClass>();

	public static boolean setConfigModels(ResourceSet rs, ILogger logger) {
		actorClassAttrMap.clear();
		protocolClassAttrMap.clear();
		actorInstanceAttrMap.clear();
		
		ssc2ssConfMap.clear();
		ssc2attrInstConfMap.clear();
		ac2aiConfMap.clear();
		aiConf2acMap.clear();
		boolean error = false;

		List<ConfigModel> configs = new ArrayList<ConfigModel>();
		for (Resource res : rs.getResources()) {
			EObject object = res.getContents().get(0);
			if (object instanceof ConfigModel)
				configs.add((ConfigModel) object);
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
							+ classConfig.getActor().getName() + " found", null);
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
									+ " found", null);
					error = true;
				} else {
					protocolClasses.add(protocolConfig.getProtocol());
					collectConfigs(protocolConfig, protocolClassAttrMap);
				}
			}
			for (ActorInstanceConfig instanceConfig : config
					.getActorInstanceConfigs()) {
				String path = "/" + instanceConfig.getRoot().getName()
						+ toPath(instanceConfig.getPath().getRefs(), "/");
				if (actorInstances.contains(path)) {
					logger.logError(
							"Multiple configurations for actor instance "
									+ path + " found", null);
				} else {
					actorInstances.add(path);
					collectConfigs(instanceConfig, path, actorInstanceAttrMap);
				}

				ActorClass ac = ConfigUtil.resolve(instanceConfig.getRoot(),
						instanceConfig.getPath());
				if (ac2aiConfMap.get(ac) == null)
					ac2aiConfMap.put(ac, new ArrayList<ActorInstanceConfig>());
				ac2aiConfMap.get(ac).add(instanceConfig);

				aiConf2acMap.put(instanceConfig, ac);
			}
			for (SubSystemConfig ssConfig : config.getSubSystemConfigs()) {
				if (ssc2ssConfMap.containsKey(ssConfig)) {
					logger.logError(
							"Multiple configurations for subSystem class "
									+ ssConfig.getSubSystem().getName()
									+ " found", null);
					error = true;
				} else {
					ssc2ssConfMap.put(ssConfig.getSubSystem(), ssConfig);
					ssc2attrInstConfMap.put(ssConfig.getSubSystem(),
							new ArrayList<AttrInstanceConfig>());
				}
			}
		}

		// dynConfigSubsystemMap
		// for (ActorInstanceConfig instanceConfig : actorInstanceMap.values())
		// {
		// List<AttrInstanceConfig> dynConfigs = new
		// ArrayList<AttrInstanceConfig>();
		// for (AttrInstanceConfig config : instanceConfig.getAttributes())
		// if (config.isDynConfig())
		// dynConfigs.add(config);
		// if (!dynConfigs.isEmpty())
		// ssc2attrInstConfMap.get(instanceConfig.getRoot()).addAll(
		// dynConfigs);
		// }

		return !error;
	}

	private static void collectConfigs(ActorInstanceConfig actorConfig,
			String path, Map<String, AttrInstanceConfig> map) {
		for (AttrInstanceConfig c : actorConfig.getAttributes())
			collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
	}

	private static void collectConfigs(ProtocolClassConfig protocolConfig,
			Map<String, AttrClassConfig> map) {
		String path = "/" + protocolConfig.getProtocol().getName();
		for (AttrClassConfig c : protocolConfig.getRegular().getAttributes())
			collectConfigs(c, path + "/regular/" + c.getAttribute().getName(),
					map);
		for (AttrClassConfig c : protocolConfig.getConjugated().getAttributes())
			collectConfigs(c, path + "/conjugated/"
					+ c.getAttribute().getName(), map);
	}

	private static void collectConfigs(ActorClassConfig actorConfig,
			Map<String, AttrClassConfig> map) {
		String path = "/" + actorConfig.getActor().getName();
		for (AttrClassConfig c : actorConfig.getAttributes())
			collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
	}

	private static void collectConfigs(AttrClassConfig config, String path,
			Map<String, AttrClassConfig> map) {
		Attribute a = config.getAttribute();
		if (a.getRefType().getType() instanceof DataClass)
			for (AttrClassConfig c : config.getAttributes())
				collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
		map.put(path, config);
	}

	private static void collectConfigs(AttrInstanceConfig config, String path,
			Map<String, AttrInstanceConfig> map) {
		Attribute a = config.getAttribute();
		if (a.getRefType().getType() instanceof DataClass)
			for (AttrInstanceConfig c : config.getAttributes())
				collectConfigs(c, path + "/" + c.getAttribute().getName(), map);
		map.put(path, config);
	}

	public static String toPath(Iterable<String> path, String pathDelim) {
		StringBuilder b = new StringBuilder();
		for (String p : path)
			b.append(pathDelim + p);

		return b.toString();
	}
}
