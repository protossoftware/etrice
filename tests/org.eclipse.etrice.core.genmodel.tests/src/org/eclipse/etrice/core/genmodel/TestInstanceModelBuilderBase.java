/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilderFactory;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.base.logging.NullLogger;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public class TestInstanceModelBuilderBase {
	
	class Diagnostician implements IDiagnostician {

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature) {
		}

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature, int index) {
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature) {
			fail(msg+roomNameProvider.getLocation(source));
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature, int index) {
			fail(msg+roomNameProvider.getLocation(source));
		}

		@Override
		public boolean isFailed() {
			return false;
		}
		
	}

	private String basePath;
	protected HashMap<EClass, ArrayList<EObject>> instances;
	private RoomNameProvider roomNameProvider = new RoomNameProvider();
	private GeneratorModelBuilderFactory genModelFactory = new RoomStandaloneSetup().createInjector().getInstance(GeneratorModelBuilderFactory.class);
	
	protected void prepare() {
		try {
			URL modelsDir = GenmodelTestsActivator.getInstance().getBundle().getEntry("models");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected LinkedList<RoomModel> getModels(String modelName) {
		LinkedList<RoomModel> models = new LinkedList<RoomModel>();
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
		
		return models;
	}

	protected Root buildInstanceModel(String modelName) {
		GeneratorModelBuilder builder = genModelFactory.create(new NullLogger(), new Diagnostician());
		LinkedList<RoomModel> models = getModels(modelName);
		ArrayList<RoomModel> importedModels = new ArrayList<>();
		Root root = builder.createGeneratorModel(models, importedModels, false);
		return root;
	}

	protected HashMap<EClass, ArrayList<EObject>> collectInstances(EObject root) {
		HashMap<EClass, ArrayList<EObject>> result = new HashMap<EClass, ArrayList<EObject>>();
		
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			EClass ecl = obj.eClass();
			ArrayList<EObject> instances = result.get(ecl);
			if (instances==null) {
				instances = new ArrayList<EObject>();
				result.put(ecl, instances);
			}
			instances.add(obj);
		}
		
		return result;
	}

	protected InstanceBase getInstance(List<? extends EObject> objects, String path) {
		for (EObject obj : objects) {
			if (obj instanceof InstanceBase) {
				InstanceBase inst = (InstanceBase) obj;
				if (inst.getPath().equals(path))
					return inst;
			}
		}
		return null;
	}

	protected StateGraphItem getStateGraphItem(List<? extends EObject> objects, String path) {
		for (EObject obj : objects) {
			if (obj instanceof StateGraphItem) {
				StateGraphItem item = (StateGraphItem) obj;
				if (roomNameProvider.getFullPath(item).equals(path))
					return item;
			}
		}
		return null;
	}

	protected void checkSize(int expected, EClass cls) {
		ArrayList<EObject> objs = instances.get(cls);
		assertEquals("Number of "+cls.getName(), expected, objs.size());
	}

}
