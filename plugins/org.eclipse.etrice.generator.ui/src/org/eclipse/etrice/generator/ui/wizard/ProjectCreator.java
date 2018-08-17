/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.etrice.core.ui.RoomUiActivator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 * 
 */
public class ProjectCreator {

	private static final String[] commonNatureIDs = {JavaCore.NATURE_ID,
			"org.eclipse.xtext.ui.shared.xtextNature"};
	private static final String[] commonBuilderIDs = {"org.eclipse.xtext.ui.shared.xtextBuilder",};

	public static List<String> getCommonNatureIDs() {
		return Arrays.asList(commonNatureIDs);
	}

	public static List<String> getCommonBuilderIDs() {
		return Arrays.asList(commonBuilderIDs);
	}

	public static IProject createETriceProject(IPath javaSource,
			IPath javaSourceGen, URI projectLocationURI,
			List<IProject> referencedProjects, List<String> naturesToAdd,
			List<String> buildersToAdd, List<IClasspathEntry> pathEntries, Monitor monitor) {
		IProgressMonitor progressMonitor = BasicMonitor
				.toIProgressMonitor(monitor);
		String projectName = javaSource.segment(0);
		IProject project = null;
		try {
			List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();

			progressMonitor.beginTask("", 10);
			progressMonitor.subTask("Creating eTrice project "
					+ projectName
					+ " ("
					+ (projectLocationURI != null ? projectLocationURI
							.toString() : projectName) + ")");
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);

			// Clean up any old project information.
			//
			if (!project.exists()) {
				URI location = projectLocationURI;
				if (location == null) {
					location = URI.createFileURI(workspace.getRoot()
							.getLocation().append(projectName).toOSString());
				}
				location = location.appendSegment(".project");
				File projectFile = new File(location.toString());
				if (projectFile.exists()) {
					projectFile
							.renameTo(new File(location.toString() + ".old"));
				}
			}

			IJavaProject javaProject = JavaCore.create(project);
			IProjectDescription projectDescription = null;
			if (!project.exists()) {
				projectDescription = ResourcesPlugin.getWorkspace()
						.newProjectDescription(projectName);
				if (projectLocationURI != null) {
					projectDescription.setLocationURI(new java.net.URI(
							projectLocationURI.toString()));
				}
				project.create(projectDescription, SubMonitor.convert(progressMonitor, 1));
				project.open(SubMonitor.convert(progressMonitor, 1));
			} else {
				projectDescription = project.getDescription();
				project.open(SubMonitor.convert(progressMonitor, 1));
				if (project.hasNature(JavaCore.NATURE_ID)) {
					classpathEntries.addAll(Arrays.asList(javaProject
							.getRawClasspath()));
				}
			}

			boolean isInitiallyEmpty = classpathEntries.isEmpty();

			{
				if (!referencedProjects.isEmpty()) {
					projectDescription.setReferencedProjects(referencedProjects
							.toArray(new IProject[referencedProjects.size()]));
					for (IProject referencedProject : referencedProjects) {
						IClasspathEntry referencedProjectClasspathEntry = JavaCore
								.newProjectEntry(referencedProject
										.getFullPath());
						classpathEntries.add(referencedProjectClasspathEntry);
					}
				}
			}

			{
				addNatures(projectDescription, naturesToAdd);
				addBuilders(projectDescription, buildersToAdd);

				project.setDescription(projectDescription,
						SubMonitor.convert(progressMonitor, 1));

				createSrcFolder(progressMonitor, project, classpathEntries,
						javaSource);
				createSrcFolder(progressMonitor, project, classpathEntries,
						javaSourceGen);

				if (isInitiallyEmpty) {
					IClasspathEntry jreClasspathEntry = JavaCore
							.newVariableEntry(new Path(
									JavaRuntime.JRELIB_VARIABLE), new Path(
									JavaRuntime.JRESRC_VARIABLE), new Path(
									JavaRuntime.JRESRCROOT_VARIABLE));
					for (Iterator<IClasspathEntry> i = classpathEntries
							.iterator(); i.hasNext();) {
						IClasspathEntry classpathEntry = i.next();
						if (classpathEntry.getPath().isPrefixOf(
								jreClasspathEntry.getPath())) {
							i.remove();
						}
					}

					String jreContainer = JavaRuntime.JRE_CONTAINER;
					jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
					classpathEntries.add(JavaCore.newContainerEntry(new Path(
							jreContainer)));
				}

				for (IClasspathEntry pathEntry : pathEntries) {
					classpathEntries.add(pathEntry);
				}
				
				javaProject.setRawClasspath(classpathEntries
						.toArray(new IClasspathEntry[classpathEntries.size()]),
						SubMonitor.convert(progressMonitor, 1));
			}

			if (isInitiallyEmpty) {
				javaProject.setOutputLocation(
						new Path("/" + javaSource.segment(0) + "/bin"),
						SubMonitor.convert(progressMonitor, 1));
			}

			javaProject.setRawClasspath(classpathEntries
					.toArray(new IClasspathEntry[classpathEntries.size()]),
					SubMonitor.convert(progressMonitor, 1));

			if (isInitiallyEmpty) {
				javaProject.setOutputLocation(
						new Path("/" + javaSource.segment(0) + "/bin"),
						SubMonitor.convert(progressMonitor, 1));
			}

		} catch (Exception e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} finally {
			progressMonitor.done();
		}

		return project;
	}

	/**
	 * @param desc
	 * @param naturesToAdd
	 */
	private static void addNatures(IProjectDescription desc,
			List<String> naturesToAdd) {
		HashSet<String> natures = new HashSet<String>();
		String[] ids = desc.getNatureIds();
		if (ids != null)
			for (String id : ids) {
				natures.add(id);
			}

		natures.addAll(naturesToAdd);

		ids = new String[natures.size()];
		ids = natures.toArray(ids);

		desc.setNatureIds(ids);
	}

	private static void addBuilders(IProjectDescription desc,
			List<String> buildersToAdd) {
		HashMap<String, ICommand> builders = new HashMap<String, ICommand>();
		ICommand[] buildSpecs = desc.getBuildSpec();
		for (ICommand spec : buildSpecs) {
			builders.put(spec.getBuilderName(), spec);
		}
		for (String builder : buildersToAdd) {
			if (!builders.containsKey(builder)) {
				ICommand cmd = desc.newCommand();
				cmd.setBuilderName(builder);
				builders.put(builder, cmd);
			}
		}

		buildSpecs = new ICommand[builders.size()];
		buildSpecs = builders.values().toArray(buildSpecs);

		desc.setBuildSpec(buildSpecs);
	}

	/**
	 * @param progressMonitor
	 * @param project
	 * @param classpathEntries
	 * @param src
	 * @throws CoreException
	 */
	private static void createSrcFolder(IProgressMonitor progressMonitor,
			IProject project, List<IClasspathEntry> classpathEntries, IPath src)
			throws CoreException {
		if (src.segmentCount() > 1) {
			IPath sourceContainerPath = src.removeFirstSegments(1)
					.makeAbsolute();
			IFolder sourceContainer = project.getFolder(sourceContainerPath);
			if (!sourceContainer.exists()) {
				for (int i = sourceContainerPath.segmentCount() - 1; i >= 0; i--) {
					sourceContainer = project.getFolder(sourceContainerPath
							.removeLastSegments(i));
					if (!sourceContainer.exists()) {
						((IFolder) sourceContainer).create(false, true,
								SubMonitor.convert(progressMonitor, 1));
					}
				}
			}

			IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(src);
			for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i
					.hasNext();) {
				IClasspathEntry classpathEntry = i.next();
				if (classpathEntry.getPath().isPrefixOf(src)) {
					i.remove();
				}
			}
			classpathEntries.add(0, sourceClasspathEntry);
		}
	}

	protected static IContainer findOrCreateContainer(IPath path,
			boolean forceRefresh, IPath localLocation,
			IProgressMonitor progressMonitor) throws CoreException {
		String projectName = path.segment(0);
		IProjectDescription projectDescription = ResourcesPlugin.getWorkspace()
				.newProjectDescription(projectName);
		projectDescription.setLocation(localLocation);
		return findOrCreateContainer(path, forceRefresh, projectDescription,
				progressMonitor);
	}

	protected static IContainer findOrCreateContainer(IPath path,
			boolean forceRefresh, IProjectDescription projectDescription,
			IProgressMonitor progressMonitor) throws CoreException {
		try {
			String projectName = path.segment(0);
			progressMonitor.beginTask("", path.segmentCount() + 3);
			progressMonitor.subTask("examine new project " + projectName);
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(path.segment(0));

			if (forceRefresh) {
				project.refreshLocal(IResource.DEPTH_INFINITE, SubMonitor.convert(progressMonitor, 1));
			} else {
				progressMonitor.worked(1);
			}

			if (!project.exists()) {
				project.create(projectDescription, SubMonitor.convert(progressMonitor, 1));
				project.open(SubMonitor.convert(progressMonitor, 1));
			} else {
				project.open(SubMonitor.convert(progressMonitor, 2));
			}

			IContainer container = project;
			for (int i = 1, length = path.segmentCount(); i < length; ++i) {
				IFolder folder = container.getFolder(new Path(path.segment(i)));
				if (!folder.exists()) {
					folder.create(false, true, SubMonitor.convert(progressMonitor, 1));
				} else {
					progressMonitor.worked(1);
				}

				container = folder;
			}

			return container;
		} finally {
			progressMonitor.done();
		}
	}

	public static void createModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicRoomModel(baseName));
	}

	public static void createPhysicalModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicPhysicalModel(baseName));
	}

	public static void createMappingModel(URI uri, String baseName) {
		writeFile(uri, ProjectFileFragments.getBasicMappingModel(baseName));
	}

	public static void createBuildProperties(URI uri, String baseName) {
		try {
			PrintStream prop = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null), false,
					"UTF-8");
			prop.println("source.. = src/,\\");
			prop.println("src-gen/");
			prop.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	public static void createLaunchGeneratorConfig(URI uri, String targetLanguage, String modelPath, String mappingName,
			String mainMethodName, String[] addLines) {
		writeFile(uri, ProjectFileFragments.getGeneratorLaunchConfig(targetLanguage, modelPath, mappingName, mainMethodName, addLines));
	}

	public static void createLaunchJavaApplicationConfig(URI uri,
			String project, String mdlName, String mainClass) {
		writeFile(uri, ProjectFileFragments.getLaunchJavaApplicationConfig(project, mdlName, mainClass));
	}

	public static void createLaunchCApplicationConfig(URI uri, String project) {
		writeFile(uri, ProjectFileFragments.getLaunchCApplicationConfig(project));
	}

	public static void createRunAndLaunchConfigurations(String baseName,
			IProject project, String mdlPath, String mainMethodName,
			String[] additionalLaunchConfigLines) throws CoreException {

		if (project.hasNature(JavaCore.NATURE_ID)) {
			ProjectCreator.createLaunchGeneratorConfig(
					URI.createPlatformResourceURI("/" + project.getName() + "/gen_" + baseName + ".launch", true), "java",
					mdlPath, baseName, mainMethodName, additionalLaunchConfigLines);
			ProjectCreator.createLaunchJavaApplicationConfig(
					URI.createPlatformResourceURI("/" + project.getName() + "/run_" + baseName + ".launch", true),
					project.getName(), baseName, "Node_nodeRef1_mainRunner");
		} else if (project.hasNature("org.eclipse.cdt.core.cnature")) {
			String language = "c";
			
			// C++ projects have _both_ natures, so we also check for this one
			if (project.hasNature("org.eclipse.cdt.core.ccnature"))
				language = "cpp";
			
			ProjectCreator.createLaunchGeneratorConfig(
					URI.createPlatformResourceURI("/" + project.getName() + "/gen_" + baseName + ".launch", true), language,
					mdlPath, baseName, mainMethodName, additionalLaunchConfigLines);
			ProjectCreator.createLaunchCApplicationConfig(
					URI.createPlatformResourceURI("/" + project.getName() + "/run_" + baseName + ".launch", true),
					project.getName());
		}
	}

	public static void createMavenPOM(URI uri, String project, String mdlName, String mainClass) {
		writeFile(uri, ProjectFileFragments.getMavenPOM(project, mdlName, mainClass));
	}

	public static void createMavenBuilder(URI uri, String project) {
		writeFile(uri, ProjectFileFragments.getMavenBuilder(project));
	}

	public static void createMavenLauncher(URI uri, String project, String mdlName) {
		writeFile(uri, ProjectFileFragments.getMavenLauncher(project, mdlName));
	}

	/**
	 * @param project
	 * @param progressMonitor
	 * @throws CoreException
	 */
	public static void addXtextNature(IProject project,
			IProgressMonitor progressMonitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		ProjectCreator.addNatures(description, Collections
				.singletonList("org.eclipse.xtext.ui.shared.xtextNature"));
		ProjectCreator.addBuilders(description, Collections
				.singletonList("org.eclipse.xtext.ui.shared.xtextBuilder"));

		project.setDescription(description, SubMonitor.convert(progressMonitor, 1));
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		ImageDescriptor desc = RoomUiActivator.getDefault().getImageRegistry()
				.getDescriptor(path);
		if (desc == null) {
			desc = RoomUiActivator.imageDescriptorFromPlugin(
					"org.eclipse.etrice.core.room.ui", path);
			if (desc == null)
				System.err.println("image not found: " + path);
			else {
				RoomUiActivator.getDefault().getImageRegistry().put(path, desc);
				RoomUiActivator.getDefault().getImageRegistry().get(path);
			}
		}
		return desc;
	}

	/**
	 * @param uri
	 * @param contents
	 */
	private static void writeFile(URI uri, String contents) {
		try {
			PrintStream model = new PrintStream(URIConverter.INSTANCE.createOutputStream(uri, null), false, "UTF-8");
			model.print(contents);
			model.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}
}
