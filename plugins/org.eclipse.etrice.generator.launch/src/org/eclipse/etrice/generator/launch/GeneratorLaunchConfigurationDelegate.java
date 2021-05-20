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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.GeneratorApplication;
import org.eclipse.etrice.generator.base.GeneratorException;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.Loglevel;
import org.eclipse.etrice.generator.base.setup.GeneratorApplicationOptions;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.jdt.launching.AbstractJavaLaunchConfigurationDelegate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import com.google.inject.Module;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public abstract class GeneratorLaunchConfigurationDelegate extends AbstractJavaLaunchConfigurationDelegate{
	
	private GeneratorLaunchHelper helper = new GeneratorLaunchHelper();
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		monitor.beginTask(configuration.getName()+"...", 3); //$NON-NLS-1$
		
		if (monitor.isCanceled()) {
			return;
		}
		try {
			ConsoleOutput output = getConsoleOutput();
			
			GeneratorApplication genAppl = GeneratorApplication.create(createGeneratorModule());
			// group files by project and generate separately for every project
			Map<IProject, List<IFile>> models = getFiles(configuration);
			for(Entry<IProject, List<IFile>> entry: models.entrySet()) {
				// load resources
				boolean includeDependencies = configuration.getAttribute(GeneratorConfigTab.GEN_DEPS_WITHIN_PROJECT, true);
				List<Resource> resources = helper.loadResources(entry.getKey(), entry.getValue(), includeDependencies);
				
				// construct program arguments
				Arguments args = genAppl.createArguments();
				configureArguments(args, configuration, entry.getKey());
				
				// generate project
				output.println("\n*** generating project " + entry.getKey().getName() + " ***\n");
				try {
					genAppl.run(resources, args, output);
				} catch(GeneratorException e) {
					break; // error is logged to console
				}
				
				// check for cancellation
				if (monitor.isCanceled()) {
					return;
				}
			}
		} finally {
			monitor.done();
		}
		
		launchRefreshJob(configuration);
	}

	private void launchRefreshJob(final ILaunchConfiguration configuration) {
		Job job = new Job("refresh resources after code generation") {
			public IStatus run(IProgressMonitor monitor) {
				try {
					RefreshTab.refreshResources(configuration, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					return e.getStatus();
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
	
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
	
	protected ConsoleOutput getConsoleOutput() {
		final MessageConsole myConsole = findConsole(getConsoleName());
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					IWorkbench wb = PlatformUI.getWorkbench();
					IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
					IWorkbenchPage page = win.getActivePage();
					String id = IConsoleConstants.ID_CONSOLE_VIEW;
					IConsoleView view = (IConsoleView) page.showView(id);
					view.display(myConsole);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
		MessageConsoleStream out = myConsole.newMessageStream();
		out.getConsole().clearConsole();
		return new ConsoleOutput(out);
	}

	/**
	 * Locates files in the workspace and groups them by project.
	 * 
	 * @param configuration the launch configuration to load the files from
	 * @return the files grouped by project
	 * @throws CoreException if there is an error when locating the files in the workspace
	 */
	protected Map<IProject, List<IFile>> getFiles(ILaunchConfiguration configuration) throws CoreException {
		IStringVariableManager variableManager = VariablesPlugin.getDefault().getStringVariableManager();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		@SuppressWarnings("unchecked")
		List<String> models = configuration.getAttribute("ModelFiles", Collections.EMPTY_LIST);
		List<IFile> files = new ArrayList<>();
		for(String model : models) {
			String substituted = variableManager.performStringSubstitution(model);
			IFile file = root.getFileForLocation(new Path(substituted));
			if(file == null || !file.exists())
				throw new CoreException(new Status(Status.ERROR, getClass().getName(),
					"Failed to find file in workspace: " + substituted));
			files.add(file);
		}
		
		return files.stream().collect(Collectors.groupingBy(IFile::getProject));
	}
	
	protected void configureArguments(Arguments args, ILaunchConfiguration configuration, IProject project) throws CoreException {
		String projectDir = project.getLocation().toString() + "/";
		boolean lib = configuration.getAttribute(GeneratorConfigTab.LIB, false);
		args.set(AbstractGeneratorOptions.LIB, lib);
		if (configuration.getAttribute(GeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			String genModelPath = configuration.getAttribute(GeneratorConfigTab.GEN_MODEL_PATH, "?");
			args.set(AbstractGeneratorOptions.SAVE_GEN_MODEL, projectDir + genModelPath);
		}
		String mainName = configuration.getAttribute(GeneratorConfigTab.MAIN_METHOD_NAME, AbstractGeneratorOptions.MAIN_NAME.getDefaultValue());
		args.set(AbstractGeneratorOptions.MAIN_NAME, mainName);
		if (configuration.getAttribute(GeneratorConfigTab.DEBUG, false)) {
			args.set(GeneratorApplicationOptions.LOGLEVEL, Loglevel.DEBUG);
		}
		boolean mscInstr = configuration.getAttribute(GeneratorConfigTab.MSC_INSTR, false);
		args.set(AbstractGeneratorOptions.MSC_INSTR, mscInstr);
		boolean verbose = configuration.getAttribute(GeneratorConfigTab.VERBOSE, false);
		args.set(AbstractGeneratorOptions.VERBOSE_RT, verbose);
		boolean notranslate = !configuration.getAttribute(GeneratorConfigTab.USE_TRAANSLATION, true);
		args.set(AbstractGeneratorOptions.NOTRANSLATE, notranslate);
		boolean oldStyleTransitionData = configuration.getAttribute(GeneratorConfigTab.OLD_STYLE_TRANSITION_DATA, false);
		args.set(AbstractGeneratorOptions.OLD_STYLE_TRANSITION_DATA, oldStyleTransitionData);
		
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		boolean override = configuration.getAttribute(GeneratorConfigTab.OVERRIDE_DIRECTORIES, false);
		String srcgenDir = prefStore.getString(getSrcgenDirPreferenceConstantName());
		if (override) {
			srcgenDir = configuration.getAttribute(GeneratorConfigTab.SRCGEN_PATH, srcgenDir);
		}
		args.set(GeneratorApplicationOptions.GEN_DIR, projectDir + srcgenDir);
		args.set(GeneratorApplicationOptions.CLEAN, true);
	}
	
	protected String getSrcgenDirPreferenceConstantName() {
		return PreferenceConstants.GEN_DIR;
	}
	
	/**
	 * @return the guice module of the generator
	 */
	protected abstract Module createGeneratorModule();
	
	/**
	 * @return the name of the console for the generator output
	 */
	protected abstract String getConsoleName();
	
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		// never build before launch
		return false;
	}
}
