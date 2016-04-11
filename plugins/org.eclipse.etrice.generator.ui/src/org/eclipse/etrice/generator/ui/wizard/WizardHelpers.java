/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrentz (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.util.URI;

/**
 * @author hrentz
 *
 */
public class WizardHelpers {

	public static ZipFile getCRuntimeZip() {
		return getExampleZip("org.eclipse.etrice.runtime.c");
	}
	
	public static ZipFile getCModellibZip() {
		return getExampleZip("org.eclipse.etrice.modellib.c");
	}
	
	private static ZipFile getExampleZip(String name) {
		ZipFile zipFile = null;

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(CommonUIPlugin.INSTANCE.getSymbolicName(),
						"examples");
		IConfigurationElement[] exampleElements = extensionPoint.getConfigurationElements();
		for (int i = 0; i < exampleElements.length; i++) {
			IConfigurationElement exampleElement = exampleElements[i];
			IConfigurationElement[] projectDescriptorElements = exampleElement
					.getChildren("projectDescriptor");
			for (int j = 0; j < projectDescriptorElements.length; j++) {
				IConfigurationElement projectDescriptorElement = projectDescriptorElements[j];
				String projectName = projectDescriptorElement
						.getAttribute("name");
				if (projectName != null
						&& projectName.equals(name)) {
					String contentURI = projectDescriptorElement
							.getAttribute("contentURI");
					if (contentURI != null) {
						URI uri = URI.createURI(contentURI);
						if (uri.isRelative()) {
							uri = URI
									.createPlatformPluginURI(
											projectDescriptorElement
													.getContributor().getName()
													+ "/" + contentURI, true);
						}
						if (uri.isPlatform()) {
							uri = CommonPlugin.asLocalURI(uri);
						}

						String location = uri.toFileString();
						if (location != null) {
							File file = new File(location);
							if (file.isFile() && file.canRead()) {
								zipFile = createZipFile(file);
							}
						}
					}
				}
				if (zipFile != null)
					break;
			}
			if (zipFile != null)
				break;
		}

		return zipFile;
	}
	
	private static ZipFile createZipFile(File file) {
		try {
			return new ZipFile(file);
		} catch (ZipException e) {
			// Ignore
		} catch (IOException e) {
			// Ignore
		}
		return null;
	}

}
