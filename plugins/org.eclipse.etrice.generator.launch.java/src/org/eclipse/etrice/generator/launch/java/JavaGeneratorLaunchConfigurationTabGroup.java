package org.eclipse.etrice.generator.launch.java;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.etrice.generator.launch.GeneratorRefreshTab;

public class JavaGeneratorLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new JavaGeneratorMainTab(),
				new JavaGeneratorConfigTab(),
				new GeneratorRefreshTab(),
				new EnvironmentTab(),
				new CommonTab()
			};
		setTabs(tabs);
	}

}
