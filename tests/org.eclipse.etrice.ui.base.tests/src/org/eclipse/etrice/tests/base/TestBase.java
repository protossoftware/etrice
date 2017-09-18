/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.tests.base;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public abstract class TestBase {

	private String basePath;
	private LinkedList<RoomModel> models = new LinkedList<RoomModel>();

	protected void loadModelFile() {
		try {
			URL modelsDir = getModelsDirectoy();
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		loadModels(getModelFileName());
	}

	protected void removeDiagramsDirectory() {
		File diagDir = new File(basePath+File.separator+"diagrams");
		if (diagDir.isDirectory()) {
			File[] files = diagDir.listFiles();
			if (files!=null)
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			diagDir.delete();
		}
	}
	
	private void loadModels(String modelName) {
		XtextResourceSet rs = new XtextResourceSet();
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		String path = basePath + modelName;
		URI uri = URI.createFileURI(path);
		Resource resource = rs.getResource(uri, true);
		Object root = resource.getContents().get(0);
		if (root instanceof RoomModel)
			models.add((RoomModel) root);
		else
			fail("File contains no RoomModel as root object");
	}

	public LinkedList<RoomModel> getModels() {
		return models;
	}

	protected abstract String getModelFileName();
	protected abstract URL getModelsDirectoy();

	protected boolean isEqual(Color c, IColorConstant cc) {
		if (c.getRed()!=cc.getRed())
			return false;
		if (c.getGreen()!=cc.getGreen())
			return false;
		if (c.getBlue()!=cc.getBlue())
			return false;
		return true;
	}
}
