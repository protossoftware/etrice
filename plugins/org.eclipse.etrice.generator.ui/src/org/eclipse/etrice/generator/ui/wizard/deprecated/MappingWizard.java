/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard.deprecated;

import org.eclipse.etrice.core.etmap.ui.internal.ETMapActivator;
import org.eclipse.etrice.core.etphys.ui.internal.ETPhysActivator;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.generator.ui.wizard.ProjectCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Injector;

@Deprecated
public class MappingWizard extends Wizard implements INewWizard {

	private static final String title = "Create a physical mapping for a ROOM model";

	private IStructuredSelection initialSelection;

	private SelectRoomPage roomPage;
	private MappingCreationPage modelPage;
	private SaveMappingPage savePage;

	@Override
	public void addPages() {
		super.addPages();

		Injector roomInjector = RoomActivator.getInstance().getInjector(RoomActivator.ORG_ECLIPSE_ETRICE_CORE_ROOM);
		Injector etMapInjector = ETMapActivator.getInstance().getInjector(
				ETMapActivator.ORG_ECLIPSE_ETRICE_CORE_ETMAP_ETMAP);
		Injector etPhysInjector = ETPhysActivator.getInstance().getInjector(
				ETPhysActivator.ORG_ECLIPSE_ETRICE_CORE_ETPHYS_ETPHYS);

		roomPage = new SelectRoomPage(initialSelection, roomInjector);
		roomPage.setTitle(title);
		roomPage.setDescription("Select .room file");
		addPage(roomPage);

		modelPage = new MappingCreationPage(etMapInjector, etPhysInjector);
		modelPage.setTitle(title);
		modelPage.setDescription("Create new mapping and physical model");
		addPage(modelPage);

		savePage = new SaveMappingPage();
		savePage.setTitle(title);
		savePage.setDescription("Save new models");
		addPage(savePage);
	}

	@Override
	public boolean performFinish() {
//		IFile mappingModelFile = savePage.getMappingFilePath();
//		IFile physModelFile = savePage.getPhysModelPath();
//
//		Resource etPhysRes = modelPage.getPhysModelResource();
//		URI etPhysURI = URI.createPlatformResourceURI(physModelFile.getFullPath().toString(), true);
//		etPhysRes.setURI(etPhysURI);
//
//		Resource etMapRes = (XtextResource) modelPage.getMappingModelResource(etPhysURI.toString());
//		etMapRes.setURI(URI.createPlatformResourceURI(mappingModelFile.getFullPath().toString(), true));
//
//		SaveOptions options = SaveOptions.newBuilder().format().noValidation().getOptions();
//		try {
//			etPhysRes.save(options.toOptionsMap());
//			etMapRes.save(options.toOptionsMap());
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//			return true;
//		}
//
//		IWorkbenchWindow dw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//		try {
//			if (dw != null) {
//				IWorkbenchPage page = dw.getActivePage();
//				if (page != null) {
//					IDE.openEditor(page, physModelFile, true);
//					IDE.openEditor(page, mappingModelFile, true);
//				}
//			}
//		}
//		catch (PartInitException e) {
//		}

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.initialSelection = selection;

		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle(title);
		setHelpAvailable(false);
	}

}
