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

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.etrice.core.common.ui.modelpath.ModelPathManager;
import org.eclipse.etrice.core.common.ui.modelpath.WorkspaceModelPath;
import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.io.ILineOutput;
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

import com.google.common.collect.Lists;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public abstract class GeneratorLaunchConfigurationDelegate extends AbstractJavaLaunchConfigurationDelegate{
	
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
			
			List<String> models = getModels(configuration);
			Map<IProject, List<String>> project2Models = GeneratorLaunchHelper.groupByProject(models);
			for(Entry<IProject, List<String>> entry: project2Models.entrySet()) {
				
				// constructing program arguments
				StringBuffer argString = new StringBuffer();
				addModels(configuration, entry.getKey(), entry.getValue(), argString);
				addArguments(configuration, entry.getKey(), argString);
				addModelpath(entry.getKey(), argString);
				String[] args = splitCommandLine(argString.toString());
				
				output.println("\n*** generating project " + entry.getKey().getName() + " ***\n");
				runGenerator(args, output);
				
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

	protected void addModels(ILaunchConfiguration configuration, IProject project, Iterable<String> models, StringBuffer argString) throws CoreException {
		if(configuration.getAttribute(GeneratorConfigTab.GEN_DEPS_WITHIN_PROJECT, true)) {
			// generate all dependencies within project
			models = GeneratorLaunchHelper.getAllDependenciesWithinProject(project, models);
		}
		for(String model : models) {
			argString.append(" \""+model+"\"");
		}		
	}
	
	@SuppressWarnings("unchecked")
	protected List<String> getModels(ILaunchConfiguration configuration) throws CoreException {
		IStringVariableManager variableManager = VariablesPlugin.getDefault().getStringVariableManager();
		List<String> models = configuration.getAttribute("ModelFiles", Collections.EMPTY_LIST);
		List<String> substitutedModels = Lists.newArrayList();
		for(String model : models) {
			substitutedModels.add(variableManager.performStringSubstitution(model));
		}
		return substitutedModels;
	}
	
	/**
	 * assemble the command line by adding further parameters
	 * 
	 * @param configuration
	 * @param argString
	 * @throws CoreException
	 */
	protected void addArguments(ILaunchConfiguration configuration, IProject project, StringBuffer argString) throws CoreException {
		String projectDir = project.getLocation().toString() + "/";
		if (configuration.getAttribute(GeneratorConfigTab.LIB, false)) {
			argString.append(" -"+AbstractGeneratorOptions.LIB.getName());
		}
		if (configuration.getAttribute(GeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			String genModelPath = configuration.getAttribute(GeneratorConfigTab.GEN_MODEL_PATH, "?");
			argString.append(" -"+AbstractGeneratorOptions.SAVE_GEN_MODEL.getName());
			argString.append(" "+projectDir + genModelPath);
		}
		if (!configuration.getAttribute(GeneratorConfigTab.MAIN_METHOD_NAME, AbstractGeneratorOptions.MAIN_NAME.getDefaultValue()).equals(AbstractGeneratorOptions.MAIN_NAME.getDefaultValue())) {
			argString.append(" -"+AbstractGeneratorOptions.MAIN_NAME.getName());
			argString.append(" "+configuration.getAttribute(GeneratorConfigTab.MAIN_METHOD_NAME, AbstractGeneratorOptions.MAIN_NAME.getDefaultValue()));
		}
		if (configuration.getAttribute(GeneratorConfigTab.DEBUG, false)) {
			argString.append(" -"+GeneratorApplicationOptions.LOGLEVEL.getName());
			argString.append(" debug");
		}
		if (configuration.getAttribute(GeneratorConfigTab.MSC_INSTR, false)) {
			argString.append(" -"+AbstractGeneratorOptions.MSC_INSTR.getName());
		}
		if (configuration.getAttribute(GeneratorConfigTab.VERBOSE, false)) {
			argString.append(" -"+AbstractGeneratorOptions.VERBOSE_RT.getName());
		}
		if (!configuration.getAttribute(GeneratorConfigTab.USE_TRAANSLATION, true)) {
			argString.append(" -"+AbstractGeneratorOptions.NOTRANSLATE.getName());
		}
		if (!configuration.getAttribute(GeneratorConfigTab.OLD_STYLE_TRANSITION_DATA, true)) {
			argString.append(" -"+AbstractGeneratorOptions.OLD_STYLE_TRANSITION_DATA.getName());
		}
		
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		
		boolean override = configuration.getAttribute(GeneratorConfigTab.OVERRIDE_DIRECTORIES, false);
		String srcgenDir = prefStore.getString(PreferenceConstants.GEN_DIR);
		if (override) {
			srcgenDir = configuration.getAttribute(GeneratorConfigTab.SRCGEN_PATH, srcgenDir);
		}

		argString.append(" -"+GeneratorApplicationOptions.GEN_DIR.getName());
		argString.append(" \""+projectDir+srcgenDir+"\"");
		
		argString.append(" -clean");
	}
	
	/**
	 * Parses the modelpath of the specified project and appends it to the generator arguments.
	 */
	protected void addModelpath(IProject project, StringBuffer argString) throws CoreException {
		WorkspaceModelPath modelpath = ModelPathManager.INSTANCE.getModelPath(project);
		String[] paths = modelpath.getPaths().stream()
			.map(container -> container.getLocation())
			.filter(Objects::nonNull)
			.map(path -> path.toOSString())
			.toArray(size -> new String[size]);
		
		if(paths.length > 0) {
			String modelpathArg = String.join(File.pathSeparator, paths);
			argString.append(" -modelpath \"").append(modelpathArg).append('"');
		}
	}
	
	/**
	 *  split at single spaces but keep strings in double quotes as single argument
	 *  (with double quotes removed)
	 */
	protected String[] splitCommandLine(String cl) {
		cl = cl.trim();
		ArrayList<String> res = new ArrayList<String>();
		int begin = 0;
		int end = cl.indexOf(' ');
		boolean inQuotes = false;
		while (end>0) {
			if (cl.charAt(begin)=='\"')
				inQuotes = true;
			if ((inQuotes && cl.charAt(end-1)=='\"')) {
				inQuotes = false;
			}
			
			if (!inQuotes) {
				res.add(cl.substring(begin, end).replace("\"", ""));
				begin = end+1;
			}
			end = cl.indexOf(' ', end+1);
		}
		res.add(cl.substring(begin).replace("\"", ""));
		
		String[] args = new String[res.size()];
		return res.toArray(args);
	}
	
	/**
	 * call the generator main method
	 * 
	 * @param args the command line arguments
	 * @param out line wise output to console
	 */
	protected abstract void runGenerator(String[] args, ILineOutput out);
	
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
