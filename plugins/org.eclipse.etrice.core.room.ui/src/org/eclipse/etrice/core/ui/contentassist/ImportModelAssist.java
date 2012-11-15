package org.eclipse.etrice.core.ui.contentassist;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

public class ImportModelAssist {

	public static void addPaths(final AbstractContentProposalProvider provider, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor, final String extension) {
		final IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
				.getFullPath();
		URI configURI = context.getRootModel().eResource().getURI();
		final IPath configPath = new Path(configURI.toPlatformString(false)
				.replace(configURI.lastSegment(), ""));
		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {

			@Override
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getType() != IResource.FILE)
					return true;

				String name = proxy.getName();
				if (name.endsWith(extension)) {
					IPath relConfigPath = proxy.requestFullPath()
							.makeRelativeTo(configPath);
					IPath relWorkspacePath = proxy.requestFullPath()
							.makeRelativeTo(rootPath);
					String proposal = "\"" + relConfigPath.toString() + "\"";
					String displayString = relConfigPath.lastSegment() + " - "
							+ relWorkspacePath;
					acceptor.accept(provider.createCompletionProposal(proposal,
							new StyledString(displayString), null, context));
				}
				return false;
			}
		};
		try {
			ResourcesPlugin.getWorkspace().getRoot()
					.accept(visitor, IResource.NONE);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
