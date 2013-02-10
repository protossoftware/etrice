package org.eclipse.etrice.generator.base;

import java.util.Collection;

/**
 * A {@link IFileFilter} that lets files pass whose paths start
 * with one of the given folder paths. In other words, files that
 * reside in one of the specified folders.
 * 
 * @author Henrik Rentz-Reichert
 */
public class FolderFilter implements IFileFilter {

	private Collection<String> folders;
	
	/**
	 * @param folders a list of folder paths
	 */
	public FolderFilter(Collection<String> folders) {
		this.folders = folders;
	}
	
	/**
	 * see the description in {@link FolderFilter}
	 * @see org.eclipse.etrice.generator.base.IFileFilter#accept(java.lang.String)
	 */
	@Override
	public boolean accept(String fname) {
		for (String folder : folders) {
			if (fname.startsWith(folder))
				return true;
		}
		return false;
	}
	
}