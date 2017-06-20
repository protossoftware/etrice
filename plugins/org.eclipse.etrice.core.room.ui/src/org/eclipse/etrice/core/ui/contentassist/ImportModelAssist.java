package org.eclipse.etrice.core.ui.contentassist;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.base.util.RelativePathHelpers;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;

public class ImportModelAssist {
		
	public static void addPaths(final AbstractContentProposalProvider provider, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor, final String extension) {
		final IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getFullPath();
		
		// toPlatformString(true) to support whitespace & special characters
		IPath modelPath = new Path(context.getRootModel().eResource().getURI().toPlatformString(true));
		modelPath = ResourcesPlugin.getWorkspace().getRoot().getFile(modelPath).getLocation();		
		final URI modelURI = URI.createFileURI(modelPath.toOSString()).trimSegments(1);
		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {

			@Override
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getType() != IResource.FILE)
					return true;

				if (proxy.getName().endsWith(extension)) {
					IPath relModelPath = proxy.requestFullPath();
					relModelPath = ResourcesPlugin.getWorkspace().getRoot().getFile(relModelPath).getLocation();
					URI relURI = URI.createFileURI(relModelPath.toOSString());
					String relPath = RelativePathHelpers.getRelativePath(modelURI, relURI, true);
					if (relPath==null)
						relPath = "file:/"+(relURI.toFileString().replaceAll("\\\\", "/"));
					IPath relWorkspacePath = proxy.requestFullPath().makeRelativeTo(rootPath);
					String proposalString = "\"" + relPath + "\"";
					String displayString = relModelPath.lastSegment() + " - " + relWorkspacePath;
					
					ICompletionProposal proposal = provider.createCompletionProposal(proposalString,
							new StyledString(displayString), null, context);
					if(proposal instanceof ConfigurableCompletionProposal) {
						ConfigurableCompletionProposal cfgProposal = (ConfigurableCompletionProposal) proposal;
						cfgProposal.setAutoInsertable(false);
						cfgProposal.setMatcher(new ImportPrefixMatcher());
					}
					
					acceptor.accept(proposal);
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
	
	private static class ImportPrefixMatcher extends PrefixMatcher {

		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			String[] segments = name.split("/");
			String last = (segments.length > 0) ? segments[segments.length-1]: "";
			
			return last.replace("\"", "").toLowerCase().startsWith(prefix.replace("\"", "").toLowerCase());
		}
		
	}

}
