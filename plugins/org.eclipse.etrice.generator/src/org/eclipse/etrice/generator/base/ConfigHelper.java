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
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.room.ActorContainerClass;

public class ConfigHelper {

	public static Map<ActorContainerClass, ActorClassConfig> classMap = new HashMap<ActorContainerClass, ActorClassConfig>();
	public static Map<String, ActorInstanceConfig> instanceMap = new HashMap<String, ActorInstanceConfig>();

	public static boolean setConfigModels(ResourceSet rs, ILogger logger) {
		classMap.clear();
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
				if (classMap.containsKey(classConfig.getActor())) {
					logger.logError("Multiple configurations for actor class "
							+ classConfig.getActor().getName() + " found", null);
					error = true;
				} else
					classMap.put(classConfig.getActor(), classConfig);
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
