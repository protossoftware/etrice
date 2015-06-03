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
import org.eclipse.etrice.generator.ui.configurator.IProjectConfigurator;

/*
 * Docs:
 * http://cdt-devel-faq.wikidot.com/
 * 
 * CDataUtil.addExcludePaths(entry, paths, removePrefix)
 */
public class ProjectConfigurator implements IProjectConfigurator {

	final static String MINGW_TOOLCHAIN = "MinGW GCC";
	final static String POSIX_TOOLCHAIN = "Linux GCC";

	public ProjectConfigurator() {
	}

	@Override
	public void configure(IProject project) {
		try {
			if (!CoreModel.hasCNature(project))
				return;
			
			configureIncludesAndLibraries(project);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void configureIncludesAndLibraries(IProject project) throws CoreException {
		
		List<CIncludePathEntry> srcIncludes = new ArrayList<CIncludePathEntry>();
		srcIncludes.add(new CIncludePathEntry("/${ProjName}/src-gen", ICSettingEntry.LOCAL));

		List<CLibraryFileEntry> posixLibraries = new ArrayList<CLibraryFileEntry>();
		posixLibraries.add(new CLibraryFileEntry("pthread", ICSettingEntry.LOCAL));
		posixLibraries.add(new CLibraryFileEntry("rt", ICSettingEntry.LOCAL));
		
		List<CLibraryFileEntry> mingwLibraries = new ArrayList<CLibraryFileEntry>();
		mingwLibraries.add(new CLibraryFileEntry("ws2_32", ICSettingEntry.LOCAL));

		ICProjectDescription projectDescription = CoreModel.getDefault().getProjectDescription(project, true);
		// all build configurations e.g. Debug, Release
		for (ICConfigurationDescription configDescription : projectDescription.getConfigurations()) {
			if (configDescription.getId() == null)
				continue;

			IConfiguration buildConfig = ManagedBuildManager.getConfigurationForDescription(configDescription);
			String toolChain = "";
			if (MINGW_TOOLCHAIN.equals(buildConfig.getToolChain().getName()))
				toolChain = MINGW_TOOLCHAIN;
			else if (POSIX_TOOLCHAIN.equals(buildConfig.getToolChain().getName()))
				toolChain = POSIX_TOOLCHAIN;
			// set project references
			/*
			 * HOWTO: Find out reference project configuration: Use GUI "Reference" tab
			 * at "Path and Symbols" and set breakpoint at {@link
			 * org.eclipse.cdt.internal.core.settings.model.CConfigurationDescription#setReferenceInfo(Map)}
			 */
			if (toolChain == MINGW_TOOLCHAIN) {
				Map<String, String> projectRefInfo = configDescription.getReferenceInfo();
				projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919");
				projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798");
				configDescription.setReferenceInfo(projectRefInfo);
			}
			else if (toolChain == POSIX_TOOLCHAIN) {
				Map<String, String> projectRefInfo = configDescription.getReferenceInfo();
				projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919.294295052");
				projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798.58778989");
				configDescription.setReferenceInfo(projectRefInfo);
			}

			// setting for compiler, linker, assembler (see id)
			for (ICLanguageSetting setting : configDescription.getRootFolderDescription().getLanguageSettings()) {
				if(setting.getId() == null)
					continue;
				
				// set source includes
				if (setting.getId().startsWith("cdt.managedbuild.tool.gnu.c.compiler"))
					addSettings(setting, ICSettingEntry.INCLUDE_PATH, srcIncludes);

				// set additional libraries (order!)
				if (toolChain == POSIX_TOOLCHAIN) {
					if (setting.getId().startsWith("cdt.managedbuild.tool.gnu.c.linker"))
						addSettings(setting, ICSettingEntry.LIBRARY_FILE, posixLibraries);
				}
				if(toolChain == MINGW_TOOLCHAIN){
					if (setting.getId().startsWith("cdt.managedbuild.tool.gnu.c.linker"))
						addSettings(setting, ICSettingEntry.LIBRARY_FILE, mingwLibraries);
				}
			}
		}

		CoreModel.getDefault().setProjectDescription(project, projectDescription);
	}

	// public static void addIncludePathsAndLibraries(IProject project)
	// throws CoreException {
	// if (!project.hasNature("org.eclipse.cdt.core.cnature"))
	// return;
	//
	// IWorkspace workspace = ResourcesPlugin.getWorkspace();
	// IProject runtime = workspace.getRoot().getProject(
	// "org.eclipse.etrice.runtime.c");
	// IFolder common = runtime.getFolder("src/common");
	// IFolder config = runtime.getFolder("src/config");
	// IFolder posix = runtime.getFolder("src/platforms/MT_POSIX_GENERIC_GCC");
	// IFolder mingw = runtime.getFolder("src/platforms/MT_WIN_MinGW");
	// IFolder src_gen = project.getFolder("src-gen");
	// IFolder mingw_debug = project.getFolder("MinGWDebug");
	// IFolder mingw_release = project.getFolder("MinGWRelease");
	// IFolder posix_debug = project.getFolder("PosixDebug");
	// IFolder posix_release = project.getFolder("PosixRelease");
	//
	// ICProjectDescription projectDescription = CoreModel.getDefault()
	// .getProjectDescription(project, true);
	// ICConfigurationDescription configDecriptions[] = projectDescription
	// .getConfigurations();
	//
	// for (ICConfigurationDescription configDescription : configDecriptions) {
	// ICFolderDescription projectRoot = configDescription
	// .getRootFolderDescription();
	// ICLanguageSetting[] settings = projectRoot.getLanguageSettings();
	// for (ICLanguageSetting setting : settings) {
	// if (!"org.eclipse.cdt.core.gcc".equals(setting.getLanguageId())) {
	// continue;
	// }
	//
	// ICTargetPlatformSetting tgt = configDescription
	// .getTargetPlatformSetting();
	// String id = tgt.getId();
	//
	// ArrayList<ICLanguageSettingEntry> includes = new
	// ArrayList<ICLanguageSettingEntry>();
	// includes.add(new CIncludePathEntry(src_gen,
	// ICSettingEntry.LOCAL));
	// includes.add(new CIncludePathEntry(common, ICSettingEntry.LOCAL));
	// includes.add(new CIncludePathEntry(config, ICSettingEntry.LOCAL));
	// if (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe")) {
	// includes.add(new CIncludePathEntry(mingw,
	// ICSettingEntry.LOCAL));
	// } else if (id
	// .startsWith("cdt.managedbuild.target.gnu.platform.posix.exe")) {
	// includes.add(new CIncludePathEntry(posix,
	// ICSettingEntry.LOCAL));
	// }
	// addSettings(setting, ICSettingEntry.INCLUDE_PATH, includes);
	//
	// List<? extends ICLanguageSettingEntry> libPaths = null;
	// if
	// (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.debug")) {
	// libPaths = Collections.singletonList(new CLibraryPathEntry(
	// mingw_debug, ICSettingEntry.LOCAL));
	// } else if (id
	// .startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.release")) {
	// libPaths = Collections.singletonList(new CLibraryPathEntry(
	// mingw_release, ICSettingEntry.LOCAL));
	// } else if (id
	// .startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.debug")) {
	// libPaths = Collections.singletonList(new CLibraryPathEntry(
	// posix_debug, ICSettingEntry.LOCAL));
	// } else if (id
	// .startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.release")) {
	// libPaths = Collections.singletonList(new CLibraryPathEntry(
	// posix_release, ICSettingEntry.LOCAL));
	// }
	// if (libPaths != null)
	// addSettings(setting, ICSettingEntry.LIBRARY_PATH, libPaths);
	//
	// List<? extends ICLanguageSettingEntry> libs = Collections
	// .singletonList(new CLibraryFileEntry(
	// "org.eclipse.etrice.runtime.c", 0));
	// addSettings(setting, ICSettingEntry.LIBRARY_FILE, libs);
	// }
	// }
	// try {
	// CoreModel.getDefault().setProjectDescription(project,
	// projectDescription);
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	// }
	
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
