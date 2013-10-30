package org.eclipse.etrice.generator.ui.cdt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.CLibraryFileEntry;
import org.eclipse.cdt.core.settings.model.CLibraryPathEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICFolderDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSetting;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.core.settings.model.ICTargetPlatformSetting;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.etrice.generator.ui.configurator.IProjectConfigurator;

public class ProjectConfigurator implements IProjectConfigurator {

	public ProjectConfigurator() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.configurator.IProjectConfigurator#configure(org.eclipse.etrice.generator.ui.configurator.IProject)
	 */
	@Override
	public void configure(IProject project) {
		try {
			addIncludePathsAndLibraries(project);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static void addIncludePathsAndLibraries(IProject project)
			throws CoreException {
		if (!project.hasNature("org.eclipse.cdt.core.cnature"))
			return;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject runtime = workspace.getRoot().getProject(
				"org.eclipse.etrice.runtime.c");
		IFolder common = runtime.getFolder("src/common");
		IFolder config = runtime.getFolder("src/config");
		IFolder posix = runtime.getFolder("src/platforms/MT_POSIX_GENERIC_GCC");
		IFolder mingw = runtime.getFolder("src/platforms/MT_WIN_MinGW");
		IFolder src_gen = project.getFolder("src-gen");
		IFolder mingw_debug = project.getFolder("MinGWDebug");
		IFolder mingw_release = project.getFolder("MinGWRelease");
		IFolder posix_debug = project.getFolder("PosixDebug");
		IFolder posix_release = project.getFolder("PosixRelease");

		ICProjectDescription projectDescription = CoreModel.getDefault()
				.getProjectDescription(project, true);
		ICConfigurationDescription configDecriptions[] = projectDescription
				.getConfigurations();

		for (ICConfigurationDescription configDescription : configDecriptions) {
			ICFolderDescription projectRoot = configDescription
					.getRootFolderDescription();
			ICLanguageSetting[] settings = projectRoot.getLanguageSettings();
			for (ICLanguageSetting setting : settings) {
				if (!"org.eclipse.cdt.core.gcc".equals(setting.getLanguageId())) {
					continue;
				}

				ICTargetPlatformSetting tgt = configDescription
						.getTargetPlatformSetting();
				String id = tgt.getId();

				ArrayList<ICLanguageSettingEntry> includes = new ArrayList<ICLanguageSettingEntry>();
				includes.add(new CIncludePathEntry(src_gen,
						ICSettingEntry.LOCAL));
				includes.add(new CIncludePathEntry(common, ICSettingEntry.LOCAL));
				includes.add(new CIncludePathEntry(config, ICSettingEntry.LOCAL));
				if (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe")) {
					includes.add(new CIncludePathEntry(mingw,
							ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe")) {
					includes.add(new CIncludePathEntry(posix,
							ICSettingEntry.LOCAL));
				}
				addSettings(setting, ICSettingEntry.INCLUDE_PATH, includes);

				List<? extends ICLanguageSettingEntry> libPaths = null;
				if (id.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.debug")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							mingw_debug, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.mingw.exe.release")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							mingw_release, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.debug")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							posix_debug, ICSettingEntry.LOCAL));
				} else if (id
						.startsWith("cdt.managedbuild.target.gnu.platform.posix.exe.release")) {
					libPaths = Collections.singletonList(new CLibraryPathEntry(
							posix_release, ICSettingEntry.LOCAL));
				}
				if (libPaths != null)
					addSettings(setting, ICSettingEntry.LIBRARY_PATH, libPaths);

				List<? extends ICLanguageSettingEntry> libs = Collections
						.singletonList(new CLibraryFileEntry(
								"org.eclipse.etrice.runtime.c", 0));
				addSettings(setting, ICSettingEntry.LIBRARY_FILE, libs);
			}
		}
		try {
			CoreModel.getDefault().setProjectDescription(project,
					projectDescription);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private static void addSettings(ICLanguageSetting setting, int kind,
			List<? extends ICLanguageSettingEntry> entries) {
		HashMap<String, ICLanguageSettingEntry> newEntries = new HashMap<String, ICLanguageSettingEntry>();
		for (ICLanguageSettingEntry entry : setting.getSettingEntriesList(kind)) {
			newEntries.put(entry.getName(), entry);
		}
		for (ICLanguageSettingEntry entry : entries) {
			newEntries.put(entry.getName(), entry);
		}
		setting.setSettingEntries(kind, new ArrayList<ICLanguageSettingEntry>(
				newEntries.values()));
	}

}
