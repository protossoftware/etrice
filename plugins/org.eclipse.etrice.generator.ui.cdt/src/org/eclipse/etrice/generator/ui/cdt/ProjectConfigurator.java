package org.eclipse.etrice.generator.ui.cdt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.CLibraryFileEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSetting;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.generator.ui.configurator.IProjectConfigurator;

/*
 * Docs:
 * http://cdt-devel-faq.wikidot.com/
 * 
 * CDataUtil.addExcludePaths(entry, paths, removePrefix)
 */
public abstract class ProjectConfigurator implements IProjectConfigurator {
	
	private static boolean traceIncludeIds = false;

	static {
		
		if (Activator.getDefault() != null && Activator.getDefault().isDebugging()) {
			String value = Platform
					.getDebugOption("org.eclipse.etrice.generator.ui.cdt/trace/includeIDs");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceIncludeIds  = true;
			}
		}
	}

	final static String MINGW_TOOLCHAIN = "MinGW GCC";
	final static String POSIX_TOOLCHAIN = "Linux GCC";
	private boolean copyRuntime;
	private String platform;
	private IPath path;

	public ProjectConfigurator() {
	}

	protected abstract boolean isApplicable(IProject project);
	protected abstract boolean isIncludePathId(String id);
	protected abstract List<CIncludePathEntry> getIncludePaths();
	protected abstract Map<String, String> getProjectRefInfo(ICConfigurationDescription configDescription, String toolChain);
	protected abstract void copyRuntime(IProject project, IProgressMonitor progressMonitor, String platform);
	protected abstract void customizeBuildConfig(IProject project, IConfiguration buildConfig);
	
	@Override
	public void configure(IProject project, IPath path, boolean copyRuntime, String platform, IProgressMonitor progressMonitor) {
		this.copyRuntime = copyRuntime;
		this.platform = platform;
		this.path = path;
		
		try {
			if (isApplicable(project)) {
				if (copyRuntime) {
					copyRuntime(project, progressMonitor, platform);
				}
				
				configureIncludesAndLibraries(project, progressMonitor);
			}
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the path
	 */
	protected IPath getPath() {
		return path;
	}

	/**
	 * @return the platform
	 */
	protected String getPlatform() {
		return platform;
	}

	/**
	 * @return the copyRuntime
	 */
	protected boolean isCopyRuntime() {
		return copyRuntime;
	}

	protected void configureIncludesAndLibraries(IProject project, IProgressMonitor progressMonitor) throws CoreException {
		if (traceIncludeIds) {
			System.out.println("org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator.configureIncludesAndLibraries(IProject, IProgressMonitor)");
		}
		
		ICProjectDescription projectDescription = CoreModel.getDefault().getProjectDescription(project, true);
		
		// it is not necessary to actually create this folder here
//		srcGenInfoFolder.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		
		// all build configurations e.g. Debug, Release
		for (ICConfigurationDescription configDescription : projectDescription.getConfigurations()) {
			if (configDescription.getId() == null)
				continue;
			
			IConfiguration buildConfig = ManagedBuildManager.getConfigurationForDescription(configDescription);
			String toolChain = "";
			String toolChainName = buildConfig.getToolChain().getName();
			if (MINGW_TOOLCHAIN.equals(toolChainName))
				toolChain = MINGW_TOOLCHAIN;
			else if (POSIX_TOOLCHAIN.equals(toolChainName))
				toolChain = POSIX_TOOLCHAIN;

			customizeBuildConfig(project, buildConfig);
			
			// set project references
			/*
			 * HOWTO: Find out reference project configuration: Use GUI "Reference" tab
			 * at "Path and Symbols" and set breakpoint at {@link
			 * org.eclipse.cdt.internal.core.settings.model.CConfigurationDescription#setReferenceInfo(Map)}
			 * 
			 * Add referenced projects in reverse library order
			 */
			configDescription.setReferenceInfo(getProjectRefInfo(configDescription, toolChain));

			// setting for compiler, linker, assembler (see id)
			for (ICLanguageSetting setting : configDescription.getRootFolderDescription().getLanguageSettings()) {
				if (setting.getId() == null)
					continue;
				
				if (traceIncludeIds) {
					System.out.println("  config '"+buildConfig.getName()+"', toolchain '"+toolChainName+"', settingID '"+setting.getId()+"'");
				}
				
				// set source includes
				if (isIncludePathId(setting.getId())) {
					addSettings(setting, ICSettingEntry.INCLUDE_PATH, getIncludePaths());
				}

				// set additional libraries (order!)
				if (setting.getId().startsWith("cdt.managedbuild.tool.gnu.c.linker")) {
					List<CLibraryFileEntry> libraries = new ArrayList<CLibraryFileEntry>();
					if (toolChain == POSIX_TOOLCHAIN) {
						libraries.add(new CLibraryFileEntry("pthread", ICSettingEntry.LOCAL));
						libraries.add(new CLibraryFileEntry("rt", ICSettingEntry.LOCAL));
					}
					else if(toolChain == MINGW_TOOLCHAIN){
						libraries.add(new CLibraryFileEntry("ws2_32", ICSettingEntry.LOCAL));
					}
					addSettings(setting, ICSettingEntry.LIBRARY_FILE, libraries);
				}
			}
		}

		CoreModel.getDefault().setProjectDescription(project, projectDescription);
	}

	/**
	 *  Appends entries at the end, preserves order, prevents new duplicates.
	 */
	private void addSettings(ICLanguageSetting setting, int kind, List<? extends ICLanguageSettingEntry> newEntries){
		Set<String> valueSet = new HashSet<String>();
		for (ICLanguageSettingEntry entry : setting.getSettingEntriesList(kind))
			valueSet.add(entry.getValue());
		
		List<ICLanguageSettingEntry> allEntries = new ArrayList<ICLanguageSettingEntry>();
		for (ICLanguageSettingEntry entry : setting.getSettingEntriesList(kind))
			allEntries.add(entry);
		for (ICLanguageSettingEntry entry : newEntries){
			if(!valueSet.contains(entry.getValue()))
				allEntries.add(entry);
		}
			
		setting.setSettingEntries(kind, allEntries);
	}

}
