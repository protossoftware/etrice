package org.eclipse.etrice.core.ui.quickfix;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class QuickfixExtensionManager {

	private static final String IQUICKFIX_ID = "org.eclipse.etrice.core.room.ui.quickfix";
	private static QuickfixExtensionManager instance = null;

	private HashMap<String, ArrayList<IRoomQuickfixProvider>> code2provider = new HashMap<String, ArrayList<IRoomQuickfixProvider>>();
	
	public static QuickfixExtensionManager getInstance() {
		if (instance==null)
			instance = new QuickfixExtensionManager();
		return instance;
	}
	
	public void loadQuickfixExtensions() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IQUICKFIX_ID);

		try {
			for (IConfigurationElement e : config) {
				final Object ext = e.createExecutableExtension("class");
				if (ext instanceof IRoomQuickfixProvider) {
					String code = e.getAttribute("code");
					put(code, (IRoomQuickfixProvider) ext);
				}
				else {
					System.out.println("QuickfixExtensionManager: unexpected extension");
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void getResolutions(Issue issue, IssueResolutionAcceptor acceptor) {
		ArrayList<IRoomQuickfixProvider> list = code2provider.get(issue.getCode());
		if (list!=null)
			for (IRoomQuickfixProvider provider : list) {
				executeExtension(provider, issue, acceptor);
			}
	}

	public boolean hasResolutionFor(String issueCode) {
		ArrayList<IRoomQuickfixProvider> list = code2provider.get(issueCode);
		return list!=null && !list.isEmpty();
	}
	
	private void executeExtension(
			final IRoomQuickfixProvider provider,
			final Issue issue,
			final IssueResolutionAcceptor acceptor) {
		
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable exception) {
				System.out.println("Exception in IRoomValidator");
			}

			@Override
			public void run() throws Exception {
				provider.getResolution(issue, acceptor);
			}
		};
		SafeRunner.run(runnable);
	}
	
	private void put(String code, IRoomQuickfixProvider ext) {
		ArrayList<IRoomQuickfixProvider> list = code2provider.get(code);
		if (list==null) {
			list = new ArrayList<IRoomQuickfixProvider>();
			code2provider.put(code, list);
		}
		list.add(ext);
	}
	
}
