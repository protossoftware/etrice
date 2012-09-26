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
package org.eclipse.etrice.generator.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;

public class ConfigHelper {

	public static Map<ActorClass, ActorClassConfig> ac2acConfMap = new HashMap<ActorClass, ActorClassConfig>();
	public static Map<ProtocolClass, ProtocolClassConfig> pc2pcConfMap = new HashMap<ProtocolClass, ProtocolClassConfig>();
	public static Map<String, ActorInstanceConfig> path2aiConfMap = new HashMap<String, ActorInstanceConfig>();
	public static Map<SubSystemClass, SubSystemConfig> ssc2ssConfMap = new HashMap<SubSystemClass, SubSystemConfig>();
	public static Map<SubSystemClass, List<AttrInstanceConfig>> ssc2attrInstConfMap = new HashMap<SubSystemClass, List<AttrInstanceConfig>>();
	public static Map<ActorClass, List<ActorInstanceConfig>> ac2aiConfMap = new HashMap<ActorClass, List<ActorInstanceConfig>>();
	public static Map<ActorInstanceConfig, ActorClass> aiConf2acMap = new HashMap<ActorInstanceConfig, ActorClass>();

	public static boolean setConfigModels(ResourceSet rs, ILogger logger) {
		ac2acConfMap.clear();
		pc2pcConfMap.clear();
		path2aiConfMap.clear();
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

		for (ConfigModel config : configs) {
			for (ActorClassConfig classConfig : config.getActorClassConfigs()) {
				if (ac2acConfMap.containsKey(classConfig.getActor())) {
					logger.logError("Multiple configurations for actor class "
							+ classConfig.getActor().getName() + " found", null);
					error = true;
				} else
					ac2acConfMap.put(classConfig.getActor(), classConfig);
			}
			for (ProtocolClassConfig protocolConfig : config
					.getProtocolClassConfigs()) {
				if (pc2pcConfMap.containsKey(protocolConfig)) {
					logger.logError(
							"Multiple configurations for protocol class "
									+ protocolConfig.getProtocol().getName()
									+ " found", null);
					error = true;
				} else
					pc2pcConfMap.put(protocolConfig.getProtocol(),
							protocolConfig);
			}
			for (ActorInstanceConfig instanceConfig : config
					.getActorInstanceConfigs()) {
				String path = "/" + instanceConfig.getRoot().getName()
						+ toPath(instanceConfig.getPath().getRefs(), "/");
				if (path2aiConfMap.containsKey(path)) {
					logger.logError(
							"Multiple configurations for actor instance "
									+ path + " found", null);
				} else
					path2aiConfMap.put(path, instanceConfig);

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
		for (ActorInstanceConfig instanceConfig : path2aiConfMap.values()) {
			List<AttrInstanceConfig> dynConfigs = new ArrayList<AttrInstanceConfig>();
			for (AttrInstanceConfig config : instanceConfig.getAttributes())
				if (config.isDynConfig())
					dynConfigs.add(config);
			if (!dynConfigs.isEmpty())
				ssc2attrInstConfMap.get(instanceConfig.getRoot()).addAll(
						dynConfigs);
		}

		return !error;
	}

	public static String toPath(Iterable<String> path, String pathDelim) {
		StringBuilder b = new StringBuilder();
		for (String p : path)
			b.append(pathDelim + p);

		return b.toString();
	}
}
