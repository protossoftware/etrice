/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
/**
 * according to eclipse forums xtext.ui.editor.embedded is save to use
 */
public class MappingCreationPage extends WizardPage {

	private Injector etMapInjector;
	private EmbeddedEditor etMapEditor;
	private Injector etPhysInjector;
	private EmbeddedEditor etPhysEditor;

	private MappingBuilder builder = null;

	public MappingCreationPage(Injector etMapInjector, Injector etPhysInjector) {
		super("mapping_creation_page");

		this.etMapInjector = etMapInjector;
		this.etPhysInjector = etPhysInjector;
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		// - top level composite
		Composite topLevel = new Composite(parent, SWT.NONE);
		GridLayout gl_topLevel = new GridLayout();
		gl_topLevel.marginHeight = 0;
		topLevel.setLayout(gl_topLevel);
		topLevel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		topLevel.setFont(parent.getFont());

		// both editor side-by-side
		SashForm sash = new SashForm(topLevel, SWT.HORIZONTAL);
		sash.setLayout(new GridLayout(1, false));
		GridData sash_data = new GridData(SWT.FILL, SWT.FILL, true, true);
		sash_data.heightHint = convertHeightInCharsToPixels(11);
		sash.setLayoutData(sash_data);
		// 1. etMap editor
		{
			IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {

				@Override
				public XtextResource createResource() {
					IResourceFactory factory = etMapInjector.getInstance(IResourceFactory.class);
					XtextResource res = (XtextResource) factory.createResource(URI.createURI("dummy:/editor.etmap"));
					res.setValidationDisabled(true);

					return res;
				}
			};
			EmbeddedEditorFactory factory = etMapInjector.getInstance(EmbeddedEditorFactory.class);
			etMapEditor = factory.newEditor(resourceProvider).readOnly().withParent(sash);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.widthHint= convertWidthInCharsToPixels(120);
			data.heightHint= convertHeightInCharsToPixels(10);
			etMapEditor.getViewer().getControl().setLayoutData(data);
		}
		// 2. etPhys editor
		{
			IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {

				@Override
				public XtextResource createResource() {
					IResourceFactory factory = etPhysInjector.getInstance(IResourceFactory.class);
					XtextResource res = (XtextResource) factory.createResource(URI.createURI("dummy:/editor.etphys"));
					res.setValidationDisabled(true);

					return res;
				}
			};
			EmbeddedEditorFactory factory = etPhysInjector.getInstance(EmbeddedEditorFactory.class);
			etPhysEditor = factory.newEditor(resourceProvider).readOnly().withParent(sash);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.widthHint= convertWidthInCharsToPixels(80);
			data.heightHint= convertHeightInCharsToPixels(10);
			etPhysEditor.getViewer().getControl().setLayoutData(data);
		}
		setControl(topLevel);

		SelectRoomPage selectRoomPage = (SelectRoomPage) getPreviousPage();
		if (selectRoomPage.getSelectedRoomModel() != null)
			createMapping(selectRoomPage.getSelectedRoomModel());

		setPageComplete(true);
	}

	public void createMapping(RoomModel roomModel) {
		if (getControl() == null)
			return;

		builder = new MappingBuilder(roomModel, etMapInjector);
		SaveOptions options = SaveOptions.newBuilder().noValidation().format().getOptions();

		ISerializer serializer = builder.etMapRes.getSerializer();
		StringBuffer mappings = new StringBuffer();
		for (Mapping item : builder.mappingModel.getMappings())
			mappings.append(serializer.serialize(item, options));
		etMapEditor.createPartialEditor("", mappings.toString(), "", false);

		serializer = builder.etPhysRes.getSerializer();
		StringBuffer physEditorContent = new StringBuffer();
		for (PhysicalSystem item : builder.physicalModel.getSystems())
			physEditorContent.append(serializer.serialize(item, options));
		for (NodeClass item : builder.physicalModel.getNodeClasses())
			physEditorContent.append(serializer.serialize(item, options));
		for (RuntimeClass item : builder.physicalModel.getRuntimeClasses())
			physEditorContent.append(serializer.serialize(item, options));
		etPhysEditor.createPartialEditor("", physEditorContent.toString(), "", false);
	}

	public Resource getMappingModelResource(String setPhysModelImport) {
		builder.setPhysImport(setPhysModelImport);
		return builder.etMapRes;
	}

	public Resource getPhysModelResource() {
		return builder.etPhysRes;
	}

}
