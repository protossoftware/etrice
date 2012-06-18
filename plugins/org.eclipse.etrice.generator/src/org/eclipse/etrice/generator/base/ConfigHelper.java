/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ProtocolClass;

public class ConfigHelper {

	public static Map<ActorContainerClass, ActorClassConfig> actorMap = new HashMap<ActorContainerClass, ActorClassConfig>();
	public static Map<ProtocolClass, ProtocolClassConfig> protocolMap = new HashMap<ProtocolClass, ProtocolClassConfig>();
	public static Map<String, ActorInstanceConfig> instanceMap = new HashMap<String, ActorInstanceConfig>();

	public static boolean setConfigModels(ResourceSet rs, ILogger logger) {
		actorMap.clear();
		protocolMap.clear();
		instanceMap.clear();
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
				if (actorMap.containsKey(classConfig.getActor())) {
					logger.logError("Multiple configurations for actor class "
							+ classConfig.getActor().getName() + " found", null);
					error = true;
				} else
					actorMap.put(classConfig.getActor(), classConfig);
			}
			for (ProtocolClassConfig protocolConfig : config
					.getProtocolClassConfigs()) {
				if (protocolMap.containsKey(protocolConfig)) {
					logger.logError(
							"Multiple configurations for protocol class "
									+ protocolConfig.getProtocol().getName()
									+ " found", null);
					error = true;
				} else
					protocolMap.put(protocolConfig.getProtocol(),
							protocolConfig);
			}
			for (ActorInstanceConfig instanceConfig : config
					.getActorInstanceConfigs()) {
				String path = "/" + instanceConfig.getRoot().getName()
						+ makePath(instanceConfig.getPath());
				if (instanceMap.containsKey(path)) {
					logger.logError(
							"Multiple configurations for actor instance "
									+ path + " found", null);
				} else
					instanceMap.put(path, instanceConfig);
			}
		}

		return !error;
	}

	private static String makePath(RefPath path) {
		String str = "";
		for (String s : path.getRefs())
			str += "/" + s;

		return str;
	}
}
